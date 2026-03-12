package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake.Pivot.Pivot;
import frc.robot.subsystems.Intake.Pivot.Pivot.PivotMode;

public class TogglePivotPosition extends Command {
    private final Pivot pivot;
    private Command command;

    public TogglePivotPosition() {
        pivot = Pivot.getInstance();
    }

    @Override
    public void initialize() {
        if(pivot.getPivotState() == PivotMode.RETRACT) command = new setPivotPosition(PivotMode.DOWN.getPosition());
        else command = new setPivotPosition(PivotMode.RETRACT.getPosition());

        pivot.togglePivotState();

        command.schedule();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    private class setPivotPosition extends Command {
        private double position;

        public setPivotPosition(double position) {
            this.position = position;
            addRequirements(pivot);
        }

        @Override
        public void initialize() {
            pivot.setPosition(position);
        }

        @Override
        public boolean isFinished() {
            return pivot.isPivotAtPosition(position);
        }

        @Override 
        public void end(boolean interrupted) {
            if(!interrupted) pivot.stop();
        }
    }
}
