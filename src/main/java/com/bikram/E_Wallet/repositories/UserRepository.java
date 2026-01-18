package com.bikram.E_Wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikram.E_Wallet.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
