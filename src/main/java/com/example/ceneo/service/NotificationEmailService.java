package com.example.ceneo.service;

import org.springframework.stereotype.Repository;

@Repository
public interface NotificationEmailService {

    boolean sendEmailsToPeople(String userCode);
}
