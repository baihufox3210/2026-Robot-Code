package frc.robot.utils;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.RobotConstants;
import frc.robot.utils.FieldZone.Zone;

public class AimingParameters {
    public static double getTargetHeading(Pose2d currentPose) {
        final Zone robotZone = FieldZone.getZone(currentPose);
        Translation2d targetPosition = new Translation2d();

        if(robotZone == Zone.ALLIANCE) targetPosition = FieldTransformer.transform(RobotConstants.AllianceHub);

        Translation2d relativeTranslation = targetPosition.minus(currentPose.getTranslation());
        
        return relativeTranslation.getAngle().getRadians();
    }
}
