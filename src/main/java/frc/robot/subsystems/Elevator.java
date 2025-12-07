package frc.robot.subsystems;


import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import frc.robot.Constants.ElevatorConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Elevator extends SubsystemBase{


    private final TalonFX m_motor;
    public final double elevator_setpoint;
    private final MotionMagicVoltage m_mmRequest = new MotionMagicVoltage(0);


    public Elevator(int motorID) {
        m_motor = new TalonFX(motorID, "CANivore");
        elevator_setpoint = getPosition();

        TalonFXConfiguration config = new TalonFXConfiguration()
            .withMotorOutput(new MotorOutputConfigs()
                .withNeutralMode(NeutralModeValue.Brake));


        Slot0Configs slot0 = new Slot0Configs()
            .withKP(ElevatorConstants.ElevatorConfigs.kP)
            .withKI(ElevatorConstants.ElevatorConfigs.kI)
            .withKD(ElevatorConstants.ElevatorConfigs.kD)
            .withKS(ElevatorConstants.ElevatorConfigs.kS)
            .withKV(ElevatorConstants.ElevatorConfigs.kV)
            .withKA(ElevatorConstants.ElevatorConfigs.kA)
            .withKG(ElevatorConstants.ElevatorConfigs.kG);


        MotionMagicConfigs mm = new MotionMagicConfigs()
            .withMotionMagicCruiseVelocity(ElevatorConstants.ElevatorMotionMagic.VELOCITY)
            .withMotionMagicAcceleration(ElevatorConstants.ElevatorMotionMagic.ACCELERATION)
            .withMotionMagicJerk(ElevatorConstants.ElevatorMotionMagic.JERK);


        config.withSlot0(slot0);
        config.withMotionMagic(mm);


        m_motor.getConfigurator().apply(config);


        m_motor.setPosition(0);
    }


    public double getPosition() {
        return m_motor.getPosition().getValueAsDouble();
    }


    public void setTargetRotations(double rotations) {
        if (rotations > ElevatorConstants.MAX_EXTENSION-0.1)
            rotations = ElevatorConstants.MAX_EXTENSION;
        if (rotations < ElevatorConstants.MIN_EXTENSION+0.1)
            rotations = ElevatorConstants.MIN_EXTENSION;

        m_motor.setControl(m_mmRequest.withPosition(rotations));
    }

    public void runManual(double percent) {
        m_motor.set(percent);
    }

    public void setNeutral(){
        m_motor.set(0.35);
    }

    public void stop() {
        m_motor.set(0);
    }


    public void zeroEncoder() {
        m_motor.setPosition(0);
    }

    // public void goToL1() { setTargetRotations(ElevatorConstants.ElevatorSetpoints.kL1); }
    public void goToL2() { setTargetRotations(ElevatorConstants.ElevatorSetpoints.kL2); }
    // public void goToL3() { setTargetRotations(ElevatorConstants.ElevatorSetpoints.kL3); }
    // public void goToL4() { setTargetRotations(ElevatorConstants.ElevatorSetpoints.kL4); }
    // public void goToSource() { setTargetRotations(ElevatorConstants.ElevatorSetpoints.kSource); }
    // public void goToStow() { setTargetRotations(ElevatorConstants.ElevatorSetpoints.kStow); }
    // public void goToL2Algae() { setTargetRotations(ElevatorConstants.ElevatorSetpoints.kL2Algae); }
    // public void goToL3Algae() { setTargetRotations(ElevatorConstants.ElevatorSetpoints.kL3Algae); }

    public boolean atSetpt(){   
        double error = Math.abs(elevator_setpoint - getPosition());
        if(error < 0.03){
            return true;
        }else{
            return false;
        }
    }

    public void periodic(){
        
    }
}


