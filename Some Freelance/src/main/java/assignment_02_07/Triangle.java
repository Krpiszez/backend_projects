package assignment_02_07;

public class Triangle {

    protected double segment1;
    protected double segment2;
    protected double segment3;
    protected double segment4;

    public Triangle(double segment1, double segment2, double segment3) {
        double s = (segment1+segment2+segment3)/2;
        double h = Math.sqrt(s*(s-segment1)*(s-segment2)*(s-segment3))/6;
        this.segment1 = segment1;
        this.segment2 = segment2;
        this.segment3 = segment3;
        this.segment4 = h;
    }

    public Triangle() {
    }


}
