package frc.robot.subsystems.Shooter.Feeder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Factory.MotorFactory;
import frc.robot.hardware.interfaces.GenericMotor;

public class Feeder extends SubsystemBase {
    private static Feeder instance;

    private final GenericMotor elevatorMotor;
    private final GenericMotor indexerMotor;

    private Feeder() {
        elevatorMotor = MotorFactory.createMotor(FeederConstants.ElevatorMotorID, FeederConstants.ElevatorMotorModel, FeederConfig.getElevatorMotorConfig());
        indexerMotor = MotorFactory.createMotor(FeederConstants.IndexerMotorID, FeederConstants.IndexerMotorModel, FeederConfig.getIndexerMotorConfig());

        elevatorMotor.configure();
        indexerMotor.configure();
    }

    private void setSpeed(double elevatorMotorSpeed, double indexerMotorSpeed) {
        elevatorMotor.set(elevatorMotorSpeed);
        indexerMotor.set(indexerMotorSpeed);
    }

    public void run() {
        setSpeed(FeederConstants.ElevatorMotorSpeed, FeederConstants.IndexerMotorSpeed);
    }

    public void stop() {
        elevatorMotor.stop();
        indexerMotor.stop();
    }

    public static Feeder getInstance() {
        if(instance == null) instance = new Feeder();
        return instance;
    }
}
