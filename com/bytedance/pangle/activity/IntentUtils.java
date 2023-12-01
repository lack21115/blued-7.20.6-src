package com.bytedance.pangle.activity;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/activity/IntentUtils.class */
public class IntentUtils {

    /* renamed from: a  reason: collision with root package name */
    static HashMap<Long, WeakReference<Bundle>> f7748a = new HashMap<>();

    public static void a(Intent intent) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra != 0) {
            WeakReference<Bundle> remove = f7748a.remove(Long.valueOf(longExtra));
            Bundle bundle = remove != null ? remove.get() : null;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        }
    }

    public static void a(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        long j = longExtra;
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent) {
            j = longExtra;
            if (longExtra == 0) {
                j = System.currentTimeMillis();
            }
        }
        if (j != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            f7748a.put(Long.valueOf(j), new WeakReference<>(extras));
            intent.putExtra("pangle_use_memory", j);
        }
    }

    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }
}
