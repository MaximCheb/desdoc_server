package com.doc.des.server.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doc.des.server.doc.service.PoiService;
import com.doc.des.server.exception.AlreadyExistException;

@RestController
@RequestMapping("/poi")
public class PoiController {
	@Autowired
	private PoiService poiService;
	
//	@GetMapping("/all")
//	public ArrayList<ProjectMongo> getAll() throws Exception {
//		ArrayList<ProjectMongo> projects = new ArrayList<>();
//		mongoProjectService.getAll
//		return itemNotebooks;
//	}
	@GetMapping("/test")
	public ResponseEntity getOne(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(0);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Not poi");
		}
	}
//	@PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity newProject(@RequestBody ProjectDocument newProject) {
//    	try {
//    		if(poiService.createDocument()) {
//    			return ResponseEntity.ok("Mongo project saved");
//    		}else {
//    			return ResponseEntity.badRequest().body("Project not create");
//    		}    		
//		}catch(Exception e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//    }
	
//	@MessageMapping("/chat")
//	@SendTo("/topic/messages")
//	public OutputMessage send(Message message) throws Exception {
//	    String time = new SimpleDateFormat("HH:mm").format(new Date());
//	    return new OutputMessage(message.getFrom(), message.getText(), time);
//	}
}


