package org.example.handler;

import org.example.model.BaseModelDefinition;

import java.awt.*;
import java.util.ArrayList;

public class HandlerMain {
    public ArrayList<BaseModelDefinition> allObjectList = new ArrayList<BaseModelDefinition>();

    public void tick(){
        if(this.allObjectList.size() > 0){
            for(int i = 0; i < this.allObjectList.size(); i++){
                this.allObjectList.get(i).tick();
            }
        }
    }

    public void render(Graphics g){
        if(this.allObjectList.size() > 0){
            for(int i = 0; i < this.allObjectList.size(); i++){
                this.allObjectList.get(i).render(g);
            }
        }
    }

    public void renderText(Graphics g){
        if(this.allObjectList.size() > 0){
            for(int i = 0; i < this.allObjectList.size(); i++){
                this.allObjectList.get(i).renderText(g);
            }
        }
    }

    public void addObjectToList(BaseModelDefinition tempObject){
        if(tempObject != null){
            if(!this.allObjectList.contains(tempObject)){
                this.allObjectList.add(tempObject);
            }
        }
    }

    public void removeObjectFromList(BaseModelDefinition tempObject){
        if(tempObject != null){
            if(this.allObjectList.contains(tempObject)){
                this.allObjectList.remove(tempObject);
            }
        }
    }
}
