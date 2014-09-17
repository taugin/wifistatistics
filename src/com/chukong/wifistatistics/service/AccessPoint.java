package com.chukong.wifistatistics.service;

public class AccessPoint {

    /** The network name. */
    public String SSID;

    /** The address of the access point. */
    public String BSSID;
    /**
     * Describes the authentication, key management, and encryption schemes
     * supported by the access point.
     */

    public String capabilities;
    /**
     * The detected signal level in dBm. At least those are the units used by
     * the TI driver.
     */

    public int level;
    /**
     * The frequency in MHz of the channel over which the client is
     * communicating with the access point.
     */
    public int frequency;

    /**
     * Time Synchronization Function (tsf) timestamp in microseconds when this
     * result was last seen.
     */
    public long timestamp;

    public boolean connecting;

    public String toString() {
        String out = "";
        out += "SSID : " + SSID + "\n";
        out += "BSSID : " + BSSID + "\n";
        out += "capabilities : " + capabilities + "\n";
        out += "level : " + level + "\n";
        out += "frequency : " + frequency + "\n";
        out += "timestamp : " + timestamp + "\n";
        out += "connecting : " + connecting;
        return out;
    }
}
