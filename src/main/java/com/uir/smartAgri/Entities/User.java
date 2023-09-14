package com.uir.smartAgri.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    @Column(unique = true,length = 20)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String Password;
    @Column(unique = true,length = 50)
    private String Email;
    private String Phone;
    private int profile;
    @ManyToMany(mappedBy = "users")
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private List<Farm> farms;

}

