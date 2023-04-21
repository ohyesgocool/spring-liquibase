package com.example.springliquibase.repository;

import com.example.springliquibase.model.Laptop;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>
{
    Laptop findAllById(Long id);
}
