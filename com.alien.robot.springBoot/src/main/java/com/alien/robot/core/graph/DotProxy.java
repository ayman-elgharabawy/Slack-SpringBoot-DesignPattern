/**
 * Copyright 2020 Alien
   Created on 02/08/202010:34:51 AM  by Ayman Elgharabawy
 */
package com.alien.robot.core.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alien.robot.core.model.MGraph;

/**
 * @author Ayman Elgharabawy
 *
 */
@Component("DotProxy")
public class DotProxy  implements IDot{

	@Autowired
	@Qualifier("DotImpl")
	IDot  idotIm;


	public MGraph MarshalGraph() {
		return idotIm.MarshalGraph();
	}



}
