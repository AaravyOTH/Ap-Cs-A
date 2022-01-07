public class SuperHero extends SuperCitizen{

    private String catchphrase;

    public SuperHero(String name, String job, String superPower, boolean cape, int powerLevel, String catchphrase) {
        super(name, job, superPower, cape, powerLevel);
        this.catchphrase = catchphrase;
    }

    public String getCatchphrase() {
        return this.catchphrase;
    }

    public void setCatchPhrase(String catchphrase) {
        this.catchphrase = catchphrase;
    }

    public int getPowerLevel(){
        powerLevelModification((int)(Math.random()*10)+1);
        return super.getPowerLevel();
    }


    @Override
    public String toString() {
        return "{" + super.toString() + 
            " catchphrase='" + getCatchphrase() + "'" +
            "}";
    }

}
