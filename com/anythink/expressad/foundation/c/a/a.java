package com.anythink.expressad.foundation.c.a;

import com.anythink.expressad.foundation.g.a.d;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/c/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private d f4918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.foundation.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/c/a/a$a.class */
    public static final class C0071a {

        /* renamed from: a  reason: collision with root package name */
        private static a f4919a = new a((byte) 0);

        private C0071a() {
        }
    }

    private a() {
        this.f4918a = new d();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0071a.f4919a;
    }

    private JSONArray b() {
        return new JSONArray((Collection) this.f4918a.a());
    }

    public final JSONObject a(String str) {
        JSONObject b = this.f4918a.b(str);
        if (b != null) {
            return b;
        }
        return null;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.f4918a.a(next, jSONObject.optJSONObject(next));
            }
        }
    }
}
