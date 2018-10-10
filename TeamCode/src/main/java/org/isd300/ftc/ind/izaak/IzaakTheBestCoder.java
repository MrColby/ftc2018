package org.isd300.ftc.ind.izaak;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="YeetBot: Auto Drive By Time", group="Pushbot")

public class IzaakTheBestCoder extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);

        this.waitForStart();

        totBot.drive(69, 69, 96, 25);
        timer.reset();
        while(timer.milliseconds()<3000 && this.opModeIsActive()) {
        }



        totBot.drive(0, 0, 0, 0);


    }
}
