package frc.robot.subsystems.Intake.Roller;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Factory.MotorFactory;
import frc.robot.hardware.interfaces.GenericMotor;

public class Roller extends SubsystemBase {
    private static Roller instance;

    private final GenericMotor rollerMotor;

    public Roller() {
        rollerMotor = MotorFactory.createMotor(RollerConstants.RollerMotorID, RollerConstants.RollerMotorModel, RollerConfig.getRollerMotorConfig());
        rollerMotor.configure();
    }

    public void setSpeed(double speed) {
        rollerMotor.set(speed);
    }

    public void run() {
        setSpeed(RollerConstants.RollerIntakeSpeed);
    }

    public void stop() {
        rollerMotor.stop();
    }

    public static Roller getInstance() {
        if (instance == null) instance = new Roller();
        return instance;
    }
}
