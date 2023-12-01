package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GLFrame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.Program;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/ResizeFilter.class */
public class ResizeFilter extends Filter {
    @GenerateFieldPort(hasDefault = true, name = "generateMipMap")
    private boolean mGenerateMipMap;
    private int mInputChannels;
    @GenerateFieldPort(hasDefault = true, name = "keepAspectRatio")
    private boolean mKeepAspectRatio;
    private FrameFormat mLastFormat;
    @GenerateFieldPort(name = "oheight")
    private int mOHeight;
    @GenerateFieldPort(name = "owidth")
    private int mOWidth;
    private MutableFrameFormat mOutputFormat;
    private Program mProgram;

    public ResizeFilter(String str) {
        super(str);
        this.mKeepAspectRatio = false;
        this.mGenerateMipMap = false;
        this.mLastFormat = null;
    }

    protected void createProgram(FilterContext filterContext, FrameFormat frameFormat) {
        if (this.mLastFormat == null || this.mLastFormat.getTarget() != frameFormat.getTarget()) {
            this.mLastFormat = frameFormat;
            switch (frameFormat.getTarget()) {
                case 2:
                    throw new RuntimeException("Native ResizeFilter not implemented yet!");
                case 3:
                    this.mProgram = ShaderProgram.createIdentity(filterContext);
                    return;
                default:
                    throw new RuntimeException("ResizeFilter could not create suitable program!");
            }
        }
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("image");
        createProgram(filterContext, pullInput.getFormat());
        MutableFrameFormat mutableCopy = pullInput.getFormat().mutableCopy();
        if (this.mKeepAspectRatio) {
            FrameFormat format = pullInput.getFormat();
            this.mOHeight = (this.mOWidth * format.getHeight()) / format.getWidth();
        }
        mutableCopy.setDimensions(this.mOWidth, this.mOHeight);
        Frame newFrame = filterContext.getFrameManager().newFrame(mutableCopy);
        if (this.mGenerateMipMap) {
            GLFrame gLFrame = (GLFrame) filterContext.getFrameManager().newFrame(pullInput.getFormat());
            gLFrame.setTextureParameter(10241, 9985);
            gLFrame.setDataFromFrame(pullInput);
            gLFrame.generateMipMap();
            this.mProgram.process(gLFrame, newFrame);
            gLFrame.release();
        } else {
            this.mProgram.process(pullInput, newFrame);
        }
        pushOutput("image", newFrame);
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3));
        addOutputBasedOnInput("image", "image");
    }
}
