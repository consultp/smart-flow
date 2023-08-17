package com.cp.service;

import com.cp.entity.Instagram;
import org.springframework.stereotype.Service;

@Service
public interface IService {

    public String registerAccount(Instagram insta);
}
