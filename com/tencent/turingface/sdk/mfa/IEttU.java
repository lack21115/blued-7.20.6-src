package com.tencent.turingface.sdk.mfa;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.t;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/IEttU.class */
public final class IEttU {

    /* renamed from: a  reason: collision with root package name */
    public String f26192a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public OCkqn f26193c;

    public IEttU(String str, int i, OCkqn oCkqn) {
        this.f26192a = str;
        this.b = i;
        this.f26193c = oCkqn;
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
        String str = this.f26192a;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        sb.append(a(ContainerUtils.FIELD_DELIMITER, "%0A", a(",", "%54", a("_", "%5F", a(t.aE, "%3B", a(":", "%3A", str2))))));
        sb.append("_");
        sb.append(this.b);
        sb.append("_");
        OCkqn oCkqn = this.f26193c;
        if (oCkqn == null) {
            return sb.toString();
        }
        sb.append(oCkqn.b);
        sb.append(":");
        sb.append(this.f26193c.f26208c);
        sb.append(":");
        Iterator<XnM3A> it = this.f26193c.d.iterator();
        while (it.hasNext()) {
            XnM3A next = it.next();
            sb.append(next.f26237a);
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
                sb.append(t.aE);
            }
        }
        sb.append(":");
        sb.append(this.f26193c.e);
        return sb.toString();
    }
}
