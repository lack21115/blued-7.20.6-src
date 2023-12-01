package c.t.m.g;

import android.location.Location;
import android.os.Bundle;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/l4.class */
public class l4 {

    /* renamed from: a  reason: collision with root package name */
    public static final Location f3873a;

    static {
        new Bundle();
        f3873a = new Location("EMPTY");
    }

    public static String a(int i, int i2, int i3) {
        String str;
        StringBuilder sb = new StringBuilder();
        boolean b = n0.b().b("https");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http");
        sb2.append(b ? "s" : "");
        String sb3 = sb2.toString();
        if (p4.d0 && p4.e0) {
            str = sb3 + "://lbs.map.iot.wechatpay.cn/loc";
        } else {
            str = sb3 + "://lbs.map.qq.com/loc";
        }
        sb.append(str);
        sb.append("?");
        sb.append("c=");
        sb.append(i);
        sb.append("&");
        sb.append("mars=");
        sb.append(i2);
        sb.append("&");
        sb.append("obs=");
        sb.append(i3);
        return sb.toString();
    }
}
