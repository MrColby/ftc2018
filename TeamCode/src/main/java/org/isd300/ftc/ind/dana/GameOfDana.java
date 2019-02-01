package org.isd300.ftc.ind.dana;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Random;

@TeleOp(name= "GameOfDana", group= "games")
public class GameOfDana extends LinearOpMode {


    public static final int B = 3;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int A = 2;

            public static final String [] BUTTON_NAMES = {"X", "Y", "A", "B"};

    public ElapsedTime timer = new ElapsedTime();
    public Random random = new Random();

    public void runOpMode() {

        this.waitForStart();

       int choice = getRandomButton();
       String buttonName = getButtonName (choice);
        displayMessage ("The random button is " + buttonName);

        while (this.opModeIsActive ()) {

        }
    }

    private String getButtonName (int button) {
        return BUTTON_NAMES[button];


    }


    private void displayMessage(String msg) {
        this.telemetry.addData("", msg);
        this.telemetry.update();
    }
    private int getRandomButton() {
        int i = random.nextInt(4);
        return i;
    }
}


