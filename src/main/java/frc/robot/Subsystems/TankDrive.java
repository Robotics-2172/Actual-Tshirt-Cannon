// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
  private SparkMax backLeftMain;
  private SparkMax frontLeftFollow;
  private SparkMax backRightMain;
  private SparkMax frontRightFollow;

  private SparkMaxConfig backLeftConfig;
  private SparkMaxConfig backRightConfig;
  private SparkMaxConfig frontLeftConfig;
  private SparkMaxConfig frontRightConfig;
  /** Creates a new TankDrive. */
  public TankDrive() {
    backLeftMain = new SparkMax(Constants.backLeftMotor, MotorType.kBrushless);
    frontLeftFollow = new SparkMax(Constants.frontLeftMotor, MotorType.kBrushless);
    backRightMain = new SparkMax(Constants.backRightMotor, MotorType.kBrushless);
    frontRightFollow = new SparkMax(Constants.frontRightMotor, MotorType.kBrushless);

    backLeftConfig = new SparkMaxConfig();
    backRightConfig = new SparkMaxConfig();
    frontLeftConfig = new SparkMaxConfig();
    frontRightConfig = new SparkMaxConfig();

    frontLeftConfig.follow(backLeftMain);
    frontLeftConfig.smartCurrentLimit(Constants.CurrentLimit);
    frontLeftConfig.inverted(false);

    frontRightConfig.follow(backRightMain);   
    frontRightConfig.smartCurrentLimit(Constants.CurrentLimit);
    frontRightConfig.inverted(true);

    backLeftConfig.smartCurrentLimit(Constants.CurrentLimit);
    backLeftConfig.inverted(false);
    backRightConfig.smartCurrentLimit(Constants.CurrentLimit);
    backRightConfig.inverted(true);

    backLeftMain.configure(backLeftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    backRightMain.configure(backRightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    frontLeftFollow.configure(frontLeftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    frontRightFollow.configure(frontRightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Drive(double LeftSpeed, double RightSpeed){
    backLeftMain.set(-LeftSpeed);
    backRightMain.set(RightSpeed);
  }
}
