package app;

import java.util.ArrayList;
import java.util.Iterator;

public class DemocraticElevator extends Elevator {

    DemocraticElevator(int iMaxCapacity, int iMaxFloors, PeopleWaiting iPeopleWaiting){
        super(iMaxCapacity, iMaxFloors, iPeopleWaiting);
    }

    public String getMyElevatorName(){
        return "Democratic Elevator";
    }

    public void move(){
        // System.out.println(_currentFloor);
        int wantsToGoUp = 0;
        int wantsToGoDown = 0;
        Iterator<Person> aInLift = _PeopleInLift.iterator();
        while (aInLift.hasNext()) {
            Person aPerson = aInLift.next();
            if (aPerson.destination > _currentFloor){
                wantsToGoUp++;            
            } else {
                wantsToGoDown++;
            } 
        }
        
        if (wantsToGoUp > wantsToGoDown){
            System.out.println("Democratic Change direction to go up");
            _isGoingUp = true;
        }
        if (wantsToGoUp < wantsToGoDown){
            System.out.println("Democratic Change direction to go down");
            _isGoingUp = false;
        }

        commonMove();
        _isGoingUp = isGoUpAtExtremities();
        _distance += 1;
    }
}