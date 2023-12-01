package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/PackageReference.class */
public final class PackageReference implements ClassBasedDeclarationContainer {
    private final Class<?> a;
    private final String b;

    public PackageReference(Class<?> jClass, String moduleName) {
        Intrinsics.e(jClass, "jClass");
        Intrinsics.e(moduleName, "moduleName");
        this.a = jClass;
        this.b = moduleName;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PackageReference) && Intrinsics.a(a(), ((PackageReference) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
