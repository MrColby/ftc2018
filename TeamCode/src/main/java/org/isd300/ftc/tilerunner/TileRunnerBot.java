package org.isd300.ftc.tilerunner;

import android.graphics.Color;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by whiar on 12/3/2017.
 */
//me
public class TileRunnerBot {
    // the config map that comes from the controller app
    private HardwareMap hardwareMap;

    // telemetry sends messages to the phone display
    private Telemetry telemetry;

    // gyroscope
    private BNO055IMU imu;

    private ColorSensor eyeStalkColorSensor;
    private DistanceSensor eyeStalkDistanceSensor;




    // drive mecanum wheels
    private DcMotor wheelFrontRightMotor;
    private DcMotor wheelFrontLeftMotor;
    private DcMotor wheelBackLeftMotor;
    private DcMotor wheelBackRightMotor;

    // image processing
    private VuforiaLocalizer vuforia;
    private VuforiaTrackables relicTrackables;
    private VuforiaTrackable relicTemplate;

    public enum Color {
        UNKNOWN,
        RED,
        GREEN,
        BLUE
    }

    /*
    When the robot is created, initialize it
     */
    public TileRunnerBot(HardwareMap ardwareMap, Telemetry elemtry) {
        this.hardwareMap = ardwareMap;
        this.telemetry = elemtry;
        this.intializewheels();
        this.initializeVuforia();
        this.initializeColorSensor();
    }

    private void initializeColorSensor() {
        this.eyeStalkColorSensor = hardwareMap.get(ColorSensor.class, "color_sensor");
        this.eyeStalkDistanceSensor = hardwareMap.get(DistanceSensor.class, "color_sensor");
    }

    public int getRed() {
        return eyeStalkColorSensor.red();
    }



    public Color getEyestalkColor() {




        message("Color sensor", eyeStalkColorSensor.red()+", " + eyeStalkColorSensor.green() + ", " + eyeStalkColorSensor.blue());
        if(eyeStalkColorSensor.red() > eyeStalkColorSensor.green() && eyeStalkColorSensor.red() > eyeStalkColorSensor.blue()  ) {
            return Color.RED;
        }
        if(eyeStalkColorSensor.green() > eyeStalkColorSensor.red() && eyeStalkColorSensor.green() > eyeStalkColorSensor.blue()  ) {
            return Color.GREEN;
        }
        if(eyeStalkColorSensor.blue() > eyeStalkColorSensor.green() && eyeStalkColorSensor.blue() > eyeStalkColorSensor.red()  ) {
            return Color.BLUE;
        }


        return Color.UNKNOWN;

    }

    public RelicRecoveryVuMark getPictograph() {
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
        //message("Pictograph", vuMark + "");
        return vuMark;
    }

    public void drive(double frontLeft, double frontRight, double rearLeft, double rearRight) {
        double greatest = Math.abs(frontLeft);
        if (Math.abs(frontRight)>greatest) greatest = Math.abs(frontRight);
        if (Math.abs(rearLeft)>greatest) greatest = Math.abs(rearLeft);
        if (Math.abs(rearRight)>greatest) greatest = Math.abs(rearRight);
        if (greatest>1){
            frontRight = frontRight / greatest;
            frontLeft = frontLeft / greatest;
            rearLeft = rearLeft / greatest;
            rearRight /= greatest;
        }


        this.wheelFrontRightMotor.setPower(-1*frontRight);
        this.wheelFrontLeftMotor.setPower(-1*frontLeft);
        this.wheelBackRightMotor.setPower(-1*rearRight);
        this.wheelBackLeftMotor.setPower(-1*rearLeft);



    }












      private void intializewheels() {
        this.wheelFrontLeftMotor = this.hardwareMap.get(DcMotor.class, "front_left");
        this.wheelFrontRightMotor = this.hardwareMap.get(DcMotor.class, "front_right");
        this.wheelBackLeftMotor = this.hardwareMap.get(DcMotor.class, "back_left");
        this.wheelBackRightMotor = this.hardwareMap.get(DcMotor.class, "back_right");

        this.wheelFrontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        this.wheelBackLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        this.wheelFrontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        this.wheelBackRightMotor.setDirection(DcMotor.Direction.REVERSE);

        this.wheelFrontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.wheelFrontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.wheelBackRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.wheelBackLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        this.wheelBackLeftMotor.setPower(0);
        this.wheelBackRightMotor.setPower(0);
        this.wheelFrontLeftMotor.setPower(0);
        this.wheelFrontRightMotor.setPower(0);
    }

    private void initializeVuforia() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "ARwYsgn/////AAAAGdnqVxXGf0FGosxoyPdT4+QytPJ1N6S60MJfFRlQ2F3BJCxLMYxkVonlquEdJiynVouUNxQCtG8RTiGlWsMYDbtiv+MK+k2fxCZNK7EFkIiJHWNE1C/BxphLZcTnDtUYvqPIQloGWRAULJz8kB/k7HrD1tV6yIGgchNZg598BPY1RFh7Z2q898lZCHLRNIlSIvznkrbrVg/b0hnwWQ2YFxaWv6QHGWjPJSGkbkqYDnOkG3BCZcvEDy71Fd7uqxTHN7Pfn0jsJHm4McgtbTzCZy1cG7pRruSfmRO6kfJK/z9mDBMeIvPDL+9SssxOZ7WtQjokfaO2l/JtlGigUkd7y6tXj1xy4XGE5JBdjMaFRSD4";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        this.relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        this.relicTemplate = relicTrackables.get(0);
        this.relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary
        this.relicTrackables.activate();

    }

    public Orientation getGyroAngles() {
        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        this.message("imu:", angles.firstAngle + ", " + angles.secondAngle + ", " + angles.thirdAngle);
        return angles;
    }

    private void initializeImu() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        imu.startAccelerationIntegration(new Position(), new Velocity(), 10);
    }

    public void message(String caption, String msg) {
        this.telemetry.addData(caption, msg);
        this.telemetry.update();
    }


}
