package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="Idk", group="Kami")
public class Idk extends LinearOpMode {
    private TileRunnerBot totBot;
    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {
        this.totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);
        this.waitForStart();
        boolean success = driveStraightByTime(0.35, 8000);
        success = turnByTime(0.5, 8000);
        success = driveStraightByTime(0.5, 8000);
        success = turnByTime(0.5, 8000);
        this.totBot.drive(0, 0, 0, 0);
    }

    private boolean driveStraightByTime(double power, int time) {
        this.totBot.drive(power, power, power, power);
        this.timer.reset();
        while (this.opModeIsActive() && this.timer.milliseconds() < time) {
        }
        this.totBot.drive(0,0,0,0);
        return true;
    }
    private boolean turnByTime(double power, int time){
        this.totBot.drive(power,power,power,power);
        this.timer.reset();
        while(this.opModeIsActive()&& this.timer.milliseconds()< time){
            }
            this.totBot.drive(0,0,0,0);
        return true;
    }
}

