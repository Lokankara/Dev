package com.luxoft.bank.domain;

import com.luxoft.bank.exceptions.ClientExistsException;
import com.luxoft.bank.service.EmailService;
import com.luxoft.bank.utils.ClientRegistrationListener;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.*;

import static com.luxoft.tutor.Logger.log;

public class Bank implements Serializable {
    private final List<Client> clients = new ArrayList<Client>();
    private final List<ClientRegistrationListener> listeners = new ArrayList<>();
    private final EmailService emailService = new EmailService();

    private int printedClients = 0;
    private int emailedClients = 0;
    private int debuggedClients = 0;

    public Bank() {
        listeners.add(new PrintClientListener());
        listeners.add(new EmailNotificationListener());
        listeners.add(new DebugListener());
    }

    public Bank(String bank) {

    }

    public int getPrintedClients() {
        return printedClients;
    }

    public int getEmailedClients() {
        return emailedClients;
    }

    public int getDebuggedClients() {
        return debuggedClients;
    }

    public void addClient(final Client client) throws ClientExistsException {
        if (!clients.contains(client)) {
            clients.add(client);
            notify(client);
        } else {
            throw new ClientExistsException("Client already exists into the bank");
        }
    }

    private void notify(Client client) {
        for (ClientRegistrationListener listener : listeners) {
            listener.onClientAdded(client);
        }
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public void close() {
        emailService.close();
    }

    class PrintClientListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client client) {
            printedClients++;
            log(String.format("Client added: %s%n", client.getName()));
        }

    }

    class EmailNotificationListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client client) {
            emailedClients++;
            log(String.format("Notification email for client %s to be sent", client.getName()));
        }
    }

    class DebugListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client client) {
            debuggedClients++;
            log(String.format("Client %s added on: %s", client.getName(), DateFormat.getDateInstance(DateFormat.FULL).format(new Date())));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;
        Bank bank = (Bank) o;
        return printedClients == bank.printedClients && emailedClients == bank.emailedClients && debuggedClients == bank.debuggedClients && Objects.equals(clients, bank.clients) && Objects.equals(listeners, bank.listeners) && Objects.equals(emailService, bank.emailService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clients, listeners, emailService, printedClients, emailedClients, debuggedClients);
    }
}
