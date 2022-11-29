package Main;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Random;

public class Pokemon{
  protected String name;
  protected int level;
  protected String type;
  protected String attack1;
  protected String attack1type;
  protected String attack2;
  protected String attack2type;
  protected String attack3;
  protected String attack3type;
  protected String attack4;
  protected String attack4type;
  protected int health;
  protected int offense;
  protected int defense;
  protected int speed;
  protected int healthMultplier;
  protected int offenseMultplier;
  protected int defenseMultplier;
  protected int speedMultplier;
  protected ArrayList<String> weakness;
  protected ArrayList<String> resistant;
  protected String status;
  protected int statusDuration;
  
  public Pokemon (String name, int level, String type, String attack1, String attack1type, String attack3, String attack3type, String attack2,  String attack2type, int offense, int defense, int speed, int health, ArrayList<String> weakness, ArrayList<String> resistant ) {
    this.name = name;
    this.level = level;
    this.type = type;
    this.attack1 = attack1;
    this.attack2 = attack2;
    this.attack1type = attack1type;
    this.attack2type = attack2type;
    this.attack3 = attack3;
    this.attack4 = "slash";
    this.attack3type = attack3type;
    this.attack4type = "normal";

    this.health = health;
    this.offense = offense;
    this.defense = defense;
    this.speed = speed;

    this.healthMultplier = health / 50;
    this.offenseMultplier = offense;
    this.defenseMultplier = defense;
    this.speedMultplier = speed;

    this.weakness = new ArrayList<String>();
    this.weakness = weakness;
    this.resistant = new ArrayList<String>();
    this.resistant = resistant;

    this.status = "none";
    this.statusDuration = 0;

  }

  public static Pokemon copy (Pokemon copy) {
    Pokemon newPoke = new Pokemon (null, 0, null, null, null, null, null, null, null, 0, 0, 0, 0, null, null );
    newPoke.name = copy.name;
    newPoke.level = copy.level;
    newPoke.type = copy.type;
    newPoke.attack1 = copy.attack1;
    newPoke.attack1type = copy.attack1type;
    newPoke.attack2 = copy.attack2;
    newPoke.attack2type = copy.attack2type;
    newPoke.attack3 = copy.attack3;
    newPoke.attack3type = copy.attack3type;
    newPoke.attack4 = copy.attack4;
    newPoke.attack4type = copy.attack4type;
    newPoke.health = copy.health;
    newPoke.offense = copy.offense;
    newPoke.defense = copy.defense;
    newPoke.speed = copy.speed;
    newPoke.healthMultplier = copy.healthMultplier;
    newPoke.offenseMultplier = copy.offenseMultplier;
    newPoke.defenseMultplier = copy.defenseMultplier;
    newPoke.speedMultplier = copy.speedMultplier;
    newPoke.weakness = copy.weakness;
    newPoke.resistant = copy.resistant;
    newPoke.status = copy.status;
    newPoke.statusDuration = copy.statusDuration;

    return newPoke;

  } 

  public String myType () {
    return this.type;

  }
  

  public boolean isWeakTo ( String type ) {
    for ( int i = 0; i < this.weakness.size (); i++ ) {
      if ( this.weakness.get( i ).equals( type ) ) {
        return true;

      }

    }

    return false;

  }

  public boolean isResistantTo ( String type ) {
    for ( int i = 0; i < this.resistant.size (); i++ ) {
      if ( this.resistant.get( i ).equals( type ) ) {
        return true;

      }

    }

    return false;

  }

  public void printName () {
    System.out.printf( "%-10s", this.name );

  }

  public void printData () {
    System.out.println ( "PokéData" );
    System.out.println ( "-----------" );
    System.out.println ( "Name: " + this.name );
    System.out.println ( "Lvl: " + this.level );
    System.out.println ( "Type: " + this.type );
    System.out.println ( "Health: " + this.health );
    System.out.println ( "Offense: " + this.offense );
    System.out.println ( "Defense: " + this.defense );
    System.out.println ( "Speed: " + this.speed );
    System.out.println ( "Attack 1: " + this.attack1 + " | " + this.attack1type );
    System.out.println ( "Attack 2: " + this.attack2 + " | " + this.attack2type );
    System.out.println ( "Attack 3: " + this.attack3 + " | " + this.attack3type );
    System.out.println ( "Attack 4: " + this.attack4 + " | " + this.attack4type );
    
  }

  public void levelUp ( int levels ) {
    if ( levels < 1 ) {
      levels = 1;

    }

    if ( levels > 100 ) {
      levels = 100;

    }

    if ( levels < this.level ) {
      for ( int i = this.level; i > levels; i-- ) {
        this.speed -= this.speedMultplier;
        this.defense -= this.defenseMultplier;
        this.offense -= this.offenseMultplier;
        this.health -= healthMultplier;
        this.level--;

      }

    } else if ( levels > this.level ) {
      for ( int i = this.level; i < levels; i++ ) {
        this.speed += this.speedMultplier;
        this.defense += this.defenseMultplier;
        this.offense += this.offenseMultplier;
        this.health += healthMultplier;
        this.level++;

      }

    }

  }

  public void printHealth ( int currentHealth ) {
    int life = ( ( currentHealth * 100 ) / this.health ) / 5;
    int total = ( ( this.health * 100 ) / this.health ) / 5;
    int space = total - life;
    
    System.out.printf ( "[" );

    for ( int i = 0; i < life; i++ ) {
      System.out.printf ( "=" );

    }

    for(int i = 0; i < space; i++){
      System.out.printf(" ");

    }

    System.out.printf ( "]" );

  }

  public int damage ( String attack ) {
    int attackMultplier = ( ( this.offense / 100 ) + 1 );
    Random rand = new Random();
    int missChance;
    switch ( attack ) {
      //fire
      case "flamethrower":
        missChance = rand.nextInt ( 4 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 200 * attackMultplier;

      case "ember":
        return 60 * attackMultplier;

      //water
      case "surf":
        missChance = rand.nextInt ( 5 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 175 * attackMultplier;

      case "watergun":
        return 40 * attackMultplier;

      //grass
      case "leafblade":
        return 100 * attackMultplier;

      case "gigadrain":
        missChance = rand.nextInt ( 6 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 80 * attackMultplier;

      case "solarbeam":
        missChance = rand.nextInt ( 3 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 200 * attackMultplier;

      //normal
      case "slash":
        missChance = rand.nextInt ( 9 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 85 * attackMultplier;

      //dragon
      case "dragonslash":
        return 90 * attackMultplier;

      case "dragonbreath":
        missChance = rand.nextInt ( 3 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 120 * attackMultplier;

      //electric
      case "thunderbolt":
        missChance = rand.nextInt ( 9 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 100 * attackMultplier;
      
      case "zap":
        return 40 * attackMultplier;

      //flying
      case "fly":
        missChance = rand.nextInt ( 4 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 105 * attackMultplier;

      //steel
      case "irontail":
        missChance = rand.nextInt ( 5 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 80 * attackMultplier;

      case "ironclaw":
        missChance = rand.nextInt ( 5 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 90 * attackMultplier;

      //psychic
      case "psychostrike":
        return 110 * attackMultplier;

      case "psychosis":
        return 30 * attackMultplier;

      //ground
      case "earthquake":
        return 130 * attackMultplier;

      //rock
      case "rockthrow":
        missChance = rand.nextInt ( 6 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 80 * attackMultplier;

      //ghost
      case "lick":
        missChance = rand.nextInt ( 6 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 85 * attackMultplier;

      case "ghostpunch":
        missChance = rand.nextInt ( 9 );
        if ( missChance == 1 ) {
          return 0;

        }

        return 90 * attackMultplier;

    }

    return 0;

  }

  public static int attack ( Pokemon attacker, Pokemon defender, String attack1, String attackType, int dano, int currentHealthDefender ) throws InterruptedException {
    
    if ( attacker.status.equals ( "paralyzed" ) ) {
      System.out.printf ( "%s is paralyzed!\n", attacker.name );
      TimeUnit.SECONDS.sleep ( 2 );

    } else if ( dano == 0 ) {
      System.out.printf ( "%s missed!\n", attacker.name );
      TimeUnit.SECONDS.sleep ( 2 );

    } else if ( defender.isWeakTo ( attackType ) ) {
      currentHealthDefender -= dano * 3;
      System.out.printf ( "%s used %s on %s and it was very effective!\n", attacker.name, attack1, defender.name );
      TimeUnit.SECONDS.sleep ( 2 );

    } else if ( defender.isResistantTo ( attackType ) ) {
      currentHealthDefender -= dano / 3;
      System.out.printf ( "%s used %s on %s and it was not effective\n", attacker.name, attack1, defender.name );
      TimeUnit.SECONDS.sleep ( 2 );

    } else {
      currentHealthDefender -= dano - ( dano * ( defender.defense / 1000 ) );
      System.out.printf ( "%s used %s on %s\n", attacker.name, attack1, defender.name );
      TimeUnit.SECONDS.sleep ( 2 );

    }

    return currentHealthDefender;

  }

  public static int statusAttacker ( Pokemon attacker, Pokemon defender, String attack1, int dano, int currentHealthAttacker ) throws InterruptedException {
    
    if ( attack1.equals ( "gigadrain" ) ) {
      currentHealthAttacker += dano / 10;
      System.out.printf ( "%s recovered health because of gigadrain!\n", attacker.name );
      TimeUnit.SECONDS.sleep ( 2 );

    }

    if ( attacker.status.equals ( "confused" ) ) {
      System.out.printf ( "%s is confused!\n", attacker.name );
      TimeUnit.SECONDS.sleep ( 2 );
      currentHealthAttacker -= dano / 2;

    }

    return currentHealthAttacker;

  }  

  public static int statusDefender ( Pokemon attacker, Pokemon defender, String attack1, int dano, int currentHealthDefender ) throws InterruptedException {
    StatusEffects status = new StatusEffects();
    
    if ( status.getBurning().contains ( attack1 ) && !( attacker.status.contains ( "paralyzed" ) ) ) { 
      defender.burn();

    }

    if ( defender.status.equals ( "burning" ) ) {
      currentHealthDefender -= 50;
      System.out.printf ( "%s is burning!\n", defender.name );
      if ( defender.statusDuration == 0 ) {
        defender.status = "none";

      }

      defender.statusDuration--;
      TimeUnit.SECONDS.sleep ( 2 );

    }

    if ( status.getParalysis().contains ( attack1 ) && !( attacker.status.contains ( "paralyzed" ) ) ) {
      defender.paralyze();

    }

    if ( defender.status.equals ( "paralyzed" ) ) {      
      System.out.printf ( "%s is paralyzed!\n", defender.name );
      if ( defender.statusDuration == 0 ) {
        defender.status = "none";

      }

      defender.statusDuration--;
      TimeUnit.SECONDS.sleep ( 2 );

    }

    if ( status.getConfusion().contains ( attack1 ) && !( attacker.status.contains ( "paralyzed" ) ) ) {
      defender.confuse();

    }

    if ( defender.status.equals ( "confused" ) ) {
      
      //System.out.printf("%s is confused!\n", defender.name);
      if ( defender.statusDuration == 0 ) {
        defender.status = "none";

      }

      defender.statusDuration--;
      TimeUnit.SECONDS.sleep ( 2 );

    }

    return currentHealthDefender;

  }
  
  public void burn () {
    Random rand = new Random();
    int int_random = rand.nextInt ( 3 );
    if ( int_random == 1 ) {
      return;

    }

    this.status = "burning";
    this.statusDuration = 3;
    return;

  }

  public void paralyze () {
    Random rand = new Random();
    int int_random = rand.nextInt ( 4 );
    if ( int_random == 1 ) {
      this.status = "paralyzed";
      this.statusDuration = 2;

    }

    return;

  }

  public void confuse () {
    Random rand = new Random();
    int int_random = rand.nextInt ( 3 );
    if ( int_random == 1 ) {
      this.status = "confused";
      this.statusDuration = 2;

    }

    return;

  }
  
  public static void battle ( Pokemon jogador1, Pokemon jogador2 ) throws InterruptedException {
    Scanner Choice = new Scanner ( System.in );
    int attackChoice1, attackChoice2, currentHealth1 = jogador1.health, currentHealth2 = jogador2.health, dano1, dano2;
    String attack1, attack2, attack1Type, attack2Type;

    System.out.print ( "\033[H\033[2J" );  
    System.out.flush(); 

    System.out.println ( "---------Batalha  Pokemon---------" );
    System.out.printf ( "%-14s |  | %14s\n",  jogador1.name, jogador2.name );
    System.out.printf ( "lvl: %-9d |VS| %12s%2d\n",  jogador1.level, "lvl: ", jogador2.level );
    System.out.printf ( "%-14s |  | %14s\n",  jogador1.type, jogador2.type );
    System.out.println();

    TimeUnit.SECONDS.sleep ( 1 );
    System.out.println ( "3" );
    TimeUnit.SECONDS.sleep ( 1 );
    System.out.println ( "2" );
    TimeUnit.SECONDS.sleep ( 1 );
    System.out.println ( "1" );
    TimeUnit.SECONDS.sleep ( 1 );

    while ( currentHealth1 > 0 && currentHealth2 > 0 ) {

      System.out.print ( "\033[H\033[2J" );  
      System.out.flush(); 
  
      System.out.printf ( "%-50s      %50s\n",  "Jogador 1", "Jogador 2" );
      System.out.printf ( "%-15s %4d/%4d %-54s %4d/%-11d%s\n",  jogador1.name, currentHealth1, jogador1.health, " ", currentHealth2, jogador2.health, jogador2.name );
      jogador1.printHealth ( currentHealth1 );
      if ( jogador1.status.equals ( "none" ) ) {
        System.out.printf ( "%31s", " " );

      } else {
        System.out.printf ( "%-11s", jogador1.status );
        System.out.printf ( "%20s", " " );

      }
      
      if ( jogador2.status.equals ( "none" ) ) {
        System.out.printf ( "%31s", " " );
      } else {
        System.out.printf ( "%20s", " " );
        System.out.printf ( "%11s", jogador2.status );
        
      }

      jogador2.printHealth ( currentHealth2 );

      System.out.println();
      System.out.printf ( "lvl: %2d  type: %-35s      %35s%2d  type: %s\n",  jogador1.level, jogador1.type, "lvl: ", jogador2.level, jogador2.type );
      System.out.println();
      System.out.printf ( "[1]%-12s [2]%-31s      %25s%-12s %s%-10s\n",  jogador1.attack1, jogador1.attack2, "[1]", jogador2.attack1, "[2]", jogador2.attack2 );
      System.out.printf ( "[3]%-12s [4]%-31s      %25s%-12s %s%-10s\n",  jogador1.attack3, jogador1.attack4, "[3]", jogador2.attack3, "[4]", jogador2.attack4 );
  
      System.out.println();
  
      System.out.printf ( "Escolha o ataque [jogador 1]: " );
      attackChoice1 = Choice.nextInt();
  
      attack1 = jogador1.attack1;
      attack1Type = jogador1.attack1type;
  
      switch ( attackChoice1 ) {
        case 1:
  
          break;

        case 2:
          attack1 = jogador1.attack2;
          attack1Type = jogador1.attack2type;
          break;

        case 3:
          attack1 = jogador1.attack3;
          attack1Type = jogador1.attack3type;
          break;

        case 4:
          attack1 = jogador1.attack4;
          attack1Type = jogador1.attack4type;
          break;

      }
  
      System.out.printf ( "Escolha o ataque [jogador 2]: " );
      attackChoice2 = Choice.nextInt();
  
      attack2 = jogador2.attack1;
      attack2Type = jogador2.attack1type;
  
      switch ( attackChoice2 ) {
        case 1:
  
          break;

        case 2:
          attack2 = jogador2.attack2;
          attack2Type = jogador2.attack2type;
          break;

        case 3:
          attack2 = jogador2.attack3;
          attack2Type = jogador2.attack3type;
          break;

        case 4:
          attack2 = jogador2.attack4;
          attack2Type = jogador2.attack4type;
          break;

      }
      
      dano1 = jogador1.damage ( attack1 );
      dano2 = jogador2.damage ( attack2 );
      
      if ( jogador1.speed >= jogador2.speed ) {

        currentHealth2 = Pokemon.attack ( jogador1, jogador2, attack1, attack1Type, dano1, currentHealth2 );

        currentHealth1 = Pokemon.statusAttacker ( jogador1, jogador2, attack1, dano1, currentHealth1 );
        currentHealth2 = Pokemon.statusDefender ( jogador1, jogador2, attack1, dano1, currentHealth2 );

        if ( currentHealth2 > 0 ) {

          currentHealth1 = Pokemon.attack ( jogador2, jogador1, attack2, attack2Type, dano2, currentHealth1 );

          currentHealth2 = Pokemon.statusAttacker ( jogador2, jogador1, attack2, dano2, currentHealth2 );
          currentHealth1 = Pokemon.statusDefender ( jogador2, jogador1, attack2, dano2, currentHealth1 );

        }
        
      }

      else if ( jogador2.speed > jogador1.speed ) {

        currentHealth1 = Pokemon.attack ( jogador2, jogador1, attack2, attack2Type, dano2, currentHealth1 );

        currentHealth2 = Pokemon.statusAttacker ( jogador2, jogador1, attack2, dano2, currentHealth2 );
        currentHealth1 = Pokemon.statusDefender ( jogador2, jogador1, attack2, dano2, currentHealth1 );

        if ( currentHealth1 > 0 ) {

          currentHealth2 = Pokemon.attack ( jogador1, jogador2, attack1, attack1Type, dano1, currentHealth2 );

          currentHealth1 = Pokemon.statusAttacker ( jogador1, jogador2, attack1, dano1, currentHealth1 );
          currentHealth2 = Pokemon.statusDefender ( jogador1, jogador2, attack1, dano1, currentHealth2 );

        }

      }

    }

    if (currentHealth1 < 0 ) {
      currentHealth1 = 0;

    }

    if ( currentHealth2 < 0 ) {
      currentHealth2 = 0;

    }

    System.out.print ( "\033[H\033[2J" );  
    System.out.flush(); 

    System.out.printf ( "%-50s      %50s\n",  "Jogador 1", "Jogador 2" );
    System.out.printf ( "%-15s %4d/%4d %-54s %4d/%-11d%s\n",  jogador1.name, currentHealth1, jogador1.health, " ", currentHealth2, jogador2.health, jogador2.name );
    jogador1.printHealth ( currentHealth1 );
    System.out.printf ( "%62s", " " );
    jogador2.printHealth ( currentHealth2 );
    System.out.println();
    System.out.printf ( "lvl: %2d  type: %-35s      %35s%2d  type: %s\n",  jogador1.level, jogador1.type, "lvl: ", jogador2.level, jogador2.type );
    System.out.println();
    System.out.printf ( "%-15s %-34s      %34s %15s\n",  jogador1.attack1, jogador1.attack2, jogador2.attack1, jogador2.attack2 );

    System.out.println();

    if ( currentHealth1 <= 0 ) {
      System.out.printf ( "%s fainted!\n", jogador1.name );
      TimeUnit.SECONDS.sleep ( 2 );

    }

    if ( currentHealth2 <= 0 ) {
      System.out.printf ( "%s fainted!\n", jogador2.name );
      TimeUnit.SECONDS.sleep ( 2 );

    }
    
    //Choice.close();

  }

}