package com.team2502.robot2020.subsystem;


import com.team2502.robot2020.Constants;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AdjustableHoodSubsystem extends SubsystemBase {
    private final Solenoid adjustableHoodSolenoid;

    public AdjustableHoodSubsystem(){
        adjustableHoodSolenoid = new Solenoid(Constants.RobotMap.Solenoid.ADJUSTABLE_HOOD);
        retractSolenoid();
    }

    @Override
    public void periodic(){ }

    public void deploySolenoid() { adjustableHoodSolenoid.set(true); }

    public void retractSolenoid() {
        adjustableHoodSolenoid.set(false);
    }

    public boolean isHoodUp() { return adjustableHoodSolenoid.get(); }
}
