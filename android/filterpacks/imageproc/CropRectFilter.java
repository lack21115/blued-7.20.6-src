package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.Program;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/CropRectFilter.class */
public class CropRectFilter extends Filter {
    private int mHeight;
    @GenerateFieldPort(name = "height")
    private int mOutputHeight;
    @GenerateFieldPort(name = "width")
    private int mOutputWidth;
    private Program mProgram;
    private int mTarget;
    @GenerateFieldPort(hasDefault = true, name = "tile_size")
    private int mTileSize;
    private int mWidth;
    @GenerateFieldPort(name = "xorigin")
    private int mXorigin;
    @GenerateFieldPort(name = "yorigin")
    private int mYorigin;

    public CropRectFilter(String str) {
        super(str);
        this.mTileSize = 640;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mTarget = 0;
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mProgram != null) {
            updateSourceRect(this.mWidth, this.mHeight);
        }
    }

    public void initProgram(FilterContext filterContext, int i) {
        switch (i) {
            case 3:
                ShaderProgram createIdentity = ShaderProgram.createIdentity(filterContext);
                createIdentity.setMaximumTileSize(this.mTileSize);
                this.mProgram = createIdentity;
                this.mTarget = i;
                return;
            default:
                throw new RuntimeException("Filter Sharpen does not support frames of target " + i + "!");
        }
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("image");
        FrameFormat format = pullInput.getFormat();
        Frame newFrame = filterContext.getFrameManager().newFrame(ImageFormat.create(this.mOutputWidth, this.mOutputHeight, 3, 3));
        if (this.mProgram == null || format.getTarget() != this.mTarget) {
            initProgram(filterContext, format.getTarget());
        }
        if (format.getWidth() != this.mWidth || format.getHeight() != this.mHeight) {
            updateSourceRect(format.getWidth(), format.getHeight());
        }
        this.mProgram.process(pullInput, newFrame);
        pushOutput("image", newFrame);
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3));
        addOutputBasedOnInput("image", "image");
    }

    void updateSourceRect(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        ((ShaderProgram) this.mProgram).setSourceRect(this.mXorigin / this.mWidth, this.mYorigin / this.mHeight, this.mOutputWidth / this.mWidth, this.mOutputHeight / this.mHeight);
    }
}
