package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    SparkMax first_motor, second_motor;
    TalonFX wrist;


    public Intake() {
        first_motor = new SparkMax(1000, MotorType.kBrushless);
        second_motor = new SparkMax(1000, MotorType.kBrushless);
    }

    public void runMotors(double speed, double secSpeed) {
        SmartDashboard.putNumber("shooter_speed", speed);
        first_motor.set(speed);
        second_motor.set(-speed);
    }
    
}