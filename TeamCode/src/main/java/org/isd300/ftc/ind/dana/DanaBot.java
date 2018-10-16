package org.isd300.ftc.ind.dana;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="DanaBot", group="Dana")
public class DanaBot extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {
        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);
        this.waitForStart();

        timer.reset();
        //fl, fr, rl, rr
        totBot.drive(1, 1, 1, 1);
        while (timer.milliseconds() < 1000 && this.opModeIsActive()) {
        }

        timer.reset();
        //fl, fr, rl, rr
        totBot.drive(0, 0,0 , 0);
        while (timer.milliseconds() < 2000 && this.opModeIsActive()) {
        }

        timer.reset();
        //fl, fr, rl, rr
        totBot.drive(-.2, 1,-.2 , 1);
        while (timer.milliseconds() < 2000 && this.opModeIsActive()) {
        }





        totBot.drive(0, 0, 0, 0);

    }
}
