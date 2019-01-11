package fr.alexis.breuse;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Operation {
    private Date date;

    private OperationType type;

    private double balance;

    private double amount;

}
