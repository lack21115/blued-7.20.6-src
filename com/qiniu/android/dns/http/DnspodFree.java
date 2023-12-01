package com.qiniu.android.dns.http;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/http/DnspodFree.class */
public final class DnspodFree implements IResolver {
    private final String ip;
    private final int timeout;

    public DnspodFree() {
        this("119.29.29.29");
    }

    public DnspodFree(String str) {
        this(str, 10);
    }

    public DnspodFree(String str, int i) {
        this.ip = str;
        this.timeout = i;
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + this.ip + "/d?ttl=1&dn=" + domain.domain).openConnection();
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setReadTimeout(this.timeout * 1000);
        Record[] recordArr = null;
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        int contentLength = httpURLConnection.getContentLength();
        if (contentLength > 0) {
            if (contentLength > 1024) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[contentLength];
            int read = inputStream.read(bArr);
            inputStream.close();
            if (read <= 0) {
                return null;
            }
            int i = 0;
            String[] split = new String(bArr, 0, read).split(",");
            if (split.length != 2) {
                return null;
            }
            try {
                int parseInt = Integer.parseInt(split[1]);
                String[] split2 = split[0].split(";");
                if (split2.length != 0) {
                    Record[] recordArr2 = new Record[split2.length];
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    while (true) {
                        recordArr = recordArr2;
                        if (i >= split2.length) {
                            break;
                        }
                        recordArr2[i] = new Record(split2[i], 1, parseInt, currentTimeMillis);
                        i++;
                    }
                } else {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return recordArr;
    }
}
