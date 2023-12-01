package skin.support.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.i;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import skin.support.SkinCompatManager;
import skin.support.utils.SkinPreference;
import skin.support.utils.Slog;

/* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatUserThemeManager.class */
public class SkinCompatUserThemeManager {

    /* renamed from: a  reason: collision with root package name */
    private static SkinCompatUserThemeManager f44227a = new SkinCompatUserThemeManager();
    private boolean e;
    private boolean i;
    private final HashMap<String, ColorState> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final Object f44228c = new Object();
    private final WeakHashMap<Integer, WeakReference<ColorStateList>> d = new WeakHashMap<>();
    private final HashMap<String, String> f = new HashMap<>();
    private final Object g = new Object();
    private final WeakHashMap<Integer, WeakReference<Drawable>> h = new WeakHashMap<>();

    private SkinCompatUserThemeManager() {
        try {
            h();
        } catch (JSONException e) {
            this.b.clear();
            this.f.clear();
            if (Slog.f44252a) {
                Slog.a("SkinCompatUserThemeManager", "startLoadFromSharedPreferences error: " + e);
            }
        }
    }

    private String a(int i, String str) {
        Context context = SkinCompatManager.a().getContext();
        if (str.equalsIgnoreCase(context.getResources().getResourceTypeName(i))) {
            return context.getResources().getResourceEntryName(i);
        }
        return null;
    }

    private void a(int i, ColorStateList colorStateList) {
        if (colorStateList != null) {
            synchronized (this.f44228c) {
                this.d.put(Integer.valueOf(i), new WeakReference<>(colorStateList));
            }
        }
    }

    private void a(int i, Drawable drawable) {
        if (drawable != null) {
            synchronized (this.g) {
                this.h.put(Integer.valueOf(i), new WeakReference<>(drawable));
            }
        }
    }

    public static SkinCompatUserThemeManager b() {
        return f44227a;
    }

    private ColorStateList c(int i) {
        synchronized (this.f44228c) {
            WeakReference<ColorStateList> weakReference = this.d.get(Integer.valueOf(i));
            if (weakReference != null) {
                ColorStateList colorStateList = weakReference.get();
                if (colorStateList != null) {
                    return colorStateList;
                }
                this.d.remove(Integer.valueOf(i));
            }
            return null;
        }
    }

    private static boolean c(String str) {
        boolean z = !TextUtils.isEmpty(str) && new File(str).exists();
        if (Slog.f44252a && !z) {
            Slog.a("SkinCompatUserThemeManager", "Invalid drawable path : " + str);
        }
        return z;
    }

    private Drawable d(int i) {
        synchronized (this.g) {
            WeakReference<Drawable> weakReference = this.h.get(Integer.valueOf(i));
            if (weakReference != null) {
                Drawable drawable = weakReference.get();
                if (drawable != null) {
                    return drawable;
                }
                this.h.remove(Integer.valueOf(i));
            }
            return null;
        }
    }

    private void h() throws JSONException {
        String d = SkinPreference.a().d();
        if (!TextUtils.isEmpty(d)) {
            JSONArray jSONArray = new JSONArray(d);
            if (Slog.f44252a) {
                Slog.a("SkinCompatUserThemeManager", "startLoadFromSharedPreferences: " + jSONArray.toString());
            }
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.has("type")) {
                    String string = jSONObject.getString("type");
                    if ("color".equals(string)) {
                        ColorState a2 = ColorState.a(jSONObject);
                        if (a2 != null) {
                            this.b.put(a2.b, a2);
                        }
                    } else if (i.f7952c.equals(string)) {
                        String string2 = jSONObject.getString("drawableName");
                        String string3 = jSONObject.getString("drawablePathAndAngle");
                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                            this.f.put(string2, string3);
                        }
                    }
                }
                i = i2 + 1;
            }
        }
        this.e = this.b.isEmpty();
        this.i = this.f.isEmpty();
    }

    private void i() {
        synchronized (this.f44228c) {
            this.d.clear();
        }
    }

    private void j() {
        synchronized (this.g) {
            this.h.clear();
        }
    }

    public ColorStateList a(int i) {
        ColorStateList c2 = c(i);
        ColorStateList colorStateList = c2;
        if (c2 == null) {
            String a2 = a(i, "color");
            colorStateList = c2;
            if (!TextUtils.isEmpty(a2)) {
                ColorState colorState = this.b.get(a2);
                colorStateList = c2;
                if (colorState != null) {
                    ColorStateList b = colorState.b();
                    colorStateList = b;
                    if (b != null) {
                        a(i, b);
                        colorStateList = b;
                    }
                }
            }
        }
        return colorStateList;
    }

    public void a() {
        JSONArray jSONArray = new JSONArray();
        for (String str : this.b.keySet()) {
            ColorState colorState = this.b.get(str);
            if (colorState != null) {
                try {
                    jSONArray.put(ColorState.a(colorState).putOpt("type", "color"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        for (String str2 : this.f.keySet()) {
            try {
                jSONArray.put(new JSONObject().putOpt("type", i.f7952c).putOpt("drawableName", str2).putOpt("drawablePathAndAngle", this.f.get(str2)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (Slog.f44252a) {
            Slog.a("SkinCompatUserThemeManager", "Apply user theme: " + jSONArray.toString());
        }
        SkinPreference.a().b(jSONArray.toString()).e();
        SkinCompatManager.a().j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
        this.e = this.b.isEmpty();
    }

    public Drawable b(int i) {
        BitmapDrawable bitmapDrawable;
        Drawable d = d(i);
        Drawable drawable = d;
        if (d == null) {
            String a2 = a(i, i.f7952c);
            drawable = d;
            if (!TextUtils.isEmpty(a2)) {
                String str = this.f.get(a2);
                drawable = d;
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(":");
                    int i2 = 0;
                    String str2 = split[0];
                    if (split.length == 2) {
                        i2 = Integer.valueOf(split[1]).intValue();
                    }
                    drawable = d;
                    if (c(str2)) {
                        if (i2 == 0) {
                            bitmapDrawable = Drawable.createFromPath(str2);
                        } else {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(i2);
                            Bitmap decodeFile = BitmapFactory.decodeFile(str2);
                            bitmapDrawable = new BitmapDrawable((Resources) null, Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true));
                        }
                        drawable = bitmapDrawable;
                        if (bitmapDrawable != null) {
                            a(i, bitmapDrawable);
                            drawable = bitmapDrawable;
                        }
                    }
                }
            }
        }
        return drawable;
    }

    public ColorState b(String str) {
        return this.b.get(str);
    }

    public void c() {
        this.b.clear();
        i();
        this.e = true;
        a();
    }

    public void d() {
        this.f.clear();
        j();
        this.i = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        i();
        j();
    }
}
