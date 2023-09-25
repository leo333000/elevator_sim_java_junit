package app;

import java.util.ArrayList;
import java.util.Iterator;

public class MechanicalElevator extends Elevator {

    MechanicalElevator(int iMaxCapacity, int iMaxFloors, PeopleWaiting iPeopleWaiting){
        super(iMaxCapacity, iMaxFloors, iPeopleWaiting);
    }

    public String getMyElevatorName(){
        return "Mechanical Elevator";
    }

    public void move(){
        
        commonMove();
        _isGoingUp = isGoUpAtExtremities();             
    }

    

}