package org.example.cyberguardianbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.cyberguardianbackend.enums.UserRole;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private UserRole role;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;
}
