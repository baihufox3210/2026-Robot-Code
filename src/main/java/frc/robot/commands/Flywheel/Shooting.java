package frc.robot.commands.Flywheel;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Shooter.Feeder.Feeder;
import frc.robot.subsystems.Shooter.Flywheel.Flywheel;
import frc.robot.utils.InputTransform;

public class Shooting extends Command {
    private final CommandXboxController controller;

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
        double xSpeed = -InputTransform.applyDeadband(controller.getLeftY());
        double ySpeed = -InputTransform.applyDeadband(controller.getLeftX());

        flywheel.runAutoVelocity();
        feeder.run();

        drivetrain.driveAutoAim(xSpeed, ySpeed);
    }

    @Override
    public void end(boolean interrupted) {
        feeder.stop();
    }
}
