package com.opos.process.bridge.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/process/bridge/provider/ProcessBridgeProvider.class */
public class ProcessBridgeProvider extends ContentProvider {
    private static final String AUTHORITY_SUFFIX = "ProcessBridgeProvider";
    public static final int CODE_ACTION_EXCEPTION = 2;
    public static final int CODE_BRIDGE_EXCEPTION = 1;
    public static final int CODE_DISPATCH_FAIl = 3;
    public static final int CODE_METHOD_UNKNOWN = 4;
    public static final int CODE_OK = 0;
    public static final int CODE_RETURN_ERROR = 7;
    public static final int CODE_TARGET_INSTANCE_FAIL = 5;
    public static final String DISPATCH_METHOD = "dispatch";
    public static final String KEY_ARGS = "args";
    public static final String KEY_METHOD_ID = "methodId";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final String KEY_RESULT_DATA = "resultData";
    public static final String KEY_RESULT_EXCEPTION = "resultException";
    public static final String KEY_RESULT_MSG = "resultMsg";
    public static final String KEY_TARGET_CLASS = "targetClass";
    public static final String KEY_TARGET_IDENTIFY = "targetIdentify";

    public static Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(str);
            Object obj = loadClass.getField("FACTORY").get(null);
            if (!(obj instanceof d.a)) {
                return makeBundle(5, "could not find factory from target instance");
            }
            d aVar = ((d.a) obj).getInstance(context, iBridgeTargetIdentify);
            Method[] methods = loadClass.getMethods();
            int length = methods.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return makeBundle(4, "can not find method with method id:" + i);
                }
                Method method = methods[i3];
                BridgeMethod bridgeMethod = (BridgeMethod) method.getAnnotation(BridgeMethod.class);
                if (bridgeMethod != null && bridgeMethod.a() == i) {
                    return invoke(method, aVar, objArr);
                }
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            return makeBundle(1, e.getMessage());
        }
    }

    public static Uri getUri(Context context) {
        String str;
        if (context == null) {
            str = "";
        } else {
            str = "content://" + context.getPackageName() + "." + AUTHORITY_SUFFIX;
        }
        return Uri.parse(str);
    }

    private static Bundle invoke(Method method, Object obj, Object[] objArr) {
        String str;
        Bundle bundle = new Bundle();
        try {
            Object invoke = method.invoke(obj, objArr);
            Class<?> returnType = method.getReturnType();
            if (!returnType.equals(Void.TYPE)) {
                if (returnType.equals(Boolean.TYPE)) {
                    bundle.putBoolean(KEY_RESULT_DATA, ((Boolean) invoke).booleanValue());
                } else if (returnType.equals(CharSequence.class)) {
                    bundle.putChar(KEY_RESULT_DATA, ((Character) invoke).charValue());
                } else if (returnType.equals(Integer.TYPE)) {
                    bundle.putInt(KEY_RESULT_DATA, ((Integer) invoke).intValue());
                } else if (returnType.equals(Short.TYPE)) {
                    bundle.putShort(KEY_RESULT_DATA, ((Short) invoke).shortValue());
                } else if (returnType.equals(Long.TYPE)) {
                    bundle.putLong(KEY_RESULT_DATA, ((Long) invoke).longValue());
                } else if (returnType.equals(Float.TYPE)) {
                    bundle.putFloat(KEY_RESULT_DATA, ((Float) invoke).floatValue());
                } else if (returnType.equals(Double.TYPE)) {
                    bundle.putDouble(KEY_RESULT_DATA, ((Double) invoke).doubleValue());
                } else if (returnType.equals(Byte.TYPE)) {
                    bundle.putByte(KEY_RESULT_DATA, ((Byte) invoke).byteValue());
                } else if (returnType.equals(String.class)) {
                    bundle.putString(KEY_RESULT_DATA, (String) invoke);
                } else if (Parcelable.class.isAssignableFrom(returnType)) {
                    bundle.putParcelable(KEY_RESULT_DATA, (Parcelable) invoke);
                } else if (Serializable.class.isAssignableFrom(returnType)) {
                    bundle.putSerializable(KEY_RESULT_DATA, (Serializable) invoke);
                } else if (Array.class.isAssignableFrom(returnType)) {
                    if (!putArray(bundle, invoke, returnType)) {
                        str = "unsupported  Array component type:" + returnType.getComponentType();
                        return makeBundle(7, str);
                    }
                } else if (ArrayList.class.isAssignableFrom(returnType) && !putArrayList(bundle, invoke, returnType)) {
                    str = "unsupported  ArrayList component type:" + returnType.getComponentType();
                    return makeBundle(7, str);
                }
            }
            bundle.putInt(KEY_RESULT_CODE, 0);
            return bundle;
        } catch (Exception e) {
            return makeExceptionBundle(e);
        }
    }

    private static Bundle makeBundle(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RESULT_CODE, i);
        bundle.putString(KEY_RESULT_MSG, str);
        return bundle;
    }

    private static Bundle makeExceptionBundle(Exception exc) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RESULT_CODE, 2);
        bundle.putSerializable(KEY_RESULT_EXCEPTION, exc);
        return bundle;
    }

    private static boolean putArray(Bundle bundle, Object obj, Class cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType.equals(Boolean.TYPE)) {
            bundle.putBooleanArray(KEY_RESULT_DATA, (boolean[]) obj);
            return true;
        } else if (componentType.equals(CharSequence.class)) {
            bundle.putCharArray(KEY_RESULT_DATA, (char[]) obj);
            return true;
        } else if (componentType.equals(Integer.TYPE)) {
            bundle.putIntArray(KEY_RESULT_DATA, (int[]) obj);
            return true;
        } else if (componentType.equals(Short.TYPE)) {
            bundle.putShortArray(KEY_RESULT_DATA, (short[]) obj);
            return true;
        } else if (componentType.equals(Long.TYPE)) {
            bundle.putLongArray(KEY_RESULT_DATA, (long[]) obj);
            return true;
        } else if (componentType.equals(Float.TYPE)) {
            bundle.putFloatArray(KEY_RESULT_DATA, (float[]) obj);
            return true;
        } else if (componentType.equals(Double.TYPE)) {
            bundle.putDoubleArray(KEY_RESULT_DATA, (double[]) obj);
            return true;
        } else if (componentType.equals(Byte.TYPE)) {
            bundle.putByteArray(KEY_RESULT_DATA, (byte[]) obj);
            return true;
        } else if (componentType.equals(String.class)) {
            bundle.putStringArray(KEY_RESULT_DATA, (String[]) obj);
            return true;
        } else if (Parcelable.class.isAssignableFrom(componentType)) {
            bundle.putParcelableArray(KEY_RESULT_DATA, (Parcelable[]) obj);
            return true;
        } else {
            return false;
        }
    }

    private static boolean putArrayList(Bundle bundle, Object obj, Class<ArrayList> cls) {
        bundle.putSerializable(KEY_RESULT_DATA, (ArrayList) obj);
        return true;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if (DISPATCH_METHOD.equals(str)) {
            bundle.setClassLoader(ProcessBridgeProvider.class.getClassLoader());
            String string = bundle.getString(KEY_TARGET_CLASS);
            byte[] byteArray = bundle.getByteArray(KEY_TARGET_IDENTIFY);
            IBridgeTargetIdentify iBridgeTargetIdentify = null;
            if (byteArray != null) {
                iBridgeTargetIdentify = null;
                if (byteArray.length > 0) {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(byteArray, 0, byteArray.length);
                    obtain.setDataPosition(0);
                    iBridgeTargetIdentify = (IBridgeTargetIdentify) obtain.readParcelable(getClass().getClassLoader());
                    obtain.recycle();
                }
            }
            int i = bundle.getInt(KEY_METHOD_ID);
            byte[] byteArray2 = bundle.getByteArray(KEY_ARGS);
            Parcel obtain2 = Parcel.obtain();
            obtain2.unmarshall(byteArray2, 0, byteArray2.length);
            obtain2.setDataPosition(0);
            Object[] readArray = obtain2.readArray(getClass().getClassLoader());
            obtain2.recycle();
            return dispatch(getContext(), string, iBridgeTargetIdentify, i, readArray);
        }
        return makeBundle(3, "only support method [dispatch]");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
