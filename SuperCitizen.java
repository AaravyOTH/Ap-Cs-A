public class SuperCitizen extends Person{

    private String superPower;
    private boolean cape;
    private int powerLevel;

    public SuperCitizen(String name, String job, String superPower, boolean cape, int powerLevel) {
        super(name, job);
        this.superPower = superPower;
        this.cape = cape;
        this.powerLevel = powerLevel;
    }

    public String getSuperPower() {
        return this.superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public boolean isCape() {
        return this.cape;
    }

    public boolean hasCape() {
        return this.cape;
    }

    public void setCape(boolean cape) {
        this.cape = cape;
    }

    public int getPowerLevel() {
        return this.powerLevel;
    }

    public void powerLevelModification (int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
            " superPower='" + getSuperPower() + "'" +
            ", cape='" + isCape() + "'" +
            ", powerLevel='" + getPowerLevel() + "'" +
            "}";
    }

}