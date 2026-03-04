package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake.Pivot.Pivot;
import frc.robot.subsystems.Intake.Pivot.Pivot.PivotMode;

public class TogglePivotPosition extends Command {
    private final Pivot pivot;
    private PivotMode targetMode; 

    public TogglePivotPosition() {
        pivot = Pivot.getInstance();
        addRequirements(pivot);
    }

    @Override
    public void initialize() {
        if(pivot.isPivotAtPosition(PivotMode.DOWN.getPosition())) targetMode = PivotMode.RETRACT;
        else targetMode = PivotMode.DOWN;

        pivot.setPosition(targetMode.getPosition());
    }

    @Override
    public boolean isFinished() {
        return pivot.isPivotAtPosition(targetMode.getPosition());
    }

    @Override
    public void end(boolean interrupted) {
        pivot.stop();
    }
}
