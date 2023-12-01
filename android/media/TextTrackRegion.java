package android.media;

import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/media/TextTrackRegion.class */
class TextTrackRegion {
    static final int SCROLL_VALUE_NONE = 300;
    static final int SCROLL_VALUE_SCROLL_UP = 301;
    String mId = "";
    float mWidth = 100.0f;
    int mLines = 3;
    float mViewportAnchorPointX = 0.0f;
    float mAnchorPointX = 0.0f;
    float mViewportAnchorPointY = 100.0f;
    float mAnchorPointY = 100.0f;
    int mScrollValue = 300;

    public String toString() {
        return " {id:\"" + this.mId + "\", width:" + this.mWidth + ", lines:" + this.mLines + ", anchorPoint:(" + this.mAnchorPointX + ", " + this.mAnchorPointY + "), viewportAnchorPoints:" + this.mViewportAnchorPointX + ", " + this.mViewportAnchorPointY + "), scrollValue:" + (this.mScrollValue == 300 ? "none" : this.mScrollValue == 301 ? "scroll_up" : "INVALID") + i.d;
    }
}
