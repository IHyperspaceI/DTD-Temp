package org.firstinspires.ftc.teamcode;

public class DTD2024Gamepad {
    private double joystickDeadzone = 0.05;
    private Gamepad gamepad;

    public DTD2024Gamepad(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public getLeftStickX() {
        return gamepad.left_stick_x;
    }

    public getLeftStickY() {
        return gamepad.left_stick_y;
    }

    public getRightStickX() {
        return gamepad.right_stick_x;
    }

    public getRightStickY() {
        return gamepad.right_stick_y;
    }
}
