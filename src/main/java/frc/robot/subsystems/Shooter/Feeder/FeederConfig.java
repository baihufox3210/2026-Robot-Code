package frc.robot.subsystems.Shooter.Feeder;

import frc.robot.hardware.config.MotorConfig;

public class FeederConfig {
    public static MotorConfig getElevatorMotorConfig() {
        MotorConfig elevatorMotorConfig = new MotorConfig();
        elevatorMotorConfig.setNeutralMode(FeederConstants.ElevatorMotorNeutralMode);

        return elevatorMotorConfig;
    }

    public static MotorConfig getIndexerMotorConfig() {
        MotorConfig indexerMotorConfig = new MotorConfig();
        indexerMotorConfig.setNeutralMode(FeederConstants.IndexerMotorNeutralMode);
        
        return indexerMotorConfig;
    }   
}