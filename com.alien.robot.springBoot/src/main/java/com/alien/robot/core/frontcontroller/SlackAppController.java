/**
 * Copyright 2020 Alien
   Created on 31/07/20207:32:40 AM  by Ayman Elgharabawy
 */
package com.alien.robot.core.frontcontroller;

import com.slack.api.bolt.App;
import com.slack.api.bolt.servlet.SlackAppServlet;
import javax.servlet.annotation.WebServlet;

// This is the webhook servlet for Slack Engine to communicate with the spring boot
/**
 * The Class SlackAppController.
 */
@WebServlet("/slack/events")
public class SlackAppController extends SlackAppServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new slack app controller.
	 *
	 * @param app the app
	 */
	public SlackAppController(App app) {
		super(app);
	}

}
