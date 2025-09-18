// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Cannon extends SubsystemBase {
  private SparkMax compressor1;
  private SparkMax compressor2;
  private SparkMax solenoid;
  public SparkMax pivot;
  /** Creates a new Cannon. */
  public Cannon() {
    compressor1 = new SparkMax(Constants.Compressor1, MotorType.kBrushed);
    compressor2 = new SparkMax(Constants.Compressor2, MotorType.kBrushed);
    solenoid = new SparkMax(Constants.Solenoid, MotorType.kBrushed);
    pivot = new SparkMax(Constants.TiltMotor, MotorType.kBrushed);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void compress(boolean value) {
    if (value){
      compressor1.set(100);
      compressor2.set(100);
    }
    else {
      compressor1.set(0);
      compressor2.set(0);
    }

  }
  public void shoot(boolean value){
    if (value) {
      solenoid.set(100);
    }
    else{
      solenoid.set(0);
    }
  }
  public void pivot(double speed){
    pivot.set(speed);
  }
}