package com.storage.warehouse.users;
import com.storage.warehouse.roles.Role;
import com.storage.warehouse.roles.RoleDTO;
import com.storage.warehouse.roles.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service // dependency injection (@Component = generic)
public class UserService {

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
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setId(userDTO.getId());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userEntity.getRoles().clear();
        for(RoleDTO roleDTO : userDTO.getRoles()){
            Role role = roleRepository.getReferenceById(roleDTO.getId());
            userEntity.getRoles().add(role);
        }
        User newUserEntity = userRepository.save(userEntity);
        return new UserDTO(newUserEntity);

    }

}