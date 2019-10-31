package com.example.demo.user.domain;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
public class User {

    @Id
    private ObjectId _id;

    private String name;
    private int age;
    private String address;

    public User(ObjectId _id, String name, int age, String address) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
