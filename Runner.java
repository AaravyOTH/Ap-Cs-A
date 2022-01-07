public class Runner {
    public static void main (String [] args)
    {
        Person p1 = new Person("Michael Scott", "Regional Manager");
        SuperCitizen s1 = new SuperHero("Clark Kent", "Journalist", "Invincibility & Superstrength", true, 10, "Up, up, & away!");
        SuperCitizen s2 = new SuperVillain("Lex Luthor", "Scientist", "Genius Level Intellect", false, 6, "Defeat Superman with a Kryptonite Ring");
        SuperHero s3 = new SuperHero("Peter Parker", "Photographer", "Spider Abilities", false, 9, "With great power comes great responsibility");
        System.out.println(p1);
        System.out.println(p1.getName()+" "+p1.getJob());
        System.out.println(s1);
        System.out.println(s1.getName()+" "+s1.getJob()+" "+s1.getSuperPower()+" "+s1.hasCape()+" "+((SuperHero)s1).getPowerLevel()+" "+((SuperHero)s1).getCatchphrase());
        s1.powerLevelModification(100);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s2.getName()+" "+s2.getJob()+" "+s2.getSuperPower()+" "+s2.hasCape()+" "+s2.getPowerLevel()+" "+((SuperVillain)s2).getEvilPlan());
        System.out.println(s3);
        System.out.println(s3.getName()+" "+s3.getJob()+" "+s3.getSuperPower()+" "+s3.hasCape()+" "+s3.getPowerLevel()+" "+s3.getCatchphrase());
        
    }
}
