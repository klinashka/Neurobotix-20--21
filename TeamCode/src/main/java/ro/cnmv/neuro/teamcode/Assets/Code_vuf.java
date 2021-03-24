package ro.cnmv.neuro.teamcode.Assets;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

public class Code_vuf {

    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";

    private static final String VUFORIA_KEY =
            Vuforia_key.vuf_key;

    private VuforiaLocalizer vuforia;

    private TFObjectDetector tfod;

    private List<Recognition> updatedRecognitions;

    public void Code_vuf(HardwareMap hardwareMap)
    {
        initVuforia(hardwareMap);
        initTfod(hardwareMap);

        if(tfod != null)
        {
            tfod.activate();
            tfod.setZoom(1.5, 16.0/9.0);
        }

        if (tfod != null) {
            updatedRecognitions = tfod.getUpdatedRecognitions();
        }
    }

    public String get_object()
    {
        return updatedRecognitions.get(0).getLabel();
    }

    private void initVuforia(HardwareMap hardwareMap) {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        vuforia = ClassFactory.getInstance().createVuforia(parameters);

    }

    private void initTfod(HardwareMap hardwareMap) {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.95f;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
}
