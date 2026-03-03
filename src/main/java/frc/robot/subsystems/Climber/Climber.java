package frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Factory.MotorFactory;
import frc.robot.hardware.interfaces.GenericEncoder;
import frc.robot.hardware.interfaces.GenericMotor;

public class Climber extends SubsystemBase {
    private static Climber instance;

    private GenericMotor climberMotor;
    private GenericEncoder climberEncoder;

    public Climber() {
        climberMotor = MotorFactory.createMotor(ClimberConstants.ClimberMotorID, ClimberConstants.ClimberMotorModel, ClimberConfig.getClimberMotorConfig());
        climberEncoder = climberMotor.getEncoder();

        climberMotor.configure();
    }

    public void setPosition(double position) {
        climberMotor.setPosition(position);
    }

    public void stop() {
        climberMotor.stop();
    }

    public boolean isClimberAtPosition(double position) {
        return Math.abs(climberEncoder.getPosition() - position) < ClimberConstants.tolerance;
    }

    public static Climber getInstance() {
        if (instance == null) instance = new Climber();
        return instance;
    }

    public enum ClimberMode {
        CLIMB(ClimberConstants.ClimberLength),
        DOWN(ClimberConstants.DownLength),
        RETRACT(0);

        private final double position;

        ClimberMode(double position) {
            this.position = position;
        }

        public double getPosition() {
            return position;
        }
    }
}
