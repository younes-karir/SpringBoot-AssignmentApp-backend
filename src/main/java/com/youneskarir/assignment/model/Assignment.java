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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "assignment_sequence")
    @SequenceGenerator(
            name = "assignment_sequence",
            sequenceName = "assignment_sequence",
            allocationSize = 1)
    private Integer id;
    private String GithubUrl;
    private String Branch;
    private String CodeReviewVideoUrl;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @ManyToOne(optional = false)
    private User user;
    
}
