// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.TankDrive;

public class RobotContainer {
  // Does this work? gorb
  XboxController controller = new XboxController(0);
  TankDrive gorb = new TankDrive();
  public RobotContainer() {
    configureBindings();
    gorb.setDefaultCommand(getAutonomousCommand());
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
