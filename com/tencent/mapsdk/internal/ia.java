package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ia.class */
public class ia {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ia$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f23860a;

        public a(SharedPreferences.Editor editor) {
            this.f23860a = editor;
        }

        public void a(String str, float f) {
            this.f23860a.putFloat(str, f);
            this.f23860a.commit();
        }

        public void a(String str, int i) {
            this.f23860a.putInt(str, i);
            this.f23860a.commit();
        }

        public void a(String str, long j) {
            this.f23860a.putLong(str, j);
            this.f23860a.commit();
        }

        public void a(String str, String str2) {
            this.f23860a.putString(str, str2);
            this.f23860a.commit();
        }

        public void a(String str, Set<String> set) {
            this.f23860a.putStringSet(str, set);
            this.f23860a.commit();
        }

        public void a(String str, boolean z) {
            this.f23860a.putBoolean(str, z);
            this.f23860a.commit();
        }
    }

    public static SharedPreferences a(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences("TMS_" + str, 0);
        }
        return null;
    }

    public static a a(SharedPreferences sharedPreferences) {
        return new a(sharedPreferences.edit());
    }
}
