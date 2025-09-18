// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.CannonCommand;
import frc.robot.Commands.DriveCommand;
import frc.robot.Subsystems.Cannon;
import frc.robot.Subsystems.TankDrive;

public class RobotContainer {
  // Does this work? gorb
  XboxController controller = new XboxController(0);
  TankDrive tank = new TankDrive();
  Cannon cannon = new Cannon();
  public RobotContainer() {
    configureBindings();
    tank.setDefaultCommand(new DriveCommand(tank, controller::getLeftY, controller::getRightY));
    cannon.setDefaultCommand(new CannonCommand(controller::getAButton, controller::getXButton, cannon, controller::getRightBumperButton, controller::getLeftBumperButton));
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
