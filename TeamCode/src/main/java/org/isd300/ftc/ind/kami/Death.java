package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Random;

@TeleOp(name="Death", group="games")
public class Death extends LinearOpMode {

    public ElapsedTime timer = new ElapsedTime();
    public Random random = new Random();

    private static int A = 0;
    private static int B = 1;
    private static int X = 2;
    private static int Y = 3;

    private String [] buttons = {"A", "B", "X", "Y"};

    public void runOpMode() {

        this.waitForStart();



        while (this.opModeIsActive()) {

            int buttonToPress = getRandomButton();

            displayMessage("Press " + this.buttons[buttonToPress]);

            int buttonPressed = this.waitForAndGetButtonPress();








        }

    }

    private int waitForAndGetButtonPress() {
        int buttonPressed = -1;
        while (this.opModeIsActive() && buttonPressed == -1) {
            if (this.gamepad1.a) {
                buttonPressed = A;
            }
            else if (this.gamepad1.b) {
                buttonPressed = B;
            }
            else if (this.gamepad1.x) {
                buttonPressed = X;
            }
            else if (this.gamepad1.y) {
                buttonPressed = Y;
            }
        }
        return buttonPressed;
    }

    private int getRandomButton() {
        int i = random.nextInt(4);
        return i;
    }

    private void displayMessage(String msg) {
        this.telemetry.addData("", msg);
        this.telemetry.update();
    }

}
