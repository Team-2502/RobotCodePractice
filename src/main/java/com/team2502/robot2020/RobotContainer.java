/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team2502.robot2020;

import com.team2502.robot2020.command.*;
import com.team2502.robot2020.subsystem.*;
import com.team2502.robot2020.Constants.OI;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the Robot periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  protected final DrivetrainSubsystem DRIVE_TRAIN = new DrivetrainSubsystem();
  protected final ControlPanelWheelSubsystem CONTROL_PANEL = new ControlPanelWheelSubsystem();
  protected final AdjustableHoodSubsystem ADJUSTABLE_HOOD = new AdjustableHoodSubsystem();
  protected final TurretSubsystem TURRET = new TurretSubsystem();

  private static final Joystick JOYSTICK_DRIVE_RIGHT = new Joystick(Constants.OI.JOYSTICK_DRIVE_RIGHT);
  private static final Joystick JOYSTICK_DRIVE_LEFT = new Joystick(Constants.OI.JOYSTICK_DRIVE_LEFT);
  private static final Joystick JOYSTICK_OPERATOR = new Joystick(Constants.OI.JOYSTICK_OPERATOR);


    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
      configureButtonBindings();

      DRIVE_TRAIN.setDefaultCommand(new DriveCommand(DRIVE_TRAIN, JOYSTICK_DRIVE_LEFT, JOYSTICK_DRIVE_RIGHT));

      CameraServer.getInstance().startAutomaticCapture();
  }

  private void configureButtonBindings() {
    JoystickButton ShiftButton = new JoystickButton(JOYSTICK_DRIVE_RIGHT, Constants.OI.BUTTON_SHIFT);
    ShiftButton.whenPressed(new ToggleDrivetrainGearCommand(DRIVE_TRAIN));

    JoystickButton RunControlPanelButton = new JoystickButton(JOYSTICK_OPERATOR, Constants.OI.BUTTON_CONTROL_PANEL);
    RunControlPanelButton.whileHeld(new RunControlPanelWheelCommand(CONTROL_PANEL, Constants.Robot.MotorSpeeds.CONTROL_PANEL));

    JoystickButton ActuateControlPanel = new JoystickButton(JOYSTICK_OPERATOR, Constants.OI.BUTTON_ACTUATE_CONTROL_PANEL);
    ActuateControlPanel.whenPressed(new ToggleControlPanelWheelSolenoidCommand(CONTROL_PANEL));

    JoystickButton ActuateHood = new JoystickButton(JOYSTICK_OPERATOR, Constants.OI.BUTTON_ACTUATE_ADJUSTABLE_HOOD);
    ActuateHood.whenPressed(new ToggleAdjustableHoodSolenoidCommand(ADJUSTABLE_HOOD));

    JoystickButton RunTurretLeftButton = new JoystickButton(JOYSTICK_OPERATOR, Constants.OI.BUTTON_TURRET_LEFT);
    RunTurretLeftButton.whileHeld(new RunTurretCommand(TURRET, Constants.Robot.MotorSpeeds.TURRET_LEFT));

    JoystickButton RunTurretRightButton = new JoystickButton(JOYSTICK_OPERATOR, Constants.OI.BUTTON_TURRET_RIGHT);
    RunTurretRightButton.whileHeld(new RunTurretCommand(TURRET, Constants.Robot.MotorSpeeds.TURRET_RIGHT));

  }

  public Command getAutonomousRoutine() {
      return null;
  }
}