package frc.robot.subsystems.Intake.Feeder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Factory.MotorFactory;
import frc.robot.hardware.interfaces.GenericMotor;

public class Feeder extends SubsystemBase {
    private static Feeder instance;

    private final GenericMotor feederMotor;

    private Feeder() {
        feederMotor = MotorFactory.createMotor(FeederConstants.FeederMotorID, FeederConstants.FeederMotorModel, FeederConfig.getFeederMotorConfig());
        feederMotor.configure();
    }

    private void setSpeed(double speed) {
        feederMotor.set(speed);
    }

    public void run() {
        setSpeed(FeederConstants.ShootingSpeed);
    }

    public void stop() {
        feederMotor.stop();
    }

    public static Feeder getInstance() {
        if (instance == null) instance = new Feeder();
        return instance;
    }
}
