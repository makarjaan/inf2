package ru.itis.inf304.kontolnaya;


public class BroadcastsTime implements Comparable<BroadcastsTime>{
    private byte hour;
    private byte minute;

    public BroadcastsTime(String time) {
        String[] hhmm = time.split(":");
        hour = Byte.parseByte(hhmm[0]);
        minute = Byte.parseByte(hhmm[1]);
    }

    private int getsecund() {
        return hour * 60 * 60 + minute * 60;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }


    public void setMinute(byte minute) {
        this.minute = minute;
    }


    public byte hour() {
        return hour;
    }
    public byte minutes() {
        return minute;
    }
    public boolean after(BroadcastsTime t) {
        return (t.getsecund() - this.getsecund()) < 0;
    }
    public boolean befor(BroadcastsTime t) {
        return (t.getsecund() - this.getsecund()) > 0;
    }
    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return (t2.getsecund() - t1.getsecund()) > this.getsecund();
    }

    @Override
    public int compareTo(BroadcastsTime o) {
        return Integer.compare(this.getsecund(), o.getsecund());
    }


}
