package ru.itis.inf304.kontolnaya;


public class Program implements Comparable<Program>{
    private String channelName;
    private BroadcastsTime time;
    private String BroadcastsName;

//    public Program(String channelName, BroadcastsTime time, String broadcastName) {
//        this.channelName = channelName;
//        this.time = time;
//        this.BroadcastsName = broadcastName;
//    }

    public String getBroadcastsName() {
        return BroadcastsName;
    }

    public void setBroadcastsName(String broadcastsName) {
        BroadcastsName = broadcastsName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public void setTime(BroadcastsTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Program{" +
                "channelName='" + channelName + '\'' +
                ", time=" + time +
                ", BroadcastsName='" + BroadcastsName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Program o) {
        return 0;
    }
}
