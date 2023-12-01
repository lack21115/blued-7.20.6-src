package com.efs.sdk.base.core.config;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public com.efs.sdk.base.core.config.a f21757a;
    public Context b;

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f21758a = new b((byte) 0);

        public static /* synthetic */ b a() {
            return f21758a;
        }
    }

    private b() {
        this.b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public final String a() {
        return this.f21757a.b("net", "disconnected").toString();
    }
}
