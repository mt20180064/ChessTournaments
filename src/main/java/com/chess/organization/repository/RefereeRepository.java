/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.repository;

import com.chess.organization.model.Referee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface RefereeRepository extends JpaRepository<Referee, Long>{
    public Optional<Referee> findById(Long id);
    public Optional<Referee> findByUsername (String username);
}
