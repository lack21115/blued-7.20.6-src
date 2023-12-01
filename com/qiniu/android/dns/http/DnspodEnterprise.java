package com.qiniu.android.dns.http;

import com.huawei.openalliance.ad.constant.t;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.util.Hex;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/http/DnspodEnterprise.class */
public final class DnspodEnterprise implements IResolver {
    private final String id;
    private final String ip;
    private final SecretKeySpec key;
    private final int timeout;

    public DnspodEnterprise(String str, String str2) {
        this(str, str2, "119.29.29.29");
    }

    public DnspodEnterprise(String str, String str2, String str3) {
        this(str, str2, str3, 10);
    }

    public DnspodEnterprise(String str, String str2, String str3, int i) {
        this.id = str;
        this.ip = str3;
        this.timeout = i;
        try {
            this.key = new SecretKeySpec(str2.getBytes("utf-8"), "DES");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    private String decrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(2, this.key);
            return new String(cipher.doFinal(Hex.decodeHex(str.toCharArray())));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String encrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, this.key);
            byte[] doFinal = cipher.doFinal(str.getBytes("utf-8"));
            return Hex.encodeHexString(doFinal) + "&id=" + this.id;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + this.ip + "/d?ttl=1&dn=" + encrypt(domain.domain) + "&id=" + this.id).openConnection();
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
            String[] split = decrypt(new String(bArr, 0, read)).split(",");
            if (split.length != 2) {
                return null;
            }
            try {
                int parseInt = Integer.parseInt(split[1]);
                String[] split2 = split[0].split(t.aE);
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
