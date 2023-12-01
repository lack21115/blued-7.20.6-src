package com.huawei.hms.ads.uiengineloader;

import android.os.IBinder;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/ac.class */
public final class ac<T> extends IObjectWrapper.Stub {

    /* renamed from: a  reason: collision with root package name */
    private final T f8932a;

    private ac(T t) {
        this.f8932a = t;
    }

    public static <T> IObjectWrapper a(T t) {
        return new ac(t);
    }

    public static <T> T a(IObjectWrapper iObjectWrapper) {
        int i;
        if (iObjectWrapper instanceof ac) {
            return ((ac) iObjectWrapper).f8932a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= length) {
                break;
            }
            int i4 = i;
            if (!declaredFields[i2].isSynthetic()) {
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        } else if (declaredFields[0].isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            declaredFields[0].setAccessible(true);
            try {
                return (T) declaredFields[0].get(asBinder);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.");
            } catch (NullPointerException e2) {
                throw new IllegalArgumentException("Binder object is null.");
            }
        }
    }
}
