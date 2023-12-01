package com.qiniu.android.dns;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/Network.class */
public final class Network {
    private static String previousIp = "";

    public static String getIp() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.connect(InetAddress.getByName("114.114.114.114"), 53);
            InetAddress localAddress = datagramSocket.getLocalAddress();
            datagramSocket.close();
            return localAddress.getHostAddress();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isNetworkChanged() {
        synchronized (Network.class) {
            try {
                String ip = getIp();
                if (ip.equals(previousIp)) {
                    return false;
                }
                previousIp = ip;
                return true;
            } finally {
            }
        }
    }
}
