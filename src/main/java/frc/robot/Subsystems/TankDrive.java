// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
  private SparkMax backLeft;
  private SparkMax frontLeft;
  private SparkMax backRight;
  private SparkMax frontRight;
  /** Creates a new TankDrive. */
  public TankDrive() {
    backLeft = new SparkMax(Constants.backLeftMotor, MotorType.kBrushless);
    frontLeft = new SparkMax(Constants.frontLeftMotor, MotorType.kBrushless);
    backRight = new SparkMax(Constants.backRightMotor, MotorType.kBrushless);
    frontRight = new SparkMax(Constants.frontRightMotor, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Drive(double LeftSpeed, double RightSpeed){
    backLeft.set(LeftSpeed);
    frontLeft.set(LeftSpeed);
    backRight.set(RightSpeed);
    frontRight.set(RightSpeed);
  }
}
