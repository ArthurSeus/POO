package PokeTypes;
import java.util.ArrayList;
import java.util.Arrays;

import Main.Pokemon;

public class ElectricPokemon extends Pokemon {
  public ElectricPokemon ( String name, int level, String attack1, String attack1type, String attack3, String attack3type, int offense, int defense, int speed, int health ) {
    super ( name, level, "electric", attack1, attack1type, attack3, attack3type, "zap", "electric", offense, defense, speed, health, new ArrayList<String> ( Arrays.asList ( "ground", "grass", "dragon" ) ), new ArrayList<String> ( Arrays.asList ( "flying", "steel", "electric" ) ) );
  
  }
    
}