package app;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PeopleWaitingTest {
 
    @Test
    void shouldDisplayPeopleWaiting() {        
        PeopleWaiting aPeopleWaiting = new PeopleWaiting(); 
        
        aPeopleWaiting.add(new Person(2,3));
        aPeopleWaiting.add(new Person(2,5));
        aPeopleWaiting.add(new Person(2,1));

        int aFloor = 2;

        assertEquals("2# U3,U5,D1 #  ",aPeopleWaiting.toDisplayString(aFloor) );
    }

}    