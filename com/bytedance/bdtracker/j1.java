package com.bytedance.bdtracker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.internal.telephony.PhoneConstants;
import com.bytedance.bdtracker.e2;
import com.bytedance.bdtracker.l1;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/j1.class */
public class j1 {

    /* renamed from: a  reason: collision with root package name */
    public static String f21237a;

    public static Class<?> a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Class<?> b = b(strArr[i2]);
            if (b != null) {
                return b;
            }
            i = i2 + 1;
        }
    }

    public static Object a(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            z2.a(th);
            return null;
        }
    }

    public static String a(final Context context) {
        try {
            return e2.a(context).a("Secure.getString_android_id", new e2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$ynstapR8Z_wdtwPZXu8nr8bLR54
                @Override // com.bytedance.bdtracker.e2.a
                public final String a() {
                    return j1.c(Context.this);
                }
            });
        } catch (Throwable th) {
            z2.a(th);
            return null;
        }
    }

    public static String a(View view) {
        if (view == null) {
            return null;
        }
        return b(view) + "$$" + view.hashCode();
    }

    public static String a(Object obj) {
        return obj != null ? obj.toString() : "";
    }

    public static String a(boolean z) {
        return z ? "yes" : "no";
    }

    public static JSONObject a(h1 h1Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TypedValues.AttributesType.S_FRAME, h1Var.m());
            jSONObject.put("element_path", h1Var.u);
            ArrayList<String> arrayList = h1Var.y;
            if (arrayList != null && arrayList.size() > 0) {
                h1Var.E = new ArrayList<>();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= h1Var.y.size()) {
                        break;
                    }
                    h1Var.E.add(PhoneConstants.APN_TYPE_ALL);
                    i = i2 + 1;
                }
                jSONObject.put("positions", new JSONArray((Collection) h1Var.y));
                jSONObject.put("fuzzy_positions", new JSONArray((Collection) h1Var.E));
            }
            ArrayList<String> arrayList2 = h1Var.x;
            if (arrayList2 != null && arrayList2.size() > 0) {
                jSONObject.put("texts", new JSONArray((Collection) h1Var.x));
            }
            jSONObject.put("zIndex", h1Var.I);
            jSONObject.put("ignore", h1Var.J);
            jSONObject.put("is_html", h1Var.D);
            JSONArray jSONArray = new JSONArray();
            for (h1 h1Var2 : h1Var.K) {
                jSONArray.put(a(h1Var2));
            }
            jSONObject.put("children", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            z2.a(e);
            return null;
        }
    }

    public static JSONObject a(l1.b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TypedValues.AttributesType.S_FRAME, bVar.b.a());
            jSONObject.put("_element_path", bVar.f21251c);
            jSONObject.put("element_path", bVar.d);
            List<String> list = bVar.e;
            if (list != null && list.size() > 0) {
                jSONObject.put("positions", new JSONArray((Collection) bVar.e));
            }
            List<String> list2 = bVar.g;
            if (list2 != null && list2.size() > 0) {
                jSONObject.put("texts", new JSONArray((Collection) bVar.g));
            }
            List<String> list3 = bVar.k;
            if (list3 != null && list3.size() > 0) {
                jSONObject.put("fuzzy_positions", new JSONArray((Collection) bVar.k));
            }
            jSONObject.put("zIndex", bVar.f);
            List<l1.b> list4 = bVar.h;
            if (list4 != null && !list4.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (l1.b bVar2 : bVar.h) {
                    jSONArray.put(a(bVar2));
                }
                jSONObject.put("children", jSONArray);
            }
            return jSONObject;
        } catch (JSONException e) {
            z2.a(e);
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            JSONObject jSONObject3 = new JSONObject();
            a(jSONObject3, jSONObject);
            try {
                String a2 = k3.a(jSONObject3.optJSONObject("oaid"));
                jSONObject2 = jSONObject3;
                if (!TextUtils.isEmpty(a2)) {
                    jSONObject3.put("oaid", a2);
                    return jSONObject3;
                }
            } catch (Exception e) {
                z2.c("U SHALL NOT PASS!", e);
                return jSONObject3;
            }
        } else {
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (JSONException e) {
                z2.c("U SHALL NOT PASS!", e);
            }
        }
        return jSONObject;
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                z2.c("U SHALL NOT PASS!", th);
            }
        }
    }

    public static void a(View view, Object obj, String str) {
        if (k2.a(view)) {
            try {
                view.getClass().getMethod("addJavascriptInterface", Object.class, String.class).invoke(view, obj, str);
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }

    public static boolean a(WebView webView) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mProvider");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(webView);
            if ("android.webkit.WebViewClassic".equals(obj)) {
                Field declaredField2 = obj.getClass().getDeclaredField("mWebViewCore");
                declaredField2.setAccessible(true);
                return declaredField2.get(obj) == null;
            }
            Field declaredField3 = obj.getClass().getDeclaredField("mAwContents");
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(obj);
            Method declaredMethod = obj2.getClass().getDeclaredMethod("isDestroyed", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj2, 0);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            z2.a("isDestroyed(): ", e);
            return false;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != null || obj2 == null) {
            return obj == null || obj2 != null;
        }
        return false;
    }

    public static boolean a(Object obj, Object obj2, String str) {
        if (a(obj, obj2)) {
            if (obj instanceof JSONObject) {
                return a((JSONObject) obj, (JSONObject) obj2, str);
            }
            if (!(obj instanceof JSONArray)) {
                if (obj.getClass() != obj2.getClass()) {
                    return false;
                }
                String obj3 = obj.toString();
                String obj4 = obj2.toString();
                boolean z = false;
                if (a((Object) obj3, (Object) obj4)) {
                    z = false;
                    if (obj3.equals(obj4)) {
                        z = true;
                    }
                }
                return z;
            }
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (a(jSONArray, jSONArray2)) {
                HashMap hashMap = new HashMap();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    Object obj5 = jSONArray.get(i2);
                    hashMap.put(obj5, (!hashMap.containsKey(obj5) || hashMap.get(obj5) == null) ? 1 : Integer.valueOf(((Integer) hashMap.get(obj5)).intValue() + 1));
                    i = i2 + 1;
                }
                HashMap hashMap2 = new HashMap();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= jSONArray2.length()) {
                        break;
                    }
                    Object obj6 = jSONArray2.get(i4);
                    hashMap2.put(obj6, (!hashMap2.containsKey(obj6) || hashMap2.get(obj6) == null) ? 1 : Integer.valueOf(((Integer) hashMap2.get(obj6)).intValue() + 1));
                    i3 = i4 + 1;
                }
                if (hashMap.size() != hashMap2.size()) {
                    return false;
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (!((Integer) entry.getValue()).equals((Integer) hashMap2.get(entry.getKey()))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean a(Object obj, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            Class<?> b = b(strArr[i2]);
            if (b != null && b.isInstance(obj)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean a(String str) {
        boolean z;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                z = true;
                break;
            } else if (str.charAt(i2) != '0') {
                z = false;
                break;
            } else {
                i = i2 + 1;
            }
        }
        return !z;
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        return str != null && str.equals(str2);
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (a((Object) jSONObject, (Object) jSONObject2)) {
            if (jSONObject == null || jSONObject.length() == jSONObject2.length()) {
                Iterator<String> keys = jSONObject.keys();
                boolean z = true;
                while (true) {
                    if (!keys.hasNext()) {
                        break;
                    }
                    String next = keys.next();
                    boolean a2 = a(jSONObject.get(next), jSONObject2.get(next), next);
                    z = a2;
                    if (!a2) {
                        z = a2;
                        break;
                    }
                }
                return z;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x000c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(org.json.JSONObject r3, java.lang.Class<?>[] r4, java.lang.Class<?>[] r5) {
        /*
            r0 = r3
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            r0 = r3
            java.util.Iterator r0 = r0.keys()
            r7 = r0
        Lc:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L7a
            r0 = r3
            r1 = r7
            java.lang.Object r1 = r1.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.get(r1)
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L2d
            r0 = 0
            return r0
        L2d:
            r0 = r8
            boolean r0 = r0 instanceof org.json.JSONArray
            if (r0 == 0) goto L68
            r0 = r8
            org.json.JSONArray r0 = (org.json.JSONArray) r0
            r8 = r0
            r0 = 0
            r6 = r0
        L3e:
            r0 = r6
            r1 = r8
            int r1 = r1.length()
            if (r0 >= r1) goto Lc
            r0 = r8
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            r9 = r0
            r0 = r5
            if (r0 == 0) goto L61
            r0 = r5
            r1 = r9
            java.lang.Class r1 = r1.getClass()
            boolean r0 = a(r0, r1)
            if (r0 != 0) goto L61
            r0 = 0
            return r0
        L61:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L3e
        L68:
            r0 = r4
            if (r0 == 0) goto Lc
            r0 = r4
            r1 = r8
            java.lang.Class r1 = r1.getClass()
            boolean r0 = a(r0, r1)
            if (r0 != 0) goto Lc
            r0 = 0
            return r0
        L7a:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.j1.a(org.json.JSONObject, java.lang.Class[], java.lang.Class[]):boolean");
    }

    public static boolean a(boolean z, String str) {
        return b(!z, str);
    }

    public static <T> boolean a(T[] tArr, T t) {
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (tArr[i2] == t) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static Class<?> b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static String b(View view) {
        boolean z;
        if (view == null) {
            return "";
        }
        if (view instanceof CheckBox) {
            return "CheckBox";
        }
        if (view instanceof RadioButton) {
            return "RadioButton";
        }
        if (view instanceof ToggleButton) {
            return "ToggleButton";
        }
        if (view instanceof CompoundButton) {
            if (a((Object) view, "android.widget.Switch")) {
                return "Switch";
            }
            return a((Object) view, "androidx.appcompat.widget.SwitchCompat", "androidx.appcompat.widget.SwitchCompat") ? "SwitchCompat" : "";
        } else if (view instanceof Button) {
            return "Button";
        } else {
            if (view instanceof CheckedTextView) {
                return "CheckedTextView";
            }
            if (view instanceof TextView) {
                return "TextView";
            }
            if (view instanceof ImageView) {
                return "ImageView";
            }
            if (view instanceof RatingBar) {
                return "RatingBar";
            }
            if (view instanceof SeekBar) {
                return "SeekBar";
            }
            if (view instanceof Spinner) {
                return "Spinner";
            }
            try {
                Class<?> a2 = a("com.google.android.material.tabs.TabLayout$TabView", "com.google.android.material.tabs.TabLayout$TabView");
                z = false;
                if (a2 != null) {
                    z = false;
                    if (a2.isAssignableFrom(view.getClass())) {
                        z = true;
                    }
                }
            } catch (Throwable th) {
                z2.c("U SHALL NOT PASS!", th);
                z = false;
            }
            if (z) {
                return "TabLayout";
            }
            if (a((Object) view, "com.google.android.material.navigation.NavigationView", "com.google.android.material.navigation.NavigationView")) {
                return "NavigationView";
            }
            if (view instanceof ViewGroup) {
                if (a((Object) view, "androidx.cardview.widget.CardView", "androidx.cardview.widget.CardView")) {
                    return "CardView";
                }
                if (a((Object) view, "com.google.android.material.navigation.NavigationView", "com.google.android.material.navigation.NavigationView")) {
                    return "NavigationView";
                }
            }
            try {
                return view.getClass().getCanonicalName();
            } catch (Throwable th2) {
                z2.c("U SHALL NOT PASS!", th2);
                return "";
            }
        }
    }

    public static boolean b(Context context) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            str = "getPackageInfo NameNotFoundException";
            Log.d("HWOAID", str);
            return false;
        } catch (Exception e2) {
            str = "getPackageInfo Exception";
            Log.d("HWOAID", str);
            return false;
        }
    }

    public static boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            if (jSONObject != jSONObject2) {
                return jSONObject != null && jSONObject.equals(jSONObject2);
            }
            return true;
        }
        return jSONObject.toString().equals(jSONObject2.toString());
    }

    public static boolean b(boolean z, String str) {
        if (z) {
            return false;
        }
        z2.a("[Assert failed] " + str, (Throwable) null);
        return true;
    }

    public static /* synthetic */ String c(Context context) {
        z2.a("[DeviceMeta] Try to get android id by secure.getString.");
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return jSONObject2;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                z2.a("Merge json interrupted.", e);
            }
        }
        return jSONObject2;
    }

    public static boolean c(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            char charAt = str.charAt(i2);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static JSONObject d(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            z2.a("wrong Json format, return null pointer", (Throwable) null);
            return null;
        }
    }
}
