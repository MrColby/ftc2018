package org.isd300.ftc.ind.dana;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="DanaColorTest", group="Dana")

public class DanaBot01 extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);

        this.waitForStart();



        while(this.opModeIsActive()) {
            totBot.getEyestalkColor();
        }



        totBot.drive(0, 0, 0, 0);


    }
}
