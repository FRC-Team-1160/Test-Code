import edu.wpi.first.math.kinematics.ChassisSpeeds;

public class SwerveAcceleration extends SubsystemBase{
    public ChassisSpeeds limiter(ChassisSpeeds robotrel){
        ChassisSpeeds real = new ChassisSpeeds();
        if(robotrel.vxMetersPerSecond() > 5){
            real.setvxMetersPerSecond(xyM);
        }
        if(robotrel.vyMetersPerSecond() >  )
        return real;
    }

}