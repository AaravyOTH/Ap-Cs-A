public class SuperVillain extends SuperCitizen{

    private String evilPlan;

    public SuperVillain(String name, String job, int hitPoints, int maxDamage, int defenseAbility, String superPower, boolean cape, int powerLevel, String superName, String evilPlan) {
        super( name, job, hitPoints, maxDamage, defenseAbility, superPower, cape, powerLevel, superName);
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
