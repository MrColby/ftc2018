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

        totBot.drive(100, 100, 100, 100);
        timer.reset();
        while(timer.milliseconds()<3000 && this.opModeIsActive()) {
        }

        //fl, fr, rl, rr
        totBot.drive(100, 0, 100, 0);
        timer.reset();
        while(timer.milliseconds()<3000 && this.opModeIsActive()) {
        }

        totBot.drive(-73, 0, 0, -23);
        timer.reset();
        while(timer.milliseconds()<3000 && this.opModeIsActive()) {
        }

        totBot.drive(0, 0, 0, 0);


    }
}
