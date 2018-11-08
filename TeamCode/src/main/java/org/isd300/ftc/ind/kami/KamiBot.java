package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="KamiBot", group="Kami")

public class KamiBot extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {
        boolean foundDistance = false;
        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);
        //wait for start button
        this.waitForStart();






        boolean yellow = checkOutTargetOne();
        if (yellow) {
            String msg = "YaY";
            this.totBot.message("", msg);
        }

        else{
            String msg = "BoO";
            this.totBot.message("", msg);

        }

    }

    private boolean checkOutTargetOne(){

        double distance = this.totBot.getDistance(DistanceUnit.CM);
        String msg = "Distance=" + distance;
        this.totBot.message("", msg);

        timer.reset();
        while(timer.milliseconds() < 3000){

        }

        totBot.drive(0.125, 0.125, 0.125, 0.125);

        boolean foundYellow = false;

        while(distance == DistanceUnit.infinity){

        }


        while(distance > 2){
            distance = this.totBot.getDistance(DistanceUnit.CM);
            msg = "Distance=" + distance;
            this.totBot.message("", msg);
        }

        totBot.drive(0, 0, 0, 0);

        int red = this.totBot.getRed();
        int blue = this.totBot.getBlue();
        int green = this.totBot.getGreen();
        if (red > 18 && blue < 15 && green > 10) {
            msg = "Hurray";
            this.totBot.message("", msg);
            foundYellow = true;
        }

        return foundYellow;
    }


}
