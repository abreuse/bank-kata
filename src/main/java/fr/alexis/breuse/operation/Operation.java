package fr.alexis.breuse.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Getter
public class Operation {
    private Date date;

    private OperationType type;

    private double balance;

    private double amount;

    @Override
    public String toString() {
        StringBuilder operation = new StringBuilder();
        return operation.append(new SimpleDateFormat("yyyy-MM-dd").format(date))
                .append("\t|\t")
                .append(type)
                .append("\t|\t")
                .append(amount)
                .append("\t|\t")
                .append(balance)
                .append("\t|\t")
                .toString();
    }
}
