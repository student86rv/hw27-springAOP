package ua.epam.springAOP.model;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "balance")
    private double balance;
    @Column(name = "email")
    private String email;

    public Account() {
    }

    public Account(String name, double balance, String email) {
        this.name = name;
        this.balance = balance;
        this.email = email;
    }

    public Account(long id, String name, double balance, String email) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                '}';
    }
}
