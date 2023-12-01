package com.oplus.quickgame.sdk.engine.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f24387a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f24388c;

    /* renamed from: com.oplus.quickgame.sdk.engine.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/b$b.class */
    public static class C0615b {
        static final /* synthetic */ boolean d = !b.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        private String f24389a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, String> f24390c;

        private C0615b() {
        }

        public C0615b a(String str) {
            this.b = str.toLowerCase();
            return this;
        }

        public C0615b a(String str, String str2) {
            if (this.f24390c == null) {
                this.f24390c = new HashMap();
            }
            this.f24390c.put(str, str2);
            return this;
        }

        public b a() {
            if (d || TextUtils.isEmpty(this.f24389a) || TextUtils.isEmpty(this.b)) {
                return new b(this);
            }
            throw new AssertionError();
        }

        public C0615b b(String str) {
            this.f24389a = str;
            return this;
        }
    }

    private b(C0615b c0615b) {
        this.f24388c = c0615b.f24390c;
        this.f24387a = c0615b.f24389a;
        this.b = c0615b.b;
    }

    public static C0615b d() {
        return new C0615b();
    }

    public Map<String, String> a() {
        return this.f24388c;
    }

    public String b() {
        return this.b.toUpperCase();
    }

    public String c() {
        return this.f24387a;
    }
}
