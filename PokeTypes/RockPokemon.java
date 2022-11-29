package PokeTypes;
import java.util.ArrayList;
import java.util.Arrays;

import Main.Pokemon;

public class RockPokemon extends Pokemon {
  public RockPokemon ( String name, int level, String attack1, String attack1type, String attack3, String attack3type, int offense, int defense, int speed, int health ) {
    super ( name, level, "rock", attack1, attack1type, attack3, attack3type, "rockthrow", "rock", offense, defense, speed, health, new ArrayList<String> ( Arrays.asList ( "fighting", "ground", "steel" ) ), new ArrayList<String> ( Arrays.asList ( "normal", "flying", "poison", "fire" ) ) );
  
  }
    
}