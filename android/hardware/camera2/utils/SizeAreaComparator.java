package android.hardware.camera2.utils;

import android.util.Size;
import com.android.internal.util.Preconditions;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/SizeAreaComparator.class */
public class SizeAreaComparator implements Comparator<Size> {
    public static Size findLargestByArea(List<Size> list) {
        Preconditions.checkNotNull(list, "sizes must not be null");
        return (Size) Collections.max(list, new SizeAreaComparator());
    }

    @Override // java.util.Comparator
    public int compare(Size size, Size size2) {
        int i = 1;
        Preconditions.checkNotNull(size, "size must not be null");
        Preconditions.checkNotNull(size2, "size2 must not be null");
        if (size.equals(size2)) {
            i = 0;
        } else {
            long width = size.getWidth();
            long width2 = size2.getWidth();
            long height = width * size.getHeight();
            long height2 = width2 * size2.getHeight();
            if (height == height2) {
                if (width <= width2) {
                    return -1;
                }
            } else if (height <= height2) {
                return -1;
            }
        }
        return i;
    }
}
