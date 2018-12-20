package org.isd300.ftc.team;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TotBot {
    // the config map that comes from the controller app
    private HardwareMap hardwareMap;

    // telemetry sends messages to the phone display
    private Telemetry telemetry;

    public Servo gate    = null;


    private DcMotor wheelLeftMotor;
    private DcMotor wheelRightMotor;

    public TotBot(HardwareMap hardwareMap, Telemetry elemtry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = elemtry;
        this.intializewheels();
        this.initializegate();
    }

    private void initializegate(){
        gate  = hardwareMap.get(Servo.class, "left_hand");

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


        this.wheelRightMotor.setPower(-1*right);
        this.wheelLeftMotor.setPower(left);



    }
    public void closegate(){
        this.gate.setPosition(0.5);
    }








}
