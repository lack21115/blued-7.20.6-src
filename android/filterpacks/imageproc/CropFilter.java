package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.Program;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.filterfw.format.ObjectFormat;
import android.filterfw.geometry.Quad;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/CropFilter.class */
public class CropFilter extends Filter {
    @GenerateFieldPort(name = "fillblack")
    private boolean mFillBlack;
    private final String mFragShader;
    private FrameFormat mLastFormat;
    @GenerateFieldPort(name = "oheight")
    private int mOutputHeight;
    @GenerateFieldPort(name = "owidth")
    private int mOutputWidth;
    private Program mProgram;

    public CropFilter(String str) {
        super(str);
        this.mLastFormat = null;
        this.mOutputWidth = -1;
        this.mOutputHeight = -1;
        this.mFillBlack = false;
        this.mFragShader = "precision mediump float;\nuniform sampler2D tex_sampler_0;\nvarying vec2 v_texcoord;\nvoid main() {\n  const vec2 lo = vec2(0.0, 0.0);\n  const vec2 hi = vec2(1.0, 1.0);\n  const vec4 black = vec4(0.0, 0.0, 0.0, 1.0);\n  bool out_of_bounds =\n    any(lessThan(v_texcoord, lo)) ||\n    any(greaterThan(v_texcoord, hi));\n  if (out_of_bounds) {\n    gl_FragColor = black;\n  } else {\n    gl_FragColor = texture2D(tex_sampler_0, v_texcoord);\n  }\n}\n";
    }

    protected void createProgram(FilterContext filterContext, FrameFormat frameFormat) {
        if (this.mLastFormat == null || this.mLastFormat.getTarget() != frameFormat.getTarget()) {
            this.mLastFormat = frameFormat;
            this.mProgram = null;
            switch (frameFormat.getTarget()) {
                case 3:
                    if (!this.mFillBlack) {
                        this.mProgram = ShaderProgram.createIdentity(filterContext);
                        break;
                    } else {
                        this.mProgram = new ShaderProgram(filterContext, "precision mediump float;\nuniform sampler2D tex_sampler_0;\nvarying vec2 v_texcoord;\nvoid main() {\n  const vec2 lo = vec2(0.0, 0.0);\n  const vec2 hi = vec2(1.0, 1.0);\n  const vec4 black = vec4(0.0, 0.0, 0.0, 1.0);\n  bool out_of_bounds =\n    any(lessThan(v_texcoord, lo)) ||\n    any(greaterThan(v_texcoord, hi));\n  if (out_of_bounds) {\n    gl_FragColor = black;\n  } else {\n    gl_FragColor = texture2D(tex_sampler_0, v_texcoord);\n  }\n}\n");
                        break;
                    }
            }
            if (this.mProgram == null) {
                throw new RuntimeException("Could not create a program for crop filter " + this + "!");
            }
        }
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        MutableFrameFormat mutableCopy = frameFormat.mutableCopy();
        mutableCopy.setDimensions(0, 0);
        return mutableCopy;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("image");
        Frame pullInput2 = pullInput("box");
        createProgram(filterContext, pullInput.getFormat());
        Quad quad = (Quad) pullInput2.getObjectValue();
        MutableFrameFormat mutableCopy = pullInput.getFormat().mutableCopy();
        mutableCopy.setDimensions(this.mOutputWidth == -1 ? mutableCopy.getWidth() : this.mOutputWidth, this.mOutputHeight == -1 ? mutableCopy.getHeight() : this.mOutputHeight);
        Frame newFrame = filterContext.getFrameManager().newFrame(mutableCopy);
        if (this.mProgram instanceof ShaderProgram) {
            ((ShaderProgram) this.mProgram).setSourceRegion(quad);
        }
        this.mProgram.process(pullInput, newFrame);
        pushOutput("image", newFrame);
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3));
        addMaskedInputPort("box", ObjectFormat.fromClass(Quad.class, 1));
        addOutputBasedOnInput("image", "image");
    }
}
