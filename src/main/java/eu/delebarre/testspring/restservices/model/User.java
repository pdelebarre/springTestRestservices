package eu.delebarre.testspring.restservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.UUID;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @javax.persistence.Id
    @Id
    @Type(type = "pg-uuid")
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
