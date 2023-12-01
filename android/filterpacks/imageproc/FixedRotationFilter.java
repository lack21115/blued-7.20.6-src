package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.filterfw.geometry.Point;
import android.filterfw.geometry.Quad;
import androidx.constraintlayout.motion.widget.Key;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/FixedRotationFilter.class */
public class FixedRotationFilter extends Filter {
    private ShaderProgram mProgram;
    @GenerateFieldPort(hasDefault = true, name = Key.ROTATION)
    private int mRotation;

    public FixedRotationFilter(String str) {
        super(str);
        this.mRotation = 0;
        this.mProgram = null;
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Quad quad;
        Frame pullInput = pullInput("image");
        if (this.mRotation == 0) {
            pushOutput("image", pullInput);
            return;
        }
        FrameFormat format = pullInput.getFormat();
        if (this.mProgram == null) {
            this.mProgram = ShaderProgram.createIdentity(filterContext);
        }
        MutableFrameFormat mutableCopy = format.mutableCopy();
        int width = format.getWidth();
        int height = format.getHeight();
        Point point = new Point(0.0f, 0.0f);
        Point point2 = new Point(1.0f, 0.0f);
        Point point3 = new Point(0.0f, 1.0f);
        Point point4 = new Point(1.0f, 1.0f);
        switch (Math.round(this.mRotation / 90.0f) % 4) {
            case 1:
                quad = new Quad(point3, point, point4, point2);
                mutableCopy.setDimensions(height, width);
                break;
            case 2:
                quad = new Quad(point4, point3, point2, point);
                break;
            case 3:
                quad = new Quad(point2, point4, point, point3);
                mutableCopy.setDimensions(height, width);
                break;
            default:
                quad = new Quad(point, point2, point3, point4);
                break;
        }
        Frame newFrame = filterContext.getFrameManager().newFrame(mutableCopy);
        this.mProgram.setSourceRegion(quad);
        this.mProgram.process(pullInput, newFrame);
        pushOutput("image", newFrame);
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3, 3));
        addOutputBasedOnInput("image", "image");
    }
}
