package com.umeng.analytics.filter;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/filter/d.class */
public class d {
    private static final String b = "Ă";

    /* renamed from: c  reason: collision with root package name */
    private MessageDigest f40608c;
    private boolean e;

    /* renamed from: a  reason: collision with root package name */
    private final String f40607a = "MD5";
    private Set<Object> d = new HashSet();

    public d(boolean z, String str) {
        this.e = false;
        this.e = z;
        try {
            this.f40608c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (str == null) {
            return;
        }
        if (!z) {
            for (String str2 : str.split(b)) {
                this.d.add(str2);
            }
            return;
        }
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= decode.length / 4) {
                    return;
                }
                int i3 = i2 * 4;
                this.d.add(Integer.valueOf(((decode[i3 + 0] & 255) << 24) + ((decode[i3 + 1] & 255) << 16) + ((decode[i3 + 2] & 255) << 8) + (decode[i3 + 3] & 255)));
                i = i2 + 1;
            }
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    private Integer c(String str) {
        try {
            this.f40608c.update(str.getBytes());
            byte[] digest = this.f40608c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.d) {
            sb.append(obj);
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }

    public boolean a(String str) {
        return this.e ? this.d.contains(c(str)) : this.d.contains(str);
    }

    public void b(String str) {
        if (this.e) {
            this.d.add(c(str));
        } else {
            this.d.add(str);
        }
    }

    public String toString() {
        if (!this.e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.d) {
                if (sb.length() > 0) {
                    sb.append(b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.d.size() * 4];
        Iterator<Object> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            int i2 = i + 1;
            bArr[i] = (byte) (((-16777216) & intValue) >> 24);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((16711680 & intValue) >> 16);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((65280 & intValue) >> 8);
            i = i4 + 1;
            bArr[i4] = (byte) (intValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }
}
