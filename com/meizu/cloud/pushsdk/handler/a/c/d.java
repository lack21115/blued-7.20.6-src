package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f24143a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f24144c;
    private String d;

    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f24145a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f24146c;
        private String d;

        public a a(String str) {
            this.f24145a = str;
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
            this.f24146c = str;
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
        this.f24143a = !TextUtils.isEmpty(aVar.f24145a) ? aVar.f24145a : "";
        this.b = !TextUtils.isEmpty(aVar.b) ? aVar.b : "";
        this.f24144c = !TextUtils.isEmpty(aVar.f24146c) ? aVar.f24146c : "";
        this.d = TextUtils.isEmpty(aVar.d) ? "" : aVar.d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
        cVar.a("task_id", this.f24143a);
        cVar.a(PushConstants.SEQ_ID, this.b);
        cVar.a(PushConstants.PUSH_TIMESTAMP, this.f24144c);
        cVar.a("device_id", this.d);
        return cVar.toString();
    }

    public String c() {
        return this.f24143a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f24144c;
    }

    public String f() {
        return this.d;
    }
}
