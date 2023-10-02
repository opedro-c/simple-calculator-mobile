package br.ufrn.calculadora.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.ufrn.calculadora.R;
import br.ufrn.calculadora.business.GradeCalculator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGradeCalculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGradeCalculator extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentGradeCalculator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentGradeCalculator.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentGradeCalculator newInstance(String param1, String param2) {
        FragmentGradeCalculator fragment = new FragmentGradeCalculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grade_calculator, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button calculateAverage = (Button) view.findViewById(R.id.button_calculate_average);
        calculateAverage.setOnClickListener(view1 -> getAverage(view));
    }

    public void getAverage(View view) {

        EditText grade1 = (EditText) view.findViewById(R.id.grade_1);
        EditText grade2 = (EditText) view.findViewById(R.id.grade_2);
        EditText grade3 = (EditText) view.findViewById(R.id.grade_3);
        TextView result = (TextView) view.findViewById(R.id.result) ;
        TextView situation = (TextView) view.findViewById(R.id.situation) ;

        GradeCalculator gradeCalculator = new GradeCalculator(
                Double.valueOf(String.valueOf(grade1.getText()).isEmpty() ? "-1" : String.valueOf(grade1.getText())),
                Double.valueOf(String.valueOf(grade2.getText()).isEmpty() ? "-1" : String.valueOf(grade2.getText())),
                Double.valueOf(String.valueOf(grade3.getText()).isEmpty() ? "-1" : String.valueOf(grade3.getText()))
        );

        result.setText(String.valueOf(gradeCalculator.calculateAverage()));
        situation.setText(gradeCalculator.getSituation());
        grade1.setText(String.valueOf(gradeCalculator.getGrade1()));
        grade2.setText(String.valueOf(gradeCalculator.getGrade2()));
        grade3.setText(String.valueOf(gradeCalculator.getGrade3()));
    }
}