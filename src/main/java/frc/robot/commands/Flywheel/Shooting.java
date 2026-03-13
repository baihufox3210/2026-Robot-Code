package frc.robot.commands.Flywheel;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter.Feeder.Feeder;
import frc.robot.subsystems.Shooter.Flywheel.Flywheel;

public class Shooting extends Command {
    private final Flywheel flywheel;
    private final Feeder feeder;

    public Shooting() {
        this.flywheel = Flywheel.getInstance();
        this.feeder = Feeder.getInstance();

        addRequirements(flywheel, feeder);
    }

    @Override
    public void execute() {
        flywheel.runAutoVelocity();
        feeder.run();
    }

    @Override
    public void end(boolean interrupted) {
        feeder.stop();
    }
}