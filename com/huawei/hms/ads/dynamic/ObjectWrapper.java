package com.huawei.hms.ads.dynamic;

import android.os.IBinder;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/ObjectWrapper.class */
public class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* renamed from: a  reason: collision with root package name */
    private final T f22458a;

    private ObjectWrapper(T t) {
        this.f22458a = t;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        int i;
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).f22458a;
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
            throw new IllegalArgumentException("Got " + declaredFields.length + " fields, The number of field number should be 1.");
        } else if (declaredFields[0].isAccessible()) {
            throw new IllegalArgumentException("The field is accessible.");
        } else {
            declaredFields[0].setAccessible(true);
            try {
                return (T) declaredFields[0].get(asBinder);
            } catch (Exception e) {
                throw new IllegalArgumentException("Get binder failed: null or not permitted.");
            }
        }
    }

    public static <T> IObjectWrapper wrap(T t) {
        return new ObjectWrapper(t);
    }
}
