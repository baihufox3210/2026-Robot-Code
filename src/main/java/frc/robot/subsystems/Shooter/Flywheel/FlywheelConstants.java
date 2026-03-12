package frc.robot.subsystems.Shooter.Flywheel;

import frc.robot.hardware.Factory.MotorFactory.MotorModel;
import frc.robot.hardware.config.MotorConfig.NeutralMode;

public class FlywheelConstants {
    public static final MotorModel FlywheelMotorModel = MotorModel.KrakenX60;

    public static final int FlywheelMotorID = 41;

    public static final boolean Inverted = true;

    public static final NeutralMode FlywheelNeutralMode = NeutralMode.COAST;

    public static final double kP = 1.0;
    public static final double kV = 0.12;

    public static final double IdleSpeed = 30;
}
