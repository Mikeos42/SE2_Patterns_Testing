package org.example.Facades;

interface PaymentGateway {
    boolean pay(double amount);
    boolean refund(String transactionId);
    boolean verifyPayment(String transactionId);
}



class PayPalGateway implements PaymentGateway {
    @Override
    public boolean pay(double amount) {
        // Logic for processing payment via PayPal
        System.out.println("Processing payment via PayPal...");
        return true;
    }

    @Override
    public boolean refund(String transactionId) {
        // Logic for refunding payment via PayPal
        System.out.println("Refunding payment via PayPal...");
        return true;
    }



    @Override
    public boolean verifyPayment(String transactionId) {
        // Logic for verifying payment status via PayPal
        System.out.println("Verifying payment status via PayPal...");
        return true;
    }
}



class StripeGateway implements PaymentGateway {
    @Override
    public boolean pay(double amount) {
        // Logic for processing payment via Stripe
        System.out.println("Processing payment via Stripe...");
        return true;
    }



    @Override
    public boolean refund(String transactionId) {
        // Logic for refunding payment via Stripe
        System.out.println("Refunding payment via Stripe...");
        return true;
    }



    @Override
    public boolean verifyPayment(String transactionId) {
        // Logic for verifying payment status via Stripe
        System.out.println("Verifying payment status via Stripe...");
        return true;
    }
}



class AuthorizeNetGateway implements PaymentGateway {
    @Override
    public boolean pay(double amount) {
        // Logic for processing payment via Authorize.Net
        System.out.println("Processing payment via Authorize.Net...");
        return true;
    }



    @Override
    public boolean refund(String transactionId) {
        // Logic for refunding payment via Authorize.Net
        System.out.println("Refunding payment via Authorize.Net...");
        return true;
    }



    @Override
    public boolean verifyPayment(String transactionId) {
        // Logic for verifying payment status via Authorize.Net
        System.out.println("Verifying payment status via Authorize.Net...");
        return true;
    }
}



class PaymentValidator {
    public boolean validatePayment(String transactionId) {
        // Logic for validating the payment transaction
        System.out.println("Validating payment - Transaction ID: " +
                transactionId);
        // Simulated success for demonstration purposes
        return true;
    }
}



class TransactionLogger {
    public void logTransaction(String transactionId, double amount) {
        // Logic for logging the payment transaction
        System.out.println("Logging transaction - ID: " +
                transactionId + ", Amount: " + amount);
        // Simulated success for demonstration purposes
        System.out.println("Transaction logged successfully.");
    }
}

class PaymentFacade {
    private PaymentGateway paymentGateway;
    private PaymentValidator paymentValidator;
    private TransactionLogger transactionLogger;

    public PaymentFacade(PaymentGateway paymentGateway, PaymentValidator paymentValidator, TransactionLogger transactionLogger) {
        this.paymentGateway = paymentGateway;
        this.paymentValidator = paymentValidator;
        this.transactionLogger = transactionLogger;
    }

    public boolean processPayment(double amount) {
        if (paymentGateway.pay(amount)) {
            System.out.println("Payment processed successfully.");
            return true;
        }
        System.out.println("Payment processing failed.");
        return false;
    }

    public boolean processRefund(String transactionId) {
        if (paymentGateway.refund(transactionId)) {
            System.out.println("Refund processed successfully.");
            return true;
        }
        System.out.println("Refund processing failed.");
        return false;
    }

    public boolean validateAndLogPayment(String transactionId, double amount) {
        if (paymentValidator.validatePayment(transactionId)) {
            transactionLogger.logTransaction(transactionId, amount);
            return true;
        }
        System.out.println("Payment validation or logging failed.");
        return false;
    }
}


public class FacadePattern {
    public static void main(String[] args) {
        PaymentFacade bank = new PaymentFacade(new PayPalGateway(), new PaymentValidator(), new TransactionLogger());

        bank.processPayment(100);
    }
}
