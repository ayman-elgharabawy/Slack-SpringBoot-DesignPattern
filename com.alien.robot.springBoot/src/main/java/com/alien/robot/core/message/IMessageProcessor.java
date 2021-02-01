/**
   Copyright 2020 Alien
   Created on 31/07/20207:32:40 AM  by Ayman Elgharabawy
/**************************************************************************************************************************
 ***** Bridge Pattern*****
       ________________            ____________________       
      |AbstractMessage |          | IMessageProcessor  |
      |----------------|          |--------------------|          
      |                |--------->|                    |
      |                |          |                    | 
      |________________|          |____________________|
              ^                             ^
              |                             |      
       _______|_________           _________|___________      
      |   MessageImpl  |          |SlackMessageProcessor|
      |----------------|          |---------------------|          
      |                |--------->|                     |
      |                |          |                     | 
      |________________|          |_____________________|
   
 * Kindly don't modify this class during the development as it is part of the design pattern unless you define mmessage attribute.
 **************************************************************************************************************************/
package com.alien.robot.core.message;

import org.springframework.stereotype.Component;

import com.alien.robot.core.model.MState;

/**
 * The Interface IMessageProcessor. This interface is the part of the
 * implementation of bridge pattern that define the how the message is
 * implemented in different messaging systems i.e.Slack.
 */
@Component
public interface IMessageProcessor {

	public void SendRecieve(String request, String response);

	public void ExecuteState(MState mstate);
}
