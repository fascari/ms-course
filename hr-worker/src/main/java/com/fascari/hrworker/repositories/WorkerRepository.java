package com.fascari.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fascari.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}