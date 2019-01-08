package org.isd300.ftc.ind.corey;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

/*

      Big ideas:
          * java is object oriented
          * a class represents an object
          * packages organize files hierarchically
          * variables can be class-scoped or method scoped.
          * variables can be declared only once within a scope
          * methods are actions. They may change variables; they may change behavior.
          *     They can organize a program so that it's easier to understand.
      TODO: Your assignments
      1) Make a method called stopRobot(). Replace the last action with a call to this method.
      2) Make a method called driveStraightByDistance(). Have it take power and inches as parameters. Replace the driveStraight calls.
      3) Make a method called turnByDegrees(). Have it take power and degrees as parameters. Replace the turn calls.
      4) Use your new methods to have the robot drive in a star pattern, always moving forwards.

      Note: / means divide. 144 / 12 will equal 12.
            * means multiply. 12 * 12 will equal 144.
            *


 */
@Autonomous(name="Coreybot", group="Corey")
public class Coreybot extends LinearOpMode {

    // this is the robot. Make sure you create a new instance, or you'll learn the lesson of the NullPointerException
    private TileRunnerBot totBot;

    // any time you need to perform some action for an amount of time, use this class-scoped timer.
    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        // create a robot instance
        this.totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);

        // wait for a user to push the start button
        this.waitForStart();

        // drive forward 10 feet
        boolean success = driveStraightByTime(0.5, 1000);

        // turn clockwise 90 degrees
        success = turnByTime(-0.5, 1130);

        // drive backward 10 feet
        success = driveStraightByTime(0.5, 1500);

        // turn counterclockwise 90 degrees
        success = turnByTime(0, 0);

        success = turnByTime(4.0, 500);

        // make sure the motors are really off. Just in case...
        this.totBot.drive(0,0,0,0);
    }

    private boolean driveStraightByTime(double power, int time) {

        // give power to the motors. Vroom!
        this.totBot.drive(power, power, power, power);

        // reset the timer so it's counting from 0
        this.timer.reset();

        // notice that we can escape this loop EITHER by the timer, or if someone pushes the stop button.
        // every loop must include the opModeIsActive call
        while (this.opModeIsActive() && this.timer.milliseconds() < time) {
            // do nothing until the timer has reached at least the time
        }

        // and stop the robot!
        this.totBot.drive(0,0,0,0);

        //true means success. What would false mean?
        return true;
    }

    /*
          This method is broken intentionally. Your challenge is to make it so that the robot actually turns.
     */
    private boolean turnByTime(double power, int time) {

        // give power to the motors. Vroom!
        this.totBot.drive(power, -power, power, -power);

        // reset the timer so it's counting from 0
        this.timer.reset();

        // notice that we can escape this loop EITHER by the timer, or if someone pushes the stop button.
        // every loop must include the opModeIsActive call
        while (this.opModeIsActive() && this.timer.milliseconds() < time) {
            // do nothing until the timer has reached at least the time
        }

        // and stop the robot!
        this.totBot.drive(0,0,0,0);

        //true means success. What would false mean?
        return true;
    }



}


