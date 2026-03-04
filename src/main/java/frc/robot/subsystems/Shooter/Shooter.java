package frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Factory.MotorFactory;
import frc.robot.hardware.interfaces.GenericMotor;

public class Shooter extends SubsystemBase {
    private static Shooter instance;

    private final GenericMotor shooterMotor;
    private final GenericMotor feederMotor;

    private Shooter() {
        shooterMotor = MotorFactory.createMotor(ShooterConstants.ShooterMotorID, ShooterConstants.ShooterMotorModel, ShooterConfig.getShooterMotorConfig());
        feederMotor = MotorFactory.createMotor(ShooterConstants.FeederMotorID, ShooterConstants.FeederMotorModel, ShooterConfig.getFeederMotorConfig());

        shooterMotor.configure();
        feederMotor.configure();
    }

    private void setShooterVelocity(double speed) {
        shooterMotor.setVelocity(speed);
    }

    private void setFeederSpeed(double speed) {
        feederMotor.set(speed);
    }

    public void run() {
        setShooterVelocity(ShooterConstants.ShooterSpeed);
        setFeederSpeed(ShooterConstants.FeederSpeed);
    }

    public void stop() {
        shooterMotor.stop();
        feederMotor.stop();
    }

    public static Shooter getInstance() {
        if(instance == null) instance = new Shooter();
        return instance;
    }
}
