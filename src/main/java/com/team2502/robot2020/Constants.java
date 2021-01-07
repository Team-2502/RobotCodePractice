/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team2502.robot2020;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class OI {

        public static final int JOYSTICK_DRIVE_RIGHT = 0;
        public static final int JOYSTICK_DRIVE_LEFT = 1;
        public static final int JOYSTICK_OPERATOR = 2;

        // Buttons on JOYSTICK_DRIVE_RIGHT
        public static final int BUTTON_SHIFT = 1;

        // Buttons on JOYSTICK_DRIVE_LEFT

        // Buttons on JOYSTICK_OPERATOR
        public static final int BUTTON_CONTROL_PANEL = 9;
        public static final int BUTTON_ACTUATE_CONTROL_PANEL = 11;
        public static final int BUTTON_TURRET_RIGHT = 1;
        public static final int BUTTON_TURRET_LEFT = 2;
        public static final int BUTTON_ACTUATE_ADJUSTABLE_HOOD = 3;
    }

    public static final class RobotMap {

        public static final class Motors {
            // Talon FX
            public static final int DRIVE_FRONT_RIGHT = 1;
            public static final int DRIVE_FRONT_LEFT = 3;
            public static final int DRIVE_BACK_RIGHT = 2;
            public static final int DRIVE_BACK_LEFT = 4;

            // Talon SRX

            // SparkMax
            public static final int CONTROL_PANEL = 57;
            public static final int TURRET = 1;
        }

        public static final class Solenoid {
            public static final int DRIVETRAIN = 0;
            public static final int CONTROL_PANEL = 2;
            public static final int ADJUSTABLE_HOOD = 3;
        }
    }

    public static final class Robot {

        public static final class MotorSpeeds {
            public static final double CONTROL_PANEL = 0.6;
            public static final double TURRET_LEFT = -1;
            public static final double TURRET_RIGHT = 1;
        }

        public static final class Shooter{

        }

        public static final class Vision {

        }

        public static final class Auto {
            public static final boolean GYRO_REVERSED = true;
        }
    }

}
