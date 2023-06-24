package com.example.demo2.data.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String fullName;
    private String username;

    @Enumerated(EnumType.STRING)
    private PoliticalParty politicalParty;
}
