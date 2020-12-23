package com.company;

import com.company.ship.Ship;
import com.company.ship.ShipQueue;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ShipQueue shipQueue = new ShipQueue();
        List<Ship> shipList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            shipList.add(new Ship(i, shipQueue));
        }

        shipList.forEach(Ship::start);
    }
}
