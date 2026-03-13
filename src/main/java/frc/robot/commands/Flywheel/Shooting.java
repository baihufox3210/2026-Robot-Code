package frc.robot.commands.Flywheel;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Shooter.Feeder.Feeder;
import frc.robot.subsystems.Shooter.Flywheel.Flywheel;

public class Shooting extends Command {
    private final CommandXboxController controller;
    private static final double DEADBAND = 0.1;

    private final Drivetrain drivetrain;

    private final Flywheel flywheel;
    private final Feeder feeder;

    public Shooting(CommandXboxController controller) {
        this.controller = controller;

        this.drivetrain = Drivetrain.getInstance();

        this.flywheel = Flywheel.getInstance();
        this.feeder = Feeder.getInstance();

        addRequirements(drivetrain, flywheel, feeder);
    }

    @Override
    public void execute() {
        double xSpeed = -applyDeadband(controller.getLeftY());
        double ySpeed = -applyDeadband(controller.getLeftX());

        flywheel.runAutoVelocity();
        feeder.run();

        drivetrain.driveAutoAim(xSpeed, ySpeed);
    }

    @Override
    public void end(boolean interrupted) {
        feeder.stop();
    }

    private double applyDeadband(double value) {
        return MathUtil.applyDeadband(value, DEADBAND);
    }
}
