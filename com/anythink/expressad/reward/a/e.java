package com.anythink.expressad.reward.a;

import com.anythink.expressad.foundation.h.o;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/e.class */
public final class e implements com.anythink.expressad.e.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8153a = "RewardUnitCacheManager";
    private ConcurrentHashMap<String, com.anythink.expressad.videocommon.e.d> b;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/e$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f8154a = new e((byte) 0);

        private a() {
        }
    }

    private e() {
        this.b = new ConcurrentHashMap<>();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public static e a() {
        return a.f8154a;
    }

    public final com.anythink.expressad.videocommon.e.d a(String str, String str2) {
        try {
            try {
                return this.b.remove(str + BridgeUtil.UNDERLINE_STR + str2);
            } catch (Exception e) {
                o.d(f8153a, e.getMessage());
                return null;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    public final void a(String str, String str2, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            String str3 = str + BridgeUtil.UNDERLINE_STR + str2;
            if (dVar != null && this.b.containsKey(str3)) {
                this.b.remove(str3);
            }
            this.b.put(str3, dVar);
        } catch (Exception e) {
            o.d(f8153a, e.getMessage());
        }
    }
}
