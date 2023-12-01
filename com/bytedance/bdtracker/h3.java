package com.bytedance.bdtracker;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h3.class */
public final class h3 {

    /* renamed from: a  reason: collision with root package name */
    public static f3<String> f7620a = new a();

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h3$a.class */
    public static final class a extends f3<String> {
        @Override // com.bytedance.bdtracker.f3
        public String a(Object[] objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            String str = string;
            if (TextUtils.isEmpty(string)) {
                str = UUID.randomUUID().toString();
                com.bytedance.bdtracker.a.a(sharedPreferences, "cdid", str);
            }
            return str;
        }
    }
}
