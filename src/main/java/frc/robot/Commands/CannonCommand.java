// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Cannon;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class CannonCommand extends Command {

  BooleanSupplier Compressor;
  BooleanSupplier Solenoid;
  BooleanSupplier PivotUp;
  BooleanSupplier PivotDown;
  Cannon Cannon;
  /** Creates a new GubTuppasWepple. */
  public CannonCommand(BooleanSupplier compressor, BooleanSupplier solenoid, Cannon cannon, BooleanSupplier pivotUp, BooleanSupplier pivotDown) {
    Compressor = compressor;
    Solenoid = solenoid;
    Cannon = cannon;
    PivotUp = pivotUp;
    PivotDown = pivotDown;
    addRequirements(Cannon);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Cannon.shoot(Solenoid.getAsBoolean());
    Cannon.compress(Compressor.getAsBoolean());
    if(PivotUp.getAsBoolean()){
      Cannon.pivot(10);
    }
    else if(PivotDown.getAsBoolean()){
      Cannon.pivot(-10);
    }
    else{
      Cannon.pivot(0);
    }
  }
}
