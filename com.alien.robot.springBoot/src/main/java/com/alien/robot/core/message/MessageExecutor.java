/**
 * Copyright 2020 Alien
   Created on 31/07/20207:32:40 AM  by Ayman Elgharabawy
   
   /**** Command Pattern*****
________________            ____________________       
|MessageExecutor |          |   IMessageCommand  |
|----------------|          |--------------------|          
|  setCommand()  |<>--------|    execute()       |
|  Commit()      |          |                    | 
|________________|          |____________________|
      |                              ^
      |                              |_____________________________________________________      
______|_________            _________|___________      _________|___________      _________|___________  
|  MessageLoader |          |   DBStateMessage    |    |  PythonStateMessage |    |  JavaStateMessage   | 
|----------------|          |---------------------|    |---------------------|    |---------------------|     
|                |          |                     |    |                     |    |                     |
|                |          |                     |    |                     |    |                     |
|________________|          |_____________________|    |_____________________|    |_____________________|

 */
package com.alien.robot.core.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class MessageExecutor. This class the remotecontrol to execute the
 * command pattern to execute each message request/response.
 */
@Component
public class MessageExecutor {

	/** The mcommand. */
	@Autowired
	@Qualifier("DBStateMessage")
	private IMessageCommand mCommand;

	/**
	 * Sets the command.
	 *
	 * @param mcommand the new command
	 */
	@Autowired
	@Qualifier("DBStateMessage")
	public void setCommand(IMessageCommand mcommand) {
		this.mCommand = mcommand;
	}

	/**
	 * Commit.
	 */
	public void commit() {
		mCommand.execute();
	}
}
