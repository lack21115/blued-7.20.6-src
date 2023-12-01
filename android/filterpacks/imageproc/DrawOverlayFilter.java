package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.filterfw.format.ObjectFormat;
import android.filterfw.geometry.Quad;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/DrawOverlayFilter.class */
public class DrawOverlayFilter extends Filter {
    private ShaderProgram mProgram;

    public DrawOverlayFilter(String str) {
        super(str);
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    @Override // android.filterfw.core.Filter
    public void prepare(FilterContext filterContext) {
        this.mProgram = ShaderProgram.createIdentity(filterContext);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("source");
        Frame pullInput2 = pullInput("overlay");
        this.mProgram.setTargetRegion(((Quad) pullInput("box").getObjectValue()).translated(1.0f, 1.0f).scaled(2.0f));
        Frame newFrame = filterContext.getFrameManager().newFrame(pullInput.getFormat());
        newFrame.setDataFromFrame(pullInput);
        this.mProgram.process(pullInput2, newFrame);
        pushOutput("image", newFrame);
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        MutableFrameFormat create = ImageFormat.create(3, 3);
        addMaskedInputPort("source", create);
        addMaskedInputPort("overlay", create);
        addMaskedInputPort("box", ObjectFormat.fromClass(Quad.class, 1));
        addOutputBasedOnInput("image", "source");
    }
}
