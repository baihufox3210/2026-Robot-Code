package frc.robot.subsystems.Drivetrain.module;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.hardware.Factory.MotorFactory;
import frc.robot.hardware.interfaces.GenericEncoder;
import frc.robot.hardware.interfaces.GenericMotor;
import frc.robot.subsystems.Drivetrain.DrivetrainConstants;

public class SwerveModule {
    private final GenericMotor driveMotor;
    private final GenericMotor streetMotor;

    private final GenericEncoder driveEncoder;
    private final GenericEncoder streetEncoder;

    private SwerveModuleState desiredState;

    public SwerveModule(int driveMotorID, int streetMotorID, double angleOffset) {
        driveMotor = MotorFactory.createMotor(driveMotorID, DrivetrainConstants.driveMotorModel, DrivetrainConfig.getDriveMotorConfig());
        streetMotor = MotorFactory.createMotor(streetMotorID, DrivetrainConstants.streetMotorModel, DrivetrainConfig.getStreetMotorConfig(angleOffset));

        driveEncoder = driveMotor.getEncoder();
        streetEncoder = streetMotor.getAbsoluteEncoder();

        driveMotor.configure();
        streetMotor.configure();

        resetEncoder();

        desiredState = new SwerveModuleState();
        desiredState.angle = new Rotation2d(streetEncoder.getPosition());
    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(
            driveEncoder.getVelocity(),
            new Rotation2d(streetEncoder.getPosition())
        );
    }

    public SwerveModulePosition getPosition() {
        return new SwerveModulePosition(
            driveEncoder.getPosition(),
            new Rotation2d(streetEncoder.getPosition())
        );
    }

    public void resetEncoder() {
        driveEncoder.setPosition(0);
    }

    public void setDesiredState(SwerveModuleState desiredState) {
        desiredState.optimize(new Rotation2d(streetEncoder.getPosition()));

        driveMotor.setVelocity(desiredState.speedMetersPerSecond);
        streetMotor.setPosition(desiredState.angle.getRadians());

        this.desiredState = desiredState;
    }

    public void stop() {
        driveMotor.stop();
        streetMotor.stop();
    }
}