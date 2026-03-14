package frc.robot.subsystems.Shooter.Flywheel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Factory.MotorFactory;
import frc.robot.hardware.interfaces.GenericEncoder;
import frc.robot.hardware.interfaces.GenericMotor;

public class Flywheel extends SubsystemBase {
    private static Flywheel instance;

    private final GenericMotor flywheelMotor;
    private final GenericEncoder flywheelEncoder;

    private Flywheel() {
        flywheelMotor = MotorFactory.createMotor(FlywheelConstants.FlywheelMotorID, FlywheelConstants.FlywheelMotorModel, FlywheelConfig.getFlywheelMotorConfig());        
        flywheelMotor.configure();

        flywheelEncoder = flywheelMotor.getEncoder();
    }

    @Override
    public void periodic() {
        double currentVelocity = flywheelEncoder.getVelocity();
        SmartDashboard.putNumber("FLywheel/Current Veloctiy", currentVelocity);
    }


    private void setVelocity(double speed) {
        flywheelMotor.setVelocity(speed);
    }

    public void spinningIdle() {
        setVelocity(FlywheelConstants.IdleSpeed);
    }

    public void runAutoVelocity() {
        setVelocity(80);
    }

    public void stop() {
        flywheelMotor.stop();
    }

    public static Flywheel getInstance() {
        if(instance == null) instance = new Flywheel();
        return instance;
    }
}