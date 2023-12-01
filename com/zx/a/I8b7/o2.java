package com.zx.a.I8b7;

import android.content.Context;
import android.text.TextUtils;
import com.zx.module.annotation.Java2C;
import com.zx.module.base.Callback;
import com.zx.module.base.ZXModule;
import com.zx.module.context.ContextHolder;
import com.zx.module.exception.ZXModuleInvokeException;
import com.zx.sdk.api.SAIDCallback;
import com.zx.sdk.api.ZXIDListener;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o2.class */
public class o2 {
    public static final AtomicBoolean e = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public ZXModule f42155a = null;
    public final o0 b;

    /* renamed from: c  reason: collision with root package name */
    public final y1 f42156c;
    public final x1 d;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o2$a.class */
    public class a implements ContextHolder {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f42157a;

        public a(o2 o2Var, Context context) {
            this.f42157a = context;
        }

        @Override // com.zx.module.context.ContextHolder
        public Object getContext() {
            return this.f42157a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o2$b.class */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SAIDCallback f42158a;

        public b(o2 o2Var, SAIDCallback sAIDCallback) {
            this.f42158a = sAIDCallback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.f42158a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.f42158a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (Throwable th) {
                z1.a(th);
                SAIDCallback sAIDCallback = this.f42158a;
                if (sAIDCallback != null) {
                    sAIDCallback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o2$c.class */
    public class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.zx.sdk.api.Callback f42159a;

        public c(o2 o2Var, com.zx.sdk.api.Callback callback) {
            this.f42159a = callback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.f42159a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.f42159a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (Throwable th) {
                z1.a(th);
                com.zx.sdk.api.Callback callback = this.f42159a;
                if (callback != null) {
                    callback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o2$d.class */
    public class d implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.zx.sdk.api.Callback f42160a;

        public d(o2 o2Var, com.zx.sdk.api.Callback callback) {
            this.f42160a = callback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.f42160a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.f42160a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (Throwable th) {
                z1.a(th);
                com.zx.sdk.api.Callback callback = this.f42160a;
                if (callback != null) {
                    callback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o2$e.class */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final o2 f42161a = new o2();
    }

    public o2() {
        o0 o0Var = new o0();
        this.b = o0Var;
        y1 y1Var = new y1();
        this.f42156c = y1Var;
        x1 x1Var = new x1();
        this.d = x1Var;
        o0Var.a("MESSAGE_ON_ZXID_CHANGED", y1Var);
        o0Var.a("MESSAGE_ON_ZXID_RECEIVED", x1Var);
        try {
            a(t2.f42201a);
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXModule init failed: "));
        }
    }

    @Java2C.Method2C
    public native String a(String str, String str2, String str3, String str4, String str5, String str6, SAIDCallback sAIDCallback) throws ZXModuleInvokeException, JSONException;

    public void a() throws r1 {
        try {
            this.f42155a.start();
        } catch (Exception e2) {
            StringBuilder a2 = m2.a("Raised exception in start: ");
            a2.append(e2.getMessage());
            throw new r1(a2.toString(), e2);
        }
    }

    @Java2C.Method2C
    public native void a(Context context) throws r1;

    @Java2C.Method2C
    public native void a(String str, com.zx.sdk.api.Callback callback) throws ZXModuleInvokeException, JSONException;

    public void a(String str, ZXIDListener zXIDListener) throws r1 {
        if (zXIDListener != null) {
            try {
                x1 x1Var = this.d;
                x1Var.getClass();
                if (!TextUtils.isEmpty(str)) {
                    LinkedList<ZXIDListener> linkedList = x1Var.f42227a.get(str);
                    LinkedList<ZXIDListener> linkedList2 = linkedList;
                    if (linkedList == null) {
                        linkedList2 = new LinkedList<>();
                    }
                    linkedList2.add(zXIDListener);
                    x1Var.f42227a.put(str, linkedList2);
                }
            } catch (Exception e2) {
                z1.a(e2);
                StringBuilder a2 = m2.a("Raised exception while getZXID: nested exception is ");
                a2.append(e2.getMessage());
                throw new r1(a2.toString(), e2);
            }
        }
        a();
    }

    @Java2C.Method2C
    public native void a(boolean z) throws ZXModuleInvokeException, JSONException;

    @Java2C.Method2C
    public native void b(String str, com.zx.sdk.api.Callback callback) throws ZXModuleInvokeException, JSONException;
}
