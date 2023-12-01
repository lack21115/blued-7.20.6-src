package com.qiniu.android.common;

import com.qiniu.android.collect.LogHandler;
import java.net.URI;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/common/Zone.class */
public abstract class Zone {

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/common/Zone$QueryHandler.class */
    public interface QueryHandler {
        void onFailure(int i);

        void onSuccess();
    }

    public abstract void frozenDomain(String str);

    public abstract void preQuery(LogHandler logHandler, String str, QueryHandler queryHandler);

    public abstract boolean preQuery(LogHandler logHandler, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public String upHost(ZoneInfo zoneInfo, boolean z, String str) {
        String str2;
        String format;
        synchronized (this) {
            if (str != null) {
                zoneInfo.frozenDomain(URI.create(str).getHost());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zoneInfo.upDomainsList.size()) {
                    str2 = null;
                    break;
                }
                String str3 = zoneInfo.upDomainsList.get(i2);
                long longValue = zoneInfo.upDomainsMap.get(str3).longValue();
                str2 = str3;
                if (longValue == 0) {
                    break;
                } else if (longValue <= System.currentTimeMillis() / 1000) {
                    str2 = str3;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (str2 != null) {
                zoneInfo.upDomainsMap.put(str2, 0L);
            } else {
                for (String str4 : zoneInfo.upDomainsList) {
                    zoneInfo.upDomainsMap.put(str4, 0L);
                }
                if (zoneInfo.upDomainsList.size() > 0) {
                    str2 = zoneInfo.upDomainsList.get(0);
                }
            }
            format = str2 != null ? z ? String.format("https://%s", str2) : String.format("http://%s", str2) : null;
        }
        return format;
    }

    public abstract String upHost(String str, boolean z, String str2);
}
