package frc.robot.utils;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.RobotConstants;
import frc.robot.utils.FieldZone.Zone;

public class AimingParameters {
    public static double getTargetHeading(Pose2d currentPose) {
        Translation2d targetPosition = getTargetPosition(currentPose);
        Translation2d relativeTranslation = targetPosition.minus(currentPose.getTranslation());
        
        return relativeTranslation.getAngle().getRadians();
    }

    public static double getDistance(Pose2d currentPose) {
        Translation2d targetPosition = getTargetPosition(currentPose);
        return currentPose.getTranslation().getDistance(targetPosition);
    }

    private static Translation2d getTargetPosition(Pose2d currentPose) {
        final Zone robotZone = FieldZone.getZone(currentPose);

        if(robotZone == Zone.ALLIANCE) return FieldTransformer.transform(RobotConstants.AllianceHub.toTranslation2d());
        if(robotZone == Zone.OPPONENT) return FieldTransformer.transform(RobotConstants.AllianceHub.toTranslation2d(), !RobotConstants.isRedAlliance());

        Translation2d baseFerryTarget = RobotConstants.FerryTarget;
        boolean isLeftSide = currentPose.getY() > RobotConstants.FieldSize.getY() / 2;
        
        if(!isLeftSide) {
            baseFerryTarget = new Translation2d(
                baseFerryTarget.getX(),
                RobotConstants.FieldSize.getY() - baseFerryTarget.getY()
            );
        }

        return FieldTransformer.transform(baseFerryTarget);
    }
}