package com.HeiseiChain.HeiseiChain.model;

import com.HeiseiChain.HeiseiChain.util.StringUtil;

import java.security.PublicKey;

public class TransactionOutput {
    public String id; // Unique identifier for this output
    public PublicKey recipient; // Recipient of the output (the new owner of these funds)
    public float value; // Amount of money or value being transferred
    public String parentTransactionId; // The ID of the transaction where this output was created

    // Constructor for creating a new TransactionOutput
    public TransactionOutput(PublicKey recipient, float value, String parentTransactionId) {
        this.recipient = recipient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StringUtil.applySha256(
                StringUtil.getStringFromKey(recipient) + Float.toString(value) + parentTransactionId
        );
    }

    // Check if this output belongs to the given public key (i.e., is it owned by the public key?)
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == recipient);
    }
}
