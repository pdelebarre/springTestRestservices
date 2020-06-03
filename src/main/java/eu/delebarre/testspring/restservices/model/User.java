package eu.delebarre.testspring.restservices.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import java.util.UUID;

public @Data class User {

    private UUID id;
    private String name;

/*    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
/*
    @Override
    public String toString() {
        return id + " : " + name;
    }*/
}
