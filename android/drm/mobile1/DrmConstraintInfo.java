package android.drm.mobile1;

import java.util.Date;

/* loaded from: source-9557208-dex2jar.jar:android/drm/mobile1/DrmConstraintInfo.class */
public class DrmConstraintInfo {
    private int count = -1;
    private long startDate = -1;
    private long endDate = -1;
    private long interval = -1;

    public int getCount() {
        return this.count;
    }

    public Date getEndDate() {
        if (this.endDate == -1) {
            return null;
        }
        return new Date(this.endDate);
    }

    public long getInterval() {
        return this.interval;
    }

    public Date getStartDate() {
        if (this.startDate == -1) {
            return null;
        }
        return new Date(this.startDate);
    }
}
