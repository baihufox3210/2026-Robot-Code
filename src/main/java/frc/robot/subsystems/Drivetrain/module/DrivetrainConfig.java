package frc.robot.subsystems.Drivetrain.module;

import frc.robot.hardware.config.MotorConfig;
import frc.robot.subsystems.Drivetrain.DrivetrainConstants.DriveMotorConfig;
import frc.robot.subsystems.Drivetrain.DrivetrainConstants.StreetMotorConfig;

public class DrivetrainConfig {
    public static MotorConfig getDriveMotorConfig() {
        MotorConfig driveMotorConfig = new MotorConfig();

        driveMotorConfig.setGearRatio(DriveMotorConfig.GearRatio);
        driveMotorConfig.setinertia(0.025);

        driveMotorConfig.setEncoderConversion(
            DriveMotorConfig.PositionConversionFactor,
            DriveMotorConfig.VelocityConversionFactor
        );

        driveMotorConfig.withKP(DriveMotorConfig.kP);
        driveMotorConfig.withKI(DriveMotorConfig.kI);
        driveMotorConfig.withKD(DriveMotorConfig.kD);

        driveMotorConfig.withKS(DriveMotorConfig.kS);
        driveMotorConfig.withKV(DriveMotorConfig.kV);
        driveMotorConfig.withKA(DriveMotorConfig.kA);

        return driveMotorConfig;
    }

    public static MotorConfig getStreetMotorConfig(double angleOffset) {
        MotorConfig streetMotorConfig = new MotorConfig();

        streetMotorConfig.setGearRatio(StreetMotorConfig.GearRatio);
        
        streetMotorConfig.setEncoderConversion(
            StreetMotorConfig.PositionConversionFactor,
            StreetMotorConfig.VelocityConversionFactor
        );

        streetMotorConfig.setEncoderInverted(StreetMotorConfig.EncoderInverted);

        streetMotorConfig.setPositionWrap(
            StreetMotorConfig.PositionWrapMin,
            StreetMotorConfig.PositionWrapMax
        );

        streetMotorConfig.withKP(StreetMotorConfig.kP);
        streetMotorConfig.withKI(StreetMotorConfig.kI);
        streetMotorConfig.withKD(StreetMotorConfig.kD);

        streetMotorConfig.withKS(StreetMotorConfig.kS);
        streetMotorConfig.withKV(StreetMotorConfig.kV);
        streetMotorConfig.withKA(StreetMotorConfig.kA);

        streetMotorConfig.setAngleOffset(angleOffset);

        streetMotorConfig.setFeedbackSensorType(StreetMotorConfig.feedbackSensorType);

        return streetMotorConfig;
    }
}
