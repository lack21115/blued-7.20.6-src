package android.filterfw.core;

import android.filterfw.geometry.Quad;
import android.opengl.GLES20;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/ShaderProgram.class */
public class ShaderProgram extends Program {
    private GLEnvironment mGLEnvironment;
    private int mMaxTileSize = 0;
    private StopWatchMap mTimer = null;
    private int shaderProgramId;

    static {
        System.loadLibrary("filterfw");
    }

    private ShaderProgram() {
    }

    public ShaderProgram(FilterContext filterContext, String str) {
        this.mGLEnvironment = getGLEnvironment(filterContext);
        allocate(this.mGLEnvironment, null, str);
        if (!compileAndLink()) {
            throw new RuntimeException("Could not compile and link shader!");
        }
        setTimer();
    }

    public ShaderProgram(FilterContext filterContext, String str, String str2) {
        this.mGLEnvironment = getGLEnvironment(filterContext);
        allocate(this.mGLEnvironment, str, str2);
        if (!compileAndLink()) {
            throw new RuntimeException("Could not compile and link shader!");
        }
        setTimer();
    }

    private ShaderProgram(NativeAllocatorTag nativeAllocatorTag) {
    }

    private native boolean allocate(GLEnvironment gLEnvironment, String str, String str2);

    private native boolean beginShaderDrawing();

    private native boolean compileAndLink();

    public static ShaderProgram createIdentity(FilterContext filterContext) {
        ShaderProgram nativeCreateIdentity = nativeCreateIdentity(getGLEnvironment(filterContext));
        nativeCreateIdentity.setTimer();
        return nativeCreateIdentity;
    }

    private native boolean deallocate();

    private static GLEnvironment getGLEnvironment(FilterContext filterContext) {
        GLEnvironment gLEnvironment = filterContext != null ? filterContext.getGLEnvironment() : null;
        if (gLEnvironment == null) {
            throw new NullPointerException("Attempting to create ShaderProgram with no GL environment in place!");
        }
        return gLEnvironment;
    }

    private native Object getUniformValue(String str);

    private static native ShaderProgram nativeCreateIdentity(GLEnvironment gLEnvironment);

    private native boolean setShaderAttributeValues(String str, float[] fArr, int i);

    private native boolean setShaderAttributeVertexFrame(String str, VertexFrame vertexFrame, int i, int i2, int i3, int i4, boolean z);

    private native boolean setShaderBlendEnabled(boolean z);

    private native boolean setShaderBlendFunc(int i, int i2);

    private native boolean setShaderClearColor(float f, float f2, float f3);

    private native boolean setShaderClearsOutput(boolean z);

    private native boolean setShaderDrawMode(int i);

    private native boolean setShaderTileCounts(int i, int i2);

    private native boolean setShaderVertexCount(int i);

    private native boolean setTargetRegion(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    private void setTimer() {
        this.mTimer = new StopWatchMap();
    }

    private native boolean setUniformValue(String str, Object obj);

    private native boolean shaderProcess(GLFrame[] gLFrameArr, GLFrame gLFrame);

    public void beginDrawing() {
        if (!beginShaderDrawing()) {
            throw new RuntimeException("Could not prepare shader-program for drawing!");
        }
    }

    protected void finalize() throws Throwable {
        deallocate();
    }

    public GLEnvironment getGLEnvironment() {
        return this.mGLEnvironment;
    }

    @Override // android.filterfw.core.Program
    public Object getHostValue(String str) {
        return getUniformValue(str);
    }

    @Override // android.filterfw.core.Program
    public void process(Frame[] frameArr, Frame frame) {
        if (this.mTimer.LOG_MFF_RUNNING_TIMES) {
            this.mTimer.start("glFinish");
            GLES20.glFinish();
            this.mTimer.stop("glFinish");
        }
        GLFrame[] gLFrameArr = new GLFrame[frameArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= frameArr.length) {
                if (!(frame instanceof GLFrame)) {
                    throw new RuntimeException("ShaderProgram got non-GL output frame!");
                }
                GLFrame gLFrame = (GLFrame) frame;
                if (this.mMaxTileSize > 0) {
                    setShaderTileCounts(((frame.getFormat().getWidth() + this.mMaxTileSize) - 1) / this.mMaxTileSize, ((frame.getFormat().getHeight() + this.mMaxTileSize) - 1) / this.mMaxTileSize);
                }
                if (!shaderProcess(gLFrameArr, gLFrame)) {
                    throw new RuntimeException("Error executing ShaderProgram!");
                }
                if (this.mTimer.LOG_MFF_RUNNING_TIMES) {
                    GLES20.glFinish();
                    return;
                }
                return;
            } else if (!(frameArr[i2] instanceof GLFrame)) {
                throw new RuntimeException("ShaderProgram got non-GL frame as input " + i2 + "!");
            } else {
                gLFrameArr[i2] = (GLFrame) frameArr[i2];
                i = i2 + 1;
            }
        }
    }

    public void setAttributeValues(String str, VertexFrame vertexFrame, int i, int i2, int i3, int i4, boolean z) {
        if (!setShaderAttributeVertexFrame(str, vertexFrame, i, i2, i3, i4, z)) {
            throw new RuntimeException("Error setting attribute value for attribute '" + str + "'!");
        }
    }

    public void setAttributeValues(String str, float[] fArr, int i) {
        if (!setShaderAttributeValues(str, fArr, i)) {
            throw new RuntimeException("Error setting attribute value for attribute '" + str + "'!");
        }
    }

    public void setBlendEnabled(boolean z) {
        if (!setShaderBlendEnabled(z)) {
            throw new RuntimeException("Could not set Blending " + z + "!");
        }
    }

    public void setBlendFunc(int i, int i2) {
        if (!setShaderBlendFunc(i, i2)) {
            throw new RuntimeException("Could not set BlendFunc " + i + "," + i2 + "!");
        }
    }

    public void setClearColor(float f, float f2, float f3) {
        if (!setShaderClearColor(f, f2, f3)) {
            throw new RuntimeException("Could not set clear color to " + f + "," + f2 + "," + f3 + "!");
        }
    }

    public void setClearsOutput(boolean z) {
        if (!setShaderClearsOutput(z)) {
            throw new RuntimeException("Could not set clears-output flag to " + z + "!");
        }
    }

    public void setDrawMode(int i) {
        if (!setShaderDrawMode(i)) {
            throw new RuntimeException("Could not set GL draw-mode to " + i + "!");
        }
    }

    @Override // android.filterfw.core.Program
    public void setHostValue(String str, Object obj) {
        if (!setUniformValue(str, obj)) {
            throw new RuntimeException("Error setting uniform value for variable '" + str + "'!");
        }
    }

    public void setMaximumTileSize(int i) {
        this.mMaxTileSize = i;
    }

    public void setSourceRect(float f, float f2, float f3, float f4) {
        setSourceRegion(f, f2, f + f3, f2, f, f2 + f4, f + f3, f2 + f4);
    }

    public void setSourceRegion(Quad quad) {
        setSourceRegion(quad.p0.x, quad.p0.y, quad.p1.x, quad.p1.y, quad.p2.x, quad.p2.y, quad.p3.x, quad.p3.y);
    }

    public native boolean setSourceRegion(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    public void setTargetRect(float f, float f2, float f3, float f4) {
        setTargetRegion(f, f2, f + f3, f2, f, f2 + f4, f + f3, f2 + f4);
    }

    public void setTargetRegion(Quad quad) {
        setTargetRegion(quad.p0.x, quad.p0.y, quad.p1.x, quad.p1.y, quad.p2.x, quad.p2.y, quad.p3.x, quad.p3.y);
    }

    public void setVertexCount(int i) {
        if (!setShaderVertexCount(i)) {
            throw new RuntimeException("Could not set GL vertex count to " + i + "!");
        }
    }
}
