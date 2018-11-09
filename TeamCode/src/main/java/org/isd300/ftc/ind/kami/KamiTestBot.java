package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="KamiTestBot", group="Kami")

public class KamiTestBot extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {

        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);
        //wait for start button
        this.waitForStart();

        totBot.drive(0.125, 0.125, 0.125, 0.125);

        timer.reset();
        while(timer.milliseconds() < 3000){
        }

        double distance = this.totBot.getDistance(DistanceUnit.METER);
        String msg = "Distance=" + distance;
        this.totBot.message("", msg);

        totBot.drive(0, 0, 0, 0);
    }

}
