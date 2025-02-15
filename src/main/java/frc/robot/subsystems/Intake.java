package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    SparkMax motor_top, motor_bottom;

    TalonFX motor_wrist;

    public Intake() {
        motor_top = new SparkMax(27, MotorType.kBrushless);
        motor_bottom = new SparkMax(28, MotorType.kBrushless);
        motor_wrist = new TalonFX(13);
    }

    public void runMotors(double speed) {
        motor_top.set(speed);
        motor_bottom.set(-speed);
    }

    public void runWrist(double volts) {
        motor_wrist.setControl(new VoltageOut(volts));

    }
    
}
