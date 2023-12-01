package com.qiniu.android.dns;

import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/IResolver.class */
public interface IResolver {
    public static final int DNS_DEFAULT_TIMEOUT = 10;

    Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException;
}
