package com.elbit.demo;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MsgsContainer {
    //list of blog posts
    private List<Message> messages;
    private static MsgsContainer instance = null;

    private MsgsContainer()
    {
        messages = new ArrayList<>();
    }

    public static MsgsContainer getInstance() {
        if (instance == null) {
            instance = new MsgsContainer();
        }
        return instance;
    }

    public void AddMsg(Message msg){
//        this.messages.add(msg);
        this.messages.add(0,msg);
    }

   public String GetAllMsgsSinceMidnight(){
       Long time = new Date().getTime();
       Date date = new Date(time - 7200000 - time % (24 * 60 * 60 * 1000));
       long midnight = date.getTime();
       Timestamp midnightTimeStamp = new Timestamp(midnight);
       StringBuilder sb = new StringBuilder();
       for (Message msg:messages) {
           if (msg.getTimestamp().after(midnightTimeStamp)){
               sb.append(msg);
           }
       }
       return sb.toString();
   }
}
