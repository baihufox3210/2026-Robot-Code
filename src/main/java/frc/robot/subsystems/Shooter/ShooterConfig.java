package frc.robot.subsystems.Shooter;

import frc.robot.hardware.config.MotorConfig;
import frc.robot.subsystems.Shooter.ShooterConstants.InnerShooterConstants;

public class ShooterConfig {
    public static MotorConfig getShooterMotorConfig() {
        MotorConfig shooterMotorConfig = new MotorConfig();

        shooterMotorConfig.setInverted(InnerShooterConstants.Inverted);

        shooterMotorConfig.withKP(InnerShooterConstants.kP);

        shooterMotorConfig.setCruiseVelocity(InnerShooterConstants.cruiseVelocity);
        shooterMotorConfig.setMaxAcceleration(InnerShooterConstants.maxAcceleration);

        return shooterMotorConfig;
    }
    
    public static MotorConfig getFeederMotorConfig() {
        MotorConfig feederMotorConfig = new MotorConfig();
        return feederMotorConfig;
    }
}
