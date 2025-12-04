package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    SparkMax shooter_motor;

    public Shooter() {
        shooter_motor = new SparkMax(9, MotorType.kBrushless);
    }

    public void runMotors(double speed) {
        SmartDashboard.putNumber("shooter_speed", speed);
        shooter_motor.set(speed);
    }
    
}
