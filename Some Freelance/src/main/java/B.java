public class B extends A{

    int c;
    B(int a, int b){
        super(a);
        super.r = 5;
        this.c = b;
    }

    int a(){
        return 4;
    }

    public static void main(String[] args) {
        B b = new B(10, 20);
        System.out.println(b.r);
        System.out.println(b.c);
        int var1 = 3;
    }

    int doCalc(int var1){
        return 4;
    }
}
