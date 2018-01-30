/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unict.ing.pds.dhtdb.utils.model;


public class NetworkStat extends GenericStat {
    private final String interf;
    
    // TODO : Float?
    private String sent, received;

    public NetworkStat(String interf, String sent, String received, long timestamp, String scannerId) {
        super(timestamp, scannerId);
        this.interf = interf;
        this.sent = sent;
        this.received = received;
    }

    public String getInterf() {
        return interf;
    }

    public String getSent() {
        return sent;
    }

    public String getReceived() {
        return received;
    }    
}