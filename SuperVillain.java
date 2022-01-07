public class SuperVillain extends SuperCitizen{

    private String evilPlan;

    public SuperVillain(String name, String job, String superPower, boolean cape, int powerLevel, String evilPlan) {
        super(name, job, superPower, cape, powerLevel);
        this.evilPlan = evilPlan;
    }

    public String getEvilPlan() {
        return this.evilPlan;
    }

    public void setEvilPlan(String evilPlan) {
        this.evilPlan = evilPlan;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + 
            " evilPlan='" + getEvilPlan() + "'" +
            "}";
    }
    
}
