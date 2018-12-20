package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.isd300.ftc.tilerunner.TileRunnerBot;

@Autonomous(name="KamiColorBot",group="kami")
public class KamiColorBot extends LinearOpMode{
    private TileRunnerBot totBot;

    @Override
    public void runOpMode() {

        totBot = new TileRunnerBot(this.hardwareMap, this.telemetry);
        this.waitForStart();

        while (this.opModeIsActive()) {
            readColorSensor();
            String msg = "Red: " + red + " Green: " + green + " Blue: " + blue ;
            if (this.isYellow()){
                msg = msg + (" yellow");

            }
            if(this.isWhite()){
                msg = msg + (" white");

            }
            if(!this.isWhite()&&!this.isYellow()){
                msg = msg + (" nada");

            }
            this.totBot.message("",msg);
        }

    }
    private boolean isWhite(){
        boolean white = (red >= 20 && blue >= 15 && green <25);
        return white;
    }

    private boolean isYellow(){
        boolean yellow = (red < 30 && blue < 15 && green < 25);
        return yellow;
    }


    int red = 0;
    int green = 0;
    int blue = 0;

    private void readColorSensor() {

        red = this.totBot.getRed();
        green = this.totBot.getGreen();
        blue = this.totBot.getBlue();
        String msg = "Red: " + red + " Green: " + green + " Blue: " + blue ;
        this.totBot.message("", msg);
    }


}
