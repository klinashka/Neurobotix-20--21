package ro.cnmv.neuro.teamcode.Hardware;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREV2mDistance;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Localization {
    private static final double FIELD_LENGTH = 3650.;
    private static DistanceSensor sensor1;
    private static DistanceSensor sensor2;

    public Localization(HardwareMap hwMap) {
        sensor1 = hwMap.get(DistanceSensor.class, "sensor_fata");
        sensor2 = hwMap.get(DistanceSensor.class, "sensor_dreapta");
    }

    public double getX() {
        return sensor1.getDistance(DistanceUnit.MM);
    }

    public double getY() {
        return sensor2.getDistance(DistanceUnit.MM);
    }

}
