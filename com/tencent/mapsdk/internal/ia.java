package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ia.class */
public class ia {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ia$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f37551a;

        public a(SharedPreferences.Editor editor) {
            this.f37551a = editor;
        }

        public void a(String str, float f) {
            this.f37551a.putFloat(str, f);
            this.f37551a.commit();
        }

        public void a(String str, int i) {
            this.f37551a.putInt(str, i);
            this.f37551a.commit();
        }

        public void a(String str, long j) {
            this.f37551a.putLong(str, j);
            this.f37551a.commit();
        }

        public void a(String str, String str2) {
            this.f37551a.putString(str, str2);
            this.f37551a.commit();
        }

        public void a(String str, Set<String> set) {
            this.f37551a.putStringSet(str, set);
            this.f37551a.commit();
        }

        public void a(String str, boolean z) {
            this.f37551a.putBoolean(str, z);
            this.f37551a.commit();
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
