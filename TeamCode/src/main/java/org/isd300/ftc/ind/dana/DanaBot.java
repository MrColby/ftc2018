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

        this.waitForStart();

        timer.reset();

        totBot.drive(100, 100, 0, 0);

        while (timer.milliseconds() < 3000 && this.opModeIsActive()) {

        }





        totBot.drive(0, 0, 0, 0);

    }
}
