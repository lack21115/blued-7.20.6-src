package android.hardware.display;

import android.graphics.Rect;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayViewport.class */
public final class DisplayViewport {
    public int deviceHeight;
    public int deviceWidth;
    public int displayId;
    public int orientation;
    public boolean valid;
    public final Rect logicalFrame = new Rect();
    public final Rect physicalFrame = new Rect();

    public void copyFrom(DisplayViewport displayViewport) {
        this.valid = displayViewport.valid;
        this.displayId = displayViewport.displayId;
        this.orientation = displayViewport.orientation;
        this.logicalFrame.set(displayViewport.logicalFrame);
        this.physicalFrame.set(displayViewport.physicalFrame);
        this.deviceWidth = displayViewport.deviceWidth;
        this.deviceHeight = displayViewport.deviceHeight;
    }

    public String toString() {
        return "DisplayViewport{valid=" + this.valid + ", displayId=" + this.displayId + ", orientation=" + this.orientation + ", logicalFrame=" + this.logicalFrame + ", physicalFrame=" + this.physicalFrame + ", deviceWidth=" + this.deviceWidth + ", deviceHeight=" + this.deviceHeight + i.d;
    }
}
