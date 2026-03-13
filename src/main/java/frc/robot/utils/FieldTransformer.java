package frc.robot.utils;

import frc.robot.RobotConstants;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

public class FieldTransformer {
    private FieldTransformer() {}

    public static Translation2d transform(Translation2d blueAlliancePose) {
        if(RobotConstants.isRedAlliance()) return mirror(blueAlliancePose);
        return blueAlliancePose;
    }

    private static Translation2d mirror(Translation2d pose) {
        return new Translation2d(
            RobotConstants.FieldSize.getX() - pose.getX(),
            pose.getY()
        );
    }

    public static Pose2d transform(Pose2d blueAlliancePose) {
        if(RobotConstants.isRedAlliance()) return mirror(blueAlliancePose);
        return blueAlliancePose;
    }

    private static Pose2d mirror(Pose2d pose) {
        return new Pose2d(
            RobotConstants.FieldSize.getX() - pose.getX(),
            pose.getY(),
            pose.getRotation().plus(Rotation2d.k180deg)
        );
    }
}
