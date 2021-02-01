/**
   PACKAGE:com.alien.robot.model 
   USE: This package has the models that is mapped to the elements in DOT file serialization

 
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
package com.alien.robot.core.model;

import com.alien.robot.core.message.IMessageProcessor;

/*
 * The Class AbstractMessage. This abstract class is front part of appearance
 * implementation of the bridge pattern that define the development method for
 * any messaging engine. i added the bean to it which is not part of the pattern
 * and nasty but i don't want redundant names and i added as 
 */
public abstract class AbstractMessage {

	// TODO: Nasty, i need to remove getter and setter and separate the bean from
	// the bridge abstract class: Ayman

	/** The message processor. */
	protected IMessageProcessor messageProcessor;

	/** The request. */
	String request;

	String mResponse;

	/**
	 * Gets the request.
	 *
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * Sets the request.
	 *
	 * @param request the new request
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * Gets the m response.
	 *
	 * @return the m response
	 */
	public String getmResponse() {
		return mResponse;
	}

	/**
	 * Sets the m response.
	 *
	 * @param mResponse the new m response
	 */
	public void setmResponse(String mResponse) {
		this.mResponse = mResponse;
	}

	/**
	 * Instantiates a new abstract message.
	 *
	 * @param messageProcessor the message processor
	 */
	public AbstractMessage(IMessageProcessor messageProcessor) {
		this.messageProcessor = messageProcessor;
	}

	/**
	 * Send recieve.
	 *
	 * @param request  the request
	 * @param response the response
	 */
	abstract public void SendRecieve(String request, String response);

	abstract public void ExecuteState(MState mstate);

	abstract public void ExecuteGraph(MGraph mgraph);
}
