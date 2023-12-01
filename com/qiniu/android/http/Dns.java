package com.qiniu.android.http;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/Dns.class */
public interface Dns {
    List<InetAddress> lookup(String str) throws UnknownHostException;
}
