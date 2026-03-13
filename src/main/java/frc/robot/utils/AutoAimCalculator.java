package frc.robot.utils;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.RobotConstants;
import frc.robot.utils.FieldZone.Zone;

public class AutoAimCalculator {
    private AutoAimCalculator() {}

    public static double getTargetHeading(Pose2d robotPose) {
        final Zone robotZone = FieldZone.getZone(robotPose);
        Translation2d targetPosition = new Translation2d();

        if(robotZone == Zone.ALLIANCE) targetPosition = FieldTransformer.transform(RobotConstants.AllianceHub);

        Translation2d relativeTranslation = targetPosition.minus(robotPose.getTranslation());
        
        return relativeTranslation.getAngle().getRadians();
    }
}
