package com.alibaba.mtl.appmonitor.d;

import android.text.TextUtils;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private a f4465a;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f4466c;

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/b$a.class */
    enum a {
        IN,
        NOT_IN
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.f4466c.contains(str);
        return this.f4465a == a.IN ? contains : !contains;
    }
}
