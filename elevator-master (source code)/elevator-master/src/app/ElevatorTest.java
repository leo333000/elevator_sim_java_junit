package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
// import java.util.List;

import org.junit.jupiter.api.Test;

class ElevatorTest {
    
    PeopleWaiting _peopleWaiting = new PeopleWaiting();

    int getDestinationDifferentFromStart(int aMaxFloors, int start){
        int uniqueDestination =  (int) (Math.random() * (aMaxFloors));
        while (uniqueDestination == start){
            uniqueDestination = (int) (Math.random() * (aMaxFloors));
        }
        return uniqueDestination;
    }

// TESTS    

    @Test
    void shouldDoNothingIfNoPeopleWaiting() {        
        MechanicalElevator aOldElevator = new MechanicalElevator(10,10,_peopleWaiting);       
        assertEquals(0, aOldElevator.getDistance());
    }

    @Test
    void shouldMoveOneIfOnePersonFromZeroToFirstFloor() {   
        _peopleWaiting.add(new Person(0,1));
        MechanicalElevator aOldElevator = new MechanicalElevator(1,2,_peopleWaiting);         
        assertEquals(1, aOldElevator.getDistance());
    }

    @Test
    void shouldMoveTwoIfOnePersonFromFirstToSecondFloor() {  
        _peopleWaiting.add(new Person(1,2)); 
        MechanicalElevator aOldElevator = new MechanicalElevator(1,2,_peopleWaiting);  
        assertEquals(2, aOldElevator.getDistance());
    }

    @Test
    void shouldMoveUpAndDownWithOnePersonFromFirstToZero() {  
        _peopleWaiting.add(new Person(1,0)); 
        MechanicalElevator aOldElevator = new MechanicalElevator(1,2,_peopleWaiting);                          
        assertEquals(4, aOldElevator.getDistance());
    }

    @Test
    void shouldMoveUpAndDownWithTwoPersonOneGoingUpOneGoingDown() { 
        _peopleWaiting.add(new Person(0,1));
        _peopleWaiting.add(new Person(1,0));  
        MechanicalElevator aOldElevator = new MechanicalElevator(1,2,_peopleWaiting);            
        assertEquals(4, aOldElevator.getDistance());
    }

    @Test
    void shouldRespectLiftCapacityOfOne() {   
        _peopleWaiting.add(new Person(0,1));
        _peopleWaiting.add(new Person(0,2));
        MechanicalElevator aOldElevator = new MechanicalElevator(1,2,_peopleWaiting);  
        assertEquals(6, aOldElevator.getDistance());
    }

    @Test
    void shouldAllowTwoPeopleInLift() {   
        _peopleWaiting.add(new Person(0,1));
        _peopleWaiting.add(new Person(0,2));
        MechanicalElevator aOldElevator = new MechanicalElevator(2,2,_peopleWaiting);  
        assertEquals(2, aOldElevator.getDistance());
    }

    @Test
    void shouldAssumePeopleDontEnterLiftIfGoingWrongDirection() {   
        _peopleWaiting.add(new Person(1,0));
        _peopleWaiting.add(new Person(1,2));
        MechanicalElevator aOldElevator = new MechanicalElevator(1,2,_peopleWaiting);  
        assertEquals(4, aOldElevator.getDistance());
    }

    @Test
    void shouldPickUpPeopleOnTopFloor() {   
        _peopleWaiting.add(new Person(2,0));        
        MechanicalElevator aOldElevator = new MechanicalElevator(1,2,_peopleWaiting);  
        assertEquals(4, aOldElevator.getDistance());
    }

    @Test
    void shouldCheckPeopleHaveValidDestination() {   
        _peopleWaiting.add(new Person(0,2));
        MechanicalElevator aOldElevator = new MechanicalElevator(1,1,_peopleWaiting);          
        assertEquals(0, aOldElevator.getDistance());
    }



    @Test
    void shouldGetAverageForRamdomTest() { 
        
        int aOverallAverageForMinMax = 0;
        int aOverallAverageForMechanical = 0;
        int aNumberOfExecutions = 100;
        int aMaxFloors = 10;
                         
        for(int j=0; j<aNumberOfExecutions ; j++){
            PeopleWaiting aPeopleWaitingForMinMax = new PeopleWaiting();
            PeopleWaiting aPeopleWaitingForMechanical = new PeopleWaiting();
            Elevator aMinMaxElevator = new MinMaxElevator(10,aMaxFloors,aPeopleWaitingForMinMax);
            Elevator aMechanicalElevator = new MechanicalElevator(10,aMaxFloors,aPeopleWaitingForMechanical);

            int aNumberOfPeopleWaiting = 100;
            for(int i=0; i<aNumberOfPeopleWaiting ; i++){
                int aStart = (int) (Math.random() * (aMaxFloors));
                int aDestination = getDestinationDifferentFromStart(aMaxFloors,aStart);
                aPeopleWaitingForMinMax.add(new Person(aStart,aDestination));
                aPeopleWaitingForMechanical.add(new Person(aStart,aDestination));
            }    
            int aDistanceForMinMax = aMinMaxElevator.getDistance();
            if (aDistanceForMinMax ==1000000){
                break;
            }


            int aDistanceForMechanical = aMechanicalElevator.getDistance();


            System.out.println("Total Distance  [" + j + "]  for the minmax lift is " + aDistanceForMinMax);
            System.out.println("Total Distance  [" + j + "]  for the mechanical lift is " + aDistanceForMechanical);
            
            aOverallAverageForMinMax += aDistanceForMinMax;
            aOverallAverageForMechanical += aDistanceForMechanical;
        }

        aOverallAverageForMinMax = (int) aOverallAverageForMinMax / aNumberOfExecutions;
        aOverallAverageForMechanical = (int) aOverallAverageForMechanical / aNumberOfExecutions;

        System.out.println("Average Distance for MinMax after [" + aNumberOfExecutions + "] executions [" + aOverallAverageForMinMax + "]" );
        System.out.println("Average Distance for Mechanical after [" + aNumberOfExecutions + "] executions [" + aOverallAverageForMechanical + "]" );

    }


    @Test
    void shouldGoUpIfMorePeopleWantToGoUp() {   
        _peopleWaiting.add(new Person(1,0));
        _peopleWaiting.add(new Person(1,2));
        _peopleWaiting.add(new Person(1,2));
        DemocraticElevator aElevator = new DemocraticElevator(10,2,_peopleWaiting);  
        assertEquals(8, aElevator.getDistance());
    }

    
    @Test
    void testIdea() {   
        _peopleWaiting.add(new Person(1,0));
        ServantElevator aElevator = new ServantElevator(10,10,_peopleWaiting);   
        assertEquals(2, aElevator.getDistance());
    }

    @Test
    void MinMaxtestToSeeIfItsWorking() {   
        _peopleWaiting.add(new Person(1,4));
        _peopleWaiting.add(new Person(4,1));
        _peopleWaiting.add(new Person(1,4));
        Elevator aElevator = new MinMaxElevator(1,5,_peopleWaiting);   
        assertEquals(2, aElevator.getDistance());
    }




}



