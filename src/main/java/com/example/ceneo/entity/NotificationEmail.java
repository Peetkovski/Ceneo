package com.example.ceneo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEmail {
    @Id
    @GeneratedValue
    private Long personId;
    private String personEmail;
    //private Company selectedCompany;
}
