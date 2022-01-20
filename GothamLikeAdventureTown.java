//Aarav Yadav

import java.util.ArrayList;

public class GothamLikeAdventureTown {

    //PART 1
    // Person p1 = new Pers qon("Michael Scott", "Regional Manager");
    // SuperCitizen s1 = new SuperHero("Clark Kent", "Journalist", "Invincibility & Superstrength", true, 10, "Up, up, & away!");
    // SuperCitizen s2 = new SuperVillain("Lex Luthor", "Scientist", "Genius Level Intellect", false, 6, "Defeat Superman with a Kryptonite Ring");
    // SuperHero s3 = new SuperHero("Peter Parker", "Photographer", "Spider Abilities", false, 9, "With great power comes great responsibility");
    // System.out.println(p1);
    // System.out.println(p1.getName()+" "+p1.getJob());
    // System.out.println(s1);
    // System.out.println(s1.getName()+" "+s1.getJob()+" "+s1.getSuperPower()+" "+s1.hasCape()+" "+((SuperHero)s1).getPowerLevel()+" "+((SuperHero)s1).getCatchphrase());
    // s1.powerLevelModification(100);
    // System.out.println(s1);
    // System.out.println(s2);
    // System.out.println(s2.getName()+" "+s2.getJob()+" "+s2.getSuperPower()+" "+s2.hasCape()+" "+s2.getPowerLevel()+" "+((SuperVillain)s2).getEvilPlan());
    // System.out.println(s3);
    // System.out.println(s3.getName()+" "+s3.getJob()+" "+s3.getSuperPower()+" "+s3.hasCape()+" "+s3.getPowerLevel()+" "+s3.getCatchphrase());

    static String [] firstNames = new String[]{
        "Micheal", "Fitzgerald", "Gumball", "Jhonson &", "Hershey", "Nestle", "Jim", "Pam", "Andy", "Joe"
    };

    static String [] lastNames = new String[]{
        "Scott", "Fitzgerald", "Waterson", "Smith", "Jhonson","Mama" , "Brown", "Williams", "Purple", "Davis"
    };
    static String [] occupations = new String[]{
        "Firefighter", "CEO", "Journalist", "Scientist", "Biologist", "Computer Engineer", "Singer", "Actor", "Dancer", "Accounter"
    };

    public static void main (String [] args)
    {
        new GothamLikeAdventureTown();
        
    }

    public GothamLikeAdventureTown()
    {
        // INSTANTIATING arraylists
        ArrayList<Person> dailyPlanetStreet = new ArrayList<>();
        ArrayList<Person> safetyLand = new ArrayList<>(); 
        ArrayList<Person> unfortunatelyFatallyWoundedPeople = new ArrayList<>();

        // 50 rand Person obj --> dailyPlanetStreet
        for(int i = 0; i < 48; i ++) dailyPlanetStreet.add(new NormalCitizen(firstNames[(int) (Math.random()*9)] + lastNames[(int) (Math.random()*9)], occupations[(int) (Math.random()*9)], 100, 1, 1));

        // Superhero + SuperVillian --> dailyPlanetStreet
        dailyPlanetStreet.add(new SuperHero("Clark Kent", "Journalist", 100, 20, 30, "Invincibility & Super Strength", true, 10, "Up, up, & away!", "Superman"));
        
        int villianIndex = (int)(Math.random()*48);
        dailyPlanetStreet.add(villianIndex, new SuperVillain("Alexander Joseph", "CEO", 100, 20, 30, "Criminal Mastermind & Superhuman Strength", false, 10, "Lex Luther", "Kill Superman"));

        // Start simulation
        int superheroIndex = -1;

        System.out.println("START OF SIMULATION.");
        
        while(dailyPlanetStreet.size() != 2)
        {
            System.out.println("");
            System.out.println("dailyPlanetStreet.size():" + dailyPlanetStreet.size());
            for(Person person: dailyPlanetStreet)
                System.out.println(person);
            System.out.println("");

            for (int i = 0; i < dailyPlanetStreet.size(); i++)
            {
                if(dailyPlanetStreet.get(i) instanceof SuperVillain)
                {
                    villianIndex = i;
                }
                if(dailyPlanetStreet.get(i) instanceof SuperHero)
                {
                    superheroIndex = i;
                }
            }

            boolean didSomeoneDie = false;
            //step 1 
            if(villianIndex != 0 && dailyPlanetStreet.get(villianIndex-1) instanceof NormalCitizen)
            {
                Person hurtPerson = dailyPlanetStreet.remove(villianIndex-1);
                unfortunatelyFatallyWoundedPeople.add(hurtPerson);
                System.out.println("KILLED: " + hurtPerson);
                didSomeoneDie = true;
            } else if (villianIndex != dailyPlanetStreet.size()-1 && dailyPlanetStreet.get(villianIndex+1) instanceof NormalCitizen)
            {
                Person hurtPerson = dailyPlanetStreet.remove(villianIndex+1);
                unfortunatelyFatallyWoundedPeople.add(hurtPerson);
                System.out.println("KILLED: " + hurtPerson);
                didSomeoneDie = true;
            }

            //2
            if(didSomeoneDie)
            {
                int safe = (int)(Math.random()*dailyPlanetStreet.size());
                if(!(dailyPlanetStreet.get(safe) instanceof SuperHero) && !(dailyPlanetStreet.get(safe) instanceof SuperVillain)) {
                    Person savedPerson = dailyPlanetStreet.remove(safe);
                    safetyLand.add(savedPerson);
                    System.out.println("SAVED: " + savedPerson);
                }
            }

            for (int i = 0; i < dailyPlanetStreet.size(); i++)
            {
                if(dailyPlanetStreet.get(i) instanceof SuperHero)
                {
                    superheroIndex = i;
                }
                if(dailyPlanetStreet.get(i) instanceof SuperVillain)
                {
                    villianIndex = i;
                }
            }

            //3
            int move = (int)(Math.random()*dailyPlanetStreet.size());
            dailyPlanetStreet.add(move, dailyPlanetStreet.remove(superheroIndex));

            
        }

        System.out.println("END OF SIMULATION.");
        System.out.println("BATTLE SIMULATION");

        for (int i = 0; i < dailyPlanetStreet.size(); i++)
        {
            if(dailyPlanetStreet.get(i) instanceof SuperHero)
            {
                superheroIndex = i;
            }
            if(dailyPlanetStreet.get(i) instanceof SuperVillain)
            {
                villianIndex = i;
            }
        }

        SuperVillain lex = (SuperVillain) dailyPlanetStreet.get(villianIndex);
        SuperHero sup = (SuperHero) dailyPlanetStreet.get(superheroIndex);

        int firstAttacker = (int)(Math.random()*2)+1;
        System.out.println("Superman has " + sup.getHitPoints() + " hitpoints and Lex Luther has " + lex.getHitPoints());
        while (lex.getHitPoints() > 0 && sup.getHitPoints() > 0){

            System.out.println("Superman has " + sup.getHitPoints() + " hitpoints and Lex Luther has " + lex.getHitPoints());
            if(firstAttacker == 1){
                int damageVal = (int) (Math.random()* sup.getMaxDamage())+1;
                int defenceVal = (int) (Math.random()* lex.getDefenseAbility())+1;
                if(damageVal >= defenceVal){
                    lex.hpReduction(damageVal);
                }
                damageVal = (int) (Math.random()* lex.getMaxDamage())+1;                 
                defenceVal = (int) (Math.random()* sup.getDefenseAbility())+1;
                if(damageVal >= defenceVal){
                    sup.hpReduction(damageVal);
                }
            }
            else{
                int damageVal = (int) (Math.random()* lex.getMaxDamage())+1;
                int defenceVal = (int) (Math.random()* sup.getDefenseAbility())+1;
                if(damageVal >= defenceVal){
                    sup.hpReduction(damageVal);
                }
                damageVal = (int) (Math.random()* sup.getMaxDamage())+1;
                defenceVal = (int) (Math.random()* lex.getDefenseAbility())+1;
                if(damageVal >= defenceVal){
                    lex.hpReduction(damageVal);
                }
            }
        }
        
        System.out.println("Superman has " + sup.getHitPoints() + " hitpoints and Lex Luther has " + lex.getHitPoints());
        if(sup.getHitPoints() <= 0)
        {
            System.out.println("Lex Luther has won!");
        }
        if(lex.getHitPoints() <= 0)
        {
            System.out.println("Superman has won!");
        }
    }
}
