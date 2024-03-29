package com.youneskarir.assignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assignments")
public class Assignment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String GithubUrl;
    private String Branch;
    private String CodeReviewVideoUrl;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @ManyToOne(optional = false)
    private User user;
    
}
