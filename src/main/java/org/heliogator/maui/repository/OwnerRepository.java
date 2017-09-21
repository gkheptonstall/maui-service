package org.heliogator.maui.repository;

import org.heliogator.maui.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
