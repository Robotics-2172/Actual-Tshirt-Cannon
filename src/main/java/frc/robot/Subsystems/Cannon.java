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
  private Relay nate1;
  private Relay nate2;
  private SparkMax natanoid;
  /** Creates a new Cannon. */
  public Cannon() {
    nate1 = new Relay(Constants.Nate1);
    nate2 = new Relay(Constants.Nate2);
    natanoid = new SparkMax(Constants.Natanoid, MotorType.kBrushed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void gorb(Value value) {
    nate1.set(value);
    nate2.set(value);
  }
  public void gub(boolean tuppas){
    if (tuppas) {
      
    }
  }
}