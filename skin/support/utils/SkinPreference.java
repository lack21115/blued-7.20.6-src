package skin.support.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-3503164-dex2jar.jar:skin/support/utils/SkinPreference.class */
public class SkinPreference {
    private static SkinPreference a;
    private final Context b;
    private final SharedPreferences c;
    private final SharedPreferences.Editor d;

    private SkinPreference(Context context) {
        this.b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("meta-data", 0);
        this.c = sharedPreferences;
        this.d = sharedPreferences.edit();
    }

    public static SkinPreference a() {
        return a;
    }

    public static void a(Context context) {
        if (a == null) {
            synchronized (SkinPreference.class) {
                try {
                    if (a == null) {
                        a = new SkinPreference(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
    }

    public SkinPreference a(int i) {
        this.d.putInt("skin-strategy", i);
        return this;
    }

    public SkinPreference a(String str) {
        this.d.putString("skin-name", str);
        return this;
    }

    public String b() {
        return this.c.getString("skin-name", "");
    }

    public SkinPreference b(String str) {
        this.d.putString("skin-user-theme-json", str);
        return this;
    }

    public int c() {
        return this.c.getInt("skin-strategy", -1);
    }

    public String d() {
        return this.c.getString("skin-user-theme-json", "");
    }

    public void e() {
        this.d.apply();
    }
}
