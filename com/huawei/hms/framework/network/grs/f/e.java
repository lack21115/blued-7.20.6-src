package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/f/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22694a = "e";
    public static final Set<String> b = Collections.unmodifiableSet(new a(16));

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/f/e$a.class */
    class a extends HashSet<String> {
        a(int i) {
            super(i);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
        r8.append(r9);
        r8.append(r6);
        com.huawei.hms.framework.common.Logger.i(r7, r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0083, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r6, com.huawei.hms.framework.network.grs.e.a r7, java.lang.String r8, com.huawei.hms.framework.network.grs.GrsBaseInfo r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.e.a(android.content.Context, com.huawei.hms.framework.network.grs.e.a, java.lang.String, com.huawei.hms.framework.network.grs.GrsBaseInfo, boolean):java.lang.String");
    }

    public static String b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(f22694a, "routeBy must be not empty string or null.");
            return null;
        } else if ("no_route".equals(str) || "unconditional".equals(str)) {
            Logger.v(f22694a, "routeBy equals NO_ROUTE_POLICY");
            return "no_route_country";
        } else {
            return a(context, aVar, str, grsBaseInfo, z);
        }
    }
}
