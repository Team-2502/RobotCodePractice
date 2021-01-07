package com.team2502.robot2020.command;

import com.team2502.robot2020.subsystem.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunTurretEncoderCommand extends CommandBase {
    private final TurretSubsystem turret;
    private final double speed;

    public RunTurretEncoderCommand(TurretSubsystem turret, double speed){
        this.turret = turret;
        this.speed = speed;
        addRequirements(turret);
    }

    @Override
    public void initialize(){
        turret.runMotor(speed);
    }

    @Override
    public void end(boolean interrupted){
        turret.runMotor(0);
    }

    @Override
    public boolean isFinished()
    {
        return turret.getEncoderValue() > 3000 || turret.getEncoderValue() < -3000;
    }
}
