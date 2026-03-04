package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climber.Climber;
import frc.robot.subsystems.Climber.Climber.ClimberMode;

public class Climbing extends Command {
    private final Climber climber;

    public Climbing() {
        climber = Climber.getInstance();
        addRequirements(climber);
    }

    @Override
    public void execute() {
        if(climber.isClimberAtPosition(ClimberMode.RETRACT.getPosition())) {
            climber.setPosition(ClimberMode.CLIMB.getPosition());
        }
    }

    @Override
    public boolean isFinished() {
        return climber.isClimberAtPosition(ClimberMode.CLIMB.getPosition());
    }

    @Override
    public void end(boolean interrupted) {
        climber.stop();
    }
}
