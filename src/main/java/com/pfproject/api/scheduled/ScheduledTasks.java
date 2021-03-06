package com.pfproject.api.scheduled;

import java.text.ParseException;

// /*
// * Copyright 2012-2015 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */

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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.pfproject.api.model.User;
import com.pfproject.api.repository.ChequeRepository;
import com.pfproject.api.service.BasicChequeService;
import com.pfproject.api.service.ChequeService;
import com.pfproject.api.service.UserService;
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
		
		

		// log.info("The time is now {}", dateFormat.format(new Date()));
		// System.out.println("====try====");
		MongoClient mongoClient = new MongoClient(
				new MongoClientURI("mongodb://ArmiraDATA:ArmiraDATA1@ds145895.mlab.com:45895/armira"));
		System.out.println("Collection created successfully");
		MongoDatabase database = mongoClient.getDatabase("armira");
		MongoCollection<Document> collection = database.getCollection("Cheque");
		MongoCollection<Document> collectionemail = database.getCollection("email");
		//
		
		FindIterable<Document> iterDoc2 = collectionemail.find();


		// Getting the iterator
		Iterator<Document> it2 = iterDoc2.iterator();
		Document D2 = it2.next();
		String email = "clientinfo.arimar@gmail.com";
		while (it2.hasNext()) {

			
			Object iduse = D2.get("statut");
			
			if(iduse=="actual") {
				
				
				
				email = D2.get("email").toString();
				break;
			}

			
		}
		
		
		
		
		
		
		//
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
			Object from = D.get("Emetteur");
			Object to = D.get("Recepteur");

			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(Date);

			// System.out.println((date1.getTime() - current.getTime()));
			// System.out.println("id" + id + "Alerte------------->" +
			// Long.parseLong(Alerte.toString()) * 86400000);
			// System.out.println("Margine: " + (date1.getTime() - current.getTime()));
			// System.out.println("Alerte: " + (Long.parseLong(Alerte.toString()) *
			// 86400000));
			// System.out.println("Sent: " + Sent);
			if (((date1.getTime() - current.getTime()) <= (Long.parseLong(Alerte.toString()) * 86400000))
					&& (Sent.toString().equalsIgnoreCase("no"))) {
				// System.out.println("sending mail");


				Mailer.send("clientinfo.arimar@gmail.com", "GECO2018Y",email , "Alerte Cheque!",
						"Vous avez un cheque dû aujourd'hui de: " + from.toString() + " à: " + to.toString());
				// System.out.println("try");
				// System.out.println(D.get("_id") + "==========" + D.get("Sent"));

				collection.updateOne(Filters.eq("_id", id), Updates.set("Sent", "yes"));
				// System.out.println("done");

			}

			i++;
		}
		mongoClient.close();
	}

	@Scheduled(fixedRate = 50000)
	public void Verify_cheques_notification() {
		// System.out.println("trying");
		// log.info("The time is now {}", dateFormat.format(new Date()));
		System.out.println("====try====");
		MongoClient mongoClient = new MongoClient(
				new MongoClientURI("mongodb://ArmiraDATA:ArmiraDATA1@ds145895.mlab.com:45895/armira"));
		System.out.println("Collection created successfully");
		MongoDatabase database = mongoClient.getDatabase("armira");
		/* Notifications */
		MongoCollection<Document> collectionNotification = database.getCollection("Notification");

		/* Cheques */
		MongoCollection<Document> collectionCheque = database.getCollection("Cheque");
		long count = collectionCheque.count();
		System.out.println("Count: " + count);

		/* Stats */
		MongoCollection<Document> collection = database.getCollection("Stats");

		FindIterable<Document> iterDoc = collection.find();
		int i = 1;

		// Getting the iterator
		Iterator<Document> it = iterDoc.iterator();
		while (it.hasNext()) {
			// System.out.println(it.next().get("Date").toString());
			Document D = it.next();
			Object id = D.get("_id");
			String StatsType = D.get("StatsType").toString();
			String Total = D.get("Total").toString();
			long num = Long.parseLong(Total);
			// System.out.println("Num===" + num);
			if (StatsType.equalsIgnoreCase("ChequeStats")) {
				System.out.println("Insert======");
				if (num < count) {

					for (int u = 0; u < (count - num); u++) {

						Document obj1 = new Document();

						obj1.put("notificationType", "ChequeNotification");
						obj1.put("notificationDetail", "You have a new Cheque");
						obj1.put("notificationSeen", "no");
						//obj1.put("idtarget", id.toString());
						collectionNotification.insertOne(obj1);
					}

				}
			}
			Bson filter = Filters.eq("StatsType", "ChequeStats");
			Bson query = Updates.set("Total", count);
			collection.updateOne(filter, query);
		}

		mongoClient.close();
	}

	@Scheduled(fixedRate = 50000)
	public void Verify_AO_notification() {
		// System.out.println("trying");
		// log.info("The time is now {}", dateFormat.format(new Date()));
		// System.out.println("====try====");
		MongoClient mongoClient = new MongoClient(
				new MongoClientURI("mongodb://ArmiraDATA:ArmiraDATA1@ds145895.mlab.com:45895/armira"));
		// System.out.println("Collection created successfully");
		MongoDatabase database = mongoClient.getDatabase("armira");
		// Notifications
		MongoCollection<Document> collectionNotification = database.getCollection("Notification");

		// Cheques
		MongoCollection<Document> collectionCheque = database.getCollection("AppelOffre");
		long count = collectionCheque.count();
		// System.out.println("Count: " + count);

		// Stats
		MongoCollection<Document> collection = database.getCollection("Stats");

		FindIterable<Document> iterDoc = collection.find();
		int i = 1;

		// Getting the iterator
		Iterator<Document> it = iterDoc.iterator();
		while (it.hasNext()) {
			// System.out.println(it.next().get("Date").toString());
			Document D = it.next();
			Object id = D.get("_id");
			String StatsType = D.get("StatsType").toString();
			String Total = D.get("Total").toString();
			long num = Long.parseLong(Total);
			// System.out.println("Num===" + num);
			if (StatsType.equalsIgnoreCase("AppelOffreStats")) {
				// System.out.println("Insert======");
				if (num < count) {

					for (int u = 0; u < (count - num); u++) {

						Document obj1 = new Document();

						obj1.put("notificationType", "AppelOffreNotification");
						obj1.put("notificationDetail", "You have a new AppelOffre");
						obj1.put("notificationSeen", "no");
						//obj1.put("idtarget", id.toString());
						collectionNotification.insertOne(obj1);
					}

				}
			}
			Bson filter = Filters.eq("StatsType", "AppelOffreStats");
			Bson query = Updates.set("Total", count);
			collection.updateOne(filter, query);
		}
		mongoClient.close();
	}
}
