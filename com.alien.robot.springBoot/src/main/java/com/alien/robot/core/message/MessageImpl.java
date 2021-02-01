/**
 * Copyright 2020 Alien
   Created on 31/07/20207:32:40 AM  by Ayman Elgharabawy
   
   /**** Bridge Pattern*****
 ________________            ____________________       
|AbstractMessage |          | IMessageProcessor  |
|----------------|          |--------------------|          
|                |--------->|                    |
|                |          |                    | 
|________________|          |____________________|
      ^                              ^
      |                              |      
______|_________            _________|___________      
|   MessageImpl  |          |SlackMessageProcessor|
|----------------|          |---------------------|          
|                |--------->|                     |
|                |          |                     | 
|________________|          |_____________________|

 */
/**************************************************************************************************************************
 * Kindly don't modify this class during the development as it is part of the design pattern unless you add another messaging processor.
 **************************************************************************************************************************/
package com.alien.robot.core.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alien.robot.core.model.AbstractMessage;
import com.alien.robot.core.model.MGraph;
import com.alien.robot.core.model.MState;

/**
 * The Class MessageImpl.
 */
@Component("mimpl")
public class MessageImpl extends AbstractMessage {

	/** The mprocessor. */
	@Autowired
	@Qualifier("slack")
	IMessageProcessor mprocessor;

	/**
	 * Instantiates a new message impl.
	 *
	 * @param mprocessor the mprocessor
	 */
	public MessageImpl(IMessageProcessor mprocessor) {
		super(mprocessor);
	}

	/**
	 * Send recieve.
	 *
	 * @param request  the request
	 * @param response the response
	 */
	public void SendRecieve(String request, String response) {
		messageProcessor.SendRecieve(request, response);
	}


	@Override
	public void ExecuteState(MState mstate) {
		messageProcessor.ExecuteState(mstate);

	}

	@Override
	public void ExecuteGraph(MGraph mgraph) {
		for (MState mstate : mgraph.getStateList()) {
			messageProcessor.ExecuteState(mstate);
		}
	}

}
