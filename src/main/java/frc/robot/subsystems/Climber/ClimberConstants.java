package frc.robot.subsystems.Climber;

import frc.robot.hardware.Factory.MotorFactory.MotorModel;

public class ClimberConstants {
    public static final MotorModel ClimberMotorModel = MotorModel.NeoVortex;

    public static final int ClimberMotorID = 51;

    public static final double WheelRadius = 1.8;
    public static final double GearRatio = 125;

    public static final double PositionConversionFactor = 2 * Math.PI * WheelRadius / GearRatio;
    public static final double VelocityConversionFactor = PositionConversionFactor / 60;

    public static final double tolerance = 0.5;

    public static final double kP = 0.5;
    public static final double kV = 0.1;
    public static final double kA = 0.0;

    public static final double ClimberLength = 17.0;
    public static final double DownLength = 25.0;
}
