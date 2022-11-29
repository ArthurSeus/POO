package PokeTypes;
import java.util.ArrayList;
import java.util.Arrays;

import Main.Pokemon;

public class DragonPokemon extends Pokemon {
  public DragonPokemon ( String name, int level, String attack1, String attack1type, String attack3, String attack3type, int offense, int defense, int speed, int health ) {
    super ( name, level, "dragon", attack1, attack1type,  attack3, attack3type, "dragonslash", "dragon", offense, defense, speed, health, new ArrayList<String> ( Arrays.asList ( "fairy", "steel" ) ), new ArrayList<String> ( Arrays.asList ( "water", "grass", "electric", "fire" ) ) );
  
  }
    
}