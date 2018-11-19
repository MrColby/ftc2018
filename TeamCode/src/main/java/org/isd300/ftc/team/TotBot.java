package org.isd300.ftc.team;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TotBot {
    // the config map that comes from the controller app
    private HardwareMap hardwareMap;

    // telemetry sends messages to the phone display
    private Telemetry telemetry;

    private DcMotor wheelLeftMotor;
    private DcMotor wheelRightMotor;

    public TotBot(HardwareMap ardwareMap, Telemetry elemtry) {
        this.hardwareMap = ardwareMap;
        this.telemetry = elemtry;
        this.intializewheels();
    }

    private void intializewheels() {
        this.wheelLeftMotor = this.hardwareMap.get(DcMotor.class, "left");
        this.wheelRightMotor = this.hardwareMap.get(DcMotor.class, "right");

        this.wheelLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        this.wheelLeftMotor.setDirection(DcMotor.Direction.FORWARD);


        this.wheelRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.wheelLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        this.wheelLeftMotor.setPower(0);
        this.wheelRightMotor.setPower(0);
    }
    public void drive(double left, double right) {
        double greatest = Math.abs(left);
        if (Math.abs(right)>greatest) greatest = Math.abs(right);

        if (greatest>1){
            right = right / greatest;
            left = left / greatest;

        }


        this.wheelRightMotor.setPower(right);
        this.wheelLeftMotor.setPower(left);



    }








}
