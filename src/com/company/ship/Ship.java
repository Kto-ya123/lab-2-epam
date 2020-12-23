package com.company.ship;

import com.company.port.dock.Dock;
import com.company.port.Port;

import java.util.Random;

public class Ship extends Thread {
    private long id;
    private Port port;
    private boolean filled;
    private ShipQueue shipQueue;

    public Port getPort() {
        return port;
    }

    public Ship(Integer id, ShipQueue shipQueue){
        this.id = id;
        this.shipQueue = shipQueue;
        filled = false;
    }

    public long getId() {
        return id;
    }

    @Override
    public void run() {
        port = Port.getInstance();
        Random random = new Random();
        while(true){
            try {
                shipQueue.addShip(this);
                showLoadUnload();
                Dock dock = port.getDock();

                System.out.println("Ship " + getId() + " wait for " + dock.getId() + " dock");
                synchronized (dock){
                    shipQueue.removeShip(this);
                    shipQueue.print();
                    System.out.println("Ship " + getId() + " start with " + dock.getId() + " dock");
                    sleep(random.nextInt(9000) + 1000);
                }
                System.out.println("Ship " + getId() + " end with " + dock.getId() + " dock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showLoadUnload(){
        if(filled){
            System.out.println("Ship " + getId() + " want to unload");
        }else {
            System.out.println("Ship " + getId() + " want to load");
        }
        filled = !filled;
    }


}
