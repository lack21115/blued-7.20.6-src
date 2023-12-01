package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.format.ImageFormat;
import android.graphics.Bitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/BitmapSource.class */
public class BitmapSource extends Filter {
    @GenerateFieldPort(name = "bitmap")
    private Bitmap mBitmap;
    private Frame mImageFrame;
    @GenerateFieldPort(hasDefault = true, name = "recycleBitmap")
    private boolean mRecycleBitmap;
    @GenerateFieldPort(hasDefault = true, name = "repeatFrame")
    boolean mRepeatFrame;
    private int mTarget;
    @GenerateFieldPort(name = TypedValues.AttributesType.S_TARGET)
    String mTargetString;

    public BitmapSource(String str) {
        super(str);
        this.mRecycleBitmap = true;
        this.mRepeatFrame = false;
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if ((str.equals("bitmap") || str.equals(TypedValues.AttributesType.S_TARGET)) && this.mImageFrame != null) {
            this.mImageFrame.release();
            this.mImageFrame = null;
        }
    }

    public void loadImage(FilterContext filterContext) {
        this.mTarget = FrameFormat.readTargetString(this.mTargetString);
        this.mImageFrame = filterContext.getFrameManager().newFrame(ImageFormat.create(this.mBitmap.getWidth(), this.mBitmap.getHeight(), 3, this.mTarget));
        this.mImageFrame.setBitmap(this.mBitmap);
        this.mImageFrame.setTimestamp(-1L);
        if (this.mRecycleBitmap) {
            this.mBitmap.recycle();
        }
        this.mBitmap = null;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        if (this.mImageFrame == null) {
            loadImage(filterContext);
        }
        pushOutput("image", this.mImageFrame);
        if (this.mRepeatFrame) {
            return;
        }
        closeOutputPort("image");
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addOutputPort("image", ImageFormat.create(3, 0));
    }

    @Override // android.filterfw.core.Filter
    public void tearDown(FilterContext filterContext) {
        if (this.mImageFrame != null) {
            this.mImageFrame.release();
            this.mImageFrame = null;
        }
    }
}
