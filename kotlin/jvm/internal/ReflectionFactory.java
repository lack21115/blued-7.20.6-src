package kotlin.jvm.internal;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ReflectionFactory.class */
public class ReflectionFactory {
    public String a(FunctionBase functionBase) {
        String obj = functionBase.getClass().getGenericInterfaces()[0].toString();
        String str = obj;
        if (obj.startsWith("kotlin.jvm.functions.")) {
            str = obj.substring(21);
        }
        return str;
    }

    public String a(Lambda lambda) {
        return a((FunctionBase) lambda);
    }

    public KClass a(Class cls) {
        return new ClassReference(cls);
    }

    public KDeclarationContainer a(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    public KFunction a(FunctionReference functionReference) {
        return functionReference;
    }

    public KMutableProperty0 a(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public KMutableProperty1 a(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public KMutableProperty2 a(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public KProperty0 a(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public KProperty1 a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public KProperty2 a(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public KType a(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        return new TypeReference(kClassifier, list, z);
    }
}
