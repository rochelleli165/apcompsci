package com.company;

public class Motor {
    public static void main(String[] args){
        int statue1positionx = 2;
        int statue1positiony = 1;
        int statue2positionx = 2;
        int statue2positiony = 5;
        AccelStepper LeftBackWheel(1, 42, 43);   // (Type:driver, STEP, DIR) - Stepper1
        AccelStepper LeftFrontWheel(1, 40, 41);  // Stepper2
        AccelStepper RightBackWheel(1, 44, 45);  // Stepper3
        AccelStepper RightFrontWheel(1, 46, 47); // Stepper4
        int wheelSpeed = 1500;
    if (playerinput = button1); //up

    if (playerinput = button2); //down

    if (playerinput = button3); //right

    if (playerinput = button4); //left
        if (statue1positionx > statue2positionx) {

        }

    }
    else {
        stopMoving();


    void moveForward() {
        LeftFrontWheel.setSpeed(wheelSpeed);
        LeftBackWheel.setSpeed(wheelSpeed);
        RightFrontWheel.setSpeed(wheelSpeed);
        RightBackWheel.setSpeed(wheelSpeed);
    }
    void moveBackward() {
        LeftFrontWheel.setSpeed(-wheelSpeed);
        LeftBackWheel.setSpeed(-wheelSpeed);
        RightFrontWheel.setSpeed(-wheelSpeed);
        RightBackWheel.setSpeed(-wheelSpeed);
    }
    void moveSidewaysRight() {
        LeftFrontWheel.setSpeed(wheelSpeed);
        LeftBackWheel.setSpeed(-wheelSpeed);
        RightFrontWheel.setSpeed(-wheelSpeed);
        RightBackWheel.setSpeed(wheelSpeed);
    }
    void moveSidewaysLeft() {
        LeftFrontWheel.setSpeed(-wheelSpeed);
        LeftBackWheel.setSpeed(wheelSpeed);
        RightFrontWheel.setSpeed(wheelSpeed);
        RightBackWheel.setSpeed(-wheelSpeed);


}
