package com.blued.android.core.utils;

import android.view.View;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/AsyncViewChecker.class */
public class AsyncViewChecker<T> {
    private final Map<Integer, T> a = Collections.synchronizedMap(new HashMap());

    public void a(View view) {
        if (view != null) {
            this.a.remove(Integer.valueOf(view.hashCode()));
        }
    }

    public void a(View view, T t) {
        if (view != null) {
            this.a.put(Integer.valueOf(view.hashCode()), t);
        }
    }

    public boolean b(View view, T t) {
        T t2;
        if (view == null || (t2 = this.a.get(Integer.valueOf(view.hashCode()))) == null) {
            return false;
        }
        return t2.equals(t);
    }
}
