package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.reflect.KDeclarationContainer;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/LocalVariableReference.class */
public class LocalVariableReference extends PropertyReference0 {
    @Override // kotlin.reflect.KProperty0
    public Object a() {
        LocalVariableReferencesKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        LocalVariableReferencesKt.b();
        throw new KotlinNothingValueException();
    }
}
