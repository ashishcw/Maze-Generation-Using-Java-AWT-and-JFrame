package org.example.objects.node;

import netscape.javascript.JSObject;
import org.example.constant.Constants;
import org.example.model.BaseModelDefinition;

import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class Node extends BaseModelDefinition {

    public static Node[][] nodes = new Node[Constants.MAX_ROWS][Constants.MAX_COLS];
    public static Node StartNode, EndNode;

    private int fCost;

    private boolean isNodeVisited = false;

    private Node parentNode;

    public Map<String, Boolean> wallsDictionary = new Hashtable<>();


    public enum NodeType{
        start,
        end,
        block,
        path,
        wall,
        none
    }
    public NodeType nodeType = NodeType.none;

    public Node(int xPosParam, int yPosParam, int colParam, int rowParam, NodeType nodeTypeParam) {
        this.setxPos(xPosParam);
        this.setyPos(yPosParam);
        this.setCol(colParam);
        this.setRow(rowParam);
        this.setSizeWidth(Constants.NODE_SIZE);
        this.setSizeHeight(Constants.NODE_SIZE);
        this.setName("Node : Col - " + this.getCol() + " Row - " + this.getRow());
        this.setNodeType(nodeTypeParam);
        this.setfCost(999);
        this.setNodeVisited(false);
        this.setParentNode(null);
        this.wallsDictionary.put("Top",true);
        this.wallsDictionary.put("Right",true);
        this.wallsDictionary.put("Bottom",true);
        this.wallsDictionary.put("Left",true);
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        nodeColorScheme();

        g.setColor(this.getColor());

//        if(
//                this.getNodeType() == NodeType.start
//                        ||
//                        this.getNodeType() == NodeType.end
//                        ||
//                        this.getNodeType() == NodeType.block
//                        ||
//                        this.getNodeType() == NodeType.wall
//        ){
//            g.fillRect(this.getxPos(), this.getyPos(), this.getSizeWidth(), this.getSizeHeight());
//        }else{
//            g.drawRect(this.getxPos(), this.getyPos(), this.getSizeWidth(), this.getSizeHeight());
//        }

//        int x1 = 50;
//        int y1 = 50;
//        int x2 = 150;
//        int y2 = 50;
//        int x3 = 150;
//        int y3 = 150;
//        int x4 = 50;
//        int y4 = 150;

        int x1 = this.getxPos();
        int y1 = this.getyPos();
        int x2 = this.getxPos() + this.getSizeWidth();
        int y2 = this.getyPos();
        int x3 = this.getxPos() + this.getSizeWidth();
        int y3 = this.getyPos() + this.getSizeHeight();
        int x4 = this.getxPos();
        int y4 = this.getyPos() + this.getSizeHeight();






        if(this.wallsDictionary.get("Top")){
            g.drawLine(x1, y1, x2, y2);
        }

        if(this.wallsDictionary.get("Right")){
            g.drawLine(x2, y2, x3, y3);
        }

        if(this.wallsDictionary.get("Bottom")){
            g.drawLine(x3, y3, x4, y4);
        }

        if(this.wallsDictionary.get("Left")){
            g.drawLine(x4, y4, x1, y1);
        }


    }

    @Override
    public void renderText(Graphics g) {

    }

    public int getfCost() {
        return fCost;
    }

    public void setfCost(int fCost) {
        this.fCost = fCost;
    }

    public boolean isNodeVisited() {
        return isNodeVisited;
    }

    public void setNodeVisited(boolean nodeVisited) {
        isNodeVisited = nodeVisited;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public Map<String, Boolean> getWallsDictionary() {
        return wallsDictionary;
    }

    private void nodeColorScheme(){
        if(this.getNodeType() == NodeType.start){
            //this.setColor(Color.YELLOW);
        }

        if(this.getNodeType() == NodeType.end){
            //this.setColor(Color.GREEN);
        }

        if(this.getNodeType() == NodeType.block){
            this.setColor(Color.RED);
        }

        if(this.getNodeType() == NodeType.path){
            this.setColor(Color.PINK);
        }

        if(this.getNodeType() == NodeType.none){
            this.setColor(Color.MAGENTA);
        }

        if(this.getNodeType() == NodeType.wall){
            this.setColor(Color.ORANGE);
        }
    }


    public static void createNodeGrid(){
        for(int i = 0; i < Constants.MAX_ROWS; i++){
            for(int j = 0; j < Constants.MAX_COLS; j++){
                nodes[j][i] = new Node(
                        j * Constants.NODE_OFFSET,
                        i * Constants.NODE_OFFSET,
                        j,
                        i,
                        NodeType.none
                );

                if(i == 0 && j == 0){
                    nodes[j][i].setNodeType(NodeType.start);
                    StartNode = nodes[j][i];
                }else{
                    if(i == Constants.MAX_ROWS-1 && j == Constants.MAX_COLS-1){
                        nodes[j][i].setNodeType(NodeType.end);
                        nodes[j][i].setfCost(0);
                        EndNode = nodes[j][i];
                    }
                }


            }
        }

    }


}
