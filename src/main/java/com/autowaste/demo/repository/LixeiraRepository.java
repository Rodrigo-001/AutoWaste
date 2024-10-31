package com.autowaste.demo.repository;

import com.autowaste.demo.model.Lixeira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LixeiraRepository extends JpaRepository<Lixeira, Long> {
}
