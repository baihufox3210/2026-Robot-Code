package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake.Feeder.Feeder;
import frc.robot.subsystems.Intake.Feeder.Feeder.FeederMode;
import frc.robot.subsystems.Intake.Roller.Roller;

public class Intaking extends Command {
    private final Roller roller;
    private final Feeder feeder;

    public Intaking() {
        roller = Roller.getInstance();
        feeder = Feeder.getInstance();

        addRequirements(roller, feeder);
    }

    @Override
    public void execute() {
        roller.run();
        feeder.setSpeed(FeederMode.INTAKE.getSpeed());
    }

    @Override
    public void end(boolean interrupted) {
        roller.stop();
        feeder.stop();
    }
}
