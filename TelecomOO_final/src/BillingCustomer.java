public class BillingCustomer extends TimingCustomer {

    private long totalBillRate;

    public BillingCustomer(String name, int areacode) {
        super(name, areacode);
        totalBillRate = 0;
    }

    public BillingCall call(BillingCustomer receiver) {
        BillingCall billingCall = new BillingCall(this, receiver);
        addCall(billingCall);
        return billingCall;
    }

    public void addBillRate(long billRate) {
        totalBillRate += billRate;
    }

    public long getTotalBillRate() {
        return totalBillRate;
    }

}
