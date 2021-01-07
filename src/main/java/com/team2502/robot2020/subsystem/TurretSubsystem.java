package com.team2502.robot2020.subsystem;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.team2502.robot2020.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {
    public final CANSparkMax turret;
    private final CANEncoder turretEncoder;

    public TurretSubsystem(){
        turret = new CANSparkMax(Constants.RobotMap.Motors.TURRET, CANSparkMaxLowLevel.MotorType.kBrushless);
        turret.setSmartCurrentLimit(35);
        turretEncoder = turret.getEncoder();
    }

    @Override
    public void periodic(){ }

    public void runMotor(double speed){
        turret.set(speed);
    }

    public double getEncoderValue(){ return turretEncoder.getPosition(); }
}
