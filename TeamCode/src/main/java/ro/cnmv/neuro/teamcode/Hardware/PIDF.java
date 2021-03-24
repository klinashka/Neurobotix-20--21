package ro.cnmv.neuro.teamcode.Hardware;
import ro.cnmv.neuro.teamcode.Assets.PIDCoefficients;

public class PIDF {
    double loop_time;
    double P, I=0., D, Pant=0., posAnt=0.;

    double update(double pos, double error) {
        P = error;
        loop_time =  pos-posAnt;
        I = I + error*loop_time;
        D = (P-Pant)/loop_time;
        posAnt = pos;
        Pant = P;
        return PIDCoefficients.KP*P+ PIDCoefficients.KI*I+PIDCoefficients.KD*D;
    }
}
