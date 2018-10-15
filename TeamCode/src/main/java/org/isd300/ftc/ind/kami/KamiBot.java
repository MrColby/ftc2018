package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="KamiBot", group="Kami")

public class KamiBot extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);

        this.waitForStart();

        totBot.drive(10, 10, 10, 20);
        timer.reset();
        while(timer.milliseconds()<1700 && this.opModeIsActive()) {
        }
// Happy Doughnut
        totBot.drive(10, -10, 10, -10);
        timer.reset();
        while(timer.milliseconds()<1400 && this.opModeIsActive()) {
        }

        totBot.drive(10, 10, 10, 10);
        timer.reset();
        while(timer.milliseconds()<2550 && this.opModeIsActive()) {
        }
        totBot.drive(15, -15, 15, -15);
        timer.reset();
        while(timer.milliseconds()<500 && this.opModeIsActive()) {
        }
        totBot.drive(10, 20, 10, 20);
        timer.reset();
        while(timer.milliseconds()<2000 && this.opModeIsActive()) {
        }
        totBot.drive(0, 0, 0, 0);


    }
}
