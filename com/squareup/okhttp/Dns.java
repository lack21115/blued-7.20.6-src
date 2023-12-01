package com.squareup.okhttp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Dns.class */
public interface Dns {
    public static final Dns SYSTEM = new Dns() { // from class: com.squareup.okhttp.Dns.1
        @Override // com.squareup.okhttp.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
