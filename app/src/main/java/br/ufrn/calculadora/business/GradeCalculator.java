package br.ufrn.calculadora.business;

public class GradeCalculator {

    private Double grade1;
    private Double grade2;
    private Double grade3;

    private Double average;
    
    private static final Double UNFILLED = -1.0;

    public String getSituation() {
        if (average >= 7.0)
            return "APROVADO";
        else if (average >= 5.0)
            return "APROVADO POR NOTA";
        else
            return "REPROVADO";
    }

    public Double calculateAverage() {
        fillMissingGrades();
        average =  (grade1 + grade2 + grade3) / 3;
        return average;
    }

    private void fillMissingGrades() {
        if (!grade1.equals(UNFILLED) && grade2.equals(UNFILLED) && grade3.equals(UNFILLED)) {
            grade2 = (15.0 - grade1) / 2;
            grade3 = (15.0 - grade1) / 2;
        } else if (grade1.equals(UNFILLED) && !grade2.equals(UNFILLED) && grade3.equals(UNFILLED)) {
            grade1 = (15.0 - grade2) / 2;
            grade3 = (15.0 - grade2) / 2;
        } else if (grade1.equals(UNFILLED) && grade2.equals(UNFILLED) && !grade3.equals(UNFILLED)) {
            grade1 = (15.0 - grade3) / 2;
            grade2 = (15.0 - grade3) / 2;
        } else if (grade1.equals(UNFILLED) && !grade2.equals(UNFILLED)) {
            grade1 = 15.0 - grade2 - grade3;
        } else if (!grade1.equals(UNFILLED) && grade2.equals(UNFILLED)) {
            grade2 = 15.0 - grade1 - grade3;
        } else if (!grade1.equals(UNFILLED) && grade3.equals(UNFILLED)) {
            grade3 = 15.0 - grade1 - grade2;
        }
    }

    public GradeCalculator(Double grade1, Double grade2, Double grade3) {
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public Double getGrade1() {
        return grade1;
    }

    public Double getGrade2() {
        return grade2;
    }

    public Double getGrade3() {
        return grade3;
    }
}
