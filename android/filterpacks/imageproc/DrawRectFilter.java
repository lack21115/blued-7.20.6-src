package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GLFrame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.filterfw.format.ObjectFormat;
import android.filterfw.geometry.Quad;
import android.opengl.GLES20;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/DrawRectFilter.class */
public class DrawRectFilter extends Filter {
    @GenerateFieldPort(hasDefault = true, name = "colorBlue")
    private float mColorBlue;
    @GenerateFieldPort(hasDefault = true, name = "colorGreen")
    private float mColorGreen;
    @GenerateFieldPort(hasDefault = true, name = "colorRed")
    private float mColorRed;
    private final String mFixedColorFragmentShader;
    private ShaderProgram mProgram;
    private final String mVertexShader;

    public DrawRectFilter(String str) {
        super(str);
        this.mColorRed = 0.8f;
        this.mColorGreen = 0.8f;
        this.mColorBlue = 0.0f;
        this.mVertexShader = "attribute vec4 aPosition;\nvoid main() {\n  gl_Position = aPosition;\n}\n";
        this.mFixedColorFragmentShader = "precision mediump float;\nuniform vec4 color;\nvoid main() {\n  gl_FragColor = color;\n}\n";
    }

    private void renderBox(Quad quad) {
        float f = this.mColorRed;
        float f2 = this.mColorGreen;
        float f3 = this.mColorBlue;
        float f4 = quad.p0.x;
        float f5 = quad.p0.y;
        float f6 = quad.p1.x;
        float f7 = quad.p1.y;
        float f8 = quad.p3.x;
        float f9 = quad.p3.y;
        float f10 = quad.p2.x;
        float f11 = quad.p2.y;
        this.mProgram.setHostValue("color", new float[]{f, f2, f3, 1.0f});
        this.mProgram.setAttributeValues("aPosition", new float[]{f4, f5, f6, f7, f8, f9, f10, f11}, 2);
        this.mProgram.setVertexCount(4);
        this.mProgram.beginDrawing();
        GLES20.glLineWidth(1.0f);
        GLES20.glDrawArrays(2, 0, 4);
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    @Override // android.filterfw.core.Filter
    public void prepare(FilterContext filterContext) {
        this.mProgram = new ShaderProgram(filterContext, "attribute vec4 aPosition;\nvoid main() {\n  gl_Position = aPosition;\n}\n", "precision mediump float;\nuniform vec4 color;\nvoid main() {\n  gl_FragColor = color;\n}\n");
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("image");
        Quad translated = ((Quad) pullInput("box").getObjectValue()).scaled(2.0f).translated(-1.0f, -1.0f);
        GLFrame gLFrame = (GLFrame) filterContext.getFrameManager().duplicateFrame(pullInput);
        gLFrame.focus();
        renderBox(translated);
        pushOutput("image", gLFrame);
        gLFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3, 3));
        addMaskedInputPort("box", ObjectFormat.fromClass(Quad.class, 1));
        addOutputBasedOnInput("image", "image");
    }
}
