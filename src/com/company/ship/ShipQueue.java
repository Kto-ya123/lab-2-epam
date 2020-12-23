package com.company.ship;

import java.util.*;

public class ShipQueue {
    private Set<Ship> ships;

    public ShipQueue(){
        ships = new HashSet<>();
    }

    public void removeShip(Ship ship){
        ships.remove(ship);
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }

    public void print(){
        synchronized (System.out) {
            System.out.println("\n\n ++++++++++++++++++++++++++++  QUEUE  +++++++++++++++++++++++++++");
            for (Ship ship : ships) {
                System.out.println("Ship " + ship.getId());
            }
            System.out.println("++++++++++++++++++++++++++++  END QUEUE  +++++++++++++++++++++++++++\n\n");
        }
    }


}
