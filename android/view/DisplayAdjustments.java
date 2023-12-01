package android.view;

import android.content.res.CompatibilityInfo;
import android.os.IBinder;
import com.blued.das.live.LiveProtos;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/view/DisplayAdjustments.class */
public class DisplayAdjustments {
    public static final DisplayAdjustments DEFAULT_DISPLAY_ADJUSTMENTS = new DisplayAdjustments();
    public static final boolean DEVELOPMENT_RESOURCES_DEPEND_ON_ACTIVITY_TOKEN = false;
    private volatile IBinder mActivityToken;
    private volatile CompatibilityInfo mCompatInfo;

    public DisplayAdjustments() {
        this.mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    public DisplayAdjustments(CompatibilityInfo compatibilityInfo, IBinder iBinder) {
        this.mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        setCompatibilityInfo(compatibilityInfo);
        this.mActivityToken = iBinder;
    }

    public DisplayAdjustments(IBinder iBinder) {
        this.mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        this.mActivityToken = iBinder;
    }

    public DisplayAdjustments(DisplayAdjustments displayAdjustments) {
        this(displayAdjustments.getCompatibilityInfo(), displayAdjustments.getActivityToken());
    }

    public boolean equals(Object obj) {
        if (obj instanceof DisplayAdjustments) {
            DisplayAdjustments displayAdjustments = (DisplayAdjustments) obj;
            return Objects.equals(displayAdjustments.mCompatInfo, this.mCompatInfo) && Objects.equals(displayAdjustments.mActivityToken, this.mActivityToken);
        }
        return false;
    }

    public IBinder getActivityToken() {
        return this.mActivityToken;
    }

    public CompatibilityInfo getCompatibilityInfo() {
        return this.mCompatInfo;
    }

    public int hashCode() {
        return this.mCompatInfo.hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
    }

    public void setActivityToken(IBinder iBinder) {
        if (this == DEFAULT_DISPLAY_ADJUSTMENTS) {
            throw new IllegalArgumentException("setActivityToken: Cannot modify DEFAULT_DISPLAY_ADJUSTMENTS");
        }
        this.mActivityToken = iBinder;
    }

    public void setCompatibilityInfo(CompatibilityInfo compatibilityInfo) {
        if (this == DEFAULT_DISPLAY_ADJUSTMENTS) {
            throw new IllegalArgumentException("setCompatbilityInfo: Cannot modify DEFAULT_DISPLAY_ADJUSTMENTS");
        }
        if (compatibilityInfo == null || (!compatibilityInfo.isScalingRequired() && compatibilityInfo.supportsScreen())) {
            this.mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        } else {
            this.mCompatInfo = compatibilityInfo;
        }
    }
}
