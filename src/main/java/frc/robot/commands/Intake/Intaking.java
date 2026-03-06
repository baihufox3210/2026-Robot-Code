package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake.Feeder.Feeder;
import frc.robot.subsystems.Intake.Feeder.Feeder.FeederMode;
import frc.robot.subsystems.Intake.Roller.Roller;

public class Intaking extends Command {
    private final Roller roller;

    public Intaking() {
        feeder = Feeder.getInstance();

        addRequirements(roller);
    }

    @Override
    public void execute() {
        roller.run();
    }

    @Override
    public void end(boolean interrupted) {
        roller.stop();
    }
}
