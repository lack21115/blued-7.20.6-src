package com.anythink.expressad.foundation.h;

import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/w.class */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5141a = "StringUtils";

    public static boolean a(String str) {
        return str == null || TextUtils.isEmpty(str.trim()) || com.igexin.push.core.b.l.equals(str);
    }

    public static boolean b(String str) {
        return (str == null || TextUtils.isEmpty(str.trim()) || com.igexin.push.core.b.l.equals(str)) ? false : true;
    }
}
