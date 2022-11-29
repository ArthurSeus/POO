package PokeTypes;
import java.util.ArrayList;
import java.util.Arrays;

import Main.Pokemon;

public class GrassPokemon extends Pokemon {
  public GrassPokemon ( String name, int level, String attack1, String attack1type, String attack3, String attack3type, int offense, int defense, int speed, int health ) {
    super ( name, level, "grass", attack1, attack1type, attack3, attack3type, "leafblade", "grass", offense, defense, speed, health, new ArrayList<String> ( Arrays.asList ( "fire", "flying", "bug", "poison", "steel", "dragon") ), new ArrayList<String> ( Arrays.asList ( "water", "rock", "ground", "grass" ) ) );
  
  }
    
}