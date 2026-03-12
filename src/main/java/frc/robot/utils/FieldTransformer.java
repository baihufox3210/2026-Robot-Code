package frc.robot.utils;

import frc.robot.RobotConstants;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public class FieldTransformer {
    private FieldTransformer() {}

    public static Pose2d transform(Pose2d blueAlliancePose) {
        if(RobotConstants.isRedAlliance()) return mirror(blueAlliancePose);
        return blueAlliancePose;
    }

    private static Pose2d mirror(Pose2d pose) {
        return new Pose2d(
            RobotConstants.FieldLength - pose.getX(),
            pose.getY(),
            pose.getRotation().plus(Rotation2d.k180deg)
        );
    }
}
