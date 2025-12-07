package frc.robot.commands;

import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.ElevatorConstants;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.FunctionalCommand;

public class ElevatorCommands {

    private final Elevator m_elevator;
    private double targetSetpoint;

    public ElevatorCommands(Elevator elevator) {
        m_elevator = elevator;
    }

    // public void moveL1() { 
    //     m_elevator.goToL1(); 
    // }
    
    public Command L2Command(){
        Runnable empty = () -> {};
        return new FunctionalCommand(
            empty, 
            m_elevator::goToL2,
            interrupted -> m_elevator.setNeutral(),
            m_elevator::atSetpt,
            m_elevator
        );
    }

    public void moveL2() {
        targetSetpoint = ElevatorConstants.ElevatorSetpoints.kL2;
        m_elevator.goToL2();
    }
    // public void moveL3() { m_elevator.goToL3(); }
    // public void moveL4() { m_elevator.goToL4(); }
    // public void moveSource() { m_elevator.goToSource(); }
    // public void moveStow() { m_elevator.goToStow(); }

    // public Command moveL1() {
    //     return new InstantCommand(() -> m_elevator.goToL1(), m_elevator);
    // }

    // public Command moveL2() {
    //     return new InstantCommand(() -> m_elevator.goToL2(), m_elevator);
    // }

    public void manual(double speed) {
        m_elevator.runManual(speed);
    }

    public void stop() {
        m_elevator.stop();
    }
}
