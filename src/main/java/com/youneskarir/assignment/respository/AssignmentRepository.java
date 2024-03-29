package com.youneskarir.assignment.respository;

import com.youneskarir.assignment.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {
}
