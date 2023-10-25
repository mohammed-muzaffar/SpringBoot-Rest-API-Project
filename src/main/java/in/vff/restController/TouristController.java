package in.vff.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vff.model.Tourist;
import in.vff.service.TouristManagementService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private TouristManagementService service;
	
	
	
	@PostMapping("/register")
	//post http request is used for create a new resource
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
	
	}

	@GetMapping("/findAll")
	//get request are intended to retrieve data from a server 
	public ResponseEntity<?> displayTouristDetails() {
		
			List<Tourist> list = service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
		
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		
	}

	@PutMapping("/modify")
	//put http request is used for update an existing resource
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
		
			String msg = service.updateTouristByDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
	
	}

	@PatchMapping("/budgetModify/{id}/{hike}")
	//PATCH HTTP method is used to modify the values of the resource properties
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable("id") Integer id,
			@PathVariable("hike") Float hikeAmt) {

		
			String msg = service.updateTouristById(id, hikeAmt);
			return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/deleteTourist/{id}")
	//The DELETE method is used to delete a specific resource in a REST API
	public ResponseEntity<String> deleteTouristById(@PathVariable("id") Integer id) {

	
			String msg = service.deleteTourist(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}

}
