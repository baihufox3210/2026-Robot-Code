package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class RobotConstants {
    public static final double FieldLength = 16.54;
    public static final double FieldWidth = 8.07;

    public static final double AllianceDepth = 4.03;

    public static boolean isRedAlliance() {
        var alliance = DriverStation.getAlliance();

        if(alliance.isPresent()) return alliance.get() == DriverStation.Alliance.Red;
        return false;
    }
}
