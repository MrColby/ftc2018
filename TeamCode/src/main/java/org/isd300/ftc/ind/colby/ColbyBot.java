package org.isd300.ftc.ind.colby;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="KamiBot", group="Kami")

public class ColbyBot extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        // create a robot instance
        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);

        // wait for a user to push the start button
        this.waitForStart();

        // start driving

        // drive to target #1

        // if 1 is right, celebrate and stop
        // else drive to target #2
        // if 2 is right, celebrate and stop
        // else drive to target #3

        boolean yellow = checkOutTargetOne();
        if (yellow) {
            // do a happy dance
        }
        else {
            yellow = checkOutTargetTwo();
            /*if (yellow) {
                // do a happy dance
            }
            else {
                yellow = checkOutTargetThree();
            }*/
        }

    }

    private boolean checkOutTargetOne() {

        // check distance
        // if close, stop motors, check color
        // if wrong color, return false
        // if right color, return true
        return false;


    }

    private boolean checkOutTargetTwo() {

        // check distance
        // if close, stop motors, check color
        // if wrong color, return false
        // if right color, return true
        return false;


    }

    private boolean checkOutTargetThree() {

        // check distance
        // if close, stop motors, check color
        // if wrong color, return false
        // if right color, return true
        return false;


    }

}
