package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation;

public class RobotConstants {
    public static final double Deadband = 0.1;

    public static final double DeltaSecond = 0.02;

    public static final Translation2d FieldSize = new Translation2d(16.54, 8.07);
    public static final Translation2d AllianceHub = new Translation2d(4.07, 4.03);
    public static final Translation2d FerryTarget = new Translation2d(2.5, 2.0);

    public static final double AllianceDepth = 4.03;

    public static boolean isRedAlliance() {
        var alliance = DriverStation.getAlliance();

        if(alliance.isPresent()) return alliance.get() == DriverStation.Alliance.Red;
        return false;
    }
}
