package com.tencent.turingface.sdk.mfa;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/IEttU.class */
public final class IEttU {

    /* renamed from: a  reason: collision with root package name */
    public String f39883a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public OCkqn f39884c;

    public IEttU(String str, int i, OCkqn oCkqn) {
        this.f39883a = str;
        this.b = i;
        this.f39884c = oCkqn;
    }

    public static String a(String str, String str2, String str3) {
        String str4 = str3;
        if (!TextUtils.isEmpty(str3)) {
            str4 = str3.replace(str, str2);
        }
        return str4;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        String str = this.f39883a;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        sb.append(a("&", "%0A", a(",", "%54", a(BridgeUtil.UNDERLINE_STR, "%5F", a(";", "%3B", a(":", "%3A", str2))))));
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(this.b);
        sb.append(BridgeUtil.UNDERLINE_STR);
        OCkqn oCkqn = this.f39884c;
        if (oCkqn == null) {
            return sb.toString();
        }
        sb.append(oCkqn.b);
        sb.append(":");
        sb.append(this.f39884c.f39899c);
        sb.append(":");
        Iterator<XnM3A> it = this.f39884c.d.iterator();
        while (it.hasNext()) {
            XnM3A next = it.next();
            sb.append(next.f39928a);
            sb.append(",");
            sb.append(",");
            sb.append(",");
            String format = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.d));
            String str3 = format;
            if (format.indexOf(".") > 0) {
                str3 = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb.append(str3);
            sb.append(",");
            String format2 = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.e));
            String str4 = format2;
            if (format2.indexOf(".") > 0) {
                str4 = format2.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb.append(str4);
            if (it.hasNext()) {
                sb.append(";");
            }
        }
        sb.append(":");
        sb.append(this.f39884c.e);
        return sb.toString();
    }
}
