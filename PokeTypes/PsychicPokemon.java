package PokeTypes;
import java.util.ArrayList;
import java.util.Arrays;

import Main.Pokemon;

public class PsychicPokemon extends Pokemon {
  public PsychicPokemon ( String name, int level, String attack1, String attack1type, String attack3, String attack3type, int offense, int defense, int speed, int health ) {
    super ( name, level, "Psychic", attack1, attack1type, attack3, attack3type, "psychosis", "psychic", offense, defense, speed, health, new ArrayList<String> ( Arrays.asList("steel", "dark") ), new ArrayList<String> ( Arrays.asList("fighting", "psychic") ) );
  
  }
    
}