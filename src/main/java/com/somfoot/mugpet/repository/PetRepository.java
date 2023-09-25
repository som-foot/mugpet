package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {

}

