package overriding_equals;

public class TryOverride {

    int a,b;

    public TryOverride (int a, int b){
        this.a=a;
        this.b=b;
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }

        if (!(o instanceof TryOverride)){
            return false;
        }

        TryOverride t = (TryOverride) o;

        return a == t.a && b == t.b;
//        return Integer.compare(a, t.a) == 0 && Integer.compare(b, t.b) == 0;
    }
}
