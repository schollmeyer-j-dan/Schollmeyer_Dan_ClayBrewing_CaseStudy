package com.optum.quantity_type;

import org.springframework.stereotype.Service;

import java.util.List;

public interface QuantityTypeService {
    List<QuantityType> getAllQuantityTypes();
    QuantityType getQuantityTypeById(long id);
}
