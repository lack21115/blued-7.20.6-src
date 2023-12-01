package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.Program;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.filterfw.geometry.Point;
import android.filterfw.geometry.Quad;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/RotateFilter.class */
public class RotateFilter extends Filter {
    @GenerateFieldPort(name = "angle")
    private int mAngle;
    private int mHeight;
    private int mOutputHeight;
    private int mOutputWidth;
    private Program mProgram;
    private int mTarget;
    @GenerateFieldPort(hasDefault = true, name = "tile_size")
    private int mTileSize;
    private int mWidth;

    public RotateFilter(String str) {
        super(str);
        this.mTileSize = 640;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mTarget = 0;
    }

    private void updateParameters() {
        float f;
        float f2;
        if (this.mAngle % 90 != 0) {
            throw new RuntimeException("degree has to be multiply of 90.");
        }
        if (this.mAngle % 180 == 0) {
            f2 = 0.0f;
            f = this.mAngle % 360 == 0 ? 1.0f : -1.0f;
        } else {
            f = 0.0f;
            f2 = (this.mAngle + 90) % 360 == 0 ? -1.0f : 1.0f;
            this.mOutputWidth = this.mHeight;
            this.mOutputHeight = this.mWidth;
        }
        ((ShaderProgram) this.mProgram).setTargetRegion(new Quad(new Point(((-f) + f2 + 1.0f) * 0.5f, (((-f2) - f) + 1.0f) * 0.5f), new Point((f + f2 + 1.0f) * 0.5f, ((f2 - f) + 1.0f) * 0.5f), new Point((((-f) - f2) + 1.0f) * 0.5f, ((-f2) + f + 1.0f) * 0.5f), new Point(((f - f2) + 1.0f) * 0.5f, (1.0f + f2 + f) * 0.5f)));
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mProgram != null) {
            updateParameters();
        }
    }

    public void initProgram(FilterContext filterContext, int i) {
        switch (i) {
            case 3:
                ShaderProgram createIdentity = ShaderProgram.createIdentity(filterContext);
                createIdentity.setMaximumTileSize(this.mTileSize);
                createIdentity.setClearsOutput(true);
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
        if (this.mProgram == null || format.getTarget() != this.mTarget) {
            initProgram(filterContext, format.getTarget());
        }
        if (format.getWidth() != this.mWidth || format.getHeight() != this.mHeight) {
            this.mWidth = format.getWidth();
            this.mHeight = format.getHeight();
            this.mOutputWidth = this.mWidth;
            this.mOutputHeight = this.mHeight;
            updateParameters();
        }
        Frame newFrame = filterContext.getFrameManager().newFrame(ImageFormat.create(this.mOutputWidth, this.mOutputHeight, 3, 3));
        this.mProgram.process(pullInput, newFrame);
        pushOutput("image", newFrame);
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3));
        addOutputBasedOnInput("image", "image");
    }
}
