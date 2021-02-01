/**
   PACKAGE:com.alien.robot.core.loader 
   USE: This package having all the classes to load all the configurations to connect to different engines.

 * Copyright 2020 Alien
   Created on 31/07/20207:32:40 AM  by Ayman Elgharabawy
 */
/**************************************************************************************************************************
 * Kindly don't modify this class unless you change the configuration.
 **************************************************************************************************************************/
package com.alien.robot.core.loader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import lombok.extern.slf4j.Slf4j;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceDOT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import static java.util.stream.Collectors.joining;

@Configuration
@Slf4j
public class SlackLoader {

	public App app;
	public Graph  graph;
	
	@Resource(name="fileSource")
	private FileSource fileSource;
	
	
	@Bean
	public AppConfig loadAppConfig() {
		AppConfig config = new AppConfig();
		ClassLoader classLoader = SlackLoader.class.getClassLoader();
		try (InputStream is = classLoader.getResourceAsStream("appConfig.json");
				InputStreamReader isr = new InputStreamReader(is)) {
			String json = new BufferedReader(isr).lines().collect(joining());
			JsonObject j = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
			config.setSigningSecret(j.get("signingSecret").getAsString());
			config.setSingleTeamBotToken(j.get("singleTeamBotToken").getAsString());
		} catch (IOException e) {
			// log.error(e.getMessage(), e);
		}
		return config;
	}

	@Bean
	public Graph loadGraphConfig() {
		Graph graph = new SingleGraph("Tutorial 1");
		ClassLoader classLoader = SlackLoader.class.getClassLoader();
		InputStream resourceAsStream = classLoader.getResourceAsStream("tech.db.dot");
		fileSource.addSink(graph);
		try {
			fileSource.readAll(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return graph;
	}

	@Bean
	@Autowired
	public App initSlackApp(AppConfig config) {
		App app = new App(config);
		this.app = app;
		return app;
	}
	
    @Bean(name="fileSource")
    public FileSource getFileSource() {
    	FileSource fileSource = new FileSourceDOT();
        return fileSource;
    }
    

}
