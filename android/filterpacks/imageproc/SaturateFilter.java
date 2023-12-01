package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.Program;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.os.BatteryManager;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/SaturateFilter.class */
public class SaturateFilter extends Filter {
    private Program mBenProgram;
    private final String mBenSaturateShader;
    private Program mHerfProgram;
    private final String mHerfSaturateShader;
    @GenerateFieldPort(hasDefault = true, name = BatteryManager.EXTRA_SCALE)
    private float mScale;
    private int mTarget;
    @GenerateFieldPort(hasDefault = true, name = "tile_size")
    private int mTileSize;

    public SaturateFilter(String str) {
        super(str);
        this.mScale = 0.0f;
        this.mTileSize = 640;
        this.mTarget = 0;
        this.mBenSaturateShader = "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform float scale;\nuniform float shift;\nuniform vec3 weights;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float kv = dot(color.rgb, weights) + shift;\n  vec3 new_color = scale * color.rgb + (1.0 - scale) * kv;\n  gl_FragColor = vec4(new_color, color.a);\n}\n";
        this.mHerfSaturateShader = "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform vec3 weights;\nuniform vec3 exponents;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float de = dot(color.rgb, weights);\n  float inv_de = 1.0 / de;\n  vec3 new_color = de * pow(color.rgb * inv_de, exponents);\n  float max_color = max(max(max(new_color.r, new_color.g), new_color.b), 1.0);\n  gl_FragColor = vec4(new_color / max_color, color.a);\n}\n";
    }

    private void initParameters() {
        float[] fArr = {0.25f, 0.625f, 0.125f};
        this.mBenProgram.setHostValue("weights", fArr);
        this.mBenProgram.setHostValue("shift", Float.valueOf(0.003921569f));
        this.mHerfProgram.setHostValue("weights", fArr);
        updateParameters();
    }

    private void updateParameters() {
        if (this.mScale <= 0.0f) {
            this.mBenProgram.setHostValue(BatteryManager.EXTRA_SCALE, Float.valueOf(this.mScale + 1.0f));
            return;
        }
        this.mHerfProgram.setHostValue("exponents", new float[]{(0.9f * this.mScale) + 1.0f, (2.1f * this.mScale) + 1.0f, (2.7f * this.mScale) + 1.0f});
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mBenProgram == null || this.mHerfProgram == null) {
            return;
        }
        updateParameters();
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    public void initProgram(FilterContext filterContext, int i) {
        switch (i) {
            case 3:
                ShaderProgram shaderProgram = new ShaderProgram(filterContext, "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform float scale;\nuniform float shift;\nuniform vec3 weights;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float kv = dot(color.rgb, weights) + shift;\n  vec3 new_color = scale * color.rgb + (1.0 - scale) * kv;\n  gl_FragColor = vec4(new_color, color.a);\n}\n");
                shaderProgram.setMaximumTileSize(this.mTileSize);
                this.mBenProgram = shaderProgram;
                ShaderProgram shaderProgram2 = new ShaderProgram(filterContext, "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform vec3 weights;\nuniform vec3 exponents;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float de = dot(color.rgb, weights);\n  float inv_de = 1.0 / de;\n  vec3 new_color = de * pow(color.rgb * inv_de, exponents);\n  float max_color = max(max(max(new_color.r, new_color.g), new_color.b), 1.0);\n  gl_FragColor = vec4(new_color / max_color, color.a);\n}\n");
                shaderProgram2.setMaximumTileSize(this.mTileSize);
                this.mHerfProgram = shaderProgram2;
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
        if (this.mBenProgram == null || format.getTarget() != this.mTarget) {
            initProgram(filterContext, format.getTarget());
            initParameters();
        }
        Frame newFrame = filterContext.getFrameManager().newFrame(format);
        if (this.mScale > 0.0f) {
            this.mHerfProgram.process(pullInput, newFrame);
        } else {
            this.mBenProgram.process(pullInput, newFrame);
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
