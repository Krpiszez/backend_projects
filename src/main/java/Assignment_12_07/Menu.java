package Assignment_12_07;

public class Menu {

    public static void main(String[] args) {

        Menu obj = new Menu("a","b","c");
        if (obj.getMain()==null||obj.getSalad()==null||obj.getDessert()==null){
            System.out.println("unknown");
        }else {
            System.out.println(obj);
        }
    }

    private String salad;
    private String main;
    private String dessert;

    public Menu() {
    }

    public Menu(String salad, String main, String dessert) {
        this.salad = salad;
        this.main = main;
        this.dessert = dessert;
    }

    public String getSalad() {
        return salad;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "Salad=" + salad +
                ", Main Meal=" + main +
                ", Dessert=" + dessert +
                '}';
    }
}
