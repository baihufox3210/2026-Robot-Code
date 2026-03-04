package frc.robot.subsystems.Intake.Pivot;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;
import frc.robot.hardware.Factory.MotorFactory.MotorModel;

public class PivotConstants {
    public static final MotorModel PivotMotorModel = MotorModel.NeoVortex;

    public static final int PivotMotorID = 31;

    public static final double GearRatio = 25 * 34 / 20.0;

    public static final double PositionConversionFactor = 2 * Math.PI / GearRatio;
    public static final double VelocityConversionFactor = PositionConversionFactor / 60;

    public static final double kP = 0.25;
    public static final double kV = 0.05;
    public static final double kS = 0.0;

    public static final Angle DownAngle = Degrees.of(95);
    public static final Angle tolerance = Degrees.of(5);
}
