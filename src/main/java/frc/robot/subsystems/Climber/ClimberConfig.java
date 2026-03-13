package frc.robot.subsystems.Climber;

import frc.robot.hardware.config.MotorConfig;

public class ClimberConfig {
    public static MotorConfig getClimberMotorConfig() {
        MotorConfig climberMotorConfig = new MotorConfig();

        climberMotorConfig.setEncoderConversion(
            ClimberConstants.PositionConversionFactor,
            ClimberConstants.VelocityConversionFactor
        );

        climberMotorConfig.withKP(ClimberConstants.kP);
        climberMotorConfig.withKV(ClimberConstants.kV);
        climberMotorConfig.withKA(ClimberConstants.kA);

        climberMotorConfig.setInverted(ClimberConstants.Inverted);
        climberMotorConfig.setEncoderInverted(ClimberConstants.EncoderInverted);

        return climberMotorConfig;
    }
}
