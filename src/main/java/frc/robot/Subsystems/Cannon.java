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
  private Relay compressor1;
  private Relay compressor2;
  private SparkMax solenoid;
  /** Creates a new Cannon. */
  public Cannon() {
    compressor1 = new Relay(Constants.Compressor1);
    compressor2 = new Relay(Constants.Compressor2);
    solenoid = new SparkMax(Constants.Solenoid, MotorType.kBrushed);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void compress(boolean value) {
    if (value){
      compressor1.set(Value.kOn);
      compressor2.set(Value.kOn);
    }
    else {
      compressor1.set(Value.kOff);
      compressor2.set(Value.kOff);
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
}