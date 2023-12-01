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
import java.util.Date;
import java.util.Random;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/GrainFilter.class */
public class GrainFilter extends Filter {
    private static final int RAND_THRESHOLD = 128;
    private Program mGrainProgram;
    private final String mGrainShader;
    private int mHeight;
    private Program mNoiseProgram;
    private final String mNoiseShader;
    private Random mRandom;
    @GenerateFieldPort(hasDefault = true, name = "strength")
    private float mScale;
    private int mTarget;
    @GenerateFieldPort(hasDefault = true, name = "tile_size")
    private int mTileSize;
    private int mWidth;

    public GrainFilter(String str) {
        super(str);
        this.mScale = 0.0f;
        this.mTileSize = 640;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mTarget = 0;
        this.mNoiseShader = "precision mediump float;\nuniform vec2 seed;\nvarying vec2 v_texcoord;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  return fract(part1 + part2 + part3);\n}\nvoid main() {\n  gl_FragColor = vec4(rand(v_texcoord + seed), 0.0, 0.0, 1.0);\n}\n";
        this.mGrainShader = "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform float scale;\nuniform float stepX;\nuniform float stepY;\nvarying vec2 v_texcoord;\nvoid main() {\n  float noise = texture2D(tex_sampler_1, v_texcoord + vec2(-stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, v_texcoord + vec2(-stepX, stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, v_texcoord + vec2(stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, v_texcoord + vec2(stepX, stepY)).r * 0.224;\n  noise += 0.4448;\n  noise *= scale;\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float energy = 0.33333 * color.r + 0.33333 * color.g + 0.33333 * color.b;\n  float mask = (1.0 - sqrt(energy));\n  float weight = 1.0 - 1.333 * mask * noise;\n  gl_FragColor = vec4(color.rgb * weight, color.a);\n}\n";
        this.mRandom = new Random(new Date().getTime());
    }

    private void updateFrameSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        if (this.mGrainProgram != null) {
            this.mGrainProgram.setHostValue("stepX", Float.valueOf(0.5f / this.mWidth));
            this.mGrainProgram.setHostValue("stepY", Float.valueOf(0.5f / this.mHeight));
            updateParameters();
        }
    }

    private void updateParameters() {
        this.mNoiseProgram.setHostValue("seed", new float[]{this.mRandom.nextFloat(), this.mRandom.nextFloat()});
        this.mGrainProgram.setHostValue(BatteryManager.EXTRA_SCALE, Float.valueOf(this.mScale));
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mGrainProgram == null || this.mNoiseProgram == null) {
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
                ShaderProgram shaderProgram = new ShaderProgram(filterContext, "precision mediump float;\nuniform vec2 seed;\nvarying vec2 v_texcoord;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  return fract(part1 + part2 + part3);\n}\nvoid main() {\n  gl_FragColor = vec4(rand(v_texcoord + seed), 0.0, 0.0, 1.0);\n}\n");
                shaderProgram.setMaximumTileSize(this.mTileSize);
                this.mNoiseProgram = shaderProgram;
                ShaderProgram shaderProgram2 = new ShaderProgram(filterContext, "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform float scale;\nuniform float stepX;\nuniform float stepY;\nvarying vec2 v_texcoord;\nvoid main() {\n  float noise = texture2D(tex_sampler_1, v_texcoord + vec2(-stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, v_texcoord + vec2(-stepX, stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, v_texcoord + vec2(stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, v_texcoord + vec2(stepX, stepY)).r * 0.224;\n  noise += 0.4448;\n  noise *= scale;\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float energy = 0.33333 * color.r + 0.33333 * color.g + 0.33333 * color.b;\n  float mask = (1.0 - sqrt(energy));\n  float weight = 1.0 - 1.333 * mask * noise;\n  gl_FragColor = vec4(color.rgb * weight, color.a);\n}\n");
                shaderProgram2.setMaximumTileSize(this.mTileSize);
                this.mGrainProgram = shaderProgram2;
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
        ImageFormat.create(format.getWidth() / 2, format.getHeight() / 2, 3, 3);
        Frame newFrame = filterContext.getFrameManager().newFrame(format);
        Frame newFrame2 = filterContext.getFrameManager().newFrame(format);
        if (this.mNoiseProgram == null || this.mGrainProgram == null || format.getTarget() != this.mTarget) {
            initProgram(filterContext, format.getTarget());
            updateParameters();
        }
        if (format.getWidth() != this.mWidth || format.getHeight() != this.mHeight) {
            updateFrameSize(format.getWidth(), format.getHeight());
        }
        this.mNoiseProgram.process(new Frame[0], newFrame);
        this.mGrainProgram.process(new Frame[]{pullInput, newFrame}, newFrame2);
        pushOutput("image", newFrame2);
        newFrame2.release();
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3));
        addOutputBasedOnInput("image", "image");
    }
}
