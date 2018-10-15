package org.isd300.ftc.ind.izaak;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="IzaakBot", group="Izaak")

public class IzaakTheBestCoder extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);

        this.waitForStart();

        totBot.drive(10, 10, 10, 10);
        timer.reset();
        while(timer.milliseconds()<1000 && this.opModeIsActive()) {
        }

        //fl, fr, rl, rr
        totBot.drive(0, 100, 0, 100);
        timer.reset();
        while(timer.milliseconds()<2500 && this.opModeIsActive()) {
        }

        totBot.drive(100, 0, 100, 0);
        timer.reset();
        while(timer.milliseconds()<1000 && this.opModeIsActive()) {
        }

        totBot.drive(0, 100, 0, 100);
        timer.reset();
        while(timer.milliseconds()<1575 && this.opModeIsActive()) {
        }

        totBot.drive(100, 100, 100, 100);
        timer.reset();
        while(timer.milliseconds()<750 && this.opModeIsActive()) {
        }
        totBot.drive(75, -75, 75, -75);
        timer.reset();
        while(timer.milliseconds()<400 && this.opModeIsActive()) {
        }
        totBot.drive(0, 100, 0, 100);
        timer.reset();
        while(timer.milliseconds()<700 && this.opModeIsActive()) {
        }

        totBot.drive(0, 0, 0, 0);


    }
}
