package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.utils.InputTransform;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Drive extends Command {
    private final Drivetrain drivetrain;
    private final CommandXboxController controller;

    public Drive(CommandXboxController controller) {
        this.controller = controller;
        this.drivetrain = Drivetrain.getInstance();
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        double xSpeed = -InputTransform.applyDeadband(controller.getLeftY());
        double ySpeed = -InputTransform.applyDeadband(controller.getLeftX());
        double rotSpeed = -InputTransform.applyDeadband(controller.getRightX());

        drivetrain.drive(xSpeed, ySpeed, rotSpeed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}