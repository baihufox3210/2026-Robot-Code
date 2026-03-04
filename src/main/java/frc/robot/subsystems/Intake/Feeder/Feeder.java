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

    public void setSpeed(double speed) {
        feederMotor.set(speed);
    }

    public void stop() {
        feederMotor.stop();
    }

    public static Feeder getInstance() {
        if (instance == null) instance = new Feeder();
        return instance;
    }

    public enum FeederMode {
        INTAKE(FeederConstants.FeederIntakeSpeed),
        SHOOTING(FeederConstants.FeederShootingSpeed);

        private final double speed;

        FeederMode(double speed) {
            this.speed = speed;
        }

        public double getSpeed() {
            return speed;
        }
    }
}
