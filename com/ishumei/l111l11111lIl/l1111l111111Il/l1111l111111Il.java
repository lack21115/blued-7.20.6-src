package com.ishumei.l111l11111lIl.l1111l111111Il;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l11111lIl.l111l11111lIl;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import com.ishumei.smantifraud.SmAntiFraud;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l1111l111111Il/l1111l111111Il.class */
public final class l1111l111111Il {
    private static final String l111l11111I1l = "sm";
    private static final String l111l11111Il = "_SUFFIX_TIME";
    private static final int l111l1111l1Il = 7;
    private Map<String, String> l111l1111lI1l;
    private Runnable l111l1111lIl;
    private AtomicBoolean l111l1111llIl;
    private static final String l1111l111111Il = l111l1111lI1l.l111l11111Il("9c9092d18c978a929a96");
    private static final String l111l11111lIl = l111l1111lI1l.l111l11111Il("9b9a89969c9a969b");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il$l1111l111111Il  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l1111l111111Il/l1111l111111Il$l1111l111111Il.class */
    public static final class C0456l1111l111111Il {
        private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte) 0);

        private C0456l1111l111111Il() {
        }
    }

    private l1111l111111Il() {
        this.l111l1111lIl = new Runnable() { // from class: com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    SmAntiFraud.SmOption smOption = SmAntiFraud.option;
                    for (String str : l1111l111111Il.l1111l111111Il(l1111l111111Il.this, new String[]{smOption.l11l1111Il1l(), smOption.l111l1111lIl()})) {
                        try {
                            String l1111l111111Il2 = l1111l111111Il.l1111l111111Il(l1111l111111Il.this, str);
                            if (!TextUtils.isEmpty(l1111l111111Il2)) {
                                l1111l111111Il.this.l1111l111111Il(str, l1111l111111Il2);
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (Throwable th) {
                }
            }
        };
        this.l111l1111lI1l = new ConcurrentHashMap();
        this.l111l1111llIl = new AtomicBoolean(false);
    }

    /* synthetic */ l1111l111111Il(byte b) {
        this();
    }

    public static l1111l111111Il l1111l111111Il() {
        return C0456l1111l111111Il.l1111l111111Il;
    }

    static /* synthetic */ String l1111l111111Il(l1111l111111Il l1111l111111il, String str) {
        return l111l11111I1l(str);
    }

    private String l1111l111111Il(String str) {
        return l1111l111111Il(str, false);
    }

    static /* synthetic */ Set l1111l111111Il(l1111l111111Il l1111l111111il, String[] strArr) {
        HashSet hashSet = new HashSet();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String l111l1111lI1l = l111l1111lIl.l111l1111lI1l(strArr[i2]);
            if (!TextUtils.isEmpty(l111l1111lI1l) && !l111l1111lIl.l111l1111lIl(l111l1111lI1l)) {
                hashSet.add(l111l1111lI1l);
            }
            i = i2 + 1;
        }
        Map<String, String> map = l1111l111111il.l111l1111lI1l;
        if (map != null && map.size() > 0) {
            hashSet.addAll(l1111l111111il.l111l1111lI1l.keySet());
        }
        return hashSet;
    }

    private Set<String> l1111l111111Il(String... strArr) {
        HashSet hashSet = new HashSet();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String l111l1111lI1l = l111l1111lIl.l111l1111lI1l(strArr[i2]);
            if (!TextUtils.isEmpty(l111l1111lI1l) && !l111l1111lIl.l111l1111lIl(l111l1111lI1l)) {
                hashSet.add(l111l1111lI1l);
            }
            i = i2 + 1;
        }
        Map<String, String> map = this.l111l1111lI1l;
        if (map != null && map.size() > 0) {
            hashSet.addAll(this.l111l1111lI1l.keySet());
        }
        return hashSet;
    }

    private static String l111l11111I1l(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName != null) {
                String hostAddress = byName.getHostAddress();
                if (TextUtils.isEmpty(hostAddress)) {
                    return null;
                }
                return hostAddress;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private void l111l11111I1l() {
        if (this.l111l1111llIl.compareAndSet(false, true)) {
            HashMap hashMap = new HashMap();
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            if (context != null) {
                HashSet<String> hashSet = new HashSet();
                for (Map.Entry<String, ?> entry : context.getSharedPreferences(l1111l111111Il, 0).getAll().entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (!key.equals(l111l11111lIl)) {
                        if (key.endsWith(l111l11111Il)) {
                            if ((value instanceof Long) && System.currentTimeMillis() - ((Long) value).longValue() > 604800000) {
                                hashSet.add(key.substring(0, key.indexOf(l111l11111Il)));
                            }
                        } else if (value instanceof String) {
                            hashMap.put(key, (String) value);
                        }
                    }
                }
                for (String str : hashSet) {
                    hashMap.remove(str);
                }
            }
            this.l111l1111lI1l.putAll(hashMap);
            com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this.l111l1111lIl, 7);
        }
    }

    private static Map<String, String> l111l11111Il() {
        HashMap hashMap = new HashMap();
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return hashMap;
        }
        HashSet<String> hashSet = new HashSet();
        for (Map.Entry<String, ?> entry : context.getSharedPreferences(l1111l111111Il, 0).getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!key.equals(l111l11111lIl)) {
                if (key.endsWith(l111l11111Il)) {
                    if ((value instanceof Long) && System.currentTimeMillis() - ((Long) value).longValue() > 604800000) {
                        hashSet.add(key.substring(0, key.indexOf(l111l11111Il)));
                    }
                } else if (value instanceof String) {
                    hashMap.put(key, (String) value);
                }
            }
        }
        for (String str : hashSet) {
            hashMap.remove(str);
        }
        return hashMap;
    }

    private String l111l11111lIl(String str) {
        return l1111l111111Il(l111l1111lIl.l111l1111lI1l(str), false);
    }

    private String l111l11111lIl(String str, boolean z) {
        return l1111l111111Il(l111l1111lIl.l111l1111lI1l(str), false);
    }

    private static void l111l11111lIl(String str, String str2) {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(l1111l111111Il, 0).edit();
        edit.putString(str, str2);
        edit.putLong(str + l111l11111Il, System.currentTimeMillis());
        edit.apply();
    }

    public final String l1111l111111Il(String str, boolean z) {
        l111l11111lIl l111l11111lIl2;
        if (TextUtils.isEmpty(str) || (l111l11111lIl2 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl()) == null || !l111l11111lIl2.l111l1111lI1l()) {
            return null;
        }
        if (!this.l111l1111llIl.get() && this.l111l1111llIl.compareAndSet(false, true)) {
            HashMap hashMap = new HashMap();
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            if (context != null) {
                HashSet<String> hashSet = new HashSet();
                for (Map.Entry<String, ?> entry : context.getSharedPreferences(l1111l111111Il, 0).getAll().entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (!key.equals(l111l11111lIl)) {
                        if (key.endsWith(l111l11111Il)) {
                            if ((value instanceof Long) && System.currentTimeMillis() - ((Long) value).longValue() > 604800000) {
                                hashSet.add(key.substring(0, key.indexOf(l111l11111Il)));
                            }
                        } else if (value instanceof String) {
                            hashMap.put(key, (String) value);
                        }
                    }
                }
                for (String str2 : hashSet) {
                    hashMap.remove(str2);
                }
            }
            this.l111l1111lI1l.putAll(hashMap);
            com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this.l111l1111lIl, 7);
        }
        if (l111l1111lIl.l111l1111lIl(str)) {
            return null;
        }
        if (z) {
            return l111l11111I1l(str);
        }
        String str3 = this.l111l1111lI1l.get(str);
        return TextUtils.isEmpty(str3) ? l111l11111I1l(str) : str3;
    }

    public final void l1111l111111Il(String str, String str2) {
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (l111l1111lIl.l111l1111lIl(str)) {
                        return;
                    }
                    this.l111l1111lI1l.put(str, str2);
                    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
                    if (context != null) {
                        SharedPreferences.Editor edit = context.getSharedPreferences(l1111l111111Il, 0).edit();
                        edit.putString(str, str2);
                        edit.putLong(str + l111l11111Il, System.currentTimeMillis());
                        edit.apply();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public final Map<String, String> l111l11111lIl() {
        return new HashMap(this.l111l1111lI1l);
    }
}
