package com.storage.warehouse.users.controller;
import com.storage.warehouse.users.service.UserService;
import com.storage.warehouse.users.dto.UserDTO;
import com.storage.warehouse.users.dto.UserInsertDTO;
import com.storage.warehouse.users.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    // should only return DTO users

    @Autowired
    protected UserService userService;

    @GetMapping(path = "all")
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping // no need to specify path
    public ResponseEntity<UserDTO> createNewUser(@Valid @RequestBody UserInsertDTO userInsertDTO){
        UserDTO userDTO = userService.createNew(userInsertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri(); // create new URI from request + the new generated id
        return  ResponseEntity.ok().body(userDTO); // default 201 code when creating new resource + return id at header
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){ // @PathVariable var name must be equals to {id}
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok().body(userDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO userDTO){
        UserDTO updatedUserDTO = userService.updateUser(id, userDTO);
        return ResponseEntity.ok().body(updatedUserDTO);

    }
}
