package ro.cnmv.neuro.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import ro.cnmv.neuro.teamcode.Hardware.Robot;

@Autonomous(name="Servo Set 0.5",  group="Autonomous")
public class Servo05 extends LinearOpMode {
    @Override
    public void runOpMode() {
        Servo servo = hardwareMap.get(Servo.class, "servo");

        waitForStart();

        servo.setPosition(0.5);
        sleep(10000);
    }
}
