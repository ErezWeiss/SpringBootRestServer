package com.elbit.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Message {
    @JsonProperty("ClientName")
     private String ClientName;
    @JsonProperty("MsgContent")
    private String MsgContent;
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Message(){
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return ClientName + ": " + MsgContent+"\n";
    }
}
