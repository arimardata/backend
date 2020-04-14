package com.pfproject.api.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.UserDTO;
import com.pfproject.api.service.UserService;
import com.pfproject.api.dto.MessageDTO;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.pfproject.api.model.User;
import com.pfproject.api.model.Response;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/user")
public class SignUpController {

    private final UserService service;

    private final ConverterFacade converterFacade;

    @Autowired
    public SignUpController(final UserService service, final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody final UserDTO dto) {
        return new ResponseEntity<>(service.create(converterFacade.convert(dto)), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final UserDTO dto) {
        User user = service.create(converterFacade.convert(dto));
        Response response = new Response();
        response.setAuthority(user.getAuthority());
        response.setUsername(user.getUsername());
        response.setId(user.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> find() {
        List<User> liste = service.findAll();
        ArrayList<Response> response = new ArrayList<Response>();
        for (User user : liste) {
            Response r = new Response();
            r.setAuthority(user.getAuthority());
            r.setUsername(user.getUsername());
            r.setId(user.getId());
            r.setEnabled(user.isEnabled());
            response.add(r);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // search route fonctional
    // @RequestMapping(value = "/find/{username}", method = RequestMethod.GET)
    // public ResponseEntity<?> findByUsername(@PathVariable final String username)
    // {
    // return new ResponseEntity<>(service.findByUsername(username), HttpStatus.OK);
    // }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> update(@PathVariable final String id, @RequestBody final UserDTO dto) {
        User user = service.find(id);
        user.setUsername(dto.getUsername());
        user.setFirstLogin(true);
        user.setPassword(dto.getPassword());
        user.setAuthority(dto.getAuthority());
        user.setEmail(dto.getEmail());
        service.update(id, user);
        

        final MessageDTO response = new MessageDTO();
        response.setMessage("Mot de passe est changé avec succes");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/passwordReset/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> passwordReset(@PathVariable final String id, @RequestBody final UserDTO dto) {
        User user = service.find(id);

        user.setFirstLogin(false);
        user.setPassword(dto.getPassword());
        service.update(id, user);

        final MessageDTO response = new MessageDTO();
        response.setMessage("Mot de passe est changé avec succes");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/disable/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable final String id) {
        // service.delete(id);
        final MessageDTO response = new MessageDTO();

        User user = service.find(id);
        boolean isEnabled = user.isEnabled();
        if (isEnabled) {
            response.setMessage("l'utilisateur a été bloqué");
            user.setEnabled(false);
        } else {
            response.setMessage("l'utilisateur a été débloqué");
            user.setEnabled(true);
        }
        service.update(id, user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updateemail", method = RequestMethod.POST)
    public ResponseEntity<?> updateemail(/*@PathVariable final String id*/ @RequestBody final UserDTO dto) {
    	
    	//User user = service.find(id);
    	//user.setAuthority(dto.getAuthority());
    	
    	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://ArmiraDATA:ArmiraDATA1@ds145895.mlab.com:45895/armira"));
    	
    	MongoDatabase database = mongoClient.getDatabase("armira");


		BasicDBObject query = new BasicDBObject();
		query.put("statut", "actual"); // (1)

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("email", dto.getEmail()); // (2)

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument); // (3)

		database.getCollection("email").updateOne(query, updateObject);
        
        //user.setEmail(dto.getEmail());
        //System.out.println(user.getEmail());
        //service.update(id, user);
        
        
        final MessageDTO response = new MessageDTO();
        response.setMessage("L'email est changé avec succes");

        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }
    
   

}
