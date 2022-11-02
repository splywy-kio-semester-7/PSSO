public class BillingCall extends Call {

    public BillingCall(BillingCustomer caller, BillingCustomer receiver) {
        super(caller, receiver);
        Connection c;
        if (receiver.localTo(caller)) {
            c = new BillingLocal(caller, receiver);
        } else {
            c = new BillingLongDistance(caller, receiver);
        }
        connections.addElement(c);
    }
}
