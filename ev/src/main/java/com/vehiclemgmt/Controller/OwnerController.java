package com.vehiclemgmt.Controller;

import com.vehiclemgmt.Model.Owner;
import com.vehiclemgmt.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;
    @PostMapping("/insertOwner")
    public String insertOwner(@RequestBody List<Owner> owner) {
        ownerService.insertOwners(owner);
        return "Owner inserted successfully";
    }
}