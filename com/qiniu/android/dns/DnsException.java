package com.qiniu.android.dns;

import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/DnsException.class */
public class DnsException extends IOException {
    public DnsException(String str, String str2) {
        super(str + ": " + str2);
    }
}
