package frc.robot;


import edu.wpi.first.wpilibj.Joystick;


import frc.robot.subsystems.Elevator;
import frc.robot.commands.ElevatorCommands;
import frc.robot.Constants.IOConstants;
import frc.robot.Constants;


public class RobotContainer {


    private final Joystick m_joystick = new Joystick(IOConstants.MAIN_PORT);


    private final Elevator m_elevator = new Elevator(Constants.PortConstants.ELEVATOR_MOTOR);
    private final ElevatorCommands m_elevatorCommands = new ElevatorCommands(m_elevator);


    public RobotContainer() {}


    public void teleopPeriodic() {
        if (m_joystick.getRawButtonPressed(1)) m_elevatorCommands.moveL1();
        if (m_joystick.getRawButtonPressed(2)) m_elevatorCommands.moveL2();
        if (m_joystick.getRawButtonPressed(3)) m_elevatorCommands.moveL3();
        if (m_joystick.getRawButtonPressed(4)) m_elevatorCommands.moveL4();
        if (m_joystick.getRawButtonPressed(5)) m_elevatorCommands.moveSource();
        if (m_joystick.getRawButtonPressed(6)) m_elevatorCommands.moveStow();


        double y = -m_joystick.getRawAxis(1);
        if (Math.abs(y) > 0.05) {
            m_elevatorCommands.manual(y * 0.4);
        } else {
            m_elevatorCommands.stop();
        }


        if (m_joystick.getRawButtonPressed(7)) {
            m_elevator.zeroEncoder();
        }
    }
}


