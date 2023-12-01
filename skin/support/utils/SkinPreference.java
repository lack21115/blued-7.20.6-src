package skin.support.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-3503164-dex2jar.jar:skin/support/utils/SkinPreference.class */
public class SkinPreference {

    /* renamed from: a  reason: collision with root package name */
    private static SkinPreference f44250a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f44251c;
    private final SharedPreferences.Editor d;

    private SkinPreference(Context context) {
        this.b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("meta-data", 0);
        this.f44251c = sharedPreferences;
        this.d = sharedPreferences.edit();
    }

    public static SkinPreference a() {
        return f44250a;
    }

    public static void a(Context context) {
        if (f44250a == null) {
            synchronized (SkinPreference.class) {
                try {
                    if (f44250a == null) {
                        f44250a = new SkinPreference(context.getApplicationContext());
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
        return this.f44251c.getString("skin-name", "");
    }

    public SkinPreference b(String str) {
        this.d.putString("skin-user-theme-json", str);
        return this;
    }

    public int c() {
        return this.f44251c.getInt("skin-strategy", -1);
    }

    public String d() {
        return this.f44251c.getString("skin-user-theme-json", "");
    }

    public void e() {
        this.d.apply();
    }
}
