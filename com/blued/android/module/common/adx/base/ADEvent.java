package com.blued.android.module.common.adx.base;

import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/ADEvent.class */
public class ADEvent {
    private int a;
    private Object[] b;

    public ADEvent(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
    }

    public <T> T a(int i, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.b) == null || objArr.length <= i) {
            return null;
        }
        T t = (T) objArr[i];
        if (t == null) {
            Log.v("adx", "ADEvent 参数为空,type:" + this.a);
            return null;
        } else if (cls.isInstance(objArr[i])) {
            return t;
        } else {
            Log.v("adx", "ADEvent" + this.a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t.getClass().getName());
            return null;
        }
    }

    public <T> T a(Class<T> cls) {
        return (T) a(0, cls);
    }

    public int getType() {
        return this.a;
    }
}
