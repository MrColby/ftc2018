package org.isd300.ftc.ind.kami;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.Random;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="EverybodyDies", group="games")
public class EverybodyDies extends LinearOpMode {
    private ElapsedTime timer = new ElapsedTime();

    public Random random = new Random();

    public void runOpMode(){

        this.waitForStart();

        

        this.timer.reset();
        while(this.opModeIsActive()){

            String death = getRandomDeath();
            if (this.gamepad1.a){
                displayMessage(death);
            }
            else if (this.gamepad1.b){
                displayMessage(death);
            }
            else if (this.gamepad1.y){
                displayMessage(death);
            }
            else if (this.gamepad1.x){
                displayMessage(death);
            }


        }

    }

    private String getRandomDeath(){
        int i =random.nextInt(4);
        if (i == 0){
            return "Heart Attack";
        }
        else if (i == 1){
            return "Bleed Out";
        }
        else if (i == 2){
            return "Poison";
        }
        else if (i == 3){
            return "Aneurysm";
        }

        return "No Death Fo You";

    }

    private void displayMessage(String msg){
        this.telemetry.addData("",msg);
        this.telemetry.update();
    }
}
