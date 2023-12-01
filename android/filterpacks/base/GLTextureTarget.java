package android.filterpacks.base;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.format.ImageFormat;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/base/GLTextureTarget.class */
public class GLTextureTarget extends Filter {
    @GenerateFieldPort(name = "texId")
    private int mTexId;

    public GLTextureTarget(String str) {
        super(str);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput(TypedValues.AttributesType.S_FRAME);
        Frame newBoundFrame = filterContext.getFrameManager().newBoundFrame(ImageFormat.create(pullInput.getFormat().getWidth(), pullInput.getFormat().getHeight(), 3, 3), 100, this.mTexId);
        newBoundFrame.setDataFromFrame(pullInput);
        newBoundFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort(TypedValues.AttributesType.S_FRAME, ImageFormat.create(3));
    }
}
