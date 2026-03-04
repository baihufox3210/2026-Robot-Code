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
import frc.robot.commands.Intake.Intaking;
import frc.robot.commands.Intake.TogglePivotPosition;
import frc.robot.commands.Shooter.Shooting;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class RobotContainer {
	private Drivetrain drivetrain = Drivetrain.getInstance();
	
	private CommandXboxController controller = new CommandXboxController(0);

	public RobotContainer() {
		drivetrain.setDefaultCommand(new Drive(controller));

		controller.b().onTrue(new ToggleClimberPosition());
		controller.x().onTrue(new Climbing());

		controller.leftBumper().onTrue(new TogglePivotPosition());

		controller.rightBumper().whileTrue(new Shooting());

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