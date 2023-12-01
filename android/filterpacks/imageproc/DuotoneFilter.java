package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.Program;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.graphics.Color;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/DuotoneFilter.class */
public class DuotoneFilter extends Filter {
    private final String mDuotoneShader;
    @GenerateFieldPort(hasDefault = true, name = "first_color")
    private int mFirstColor;
    private Program mProgram;
    @GenerateFieldPort(hasDefault = true, name = "second_color")
    private int mSecondColor;
    private int mTarget;
    @GenerateFieldPort(hasDefault = true, name = "tile_size")
    private int mTileSize;

    public DuotoneFilter(String str) {
        super(str);
        this.mFirstColor = -65536;
        this.mSecondColor = -256;
        this.mTileSize = 640;
        this.mTarget = 0;
        this.mDuotoneShader = "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform vec3 first;\nuniform vec3 second;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float energy = (color.r + color.g + color.b) * 0.3333;\n  vec3 new_color = (1.0 - energy) * first + energy * second;\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    private void updateParameters() {
        float red = Color.red(this.mFirstColor) / 255.0f;
        float green = Color.green(this.mFirstColor) / 255.0f;
        float blue = Color.blue(this.mFirstColor) / 255.0f;
        float red2 = Color.red(this.mSecondColor) / 255.0f;
        float green2 = Color.green(this.mSecondColor) / 255.0f;
        float blue2 = Color.blue(this.mSecondColor) / 255.0f;
        this.mProgram.setHostValue("first", new float[]{red, green, blue});
        this.mProgram.setHostValue("second", new float[]{red2, green2, blue2});
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    public void initProgram(FilterContext filterContext, int i) {
        switch (i) {
            case 3:
                ShaderProgram shaderProgram = new ShaderProgram(filterContext, "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform vec3 first;\nuniform vec3 second;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float energy = (color.r + color.g + color.b) * 0.3333;\n  vec3 new_color = (1.0 - energy) * first + energy * second;\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n");
                shaderProgram.setMaximumTileSize(this.mTileSize);
                this.mProgram = shaderProgram;
                this.mTarget = i;
                return;
            default:
                throw new RuntimeException("Filter Duotone does not support frames of target " + i + "!");
        }
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("image");
        FrameFormat format = pullInput.getFormat();
        Frame newFrame = filterContext.getFrameManager().newFrame(format);
        if (this.mProgram == null || format.getTarget() != this.mTarget) {
            initProgram(filterContext, format.getTarget());
        }
        updateParameters();
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
