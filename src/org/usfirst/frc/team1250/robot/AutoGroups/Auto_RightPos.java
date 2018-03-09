package org.usfirst.frc.team1250.robot.AutoGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.AutoCommands.CmdG_ScaleWhip;
import org.usfirst.frc.team1250.robot.AutoCommands.CmdG_StriaghtScale;
import org.usfirst.frc.team1250.robot.commands.Cmd_Popper;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleSwitch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auto_RightPos extends CommandGroup {

    public Auto_RightPos() {
    	
    	String autoMessage = Robot.DS_Msg;
    	
    	SmartDashboard.putString("input String", autoMessage);

    	if(autoMessage.equals("LR") || autoMessage.equals("RR"))
    	{
     		
    		addSequential(new CmdG_StriaghtScale(-1));
    		
    	}
    	else if(autoMessage.equals("RL") || autoMessage.equals("LL"))
    	{
    		//Left Switch case
//    		addParallel(new Cmd_AutoDrive(45));
     		addSequential(new CmdG_ScaleWhip(-1));
//     		addSequential(new Cmd_AutoTurn(90));
    	}
    	else
    	{
    		//RR - Do nothing else
    	}

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}