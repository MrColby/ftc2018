package org.isd300.ftc.ind.colby;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="ColbyBasicBot", group="Colby")
public class ColbyBasicBot extends LinearOpMode {

    // this is the robot. Make sure you create a new instance, or you'll learn the lesson of the NullPointerException
    private TileRunnerBot totBot;

    // any time you need to perform some action for an amount of time, use this class-scoped timer.
    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        // create a robot instance
        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);

        // wait for a user to push the start button
        this.waitForStart();

        //this.run1();

        this.pause(1000);

        this.run2();







    }

    private void pause(int millis) {
        this.timer.reset();
        while (this.timer.milliseconds() < millis) {
            // do nothing
        }

    }

    private void run1() {
        // drive straight
        totBot.drive(0.5, 0.5, 0.5, 0.5);

        this.timer.reset();
        while (this.timer.milliseconds() < 1000) {
            // do nothing
        }

        totBot.drive(0.0, 0.0, 0.0, 0.0);
    }

    public void run2() {
        //
        totBot.drive(0.5, -0.5, 0.5, -0.5);

        this.timer.reset();
        while (this.timer.milliseconds() < 1000) {
            // do nothing
        }

        totBot.drive(0.0, 0.0, 0.0, 0.0);
    }






}
