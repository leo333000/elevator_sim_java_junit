package app;

import java.util.ArrayList;

public class PeopleWaiting extends ArrayList<Person> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    PeopleWaiting() {
        super();
    }

    String toDisplayString(int iFloor) {

        String aDisplayString = new String(Integer.toString(iFloor) + "# ");
        for (int i = 0; i < size(); i++){
            if (get(i).start == iFloor){
                aDisplayString += (iFloor < get(i).destination) ? "U" : "D";
                aDisplayString += get(i).destination + ",";
            }            
        }
        aDisplayString = aDisplayString.substring(0,aDisplayString.length() -1);

        aDisplayString += " #  ";
        return aDisplayString;
    }

}