package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/FunctionReferenceImpl.class */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i, Class cls, String str, String str2, int i2) {
        super(i, NO_RECEIVER, cls, str, str2, i2);
    }

    public FunctionReferenceImpl(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(i, obj, cls, str, str2, i2);
    }

    public FunctionReferenceImpl(int i, KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(i, NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).a(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }
}