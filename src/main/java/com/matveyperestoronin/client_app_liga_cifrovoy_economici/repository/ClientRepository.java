package com.matveyperestoronin.client_app_liga_cifrovoy_economici.repository;

import com.matveyperestoronin.client_app_liga_cifrovoy_economici.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {



}
