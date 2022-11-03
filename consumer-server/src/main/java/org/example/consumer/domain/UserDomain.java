package org.example.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public")
@Data
@AllArgsConstructor
public class UserDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", length = 50, nullable = false, unique = true)
    private String username;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstname;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastname;
    @Column(name = "password", length = 50, nullable = false)
    private String password;

    public UserDomain() {

    }
}
