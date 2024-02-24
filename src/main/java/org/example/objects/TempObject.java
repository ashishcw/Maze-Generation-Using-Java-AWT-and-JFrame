package org.example.objects;

import org.example.constant.Constants;
import org.example.model.BaseModelDefinition;

import java.awt.*;

public class TempObject extends BaseModelDefinition {

    public TempObject() {
        this.setxPos(100);
        this.setyPos(100);
        this.setCol(1);
        this.setRow(1);
        this.setSizeWidth(Constants.NODE_SIZE/2);
        this.setSizeHeight(Constants.NODE_SIZE/2);
        this.setName("Node : Col - " + this.getCol() + " Row - " + this.getRow());
        this.setColor(Color.CYAN);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(this.getxPos(), this.getyPos(), this.getSizeWidth(), this.getSizeHeight());
    }

    @Override
    public void renderText(Graphics g) {

    }
}
