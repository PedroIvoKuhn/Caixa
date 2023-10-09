package com.pedro.caixa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
    private String category;

    private List<MonthlyAccounts> monthlyAccounts = new ArrayList<>();

    public User(){
    }

    public User(String id, String name, String email, String category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public List<MonthlyAccounts> getMonthlyAccounts() {
        return monthlyAccounts;
    }

    public void setMonthlyAccounts(List<MonthlyAccounts> monthlyAccounts) {
        this.monthlyAccounts = monthlyAccounts;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}