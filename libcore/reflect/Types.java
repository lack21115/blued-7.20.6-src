package libcore.reflect;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.ads.ContentClassification;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/Types.class */
public final class Types {
    private static final Map<Class<?>, String> PRIMITIVE_TO_SIGNATURE = new HashMap(9);

    static {
        PRIMITIVE_TO_SIGNATURE.put(Byte.TYPE, "B");
        PRIMITIVE_TO_SIGNATURE.put(Character.TYPE, "C");
        PRIMITIVE_TO_SIGNATURE.put(Short.TYPE, ExifInterface.LATITUDE_SOUTH);
        PRIMITIVE_TO_SIGNATURE.put(Integer.TYPE, "I");
        PRIMITIVE_TO_SIGNATURE.put(Long.TYPE, ContentClassification.AD_CONTENT_CLASSIFICATION_J);
        PRIMITIVE_TO_SIGNATURE.put(Float.TYPE, "F");
        PRIMITIVE_TO_SIGNATURE.put(Double.TYPE, "D");
        PRIMITIVE_TO_SIGNATURE.put(Void.TYPE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        PRIMITIVE_TO_SIGNATURE.put(Boolean.TYPE, "Z");
    }

    private Types() {
    }

    public static void appendArrayGenericType(StringBuilder sb, Type[] typeArr) {
        if (typeArr.length == 0) {
            return;
        }
        appendGenericType(sb, typeArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= typeArr.length) {
                return;
            }
            sb.append(',');
            appendGenericType(sb, typeArr[i2]);
            i = i2 + 1;
        }
    }

    public static void appendGenericType(StringBuilder sb, Type type) {
        if (type instanceof TypeVariable) {
            sb.append(((TypeVariable) type).getName());
        } else if (type instanceof ParameterizedType) {
            sb.append(type.toString());
        } else if (type instanceof GenericArrayType) {
            appendGenericType(sb, ((GenericArrayType) type).getGenericComponentType());
            sb.append("[]");
        } else if (!(type instanceof Class)) {
        } else {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                sb.append(cls.getName());
                return;
            }
            String[] split = cls.getName().split("\\[");
            int length = split.length - 1;
            if (split[length].length() > 1) {
                sb.append(split[length].substring(1, split[length].length() - 1));
            } else {
                char charAt = split[length].charAt(0);
                if (charAt == 'I') {
                    sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                } else if (charAt == 'B') {
                    sb.append("byte");
                } else if (charAt == 'J') {
                    sb.append("long");
                } else if (charAt == 'F') {
                    sb.append(TypedValues.Custom.S_FLOAT);
                } else if (charAt == 'D') {
                    sb.append("double");
                } else if (charAt == 'S') {
                    sb.append(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT);
                } else if (charAt == 'C') {
                    sb.append("char");
                } else if (charAt == 'Z') {
                    sb.append(TypedValues.Custom.S_BOOLEAN);
                } else if (charAt == 'V') {
                    sb.append("void");
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                sb.append("[]");
                i = i2 + 1;
            }
        }
    }

    public static void appendTypeName(StringBuilder sb, Class<?> cls) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (!cls.isArray()) {
                break;
            }
            cls = cls.getComponentType();
            i2 = i + 1;
        }
        sb.append(cls.getName());
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return;
            }
            sb.append("[]");
            i3 = i4 + 1;
        }
    }

    public static String getSignature(Class<?> cls) {
        String str = PRIMITIVE_TO_SIGNATURE.get(cls);
        return str != null ? str : cls.isArray() ? "[" + getSignature(cls.getComponentType()) : "L" + cls.getName() + ";";
    }

    public static Type getType(Type type) {
        Type type2 = type;
        if (type instanceof ParameterizedTypeImpl) {
            type2 = ((ParameterizedTypeImpl) type).getResolvedType();
        }
        return type2;
    }

    public static Type[] getTypeArray(ListOfTypes listOfTypes, boolean z) {
        if (listOfTypes.length() == 0) {
            return EmptyArray.TYPE;
        }
        Type[] resolvedTypes = listOfTypes.getResolvedTypes();
        return z ? (Type[]) resolvedTypes.clone() : resolvedTypes;
    }

    public static String toString(Class<?>[] clsArr) {
        if (clsArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        appendTypeName(sb, clsArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= clsArr.length) {
                return sb.toString();
            }
            sb.append(',');
            appendTypeName(sb, clsArr[i2]);
            i = i2 + 1;
        }
    }
}
