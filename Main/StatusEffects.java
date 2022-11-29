package Main;

import java.util.ArrayList;
import java.util.Arrays;

public class StatusEffects {
    protected ArrayList<String> paralysis;
    protected ArrayList<String> burning;
    protected ArrayList<String> confusion;

    public StatusEffects () {
        this.paralysis = new ArrayList<String> ( Arrays.asList ( "zap" ) );
        this.burning = new ArrayList<String> ( Arrays.asList ( "ember" ) );
        this.confusion = new ArrayList<String> ( Arrays.asList ( "psychosis" ) );

    }

    public ArrayList<String> getParalysis () {
        return paralysis;

    }

    public ArrayList<String> getBurning () {
        return burning;

    }

    public ArrayList<String> getConfusion () {
        return confusion;

    }
    
}
