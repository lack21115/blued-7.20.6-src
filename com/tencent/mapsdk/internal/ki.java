package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.mi;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ki.class */
public interface ki extends mi.a {
    int a();

    Class a(String str);

    <T> Class<? extends T> a(String str, Class<T> cls);

    Object a(Class cls, String str, Class[] clsArr, Object[] objArr);

    <T> T a(Class<T> cls, Object... objArr);

    Object a(Object obj, String str, Class[] clsArr, Object[] objArr);

    Object a(Object obj, String str, Object... objArr);

    ClassLoader b();

    Object b(String str);

    File c();
}
