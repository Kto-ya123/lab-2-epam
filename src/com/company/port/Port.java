package com.company.port;

import com.company.port.dock.Dock;
import com.company.port.dock.DockCollection;
import com.company.ship.Ship;

public class Port {
    public static int COUNT_DOCKS = 4;
    private static Port instance;
    private final DockCollection dockCollection;

    private Port(Integer docksCount){
        dockCollection = new DockCollection(docksCount);
    }

    public static synchronized Port getInstance(){
        if(instance == null){
            instance = new Port(COUNT_DOCKS);
        }

        return instance;
    }

    public synchronized Dock getDock(){
        return dockCollection.getDock();
    }

    public synchronized void doSomeOne(Ship ship) throws InterruptedException {
        System.out.println("Ship " + ship.getId() + " is here");
        Thread.sleep(5000);
    }
}
