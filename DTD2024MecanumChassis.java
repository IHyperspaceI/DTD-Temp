package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class DTD2024MecanumChassis extends LinearOpMode {
    // Drivetrain motors
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    // Input
    private double forwardBackValue = 0;
    private double sideToSideValue = 0;
    private double rotationValue = 0;

    public DTD2024Chassis () {
        // Setup
        WiringConnections m_wiringConnections = new WiringConnections();

        frontLeftMotor = hardwareMap.get(DcMotor.class, m_wiringConnections.frontLeftMotorName); // Port 0
        frontRightMotor = hardwareMap.get(DcMotor.class, m_wiringConnections.frontRightMotorName); // Port 1
        backLeftMotor = hardwareMap.get(DcMotor.class, m_wiringConnections.backLeftMotorName); // Port 2
        backRightMotor = hardwareMap.get(DcMotor.class, m_wiringConnections.backRightMotorName); // Port 3
    }

    /**
     * Makes it drive forward/backward
     * @param value how fast forward/back
     */
    public void setForwardBackValue(double value) {
        this.forwardBackValue = value;
        drive();
    }

    private void drive() {
        // Drive go brrrrrr (mecanum math as well)
        frontLeftMotor.setPower(forwardBackValue - rotationValue + sideToSideValue + strafeSpeedTune * sideToSideValue);
        frontRightMotor.setPower(-forwardBackValue - rotationValue + sideToSideValue + strafeSpeedTune * sideToSideValue);
        backLeftMotor.setPower(forwardBackValue - rotationValue - sideToSideValue);
        backRightMotor.setPower(-forwardBackValue - rotationValue - sideToSideValue);
    }
}
