package com.qiniu.android.dns.local;

import com.qiniu.android.dns.DnsException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/local/DnshijackingException.class */
public class DnshijackingException extends DnsException {
    public DnshijackingException(String str, String str2) {
        super(str, "has hijacked by " + str2);
    }

    public DnshijackingException(String str, String str2, int i) {
        super(str, "has hijacked by " + str2 + " ttl " + i);
    }
}
