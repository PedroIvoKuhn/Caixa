package com.pedro.caixa.domain;

import java.util.List;

public class MonthlyAccounts {
    private String month;
    private List<Account> incomming;
    private List<Account> expenses;

    public MonthlyAccounts(){
    }

    public MonthlyAccounts(String month, List<Account> incomming, List<Account> expenses) {
        this.month = month.toUpperCase();
        this.incomming = incomming;
        this.expenses = expenses;
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

    public void setIncomming(List<Account> incomming) {
        this.incomming = incomming;
    }

    public List<Account> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Account> expenses) {
        this.expenses = expenses;
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