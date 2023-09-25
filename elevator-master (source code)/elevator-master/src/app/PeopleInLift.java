package app;

import java.util.ArrayList;

public class PeopleInLift extends ArrayList<Person> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    PeopleInLift() {
        super();
    }

    String toDisplayString(int iCurrentFloor, boolean iGoingUp) {

        String aDisplayString = new String("# ");
        for (int i = 0; i < size(); i++){
            String aDestinationIndicator = new String("-");
            if (iCurrentFloor < get(i).destination){
                aDestinationIndicator = "U";
            }
            if (iCurrentFloor > get(i).destination){
                aDestinationIndicator = "D";
            }

            aDisplayString += aDestinationIndicator;
            aDisplayString += get(i).destination + ",";
        }
        aDisplayString = aDisplayString.substring(0,aDisplayString.length() -1);

        aDisplayString += " #  ";
        aDisplayString += (iGoingUp ? "/\\" : "\\/");
        return aDisplayString;
    }

}