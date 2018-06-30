package br.puc.se.designPatterns.creational.prototype;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BlockChainTransactionLoader implements Cloneable {

    List<UserTransaction> transactions;
    
    public List<UserTransaction> loadTransactionsFromFile(String fileName) {
        return loadTheMessages(fileName);
    }

    private List<UserTransaction> loadTheMessages(String fileName) {
        try {
            Thread.sleep(6000); // :p
            
            this.transactions = PrototypeUtils.readLinesFromResource(fileName);
            
            return this.transactions;
        } catch (IOException | InterruptedException e) {
        }

        return new LinkedList<>();
    }

    BlockChainTransactionLoader deepCopy() {
        try {
            return (BlockChainTransactionLoader) this.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
