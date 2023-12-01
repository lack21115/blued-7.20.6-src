package com.ishumei.l111l11111lIl;

import android.text.TextUtils;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111lIl.class */
public class l111l11111lIl {
    private static final String l1111l111111Il = "sm";
    private Map<String, l111l11111I1l> l111l11111I1l;
    private Map<String, l111l11111Il> l111l11111Il;
    private Map<String, C0289l111l11111lIl> l111l11111lIl;
    private Set<String> l111l1111l1Il;
    private String l111l1111lI1l;
    private String l111l1111lIl;
    private List<l1111l111111Il> l111l1111llIl;
    private boolean l11l1111I1ll;
    private String l11l1111lIIl;
    private boolean l11l111l11Il;
    private boolean l11l111l1lll;
    private boolean l11l11IlIIll;
    private boolean l11l1111I11l = true;
    private boolean l11l1111I1l = true;
    private int l11l1111Il = 50;
    private int l11l1111Il1l = 10;
    private boolean l11l1111Ill = true;
    private int l111l11IlIlIl = 0;
    private int l11l111l1I1l = 2;
    private int l11l111l1Il = -1;
    private int l11l111ll11l = 100;
    private int l11l111ll1Il = 10;
    private int l11l111lll = 60;

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111lIl$l1111l111111Il.class */
    public static final class l1111l111111Il {
        private static int l1111l111111Il = 1;
        private static int l111l11111I1l = 3;
        private static int l111l11111lIl = 2;
        private String l111l11111Il;
        private String l111l1111l1Il;
        private List<String> l111l1111lI1l;
        private int l111l1111lIl;
        private String l111l1111llIl;

        private String l111l1111l1Il() {
            return this.l111l11111Il;
        }

        public final String l1111l111111Il() {
            return this.l111l1111l1Il;
        }

        public final void l1111l111111Il(int i) {
            this.l111l1111lIl = i;
        }

        public final void l1111l111111Il(String str) {
            this.l111l11111Il = str;
        }

        public final void l1111l111111Il(List<String> list) {
            this.l111l1111lI1l = list;
        }

        public final List<String> l111l11111I1l() {
            return this.l111l1111lI1l;
        }

        public final void l111l11111I1l(String str) {
            this.l111l1111llIl = str;
        }

        public final int l111l11111Il() {
            return this.l111l1111lIl;
        }

        public final String l111l11111lIl() {
            return this.l111l1111llIl;
        }

        public final void l111l11111lIl(String str) {
            this.l111l1111l1Il = str;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111lIl$l111l11111I1l.class */
    public static final class l111l11111I1l {
        private static int l1111l111111Il = 0;
        private static int l111l11111lIl = 1;
        private String l111l11111I1l;
        private int l111l11111Il;
        private String l111l1111l1Il;

        public final String l1111l111111Il() {
            return this.l111l11111I1l;
        }

        public final void l1111l111111Il(int i) {
            this.l111l11111Il = i;
        }

        public final void l1111l111111Il(String str) {
            this.l111l11111I1l = str;
        }

        public final int l111l11111I1l() {
            return this.l111l11111Il;
        }

        public final String l111l11111lIl() {
            return this.l111l1111l1Il;
        }

        public final void l111l11111lIl(String str) {
            this.l111l1111l1Il = str;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111lIl$l111l11111Il.class */
    public static final class l111l11111Il {
        private String l1111l111111Il;
        private String l111l11111lIl;

        public final String l1111l111111Il() {
            return this.l1111l111111Il;
        }

        public final void l1111l111111Il(String str) {
            this.l1111l111111Il = str;
        }

        public final String l111l11111lIl() {
            return this.l111l11111lIl;
        }

        public final void l111l11111lIl(String str) {
            this.l111l11111lIl = str;
        }
    }

    /* renamed from: com.ishumei.l111l11111lIl.l111l11111lIl$l111l11111lIl  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111lIl$l111l11111lIl.class */
    public static final class C0289l111l11111lIl {
        private String l1111l111111Il;
        private String l111l11111I1l;
        private String l111l11111lIl;

        private String l111l11111I1l() {
            return this.l111l11111I1l;
        }

        public final String l1111l111111Il() {
            return this.l1111l111111Il;
        }

        public final void l1111l111111Il(String str) {
            this.l1111l111111Il = str;
        }

        public final void l111l11111I1l(String str) {
            this.l111l11111I1l = str;
        }

        public final String l111l11111lIl() {
            return this.l111l11111lIl;
        }

        public final void l111l11111lIl(String str) {
            this.l111l11111lIl = str;
        }
    }

    private static Map<String, C0289l111l11111lIl> l1111l111111Il(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return hashMap;
            }
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                C0289l111l11111lIl c0289l111l11111lIl = new C0289l111l11111lIl();
                String next = jSONObject.keys().next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                c0289l111l11111lIl.l1111l111111Il(next);
                c0289l111l11111lIl.l111l11111lIl(jSONObject2.getString("pn"));
                c0289l111l11111lIl.l111l11111I1l(jSONObject2.getString("uri"));
                hashMap.put(c0289l111l11111lIl.l1111l111111Il(), c0289l111l11111lIl);
            } catch (JSONException e) {
            }
            i = i2 + 1;
        }
    }

    private static Set<String> l1111l111111Il(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (next.startsWith("sensitive.") && jSONObject.getBoolean(next)) {
                    hashSet.add(next.split("\\.")[1]);
                }
            } catch (Exception e) {
            }
        }
        return hashSet;
    }

    private void l1111l111111Il(int i) {
        this.l11l111ll11l = i;
    }

    private void l1111l111111Il(List<l1111l111111Il> list) {
        this.l111l1111llIl = list;
    }

    private void l1111l111111Il(Map<String, C0289l111l11111lIl> map) {
        this.l111l11111lIl = map;
    }

    private void l1111l111111Il(Set<String> set) {
        this.l111l1111l1Il = set;
    }

    private void l1111l111111Il(boolean z) {
        this.l11l111l1lll = z;
    }

    public static l111l11111lIl l111l11111I1l(String str) {
        l111l11111lIl l111l11111lil = new l111l11111lIl();
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                l111l11111lil.l111l11111lIl = l111l11111I1l(jSONObject.getJSONObject("risk_apps"));
            } catch (Exception e) {
            }
            try {
                l111l11111lil.l111l11111I1l = l111l11111Il(jSONObject.getJSONObject("risk_dirs"));
            } catch (Exception e2) {
            }
            try {
                l111l11111lil.l111l11111Il = l111l1111l1Il(jSONObject.getJSONObject("white_apps"));
            } catch (Exception e3) {
            }
            try {
                l111l11111lil.l111l1111l1Il = l111l1111llIl(jSONObject.getJSONObject("sensitive"));
            } catch (Exception e4) {
            }
            try {
                l111l11111lil.l11l1111I11l = jSONObject.getBoolean("core_atamper");
            } catch (Exception e5) {
            }
            try {
                l111l11111lil.l11l1111I1l = jSONObject.getBoolean("all_atamper");
            } catch (Exception e6) {
            }
            try {
                l111l11111lil.l11l1111I1ll = jSONObject.getBoolean("risk_file_switch");
            } catch (Exception e7) {
            }
            try {
                l111l11111lil.l11l1111Ill = jSONObject.getBoolean("upload_checker_switch");
            } catch (Exception e8) {
            }
            l111l11111lil.l111l1111lI1l = str;
            l111l11111lil.l111l1111lIl = l111l1111lIl.l111l1111l1Il(str);
            return l111l11111lil;
        } catch (Exception e9) {
            throw new IOException(e9);
        }
    }

    private static Map<String, l111l11111Il> l111l11111I1l(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return hashMap;
            }
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                l111l11111Il l111l11111il = new l111l11111Il();
                String next = jSONObject.keys().next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                l111l11111il.l1111l111111Il(next);
                l111l11111il.l111l11111lIl(jSONObject2.getString("pn"));
                hashMap.put(l111l11111il.l1111l111111Il(), l111l11111il);
            } catch (JSONException e) {
            }
            i = i2 + 1;
        }
    }

    private static Map<String, C0289l111l11111lIl> l111l11111I1l(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                C0289l111l11111lIl c0289l111l11111lIl = new C0289l111l11111lIl();
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                c0289l111l11111lIl.l1111l111111Il(next);
                c0289l111l11111lIl.l111l11111lIl(jSONObject2.getString("pn"));
                c0289l111l11111lIl.l111l11111I1l(jSONObject2.getString("uri"));
                hashMap.put(c0289l111l11111lIl.l1111l111111Il(), c0289l111l11111lIl);
            } catch (Exception e) {
            }
        }
        return hashMap;
    }

    private void l111l11111I1l(int i) {
        this.l11l111lll = i;
    }

    private void l111l11111I1l(Map<String, l111l11111Il> map) {
        this.l111l11111Il = map;
    }

    private void l111l11111I1l(boolean z) {
        this.l11l111l11Il = z;
    }

    private static Map<String, l111l11111I1l> l111l11111Il(JSONObject jSONObject) {
        l111l11111I1l l111l11111i1l;
        JSONObject jSONObject2;
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                l111l11111i1l = new l111l11111I1l();
                String next = keys.next();
                jSONObject2 = jSONObject.getJSONObject(next);
                l111l11111i1l.l1111l111111Il(next);
            } catch (Exception e) {
            }
            if (TextUtils.equals("sdcard", jSONObject2.getString("type"))) {
                l111l11111i1l.l1111l111111Il(0);
            } else if (TextUtils.equals("absolute", jSONObject2.getString("type"))) {
                l111l11111i1l.l1111l111111Il(1);
            }
            l111l11111i1l.l111l11111lIl(jSONObject2.getString(SharePatchInfo.OAT_DIR));
            hashMap.put(l111l11111i1l.l1111l111111Il(), l111l11111i1l);
        }
        return hashMap;
    }

    private void l111l11111Il(int i) {
        this.l111l11IlIlIl = i;
    }

    private void l111l11111Il(String str) {
        this.l111l1111lIl = str;
    }

    private void l111l11111Il(boolean z) {
        this.l11l1111Ill = z;
    }

    public static l111l11111lIl l111l11111lIl(String str) {
        l111l11111lIl l111l11111lil = new l111l11111lIl();
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (jSONObject.has("usrappcnt")) {
                    l111l11111lil.l11l1111Il = jSONObject.getInt("usrappcnt");
                }
                if (jSONObject.has("sysappcnt")) {
                    l111l11111lil.l11l1111Il1l = jSONObject.getInt("sysappcnt");
                }
            } catch (Exception e) {
            }
            try {
                l111l11111lil.l111l11111lIl = l1111l111111Il(jSONObject.getJSONArray("risk_apps"));
            } catch (Exception e2) {
            }
            try {
                l111l11111lil.l111l11111I1l = l111l11111lIl(jSONObject.getJSONArray("risk_dirs"));
            } catch (Exception e3) {
            }
            try {
                l111l11111lil.l111l11111Il = l111l11111I1l(jSONObject.getJSONArray("white_apps"));
            } catch (Exception e4) {
            }
            try {
                l111l11111lil.l111l1111l1Il = l1111l111111Il(jSONObject);
            } catch (Exception e5) {
            }
            try {
                l111l11111lil.l11l1111I11l = jSONObject.getBoolean("core_atamper");
            } catch (Exception e6) {
            }
            try {
                l111l11111lil.l11l1111I1l = jSONObject.getBoolean("all_atamper");
            } catch (Exception e7) {
            }
            try {
                l111l11111lil.l11l1111I1ll = jSONObject.getBoolean("risk_file_switch");
            } catch (Exception e8) {
            }
            try {
                l111l11111lil.l11l1111Ill = jSONObject.getBoolean("upload_checker_switch");
            } catch (Exception e9) {
            }
            try {
                l111l11111lil.l11l11IlIIll = jSONObject.getBoolean("hook_switch");
            } catch (Exception e10) {
            }
            try {
                l111l11111lil.l11l111l11Il = jSONObject.getBoolean("hook_java_switch");
            } catch (Exception e11) {
            }
            try {
                l111l11111lil.l11l111l1lll = jSONObject.optBoolean("ip_cache_switch");
            } catch (Exception e12) {
            }
            try {
                l111l11111lil.l111l11IlIlIl = jSONObject.getInt("net_max");
            } catch (Exception e13) {
            }
            try {
                l111l11111lil.l11l111l1I1l = jSONObject.getInt("re_max");
            } catch (Exception e14) {
            }
            try {
                l111l11111lil.l11l111l1Il = jSONObject.getInt("up_max");
            } catch (Exception e15) {
            }
            try {
                l111l11111lil.l11l111lll = jSONObject.optInt("weventt", 60);
                l111l11111lil.l11l111ll11l = jSONObject.optInt("weventc", 100);
                l111l11111lil.l11l111ll1Il = jSONObject.optInt("weventmax", 10);
            } catch (Exception e16) {
            }
            l111l11111lil.l111l1111lI1l = str;
            l111l11111lil.l111l1111lIl = l111l1111lIl.l111l1111l1Il(str);
            return l111l11111lil;
        } catch (Exception e17) {
            throw new IOException(e17);
        }
    }

    private static Map<String, l111l11111I1l> l111l11111lIl(JSONArray jSONArray) {
        l111l11111I1l l111l11111i1l;
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return hashMap;
            }
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                l111l11111i1l = new l111l11111I1l();
                String next = jSONObject2.keys().next();
                jSONObject = jSONObject2.getJSONObject(next);
                l111l11111i1l.l1111l111111Il(next);
            } catch (JSONException e) {
            }
            if (TextUtils.equals("sdcard", jSONObject.getString("type"))) {
                l111l11111i1l.l1111l111111Il(0);
            } else {
                if (TextUtils.equals("absolute", jSONObject.getString("type"))) {
                    l111l11111i1l.l1111l111111Il(1);
                }
                i = i2 + 1;
            }
            l111l11111i1l.l111l11111lIl(jSONObject.getString(SharePatchInfo.OAT_DIR));
            hashMap.put(l111l11111i1l.l1111l111111Il(), l111l11111i1l);
            i = i2 + 1;
        }
    }

    private void l111l11111lIl(int i) {
        this.l11l111ll1Il = i;
    }

    private void l111l11111lIl(Map<String, l111l11111I1l> map) {
        this.l111l11111I1l = map;
    }

    private void l111l11111lIl(JSONObject jSONObject) {
        if (jSONObject.has("usrappcnt")) {
            this.l11l1111Il = jSONObject.getInt("usrappcnt");
        }
        if (jSONObject.has("sysappcnt")) {
            this.l11l1111Il1l = jSONObject.getInt("sysappcnt");
        }
    }

    private void l111l11111lIl(boolean z) {
        this.l11l11IlIIll = z;
    }

    private static Map<String, l111l11111Il> l111l1111l1Il(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                l111l11111Il l111l11111il = new l111l11111Il();
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                l111l11111il.l1111l111111Il(next);
                l111l11111il.l111l11111lIl(jSONObject2.getString("pn"));
                hashMap.put(l111l11111il.l1111l111111Il(), l111l11111il);
            } catch (Exception e) {
            }
        }
        return hashMap;
    }

    private void l111l1111l1Il(int i) {
        this.l11l111l1I1l = i;
    }

    private void l111l1111l1Il(String str) {
        this.l111l1111lI1l = str;
    }

    private void l111l1111l1Il(boolean z) {
        this.l11l1111I1ll = z;
    }

    private void l111l1111lI1l(int i) {
        this.l11l1111Il = i;
    }

    private void l111l1111lI1l(boolean z) {
        this.l11l1111I1l = z;
    }

    private void l111l1111lIl(int i) {
        this.l11l1111Il1l = i;
    }

    private static Set<String> l111l1111llIl(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (jSONObject.getBoolean(next)) {
                    hashSet.add(next);
                }
            } catch (Exception e) {
            }
        }
        return hashSet;
    }

    private void l111l1111llIl(int i) {
        this.l11l111l1Il = i;
    }

    private void l111l1111llIl(boolean z) {
        this.l11l1111I11l = z;
    }

    private boolean l11l111l1I1l() {
        return this.l11l11IlIIll;
    }

    private List<l1111l111111Il> l11l111l1Il() {
        return this.l111l1111llIl;
    }

    private boolean l11l111ll11l() {
        return this.l11l1111I1l;
    }

    private String l11l111ll1Il() {
        return this.l11l1111lIIl;
    }

    public final int l1111l111111Il() {
        return this.l11l111ll11l;
    }

    public final void l1111l111111Il(String str) {
        this.l11l1111lIIl = str;
    }

    public final int l111l11111I1l() {
        return this.l11l111lll;
    }

    public final int l111l11111Il() {
        return this.l111l11IlIlIl;
    }

    public final int l111l11111lIl() {
        return this.l11l111ll1Il;
    }

    public final int l111l1111l1Il() {
        return this.l11l111l1I1l;
    }

    public final boolean l111l1111lI1l() {
        return this.l11l111l1lll;
    }

    public final boolean l111l1111lIl() {
        return this.l11l111l11Il;
    }

    public final int l111l1111llIl() {
        return this.l11l111l1Il;
    }

    public final Set<String> l111l11IlIlIl() {
        return this.l111l1111l1Il;
    }

    public final boolean l11l1111I11l() {
        return this.l11l1111I1ll;
    }

    public final int l11l1111I1l() {
        return this.l11l1111Il;
    }

    public final int l11l1111I1ll() {
        return this.l11l1111Il1l;
    }

    public final boolean l11l1111Il() {
        return this.l11l1111I11l;
    }

    public final String l11l1111Il1l() {
        return this.l111l1111lIl;
    }

    public final String l11l1111Ill() {
        return this.l111l1111lI1l;
    }

    public final boolean l11l1111lIIl() {
        return this.l11l1111Ill;
    }

    public final Map<String, l111l11111I1l> l11l111l11Il() {
        return this.l111l11111I1l;
    }

    public final Map<String, l111l11111Il> l11l111l1lll() {
        return this.l111l11111Il;
    }

    public final Map<String, C0289l111l11111lIl> l11l11IlIIll() {
        return this.l111l11111lIl;
    }
}
