public class Person{
    private String name, job;
    private int hitPoints, maxDamage, defenseAbility;

    public Person(String name, String job, int hitPoints, int maxDamage, int defenseAbility) {
        this.name = name;
        this.job = job;
        this.hitPoints = hitPoints;
        this.maxDamage = maxDamage;
        this.defenseAbility = defenseAbility;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getDefenseAbility() {
        return this.defenseAbility;
    }

    public void setDefenseAbility(int defenseAbility) {
        this.defenseAbility = defenseAbility;
    }

    public void hpReduction(int damage){
        hitPoints -= damage;
    }
    

    public String getName() {
        return this.name;
    }


    public String getJob() {
        return this.job;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", job='" + getJob() + "'" +
            "}";
    }

}