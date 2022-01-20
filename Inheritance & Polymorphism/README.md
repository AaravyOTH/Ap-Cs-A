# Superheroes, Supervillains, and NormalCitizens

Project about inheritance and polymorphism in Java. 

Created custom objects: SuperHero, SuperVillian, SuperCitizen, NormalCitizen, Person.

[PART I](https://github.com/AaravyOTH/Ap-Cs-A/blob/master/Inheritance%20%26%20Polymorphism/Superheroes%2C%20Supervillains%2C%20and%20NormalCitizens%20(Part%201).pdf)

[PART II](https://github.com/AaravyOTH/Ap-Cs-A/blob/master/Inheritance%20%26%20Polymorphism/Superheroes%2C%20Supervillains%2C%20and%20NormalCitizens%20(Part%202).pdf)

[PART III](https://github.com/AaravyOTH/Ap-Cs-A/blob/master/Inheritance%20%26%20Polymorphism/Superheroes%2C%20Supervillains%2C%20and%20NormalCitizens%20(Part%203).pdf)


"Runner program" to run simulation using custom objs: 
```java
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
```