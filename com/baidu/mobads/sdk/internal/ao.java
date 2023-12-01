package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ao.class */
public class ao extends RouteInfo {

    /* renamed from: a  reason: collision with root package name */
    private v f9312a;

    public ao(String str) {
        setPath(str);
        b();
    }

    private void b() {
        RouteInfo routeInfo;
        try {
            Class<?> cls = Class.forName(w.ap + getPath());
            if (cls != null) {
                Method declaredMethod = cls.getDeclaredMethod("getRoutesMap", new Class[0]);
                declaredMethod.setAccessible(true);
                HashMap hashMap = (HashMap) declaredMethod.invoke(null, new Object[0]);
                if (hashMap == null || hashMap.size() <= 0 || (routeInfo = (RouteInfo) hashMap.get(getPath())) == null) {
                    return;
                }
                this.f9312a = (v) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Throwable th) {
        }
    }

    public Object a() {
        return this.f9312a;
    }
}
