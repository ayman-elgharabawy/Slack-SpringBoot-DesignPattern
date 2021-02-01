/**
 * Copyright 2020 Alien
   Created on 02/08/202010:32:17 AM  by Ayman Elgharabawy
 */
package com.alien.robot.core.graph;


import org.springframework.stereotype.Component;

import com.alien.robot.core.model.MGraph;

/**
 * @author Ayman Elgharabawy
 *
 */
@Component("IDot")
public interface IDot {

	
	MGraph MarshalGraph();
	
}
