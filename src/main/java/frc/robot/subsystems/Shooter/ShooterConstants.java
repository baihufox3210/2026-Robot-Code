package frc.robot.subsystems.Shooter;

import frc.robot.hardware.Factory.MotorFactory.MotorModel;

public class ShooterConstants {
    public static final MotorModel ShooterMotorModel = MotorModel.KrakenX60;
    public static final MotorModel FeederMotorModel = MotorModel.Neo;

    public static final int ShooterMotorID = 41;
    public static final int FeederMotorID = 42;
    
    public static final int ShooterSpeed = 50;
    public static final double FeederSpeed = 0.6;

    public class InnerShooterConstants {
        public static final boolean Inverted = true;

        public static final double kP = 1;
    }
}
