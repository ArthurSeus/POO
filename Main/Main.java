package Main;
import java.util.Scanner;
import java.util.InputMismatchException;
//import java.util.concurrent.TimeUnit;

class Main {
  public static void main ( String[] args ) throws InterruptedException {
    Pokedex pokedex = new Pokedex();
    Scanner myChoice = new Scanner ( System.in );
    int choice;
    int pokeChoice;
    Pokemon jogador1, jogador2, view;

    while ( true ) {
      choice = 0;
      System.out.print ( "\033[H\033[2J" );  
      System.out.flush();

      System.out.println ( "-----" );
      System.out.println ( "Menu" );
      System.out.println ( "[1] Look at Pokédex" );
      System.out.println ( "[2] Pokémon duel" );
      System.out.println ( "[3] Exit" );
      System.out.print ( "\nYour input: " );

      try {
        choice = myChoice.nextInt();

      } catch ( InputMismatchException e ) {
        myChoice.nextLine();

      }

      if ( choice == 1 ) {
        pokeChoice = 0;

        while ( pokeChoice != 999 ) {
          System.out.print ( "\033[H\033[2J" );  
          System.out.flush(); 

          System.out.println ( "Pokémon list:" );
          pokedex.lista();
          System.out.println ( "-----------" );
          System.out.println();
          System.out.println ( "Type a number to look at a specific Pokémon" );
          System.out.println ( "[999] Return to menu" );
          System.out.print ( "\nYour input: " );
        
          try {
            pokeChoice = myChoice.nextInt() - 1;

          } catch ( InputMismatchException e ) {
            myChoice.nextLine();
            pokeChoice = 999;

          }
        
          if ( pokeChoice == 999 || pokeChoice < 0 || pokeChoice > pokedex.getNum() - 1 ) {
            break;

          }

          System.out.print ( "\033[H\033[2J" );  
          System.out.flush(); 

          view = pokedex.takePoke ( pokeChoice );
          view.printData();
          System.out.println ( "-----------" );
          System.out.println();
          System.out.println ( "[1] Look at a different Pokémon" );
          System.out.println ( "[2] Change Pokémon's level" );
          System.out.println ( "[999] Return to menu" );
          System.out.print ( "\nYour input: " );
          pokeChoice = myChoice.nextInt();

          if ( pokeChoice == 2 ) {
            while ( pokeChoice != 999 ) {
              System.out.print ( "Type desired level [999 to return]: " );
              pokeChoice = myChoice.nextInt();
              if ( pokeChoice == 999 ) {
                pokeChoice = 1;
                break;

              }

              view.levelUp ( pokeChoice );
              System.out.print ( "\033[H\033[2J" );  
              System.out.flush();

              view.printData();

            }

          }

        }

      } else if ( choice == 2 ) {

        System.out.print ( "\033[H\033[2J" );  
        System.out.flush();

        System.out.println ( "Pokémon list:" );
        pokedex.lista();

        System.out.print ( "\nChoose a Pokémon for player [ 1 ]: " );

        try {
          pokeChoice = myChoice.nextInt() - 1;
        
        } catch ( InputMismatchException e ) {
          myChoice.nextLine();
          pokeChoice = 0;

        }

        if ( pokeChoice > pokedex.getNum() - 1 ) {
          pokeChoice = 0;

        }

        jogador1 = Pokemon.copy ( pokedex.takePoke ( pokeChoice ) );

        System.out.print ( "Which level will " );
        jogador1.printName();
        System.out.print ( "be: " );

        try {
          pokeChoice = myChoice.nextInt();

        } catch ( InputMismatchException e ) {
          myChoice.nextLine();
          pokeChoice = 1;
          
        }

        jogador1.levelUp ( pokeChoice );
        
        System.out.print ( "\033[H\033[2J" );  
        System.out.flush();

        System.out.println ( "Pokémon list:" );
        pokedex.lista();

        System.out.print ( "\nChoose a Pokémon for player [ 2 ]: " );

        try {
          pokeChoice = myChoice.nextInt() - 1;
        
        } catch ( InputMismatchException e ) {
          myChoice.nextLine();
          pokeChoice = 0;

        }

        if ( pokeChoice > pokedex.getNum() - 1 ) {
          pokeChoice = 0;

        }

        jogador2 = Pokemon.copy ( pokedex.takePoke ( pokeChoice ) );

        System.out.print ( "Which level will " );
        jogador2.printName();
        System.out.print ( "be: " );

        try {
          pokeChoice = myChoice.nextInt();

        } catch ( InputMismatchException e ) {
          myChoice.nextLine();
          pokeChoice = 1;
          
        }

        jogador2.levelUp ( pokeChoice );

        Pokemon.battle ( jogador1, jogador2 );
        
      } else if ( choice == 3 ) {
        System.out.print ( "\033[H\033[2J" );  
        System.out.flush();

        myChoice.close();
        return;

      }

    }
     
  }

}