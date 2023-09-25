package app;

import java.util.ArrayList;
import java.util.Iterator;

public class MinMaxElevator extends Elevator {

    MinMaxElevator(int iMaxCapacity, int iMaxFloors, PeopleWaiting iPeopleWaiting){
        super(iMaxCapacity, iMaxFloors, iPeopleWaiting);
    }

    public String getMyElevatorName(){
        return "MinMax Elevator";
    }

    int getMaxPeopleWaitingStart(){
        int myMax = 0;
        
        for(int i=0; i<_PeopleWaiting.size();i++){
            myMax = Math.max(myMax ,_PeopleWaiting.get(i).start);
        }
        // System.out.println("getMaxPeopleWaitingStart: "+ myMax);
        return myMax;
    }

    int getMaxPeopleInLiftDestination(){
        int myMax = 0;
        
        for(int i=0; i<_PeopleInLift.size();i++){
            myMax = Math.max(myMax ,_PeopleInLift.get(i).destination);
        }
        // System.out.println("getMaxPeopleInLiftDestination: "+ myMax);
        return myMax;
    }
    int getMinPeopleInLiftDestination(){
        int myMin = _maxFloors;
        
        for(int i=0; i<_PeopleInLift.size();i++){
            myMin = Math.min(myMin ,_PeopleInLift.get(i).destination);
        }
        // System.out.println("getMinPeopleInLiftDestination: "+ myMin);
        return myMin;
    }
    int getMinPeopleWaitingStart(){
        int myMin = _maxFloors;
        
        for(int i=0; i<_PeopleWaiting.size();i++){
            myMin = Math.min(myMin ,_PeopleWaiting.get(i).start);
        }
        // System.out.println("getMinPeopleWaitingStart: "+ myMin);
        return myMin;
    }


    boolean isGoUpAtExtremitiesMinMax(){
        if (_currentFloor == Math.min(_maxFloors,Math.max(getMaxPeopleInLiftDestination(), getMaxPeopleWaitingStart()))) {
            // System.out.println("Change direction to go down"); 
            return false;            
        }

        if (_currentFloor <= Math.max(0,Math.min(getMinPeopleInLiftDestination(), getMinPeopleWaitingStart()))) {
            // System.out.println("Change direction to go up");
            return true;
        }

        return _isGoingUp; // no change
    }

    public void move(){

        commonMove();
        addPeopleStartingAtThisFloor();
        _isGoingUp = isGoUpAtExtremitiesMinMax();    
           
        
    }
}