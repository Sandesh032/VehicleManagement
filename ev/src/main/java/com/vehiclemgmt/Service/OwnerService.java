package com.vehiclemgmt.Service;

import com.vehiclemgmt.Model.Owner;
import com.vehiclemgmt.Repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    OwnerRepo ownerRepo;

    public void insertOwners(List<Owner> owner) {
        ownerRepo.saveAll(owner);
    }

    public List<Owner> getOwners() {
        return ownerRepo.findAll();
    }
}