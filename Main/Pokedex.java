package Main;
import Pokemons.*;

public class Pokedex {
  protected Pokemon [] pokedex;
  protected int num;
  
  public Pokedex () {
    this.num = 7;
    this.pokedex = new Pokemon [ this.num ];
    this.pokedex [ 0 ] = new Charizard();
    this.pokedex [ 1 ] = new Blastoise();
    this.pokedex [ 2 ] = new Venusaur();
    this.pokedex [ 3 ] = new Pikachu();
    this.pokedex [ 4 ] = new Dragonite();
    this.pokedex [ 5 ] = new Geodude();
    this.pokedex [ 6 ] = new Mewtwo();

  }

  public void lista () {
    for( int i = 0; i < this.num; i++ ) {
      System.out.print ( "[" + ( i + 1 ) + "] " );
      this.pokedex [ i ].printName();
      System.out.printf ( "%5s"," " );
      System.out.printf ( " %s %s","type:", this.pokedex [ i ].type );
      System.out.println();

    }

  }

  public Pokemon takePoke ( int i ) {
    return this.pokedex [ i ];

  } 

  public int getNum () {
    return this.num;

  }

}