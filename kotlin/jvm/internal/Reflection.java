package kotlin.jvm.internal;

import java.util.Collections;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Reflection.class */
public class Reflection {
    private static final ReflectionFactory a;
    private static final KClass[] b;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        a = reflectionFactory;
        b = new KClass[0];
    }

    public static String a(FunctionBase functionBase) {
        return a.a(functionBase);
    }

    public static String a(Lambda lambda) {
        return a.a(lambda);
    }

    public static KDeclarationContainer a(Class cls) {
        return a.a(cls, "");
    }

    public static KDeclarationContainer a(Class cls, String str) {
        return a.a(cls, str);
    }

    public static KFunction a(FunctionReference functionReference) {
        return a.a(functionReference);
    }

    public static KMutableProperty0 a(MutablePropertyReference0 mutablePropertyReference0) {
        return a.a(mutablePropertyReference0);
    }

    public static KMutableProperty1 a(MutablePropertyReference1 mutablePropertyReference1) {
        return a.a(mutablePropertyReference1);
    }

    public static KMutableProperty2 a(MutablePropertyReference2 mutablePropertyReference2) {
        return a.a(mutablePropertyReference2);
    }

    public static KProperty0 a(PropertyReference0 propertyReference0) {
        return a.a(propertyReference0);
    }

    public static KProperty1 a(PropertyReference1 propertyReference1) {
        return a.a(propertyReference1);
    }

    public static KProperty2 a(PropertyReference2 propertyReference2) {
        return a.a(propertyReference2);
    }

    public static KClass b(Class cls) {
        return a.a(cls);
    }

    public static KType c(Class cls) {
        return a.a(b(cls), Collections.emptyList(), true);
    }
}
