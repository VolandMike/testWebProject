package org.example.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="users", schema="public")
@Data
@Builder
@AllArgsConstructor
public class UserDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="USERNAME", length=50, nullable=false)
    private String username;
    @Column(name="FIRSTNAME", length=50, nullable=false)
    private String firstname;
    @Column(name="LASTNAME", length=50, nullable=false)
    private String lastname;
    @Column(name="PASSWORD", length=50, nullable=false)
    private String password;

    public UserDomain() {

    }
}
