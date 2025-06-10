package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@Autonomous(name = "Auto Mecanum", group = "Autonomous")
public class AutoMecanum extends MecanumDrive{}

public class Claw {
    private Servo claw;

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "claw");
    }
}

public class CloseClaw implements Action {
    @Override
    public boolean run(@NonNull TelemetryPacket packet) {
        claw.setPosition(0.55);
        return false;
    }
}
public Action closeClaw() {
    return new CloseClaw();
}

public class OpenClaw implements Action {
    @Override
    public boolean run(@NonNull TelemetryPacket packet) {
        claw.setPosition(1.0);
        return false;
    }
}
public Action openClaw() {
    return new OpenClaw();
}