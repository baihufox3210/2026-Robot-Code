package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake.Feeder.Feeder;
import frc.robot.subsystems.Shooter.Shooter;

public class Shooting extends Command {
    private final Shooter shooter;
    private final Feeder feeder;

    public Shooting() {
        shooter = Shooter.getInstance();
        feeder = Feeder.getInstance();

        addRequirements(shooter, feeder);
    }

    @Override
    public void execute() {
        shooter.run();
        feeder.run();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
        feeder.stop();
    }
}
