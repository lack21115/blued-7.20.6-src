package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/n.class */
public class n extends com.tencent.liteav.videobase.a.b {
    private static final String TAG = "TXCGPUWatermarkFilter";
    private int mBaseMarkOffset;
    private a mBaseWaterMark;
    protected boolean mDrawWaterMarkEnabled;
    public a[] mRenderObjects;
    protected int mSrcBlendMode;
    protected List<o> mWaterMarkList;
    private o mWatermark;
    protected static final short[] DRAW_ORDER = {1, 2, 0, 2, 0, 3};
    private static final float[] VERTICES_COORDS = new float[8];
    private static final float[] TEXTURE_COORDS = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    protected static final FloatBuffer TEXTURE_COORDS_BUFFER = (FloatBuffer) ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(TEXTURE_COORDS).asReadOnlyBuffer().position(0);
    protected static final ShortBuffer DRAW_ORDER_BUFFER = (ShortBuffer) ByteBuffer.allocateDirect(DRAW_ORDER.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(DRAW_ORDER).asReadOnlyBuffer().position(0);

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/n$a.class */
    public static final class a {
        public Bitmap b;

        /* renamed from: a  reason: collision with root package name */
        public FloatBuffer f36395a = null;

        /* renamed from: c  reason: collision with root package name */
        public int f36396c = -1;

        public final void a() {
            this.b = null;
            OpenGlUtils.deleteTexture(this.f36396c);
            this.f36396c = -1;
        }
    }

    public n() {
        this(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public n(String str, String str2) {
        super(str, str2);
        this.mRenderObjects = null;
        this.mBaseWaterMark = null;
        this.mWaterMarkList = null;
        this.mDrawWaterMarkEnabled = false;
        this.mSrcBlendMode = 1;
        this.mBaseMarkOffset = 1;
        this.mWatermark = null;
    }

    private boolean compareWaterMarkList(List<o> list, List<o> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return true;
            }
            o oVar = list.get(i2);
            o oVar2 = list2.get(i2);
            if (!oVar.f36397a.equals(oVar2.f36397a) || oVar.b != oVar2.b || oVar.f36398c != oVar2.f36398c || oVar.d != oVar2.d) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private void releaseWaterMark() {
        a[] aVarArr = this.mRenderObjects;
        if (aVarArr == null || aVarArr.length == 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            a[] aVarArr2 = this.mRenderObjects;
            if (i2 >= aVarArr2.length) {
                this.mRenderObjects = null;
                return;
            }
            if (aVarArr2[i2] != null) {
                aVarArr2[i2].a();
                this.mRenderObjects[i2] = null;
            }
            i = i2 + 1;
        }
    }

    private void setWatermark(Bitmap bitmap, float f, float f2, float f3, int i) {
        a[] aVarArr = this.mRenderObjects;
        if (aVarArr == null || i >= aVarArr.length || aVarArr[i] == null) {
            LiteavLog.e(TAG, "index is too large for mRenderObjects!");
        } else if (bitmap == null) {
            LiteavLog.i(TAG, "release %d watermark!", Integer.valueOf(i));
            this.mRenderObjects[i].a();
            this.mRenderObjects[i] = null;
        } else {
            calculateOffsetMatrix(bitmap.getWidth(), bitmap.getHeight(), f, f2, f3, i);
            a aVar = this.mRenderObjects[i];
            if (aVar.b == null || !aVar.b.equals(bitmap)) {
                if (aVar.f36396c != -1 && aVar.b != null && (aVar.b.getWidth() != bitmap.getWidth() || aVar.b.getHeight() != bitmap.getHeight())) {
                    OpenGlUtils.deleteTexture(aVar.f36396c);
                    aVar.f36396c = -1;
                }
                aVar.f36396c = OpenGlUtils.loadTexture(bitmap, aVar.f36396c, false);
            }
            aVar.b = bitmap;
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void afterDrawArrays() {
        super.afterDrawArrays();
        if (!this.mDrawWaterMarkEnabled) {
            return;
        }
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(this.mSrcBlendMode, 771);
        int i = 0;
        while (true) {
            int i2 = i;
            a[] aVarArr = this.mRenderObjects;
            if (i2 >= aVarArr.length) {
                GLES20.glDisable(3042);
                return;
            }
            if (aVarArr[i2] != null) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.mRenderObjects[i2].f36396c);
                GLES20.glUniform1i(this.mGLUniformTexture, 0);
                GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 8, (Buffer) this.mRenderObjects[i2].f36395a);
                GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
                GLES20.glVertexAttribPointer(this.mGLAttribTextureCoord, 2, 5126, false, 0, (Buffer) TEXTURE_COORDS_BUFFER);
                GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoord);
                GLES20.glDrawElements(4, DRAW_ORDER.length, 5123, DRAW_ORDER_BUFFER);
                GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
                GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoord);
            }
            i = i2 + 1;
        }
    }

    public void calculateOffsetMatrix(int i, int i2, float f, float f2, float f3, int i3) {
        a[] aVarArr = this.mRenderObjects;
        if (aVarArr == null || i3 >= aVarArr.length || aVarArr[i3] == null) {
            LiteavLog.e(TAG, "calculateOffsetMatrix,index[%d],mRenderObjects=%s", Integer.valueOf(i3), Arrays.toString(this.mRenderObjects));
            return;
        }
        aVarArr[i3].f36395a = ByteBuffer.allocateDirect(VERTICES_COORDS.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        float[] fArr = new float[VERTICES_COORDS.length];
        fArr[0] = (f * 2.0f) - 1.0f;
        fArr[1] = 1.0f - (f2 * 2.0f);
        fArr[2] = fArr[0];
        fArr[3] = fArr[1] - (((((i2 / i) * f3) * this.mOutputSize.f36340a) / this.mOutputSize.b) * 2.0f);
        fArr[4] = fArr[0] + (f3 * 2.0f);
        fArr[5] = fArr[3];
        fArr[6] = fArr[4];
        fArr[7] = fArr[1];
        int i4 = 1;
        while (true) {
            int i5 = i4;
            if (i5 > 7) {
                this.mRenderObjects[i3].f36395a.put(fArr).position(0);
                return;
            } else {
                fArr[i5] = fArr[i5] * (-1.0f);
                i4 = i5 + 2;
            }
        }
    }

    public void enableWatermark(boolean z) {
        this.mDrawWaterMarkEnabled = z;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        o oVar = this.mWatermark;
        if (oVar != null) {
            setWatermark(oVar.f36397a, this.mWatermark.b, this.mWatermark.f36398c, this.mWatermark.d);
        }
        List<o> list = this.mWaterMarkList;
        if (list != null) {
            setWaterMarkList(list);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        LiteavLog.i(TAG, "onOutputSizeChanged,width=%d,height=%d", Integer.valueOf(i), Integer.valueOf(i2));
        super.onOutputSizeChanged(i, i2);
        if (this.mRenderObjects == null) {
            return;
        }
        o oVar = this.mWatermark;
        if (oVar != null && oVar.f36397a != null) {
            calculateOffsetMatrix(this.mWatermark.f36397a.getWidth(), this.mWatermark.f36397a.getHeight(), this.mWatermark.b, this.mWatermark.f36398c, this.mWatermark.d, 0);
        }
        if (this.mWaterMarkList == null) {
            return;
        }
        for (int i3 = 0; i3 < this.mWaterMarkList.size(); i3++) {
            o oVar2 = this.mWaterMarkList.get(i3);
            if (oVar2 != null && oVar2.f36397a != null) {
                calculateOffsetMatrix(oVar2.f36397a.getWidth(), oVar2.f36397a.getHeight(), oVar2.b, oVar2.f36398c, oVar2.d, i3 + this.mBaseMarkOffset);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        releaseWaterMark();
    }

    public void setWaterMarkList(List<o> list) {
        List<o> list2 = this.mWaterMarkList;
        if (list2 != null && compareWaterMarkList(list2, list)) {
            LiteavLog.i(TAG, "Same markList");
            return;
        }
        this.mWaterMarkList = list;
        if (this.mRenderObjects != null) {
            int i = this.mBaseMarkOffset;
            while (true) {
                int i2 = i;
                a[] aVarArr = this.mRenderObjects;
                if (i2 >= aVarArr.length) {
                    break;
                }
                OpenGlUtils.deleteTexture(aVarArr[i2].f36396c);
                this.mRenderObjects[i2].f36396c = -1;
                i = i2 + 1;
            }
        }
        a[] aVarArr2 = new a[list.size() + this.mBaseMarkOffset];
        this.mRenderObjects = aVarArr2;
        aVarArr2[0] = this.mBaseWaterMark;
        for (int i3 = 0; i3 < list.size(); i3++) {
            o oVar = list.get(i3);
            if (oVar != null) {
                this.mRenderObjects[this.mBaseMarkOffset + i3] = new a();
                setWatermark(oVar.f36397a, oVar.b, oVar.f36398c, oVar.d, i3 + this.mBaseMarkOffset);
            }
        }
    }

    public void setWatermark(Bitmap bitmap, float f, float f2, float f3) {
        if (this.mRenderObjects == null) {
            this.mRenderObjects = new a[1];
        }
        a[] aVarArr = this.mRenderObjects;
        if (aVarArr[0] == null) {
            aVarArr[0] = new a();
        }
        setWatermark(bitmap, f, f2, f3, 0);
        this.mBaseWaterMark = this.mRenderObjects[0];
        if (bitmap == null) {
            this.mWatermark = null;
            return;
        }
        if (this.mWatermark == null) {
            this.mWatermark = new o();
        }
        this.mWatermark.f36397a = bitmap;
        this.mWatermark.b = f;
        this.mWatermark.f36398c = f2;
        this.mWatermark.d = f3;
    }
}
