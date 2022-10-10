package com.artem.week3.atm;

public class AutomatedTellerMachine {

    private static final String WITHDRAWAL_ONY_TYPE_OF_NOTES =
            "The following denominations have been issued: %d notes of %d $CAD";
    private static final String WITHDRAWAL_TWO_TYPES_OF_NOTES =
            "The following denominations have been issued: %d notes of %d $CAD, %d notes of %d $CAD";
    private static final String WITHDRAWAL_THREE_TYPES_OF_NOTES =
            "The following denominations have been issued: %d notes of %d $CAD, %d notes of %d $CAD, %d notes of %d $CAD";
    private static final String AVAILABLE_BANKNOTES =
            "Available banknotes: %d $CAD - %d, %d $CAD - %d, %d $CAD - %d.";

    private static final int TWENTY_NOMINAL = 20;

    private static final int FIFTY_NOMINAL = 50;

    private static final int HUNDRED_NOMINAL = 100;

    private int numberOfTwenties;

    private int numberOfFifty;

    private int numberOfHundred;

    private int balance;

    public AutomatedTellerMachine(int numberOfTwenties, int numberOfFifty, int numberOfHundred) {
        this.numberOfTwenties = numberOfTwenties;
        this.numberOfFifty = numberOfFifty;
        this.numberOfHundred = numberOfHundred;
        this.balance = numberOfTwenties * TWENTY_NOMINAL + numberOfFifty * FIFTY_NOMINAL + numberOfHundred * HUNDRED_NOMINAL;
    }


    public void cashPutting(int twenties, int fifty, int hundred) {
        numberOfTwenties += twenties;
        numberOfFifty += fifty;
        numberOfHundred += hundred;
        balanceChangingPutting(twenties, fifty, hundred);
    }

    public boolean cashWithdraw(int cashAmount) {
        if (cashAmount > balance) {
            System.out.println("Not enough money in the account");
            return false;
        }
        if (cashAmount % 10 != 0) {
            System.out.println("You can't withdraw that amount of money");
            return false;
        }
        if (cashAmount == balance) {
            balance = 0;
            printWithdrawalWithThreeTypesOfNotes(cashAmount, numberOfHundred, HUNDRED_NOMINAL, numberOfFifty, FIFTY_NOMINAL, numberOfTwenties, TWENTY_NOMINAL);
            numberOfTwenties = 0;
            numberOfFifty = 0;
            numberOfHundred = 0;
            return true;
        }
        if (cashAmount >= HUNDRED_NOMINAL) {
            int hundredNotesNumber = Math.min(numberOfHundred, countNecessaryNumberOfNotes(cashAmount, HUNDRED_NOMINAL));
            numberOfHundred -= hundredNotesNumber;
            int sum = hundredNotesNumber * HUNDRED_NOMINAL;
            balanceChangingWithdrawal(hundredNotesNumber, HUNDRED_NOMINAL);
            cashAmount = countBalanceOfNotes(cashAmount, hundredNotesNumber, HUNDRED_NOMINAL);
            if (cashAmount <= 0) {
                printWithdrawalWithOneTypeOfNotes(sum, hundredNotesNumber, HUNDRED_NOMINAL);
            }
        }
        if (cashAmount >= FIFTY_NOMINAL) {
            int fiftyNotesNumber = Math.min(numberOfFifty, countNecessaryNumberOfNotes(cashAmount, FIFTY_NOMINAL));
            balanceChangingWithdrawal(fiftyNotesNumber, FIFTY_NOMINAL);
            numberOfFifty -= fiftyNotesNumber;
            int sum = fiftyNotesNumber * FIFTY_NOMINAL;
            cashAmount = countBalanceOfNotes(cashAmount, fiftyNotesNumber, FIFTY_NOMINAL);
            if (cashAmount <= 0) {
                printWithdrawalWithOneTypeOfNotes(sum, fiftyNotesNumber, FIFTY_NOMINAL);
            }
        }
        if (cashAmount >= TWENTY_NOMINAL) {
            int twentyNotesNumber = Math.min(numberOfTwenties, countNecessaryNumberOfNotes(cashAmount, TWENTY_NOMINAL));
            balanceChangingWithdrawal(twentyNotesNumber, TWENTY_NOMINAL);
            numberOfTwenties -= twentyNotesNumber;
            int sum = twentyNotesNumber * TWENTY_NOMINAL;
            cashAmount = countBalanceOfNotes(cashAmount, twentyNotesNumber, TWENTY_NOMINAL);
            if (cashAmount <= 0) {
                printWithdrawalWithOneTypeOfNotes(sum, twentyNotesNumber, TWENTY_NOMINAL);
            } else {
                printWithdrawalWithOneTypeOfNotes(sum, twentyNotesNumber, TWENTY_NOMINAL);
            }
        }
        return cashAmount <= 0;
    }

    private void printWithdrawalWithOneTypeOfNotes(int cashAmount, int countOfNotes, int notes) {
        System.out.println("Successful withdrawal - " + cashAmount + " $CAD");
        System.out.printf(WITHDRAWAL_ONY_TYPE_OF_NOTES, countOfNotes, notes);
        System.out.println();
    }

    private void printWithdrawalWithTwoTypesOfNotes(int cashAmount, int countOfNotes1, int notes1, int countOfNotes2, int notes2) {
        System.out.println("Successful withdrawal - " + cashAmount + " $CAD");
        System.out.printf(WITHDRAWAL_TWO_TYPES_OF_NOTES, countOfNotes1, notes1, countOfNotes2, notes2);
        System.out.println();
    }

    private void printWithdrawalWithThreeTypesOfNotes(int cashAmount, int countOfNotes1, int notes1, int countOfNotes2,
                                                      int notes2, int countOfNotes3, int notes3) {
        System.out.println("Successful withdrawal - " + cashAmount + " $CAD");
        System.out.printf(WITHDRAWAL_THREE_TYPES_OF_NOTES, countOfNotes1, notes1, countOfNotes2, notes2, countOfNotes3, notes3);
        System.out.println();
    }

    public void printBalance() {
        System.out.println("On your account: " + balance + " $CAD");
        System.out.printf(AVAILABLE_BANKNOTES, HUNDRED_NOMINAL, numberOfHundred, FIFTY_NOMINAL, numberOfFifty, TWENTY_NOMINAL, numberOfTwenties);
        System.out.println();
    }

    private void balanceChangingWithdrawal(int numberOfNotes, int noteNominal) {
        balance -= numberOfNotes * noteNominal;
    }

    private void balanceChangingPutting(int twenties, int fifty, int hundred) {
        balance += twenties * TWENTY_NOMINAL + fifty * FIFTY_NOMINAL + hundred * HUNDRED_NOMINAL;
    }

    private int countNecessaryNumberOfNotes(int cashAmount, int noteNominal) {
        return cashAmount / noteNominal;
    }

    private int countBalanceOfNotes(int cashAmount, int numberOfNotes, int noteNominal) {
        return cashAmount - (numberOfNotes * noteNominal);
    }
}