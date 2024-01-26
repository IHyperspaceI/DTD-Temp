package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class DTD2024TeleOp2 extends LinearOpMode {

    public void runOpMode() {
        // Setup
        Gamepad helmGamepad = new DTD2024Gamepad(gamepad1);
        Gamepad weaponsGamepad = new DTD2024Gamepad(gamepad2);

        // Config
        private double placementLinearSpeed = 1;

        // Input tuning
        private double joystickDeadzone = 0.05;

        private double translateSpeed = -1;
        private double turnSpeed = 1;
        private double strafeSpeedTune = -0.1;

        private double linearPower = 0;


        // Tell driver it is initialized
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait until the robot is running
        waitForStart();


        while(opModeIsActive()) {
            // Gamepad input, if statements are for deadzones
            forwardBackValue = Math.abs(helmGamepad.getLeftStickY) >= joystickDeadzone // Condition
                    ? (helmGamepad.getLeftStickY * Math.abs(gamepad1.getLeftStickY) - joystickDeadzone) * translateSpeed // True
                    : 0; // False

            sideToSideValue = Math.abs(helmGamepad.getLeftStickX) >= joystickDeadzone // Condition
                    ? (helmGamepad.getLeftStickX * Math.abs(helmGamepad.getLeftStickX) - joystickDeadzone) * translateSpeed // True
                    : 0; // False

            rotationValue = Math.abs(gamepad1.right_stick_x) >= joystickDeadzone // Condition
                    ? (helmGamepad.getRightStickX * Math.abs(helmGamepad.getRightStickX) - joystickDeadzone) * turnSpeed // True
                    : 0; // False


            linearPower = Math.abs(weaponsGamepad.getRightStickY) >= joystickDeadzone // Condition
                    ? (weaponsGamepad.getRightStickY * Math.abs(weaponsGamepad.getRightStickY) - joystickDeadzone) * placementLinearSpeed // True
                    : 0; // False
        }
    }
}
