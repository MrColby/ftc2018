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

        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);

        this.waitForStart();
        while (this.opModeIsActive()) {
            this.totBot.getEyestalkColor();
        }

    }
}
