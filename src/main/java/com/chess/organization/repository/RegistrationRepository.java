/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.repository;

import com.chess.organization.model.Registration;
import java.util.Optional;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    public Optional<Registration> findById(Long id);
}