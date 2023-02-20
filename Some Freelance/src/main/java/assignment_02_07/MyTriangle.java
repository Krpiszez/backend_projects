package assignment_02_07;

public class MyTriangle extends Triangle{

    public MyTriangle(double segment1, double segment2, double segment3) {
        super(segment1, segment2, segment3);
    }

    public boolean canBuilt(){
        boolean res = false;

        if (segment1+segment2>segment3&&segment1+segment3>segment2&&segment2+segment3>segment1){
            res = true;
        }

        return res;

    }

    public Double calculateArea(MyTriangle myTriangle){
        if (myTriangle.canBuilt()){
        return (myTriangle.segment2 * myTriangle.segment4) / 2;
        }else return null;

    }
}
