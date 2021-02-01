/**
  * PACKAGE:com.alien.robot.core.graph 
  * USE: This package is created for object serialization from Graph file to the models package

 * Copyright 2020 Alien
   Created on 02/08/202010:53:50 AM  by Ayman Elgharabawy
 */
package com.alien.robot.core.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alien.robot.core.model.MGraph;
import com.alien.robot.core.model.MState;


/**
 * @author Ayman Elgharabawy
 *
 */
@Component("DotImpl")
public class DotImpl implements IDot {

	public MGraph mgraph;

	@Autowired
	Graph graph;

	//This method read the node and marshal each state to mstate object
	public MGraph MarshalGraph() {

		MGraph mgraph = new MGraph();
		List<MState> statelist=new ArrayList<MState>();
		mgraph.setStateList(statelist);

		
		for (Node node : graph.getEachNode()) {
			Collection<Edge> enteringedges=node.getEnteringEdgeSet();
			  for (Edge edge : enteringedges) {
				  System.out.println("sources="+edge.getSourceNode().toString());
			  }
			Collection<Edge> leavingedges=node.getLeavingEdgeSet();
			  for (Edge edge : leavingedges) {
				  System.out.println("targets="+edge.getTargetNode().toString());
			  }
			MState mstate = new MState();
			mstate.setId(Optional.ofNullable(node).map(e -> e.getAttribute("id")).map(e -> e.toString()).orElse(""));
			mstate.setDescription(Optional.ofNullable(node).map(e -> e.getAttribute("description")).map(e -> e.toString()).orElse(""));
			mstate.setActioncomponent(Optional.ofNullable(node).map(e -> e.getAttribute("actioncomponent")).map(e -> e.toString()).orElse(""));
			mstate.setUsermessage(Optional.ofNullable(node).map(e -> e.getAttribute("usermessage")).map(e -> e.toString()).orElse(""));
			mstate.setSystemmessage(Optional.ofNullable(node).map(e -> e.getAttribute("systemmessage")).map(e -> e.toString()).orElse(""));
			mstate.setUseroptions(Optional.ofNullable(node).map(e -> e.getAttribute("useroptions")).map(e -> e.toString()).orElse(""));
			mgraph.getStateList().add(mstate);
		}
		return mgraph;
	}

}
