package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="KamiBot", group="Kami")
public class KamiBot extends LinearOpMode {

    // this is the robot. Make sure you create a new instance, or you'll learn the lesson of the NullPointerException
    private TileRunnerBot totBot;

    // any time you need to perform some action for an amount of time, use this class-scoped timer.
    private ElapsedTime timer = new ElapsedTime();

    // declare these variables at the class scope. That means that every method can read them.
    // make them private so that only this class can interact with them.
    private double distance = Double.NaN;
    private int red = 0;
    private int green = 0;
    private int blue = 0;

    public void runOpMode() {

        // create a robot instance
        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);

        // wait for a user to push the start button
        this.waitForStart();



        // if 1 is right, celebrate and knock over the target. Drive to base.
        // else drive to target #2
        // if 2 is right, celebrate and knock over the target. Drive to base.
        // else drive to target #3. If 3 is right, celebrate and knock over the target.
        // drive to base

        boolean yellow = checkOutTargetOne();
        if (yellow) {
            totBot.drive(0.125, 0.125, 0.125, 0.125);
            this.timer.reset();
            while (this.opModeIsActive() && this.timer.milliseconds() < 3000) {

            }
        }
        else {
            if (yellow) {
                // knock over the target. Drive to base.
            }
            else {
                yellow = checkOutTargetThree();
                if (yellow) {
                    // knock over the target
                }
                // drive to base
            }
        }

        // make sure we're stopped
        totBot.drive(0.0, 0.0, 0.0, 0.0);

    }

    private boolean checkOutTargetOne() {

        // start driving.
        // frontLeft, frontRight, rearLeft, rearRight
        totBot.drive(0.125, 0.125, 0.125, 0.125);

        while (this.opModeIsActive() && Double.isNaN(this.distance)) {
            this.timer.reset();
            while (timer.milliseconds()< 250) {
                }
            readColorSensor(DistanceUnit.CM);

        }

        // drive to target #1. Add turns, etc.
        // This is not sensor driving.
        // reset the timer, and then do nothing for 3 seconds


        // notice that we can escape this loop EITHER by the timer, or if someone pushes the stop button.
        // every loop must include the opModeIsActive call
        // add turns, etc, so that we are lined up with the target.



        // this gets a current reading of distance and three primary colors


        //if (distance > 2) {
            //totBot.drive(0, 0, 0, 0);
        //}

        //else{
            //totBot.drive(0.125,0.125,0.125,0.125);
    }
        // drive until we're close enough to get a measurement


        // now drive until we're at the distance that we want
        //while (this.opModeIsActive() && distance > 10) {
            //readColorSensor(DistanceUnit.CM);


        // we're there. Switch off the motors.
        totBot.drive(0.0, 0.0, 0.0, 0.0);

        // if wrong color, return false
        // if right color, return true
        //return false;


    }


    private boolean checkOutTargetTwo() {


        return false;


    }

    private boolean checkOutTargetThree() {


        return false;


    }

    private void readColorSensor(DistanceUnit distanceUnit) {
        distance = this.totBot.getDistance(distanceUnit);
        red = this.totBot.getRed();
        green = this.totBot.getGreen();
        blue = this.totBot.getBlue();
        String msg = "Red: " + red + " Green: " + green + " Blue: " + blue + " Distance: " + distance;
        this.totBot.message("", msg);
    }




}
