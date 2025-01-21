package com.HeiseiChain.HeiseiChain.model;

import java.security.PublicKey;
import java.util.ArrayList;

public class RegistrationTransaction extends Transaction {
    private final String address;

    public RegistrationTransaction(PublicKey userPublicKey, String username) {
        super(userPublicKey, userPublicKey, "registration", 0, "User Registration of "+username, new ArrayList<>());
        this.address = userPublicKey.toString();
    }

    public String getAddress() {
        return address;
    }

}
