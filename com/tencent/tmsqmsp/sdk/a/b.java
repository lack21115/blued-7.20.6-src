package com.tencent.tmsqmsp.sdk.a;

import android.content.Context;
import com.tencent.mapsdk.internal.oj;
import com.tencent.tmsqmsp.sdk.f.h;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f25981a = {52, 125, -96, 80};
    private static final byte[] b = {107, 124, -70, 66, 61};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f25982c = {107, 67, -107, 117, 97};

    public static String a() {
        Context context;
        context = oj.getContext();
        return context.getDir(com.tencent.tmsqmsp.sdk.c.b.f26014a + h.a(f25981a), 0).toString();
    }

    public static String b() {
        return a() + File.separator + h.a(b);
    }

    public static String c() {
        return a() + File.separator + h.a(f25982c);
    }
}
