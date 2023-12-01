package androidx.core.location;

import android.location.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationKt.class */
public final class LocationKt {
    public static final double component1(Location location) {
        Intrinsics.e(location, "<this>");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        Intrinsics.e(location, "<this>");
        return location.getLongitude();
    }
}
