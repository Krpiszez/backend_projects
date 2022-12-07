package Assignment_12_07;

public class Country {

    public static void main(String[] args) {
        Country obj = new Country("Poland");
        String res = obj.getCountry();
        System.out.println(res);
    }

    private String country;

    public Country(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" + country + '}';
    }
}
