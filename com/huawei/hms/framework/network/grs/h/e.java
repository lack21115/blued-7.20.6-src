package com.huawei.hms.framework.network.grs.h;

import com.huawei.hms.framework.common.Logger;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/h/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9117a = "e";

    public static boolean a(Long l) {
        if (l == null) {
            Logger.v(f9117a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l.longValue() - System.currentTimeMillis() >= 0) {
                Logger.i(f9117a, "isSpExpire false.");
                return false;
            }
            Logger.i(f9117a, "isSpExpire true.");
            return true;
        } catch (NumberFormatException e) {
            Logger.v(f9117a, "isSpExpire spValue NumberFormatException.");
            return true;
        }
    }

    public static boolean a(Long l, long j) {
        if (l == null) {
            Logger.v(f9117a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l.longValue() - (System.currentTimeMillis() + j) >= 0) {
                Logger.v(f9117a, "isSpExpire false.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            Logger.v(f9117a, "isSpExpire spValue NumberFormatException.");
            return true;
        }
    }
}
