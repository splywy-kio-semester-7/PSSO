/*

Copyright (c) Xerox Corporation 1998-2002.  All rights reserved.

Use and copying of this software and preparation of derivative works based
upon this software are permitted.  Any distribution of this software or
derivative works must comply with all applicable United States export control
laws.

This software is made available AS IS, and Xerox Corporation makes no warranty
about the software, its performance or its conformity to any specification.

|<---            this code is formatted to fit into 80 columns             --->|
|<---            this code is formatted to fit into 80 columns             --->|
|<---            this code is formatted to fit into 80 columns             --->|

*/


public abstract class AbstractSimulation {

    public static AbstractSimulation simulation;

    /**
     * Creates objects and puts them to work.
     */
    public void run() {
        TimingCustomer jim = new TimingCustomer("Jim", 650);
        TimingCustomer mik = new TimingCustomer("Mik", 650);
        TimingCustomer crista = new TimingCustomer("Crista", 415);

        say("jim calls mik...");
        TimingCall c1 = jim.call(mik);
        wait(1);
        say("mik accepts...");
        mik.pickup(c1);
        wait(4);
        say("jim hangs up...");
        jim.hangup(c1);

        say("jim calls crista...");
        TimingCall c2 = jim.call(crista);
        say("crista accepts...");
        crista.pickup(c2);
        wait(2);
        say("crista hangs up...");
        crista.hangup(c2);

        report(jim);
        report(crista);
        report(mik);

    }

    /**
     * Print a report of the connection time for customer
     */
    abstract protected void report(TimingCustomer c);

    protected static void wait(int seconds) {
        Object dummy = new Object();
        synchronized (dummy) {
            try {dummy.wait(seconds*1000); }
            catch (Exception e) {}
        }
    }

    /**
     * Put a message on standard output
     */
    protected static void say(String s){
    	System.out.println(s);
    }

}
