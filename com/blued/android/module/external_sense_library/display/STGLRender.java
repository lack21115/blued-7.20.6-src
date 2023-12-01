package com.blued.android.module.external_sense_library.display;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.glutils.OpenGLUtils;
import com.blued.android.module.external_sense_library.glutils.TextureRotationUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/display/STGLRender.class */
public class STGLRender {
    public static final String CAMERA_INPUT_FRAGMENT_SHADER = "precision mediump float;\nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    private static final String CAMERA_INPUT_FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\n\nvoid main()\n{\n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    private static final String CAMERA_INPUT_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\tgl_Position = position;\n}";
    private static final String DRAW_POINTS_COLOR = "uColor";
    public static final String DRAW_POINTS_FRAGMENT_SHADER = "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}";
    private static final String DRAW_POINTS_POSITION = "aPosition";
    private static final String DRAW_POINTS_PROGRAM = "mPointProgram";
    public static final String DRAW_POINTS_VERTEX_SHADER = "attribute vec4 aPosition;\nvoid main() {\n  gl_PointSize = 2.0;  gl_Position = aPosition;\n}";
    private static final String POSITION_COORDINATE = "position";
    private static final String PROGRAM_ID = "program";
    private static final String TAG = "STGLRender";
    private static final String TEXTURE_COORDINATE = "inputTextureCoordinate";
    private static final String TEXTURE_UNIFORM = "inputImageTexture";
    private static final String UV_TEXTURE = "uv_texture";
    private static final String YUV_TEXTURE = "precision mediump float;                           \nvarying vec2 textureCoordinate;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void){                                  \n   float y = texture2D(y_texture, textureCoordinate).r;        \n   vec2 uv = texture2D(uv_texture, textureCoordinate).xw - 0.5;       \n   float r = y + 1.370705 * uv.x;\n   float g = y - 0.698001 * uv.x - 0.337633 * uv.y;\n   float b = y + 1.732446 * uv.y;\n                          \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n";
    private static final String Y_TEXTURE = "y_texture";
    private int YUVToRGBAProgramId;
    private boolean activityModelLandscape;
    private int glError;
    private ArrayList<HashMap<String, Integer>> mArrayPrograms;
    private int mColor;
    private int mDrawPointsProgram;
    private int[] mFrameBufferTextures;
    private int[] mFrameBufferTexturesResize;
    private int[] mFrameBuffers;
    private int[] mFrameBuffersResize;
    private final FloatBuffer mGLCubeBuffer;
    private final FloatBuffer mGLSaveTextureBuffer;
    private final FloatBuffer mGLTextureBuffer;
    private int mHeightResize;
    private boolean mIsInitialized;
    private boolean mNeedResize;
    private int[] mPointsFrameBuffers;
    private int mPosition;
    private int[] mSavePictureFrameBufferTextures;
    private int[] mSavePictureFrameBuffers;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVertexBuffer;
    private int mViewPortHeight;
    private int mViewPortWidth;
    private int mWidthResize;
    private int uvTextureLoc;
    private int yTextureLoc;

    public STGLRender() {
        this(true);
    }

    public STGLRender(boolean z) {
        this.mDrawPointsProgram = 0;
        this.mColor = -1;
        this.mPosition = -1;
        this.YUVToRGBAProgramId = -1;
        this.yTextureLoc = -1;
        this.uvTextureLoc = -1;
        this.mArrayPrograms = new ArrayList<HashMap<String, Integer>>(2) { // from class: com.blued.android.module.external_sense_library.display.STGLRender.1
            {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 2) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(STGLRender.PROGRAM_ID, 0);
                    hashMap.put("position", -1);
                    hashMap.put(STGLRender.TEXTURE_UNIFORM, -1);
                    hashMap.put(STGLRender.TEXTURE_COORDINATE, -1);
                    add(hashMap);
                    i = i2 + 1;
                }
            }
        };
        this.mNeedResize = false;
        this.mWidthResize = 180;
        this.mHeightResize = 320;
        this.activityModelLandscape = true;
        this.activityModelLandscape = z;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.f.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLCubeBuffer = asFloatBuffer;
        asFloatBuffer.put(TextureRotationUtil.f).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureBuffer = asFloatBuffer2;
        asFloatBuffer2.put(TextureRotationUtil.b).position(0);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLSaveTextureBuffer = asFloatBuffer3;
        asFloatBuffer3.put(TextureRotationUtil.c(0, false, true)).position(0);
        if (z) {
            FloatBuffer asFloatBuffer4 = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mTextureBuffer = asFloatBuffer4;
            asFloatBuffer4.put(TextureRotationUtil.d).position(0);
        }
    }

    private void bindFrameBuffer(int i, int i2, int i3, int i4) {
        GLES20.glBindTexture(3553, i);
        GLES20.glTexImage2D(3553, 0, 6408, i3, i4, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void initFrameBuffers(int i, int i2) {
        destroyFrameBuffers();
        destroyResizeFrameBuffers();
        if (this.mFrameBuffers == null) {
            int[] iArr = new int[2];
            this.mFrameBuffers = iArr;
            this.mFrameBufferTextures = new int[2];
            GLES20.glGenFramebuffers(2, iArr, 0);
            GLES20.glGenTextures(2, this.mFrameBufferTextures, 0);
            bindFrameBuffer(this.mFrameBufferTextures[0], this.mFrameBuffers[0], i, i2);
            bindFrameBuffer(this.mFrameBufferTextures[1], this.mFrameBuffers[1], i, i2);
        }
        if (this.mSavePictureFrameBuffers == null) {
            int[] iArr2 = new int[1];
            this.mSavePictureFrameBuffers = iArr2;
            this.mSavePictureFrameBufferTextures = new int[1];
            GLES20.glGenFramebuffers(1, iArr2, 0);
            GLES20.glGenTextures(1, this.mSavePictureFrameBufferTextures, 0);
            bindFrameBuffer(this.mSavePictureFrameBufferTextures[0], this.mSavePictureFrameBuffers[0], i, i2);
        }
        if (this.mNeedResize && this.mFrameBuffersResize == null) {
            int[] iArr3 = new int[2];
            this.mFrameBuffersResize = iArr3;
            this.mFrameBufferTexturesResize = new int[2];
            GLES20.glGenFramebuffers(2, iArr3, 0);
            GLES20.glGenTextures(2, this.mFrameBufferTexturesResize, 0);
            bindFrameBuffer(this.mFrameBufferTexturesResize[0], this.mFrameBuffersResize[0], this.mWidthResize, this.mHeightResize);
            bindFrameBuffer(this.mFrameBufferTexturesResize[1], this.mFrameBuffersResize[1], this.mWidthResize, this.mHeightResize);
        }
    }

    private void initInner(int i, int i2, int i3, int i4) {
        if (this.mViewPortWidth == i && this.mViewPortHeight == i2) {
            return;
        }
        initProgram(CAMERA_INPUT_FRAGMENT_SHADER_OES, this.mArrayPrograms.get(0));
        initProgram(CAMERA_INPUT_FRAGMENT_SHADER, this.mArrayPrograms.get(1));
        initYUVProgram(CAMERA_INPUT_VERTEX_SHADER, YUV_TEXTURE);
        this.mViewPortWidth = i;
        this.mViewPortHeight = i2;
        this.mWidthResize = i3;
        this.mHeightResize = i4;
        if (i3 > 0 && i4 > 0) {
            this.mNeedResize = true;
        }
        initFrameBuffers(i, i2);
        this.mIsInitialized = true;
    }

    private void initProgram(String str, HashMap<String, Integer> hashMap) {
        if (hashMap.get(PROGRAM_ID).intValue() == 0) {
            int a2 = OpenGLUtils.a(CAMERA_INPUT_VERTEX_SHADER, str);
            hashMap.put(PROGRAM_ID, Integer.valueOf(a2));
            hashMap.put("position", Integer.valueOf(GLES20.glGetAttribLocation(a2, "position")));
            hashMap.put(TEXTURE_UNIFORM, Integer.valueOf(GLES20.glGetUniformLocation(a2, TEXTURE_UNIFORM)));
            hashMap.put(TEXTURE_COORDINATE, Integer.valueOf(GLES20.glGetAttribLocation(a2, TEXTURE_COORDINATE)));
        }
    }

    private void initYUVProgram(String str, String str2) {
        int a2 = OpenGLUtils.a(str, str2);
        this.YUVToRGBAProgramId = a2;
        this.yTextureLoc = GLES20.glGetUniformLocation(a2, Y_TEXTURE);
        this.uvTextureLoc = GLES20.glGetUniformLocation(this.YUVToRGBAProgramId, UV_TEXTURE);
    }

    public int YUV2RGB(int i, int i2, boolean z) {
        if (this.mFrameBuffers == null || !this.mIsInitialized) {
            return -2;
        }
        GLES20.glUseProgram(this.YUVToRGBAProgramId);
        GlUtil.a("glUseProgram");
        this.mGLCubeBuffer.position(0);
        int intValue = this.mArrayPrograms.get(0).get("position").intValue();
        GLES20.glVertexAttribPointer(intValue, 2, 5126, false, 0, (Buffer) this.mGLCubeBuffer);
        GLES20.glEnableVertexAttribArray(intValue);
        this.mTextureBuffer.position(0);
        int intValue2 = this.mArrayPrograms.get(0).get(TEXTURE_COORDINATE).intValue();
        GLES20.glVertexAttribPointer(intValue2, 2, 5126, false, 0, (Buffer) this.mTextureBuffer);
        GLES20.glEnableVertexAttribArray(intValue2);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(this.yTextureLoc, 0);
        }
        if (i2 != -1) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, i2);
            GLES20.glUniform1i(this.uvTextureLoc, 1);
        }
        if (z) {
            GLES20.glBindFramebuffer(36160, this.mFrameBuffers[0]);
        } else {
            GLES20.glBindFramebuffer(36160, this.mFrameBuffers[1]);
        }
        GlUtil.a("glBindFramebuffer");
        GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(intValue);
        GLES20.glDisableVertexAttribArray(intValue2);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return z ? this.mFrameBufferTextures[0] : this.mFrameBufferTextures[1];
    }

    public void adjustTextureBuffer(int i, boolean z, boolean z2) {
        float[] a2 = TextureRotationUtil.a(i, z, z2);
        LogUtils.b(TAG, "==========rotation: " + i + " flipVertical: " + z2 + " texturePos: " + Arrays.toString(a2));
        if (this.mTextureBuffer == null) {
            this.mTextureBuffer = ByteBuffer.allocateDirect(a2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mTextureBuffer.clear();
        this.mTextureBuffer.put(a2).position(0);
    }

    public void adjustVideoTextureBuffer(int i, boolean z, boolean z2) {
        float[] d = TextureRotationUtil.d(i, z, z2);
        LogUtils.b(TAG, "==========rotation: " + i + " flipVertical: " + z2 + " texturePos: " + Arrays.toString(d));
        if (this.mTextureBuffer == null) {
            this.mTextureBuffer = ByteBuffer.allocateDirect(d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mTextureBuffer.clear();
        this.mTextureBuffer.put(d).position(0);
    }

    public void adjustZegoTextureBuffer(int i, boolean z, boolean z2) {
        float[] b = TextureRotationUtil.b(i, z, z2);
        LogUtils.b(TAG, "==========rotation: " + i + " flipVertical: " + z2 + " texturePos: " + Arrays.toString(b));
        if (this.mTextureBuffer == null) {
            this.mTextureBuffer = ByteBuffer.allocateDirect(b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mTextureBuffer.clear();
        this.mTextureBuffer.put(b).position(0);
    }

    public void calculateVertexBuffer(int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i3;
        float f3 = f / f2;
        float f4 = i2;
        float f5 = i4;
        float min = Math.min(f3, f4 / f5);
        int round = Math.round(f2 * min);
        int round2 = Math.round(f5 * min);
        float f6 = round / f;
        float f7 = round2 / f4;
        float f8 = TextureRotationUtil.f[0] / f7;
        float f9 = TextureRotationUtil.f[1] / f6;
        float f10 = TextureRotationUtil.f[2] / f7;
        float f11 = TextureRotationUtil.f[3] / f6;
        float f12 = TextureRotationUtil.f[4] / f7;
        float f13 = TextureRotationUtil.f[5] / f6;
        float f14 = TextureRotationUtil.f[6] / f7;
        float f15 = TextureRotationUtil.f[7] / f6;
        if (this.mVertexBuffer == null) {
            this.mVertexBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mVertexBuffer.clear();
        this.mVertexBuffer.put(new float[]{f8, f9, f10, f11, f12, f13, f14, f15}).position(0);
    }

    public void calculateZegoVertexBuffer(int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i3;
        float f3 = f / f2;
        float f4 = i2;
        float f5 = i4;
        float min = Math.min(f3, f4 / f5);
        int round = Math.round(f2 * min);
        int round2 = Math.round(f5 * min);
        float f6 = round / f;
        float f7 = round2 / f4;
        float f8 = TextureRotationUtil.f[0] / f7;
        float f9 = TextureRotationUtil.f[1] / f6;
        float f10 = TextureRotationUtil.f[2] / f7;
        float f11 = TextureRotationUtil.f[3] / f6;
        float f12 = TextureRotationUtil.f[4] / f7;
        float f13 = TextureRotationUtil.f[5] / f6;
        float f14 = TextureRotationUtil.f[6] / f7;
        float f15 = TextureRotationUtil.f[7] / f6;
        if (this.mVertexBuffer == null) {
            this.mVertexBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mVertexBuffer.clear();
        this.mVertexBuffer.put(new float[]{f8, f9, f10, f11, f12, f13, f14, f15}).position(0);
    }

    public final void destroy() {
        this.mIsInitialized = false;
        destroyFrameBuffers();
        GLES20.glDeleteProgram(this.mArrayPrograms.get(0).get(PROGRAM_ID).intValue());
        GLES20.glDeleteProgram(this.mArrayPrograms.get(1).get(PROGRAM_ID).intValue());
        if (this.activityModelLandscape) {
            return;
        }
        GLES20.glDeleteProgram(this.mArrayPrograms.get(2).get(PROGRAM_ID).intValue());
    }

    public void destroyFrameBuffers() {
        int[] iArr = this.mFrameBufferTextures;
        if (iArr != null) {
            GLES20.glDeleteTextures(2, iArr, 0);
            this.mFrameBufferTextures = null;
        }
        int[] iArr2 = this.mFrameBuffers;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(2, iArr2, 0);
            this.mFrameBuffers = null;
        }
        int[] iArr3 = this.mSavePictureFrameBufferTextures;
        if (iArr3 != null) {
            GLES20.glDeleteTextures(1, iArr3, 0);
            this.mSavePictureFrameBufferTextures = null;
        }
        int[] iArr4 = this.mSavePictureFrameBuffers;
        if (iArr4 != null) {
            GLES20.glDeleteFramebuffers(1, iArr4, 0);
            this.mSavePictureFrameBuffers = null;
        }
        int[] iArr5 = this.mPointsFrameBuffers;
        if (iArr5 != null) {
            GLES20.glDeleteFramebuffers(1, iArr5, 0);
            this.mPointsFrameBuffers = null;
        }
    }

    public void destroyResizeFrameBuffers() {
        int[] iArr = this.mFrameBufferTexturesResize;
        if (iArr != null) {
            GLES20.glDeleteTextures(2, iArr, 0);
            this.mFrameBufferTexturesResize = null;
        }
        int[] iArr2 = this.mFrameBuffersResize;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(2, iArr2, 0);
            this.mFrameBuffersResize = null;
        }
    }

    public void init(int i, int i2) {
        initInner(i, i2, -1, -1);
    }

    public void init(int i, int i2, int i3, int i4) {
        initInner(i, i2, i3, i4);
    }

    public void initDrawPoints() {
        int a2 = OpenGLUtils.a(DRAW_POINTS_VERTEX_SHADER, DRAW_POINTS_FRAGMENT_SHADER);
        this.mDrawPointsProgram = a2;
        this.mColor = GLES20.glGetAttribLocation(a2, DRAW_POINTS_POSITION);
        this.mPosition = GLES20.glGetUniformLocation(this.mDrawPointsProgram, DRAW_POINTS_COLOR);
        if (this.mPointsFrameBuffers == null) {
            int[] iArr = new int[1];
            this.mPointsFrameBuffers = iArr;
            GLES20.glGenFramebuffers(1, iArr, 0);
        }
    }

    public int onDrawFrame(int i) {
        if (this.mIsInitialized) {
            GLES20.glUseProgram(this.mArrayPrograms.get(1).get(PROGRAM_ID).intValue());
            this.mVertexBuffer.position(0);
            int intValue = this.mArrayPrograms.get(1).get("position").intValue();
            GLES20.glVertexAttribPointer(intValue, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
            GLES20.glEnableVertexAttribArray(intValue);
            this.mGLTextureBuffer.position(0);
            int intValue2 = this.mArrayPrograms.get(1).get(TEXTURE_COORDINATE).intValue();
            GLES20.glVertexAttribPointer(intValue2, 2, 5126, false, 0, (Buffer) this.mGLTextureBuffer);
            GLES20.glEnableVertexAttribArray(intValue2);
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i);
                GLES20.glUniform1i(this.mArrayPrograms.get(1).get(TEXTURE_UNIFORM).intValue(), 0);
            }
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(intValue);
            GLES20.glDisableVertexAttribArray(intValue2);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            return 1;
        }
        return -1;
    }

    public void onDrawPoints(int i, float[] fArr) {
        if (this.mDrawPointsProgram == 0) {
            initDrawPoints();
        }
        GLES20.glUseProgram(this.mDrawPointsProgram);
        GLES20.glUniform4f(this.mColor, 0.0f, 1.0f, 0.0f, 1.0f);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.clear();
        asFloatBuffer.put(fArr).position(0);
        GLES20.glVertexAttribPointer(this.mPosition, 2, 5126, false, 0, (Buffer) asFloatBuffer);
        GLES20.glEnableVertexAttribArray(this.mPosition);
        GLES20.glBindFramebuffer(36160, this.mPointsFrameBuffers[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GlUtil.a("glBindFramebuffer");
        GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
        GLES20.glDrawArrays(0, 0, fArr.length / 2);
        GLES20.glDisableVertexAttribArray(this.mPosition);
        int glGetError = GLES20.glGetError();
        this.glError = glGetError;
        if (glGetError != 0) {
            LogUtils.b(TAG, "CatchGLError : " + this.glError);
        }
    }

    public int preProcess(int i, ByteBuffer byteBuffer) {
        return preProcess(i, byteBuffer, 0);
    }

    public int preProcess(int i, ByteBuffer byteBuffer, int i2) {
        if (this.mFrameBuffers == null || !this.mIsInitialized) {
            return -1;
        }
        GLES20.glUseProgram(this.mArrayPrograms.get(0).get(PROGRAM_ID).intValue());
        GlUtil.a("glUseProgram");
        this.mGLCubeBuffer.position(0);
        int intValue = this.mArrayPrograms.get(0).get("position").intValue();
        GLES20.glVertexAttribPointer(intValue, 2, 5126, false, 0, (Buffer) this.mGLCubeBuffer);
        GLES20.glEnableVertexAttribArray(intValue);
        this.mTextureBuffer.position(0);
        int intValue2 = this.mArrayPrograms.get(0).get(TEXTURE_COORDINATE).intValue();
        GLES20.glVertexAttribPointer(intValue2, 2, 5126, false, 0, (Buffer) this.mTextureBuffer);
        GLES20.glEnableVertexAttribArray(intValue2);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, i);
            GLES20.glUniform1i(this.mArrayPrograms.get(0).get(TEXTURE_UNIFORM).intValue(), 0);
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i2]);
        GlUtil.a("glBindFramebuffer");
        GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
        GLES20.glDrawArrays(5, 0, 4);
        if (byteBuffer != null) {
            if (this.mNeedResize) {
                GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[i2]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTexturesResize[i2], 0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i2]);
                GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[i2]);
                GLES20.glViewport(0, 0, this.mWidthResize, this.mHeightResize);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[i2]);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glReadPixels(0, 0, this.mWidthResize, this.mHeightResize, 6408, 5121, byteBuffer);
                GLES20.glBindFramebuffer(36160, 0);
            } else {
                GLES20.glReadPixels(0, 0, this.mViewPortWidth, this.mViewPortHeight, 6408, 5121, byteBuffer);
            }
        }
        if (this.mNeedResize) {
            GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
        }
        GLES20.glDisableVertexAttribArray(intValue);
        GLES20.glDisableVertexAttribArray(intValue2);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return this.mFrameBufferTextures[i2];
    }

    public void saveTextureToFrameBuffer(int i, ByteBuffer byteBuffer) {
        int[] iArr = this.mSavePictureFrameBuffers;
        if (iArr == null) {
            return;
        }
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
        GLES20.glUseProgram(this.mArrayPrograms.get(1).get(PROGRAM_ID).intValue());
        if (this.mIsInitialized) {
            this.mGLCubeBuffer.position(0);
            int intValue = this.mArrayPrograms.get(1).get("position").intValue();
            GLES20.glVertexAttribPointer(intValue, 2, 5126, false, 0, (Buffer) this.mGLCubeBuffer);
            GLES20.glEnableVertexAttribArray(intValue);
            this.mGLSaveTextureBuffer.position(0);
            int intValue2 = this.mArrayPrograms.get(1).get(TEXTURE_COORDINATE).intValue();
            GLES20.glVertexAttribPointer(intValue2, 2, 5126, false, 0, (Buffer) this.mGLSaveTextureBuffer);
            GLES20.glEnableVertexAttribArray(intValue2);
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i);
                GLES20.glUniform1i(this.mArrayPrograms.get(1).get(TEXTURE_UNIFORM).intValue(), 0);
            }
            GLES20.glDrawArrays(5, 0, 4);
            if (byteBuffer != null) {
                GLES20.glReadPixels(0, 0, this.mViewPortWidth, this.mViewPortHeight, 6408, 5121, byteBuffer);
            }
            GLES20.glDisableVertexAttribArray(intValue);
            GLES20.glDisableVertexAttribArray(intValue2);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }
}
