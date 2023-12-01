package com.tencent.qmsp.sdk.a;

import android.content.Context;
import com.tencent.qmsp.sdk.f.h;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f24822a = {52, 125, -96, 80};
    private static final byte[] b = {107, 124, -70, 66, 61};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f24823c = {107, 67, -107, 117, 97};

    public static String a() {
        Context context;
        context = com.tencent.qmsp.sdk.app.a.getContext();
        return context.getDir(com.tencent.qmsp.sdk.c.b.f24856a + h.a(f24822a), 0).toString();
    }

    public static String b() {
        return a() + File.separator + h.a(b);
    }

    public static String c() {
        return a() + File.separator + h.a(f24823c);
    }
}
