package org.isd300.ftc.ind.max;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="MaxBot", group="Max")

public class MaxBot extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);

        this.waitForStart();

        //fl, fr, rl, rr
        totBot.drive(1, 1, 1, 1);
        timer.reset();
        while(timer.milliseconds()<500 && this.opModeIsActive()) {
        }

        timer.reset();
        while(timer.milliseconds()<1000 && this.opModeIsActive()) {
        }

        //fl, fr, rl, rr
        totBot.drive(-1, -1, -1, -1);
        timer.reset();
        while(timer.milliseconds()<500 && this.opModeIsActive()) {
        }



        totBot.drive(0, 0, 0, 0);


    }
}
