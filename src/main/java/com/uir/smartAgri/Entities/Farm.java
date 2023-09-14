package com.uir.smartAgri.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Farm {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFarm;
    @NotBlank
    private String address;
    private float area;
    @Column(unique = true,length = 30)
    @NotBlank
    private String name;
    private double longitude;
    private double latitude;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_FARMS",
            joinColumns = @JoinColumn(name = "farm_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private List<User> users;
}
