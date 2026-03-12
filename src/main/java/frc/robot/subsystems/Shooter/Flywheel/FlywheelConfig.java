package frc.robot.subsystems.Shooter.Flywheel;

import frc.robot.hardware.config.MotorConfig;

public class FlywheelConfig {
    public static MotorConfig getFlywheelMotorConfig() {
        MotorConfig flywheelMotorConfig = new MotorConfig();

        flywheelMotorConfig.setInverted(FlywheelConstants.Inverted);

        flywheelMotorConfig.setNeutralMode(FlywheelConstants.FlywheelNeutralMode);
        
        flywheelMotorConfig.withKP(FlywheelConstants.kP);
        flywheelMotorConfig.withKV(FlywheelConstants.kV);

        return flywheelMotorConfig;
    }
}
