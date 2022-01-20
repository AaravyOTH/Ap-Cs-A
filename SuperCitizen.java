public class SuperCitizen extends Person{

    private String superPower;
    private boolean cape;
    private int powerLevel;
    private String superName;
    public SuperCitizen(String name, String job, int hitPoints, int maxDamage, int defenseAbility, String superPower, boolean cape, int powerLevel, String superName) {
        super(name, job, hitPoints, maxDamage, defenseAbility);
        this.superPower = superPower;
        this.cape = cape;
        this.powerLevel = powerLevel;
        this.superName = superName;
    }

    public boolean getCape() {
        return this.cape;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getSuperName() {
        return this.superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
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