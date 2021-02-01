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
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alien.robot.core.graph.IDot;

//import com.alien.robot.core.graph.IDot;

/**
 * The Class MessageLoader. This class is the client to call all the commands
 * pattern messages
 */
//TODO: I don't like it , It need redesign and inject the commands then delete it
@Component("MessageLoader")
public class MessageLoader {

	/** The main menu. */
	@Autowired
	@Qualifier("DBStateMessage")
	IMessageCommand MainMenuCommand;

	/** The MessageExecutor. */
	@Autowired
	MessageExecutor mExecutor;

	/**
	 * Load.
	 */
	@Bean
	public void load() {	
		mExecutor.setCommand(MainMenuCommand);
		mExecutor.commit();
	}

}
