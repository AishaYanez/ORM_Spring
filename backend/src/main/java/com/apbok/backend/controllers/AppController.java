package com.apbok.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apbok.backend.entity.models.App;
import com.apbok.backend.entity.services.AppServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class AppController {

	@Autowired
	private AppServiceImpl appService;
	
	@GetMapping("/apps")
	private List<App> getAllApps(){
		return (List<App>)appService.getAllApps();
	}
	
	@PostMapping("/apps")
	public ResponseEntity<String> postApp(App app) {
	    try {
	        appService.postApp(app);
	        return ResponseEntity.ok("App creada con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
	
	@DeleteMapping("/apps/{id}")
	private ResponseEntity<String> deleteApp(@PathVariable(name="id") long id){
		try {
			appService.deleteApp(id);
	        return ResponseEntity.ok("App borrada con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
	
	@PutMapping("/apps/{id}")
	private ResponseEntity<String> putApp(@PathVariable(name="id") long id, App app) {
		try {
			appService.putApp(app);
	        return ResponseEntity.ok("App actualizada con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
}