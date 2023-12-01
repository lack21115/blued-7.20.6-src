package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/local/HijackingDetectWrapper.class */
public final class HijackingDetectWrapper implements IResolver {
    private final Resolver resolver;

    public HijackingDetectWrapper(Resolver resolver) {
        this.resolver = resolver;
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        boolean z;
        Record[] resolve = this.resolver.resolve(domain, networkInfo);
        if (domain.hasCname) {
            int length = resolve.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (resolve[i2].isCname()) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (!z) {
                throw new DnshijackingException(domain.domain, this.resolver.address.getHostAddress());
            }
        }
        if (domain.maxTtl != 0) {
            int length2 = resolve.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                Record record = resolve[i4];
                if (!record.isCname() && record.ttl > domain.maxTtl) {
                    throw new DnshijackingException(domain.domain, this.resolver.address.getHostAddress(), record.ttl);
                }
                i3 = i4 + 1;
            }
        }
        return resolve;
    }
}
