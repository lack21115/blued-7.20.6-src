package android.hardware.camera2.legacy;

import android.hardware.Camera;
import com.android.internal.util.Preconditions;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/SizeAreaComparator.class */
public class SizeAreaComparator implements Comparator<Camera.Size> {
    public static Camera.Size findLargestByArea(List<Camera.Size> list) {
        Preconditions.checkNotNull(list, "sizes must not be null");
        return (Camera.Size) Collections.max(list, new SizeAreaComparator());
    }

    @Override // java.util.Comparator
    public int compare(Camera.Size size, Camera.Size size2) {
        int i = 1;
        Preconditions.checkNotNull(size, "size must not be null");
        Preconditions.checkNotNull(size2, "size2 must not be null");
        if (size.equals(size2)) {
            i = 0;
        } else {
            long j = size.width;
            long j2 = size2.width;
            long j3 = j * size.height;
            long j4 = j2 * size2.height;
            if (j3 == j4) {
                if (j <= j2) {
                    return -1;
                }
            } else if (j3 <= j4) {
                return -1;
            }
        }
        return i;
    }
}
