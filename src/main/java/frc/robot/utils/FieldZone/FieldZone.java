package frc.robot.utils.FieldZone;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;

public class FieldZone {
    public enum Zone {
        ALLIANCE, NEUTRAL, OPPONENT;
    }

    public static Zone getZone(Pose2d pose) {
        double x = pose.getX();
        if(isRedAlliance()) x = FieldZoneConstants.FieldLength - x;

        if(x <= FieldZoneConstants.AllianceDepth) return Zone.ALLIANCE;
        else if(x <= FieldZoneConstants.FieldLength - FieldZoneConstants.AllianceDepth) return Zone.NEUTRAL;
        else return Zone.OPPONENT;
    }

    private static boolean isRedAlliance() {
        var alliance = DriverStation.getAlliance();
        
        if(alliance.isPresent()) return alliance.get() == DriverStation.Alliance.Red;
        return false;
    }
}
