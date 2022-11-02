public class TimingCall extends Call {
    public TimingCall(TimingCustomer caller, TimingCustomer receiver) {
        super(caller, receiver);
        Connection c;
        if (receiver.localTo(caller)) {
            c = new TimingLocal(caller, receiver);
        } else {
            c = new TimingLongDistance(caller, receiver);
        }
        connections.addElement(c);
    }
}
