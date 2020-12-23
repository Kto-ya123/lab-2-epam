package com.company.port.dock;

import java.util.ArrayList;
import java.util.List;

public class DockCollection {
    private List<Dock> dockList;
    private Integer docksCount;
    private Integer dockIterator;

    public DockCollection(Integer dockCount){
        this.docksCount = dockCount;
        dockList = new ArrayList<>();
        dockIterator = 0;
        initializeDocks();
    }

    private void initializeDocks(){
        for(int i = 0; i < this.docksCount; i++){
            dockList.add(new Dock(i));
        }
    }

    public Dock getDock(){
        Dock dock = dockList.get(dockIterator++);

        if(dockIterator >= docksCount){
            dockIterator = 0;
        }

        return dock;
    }


}
