/**
   PACKAGE:com.alien.robot.core.model 
   USE: This package has the models that is mapped to the elements in DOT file serialization

 * Copyright 2020 Alien
   Created on 02/08/20202:07:26 PM  by Ayman Elgharabawy
 */
package com.alien.robot.core.model;

import java.util.List;

/**
 * @author Ayman Elgharabawy
 *
 */
public class MGraph {

	
	private List<MState> StateList;

	/**
	 * @return the stateList
	 */
	public List<MState> getStateList() {
		return StateList;
	}

	/**
	 * @param stateList the stateList to set
	 */
	public void setStateList(List<MState> stateList) {
		StateList = stateList;
	}
}
