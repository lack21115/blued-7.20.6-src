package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f10528a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f10529c;
    private String d;

    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f10530a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f10531c;
        private String d;

        public a a(String str) {
            this.f10530a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.f10531c = str;
            return this;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f10528a = !TextUtils.isEmpty(aVar.f10530a) ? aVar.f10530a : "";
        this.b = !TextUtils.isEmpty(aVar.b) ? aVar.b : "";
        this.f10529c = !TextUtils.isEmpty(aVar.f10531c) ? aVar.f10531c : "";
        this.d = TextUtils.isEmpty(aVar.d) ? "" : aVar.d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
        cVar.a("task_id", this.f10528a);
        cVar.a(PushConstants.SEQ_ID, this.b);
        cVar.a(PushConstants.PUSH_TIMESTAMP, this.f10529c);
        cVar.a("device_id", this.d);
        return cVar.toString();
    }

    public String c() {
        return this.f10528a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f10529c;
    }

    public String f() {
        return this.d;
    }
}
