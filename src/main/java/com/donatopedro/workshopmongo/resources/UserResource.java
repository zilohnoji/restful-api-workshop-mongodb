package com.donatopedro.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.donatopedro.workshopmongo.dto.UserDTO;
import com.donatopedro.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	UserService service;

	@GetMapping(path = "/find-all")
	public @ResponseBody ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok()
				.body(service.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList()));
	}

	@GetMapping(path = "/find-id")
	public @ResponseBody ResponseEntity<UserDTO> findById(@RequestParam(name = "id") String id) {
		return ResponseEntity.ok().body(new UserDTO(service.findById(id)));
	}

}
