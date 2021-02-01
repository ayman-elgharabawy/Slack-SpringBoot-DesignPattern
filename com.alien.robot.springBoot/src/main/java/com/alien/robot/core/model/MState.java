/**
   PACKAGE:com.alien.robot.core.model 
   USE: This package has the models that is mapped to the elements in DOT file serialization

 * Copyright 2020 Alien
   Created on 02/08/20201:56:13 PM  by Ayman Elgharabawy
 */
package com.alien.robot.core.model;

/**
 * @author Ayman Elgharabawy
 *
 */
public class MState {

	

	private String id;

	private String usermessage;

	private String systemmessage;

	private String useroptions;

	private String description;

	private String actioncomponent;

	private String shape;

	private String label;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsermessage() {
		return usermessage;
	}

	public void setUsermessage(String usermessage) {
		this.usermessage = usermessage;
	}

	public String getSystemmessage() {
		return systemmessage;
	}

	public void setSystemmessage(String systemmessage) {
		this.systemmessage = systemmessage;
	}

	public String getUseroptions() {
		return useroptions;
	}

	public void setUseroptions(String useroptions) {
		this.useroptions = useroptions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActioncomponent() {
		return actioncomponent;
	}

	public void setActioncomponent(String actioncomponent) {
		this.actioncomponent = actioncomponent;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
