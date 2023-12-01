package kotlin.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/JvmClassMappingKt.class */
public final class JvmClassMappingKt {
    public static final <T> Class<T> a(KClass<T> kClass) {
        Intrinsics.e(kClass, "<this>");
        return (Class<T>) ((ClassBasedDeclarationContainer) kClass).a();
    }

    public static final <T> KClass<T> a(Class<T> cls) {
        Intrinsics.e(cls, "<this>");
        return Reflection.b(cls);
    }

    public static final <T> Class<T> b(KClass<T> kClass) {
        Intrinsics.e(kClass, "<this>");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).a();
        if (cls.isPrimitive()) {
            String name = cls.getName();
            Class<T> cls2 = cls;
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            cls2 = Double.class;
                            break;
                        } else {
                            return cls;
                        }
                    case 104431:
                        return !name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL) ? cls : Integer.class;
                    case 3039496:
                        return !name.equals("byte") ? cls : Byte.class;
                    case 3052374:
                        return !name.equals("char") ? cls : Character.class;
                    case 3327612:
                        return !name.equals("long") ? cls : Long.class;
                    case 3625364:
                        return !name.equals("void") ? cls : Void.class;
                    case 64711720:
                        return !name.equals(TypedValues.Custom.S_BOOLEAN) ? cls : Boolean.class;
                    case 97526364:
                        return !name.equals(TypedValues.Custom.S_FLOAT) ? cls : Float.class;
                    case 109413500:
                        return !name.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT) ? cls : Short.class;
                    default:
                        return cls;
                }
            }
            return cls2;
        }
        return cls;
    }
}
