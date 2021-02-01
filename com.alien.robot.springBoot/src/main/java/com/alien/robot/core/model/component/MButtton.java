/**
   PACKAGE:com.alien.robot.core.model.component 
   USE: This package has the models that isused for object seriialization related to GUI response to that appear in chat
 * Copyright 2020 Alien
   Created on 31/07/20209:14:17 PM  by Ayman Elgharabawy
 */
package com.alien.robot.core.model.component;

/**
 * @author Ayman Elgharabawy
 *
 */
public class MButtton {

	String Id;
	String label;
	String value;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
