// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.Climber.Climbing;
import frc.robot.commands.Climber.ToggleClimberPosition;
import frc.robot.commands.Drivetrain.Drive;
import frc.robot.commands.Flywheel.Shooting;
import frc.robot.commands.Flywheel.SpinningIdle;
import frc.robot.commands.Intake.Intaking;
import frc.robot.commands.Intake.TogglePivotPosition;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Shooter.Flywheel.Flywheel;
import frc.robot.subsystems.Vision.Vision;

public class RobotContainer {
	private Drivetrain drivetrain = Drivetrain.getInstance();
	private Flywheel flywheel = Flywheel.getInstance();
	
	private CommandXboxController controller = new CommandXboxController(0);

	public RobotContainer() {
		new Vision(drivetrain::addVisionMeasurement);

		drivetrain.setDefaultCommand(new Drive(controller));
		flywheel.setDefaultCommand(new SpinningIdle());

		controller.rightBumper().whileTrue(new Shooting(controller));
		
		controller.leftBumper().onTrue(new TogglePivotPosition());

		controller.b().onTrue(new ToggleClimberPosition());
		controller.x().onTrue(new Climbing());

		controller.a().toggleOnTrue(new Intaking());
	}
	
	public Command getAutonomousCommand() {
		try {
			PathPlannerPath path = PathPlannerPath.fromPathFile("Example Path");
			return AutoBuilder.followPath(path);
		}
		catch (Exception e) {
			DriverStation.reportError("Big oops: " + e.getMessage(), e.getStackTrace());
        	return Commands.none();
		}
	}
}