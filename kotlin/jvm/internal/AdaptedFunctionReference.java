package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/AdaptedFunctionReference.class */
public class AdaptedFunctionReference implements Serializable, FunctionBase {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f42513a;
    private final Class b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42514c;
    private final String d;
    private final boolean e;
    private final int f;
    private final int g;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdaptedFunctionReference) {
            AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
            return this.e == adaptedFunctionReference.e && this.f == adaptedFunctionReference.f && this.g == adaptedFunctionReference.g && Intrinsics.a(this.f42513a, adaptedFunctionReference.f42513a) && Intrinsics.a(this.b, adaptedFunctionReference.b) && this.f42514c.equals(adaptedFunctionReference.f42514c) && this.d.equals(adaptedFunctionReference.d);
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.f;
    }

    public int hashCode() {
        Object obj = this.f42513a;
        int i = 0;
        int hashCode = obj != null ? obj.hashCode() : 0;
        Class cls = this.b;
        if (cls != null) {
            i = cls.hashCode();
        }
        return (((((((((((hashCode * 31) + i) * 31) + this.f42514c.hashCode()) * 31) + this.d.hashCode()) * 31) + (this.e ? 1231 : 1237)) * 31) + this.f) * 31) + this.g;
    }

    public String toString() {
        return Reflection.a(this);
    }
}
