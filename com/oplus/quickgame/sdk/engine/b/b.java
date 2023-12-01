package com.oplus.quickgame.sdk.engine.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f10700a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f10701c;

    /* renamed from: com.oplus.quickgame.sdk.engine.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/b$b.class */
    public static class C0445b {
        static final /* synthetic */ boolean d = !b.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        private String f10702a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, String> f10703c;

        private C0445b() {
        }

        public C0445b a(String str) {
            this.b = str.toLowerCase();
            return this;
        }

        public C0445b a(String str, String str2) {
            if (this.f10703c == null) {
                this.f10703c = new HashMap();
            }
            this.f10703c.put(str, str2);
            return this;
        }

        public b a() {
            if (d || TextUtils.isEmpty(this.f10702a) || TextUtils.isEmpty(this.b)) {
                return new b(this);
            }
            throw new AssertionError();
        }

        public C0445b b(String str) {
            this.f10702a = str;
            return this;
        }
    }

    private b(C0445b c0445b) {
        this.f10701c = c0445b.f10703c;
        this.f10700a = c0445b.f10702a;
        this.b = c0445b.b;
    }

    public static C0445b d() {
        return new C0445b();
    }

    public Map<String, String> a() {
        return this.f10701c;
    }

    public String b() {
        return this.b.toUpperCase();
    }

    public String c() {
        return this.f10700a;
    }
}
