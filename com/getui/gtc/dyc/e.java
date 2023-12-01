package com.getui.gtc.dyc;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private c f21981a;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/e$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static e f21982a = new e();
    }

    private e() {
        this.f21981a = c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a() {
        return a.f21982a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(String str) {
        return this.f21981a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, h hVar, h hVar2) {
        if (hVar2 == null) {
            return false;
        }
        return this.f21981a.a(str, hVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, h> c() {
        return this.f21981a.c();
    }
}
