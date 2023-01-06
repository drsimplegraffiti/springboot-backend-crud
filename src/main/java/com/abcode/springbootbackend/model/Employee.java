package com.abcode.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

//Lombok Annotations @Data, @AllArgsConstructor, @NoArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//JPA Annotations @Entity, @Id
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // this will not be returned in the response body
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;
}
