package PokeTypes;
import java.util.ArrayList;
import java.util.Arrays;

import Main.Pokemon;

public class WaterPokemon extends Pokemon {
  public WaterPokemon ( String name, int level, String attack1, String attack1type, String attack3, String attack3type, int offense, int defense, int speed, int health ) {
    super ( name, level, "water", attack1, attack1type, attack3, attack3type, "watergun", "water", offense, defense, speed, health, new ArrayList<String> ( Arrays.asList ( "electric", "grass", "dragon" ) ), new ArrayList<String> ( Arrays.asList ( "fire", "ice", "water", "steel" ) ) );

  }

}