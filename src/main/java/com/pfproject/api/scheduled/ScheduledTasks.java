package com.pfproject.api.scheduled;

import java.util.List;

import java.util.ArrayList;
import java.text.ParseException;

/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.pfproject.api.controller.ChequeController;
import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.model.Cheque;
import com.pfproject.api.repository.ChequeRepository;
import com.pfproject.api.service.BasicChequeService;
import com.pfproject.api.service.ChequeService;

import com.pfproject.api.service.ChequeService;

@Component

public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	/*
	 * @Scheduled(fixedRate = 5000) public void reportCurrentTime() {
	 * log.info("The time is now {}", dateFormat.format(new Date()));
	 * System.out.println("try1"); }
	 */
	@Scheduled(fixedRate = 50000000)
	public void Verify_cheques() throws ParseException {

		log.info("The time is now {}", dateFormat.format(new Date()));
		System.out.println("====try====");
		MongoClient mongoClient = new MongoClient(
				new MongoClientURI("mongodb://ArmiraDATA:ArmiraDATA1@ds145895.mlab.com:45895/armira"));
		System.out.println("Collection created successfully");
		MongoDatabase database = mongoClient.getDatabase("armira");
		MongoCollection<Document> collection = database.getCollection("Cheque");

		FindIterable<Document> iterDoc = collection.find();
		int i = 1;

		// Getting the iterator
		Iterator<Document> it = iterDoc.iterator();

		LocalDateTime now = LocalDateTime.now();
		Date current = new SimpleDateFormat("yyyy-MM-dd").parse(now.toString());
		while (it.hasNext()) {
			// System.out.println(it.next().get("Date").toString());
			Document D = it.next();

			String Date = D.get("Date").toString();
			Object id = D.get("_id");
			Object Sent = D.get("Sent");
			Object Alerte = D.get("Alerte");
			Object from=D.get("Emetteur");
			Object to=D.get("Recepteur");

			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(Date);

			System.out.println((date1.getTime() - current.getTime()));
			System.out.println("id"+id+"Alerte------------->"+Long.parseLong(Alerte.toString())*86400000);
			System.out.println("Margine:  "+(date1.getTime() - current.getTime()));
			System.out.println("Alerte:  "+(Long.parseLong(Alerte.toString())*86400000));
			System.out.println("Sent:  "+Sent);
			if (((date1.getTime() - current.getTime()) <= (Long.parseLong(Alerte.toString())*86400000)) && (Sent.toString().equalsIgnoreCase("no") )) {
				 System.out.println("sending mail");
				 Mailer.send("clientinfo.arimar@gmail.com", "GECO2018Y", "clientinfo.arimar@gmail.com", "Alerte Cheque!", "Vous avez un cheque dû aujourd'hui de: "+from.toString()+" à: "+to.toString());
				 System.out.println("try");
				 System.out.println(D.get("_id")+"=========="+D.get("Sent"));
				  
				 collection.updateOne(Filters.eq("_id",id), Updates.set("Sent", "yes"));
				 System.out.println("done");
				 
			}

			i++;
		}
	}
}