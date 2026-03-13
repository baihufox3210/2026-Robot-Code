package frc.robot.utils;

import frc.robot.RobotConstants;
import edu.wpi.first.math.geometry.Pose2d;

public class FieldZone {
    public enum Zone {
        ALLIANCE, NEUTRAL, OPPONENT;
    }

    public static Zone getZone(Pose2d pose) {
        double x = pose.getX();
        if(RobotConstants.isRedAlliance()) x = RobotConstants.FieldSize.getX() - x;

        if(x <= RobotConstants.AllianceDepth) return Zone.ALLIANCE;
        else if(x <= RobotConstants.FieldSize.getX() - RobotConstants.AllianceDepth) return Zone.NEUTRAL;
        else return Zone.OPPONENT;
    }
}
