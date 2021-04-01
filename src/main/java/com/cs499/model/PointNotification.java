/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs499.model;

import java.security.Timestamp;

/**
 *
 * @author Dang
 */
public class PointNotification {
    private int numNotify;
    private String notifyMessage;
    private Timestamp notifyTimestamp;

    public PointNotification(int numNotify, String notifyMessage, Timestamp notifyTimestamp) {
        this.numNotify = numNotify;
        this.notifyMessage = notifyMessage;
        this.notifyTimestamp = notifyTimestamp;
    }

    public int getNumNotify() {
        return numNotify;
    }

    public String getNotifyMessage() {
        return notifyMessage;
    }

    public Timestamp getNotifyTimestamp() {
        return notifyTimestamp;
    }

    public void setNumNotify(int numNotify) {
        this.numNotify = numNotify;
    }

    public void setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
    }

    public void setNotifyTimestamp(Timestamp notifyTimestamp) {
        this.notifyTimestamp = notifyTimestamp;
    }
}
