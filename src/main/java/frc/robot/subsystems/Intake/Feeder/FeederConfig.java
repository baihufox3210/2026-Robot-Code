package frc.robot.subsystems.Intake.Feeder;

import frc.robot.hardware.config.MotorConfig;

public class FeederConfig {
    public static MotorConfig getFeederMotorConfig() {
        MotorConfig feederMotorConfig = new MotorConfig();
        feederMotorConfig.setInverted(FeederConstants.FeederInverted);
        return feederMotorConfig;
    }
}
