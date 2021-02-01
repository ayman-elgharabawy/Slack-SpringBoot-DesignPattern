/**
  * PACKAGE:com.alien.robot.core.frontcontroller 
  * USE: This package is created for front controller as a Integration and communication between Core and other systems

 * Copyright 2020 Alien
   Created on 31/07/20207:32:40 AM  by Ayman Elgharabawy
 */
package com.alien.robot.core.frontcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class SlackContlroller is for Rest API that the user can send message to the Chatbot core.
 */
@RestController
public class SlackRobotClient {
	
  /**
   * PThis com.alien.robot.core.frontcontroller
   *
   * @return the string
   */
  //TODO: 
	@RequestMapping("/controller/hello")
	public String hello() {
		
//		ChatPostMessageResponse response = slack.methods(token).chatPostMessage(ChatPostMessageRequest.builder()
//				  .channel("#random")
//				  .text(":wave: Hi from a bot written in Java!")
//				  .build());
		
		return "{\"Hello\":\"World\"}";
	}

	/**
	 * Send message.
	 *
	 * @param message the message
	 * @return the string
	 */
	@RequestMapping("/controller/send")
	public String sendMessage(String message) {
		return "welcome";
	}

}
