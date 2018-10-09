package org.isd300.ftc.tilerunner;





        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by whiar on 12/3/2017.
 */
@TeleOp(name="TileRunnerDriver", group="tilerunner")
public class TileRunnerDriver extends LinearOpMode {

    private TileRunnerBot totBot;

    @Override
    public void runOpMode() throws InterruptedException {

        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);

        this.waitForStart();
        while (this.opModeIsActive()) {
            drive();

        }
        totBot.drive(0, 0, 0, 0);
    }




    private void drive(){

        double forward = -1 * this.gamepad1.right_stick_y;
        double right = this.gamepad1.right_stick_x;
        double clockwise = this.gamepad1.left_stick_x;

        double frontLeft = forward + clockwise + right;
        double frontRight = forward - clockwise - right;
        double rearLeft = forward + clockwise - right;
        double rearRight = forward - clockwise + right;

        /*

        double frontLeft;
        double frontRight;
        double rearLeft;
        double rearRight;
        if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.right_stick_y) && Math.abs(gamepad1.right_stick_x) > Math.abs(this.gamepad1.left_stick_x)) {
            //straight = false;
            frontLeft = gamepad1.right_stick_x;
            rearRight = gamepad1.right_stick_x;
            frontRight = -gamepad1.right_stick_x;
            rearLeft = -gamepad1.right_stick_x;

        }
        else if (Math.abs(gamepad1.right_stick_y) > Math.abs(gamepad1.right_stick_x) && Math.abs(gamepad1.right_stick_y) > Math.abs(this.gamepad1.left_stick_x)){
            frontLeft = -gamepad1.right_stick_x;
            rearRight = -gamepad1.right_stick_x;
            frontRight = -gamepad1.right_stick_x;
            rearLeft = -gamepad1.right_stick_x;
        }
        else {
            frontLeft = gamepad1.left_stick_x;
            rearRight = -gamepad1.left_stick_x;
            frontRight = -gamepad1.left_stick_x;
            rearLeft = gamepad1.left_stick_x;
        }

        */



        totBot.drive(frontLeft, frontRight, rearLeft, rearRight);
    }



}

