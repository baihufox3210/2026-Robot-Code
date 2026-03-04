package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climber.Climber;
import frc.robot.subsystems.Climber.Climber.ClimberMode;

public class ToggleClimberPosition extends Command {
    private final Climber climber;
    private ClimberMode targetMode;

    public ToggleClimberPosition() {
        climber = Climber.getInstance();
        addRequirements(climber);
    }

    @Override
    public void initialize() {
        if(climber.isClimberAtPosition(ClimberMode.RETRACT.getPosition())) targetMode = ClimberMode.DOWN;
        else targetMode = ClimberMode.RETRACT;
        
        climber.setPosition(targetMode.getPosition());
    }

    @Override
    public boolean isFinished() {
        return climber.isClimberAtPosition(targetMode.getPosition());
    }

    @Override
    public void end(boolean interrupted) {
        climber.stop();
    }
}
