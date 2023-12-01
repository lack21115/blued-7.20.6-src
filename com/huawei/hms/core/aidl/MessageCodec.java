package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/core/aidl/MessageCodec.class */
public class MessageCodec {
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_NULL = -1;
    protected static final String VAL_TYPE = "_val_type_";

    private Bundle a(String str, Bundle bundle, Object obj) {
        Bundle bundle2 = new Bundle();
        writeValue(str, obj, bundle2);
        bundle.putBundle("_next_item_", bundle2);
        return bundle2;
    }

    private Object a(Field field, Bundle bundle) {
        String name = field.getName();
        Object obj = bundle.get(name);
        if (obj instanceof Bundle) {
            try {
                Bundle bundle2 = (Bundle) obj;
                int i = bundle2.getInt(VAL_TYPE, -1);
                if (i == 1) {
                    return readList(field.getGenericType(), bundle2);
                }
                if (i == 0) {
                    return decode((Bundle) obj, (IMessageEntity) field.getType().newInstance());
                }
            } catch (Exception e) {
                Log.e("MessageCodec", "decode, read value of the field exception, field name: " + name);
                return null;
            }
        }
        return obj;
    }

    private void a(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        Object a2 = a(field, bundle);
        if (a2 != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, a2);
            field.setAccessible(isAccessible);
        }
    }

    private boolean a(String str, Object obj, Bundle bundle) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else {
            return false;
        }
    }

    private void b(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        writeValue(field.getName(), field.get(iMessageEntity), bundle);
        field.setAccessible(isAccessible);
    }

    public IMessageEntity decode(Bundle bundle, IMessageEntity iMessageEntity) {
        if (bundle == null) {
            return iMessageEntity;
        }
        bundle.setClassLoader(getClass().getClassLoader());
        Class<?> cls = iMessageEntity.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                return iMessageEntity;
            }
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    Field field = declaredFields[i2];
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            a(iMessageEntity, field, bundle);
                        } catch (IllegalAccessException | IllegalArgumentException e) {
                            Log.e("MessageCodec", "decode, set value of the field exception, field name:" + field.getName());
                        }
                    }
                    i = i2 + 1;
                }
            }
            cls = cls2.getSuperclass();
        }
    }

    public Bundle encode(IMessageEntity iMessageEntity, Bundle bundle) {
        Class<?> cls = iMessageEntity.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                return bundle;
            }
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    Field field = declaredFields[i2];
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            b(iMessageEntity, field, bundle);
                        } catch (IllegalAccessException | IllegalArgumentException e) {
                            Log.e("MessageCodec", "encode, get value of the field exception, field name: " + field.getName());
                        }
                    }
                    i = i2 + 1;
                }
            }
            cls = cls2.getSuperclass();
        }
    }

    protected List<Object> readList(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = bundle.getBundle("_next_item_");
        while (true) {
            Bundle bundle3 = bundle2;
            if (bundle3 == null) {
                return arrayList;
            }
            Object obj = bundle3.get("_value_");
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                arrayList.add(obj);
            } else if (obj instanceof Bundle) {
                Bundle bundle4 = (Bundle) obj;
                int i = bundle4.getInt(VAL_TYPE, -1);
                if (i == 1) {
                    throw new InstantiationException("Nested List can not be supported");
                }
                if (i != 0) {
                    throw new InstantiationException("Unknown type can not be supported");
                }
                arrayList.add(decode(bundle4, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else {
                continue;
            }
            bundle2 = bundle3.getBundle("_next_item_");
        }
    }

    protected void writeList(String str, List list, Bundle bundle) {
        Iterator it = list.iterator();
        Bundle bundle2 = null;
        while (true) {
            Bundle bundle3 = bundle2;
            if (!it.hasNext()) {
                return;
            }
            Object next = it.next();
            Bundle bundle4 = bundle3;
            if (bundle3 == null) {
                bundle4 = new Bundle();
                bundle.putBundle(str, bundle4);
                bundle4.putInt(VAL_TYPE, 1);
            }
            bundle2 = a("_value_", bundle4, next);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeValue(String str, Object obj, Bundle bundle) {
        if (obj == null || a(str, obj, bundle)) {
            return;
        }
        if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof List) {
            writeList(str, (List) obj, bundle);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj instanceof IMessageEntity) {
            Bundle encode = encode((IMessageEntity) obj, new Bundle());
            encode.putInt(VAL_TYPE, 0);
            bundle.putBundle(str, encode);
        } else {
            Log.e("MessageCodec", "cannot support type, " + str);
        }
    }
}
