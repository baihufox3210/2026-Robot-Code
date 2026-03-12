package frc.robot.subsystems.Shooter.Feeder;

import frc.robot.hardware.Factory.MotorFactory.MotorModel;
import frc.robot.hardware.config.MotorConfig.NeutralMode;

public class FeederConstants {
    public static final MotorModel ElevatorMotorModel = MotorModel.Neo;
    public static final MotorModel IndexerMotorModel = MotorModel.KrakenX60;

    public static final NeutralMode ElevatorMotorNeutralMode = NeutralMode.COAST;
    public static final NeutralMode IndexerMotorNeutralMode = NeutralMode.COAST;
    
    public static final int ElevatorMotorID = 42;
    public static final int IndexerMotorID = 43;

    public static final double ElevatorMotorSpeed = 0.3;
    public static final double IndexerMotorSpeed = 0.4;
}
