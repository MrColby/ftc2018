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

        boolean foundDistance = false;

        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);
        //wait for start button
        this.waitForStart();

        while (this.opModeIsActive() ) {

            totBot.drive(0.125, 0.125, 0.125, 0.125);

            //drive for a 1/4 of a second
            timer.reset();
            while (timer.milliseconds() < 250) {

            }

            double distance = this.totBot.getDistance();
            String msg = "Distance=" + distance;
            this.totBot.message("", msg);

            if (distance > 2) {
                foundDistance = true;
                totBot.drive(0, 0, 0, 0);
            }

            int red = this.totBot.getRed();
            int blue = this.totBot.getBlue();
            int green = this.totBot.getGreen();

            msg = "Red=" + red + "Blue=" + blue + "Green=" + green;
            this.totBot.message("", msg);


        }
    }

    public void runOpModeColor() {

        totBot = new TileRunnerBot(this.hardwareMap,this.telemetry);
        //wait for start button
        this.waitForStart();

        //there is no yellow
        boolean foundYellow = false;

        //run until yellow is found
        while (this.opModeIsActive() && foundYellow == false) {

            totBot.drive(0.125,0.125,0.125,0.125);

            //drive for a 1/4 of a second
            timer.reset();
            while (timer.milliseconds() < 250){
                }

            totBot.drive(0, 0, 0, 0);

            int red = this.totBot.getRed();
            int blue = this.totBot.getBlue();
            int green = this.totBot.getGreen();

            //drive for a 1/4 of a second
            timer.reset();
            while (timer.milliseconds() < 250){
            }

            //String msg = "Red=" + red + "Blue=" + blue + "Green=" + green;
            //this.totBot.message("", msg);

            if (red > 70 && green > 35) {
                foundYellow = true;
            }

            double distance = this.totBot.getDistance();
            String msg = "Distance=" + distance;
            this.totBot.message("", msg);


        }


        /*totBot.drive(10, 10, 10, 20);
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
        }*/
        //totBot.drive(0, 0, 0, 0);


    }
}
