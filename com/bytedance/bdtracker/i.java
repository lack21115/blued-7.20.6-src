package com.bytedance.bdtracker;

import com.bytedance.bdtracker.l;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i.class */
public final class i<T extends l> {
    public static final a b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public T f21228a;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i$a.class */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends l> i<T> a(String str, Class<T> clazz) {
            Intrinsics.d(clazz, "clazz");
            JSONObject jSONObject = new JSONObject(str);
            i<T> iVar = new i<>();
            jSONObject.optInt("code");
            jSONObject.optString("message");
            iVar.f21228a = (T) l.f21245a.a(jSONObject.optJSONObject("data"), clazz);
            return iVar;
        }
    }

    public final T a() {
        return this.f21228a;
    }
}
