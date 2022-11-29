package PokeTypes;
import java.util.ArrayList;
import java.util.Arrays;

import Main.Pokemon;

public class FirePokemon extends Pokemon {
  public FirePokemon ( String name, int level, String attack1, String attack1type, String attack3, String attack3type, int offense, int defense, int speed, int health ) {
    super ( name, level, "fire", attack1, attack1type,  attack3, attack3type, "ember", "fire", offense, defense, speed, health, new ArrayList<String> ( Arrays.asList ( "water", "dragon", "rock" ) ), new ArrayList<String> ( Arrays.asList ( "fire", "grass", "ice", "steel", "bug" ) ) );

  }
  
}