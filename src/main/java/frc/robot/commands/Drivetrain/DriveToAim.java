package frc.robot.commands.Drivetrain;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.utils.AimingParameters;
import frc.robot.utils.InputTransform;

public class DriveToAim extends Command {
    private final Drivetrain drivetrain;
    private final PIDController rotationPID = new PIDController(1.0, 0, 0);

    private final CommandXboxController controller;

    public DriveToAim(CommandXboxController controller) {
        this.controller = controller;
        this.drivetrain = Drivetrain.getInstance();
        
        rotationPID.enableContinuousInput(-Math.PI, Math.PI);
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        Pose2d currentPose = drivetrain.getPose();

        double targetAngle = AimingParameters.getTargetHeading(currentPose);

        double xSpeed = -InputTransform.applyDeadband(controller.getLeftY());
        double ySpeed = -InputTransform.applyDeadband(controller.getLeftX());
        double rotation = rotationPID.calculate(drivetrain.getHeading().getRadians(), targetAngle);

        drivetrain.drive(xSpeed, ySpeed, rotation);
    }
}
