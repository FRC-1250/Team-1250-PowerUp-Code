package org.usfirst.frc.team1250.robot.groups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleTimedPinch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeCollectTimed;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakePinch;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeUnPinch;
import org.usfirst.frc.team1250.robot.test.Cmd_IntakeTest;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_TimedCollect extends CommandGroup {

    public CmdG_TimedCollect() {
    	requires(Robot.s_intake);
    	requires(Robot.s_elevator);
    	
    	addSequential(new Cmd_IntakeUnPinch());
    	addParallel(new Cmd_IntakeCollectTimed(2));
    	addSequential(new Cmd_EleTimedPinch(.5));
    	addSequential(new Cmd_IntakePinch());
    	
    }
}