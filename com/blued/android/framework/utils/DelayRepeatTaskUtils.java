package com.blued.android.framework.utils;

import java.util.WeakHashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/DelayRepeatTaskUtils.class */
public class DelayRepeatTaskUtils {
    private static WeakHashMap<String, Runnable> a = new WeakHashMap<>();

    public static void a(String str, Runnable runnable) {
        a(str, runnable, 200);
    }

    public static void a(final String str, final Runnable runnable, final int i) {
        ThreadUtils.a(new Runnable() { // from class: com.blued.android.framework.utils.-$$Lambda$DelayRepeatTaskUtils$0V4j3aJtDpZv5t14Stf_15-izAQ
            @Override // java.lang.Runnable
            public final void run() {
                DelayRepeatTaskUtils.b(String.this, runnable, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, Runnable runnable, int i) {
        Runnable remove = a.remove(str);
        if (remove != null) {
            ThreadUtils.c(remove);
        }
        a.put(str, runnable);
        ThreadUtils.a(runnable, i);
    }
}
