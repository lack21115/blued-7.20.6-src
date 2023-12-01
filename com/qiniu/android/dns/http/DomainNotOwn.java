package com.qiniu.android.dns.http;

import com.qiniu.android.dns.DnsException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/http/DomainNotOwn.class */
public class DomainNotOwn extends DnsException {
    public DomainNotOwn(String str) {
        super(str, "dns not own");
    }
}
