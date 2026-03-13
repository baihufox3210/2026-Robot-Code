package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation;

public class RobotConstants {
    public static final Translation2d FieldSize = new Translation2d(16.54, 8.07);

    public static final double AllianceDepth = 4.03;

    public static boolean isRedAlliance() {
        var alliance = DriverStation.getAlliance();

        if(alliance.isPresent()) return alliance.get() == DriverStation.Alliance.Red;
        return false;
    }
}
