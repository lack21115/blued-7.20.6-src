package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.NativeProgram;
import android.filterfw.core.Program;
import android.filterfw.format.ImageFormat;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/ToRGBFilter.class */
public class ToRGBFilter extends Filter {
    private int mInputBPP;
    private FrameFormat mLastFormat;
    private Program mProgram;

    public ToRGBFilter(String str) {
        super(str);
        this.mLastFormat = null;
    }

    public void createProgram(FilterContext filterContext, FrameFormat frameFormat) {
        this.mInputBPP = frameFormat.getBytesPerSample();
        if (this.mLastFormat == null || this.mLastFormat.getBytesPerSample() != this.mInputBPP) {
            this.mLastFormat = frameFormat;
            switch (this.mInputBPP) {
                case 1:
                    this.mProgram = new NativeProgram("filterpack_imageproc", "gray_to_rgb");
                    return;
                case 2:
                case 3:
                default:
                    throw new RuntimeException("Unsupported BytesPerPixel: " + this.mInputBPP + "!");
                case 4:
                    this.mProgram = new NativeProgram("filterpack_imageproc", "rgba_to_rgb");
                    return;
            }
        }
    }

    public FrameFormat getConvertedFormat(FrameFormat frameFormat) {
        MutableFrameFormat mutableCopy = frameFormat.mutableCopy();
        mutableCopy.setMetaValue(ImageFormat.COLORSPACE_KEY, 2);
        mutableCopy.setBytesPerSample(3);
        return mutableCopy;
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return getConvertedFormat(frameFormat);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("image");
        createProgram(filterContext, pullInput.getFormat());
        Frame newFrame = filterContext.getFrameManager().newFrame(getConvertedFormat(pullInput.getFormat()));
        this.mProgram.process(pullInput, newFrame);
        pushOutput("image", newFrame);
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        MutableFrameFormat mutableFrameFormat = new MutableFrameFormat(2, 2);
        mutableFrameFormat.setDimensionCount(2);
        addMaskedInputPort("image", mutableFrameFormat);
        addOutputBasedOnInput("image", "image");
    }
}
