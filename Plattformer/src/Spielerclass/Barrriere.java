package Spielerclass;

public class Barrriere {
    int xPos_barr;
    int yPos_barr;
    int width_barr;
    int height_barr;
    int fieldWidth;
    int speed;


    public Barrriere (int xPos_barr, int yPos_barr, int width_barr, int height_barr, int fieldWidth, int speed){
        this.xPos_barr = xPos_barr;
        this.yPos_barr = yPos_barr;
        this.width_barr = width_barr;
        this.height_barr = height_barr;
        this.fieldWidth = fieldWidth;
        this.speed = speed;
    }

    public int getxPos_barr() {
        return xPos_barr;
    }

    public int getyPos_barr() {
        return yPos_barr;
    }

    public int getHeight_barr() {
        return height_barr;
    }

    public int getWidth_barr() {
        return width_barr;
    }


    //Bewegung der Barrieren
    public void moveLeft (){
        if (xPos_barr + width_barr > 0){
            xPos_barr -= speed;
        } else xPos_barr = fieldWidth;
    }
    public void moveRight (){
        if (xPos_barr < fieldWidth){
            xPos_barr += speed;
        } else xPos_barr = -width_barr;
    }
}

