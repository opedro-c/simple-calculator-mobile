package br.ufrn.calculadora.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.ufrn.calculadora.R;
import br.ufrn.calculadora.business.SimpleCalculator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSimpleCalculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSimpleCalculator extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private SimpleCalculator calculator = new SimpleCalculator();

    public FragmentSimpleCalculator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSimpleCalculator.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSimpleCalculator newInstance(String param1, String param2) {
        FragmentSimpleCalculator fragment = new FragmentSimpleCalculator();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_calculator, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView text_res = (TextView) view.findViewById(R.id.text_res);
        Button button_0 = (Button) view.findViewById(R.id.button_0);
        Button button_1 = (Button) view.findViewById(R.id.button_1);
        Button button_2 = (Button) view.findViewById(R.id.button_2);
        Button button_3 = (Button) view.findViewById(R.id.button_3);
        Button button_4 = (Button) view.findViewById(R.id.button_4);
        Button button_5 = (Button) view.findViewById(R.id.button_5);
        Button button_6 = (Button) view.findViewById(R.id.button_6);
        Button button_7 = (Button) view.findViewById(R.id.button_7);
        Button button_8 = (Button) view.findViewById(R.id.button_8);
        Button button_9 = (Button) view.findViewById(R.id.button_9);
        Button button_del = (Button) view.findViewById(R.id.button_del);
        Button button_c = (Button) view.findViewById(R.id.button_c);
        Button button_div = (Button) view.findViewById(R.id.button_div);
        Button button_sum = (Button) view.findViewById(R.id.button_sum);
        Button button_sub = (Button) view.findViewById(R.id.button_sub);
        Button button_mult = (Button) view.findViewById(R.id.button_mult);
        Button button_eq = (Button) view.findViewById(R.id.button_eq);

        button_0.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_0.getText())))));
        button_1.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_1.getText())))));
        button_2.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_2.getText())))));
        button_3.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_3.getText())))));
        button_4.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_4.getText())))));
        button_5.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_5.getText())))));
        button_6.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_6.getText())))));
        button_7.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_7.getText())))));
        button_8.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_8.getText())))));
        button_9.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.typeNumber(Double.parseDouble((String) button_9.getText())))));

        button_del.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.del())));
        button_c.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.clear())));

        button_div.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.setOperation((String) button_div.getText()))));
        button_mult.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.setOperation((String) button_mult.getText()))));
        button_sum.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.setOperation((String) button_sum.getText()))));
        button_sub.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.setOperation((String) button_sub.getText()))));
        button_eq.setOnClickListener(view1 -> text_res.setText(String.valueOf(calculator.calculate())));
    }
}