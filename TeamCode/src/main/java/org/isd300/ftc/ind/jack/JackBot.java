package org.isd300.ftc.ind.jack;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;



@Autonomous(name="JackBot", group="Jack")

public class JackBot extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);

        this.waitForStart();

        //fl, fr, rl, rr
        totBot.drive(100, -100, 100, -100);
        timer.reset();
        while(timer.milliseconds()<3000 && this.opModeIsActive()) {
        }



        totBot.drive(0, 0, 0, 0);


    }
}
