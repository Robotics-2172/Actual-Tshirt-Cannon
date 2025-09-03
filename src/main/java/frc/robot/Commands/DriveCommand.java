// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.TankDrive;

public class DriveCommand extends Command {
  TankDrive tank;
  DoubleSupplier left;
  DoubleSupplier right;
  public DriveCommand(TankDrive tank, DoubleSupplier left, DoubleSupplier right) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.tank = tank;
    this.left = left;
    this.right = right;
    addRequirements(this.tank);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    tank.Drive(left.getAsDouble(), right.getAsDouble());
  }
}
