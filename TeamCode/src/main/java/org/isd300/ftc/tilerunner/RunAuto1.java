package org.isd300.ftc.tilerunner;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by whiar on 12/3/2017.
 */
@Autonomous(name="RunTileRunner1", group="tilerunner")
public class RunAuto1 extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        TileRunnerAuto marmotot =  new TileRunnerAuto(this);
        marmotot.runMission();
    }
}

