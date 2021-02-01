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
package com.alien.robot.core.message;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.composition.BlockCompositions.*;
import static com.slack.api.model.block.element.BlockElements.*;

import org.springframework.stereotype.Component;

import com.alien.robot.core.loader.SlackLoader;
import com.alien.robot.core.model.MState;
import com.alien.robot.core.util.SpringContext;
import com.slack.api.model.block.DividerBlock;
import com.slack.api.model.block.element.BlockElement;

/*
 * The Class SlackMessageProcessor.
 * This is the concrete class that handle the under hood implementation of the bridge pattern and have the lambda expression that deal with Slack
 */
@Component("slack")
public class SlackMessageProcessor implements IMessageProcessor {

	/** The pattern. */
	Pattern pattern = Pattern.compile(".*", Pattern.CASE_INSENSITIVE);

	/** The app. */

	/**
	 * Send recieve.
	 *
	 * @param requestmessage  the requestmessage
	 * @param responsemessage the responsemessage
	 */

	public void SendRecieve(String requestmessage, String responsemessage) {
		SlackLoader sl = SpringContext.getBean(SlackLoader.class); // TODO:Nasty but Jbolt Api. is not springfied.
		sl.app.message(pattern, (payload, ctx) -> {
			String text = payload.getEvent().getText();
			if (text.equalsIgnoreCase(requestmessage)) {
				ctx.say(responsemessage);
				return ctx.ack();
			}
			return ctx.ack();
		});
		;
	}

	// This method register the graph state in the slack engine
	@Override
	public void ExecuteState(MState mstate) {
		SlackLoader sl = SpringContext.getBean(SlackLoader.class);
		sl.app.blockAction("Attribute", (req, ctx) -> { // if Entity button is clicked
			String value = req.getPayload().getActions().get(0).getValue(); // "button's value"
			System.out.println("Button Pressed = " + value);
			if (req.getPayload().getResponseUrl() != null) {
				
				List<BlockElement>	beList=getBlockElement(mstate);
				ctx.client()
						.chatPostMessage(
								r -> r.channel(
										req.getPayload().getChannel().getId()).blocks(
												asBlocks(DividerBlock.builder().build(),
														section(section -> section
																.text(markdownText(mstate.getUsermessage()))),
														actions(actions -> actions
																.elements(beList)))));
			}
			return ctx.ack();
		});

	}

	//This method extract the mapped Slack Block element from M state
	
	private List<BlockElement> getBlockElement(MState mstate) {
		List<BlockElement> beList = new ArrayList<BlockElement>();
		StringTokenizer stok = new StringTokenizer(mstate.getUseroptions(), ",");
		while (stok.hasMoreTokens()) {
			if (mstate.getActioncomponent().equalsIgnoreCase("button")) {
				beList.add(button(b -> b.actionId("Integer").text(plainText(pt -> pt.text(stok.nextToken())))
						.value(stok.nextToken())));
			}
		}

		return beList;

	}

	
	
//	@Override
//	public void ExecuteState(MState mstate) {
//		SlackLoader sl = SpringContext.getBean(SlackLoader.class);
//		sl.app.blockAction("Attribute", (req, ctx) -> { // if Entity button is clicked
//			String value = req.getPayload().getActions().get(0).getValue(); // "button's value"
//			System.out.println("Button Pressed = " + value);
//			if (req.getPayload().getResponseUrl() != null) {
//				
//				List<BlockElement>	beList=getBlockElement(mstate);
//				ctx.client()
//						.chatPostMessage(
//								r -> r.channel(
//										req.getPayload().getChannel().getId()).blocks(
//												asBlocks(DividerBlock.builder().build(),
//														section(section -> section
//																.text(markdownText(mstate.getUsermessage()))),
//														actions(actions -> actions
//																.elements(
//																		asElements(
//																				button(b -> b.actionId("Integer")
//																						.text(plainText(
//																								pt -> pt.text(
//																										"Integer")))
//																						.value("Integer")),
//																				button(b -> b.actionId("String")
//																						.text(plainText(pt -> pt
//																								.text("String")))
//																						.value("String")),
//																				button(b -> b.actionId("Boolean")
//																						.text(plainText(pt -> pt
//																								.text("Boolean")))
//																						.value("Boolean"))))))));
//			}
//			return ctx.ack();
//		});
//
//	}
	
	
}