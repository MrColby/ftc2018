package org.isd300.ftc.team;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TotBotDriver", group="team")
public class TotBotDriver extends LinearOpMode {

    private TotBot totBot;
    public void runOpMode() throws InterruptedException {

        totBot = new TotBot(this.hardwareMap,this.telemetry);

        this.waitForStart();
        while (this.opModeIsActive()) {
            drive();

        }
        totBot.drive(0, 0);
    }private void drive(){

        double right = this.gamepad1.right_stick_y;
        double left = this.gamepad1.left_stick_y;

        totBot.drive(left, right);
    }




}
