package com.cp.service;

import com.cp.entity.Instagram;
import com.cp.repo.IInstarepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Serviceimpl implements IService{

    @Autowired
    private IInstarepo repo;

    @Override
    public String registerAccount(Instagram insta) {

        Instagram instao = new Instagram();

        return "account created with id od " + instao.getId();


    }

}
