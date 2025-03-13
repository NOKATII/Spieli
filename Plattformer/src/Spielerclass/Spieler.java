package Spielerclass;

public class Spieler {
    float xPos;
    float yPos;
    int wand;
    int width;
    int height;
    Boolean isJumping = false;



    public Spieler (int xPos, int yPos, int wand, int width, int height){
        this.xPos = xPos;
        this.yPos = yPos;
        this.wand = wand;
        this.width = width;
        this.height = height;
    }
    public float getxPos() {
        return this.xPos;
    }

    public float getyPos() {
        return this.yPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public void moveRight(){
        if (this.xPos < wand-width){
            this.xPos += 10;
        }
    }
    public void moveLeft(){
        if (this.xPos >= 10){
            this.xPos -= 10;
        }
    }
    public void moveUp(){
        if (this.yPos >0){
            this.yPos -= 10;
        }
    }

    //
    public void moveDown(float distance ){
        if (this.yPos <= 400 - height - distance){
            this.yPos += distance;
        }
        else this.yPos = 400 - height;
    }

    public boolean inAir(){
       return this.yPos < 400 - height;
    }



    //Umsetzen, aber wie ? Zukunfts Tom Problem
    public void jumping(){}
}
