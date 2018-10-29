package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="KamiBot", group="Kami")

public class KamiBot extends LinearOpMode {

    private TileRunnerBot totBot;

    private ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {
        boolean foundDistance = false
        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);
        //wait for start button
        this.waitForStart();

        totBot.drive(0.125, 0.125, 0.125, 0.125);

        double distance = this.totBot.getDistance();
        String msg = "Distance=" + distance;
        this.totBot.message("", msg);

        if (distance > 2) {
            foundDistance = true;
            totBot.drive(0, 0, 0, 0);
            int red = this.totBot.getRed();
            int blue = this.totBot.getBlue();
            int green = this.totBot.getGreen();
        }
        int red = this.totBot.getRed();
        int blue = this.totBot.getBlue();
        int green = this.totBot.getGreen();
        if (red > 18 && blue < 15 && green > 10) {
            msg = "Hurray";
            this.totBot.message("", msg);
        }

        boolean yellow = checkOutTargetOne();
        if (yellow) {
            totBot.drive(0, 0, 0, 0);
        }

        else{





    }

    }

    private boolean chaeckOutTargetOne(){

        boolean foundDistance = false
        double distance = this.totBot.getDistance();
        String msg = "Distance=" + distance;
        this.totBot.message("", msg);


        if (distance > 2) {
            foundDistance = true;
            totBot.drive(0, 0, 0, 0);
            int red = this.totBot.getRed();
            int blue = this.totBot.getBlue();
            int green = this.totBot.getGreen();
        }
        int red = this.totBot.getRed();
        int blue = this.totBot.getBlue();
        int green = this.totBot.getGreen();
        if (red > 18 && blue < 15 && green > 10) {
            msg = "Hurray";
            this.totBot.message("", msg);
        }
    }


        if (distance > 2) {
            foundDistance = true;
            totBot.drive(0, 0, 0, 0);
        while (this.opModeIsActive() ) {



        }
    }


}
