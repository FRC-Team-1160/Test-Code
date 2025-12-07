package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.Elevator;
import frc.robot.commands.ElevatorCommands;
import frc.robot.Constants.IOConstants;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class RobotContainer {

    private final Joystick m_joystick = new Joystick(IOConstants.MAIN_PORT);

    private final Elevator m_elevator =
        new Elevator(Constants.PortConstants.ELEVATOR_MOTOR);

    private final ElevatorCommands m_elevatorCommands =
        new ElevatorCommands(m_elevator);

    public RobotContainer() {
        configureBindings();

        // Default command → manual control
        m_elevator.setDefaultCommand(
            new RunCommand(() -> {
                double y = m_joystick.getRawAxis(1);

                if (Math.abs(y) > 0.05)
                    m_elevatorCommands.manual(y * 0.4);
                else
                    m_elevatorCommands.stop();

                SmartDashboard.putNumber("current position:", m_elevator.getPosition());
            }, m_elevator)
        );
    }

    private void configureBindings() {
       // new JoystickButton(m_joystick, 1).onTrue(m_elevatorCommands.goToL1);
        new JoystickButton(m_joystick, 2).onTrue(
            m_elevatorCommands.L2Command()
            );
        // new JoystickButton(m_joystick, 3).onTrue(m_elevatorCommands.moveL3);
        // new JoystickButton(m_joystick, 4).onTrue(m_elevatorCommands.moveL4);
        // new JoystickButton(m_joystick, 5).onTrue(m_elevatorCommands.moveSource);

        // Zero encoder button
        new JoystickButton(m_joystick, 7)
            .onTrue(new RunCommand(() -> m_elevator.zeroEncoder(), m_elevator));
    }
}
