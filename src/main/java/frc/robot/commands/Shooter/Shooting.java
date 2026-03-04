package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter.Shooter;

public class Shooting extends Command {
    private final Shooter shooter;

    public Shooting() {
        shooter = Shooter.getInstance();
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.run();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
