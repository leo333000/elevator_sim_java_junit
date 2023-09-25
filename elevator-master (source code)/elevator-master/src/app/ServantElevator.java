package app;

import java.util.ArrayList;
import java.util.Iterator;

public class ServantElevator extends Elevator {

    ServantElevator(int iMaxCapacity, int iMaxFloors, PeopleWaiting iPeopleWaiting){
        super(iMaxCapacity, iMaxFloors, iPeopleWaiting);
    }

    public String getMyElevatorName(){
        return "Servant Elevator";
    }

    public void move(){

        if(_PeopleInLift.size() == 0){
         _isGoingUp = !_isGoingUp;
         addPeopleStartingAtThisFloor();
         if(_PeopleInLift.size() == 0){
            _isGoingUp = !_isGoingUp;
         }
        }

        commonMove();
        _isGoingUp = isGoUpAtExtremities();        
        
    }
}