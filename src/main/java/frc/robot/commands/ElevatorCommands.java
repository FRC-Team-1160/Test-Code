package frc.robot.commands;

import frc.robot.subsystems.Elevator;

public class ElevatorCommands {

    private final Elevator m_elevator;

    public ElevatorCommands(Elevator elevator) {
        m_elevator = elevator;
    }

    public void moveL1() { m_elevator.goToL1(); }
    public void moveL2() { m_elevator.goToL2(); }
    public void moveL3() { m_elevator.goToL3(); }
    public void moveL4() { m_elevator.goToL4(); }
    public void moveSource() { m_elevator.goToSource(); }
    public void moveStow() { m_elevator.goToStow(); }

    public void manual(double speed) {
        m_elevator.runManual(speed);
    }

    public void stop() {
        m_elevator.stop();
    }
}
