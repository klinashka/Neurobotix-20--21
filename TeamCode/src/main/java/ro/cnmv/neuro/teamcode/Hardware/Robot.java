package ro.cnmv.neuro.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public Drivetrain drivetrain;
    public Intake intake;
    public Outtake outtake;
    public IMU imu;
    public Localization localization;
    public Robot(HardwareMap ahwMap) {
        drivetrain = new Drivetrain(ahwMap);
        intake = new Intake(ahwMap);
        outtake = new Outtake(ahwMap);
        imu = new IMU(ahwMap);
        localization = new Localization();
    }
}
