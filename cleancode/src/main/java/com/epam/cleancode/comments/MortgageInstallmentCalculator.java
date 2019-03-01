package com.epam.cleancode.comments;

class MortgageInstallmentCalculator {

    MortgageInstallmentCalculator() {
    }

    /**
     * @param principalAmount       principal amount
     * @param termOfMortgageInYears term of mortgage in years
     * @param rateOfInterest        rate of interest
     * @return monthly payment amount
     */
    static double calculateMonthlyPayment(
            int principalAmount, int termOfMortgageInYears, double rateOfInterest) {
        double termInMonths = termOfMortgageInYears * 12.0;
        double rateInDecimal = rateOfInterest / 100.0;
        double monthlyRate = rateInDecimal / 12.0;

        if (principalAmount < 0 || termOfMortgageInYears <= 0 || rateOfInterest < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }
        if (rateInDecimal == 0) {
            return principalAmount / termInMonths;
        }

        return (principalAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
    }
}
