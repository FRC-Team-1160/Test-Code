// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Funnel;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Shooter m_shooter = new Shooter();

  private final Funnel m_funnel = new Funnel();

  private final Joystick main_stick = new Joystick(4);

  //private final Climber m_climber = new Climber();

  private final Elevator m_Elevator = new Elevator();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {


    new JoystickButton(main_stick, 7)
        .whileTrue(new StartEndCommand(
            () -> m_shooter.runMotors(.2), 
            () -> m_shooter.runMotors(0)));

    new JoystickButton(main_stick, 8)
        .onTrue(new InstantCommand(m_funnel::flip));

    /*new JoystickButton(main_stick, 9)
        .onTrue(new IntantCommand(m_climber::grabDown(2)));

    new JoystickButton(main_stick, 9)
      .whileTrue(new StartEndCommand(
          () -> m_climber.grabUp(2), 
          () -> m_climber.afk()));

    new JoystickButton(main_stick, 10){
      .whileTrue(new StartEndCommand(
          () -> m_climber.runMotors(2), 
          () -> m_climber.afk()));

    //button 3
    new JoystickButton(main_stick,12)
      .onTrue(new StartEndCommand(, 
          () -> m_climber.afk()));

    //upButton
    new JoystickButton(main_stick,11)
      .whileTrue(new StartEndCommand(
          () -> m_climber.grabUp(2), 
          () -> m_climber.afk()));

    //downbutton
    new JoystickButton(main_stick,11)
      .whileTrue(new StartEndCommand(
          () -> m_climber.grabDown(2), 
          () -> m_climber.afk()));

    
*/

//i've got this *ding*

          //l4 preset
    new JoystickButton(main_stick, 9)
      .whileTrue(new StartEndCommand(
        () -> m_Elevator.l4(),
        () -> m_Elevator.afk()));
    
      
    }
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }
  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
