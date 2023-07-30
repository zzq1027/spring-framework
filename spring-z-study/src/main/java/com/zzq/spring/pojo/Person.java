package com.zzq.spring.pojo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zzq
 * @date 2023/7/30
 */
public class Person {
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}