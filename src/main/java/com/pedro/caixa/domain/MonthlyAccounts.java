package com.pedro.caixa.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MonthlyAccounts {
    @Id
    private String id;
    private String userId;
    private String month;
    private List<Account> incomming;
    private List<Account> expenses;

    public MonthlyAccounts(){
    }

    public MonthlyAccounts(String id, String userId, String month) {
        this.id = id;
        this.userId = userId;
        this.month = month.toUpperCase();
        this.incomming = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<Account> getIncomming() {
        return incomming;
    }

    public void setIncomming(Account incomming) {
        this.incomming.add(incomming);
    }

    public List<Account> getExpenses() {
        return expenses;
    }

    public void setExpense(Account expense) {
        this.expenses.add(expense);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((month == null) ? 0 : month.hashCode());
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
        MonthlyAccounts other = (MonthlyAccounts) obj;
        if (month == null) {
            if (other.month != null)
                return false;
        } else if (!month.equals(other.month))
            return false;
        return true;
    }
}