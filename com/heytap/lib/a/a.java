package com.heytap.lib.a;

import android.os.Build;
import android.util.Base64;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata
/* loaded from: source-7994992-dex2jar.jar:com/heytap/lib/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22221a = new a();

    private a() {
    }

    @JvmStatic
    public static final String a(String str, String str2, String str3, String str4) {
        String str5 = "1\u0001" + str3 + "\u0001" + str + "\u0001" + Build.MODEL + "\u0001" + Build.BRAND + "\u0001" + str2 + "\u0001" + str4;
        Charset charset = Charsets.b;
        if (str5 != null) {
            byte[] bytes = str5.getBytes(charset);
            Intrinsics.b(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] encode = Base64.encode(bytes, 2);
            Intrinsics.b(encode, "Base64.encode(routeData.…EFAULT or Base64.NO_WRAP)");
            return new String(encode, Charsets.b);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
