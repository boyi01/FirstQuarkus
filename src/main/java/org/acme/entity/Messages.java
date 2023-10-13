package org.acme.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.arjuna.ats.arjuna.common.recoveryPropertyManager;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "message")
public class Messages extends PanacheEntity {
    
    public String message;

    public static List<Messages> findAllMessages(){
        return listAll();
    }

}
