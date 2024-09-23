package com.vehiclemgmt.Repository;

import com.vehiclemgmt.Model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Integer> {
}