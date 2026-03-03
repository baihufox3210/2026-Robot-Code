package frc.robot.subsystems.Intake.Pivot;

import frc.robot.hardware.config.MotorConfig;

public class PivotConfig {
    public static MotorConfig getPivotMotorConfig() {
        MotorConfig pivotMotorConfig = new MotorConfig();

        pivotMotorConfig.setEncoderConversion(
            PivotConstants.PositionConversionFactor,
            PivotConstants.VelocityConversionFactor
        );

        pivotMotorConfig.withKP(PivotConstants.kP);
        pivotMotorConfig.withKV(PivotConstants.kV);
        pivotMotorConfig.withKS(PivotConstants.kS);

        return pivotMotorConfig;
    }
}
