package com.team2502.robot2020.command;

import com.team2502.robot2020.subsystem.AdjustableHoodSubsystem;
import edu.wpi.first.wpilibj2.command.InstantCommand;


public class ToggleAdjustableHoodSolenoidCommand extends InstantCommand {
    private final AdjustableHoodSubsystem hood;

    public ToggleAdjustableHoodSolenoidCommand(AdjustableHoodSubsystem hood){
        this.hood = hood;
        addRequirements(hood);
    }

    @Override
    public void initialize() {
        if(hood.isHoodUp()){
            hood.retractSolenoid();
        }
        else{
            hood.deploySolenoid();
        }
    }
}
