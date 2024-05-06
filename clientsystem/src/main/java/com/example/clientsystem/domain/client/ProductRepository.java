package com.example.clientsystem.domain.client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Client, String> {
    List<Client> findAllByActiveTrue();
}
