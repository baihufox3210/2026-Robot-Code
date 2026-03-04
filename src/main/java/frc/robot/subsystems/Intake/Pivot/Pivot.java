package frc.robot.subsystems.Intake.Pivot;

import static edu.wpi.first.units.Units.Radians;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Factory.MotorFactory;
import frc.robot.hardware.interfaces.GenericEncoder;
import frc.robot.hardware.interfaces.GenericMotor;

public class Pivot extends SubsystemBase {
    private static Pivot instance;

    private final GenericMotor pivotMotor;
    private final GenericEncoder pivotEncoder;

    private Pivot() {
        pivotMotor = MotorFactory.createMotor(PivotConstants.PivotMotorID, PivotConstants.PivotMotorModel, PivotConfig.getPivotMotorConfig());
        pivotEncoder = pivotMotor.getEncoder();

        pivotMotor.configure();
    }

    public void setPosition(double position) {
        pivotMotor.setPosition(position);
    }

    public void stop() {
        pivotMotor.stop();
    }

    public boolean isPivotAtPosition(double position) {
        return Math.abs(pivotEncoder.getPosition() - position) < PivotConstants.tolerance.in(Radians);
    }

    public static Pivot getInstance() {
        if (instance == null) instance = new Pivot();
        return instance;
    }

    public enum PivotMode {
        DOWN(PivotConstants.DownAngle.in(Radians)),
        RETRACT(0);

        private final double position;

        PivotMode(double position) {
            this.position = position;
        }

        public double getPosition() {
            return position;
        }
    }
}
