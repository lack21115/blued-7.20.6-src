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

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/TintFilter.class */
public class TintFilter extends Filter {
    private Program mProgram;
    private int mTarget;
    @GenerateFieldPort(hasDefault = true, name = "tile_size")
    private int mTileSize;
    @GenerateFieldPort(hasDefault = true, name = "tint")
    private int mTint;
    private final String mTintShader;

    public TintFilter(String str) {
        super(str);
        this.mTint = Color.BLUE;
        this.mTileSize = 640;
        this.mTarget = 0;
        this.mTintShader = "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform vec3 tint;\nuniform vec3 color_ratio;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float avg_color = dot(color_ratio, color.rgb);\n  vec3 new_color = min(0.8 * avg_color + 0.2 * tint, 1.0);\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    private void initParameters() {
        this.mProgram.setHostValue("color_ratio", new float[]{0.21f, 0.71f, 0.07f});
        updateParameters();
    }

    private void updateParameters() {
        this.mProgram.setHostValue("tint", new float[]{Color.red(this.mTint) / 255.0f, Color.green(this.mTint) / 255.0f, Color.blue(this.mTint) / 255.0f});
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mProgram != null) {
            updateParameters();
        }
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    public void initProgram(FilterContext filterContext, int i) {
        switch (i) {
            case 3:
                ShaderProgram shaderProgram = new ShaderProgram(filterContext, "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform vec3 tint;\nuniform vec3 color_ratio;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float avg_color = dot(color_ratio, color.rgb);\n  vec3 new_color = min(0.8 * avg_color + 0.2 * tint, 1.0);\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n");
                shaderProgram.setMaximumTileSize(this.mTileSize);
                this.mProgram = shaderProgram;
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
            initParameters();
        }
        Frame newFrame = filterContext.getFrameManager().newFrame(format);
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
