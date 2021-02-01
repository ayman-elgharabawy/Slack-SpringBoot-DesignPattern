/**
 * PACKAGE:com.alien.robot.core.message 
   USE: This package for message handling. 

 * Copyright 2020 Alien
   Created on 31/07/20207:32:40 AM  by Ayman Elgharabawy
 */
/**************************************************************************************************************************
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
 * Kindly don't modify this class during the development as it is part of the design pattern unless you change the pattern.
 **************************************************************************************************************************/
package com.alien.robot.core.message;

import org.springframework.stereotype.Component;

@Component
public interface IMessageCommand {

	/**
	 * Execute. This is the interface that define the command pattern
	 */
	public void execute();
}
