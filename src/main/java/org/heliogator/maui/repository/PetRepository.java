package org.heliogator.maui.repository;

import org.heliogator.maui.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByName(String name);

    @Query("select p from Pet p inner join p.owner o where o.name = ?1")
    List<Pet> findByOwnerName(String name);
}
