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
* 
* 
 */
package com.alien.robot.core.tech.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alien.robot.core.message.IMessageCommand;
import com.alien.robot.core.model.AbstractMessage;


/**
 * The Class MainMenu.
 */
@Component("JavaStateMessage")
public class JavaStateMessage implements IMessageCommand {

	/** The code message. */
	@Autowired
	@Qualifier("mimpl")
	AbstractMessage codeMessage;

	/**
	 * Instantiates a new main menu.
	 *
	 * @param codeMessage the code message
	 */
	@Autowired
	public JavaStateMessage(AbstractMessage codeMessage) {
		this.codeMessage = codeMessage;
	}

	/**
	 * Execute.
	 */
	@Override
	public void execute() {
		 codeMessage.SendRecieve("Hi","Welcome to Java cartridge Wizard.");		
	}

}

