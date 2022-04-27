package com.optum.quantity_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityTypeServiceImpl implements QuantityTypeService {

    private QuantityTypeRepo repo;

    @Autowired
    public QuantityTypeServiceImpl(QuantityTypeRepo repo){ this.repo = repo; }

    @Override
    public List<QuantityType> getAllQuantityTypes() {
        return repo.findAll();
    }

    @Override
    public QuantityType getQuantityTypeById(long id) {
        return repo.getById(id);
    }
}
