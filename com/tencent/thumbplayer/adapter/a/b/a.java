package com.tencent.thumbplayer.adapter.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.o;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Set<String> f39165a = new HashSet();
    private static Set<String> b = new HashSet();

    public static void a(Context context) {
        synchronized (a.class) {
            try {
                TPLogUtil.i("TPDrmCapability", "TPDrmCapability, init");
                TPLogUtil.i("TPDrmCapability", "TPDrmCapability, get shared preferences.");
                SharedPreferences sharedPreferences = context.getSharedPreferences("TP_DRM_CAPABILITY", 0);
                try {
                    f39165a = sharedPreferences.getStringSet("DRM_CAPABILITY_LIST", f39165a);
                } catch (ClassCastException e) {
                    TPLogUtil.e("TPDrmCapability", e);
                }
                f39165a.removeAll(b);
                a(sharedPreferences);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void a(final SharedPreferences sharedPreferences) {
        o.a().d().execute(new Runnable() { // from class: com.tencent.thumbplayer.adapter.a.b.a.1
            @Override // java.lang.Runnable
            public final void run() {
                int[] iArr = new int[0];
                try {
                    iArr = TPThumbplayerCapabilityHelper.getDRMCapabilities();
                } catch (TPNativeLibraryException e) {
                    TPLogUtil.e("TPDrmCapability", e);
                }
                TPLogUtil.i("TPDrmCapability", "TPThumbPlayerCapabilityHelper, DRM capability:" + Arrays.toString(iArr));
                if (iArr.length == 0) {
                    return;
                }
                HashSet hashSet = new HashSet();
                for (int i : iArr) {
                    hashSet.add(String.valueOf(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDrmType.class, i)));
                }
                SharedPreferences.Editor edit = SharedPreferences.this.edit();
                edit.putStringSet("DRM_CAPABILITY_LIST", hashSet);
                edit.apply();
                synchronized (a.class) {
                    try {
                        Set unused = a.f39165a = hashSet;
                        a.f39165a.removeAll(a.b);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    public static boolean a(@TPCommonEnum.TP_DRM_TYPE int i) {
        synchronized (a.class) {
            if (i == -1) {
                return false;
            }
            try {
                Iterator<String> it = f39165a.iterator();
                do {
                    if (!it.hasNext()) {
                        return false;
                    }
                } while (com.tencent.thumbplayer.utils.b.a(it.next(), -1) != i);
                return true;
            } finally {
            }
        }
    }

    public static int[] a() {
        int[] iArr;
        synchronized (a.class) {
            try {
                iArr = new int[f39165a.size()];
                int i = 0;
                for (String str : f39165a) {
                    iArr[i] = com.tencent.thumbplayer.utils.b.a(str, -1);
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iArr;
    }

    public static void b(@TPCommonEnum.TP_DRM_TYPE int i) {
        synchronized (a.class) {
            if (i == -1) {
                return;
            }
            try {
                b.add(String.valueOf(i));
                f39165a.removeAll(b);
            } finally {
            }
        }
    }
}
