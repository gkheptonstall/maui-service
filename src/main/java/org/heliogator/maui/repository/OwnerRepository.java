package org.heliogator.maui.repository;

import javax.transaction.Transactional;

import org.heliogator.maui.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
