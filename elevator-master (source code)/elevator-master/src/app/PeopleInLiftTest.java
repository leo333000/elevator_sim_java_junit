package app;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PeopleInLiftTest {
 

    @Test
    void shouldDisplayPeopleInLift() {        
        PeopleInLift aPeopleInLift = new PeopleInLift(); 
        
        aPeopleInLift.add(new Person(2,3));
        aPeopleInLift.add(new Person(2,5));
        aPeopleInLift.add(new Person(2,1));

        int aCurrentFloor = 2;
        boolean aGoingUp = true;

        assertEquals("# U3,U5,D1 #  /\\",aPeopleInLift.toDisplayString(aCurrentFloor,aGoingUp) );
    }

}    