package Spielerclass;

public class Spieler {
    int xPos;
    int yPos;
    int wand;
    int width;


    public Spieler (int xPos, int yPos, int wand, int width){
        this.xPos = xPos;
        this.yPos = yPos;
        this.wand = wand;
        this.width = width;

    }
    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void moveRight(){
        if (this.xPos < wand-width){
            this.xPos += 10;
        }
    }
    public void moveLeft(){
        if (this.xPos > 0){
            this.xPos -= 10;
        }
    }
    public void moveUp(){
        if (this.yPos >0){
            this.yPos -= 10;
        }
    }
}
