package com.luxoft.bank.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Email implements Serializable {
    private final transient Client from;
    private final transient List<Client> to;
    private final String message;

    public Email(Client from, List<Client> to, String message) {
        this.from = from;
        this.message = message;
        this.to = to;
    }

    public Client getFrom() {
        return from;
    }

    public List<Client> getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(from, email.from) && Objects.equals(to, email.to) && Objects.equals(message, email.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, message);
    }

    @Override
    public String toString() {
        return "Email: {" +
                "from=" + from +
                ", to=" + to +
                ", message='" + message + '\'' +
                '}';
    }
}
