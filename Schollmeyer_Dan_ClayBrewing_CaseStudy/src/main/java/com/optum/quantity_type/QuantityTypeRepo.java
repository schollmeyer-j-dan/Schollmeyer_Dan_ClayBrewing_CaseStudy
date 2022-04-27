package com.optum.quantity_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityTypeRepo extends JpaRepository<QuantityType, Long> {
    public QuantityType findFirstByType(String type);
}