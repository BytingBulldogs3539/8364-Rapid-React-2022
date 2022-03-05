// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveCommand;

public class DriveSubsystem extends SubsystemBase {
  // The motors on the left side of the drive.
  private final MotorControllerGroup m_leftMotors =
      new MotorControllerGroup(
          new WPI_VictorSPX(Constants.frontLeftDrive),
          new WPI_VictorSPX(Constants.backLeftDrive));

  // The motors on the right side of the drive.
  private final MotorControllerGroup m_rightMotors =
      new MotorControllerGroup(
          new WPI_VictorSPX(Constants.frontRightDrive),
          new WPI_VictorSPX(Constants.backRightDrive));

  // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

   /** Creates a new DriveSubsystem. */
   public DriveSubsystem() {
    // One side of the drivetrain needs to be inverted so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightMotors.setInverted(true);

    // Sets the drive command to run all the time.
    setDefaultCommand(new DriveCommand(this));
   }

   /**
   * Drives the robot using arcade controls.
   *
   * @param fwd The commanded forward movement
   * @param rot The commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }
  
  /**
   * Sets the max output of the drive. This is useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput Maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
