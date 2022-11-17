package com.example.ceneo.service.implementation;

import com.example.ceneo.entity.NotificationEmail;
import com.example.ceneo.repository.NotificationEmailRepository;
import com.example.ceneo.service.NotificationEmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationEmailServiceImpl implements NotificationEmailService {

    private final NotificationEmailRepository emailRepository;

    @Override
    public boolean sendEmailsToPeople(String userCode) {
        NotificationEmail email = new NotificationEmail();
        email.setPersonEmail(email.getPersonEmail());
        email.setPersonId(email.getPersonId());
        return true;
    }
}
