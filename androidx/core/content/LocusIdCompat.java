package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.Preconditions;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/LocusIdCompat.class */
public final class LocusIdCompat {

    /* renamed from: a  reason: collision with root package name */
    private final String f2359a;
    private final LocusId b;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/LocusIdCompat$Api29Impl.class */
    static class Api29Impl {
        private Api29Impl() {
        }

        static LocusId a(String str) {
            return new LocusId(str);
        }

        static String a(LocusId locusId) {
            return locusId.getId();
        }
    }

    public LocusIdCompat(String str) {
        this.f2359a = (String) Preconditions.checkStringNotEmpty(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.b = Api29Impl.a(str);
        } else {
            this.b = null;
        }
    }

    private String a() {
        int length = this.f2359a.length();
        return length + "_chars";
    }

    public static LocusIdCompat toLocusIdCompat(LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.a(locusId), "id cannot be empty"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
            String str = this.f2359a;
            return str == null ? locusIdCompat.f2359a == null : str.equals(locusIdCompat.f2359a);
        }
        return false;
    }

    public String getId() {
        return this.f2359a;
    }

    public int hashCode() {
        String str = this.f2359a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public LocusId toLocusId() {
        return this.b;
    }

    public String toString() {
        return "LocusIdCompat[" + a() + "]";
    }
}
