package org.acme.entity;

import java.util.List;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Table;


@Entity
@Table(name = "message")
public class Messages extends PanacheEntity {
    
    private String message;
    

    public static List<Messages> findAllMessages(){
        return listAll();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
