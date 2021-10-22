package com.fascari.hroauth.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String roleName;
}