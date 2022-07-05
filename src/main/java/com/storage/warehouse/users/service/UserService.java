package com.storage.warehouse.users.service;
import com.storage.warehouse.errors.exceptions.ResourceNotFoundException;
import com.storage.warehouse.roles.entity.Role;
import com.storage.warehouse.roles.dto.RoleDTO;
import com.storage.warehouse.roles.repository.RoleRepository;
import com.storage.warehouse.users.dto.UserDTO;
import com.storage.warehouse.users.dto.UserInsertDTO;
import com.storage.warehouse.users.dto.UserRepository;
import com.storage.warehouse.users.dto.UserUpdateDTO;
import com.storage.warehouse.users.springSecurity.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // dependency injection (@Component = generic)
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> listRepository = this.userRepository.findAll();
        List<UserDTO> listDTO = listRepository.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return listDTO;
    }

    @Transactional
    public UserDTO createNew(UserInsertDTO userDTO) {
        User userEntity = new User();
        this.copyFromDtoToEntity(userDTO, userEntity);
        User newUserEntity = userRepository.save(userEntity);
        return new UserDTO(newUserEntity);

    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = userRepository.findById(id); // returns an Optional object
        User userEntity = obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
        return new UserDTO(userEntity);
    }

    @Transactional
    public UserDTO updateUser(Long id, UserUpdateDTO userDTO){
        try {
            userDTO.setId(id);
            User userEntity = userRepository.getReferenceById(id); // dont acess BD, just creates an User with this id
            this.copyFromDtoToEntity(userDTO, userEntity);
            User updatedUserEntity = userRepository.save(userEntity);
            return new UserDTO(updatedUserEntity);
        }catch (EntityNotFoundException e){ // catch  javax.persistence exception and throw ours to exception handler
            throw new ResourceNotFoundException("Usuário id " + userDTO.getId().toString() + " não encontrado!");
        }

    }

    private void copyFromDtoToEntity(UserDTO dto, User entity){
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setId(dto.getId());
        entity.getRoles().clear();
        for(RoleDTO roleDTO : dto.getRoles()){
            Role role = roleRepository.getReferenceById(roleDTO.getId());
            entity.getRoles().add(role);
        }
    }

    private void copyFromDtoToEntity(UserInsertDTO dto, User entity){
        this.copyFromDtoToEntity(dto, entity);
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null){
            logger.error("User not found: " + username);
            throw new UsernameNotFoundException("Usuário email " + username + " não encontrado!");
        }
        return user;

    }
}