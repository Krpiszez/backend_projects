package cleancode_coffeemaker;

public class BoilerPlate {

    private boolean heater;

    private int pot;

    public BoilerPlate(boolean heater, int pot) {
        this.heater = heater;
        this.pot = pot;
    }

    public BoilerPlate() {
    }

    public boolean isHeater() {
        return heater;
    }

    public void setHeater(boolean heater) {
        this.heater = heater;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }
}
