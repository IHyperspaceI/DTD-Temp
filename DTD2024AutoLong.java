package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.Timer;
import java.util.TimerTask;

// 1.5 forward - short
// 1 left 3.5 forward - long

//@Disabled
@Autonomous
public class DTD2024AutoLong extends LinearOpMode {
    // Timer
    private Timer m_timer;
    final long SIDEWAYS_DELAY = 500L; //in ms
    final long FORWARD_DELAY = 2000L; //in ms

    // Drivetrain motors
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    // Overall speeeed
    private double moveSpeed = 0.5;


    // Actually run the robot
    public void runOpMode() {
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontleft"); // Port 0
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontright"); // Port 1
        backLeftMotor = hardwareMap.get(DcMotor.class, "backleft"); // Port 2
        backRightMotor = hardwareMap.get(DcMotor.class, "backright"); // Port 3


        // Wait until the robot is running
        waitForStart();

        // Move sideways
        frontLeftMotor.setPower(moveSpeed);
        frontRightMotor.setPower(-moveSpeed);
        backLeftMotor.setPower(moveSpeed);
        backRightMotor.setPower(-moveSpeed);

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;

        while (elapsedTime < FORWARD_DELAY) {
            elapsedTime = System.currentTimeMillis() - startTime;
        }

        // Stop
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }
}
