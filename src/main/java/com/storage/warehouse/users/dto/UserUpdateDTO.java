package com.storage.warehouse.users.dto;

import com.storage.warehouse.users.dto.UserDTO;
import com.storage.warehouse.users.validation.UserUpdateValid;

import java.io.Serializable;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
}
