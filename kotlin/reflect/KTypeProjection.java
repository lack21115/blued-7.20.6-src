package kotlin.reflect;

import com.android.internal.telephony.PhoneConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KTypeProjection.class */
public final class KTypeProjection {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42599a = new Companion(null);
    public static final KTypeProjection b = new KTypeProjection(null, null);

    /* renamed from: c  reason: collision with root package name */
    private final KVariance f42600c;
    private final KType d;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KTypeProjection$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KTypeProjection$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42601a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f42601a = iArr;
        }
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        String str;
        this.f42600c = kVariance;
        this.d = kType;
        if ((kVariance == null) == (this.d == null)) {
            return;
        }
        if (this.f42600c == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + this.f42600c + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final KVariance a() {
        return this.f42600c;
    }

    public final KVariance b() {
        return this.f42600c;
    }

    public final KType c() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KTypeProjection) {
            KTypeProjection kTypeProjection = (KTypeProjection) obj;
            return this.f42600c == kTypeProjection.f42600c && Intrinsics.a(this.d, kTypeProjection.d);
        }
        return false;
    }

    public final KType getType() {
        return this.d;
    }

    public int hashCode() {
        KVariance kVariance = this.f42600c;
        int i = 0;
        int hashCode = kVariance == null ? 0 : kVariance.hashCode();
        KType kType = this.d;
        if (kType != null) {
            i = kType.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public String toString() {
        KVariance kVariance = this.f42600c;
        int i = kVariance == null ? -1 : WhenMappings.f42601a[kVariance.ordinal()];
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    return "in " + this.d;
                } else if (i == 3) {
                    return "out " + this.d;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return String.valueOf(this.d);
        }
        return PhoneConstants.APN_TYPE_ALL;
    }
}
