package android.opengl;

import android.media.MediaFormat;
import android.os.BatteryManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.bc;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import javax.microedition.khronos.opengles.GL;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/opengl/GLLogWrapper.class */
public class GLLogWrapper extends GLWrapperBase {
    private static final int FORMAT_FIXED = 2;
    private static final int FORMAT_FLOAT = 1;
    private static final int FORMAT_INT = 0;
    private int mArgCount;
    boolean mColorArrayEnabled;
    private PointerInfo mColorPointer;
    private Writer mLog;
    private boolean mLogArgumentNames;
    boolean mNormalArrayEnabled;
    private PointerInfo mNormalPointer;
    StringBuilder mStringBuilder;
    private PointerInfo mTexCoordPointer;
    boolean mTextureCoordArrayEnabled;
    boolean mVertexArrayEnabled;
    private PointerInfo mVertexPointer;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/opengl/GLLogWrapper$PointerInfo.class */
    public class PointerInfo {
        public Buffer mPointer;
        public int mSize;
        public int mStride;
        public ByteBuffer mTempByteBuffer;
        public int mType;

        public PointerInfo() {
        }

        public PointerInfo(int i, int i2, int i3, Buffer buffer) {
            this.mSize = i;
            this.mType = i2;
            this.mStride = i3;
            this.mPointer = buffer;
        }

        public void bindByteBuffer() {
            this.mTempByteBuffer = this.mPointer == null ? null : GLLogWrapper.this.toByteBuffer(-1, this.mPointer);
        }

        public int getStride() {
            return this.mStride > 0 ? this.mStride : sizeof(this.mType) * this.mSize;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public int sizeof(int i) {
            int i2 = 1;
            switch (i) {
                case 5120:
                case 5121:
                    break;
                case 5122:
                    return 2;
                case 5126:
                    return 4;
                case 5132:
                    return 4;
                default:
                    i2 = 0;
                    break;
            }
            return i2;
        }

        public void unbindByteBuffer() {
            this.mTempByteBuffer = null;
        }
    }

    public GLLogWrapper(GL gl, Writer writer, boolean z) {
        super(gl);
        this.mColorPointer = new PointerInfo();
        this.mNormalPointer = new PointerInfo();
        this.mTexCoordPointer = new PointerInfo();
        this.mVertexPointer = new PointerInfo();
        this.mLog = writer;
        this.mLogArgumentNames = z;
    }

    private void arg(String str, float f) {
        arg(str, Float.toString(f));
    }

    private void arg(String str, int i) {
        arg(str, Integer.toString(i));
    }

    private void arg(String str, int i, FloatBuffer floatBuffer) {
        arg(str, toString(i, floatBuffer));
    }

    private void arg(String str, int i, IntBuffer intBuffer) {
        arg(str, toString(i, 0, intBuffer));
    }

    private void arg(String str, int i, ShortBuffer shortBuffer) {
        arg(str, toString(i, shortBuffer));
    }

    private void arg(String str, int i, float[] fArr, int i2) {
        arg(str, toString(i, fArr, i2));
    }

    private void arg(String str, int i, int[] iArr, int i2) {
        arg(str, toString(i, 0, iArr, i2));
    }

    private void arg(String str, int i, short[] sArr, int i2) {
        arg(str, toString(i, sArr, i2));
    }

    private void arg(String str, String str2) {
        int i = this.mArgCount;
        this.mArgCount = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.mLogArgumentNames) {
            log(str + "=");
        }
        log(str2);
    }

    private void arg(String str, boolean z) {
        arg(str, Boolean.toString(z));
    }

    private void argPointer(int i, int i2, int i3, Buffer buffer) {
        arg(OapsKey.KEY_SIZE, i);
        arg("type", getPointerTypeName(i2));
        arg(MediaFormat.KEY_STRIDE, i3);
        arg("pointer", buffer.toString());
    }

    private void begin(String str) {
        log(str + '(');
        this.mArgCount = 0;
    }

    private void bindArrays() {
        if (this.mColorArrayEnabled) {
            this.mColorPointer.bindByteBuffer();
        }
        if (this.mNormalArrayEnabled) {
            this.mNormalPointer.bindByteBuffer();
        }
        if (this.mTextureCoordArrayEnabled) {
            this.mTexCoordPointer.bindByteBuffer();
        }
        if (this.mVertexArrayEnabled) {
            this.mVertexPointer.bindByteBuffer();
        }
    }

    private void checkError() {
        int glGetError = this.mgl.glGetError();
        if (glGetError != 0) {
            logLine("glError: " + Integer.toString(glGetError));
        }
    }

    private void doArrayElement(StringBuilder sb, boolean z, String str, PointerInfo pointerInfo, int i) {
        if (!z) {
            return;
        }
        sb.append(" ");
        sb.append(str + ":{");
        if (pointerInfo == null || pointerInfo.mTempByteBuffer == null) {
            sb.append("undefined }");
        } else if (pointerInfo.mStride < 0) {
            sb.append("invalid stride");
        } else {
            int stride = pointerInfo.getStride();
            ByteBuffer byteBuffer = pointerInfo.mTempByteBuffer;
            int i2 = pointerInfo.mSize;
            int i3 = pointerInfo.mType;
            int sizeof = pointerInfo.sizeof(i3);
            int i4 = stride * i;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= i2) {
                    sb.append("}");
                    return;
                }
                if (i6 > 0) {
                    sb.append(", ");
                }
                switch (i3) {
                    case 5120:
                        sb.append(Integer.toString(byteBuffer.get(i4)));
                        break;
                    case 5121:
                        sb.append(Integer.toString(byteBuffer.get(i4) & 255));
                        break;
                    case 5122:
                        sb.append(Integer.toString(byteBuffer.asShortBuffer().get(i4 / 2)));
                        break;
                    case 5126:
                        sb.append(Float.toString(byteBuffer.asFloatBuffer().get(i4 / 4)));
                        break;
                    case 5132:
                        sb.append(Integer.toString(byteBuffer.asIntBuffer().get(i4 / 4)));
                        break;
                    default:
                        sb.append("?");
                        break;
                }
                i4 += sizeof;
                i5 = i6 + 1;
            }
        }
    }

    private void doElement(StringBuilder sb, int i, int i2) {
        sb.append(" [" + i + " : " + i2 + "] =");
        doArrayElement(sb, this.mVertexArrayEnabled, "v", this.mVertexPointer, i2);
        doArrayElement(sb, this.mNormalArrayEnabled, "n", this.mNormalPointer, i2);
        doArrayElement(sb, this.mColorArrayEnabled, "c", this.mColorPointer, i2);
        doArrayElement(sb, this.mTextureCoordArrayEnabled, "t", this.mTexCoordPointer, i2);
        sb.append("\n");
    }

    private void end() {
        log(");\n");
        flush();
    }

    private void endLogIndices() {
        log(this.mStringBuilder.toString());
        unbindArrays();
    }

    private void flush() {
        try {
            this.mLog.flush();
        } catch (IOException e) {
            this.mLog = null;
        }
    }

    private void formattedAppend(StringBuilder sb, int i, int i2) {
        switch (i2) {
            case 0:
                sb.append(i);
                return;
            case 1:
                sb.append(Float.intBitsToFloat(i));
                return;
            case 2:
                sb.append(i / 65536.0f);
                return;
            default:
                return;
        }
    }

    private String getBeginMode(int i) {
        switch (i) {
            case 0:
                return "GL_POINTS";
            case 1:
                return "GL_LINES";
            case 2:
                return "GL_LINE_LOOP";
            case 3:
                return "GL_LINE_STRIP";
            case 4:
                return "GL_TRIANGLES";
            case 5:
                return "GL_TRIANGLE_STRIP";
            case 6:
                return "GL_TRIANGLE_FAN";
            default:
                return getHex(i);
        }
    }

    private String getCap(int i) {
        switch (i) {
            case GLES10.GL_POINT_SMOOTH /* 2832 */:
                return "GL_POINT_SMOOTH";
            case GLES10.GL_LINE_SMOOTH /* 2848 */:
                return "GL_LINE_SMOOTH";
            case 2884:
                return "GL_CULL_FACE";
            case GLES10.GL_LIGHTING /* 2896 */:
                return "GL_LIGHTING";
            case GLES10.GL_COLOR_MATERIAL /* 2903 */:
                return "GL_COLOR_MATERIAL";
            case GLES10.GL_FOG /* 2912 */:
                return "GL_FOG";
            case 2929:
                return "GL_DEPTH_TEST";
            case 2960:
                return "GL_STENCIL_TEST";
            case GLES10.GL_NORMALIZE /* 2977 */:
                return "GL_NORMALIZE";
            case 3008:
                return "GL_ALPHA_TEST";
            case 3024:
                return "GL_DITHER";
            case 3042:
                return "GL_BLEND";
            case GLES10.GL_COLOR_LOGIC_OP /* 3058 */:
                return "GL_COLOR_LOGIC_OP";
            case 3089:
                return "GL_SCISSOR_TEST";
            case 3553:
                return "GL_TEXTURE_2D";
            case 16384:
                return "GL_LIGHT0";
            case 16385:
                return "GL_LIGHT1";
            case 16386:
                return "GL_LIGHT2";
            case 16387:
                return "GL_LIGHT3";
            case 16388:
                return "GL_LIGHT4";
            case 16389:
                return "GL_LIGHT5";
            case 16390:
                return "GL_LIGHT6";
            case 16391:
                return "GL_LIGHT7";
            case GLES10.GL_RESCALE_NORMAL /* 32826 */:
                return "GL_RESCALE_NORMAL";
            case 32884:
                return "GL_VERTEX_ARRAY";
            case GLES10.GL_NORMAL_ARRAY /* 32885 */:
                return "GL_NORMAL_ARRAY";
            case GLES10.GL_COLOR_ARRAY /* 32886 */:
                return "GL_COLOR_ARRAY";
            case GLES10.GL_TEXTURE_COORD_ARRAY /* 32888 */:
                return "GL_TEXTURE_COORD_ARRAY";
            case GLES10.GL_MULTISAMPLE /* 32925 */:
                return "GL_MULTISAMPLE";
            case 32926:
                return "GL_SAMPLE_ALPHA_TO_COVERAGE";
            case GLES10.GL_SAMPLE_ALPHA_TO_ONE /* 32927 */:
                return "GL_SAMPLE_ALPHA_TO_ONE";
            case 32928:
                return "GL_SAMPLE_COVERAGE";
            default:
                return getHex(i);
        }
    }

    private String getClearBufferMask(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i;
        if ((i & 256) != 0) {
            sb.append("GL_DEPTH_BUFFER_BIT");
            i2 = i & (-257);
        }
        int i3 = i2;
        if ((i2 & 1024) != 0) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append("GL_STENCIL_BUFFER_BIT");
            i3 = i2 & (-1025);
        }
        int i4 = i3;
        if ((i3 & 16384) != 0) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append("GL_COLOR_BUFFER_BIT");
            i4 = i3 & (-16385);
        }
        if (i4 != 0) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(getHex(i4));
        }
        return sb.toString();
    }

    private String getClientState(int i) {
        switch (i) {
            case 32884:
                return "GL_VERTEX_ARRAY";
            case GLES10.GL_NORMAL_ARRAY /* 32885 */:
                return "GL_NORMAL_ARRAY";
            case GLES10.GL_COLOR_ARRAY /* 32886 */:
                return "GL_COLOR_ARRAY";
            case 32887:
            default:
                return getHex(i);
            case GLES10.GL_TEXTURE_COORD_ARRAY /* 32888 */:
                return "GL_TEXTURE_COORD_ARRAY";
        }
    }

    public static String getErrorString(int i) {
        switch (i) {
            case 0:
                return "GL_NO_ERROR";
            case 1280:
                return "GL_INVALID_ENUM";
            case 1281:
                return "GL_INVALID_VALUE";
            case 1282:
                return "GL_INVALID_OPERATION";
            case 1283:
                return "GL_STACK_OVERFLOW";
            case 1284:
                return "GL_STACK_UNDERFLOW";
            case 1285:
                return "GL_OUT_OF_MEMORY";
            default:
                return getHex(i);
        }
    }

    private String getFaceName(int i) {
        switch (i) {
            case 1032:
                return "GL_FRONT_AND_BACK";
            default:
                return getHex(i);
        }
    }

    private String getFactor(int i) {
        switch (i) {
            case 0:
                return "GL_ZERO";
            case 1:
                return "GL_ONE";
            case 768:
                return "GL_SRC_COLOR";
            case 769:
                return "GL_ONE_MINUS_SRC_COLOR";
            case 770:
                return "GL_SRC_ALPHA";
            case 771:
                return "GL_ONE_MINUS_SRC_ALPHA";
            case 772:
                return "GL_DST_ALPHA";
            case 773:
                return "GL_ONE_MINUS_DST_ALPHA";
            case 774:
                return "GL_DST_COLOR";
            case 775:
                return "GL_ONE_MINUS_DST_COLOR";
            case 776:
                return "GL_SRC_ALPHA_SATURATE";
            default:
                return getHex(i);
        }
    }

    private String getFogPName(int i) {
        switch (i) {
            case GLES10.GL_FOG_DENSITY /* 2914 */:
                return "GL_FOG_DENSITY";
            case GLES10.GL_FOG_START /* 2915 */:
                return "GL_FOG_START";
            case GLES10.GL_FOG_END /* 2916 */:
                return "GL_FOG_END";
            case GLES10.GL_FOG_MODE /* 2917 */:
                return "GL_FOG_MODE";
            case GLES10.GL_FOG_COLOR /* 2918 */:
                return "GL_FOG_COLOR";
            default:
                return getHex(i);
        }
    }

    private int getFogParamCount(int i) {
        int i2 = 1;
        switch (i) {
            case GLES10.GL_FOG_DENSITY /* 2914 */:
            case GLES10.GL_FOG_START /* 2915 */:
            case GLES10.GL_FOG_END /* 2916 */:
            case GLES10.GL_FOG_MODE /* 2917 */:
                break;
            case GLES10.GL_FOG_COLOR /* 2918 */:
                return 4;
            default:
                i2 = 0;
                break;
        }
        return i2;
    }

    private static String getHex(int i) {
        return "0x" + Integer.toHexString(i);
    }

    private String getHintMode(int i) {
        switch (i) {
            case 4352:
                return "GL_DONT_CARE";
            case 4353:
                return "GL_FASTEST";
            case 4354:
                return "GL_NICEST";
            default:
                return getHex(i);
        }
    }

    private String getHintTarget(int i) {
        switch (i) {
            case GLES10.GL_PERSPECTIVE_CORRECTION_HINT /* 3152 */:
                return "GL_PERSPECTIVE_CORRECTION_HINT";
            case GLES10.GL_POINT_SMOOTH_HINT /* 3153 */:
                return "GL_POINT_SMOOTH_HINT";
            case GLES10.GL_LINE_SMOOTH_HINT /* 3154 */:
                return "GL_LINE_SMOOTH_HINT";
            case GLES10.GL_POLYGON_SMOOTH_HINT /* 3155 */:
                return "GL_POLYGON_SMOOTH_HINT";
            case GLES10.GL_FOG_HINT /* 3156 */:
                return "GL_FOG_HINT";
            case 33170:
                return "GL_GENERATE_MIPMAP_HINT";
            default:
                return getHex(i);
        }
    }

    private String getIndexType(int i) {
        switch (i) {
            case 5121:
                return "GL_UNSIGNED_BYTE";
            case 5122:
            default:
                return getHex(i);
            case 5123:
                return "GL_UNSIGNED_SHORT";
        }
    }

    private int getIntegerStateFormat(int i) {
        switch (i) {
            case 35213:
            case 35214:
            case 35215:
                return 1;
            default:
                return 0;
        }
    }

    private String getIntegerStateName(int i) {
        switch (i) {
            case GLES10.GL_SMOOTH_POINT_SIZE_RANGE /* 2834 */:
                return "GL_SMOOTH_POINT_SIZE_RANGE";
            case GLES10.GL_SMOOTH_LINE_WIDTH_RANGE /* 2850 */:
                return "GL_SMOOTH_LINE_WIDTH_RANGE";
            case GLES10.GL_MAX_LIGHTS /* 3377 */:
                return "GL_MAX_LIGHTS";
            case 3379:
                return "GL_MAX_TEXTURE_SIZE";
            case GLES10.GL_MAX_MODELVIEW_STACK_DEPTH /* 3382 */:
                return "GL_MAX_MODELVIEW_STACK_DEPTH";
            case GLES10.GL_MAX_PROJECTION_STACK_DEPTH /* 3384 */:
                return "GL_MAX_PROJECTION_STACK_DEPTH";
            case GLES10.GL_MAX_TEXTURE_STACK_DEPTH /* 3385 */:
                return "GL_MAX_TEXTURE_STACK_DEPTH";
            case 3386:
                return "GL_MAX_VIEWPORT_DIMS";
            case 3408:
                return "GL_SUBPIXEL_BITS";
            case 3410:
                return "GL_RED_BITS";
            case 3411:
                return "GL_GREEN_BITS";
            case 3412:
                return "GL_BLUE_BITS";
            case 3413:
                return "GL_ALPHA_BITS";
            case 3414:
                return "GL_DEPTH_BITS";
            case 3415:
                return "GL_STENCIL_BITS";
            case 33000:
                return "GL_MAX_ELEMENTS_VERTICES";
            case 33001:
                return "GL_MAX_ELEMENTS_INDICES";
            case 33901:
                return "GL_ALIASED_POINT_SIZE_RANGE";
            case 33902:
                return "GL_ALIASED_LINE_WIDTH_RANGE";
            case GLES10.GL_MAX_TEXTURE_UNITS /* 34018 */:
                return "GL_MAX_TEXTURE_UNITS";
            case 34466:
                return "GL_NUM_COMPRESSED_TEXTURE_FORMATS";
            case 34467:
                return "GL_COMPRESSED_TEXTURE_FORMATS";
            case 35213:
                return "GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES";
            case 35214:
                return "GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES";
            case 35215:
                return "GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES";
            default:
                return getHex(i);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getIntegerStateSize(int i) {
        int i2 = 1;
        switch (i) {
            case GLES10.GL_SMOOTH_POINT_SIZE_RANGE /* 2834 */:
                return 2;
            case GLES10.GL_SMOOTH_LINE_WIDTH_RANGE /* 2850 */:
                return 2;
            case GLES10.GL_MAX_LIGHTS /* 3377 */:
            case 3379:
            case GLES10.GL_MAX_MODELVIEW_STACK_DEPTH /* 3382 */:
            case GLES10.GL_MAX_PROJECTION_STACK_DEPTH /* 3384 */:
            case GLES10.GL_MAX_TEXTURE_STACK_DEPTH /* 3385 */:
            case 3408:
            case 3410:
            case 3411:
            case 3412:
            case 3413:
            case 3414:
            case 3415:
            case 33000:
            case 33001:
            case GLES10.GL_MAX_TEXTURE_UNITS /* 34018 */:
            case 34466:
                break;
            case 3386:
                return 2;
            case 33901:
                return 2;
            case 33902:
                return 2;
            case 34467:
                int[] iArr = new int[1];
                this.mgl.glGetIntegerv(34466, iArr, 0);
                return iArr[0];
            case 35213:
            case 35214:
            case 35215:
                return 16;
            default:
                i2 = 0;
                break;
        }
        return i2;
    }

    private String getLightModelPName(int i) {
        switch (i) {
            case GLES10.GL_LIGHT_MODEL_TWO_SIDE /* 2898 */:
                return "GL_LIGHT_MODEL_TWO_SIDE";
            case GLES10.GL_LIGHT_MODEL_AMBIENT /* 2899 */:
                return "GL_LIGHT_MODEL_AMBIENT";
            default:
                return getHex(i);
        }
    }

    private int getLightModelParamCount(int i) {
        switch (i) {
            case GLES10.GL_LIGHT_MODEL_TWO_SIDE /* 2898 */:
                return 1;
            case GLES10.GL_LIGHT_MODEL_AMBIENT /* 2899 */:
                return 4;
            default:
                return 0;
        }
    }

    private String getLightName(int i) {
        return (i < 16384 || i > 16391) ? getHex(i) : "GL_LIGHT" + Integer.toString(i);
    }

    private String getLightPName(int i) {
        switch (i) {
            case GLES10.GL_AMBIENT /* 4608 */:
                return "GL_AMBIENT";
            case GLES10.GL_DIFFUSE /* 4609 */:
                return "GL_DIFFUSE";
            case GLES10.GL_SPECULAR /* 4610 */:
                return "GL_SPECULAR";
            case GLES10.GL_POSITION /* 4611 */:
                return "GL_POSITION";
            case GLES10.GL_SPOT_DIRECTION /* 4612 */:
                return "GL_SPOT_DIRECTION";
            case GLES10.GL_SPOT_EXPONENT /* 4613 */:
                return "GL_SPOT_EXPONENT";
            case GLES10.GL_SPOT_CUTOFF /* 4614 */:
                return "GL_SPOT_CUTOFF";
            case GLES10.GL_CONSTANT_ATTENUATION /* 4615 */:
                return "GL_CONSTANT_ATTENUATION";
            case GLES10.GL_LINEAR_ATTENUATION /* 4616 */:
                return "GL_LINEAR_ATTENUATION";
            case GLES10.GL_QUADRATIC_ATTENUATION /* 4617 */:
                return "GL_QUADRATIC_ATTENUATION";
            default:
                return getHex(i);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getLightParamCount(int i) {
        int i2 = 4;
        switch (i) {
            case GLES10.GL_AMBIENT /* 4608 */:
            case GLES10.GL_DIFFUSE /* 4609 */:
            case GLES10.GL_SPECULAR /* 4610 */:
            case GLES10.GL_POSITION /* 4611 */:
                break;
            case GLES10.GL_SPOT_DIRECTION /* 4612 */:
                return 3;
            case GLES10.GL_SPOT_EXPONENT /* 4613 */:
                return 1;
            case GLES10.GL_SPOT_CUTOFF /* 4614 */:
                return 1;
            case GLES10.GL_CONSTANT_ATTENUATION /* 4615 */:
                return 1;
            case GLES10.GL_LINEAR_ATTENUATION /* 4616 */:
                return 1;
            case GLES10.GL_QUADRATIC_ATTENUATION /* 4617 */:
                return 1;
            default:
                i2 = 0;
                break;
        }
        return i2;
    }

    private String getMaterialPName(int i) {
        switch (i) {
            case GLES10.GL_AMBIENT /* 4608 */:
                return "GL_AMBIENT";
            case GLES10.GL_DIFFUSE /* 4609 */:
                return "GL_DIFFUSE";
            case GLES10.GL_SPECULAR /* 4610 */:
                return "GL_SPECULAR";
            case GLES10.GL_EMISSION /* 5632 */:
                return "GL_EMISSION";
            case GLES10.GL_SHININESS /* 5633 */:
                return "GL_SHININESS";
            case GLES10.GL_AMBIENT_AND_DIFFUSE /* 5634 */:
                return "GL_AMBIENT_AND_DIFFUSE";
            default:
                return getHex(i);
        }
    }

    private int getMaterialParamCount(int i) {
        int i2 = 4;
        switch (i) {
            case GLES10.GL_AMBIENT /* 4608 */:
            case GLES10.GL_DIFFUSE /* 4609 */:
            case GLES10.GL_SPECULAR /* 4610 */:
            case GLES10.GL_EMISSION /* 5632 */:
            case GLES10.GL_AMBIENT_AND_DIFFUSE /* 5634 */:
                break;
            case GLES10.GL_SHININESS /* 5633 */:
                return 1;
            default:
                i2 = 0;
                break;
        }
        return i2;
    }

    private String getMatrixMode(int i) {
        switch (i) {
            case GLES10.GL_MODELVIEW /* 5888 */:
                return "GL_MODELVIEW";
            case GLES10.GL_PROJECTION /* 5889 */:
                return "GL_PROJECTION";
            case 5890:
                return "GL_TEXTURE";
            default:
                return getHex(i);
        }
    }

    private String getPointerTypeName(int i) {
        switch (i) {
            case 5120:
                return "GL_BYTE";
            case 5121:
                return "GL_UNSIGNED_BYTE";
            case 5122:
                return "GL_SHORT";
            case 5126:
                return "GL_FLOAT";
            case 5132:
                return "GL_FIXED";
            default:
                return getHex(i);
        }
    }

    private String getShadeModel(int i) {
        switch (i) {
            case GLES10.GL_FLAT /* 7424 */:
                return "GL_FLAT";
            case GLES10.GL_SMOOTH /* 7425 */:
                return "GL_SMOOTH";
            default:
                return getHex(i);
        }
    }

    private String getTextureEnvPName(int i) {
        switch (i) {
            case GLES10.GL_TEXTURE_ENV_MODE /* 8704 */:
                return "GL_TEXTURE_ENV_MODE";
            case GLES10.GL_TEXTURE_ENV_COLOR /* 8705 */:
                return "GL_TEXTURE_ENV_COLOR";
            default:
                return getHex(i);
        }
    }

    private int getTextureEnvParamCount(int i) {
        switch (i) {
            case GLES10.GL_TEXTURE_ENV_MODE /* 8704 */:
                return 1;
            case GLES10.GL_TEXTURE_ENV_COLOR /* 8705 */:
                return 4;
            default:
                return 0;
        }
    }

    private String getTextureEnvParamName(float f) {
        int i = (int) f;
        if (f == i) {
            switch (i) {
                case 260:
                    return "GL_ADD";
                case 3042:
                    return "GL_BLEND";
                case 7681:
                    return "GL_REPLACE";
                case 8448:
                    return "GL_MODULATE";
                case GLES10.GL_DECAL /* 8449 */:
                    return "GL_DECAL";
                case GLES11.GL_COMBINE /* 34160 */:
                    return "GL_COMBINE";
                default:
                    return getHex(i);
            }
        }
        return Float.toString(f);
    }

    private String getTextureEnvTarget(int i) {
        switch (i) {
            case GLES10.GL_TEXTURE_ENV /* 8960 */:
                return "GL_TEXTURE_ENV";
            default:
                return getHex(i);
        }
    }

    private String getTexturePName(int i) {
        switch (i) {
            case 10240:
                return "GL_TEXTURE_MAG_FILTER";
            case 10241:
                return "GL_TEXTURE_MIN_FILTER";
            case 10242:
                return "GL_TEXTURE_WRAP_S";
            case 10243:
                return "GL_TEXTURE_WRAP_T";
            case GLES11.GL_GENERATE_MIPMAP /* 33169 */:
                return "GL_GENERATE_MIPMAP";
            case GLES11Ext.GL_TEXTURE_CROP_RECT_OES /* 35741 */:
                return "GL_TEXTURE_CROP_RECT_OES";
            default:
                return getHex(i);
        }
    }

    private String getTextureParamName(float f) {
        int i = (int) f;
        if (f == i) {
            switch (i) {
                case 9728:
                    return "GL_NEAREST";
                case 9729:
                    return "GL_LINEAR";
                case 9984:
                    return "GL_NEAREST_MIPMAP_NEAREST";
                case 9985:
                    return "GL_LINEAR_MIPMAP_NEAREST";
                case 9986:
                    return "GL_NEAREST_MIPMAP_LINEAR";
                case 9987:
                    return "GL_LINEAR_MIPMAP_LINEAR";
                case 10497:
                    return "GL_REPEAT";
                case 33071:
                    return "GL_CLAMP_TO_EDGE";
                default:
                    return getHex(i);
            }
        }
        return Float.toString(f);
    }

    private String getTextureTarget(int i) {
        switch (i) {
            case 3553:
                return "GL_TEXTURE_2D";
            default:
                return getHex(i);
        }
    }

    private void log(String str) {
        try {
            this.mLog.write(str);
        } catch (IOException e) {
        }
    }

    private void logLine(String str) {
        log(str + '\n');
    }

    private void returns(int i) {
        returns(Integer.toString(i));
    }

    private void returns(String str) {
        log(") returns " + str + ";\n");
        flush();
    }

    private void startLogIndices() {
        this.mStringBuilder = new StringBuilder();
        this.mStringBuilder.append("\n");
        bindArrays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ByteBuffer toByteBuffer(int i, Buffer buffer) {
        ByteBuffer order;
        boolean z = i < 0;
        if (buffer instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) buffer;
            int position = byteBuffer.position();
            if (z) {
                i = byteBuffer.limit() - position;
            }
            order = ByteBuffer.allocate(i).order(byteBuffer.order());
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                order.put(byteBuffer.get());
                i2 = i3 + 1;
            }
            byteBuffer.position(position);
        } else if (buffer instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) buffer;
            int position2 = charBuffer.position();
            if (z) {
                i = (charBuffer.limit() - position2) * 2;
            }
            order = ByteBuffer.allocate(i).order(charBuffer.order());
            CharBuffer asCharBuffer = order.asCharBuffer();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i / 2) {
                    break;
                }
                asCharBuffer.put(charBuffer.get());
                i4 = i5 + 1;
            }
            charBuffer.position(position2);
        } else if (buffer instanceof ShortBuffer) {
            ShortBuffer shortBuffer = (ShortBuffer) buffer;
            int position3 = shortBuffer.position();
            if (z) {
                i = (shortBuffer.limit() - position3) * 2;
            }
            order = ByteBuffer.allocate(i).order(shortBuffer.order());
            ShortBuffer asShortBuffer = order.asShortBuffer();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= i / 2) {
                    break;
                }
                asShortBuffer.put(shortBuffer.get());
                i6 = i7 + 1;
            }
            shortBuffer.position(position3);
        } else if (buffer instanceof IntBuffer) {
            IntBuffer intBuffer = (IntBuffer) buffer;
            int position4 = intBuffer.position();
            if (z) {
                i = (intBuffer.limit() - position4) * 4;
            }
            order = ByteBuffer.allocate(i).order(intBuffer.order());
            IntBuffer asIntBuffer = order.asIntBuffer();
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= i / 4) {
                    break;
                }
                asIntBuffer.put(intBuffer.get());
                i8 = i9 + 1;
            }
            intBuffer.position(position4);
        } else if (buffer instanceof FloatBuffer) {
            FloatBuffer floatBuffer = (FloatBuffer) buffer;
            int position5 = floatBuffer.position();
            if (z) {
                i = (floatBuffer.limit() - position5) * 4;
            }
            order = ByteBuffer.allocate(i).order(floatBuffer.order());
            FloatBuffer asFloatBuffer = order.asFloatBuffer();
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= i / 4) {
                    break;
                }
                asFloatBuffer.put(floatBuffer.get());
                i10 = i11 + 1;
            }
            floatBuffer.position(position5);
        } else if (buffer instanceof DoubleBuffer) {
            DoubleBuffer doubleBuffer = (DoubleBuffer) buffer;
            int position6 = doubleBuffer.position();
            if (z) {
                i = (doubleBuffer.limit() - position6) * 8;
            }
            order = ByteBuffer.allocate(i).order(doubleBuffer.order());
            DoubleBuffer asDoubleBuffer = order.asDoubleBuffer();
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 >= i / 8) {
                    break;
                }
                asDoubleBuffer.put(doubleBuffer.get());
                i12 = i13 + 1;
            }
            doubleBuffer.position(position6);
        } else if (!(buffer instanceof LongBuffer)) {
            throw new RuntimeException("Unimplemented Buffer subclass.");
        } else {
            LongBuffer longBuffer = (LongBuffer) buffer;
            int position7 = longBuffer.position();
            if (z) {
                i = (longBuffer.limit() - position7) * 8;
            }
            order = ByteBuffer.allocate(i).order(longBuffer.order());
            LongBuffer asLongBuffer = order.asLongBuffer();
            int i14 = 0;
            while (true) {
                int i15 = i14;
                if (i15 >= i / 8) {
                    break;
                }
                asLongBuffer.put(longBuffer.get());
                i14 = i15 + 1;
            }
            longBuffer.position(position7);
        }
        order.rewind();
        order.order(ByteOrder.nativeOrder());
        return order;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private char[] toCharIndices(int i, int i2, Buffer buffer) {
        char[] cArr = new char[i];
        switch (i2) {
            case 5121:
                ByteBuffer byteBuffer = toByteBuffer(i, buffer);
                byte[] array = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= i) {
                        break;
                    } else {
                        cArr[i4] = (char) (array[arrayOffset + i4] & 255);
                        i3 = i4 + 1;
                    }
                }
            case 5123:
                CharBuffer asCharBuffer = buffer instanceof CharBuffer ? (CharBuffer) buffer : toByteBuffer(i * 2, buffer).asCharBuffer();
                int position = asCharBuffer.position();
                asCharBuffer.position(0);
                asCharBuffer.get(cArr);
                asCharBuffer.position(position);
                return cArr;
        }
        return cArr;
    }

    private String toString(int i, int i2, IntBuffer intBuffer) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                sb.append("}");
                return sb.toString();
            }
            sb.append(" [" + i4 + "] = ");
            formattedAppend(sb, intBuffer.get(i4), i2);
            sb.append('\n');
            i3 = i4 + 1;
        }
    }

    private String toString(int i, int i2, int[] iArr, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int length = iArr.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                sb.append("}");
                return sb.toString();
            }
            int i6 = i3 + i5;
            sb.append(" [" + i6 + "] = ");
            if (i6 < 0 || i6 >= length) {
                sb.append("out of bounds");
            } else {
                formattedAppend(sb, iArr[i6], i2);
            }
            sb.append('\n');
            i4 = i5 + 1;
        }
    }

    private String toString(int i, FloatBuffer floatBuffer) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                sb.append("}");
                return sb.toString();
            }
            sb.append(" [" + i3 + "] = " + floatBuffer.get(i3) + '\n');
            i2 = i3 + 1;
        }
    }

    private String toString(int i, ShortBuffer shortBuffer) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                sb.append("}");
                return sb.toString();
            }
            sb.append(" [" + i3 + "] = " + ((int) shortBuffer.get(i3)) + '\n');
            i2 = i3 + 1;
        }
    }

    private String toString(int i, float[] fArr, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int length = fArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                sb.append("}");
                return sb.toString();
            }
            int i5 = i2 + i4;
            sb.append("[" + i5 + "] = ");
            if (i5 < 0 || i5 >= length) {
                sb.append("out of bounds");
            } else {
                sb.append(fArr[i5]);
            }
            sb.append('\n');
            i3 = i4 + 1;
        }
    }

    private String toString(int i, short[] sArr, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int length = sArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                sb.append("}");
                return sb.toString();
            }
            int i5 = i2 + i4;
            sb.append(" [" + i5 + "] = ");
            if (i5 < 0 || i5 >= length) {
                sb.append("out of bounds");
            } else {
                sb.append((int) sArr[i5]);
            }
            sb.append('\n');
            i3 = i4 + 1;
        }
    }

    private void unbindArrays() {
        if (this.mColorArrayEnabled) {
            this.mColorPointer.unbindByteBuffer();
        }
        if (this.mNormalArrayEnabled) {
            this.mNormalPointer.unbindByteBuffer();
        }
        if (this.mTextureCoordArrayEnabled) {
            this.mTexCoordPointer.unbindByteBuffer();
        }
        if (this.mVertexArrayEnabled) {
            this.mVertexPointer.unbindByteBuffer();
        }
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glActiveTexture(int i) {
        begin("glActiveTexture");
        arg("texture", i);
        end();
        this.mgl.glActiveTexture(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glAlphaFunc(int i, float f) {
        begin("glAlphaFunc");
        arg("func", i);
        arg(OapsKey.KEY_REF, f);
        end();
        this.mgl.glAlphaFunc(i, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glAlphaFuncx(int i, int i2) {
        begin("glAlphaFuncx");
        arg("func", i);
        arg(OapsKey.KEY_REF, i2);
        end();
        this.mgl.glAlphaFuncx(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glBindBuffer(int i, int i2) {
        begin("glBindBuffer");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("buffer", i2);
        end();
        this.mgl11.glBindBuffer(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glBindFramebufferOES(int i, int i2) {
        begin("glBindFramebufferOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("framebuffer", i2);
        end();
        this.mgl11ExtensionPack.glBindFramebufferOES(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glBindRenderbufferOES(int i, int i2) {
        begin("glBindRenderbufferOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("renderbuffer", i2);
        end();
        this.mgl11ExtensionPack.glBindRenderbufferOES(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glBindTexture(int i, int i2) {
        begin("glBindTexture");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg("texture", i2);
        end();
        this.mgl.glBindTexture(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glBlendEquation(int i) {
        begin("glBlendEquation");
        arg("mode", i);
        end();
        this.mgl11ExtensionPack.glBlendEquation(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glBlendEquationSeparate(int i, int i2) {
        begin("glBlendEquationSeparate");
        arg("modeRGB", i);
        arg("modeAlpha", i2);
        end();
        this.mgl11ExtensionPack.glBlendEquationSeparate(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glBlendFunc(int i, int i2) {
        begin("glBlendFunc");
        arg("sfactor", getFactor(i));
        arg("dfactor", getFactor(i2));
        end();
        this.mgl.glBlendFunc(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        begin("glBlendFuncSeparate");
        arg("srcRGB", i);
        arg("dstRGB", i2);
        arg("srcAlpha", i3);
        arg("dstAlpha", i4);
        end();
        this.mgl11ExtensionPack.glBlendFuncSeparate(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glBufferData(int i, int i2, Buffer buffer, int i3) {
        begin("glBufferData");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg(OapsKey.KEY_SIZE, i2);
        arg("data", buffer.toString());
        arg("usage", i3);
        end();
        this.mgl11.glBufferData(i, i2, buffer, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glBufferSubData(int i, int i2, int i3, Buffer buffer) {
        begin("glBufferSubData");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("offset", i2);
        arg(OapsKey.KEY_SIZE, i3);
        arg("data", buffer.toString());
        end();
        this.mgl11.glBufferSubData(i, i2, i3, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public int glCheckFramebufferStatusOES(int i) {
        begin("glCheckFramebufferStatusOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        end();
        int glCheckFramebufferStatusOES = this.mgl11ExtensionPack.glCheckFramebufferStatusOES(i);
        checkError();
        return glCheckFramebufferStatusOES;
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glClear(int i) {
        begin("glClear");
        arg("mask", getClearBufferMask(i));
        end();
        this.mgl.glClear(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glClearColor(float f, float f2, float f3, float f4) {
        begin("glClearColor");
        arg("red", f);
        arg("green", f2);
        arg("blue", f3);
        arg("alpha", f4);
        end();
        this.mgl.glClearColor(f, f2, f3, f4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glClearColorx(int i, int i2, int i3, int i4) {
        begin("glClearColor");
        arg("red", i);
        arg("green", i2);
        arg("blue", i3);
        arg("alpha", i4);
        end();
        this.mgl.glClearColorx(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glClearDepthf(float f) {
        begin("glClearDepthf");
        arg("depth", f);
        end();
        this.mgl.glClearDepthf(f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glClearDepthx(int i) {
        begin("glClearDepthx");
        arg("depth", i);
        end();
        this.mgl.glClearDepthx(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glClearStencil(int i) {
        begin("glClearStencil");
        arg("s", i);
        end();
        this.mgl.glClearStencil(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glClientActiveTexture(int i) {
        begin("glClientActiveTexture");
        arg("texture", i);
        end();
        this.mgl.glClientActiveTexture(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glClipPlanef(int i, FloatBuffer floatBuffer) {
        begin("glClipPlanef");
        arg("plane", i);
        arg("equation", 4, floatBuffer);
        end();
        this.mgl11.glClipPlanef(i, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glClipPlanef(int i, float[] fArr, int i2) {
        begin("glClipPlanef");
        arg("plane", i);
        arg("equation", 4, fArr, i2);
        arg("offset", i2);
        end();
        this.mgl11.glClipPlanef(i, fArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glClipPlanex(int i, IntBuffer intBuffer) {
        begin("glClipPlanef");
        arg("plane", i);
        arg("equation", 4, intBuffer);
        end();
        this.mgl11.glClipPlanex(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glClipPlanex(int i, int[] iArr, int i2) {
        begin("glClipPlanex");
        arg("plane", i);
        arg("equation", 4, iArr, i2);
        arg("offset", i2);
        end();
        this.mgl11.glClipPlanex(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glColor4f(float f, float f2, float f3, float f4) {
        begin("glColor4f");
        arg("red", f);
        arg("green", f2);
        arg("blue", f3);
        arg("alpha", f4);
        end();
        this.mgl.glColor4f(f, f2, f3, f4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glColor4ub(byte b, byte b2, byte b3, byte b4) {
        begin("glColor4ub");
        arg("red", (int) b);
        arg("green", (int) b2);
        arg("blue", (int) b3);
        arg("alpha", (int) b4);
        end();
        this.mgl11.glColor4ub(b, b2, b3, b4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glColor4x(int i, int i2, int i3, int i4) {
        begin("glColor4x");
        arg("red", i);
        arg("green", i2);
        arg("blue", i3);
        arg("alpha", i4);
        end();
        this.mgl.glColor4x(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        begin("glColorMask");
        arg("red", z);
        arg("green", z2);
        arg("blue", z3);
        arg("alpha", z4);
        end();
        this.mgl.glColorMask(z, z2, z3, z4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glColorPointer(int i, int i2, int i3, int i4) {
        begin("glColorPointer");
        arg(OapsKey.KEY_SIZE, i);
        arg("type", i2);
        arg(MediaFormat.KEY_STRIDE, i3);
        arg("offset", i4);
        end();
        this.mgl11.glColorPointer(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glColorPointer(int i, int i2, int i3, Buffer buffer) {
        begin("glColorPointer");
        argPointer(i, i2, i3, buffer);
        end();
        this.mColorPointer = new PointerInfo(i, i2, i3, buffer);
        this.mgl.glColorPointer(i, i2, i3, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer) {
        begin("glCompressedTexImage2D");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg(BatteryManager.EXTRA_LEVEL, i2);
        arg("internalformat", i3);
        arg("width", i4);
        arg("height", i5);
        arg("border", i6);
        arg("imageSize", i7);
        arg("data", buffer.toString());
        end();
        this.mgl.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        begin("glCompressedTexSubImage2D");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg(BatteryManager.EXTRA_LEVEL, i2);
        arg("xoffset", i3);
        arg("yoffset", i4);
        arg("width", i5);
        arg("height", i6);
        arg("format", i7);
        arg("imageSize", i8);
        arg("data", buffer.toString());
        end();
        this.mgl.glCompressedTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        begin("glCopyTexImage2D");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg(BatteryManager.EXTRA_LEVEL, i2);
        arg("internalformat", i3);
        arg("x", i4);
        arg("y", i5);
        arg("width", i6);
        arg("height", i7);
        arg("border", i8);
        end();
        this.mgl.glCopyTexImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        begin("glCopyTexSubImage2D");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg(BatteryManager.EXTRA_LEVEL, i2);
        arg("xoffset", i3);
        arg("yoffset", i4);
        arg("x", i5);
        arg("y", i6);
        arg("width", i7);
        arg("height", i8);
        end();
        this.mgl.glCopyTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glCullFace(int i) {
        begin("glCullFace");
        arg("mode", i);
        end();
        this.mgl.glCullFace(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glCurrentPaletteMatrixOES(int i) {
        begin("glCurrentPaletteMatrixOES");
        arg("matrixpaletteindex", i);
        end();
        this.mgl11Ext.glCurrentPaletteMatrixOES(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glDeleteBuffers(int i, IntBuffer intBuffer) {
        begin("glDeleteBuffers");
        arg("n", i);
        arg("buffers", intBuffer.toString());
        end();
        this.mgl11.glDeleteBuffers(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glDeleteBuffers(int i, int[] iArr, int i2) {
        begin("glDeleteBuffers");
        arg("n", i);
        arg("buffers", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glDeleteBuffers(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glDeleteFramebuffersOES(int i, IntBuffer intBuffer) {
        begin("glDeleteFramebuffersOES");
        arg("n", i);
        arg("framebuffers", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glDeleteFramebuffersOES(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glDeleteFramebuffersOES(int i, int[] iArr, int i2) {
        begin("glDeleteFramebuffersOES");
        arg("n", i);
        arg("framebuffers", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11ExtensionPack.glDeleteFramebuffersOES(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glDeleteRenderbuffersOES(int i, IntBuffer intBuffer) {
        begin("glDeleteRenderbuffersOES");
        arg("n", i);
        arg("renderbuffers", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glDeleteRenderbuffersOES(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glDeleteRenderbuffersOES(int i, int[] iArr, int i2) {
        begin("glDeleteRenderbuffersOES");
        arg("n", i);
        arg("renderbuffers", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11ExtensionPack.glDeleteRenderbuffersOES(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDeleteTextures(int i, IntBuffer intBuffer) {
        begin("glDeleteTextures");
        arg("n", i);
        arg("textures", i, intBuffer);
        end();
        this.mgl.glDeleteTextures(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDeleteTextures(int i, int[] iArr, int i2) {
        begin("glDeleteTextures");
        arg("n", i);
        arg("textures", i, iArr, i2);
        arg("offset", i2);
        end();
        this.mgl.glDeleteTextures(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDepthFunc(int i) {
        begin("glDepthFunc");
        arg("func", i);
        end();
        this.mgl.glDepthFunc(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDepthMask(boolean z) {
        begin("glDepthMask");
        arg("flag", z);
        end();
        this.mgl.glDepthMask(z);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDepthRangef(float f, float f2) {
        begin("glDepthRangef");
        arg("near", f);
        arg("far", f2);
        end();
        this.mgl.glDepthRangef(f, f2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDepthRangex(int i, int i2) {
        begin("glDepthRangex");
        arg("near", i);
        arg("far", i2);
        end();
        this.mgl.glDepthRangex(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDisable(int i) {
        begin("glDisable");
        arg("cap", getCap(i));
        end();
        this.mgl.glDisable(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDisableClientState(int i) {
        begin("glDisableClientState");
        arg("array", getClientState(i));
        end();
        switch (i) {
            case 32884:
                this.mVertexArrayEnabled = false;
                break;
            case GLES10.GL_NORMAL_ARRAY /* 32885 */:
                this.mNormalArrayEnabled = false;
                break;
            case GLES10.GL_COLOR_ARRAY /* 32886 */:
                this.mColorArrayEnabled = false;
                break;
            case GLES10.GL_TEXTURE_COORD_ARRAY /* 32888 */:
                this.mTextureCoordArrayEnabled = false;
                break;
        }
        this.mgl.glDisableClientState(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDrawArrays(int i, int i2, int i3) {
        begin("glDrawArrays");
        arg("mode", i);
        arg("first", i2);
        arg("count", i3);
        startLogIndices();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                endLogIndices();
                end();
                this.mgl.glDrawArrays(i, i2, i3);
                checkError();
                return;
            }
            doElement(this.mStringBuilder, i5, i2 + i5);
            i4 = i5 + 1;
        }
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glDrawElements(int i, int i2, int i3, int i4) {
        begin("glDrawElements");
        arg("mode", i);
        arg("count", i2);
        arg("type", i3);
        arg("offset", i4);
        end();
        this.mgl11.glDrawElements(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glDrawElements(int i, int i2, int i3, Buffer buffer) {
        begin("glDrawElements");
        arg("mode", getBeginMode(i));
        arg("count", i2);
        arg("type", getIndexType(i3));
        char[] charIndices = toCharIndices(i2, i3, buffer);
        int length = charIndices.length;
        startLogIndices();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                endLogIndices();
                end();
                this.mgl.glDrawElements(i, i2, i3, buffer);
                checkError();
                return;
            }
            doElement(this.mStringBuilder, i5, charIndices[i5]);
            i4 = i5 + 1;
        }
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexfOES(float f, float f2, float f3, float f4, float f5) {
        begin("glDrawTexfOES");
        arg("x", f);
        arg("y", f2);
        arg(bh.aG, f3);
        arg("width", f4);
        arg("height", f5);
        end();
        this.mgl11Ext.glDrawTexfOES(f, f2, f3, f4, f5);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexfvOES(FloatBuffer floatBuffer) {
        begin("glDrawTexfvOES");
        arg("coords", 5, floatBuffer);
        end();
        this.mgl11Ext.glDrawTexfvOES(floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexfvOES(float[] fArr, int i) {
        begin("glDrawTexfvOES");
        arg("coords", 5, fArr, i);
        arg("offset", i);
        end();
        this.mgl11Ext.glDrawTexfvOES(fArr, i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexiOES(int i, int i2, int i3, int i4, int i5) {
        begin("glDrawTexiOES");
        arg("x", i);
        arg("y", i2);
        arg(bh.aG, i3);
        arg("width", i4);
        arg("height", i5);
        end();
        this.mgl11Ext.glDrawTexiOES(i, i2, i3, i4, i5);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexivOES(IntBuffer intBuffer) {
        begin("glDrawTexivOES");
        arg("coords", 5, intBuffer);
        end();
        this.mgl11Ext.glDrawTexivOES(intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexivOES(int[] iArr, int i) {
        begin("glDrawTexivOES");
        arg("coords", 5, iArr, i);
        arg("offset", i);
        end();
        this.mgl11Ext.glDrawTexivOES(iArr, i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexsOES(short s, short s2, short s3, short s4, short s5) {
        begin("glDrawTexsOES");
        arg("x", (int) s);
        arg("y", (int) s2);
        arg(bh.aG, (int) s3);
        arg("width", (int) s4);
        arg("height", (int) s5);
        end();
        this.mgl11Ext.glDrawTexsOES(s, s2, s3, s4, s5);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexsvOES(ShortBuffer shortBuffer) {
        begin("glDrawTexsvOES");
        arg("coords", 5, shortBuffer);
        end();
        this.mgl11Ext.glDrawTexsvOES(shortBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexsvOES(short[] sArr, int i) {
        begin("glDrawTexsvOES");
        arg("coords", 5, sArr, i);
        arg("offset", i);
        end();
        this.mgl11Ext.glDrawTexsvOES(sArr, i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexxOES(int i, int i2, int i3, int i4, int i5) {
        begin("glDrawTexxOES");
        arg("x", i);
        arg("y", i2);
        arg(bh.aG, i3);
        arg("width", i4);
        arg("height", i5);
        end();
        this.mgl11Ext.glDrawTexxOES(i, i2, i3, i4, i5);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexxvOES(IntBuffer intBuffer) {
        begin("glDrawTexxvOES");
        arg("coords", 5, intBuffer);
        end();
        this.mgl11Ext.glDrawTexxvOES(intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glDrawTexxvOES(int[] iArr, int i) {
        begin("glDrawTexxvOES");
        arg("coords", 5, iArr, i);
        arg("offset", i);
        end();
        this.mgl11Ext.glDrawTexxvOES(iArr, i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11Ext, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glEnable(int i) {
        begin("glEnable");
        arg("cap", getCap(i));
        end();
        this.mgl.glEnable(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11Ext
    public void glEnableClientState(int i) {
        begin("glEnableClientState");
        arg("array", getClientState(i));
        end();
        switch (i) {
            case 32884:
                this.mVertexArrayEnabled = true;
                break;
            case GLES10.GL_NORMAL_ARRAY /* 32885 */:
                this.mNormalArrayEnabled = true;
                break;
            case GLES10.GL_COLOR_ARRAY /* 32886 */:
                this.mColorArrayEnabled = true;
                break;
            case GLES10.GL_TEXTURE_COORD_ARRAY /* 32888 */:
                this.mTextureCoordArrayEnabled = true;
                break;
        }
        this.mgl.glEnableClientState(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFinish() {
        begin("glFinish");
        end();
        this.mgl.glFinish();
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFlush() {
        begin("glFlush");
        end();
        this.mgl.glFlush();
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFogf(int i, float f) {
        begin("glFogf");
        arg("pname", i);
        arg(RemoteMessageConst.MessageBody.PARAM, f);
        end();
        this.mgl.glFogf(i, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFogfv(int i, FloatBuffer floatBuffer) {
        begin("glFogfv");
        arg("pname", getFogPName(i));
        arg("params", getFogParamCount(i), floatBuffer);
        end();
        this.mgl.glFogfv(i, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFogfv(int i, float[] fArr, int i2) {
        begin("glFogfv");
        arg("pname", getFogPName(i));
        arg("params", getFogParamCount(i), fArr, i2);
        arg("offset", i2);
        end();
        this.mgl.glFogfv(i, fArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFogx(int i, int i2) {
        begin("glFogx");
        arg("pname", getFogPName(i));
        arg(RemoteMessageConst.MessageBody.PARAM, i2);
        end();
        this.mgl.glFogx(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFogxv(int i, IntBuffer intBuffer) {
        begin("glFogxv");
        arg("pname", getFogPName(i));
        arg("params", getFogParamCount(i), intBuffer);
        end();
        this.mgl.glFogxv(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFogxv(int i, int[] iArr, int i2) {
        begin("glFogxv");
        arg("pname", getFogPName(i));
        arg("params", getFogParamCount(i), iArr, i2);
        arg("offset", i2);
        end();
        this.mgl.glFogxv(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glFramebufferRenderbufferOES(int i, int i2, int i3, int i4) {
        begin("glFramebufferRenderbufferOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("attachment", i2);
        arg("renderbuffertarget", i3);
        arg("renderbuffer", i4);
        end();
        this.mgl11ExtensionPack.glFramebufferRenderbufferOES(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glFramebufferTexture2DOES(int i, int i2, int i3, int i4, int i5) {
        begin("glFramebufferTexture2DOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("attachment", i2);
        arg("textarget", i3);
        arg("texture", i4);
        arg(BatteryManager.EXTRA_LEVEL, i5);
        end();
        this.mgl11ExtensionPack.glFramebufferTexture2DOES(i, i2, i3, i4, i5);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFrontFace(int i) {
        begin("glFrontFace");
        arg("mode", i);
        end();
        this.mgl.glFrontFace(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFrustumf(float f, float f2, float f3, float f4, float f5, float f6) {
        begin("glFrustumf");
        arg("left", f);
        arg("right", f2);
        arg("bottom", f3);
        arg(Constant.MAP_KEY_TOP, f4);
        arg("near", f5);
        arg("far", f6);
        end();
        this.mgl.glFrustumf(f, f2, f3, f4, f5, f6);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glFrustumx(int i, int i2, int i3, int i4, int i5, int i6) {
        begin("glFrustumx");
        arg("left", i);
        arg("right", i2);
        arg("bottom", i3);
        arg(Constant.MAP_KEY_TOP, i4);
        arg("near", i5);
        arg("far", i6);
        end();
        this.mgl.glFrustumx(i, i2, i3, i4, i5, i6);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGenBuffers(int i, IntBuffer intBuffer) {
        begin("glGenBuffers");
        arg("n", i);
        arg("buffers", intBuffer.toString());
        end();
        this.mgl11.glGenBuffers(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGenBuffers(int i, int[] iArr, int i2) {
        begin("glGenBuffers");
        arg("n", i);
        arg("buffers", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glGenBuffers(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGenFramebuffersOES(int i, IntBuffer intBuffer) {
        begin("glGenFramebuffersOES");
        arg("n", i);
        arg("framebuffers", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glGenFramebuffersOES(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGenFramebuffersOES(int i, int[] iArr, int i2) {
        begin("glGenFramebuffersOES");
        arg("n", i);
        arg("framebuffers", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11ExtensionPack.glGenFramebuffersOES(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGenRenderbuffersOES(int i, IntBuffer intBuffer) {
        begin("glGenRenderbuffersOES");
        arg("n", i);
        arg("renderbuffers", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glGenRenderbuffersOES(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGenRenderbuffersOES(int i, int[] iArr, int i2) {
        begin("glGenRenderbuffersOES");
        arg("n", i);
        arg("renderbuffers", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11ExtensionPack.glGenRenderbuffersOES(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glGenTextures(int i, IntBuffer intBuffer) {
        begin("glGenTextures");
        arg("n", i);
        arg("textures", intBuffer.toString());
        this.mgl.glGenTextures(i, intBuffer);
        returns(toString(i, 0, intBuffer));
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glGenTextures(int i, int[] iArr, int i2) {
        begin("glGenTextures");
        arg("n", i);
        arg("textures", Arrays.toString(iArr));
        arg("offset", i2);
        this.mgl.glGenTextures(i, iArr, i2);
        returns(toString(i, 0, iArr, i2));
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGenerateMipmapOES(int i) {
        begin("glGenerateMipmapOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        end();
        this.mgl11ExtensionPack.glGenerateMipmapOES(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetBooleanv(int i, IntBuffer intBuffer) {
        begin("glGetBooleanv");
        arg("pname", i);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetBooleanv(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetBooleanv(int i, boolean[] zArr, int i2) {
        begin("glGetBooleanv");
        arg("pname", i);
        arg("params", zArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glGetBooleanv(i, zArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetBufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetBufferParameteriv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetBufferParameteriv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetBufferParameteriv(int i, int i2, int[] iArr, int i3) {
        begin("glGetBufferParameteriv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetBufferParameteriv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetClipPlanef(int i, FloatBuffer floatBuffer) {
        begin("glGetClipPlanef");
        arg("pname", i);
        arg("eqn", floatBuffer.toString());
        end();
        this.mgl11.glGetClipPlanef(i, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetClipPlanef(int i, float[] fArr, int i2) {
        begin("glGetClipPlanef");
        arg("pname", i);
        arg("eqn", fArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glGetClipPlanef(i, fArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetClipPlanex(int i, IntBuffer intBuffer) {
        begin("glGetClipPlanex");
        arg("pname", i);
        arg("eqn", intBuffer.toString());
        end();
        this.mgl11.glGetClipPlanex(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetClipPlanex(int i, int[] iArr, int i2) {
        begin("glGetClipPlanex");
        arg("pname", i);
        arg("eqn", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glGetClipPlanex(i, iArr, i2);
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public int glGetError() {
        begin("glGetError");
        int glGetError = this.mgl.glGetError();
        returns(glGetError);
        return glGetError;
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetFixedv(int i, IntBuffer intBuffer) {
        begin("glGetFixedv");
        arg("pname", i);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetFixedv(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetFixedv(int i, int[] iArr, int i2) {
        begin("glGetFixedv");
        arg("pname", i);
        arg("params", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glGetFixedv(i, iArr, i2);
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetFloatv(int i, FloatBuffer floatBuffer) {
        begin("glGetFloatv");
        arg("pname", i);
        arg("params", floatBuffer.toString());
        end();
        this.mgl11.glGetFloatv(i, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetFloatv(int i, float[] fArr, int i2) {
        begin("glGetFloatv");
        arg("pname", i);
        arg("params", fArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glGetFloatv(i, fArr, i2);
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetFramebufferAttachmentParameterivOES(int i, int i2, int i3, IntBuffer intBuffer) {
        begin("glGetFramebufferAttachmentParameterivOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("attachment", i2);
        arg("pname", i3);
        arg("params", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(i, i2, i3, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetFramebufferAttachmentParameterivOES(int i, int i2, int i3, int[] iArr, int i4) {
        begin("glGetFramebufferAttachmentParameterivOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("attachment", i2);
        arg("pname", i3);
        arg("params", iArr.toString());
        arg("offset", i4);
        end();
        this.mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(i, i2, i3, iArr, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetIntegerv(int i, IntBuffer intBuffer) {
        begin("glGetIntegerv");
        arg("pname", getIntegerStateName(i));
        arg("params", intBuffer.toString());
        this.mgl.glGetIntegerv(i, intBuffer);
        returns(toString(getIntegerStateSize(i), getIntegerStateFormat(i), intBuffer));
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetIntegerv(int i, int[] iArr, int i2) {
        begin("glGetIntegerv");
        arg("pname", getIntegerStateName(i));
        arg("params", Arrays.toString(iArr));
        arg("offset", i2);
        this.mgl.glGetIntegerv(i, iArr, i2);
        returns(toString(getIntegerStateSize(i), getIntegerStateFormat(i), iArr, i2));
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetLightfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glGetLightfv");
        arg("light", i);
        arg("pname", i2);
        arg("params", floatBuffer.toString());
        end();
        this.mgl11.glGetLightfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetLightfv(int i, int i2, float[] fArr, int i3) {
        begin("glGetLightfv");
        arg("light", i);
        arg("pname", i2);
        arg("params", fArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetLightfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetLightxv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetLightxv");
        arg("light", i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetLightxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetLightxv(int i, int i2, int[] iArr, int i3) {
        begin("glGetLightxv");
        arg("light", i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetLightxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetMaterialfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glGetMaterialfv");
        arg("face", i);
        arg("pname", i2);
        arg("params", floatBuffer.toString());
        end();
        this.mgl11.glGetMaterialfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetMaterialfv(int i, int i2, float[] fArr, int i3) {
        begin("glGetMaterialfv");
        arg("face", i);
        arg("pname", i2);
        arg("params", fArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetMaterialfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetMaterialxv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetMaterialxv");
        arg("face", i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetMaterialxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetMaterialxv(int i, int i2, int[] iArr, int i3) {
        begin("glGetMaterialxv");
        arg("face", i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetMaterialxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetPointerv(int i, Buffer[] bufferArr) {
        begin("glGetPointerv");
        arg("pname", i);
        arg("params", bufferArr.toString());
        end();
        this.mgl11.glGetPointerv(i, bufferArr);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetRenderbufferParameterivOES(int i, int i2, IntBuffer intBuffer) {
        begin("glGetRenderbufferParameterivOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glGetRenderbufferParameterivOES(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetRenderbufferParameterivOES(int i, int i2, int[] iArr, int i3) {
        begin("glGetRenderbufferParameterivOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11ExtensionPack.glGetRenderbufferParameterivOES(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public String glGetString(int i) {
        begin("glGetString");
        arg("name", i);
        String glGetString = this.mgl.glGetString(i);
        returns(glGetString);
        checkError();
        return glGetString;
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexEnviv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetTexEnviv");
        arg(at.f26942a, i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetTexEnviv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexEnviv(int i, int i2, int[] iArr, int i3) {
        begin("glGetTexEnviv");
        arg(at.f26942a, i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetTexEnviv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexEnvxv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetTexEnviv");
        arg(at.f26942a, i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetTexEnvxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexEnvxv(int i, int i2, int[] iArr, int i3) {
        begin("glGetTexEnviv");
        arg(at.f26942a, i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetTexEnviv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetTexGenfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glGetTexGenfv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", floatBuffer.toString());
        end();
        this.mgl11ExtensionPack.glGetTexGenfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetTexGenfv(int i, int i2, float[] fArr, int i3) {
        begin("glGetTexGenfv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", fArr.toString());
        arg("offset", i3);
        end();
        this.mgl11ExtensionPack.glGetTexGenfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetTexGeniv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetTexGeniv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glGetTexGeniv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetTexGeniv(int i, int i2, int[] iArr, int i3) {
        begin("glGetTexGeniv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11ExtensionPack.glGetTexGeniv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetTexGenxv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetTexGenxv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glGetTexGenxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glGetTexGenxv(int i, int i2, int[] iArr, int i3) {
        begin("glGetTexGenxv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11ExtensionPack.glGetTexGenxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glGetTexParameterfv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", floatBuffer.toString());
        end();
        this.mgl11.glGetTexParameterfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexParameterfv(int i, int i2, float[] fArr, int i3) {
        begin("glGetTexParameterfv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", fArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetTexParameterfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetTexParameteriv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetTexParameteriv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexParameteriv(int i, int i2, int[] iArr, int i3) {
        begin("glGetTexParameteriv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetTexEnviv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexParameterxv(int i, int i2, IntBuffer intBuffer) {
        begin("glGetTexParameterxv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glGetTexParameterxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glGetTexParameterxv(int i, int i2, int[] iArr, int i3) {
        begin("glGetTexParameterxv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glGetTexParameterxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glHint(int i, int i2) {
        begin("glHint");
        arg(TypedValues.AttributesType.S_TARGET, getHintTarget(i));
        arg("mode", getHintMode(i2));
        end();
        this.mgl.glHint(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public boolean glIsBuffer(int i) {
        begin("glIsBuffer");
        arg("buffer", i);
        end();
        boolean glIsBuffer = this.mgl11.glIsBuffer(i);
        checkError();
        return glIsBuffer;
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public boolean glIsEnabled(int i) {
        begin("glIsEnabled");
        arg("cap", i);
        end();
        boolean glIsEnabled = this.mgl11.glIsEnabled(i);
        checkError();
        return glIsEnabled;
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public boolean glIsFramebufferOES(int i) {
        begin("glIsFramebufferOES");
        arg("framebuffer", i);
        end();
        boolean glIsFramebufferOES = this.mgl11ExtensionPack.glIsFramebufferOES(i);
        checkError();
        return glIsFramebufferOES;
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public boolean glIsRenderbufferOES(int i) {
        begin("glIsRenderbufferOES");
        arg("renderbuffer", i);
        end();
        this.mgl11ExtensionPack.glIsRenderbufferOES(i);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public boolean glIsTexture(int i) {
        begin("glIsTexture");
        arg("texture", i);
        end();
        boolean glIsTexture = this.mgl11.glIsTexture(i);
        checkError();
        return glIsTexture;
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightModelf(int i, float f) {
        begin("glLightModelf");
        arg("pname", getLightModelPName(i));
        arg(RemoteMessageConst.MessageBody.PARAM, f);
        end();
        this.mgl.glLightModelf(i, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightModelfv(int i, FloatBuffer floatBuffer) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(i));
        arg("params", getLightModelParamCount(i), floatBuffer);
        end();
        this.mgl.glLightModelfv(i, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightModelfv(int i, float[] fArr, int i2) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(i));
        arg("params", getLightModelParamCount(i), fArr, i2);
        arg("offset", i2);
        end();
        this.mgl.glLightModelfv(i, fArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightModelx(int i, int i2) {
        begin("glLightModelx");
        arg("pname", getLightModelPName(i));
        arg(RemoteMessageConst.MessageBody.PARAM, i2);
        end();
        this.mgl.glLightModelx(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightModelxv(int i, IntBuffer intBuffer) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(i));
        arg("params", getLightModelParamCount(i), intBuffer);
        end();
        this.mgl.glLightModelxv(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightModelxv(int i, int[] iArr, int i2) {
        begin("glLightModelxv");
        arg("pname", getLightModelPName(i));
        arg("params", getLightModelParamCount(i), iArr, i2);
        arg("offset", i2);
        end();
        this.mgl.glLightModelxv(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightf(int i, int i2, float f) {
        begin("glLightf");
        arg("light", getLightName(i));
        arg("pname", getLightPName(i2));
        arg(RemoteMessageConst.MessageBody.PARAM, f);
        end();
        this.mgl.glLightf(i, i2, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glLightfv");
        arg("light", getLightName(i));
        arg("pname", getLightPName(i2));
        arg("params", getLightParamCount(i2), floatBuffer);
        end();
        this.mgl.glLightfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightfv(int i, int i2, float[] fArr, int i3) {
        begin("glLightfv");
        arg("light", getLightName(i));
        arg("pname", getLightPName(i2));
        arg("params", getLightParamCount(i2), fArr, i3);
        arg("offset", i3);
        end();
        this.mgl.glLightfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightx(int i, int i2, int i3) {
        begin("glLightx");
        arg("light", getLightName(i));
        arg("pname", getLightPName(i2));
        arg(RemoteMessageConst.MessageBody.PARAM, i3);
        end();
        this.mgl.glLightx(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightxv(int i, int i2, IntBuffer intBuffer) {
        begin("glLightxv");
        arg("light", getLightName(i));
        arg("pname", getLightPName(i2));
        arg("params", getLightParamCount(i2), intBuffer);
        end();
        this.mgl.glLightxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLightxv(int i, int i2, int[] iArr, int i3) {
        begin("glLightxv");
        arg("light", getLightName(i));
        arg("pname", getLightPName(i2));
        arg("params", getLightParamCount(i2), iArr, i3);
        arg("offset", i3);
        end();
        this.mgl.glLightxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLineWidth(float f) {
        begin("glLineWidth");
        arg("width", f);
        end();
        this.mgl.glLineWidth(f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLineWidthx(int i) {
        begin("glLineWidthx");
        arg("width", i);
        end();
        this.mgl.glLineWidthx(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLoadIdentity() {
        begin("glLoadIdentity");
        end();
        this.mgl.glLoadIdentity();
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLoadMatrixf(FloatBuffer floatBuffer) {
        begin("glLoadMatrixf");
        arg("m", 16, floatBuffer);
        end();
        this.mgl.glLoadMatrixf(floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLoadMatrixf(float[] fArr, int i) {
        begin("glLoadMatrixf");
        arg("m", 16, fArr, i);
        arg("offset", i);
        end();
        this.mgl.glLoadMatrixf(fArr, i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLoadMatrixx(IntBuffer intBuffer) {
        begin("glLoadMatrixx");
        arg("m", 16, intBuffer);
        end();
        this.mgl.glLoadMatrixx(intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLoadMatrixx(int[] iArr, int i) {
        begin("glLoadMatrixx");
        arg("m", 16, iArr, i);
        arg("offset", i);
        end();
        this.mgl.glLoadMatrixx(iArr, i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glLoadPaletteFromModelViewMatrixOES() {
        begin("glLoadPaletteFromModelViewMatrixOES");
        end();
        this.mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glLogicOp(int i) {
        begin("glLogicOp");
        arg("opcode", i);
        end();
        this.mgl.glLogicOp(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMaterialf(int i, int i2, float f) {
        begin("glMaterialf");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(i2));
        arg(RemoteMessageConst.MessageBody.PARAM, f);
        end();
        this.mgl.glMaterialf(i, i2, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMaterialfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glMaterialfv");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(i2));
        arg("params", getMaterialParamCount(i2), floatBuffer);
        end();
        this.mgl.glMaterialfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMaterialfv(int i, int i2, float[] fArr, int i3) {
        begin("glMaterialfv");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(i2));
        arg("params", getMaterialParamCount(i2), fArr, i3);
        arg("offset", i3);
        end();
        this.mgl.glMaterialfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMaterialx(int i, int i2, int i3) {
        begin("glMaterialx");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(i2));
        arg(RemoteMessageConst.MessageBody.PARAM, i3);
        end();
        this.mgl.glMaterialx(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMaterialxv(int i, int i2, IntBuffer intBuffer) {
        begin("glMaterialxv");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(i2));
        arg("params", getMaterialParamCount(i2), intBuffer);
        end();
        this.mgl.glMaterialxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMaterialxv(int i, int i2, int[] iArr, int i3) {
        begin("glMaterialxv");
        arg("face", getFaceName(i));
        arg("pname", getMaterialPName(i2));
        arg("params", getMaterialParamCount(i2), iArr, i3);
        arg("offset", i3);
        end();
        this.mgl.glMaterialxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glMatrixIndexPointerOES(int i, int i2, int i3, int i4) {
        begin("glMatrixIndexPointerOES");
        arg(OapsKey.KEY_SIZE, i);
        arg("type", i2);
        arg(MediaFormat.KEY_STRIDE, i3);
        arg("offset", i4);
        end();
        this.mgl11Ext.glMatrixIndexPointerOES(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glMatrixIndexPointerOES(int i, int i2, int i3, Buffer buffer) {
        begin("glMatrixIndexPointerOES");
        argPointer(i, i2, i3, buffer);
        end();
        this.mgl11Ext.glMatrixIndexPointerOES(i, i2, i3, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMatrixMode(int i) {
        begin("glMatrixMode");
        arg("mode", getMatrixMode(i));
        end();
        this.mgl.glMatrixMode(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMultMatrixf(FloatBuffer floatBuffer) {
        begin("glMultMatrixf");
        arg("m", 16, floatBuffer);
        end();
        this.mgl.glMultMatrixf(floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMultMatrixf(float[] fArr, int i) {
        begin("glMultMatrixf");
        arg("m", 16, fArr, i);
        arg("offset", i);
        end();
        this.mgl.glMultMatrixf(fArr, i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMultMatrixx(IntBuffer intBuffer) {
        begin("glMultMatrixx");
        arg("m", 16, intBuffer);
        end();
        this.mgl.glMultMatrixx(intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMultMatrixx(int[] iArr, int i) {
        begin("glMultMatrixx");
        arg("m", 16, iArr, i);
        arg("offset", i);
        end();
        this.mgl.glMultMatrixx(iArr, i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMultiTexCoord4f(int i, float f, float f2, float f3, float f4) {
        begin("glMultiTexCoord4f");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("s", f);
        arg("t", f2);
        arg("r", f3);
        arg("q", f4);
        end();
        this.mgl.glMultiTexCoord4f(i, f, f2, f3, f4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glMultiTexCoord4x(int i, int i2, int i3, int i4, int i5) {
        begin("glMultiTexCoord4x");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("s", i2);
        arg("t", i3);
        arg("r", i4);
        arg("q", i5);
        end();
        this.mgl.glMultiTexCoord4x(i, i2, i3, i4, i5);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glNormal3f(float f, float f2, float f3) {
        begin("glNormal3f");
        arg("nx", f);
        arg("ny", f2);
        arg("nz", f3);
        end();
        this.mgl.glNormal3f(f, f2, f3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glNormal3x(int i, int i2, int i3) {
        begin("glNormal3x");
        arg("nx", i);
        arg("ny", i2);
        arg("nz", i3);
        end();
        this.mgl.glNormal3x(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glNormalPointer(int i, int i2, int i3) {
        begin("glNormalPointer");
        arg("type", i);
        arg(MediaFormat.KEY_STRIDE, i2);
        arg("offset", i3);
        end();
        this.mgl11.glNormalPointer(i, i2, i3);
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glNormalPointer(int i, int i2, Buffer buffer) {
        begin("glNormalPointer");
        arg("type", i);
        arg(MediaFormat.KEY_STRIDE, i2);
        arg("pointer", buffer.toString());
        end();
        this.mNormalPointer = new PointerInfo(3, i, i2, buffer);
        this.mgl.glNormalPointer(i, i2, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glOrthof(float f, float f2, float f3, float f4, float f5, float f6) {
        begin("glOrthof");
        arg("left", f);
        arg("right", f2);
        arg("bottom", f3);
        arg(Constant.MAP_KEY_TOP, f4);
        arg("near", f5);
        arg("far", f6);
        end();
        this.mgl.glOrthof(f, f2, f3, f4, f5, f6);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glOrthox(int i, int i2, int i3, int i4, int i5, int i6) {
        begin("glOrthox");
        arg("left", i);
        arg("right", i2);
        arg("bottom", i3);
        arg(Constant.MAP_KEY_TOP, i4);
        arg("near", i5);
        arg("far", i6);
        end();
        this.mgl.glOrthox(i, i2, i3, i4, i5, i6);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glPixelStorei(int i, int i2) {
        begin("glPixelStorei");
        arg("pname", i);
        arg(RemoteMessageConst.MessageBody.PARAM, i2);
        end();
        this.mgl.glPixelStorei(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glPointParameterf(int i, float f) {
        begin("glPointParameterf");
        arg("pname", i);
        arg(RemoteMessageConst.MessageBody.PARAM, f);
        end();
        this.mgl11.glPointParameterf(i, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glPointParameterfv(int i, FloatBuffer floatBuffer) {
        begin("glPointParameterfv");
        arg("pname", i);
        arg("params", floatBuffer.toString());
        end();
        this.mgl11.glPointParameterfv(i, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glPointParameterfv(int i, float[] fArr, int i2) {
        begin("glPointParameterfv");
        arg("pname", i);
        arg("params", fArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glPointParameterfv(i, fArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glPointParameterx(int i, int i2) {
        begin("glPointParameterfv");
        arg("pname", i);
        arg(RemoteMessageConst.MessageBody.PARAM, i2);
        end();
        this.mgl11.glPointParameterx(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glPointParameterxv(int i, IntBuffer intBuffer) {
        begin("glPointParameterxv");
        arg("pname", i);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glPointParameterxv(i, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glPointParameterxv(int i, int[] iArr, int i2) {
        begin("glPointParameterxv");
        arg("pname", i);
        arg("params", iArr.toString());
        arg("offset", i2);
        end();
        this.mgl11.glPointParameterxv(i, iArr, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glPointSize(float f) {
        begin("glPointSize");
        arg(OapsKey.KEY_SIZE, f);
        end();
        this.mgl.glPointSize(f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glPointSizePointerOES(int i, int i2, Buffer buffer) {
        begin("glPointSizePointerOES");
        arg("type", i);
        arg(MediaFormat.KEY_STRIDE, i2);
        arg("params", buffer.toString());
        end();
        this.mgl11.glPointSizePointerOES(i, i2, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glPointSizex(int i) {
        begin("glPointSizex");
        arg(OapsKey.KEY_SIZE, i);
        end();
        this.mgl.glPointSizex(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glPolygonOffset(float f, float f2) {
        begin("glPolygonOffset");
        arg("factor", f);
        arg("units", f2);
        end();
        this.mgl.glPolygonOffset(f, f2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glPolygonOffsetx(int i, int i2) {
        begin("glPolygonOffsetx");
        arg("factor", i);
        arg("units", i2);
        end();
        this.mgl.glPolygonOffsetx(i, i2);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glPopMatrix() {
        begin("glPopMatrix");
        end();
        this.mgl.glPopMatrix();
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glPushMatrix() {
        begin("glPushMatrix");
        end();
        this.mgl.glPushMatrix();
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10Ext
    public int glQueryMatrixxOES(IntBuffer intBuffer, IntBuffer intBuffer2) {
        begin("glQueryMatrixxOES");
        arg("mantissa", intBuffer.toString());
        arg("exponent", intBuffer2.toString());
        end();
        int glQueryMatrixxOES = this.mgl10Ext.glQueryMatrixxOES(intBuffer, intBuffer2);
        returns(toString(16, 2, intBuffer));
        returns(toString(16, 0, intBuffer2));
        checkError();
        return glQueryMatrixxOES;
    }

    @Override // javax.microedition.khronos.opengles.GL10Ext
    public int glQueryMatrixxOES(int[] iArr, int i, int[] iArr2, int i2) {
        begin("glQueryMatrixxOES");
        arg("mantissa", Arrays.toString(iArr));
        arg("exponent", Arrays.toString(iArr2));
        end();
        int glQueryMatrixxOES = this.mgl10Ext.glQueryMatrixxOES(iArr, i, iArr2, i2);
        returns(toString(16, 2, iArr, i));
        returns(toString(16, 0, iArr2, i2));
        checkError();
        return glQueryMatrixxOES;
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, Buffer buffer) {
        begin("glReadPixels");
        arg("x", i);
        arg("y", i2);
        arg("width", i3);
        arg("height", i4);
        arg("format", i5);
        arg("type", i6);
        arg("pixels", buffer.toString());
        end();
        this.mgl.glReadPixels(i, i2, i3, i4, i5, i6, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glRenderbufferStorageOES(int i, int i2, int i3, int i4) {
        begin("glRenderbufferStorageOES");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("internalformat", i2);
        arg("width", i3);
        arg("height", i4);
        end();
        this.mgl11ExtensionPack.glRenderbufferStorageOES(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glRotatef(float f, float f2, float f3, float f4) {
        begin("glRotatef");
        arg("angle", f);
        arg("x", f2);
        arg("y", f3);
        arg(bh.aG, f4);
        end();
        this.mgl.glRotatef(f, f2, f3, f4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glRotatex(int i, int i2, int i3, int i4) {
        begin("glRotatex");
        arg("angle", i);
        arg("x", i2);
        arg("y", i3);
        arg(bh.aG, i4);
        end();
        this.mgl.glRotatex(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glSampleCoverage(float f, boolean z) {
        begin("glSampleCoveragex");
        arg("value", f);
        arg("invert", z);
        end();
        this.mgl.glSampleCoverage(f, z);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glSampleCoveragex(int i, boolean z) {
        begin("glSampleCoveragex");
        arg("value", i);
        arg("invert", z);
        end();
        this.mgl.glSampleCoveragex(i, z);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glScalef(float f, float f2, float f3) {
        begin("glScalef");
        arg("x", f);
        arg("y", f2);
        arg(bh.aG, f3);
        end();
        this.mgl.glScalef(f, f2, f3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glScalex(int i, int i2, int i3) {
        begin("glScalex");
        arg("x", i);
        arg("y", i2);
        arg(bh.aG, i3);
        end();
        this.mgl.glScalex(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glScissor(int i, int i2, int i3, int i4) {
        begin("glScissor");
        arg("x", i);
        arg("y", i2);
        arg("width", i3);
        arg("height", i4);
        end();
        this.mgl.glScissor(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glShadeModel(int i) {
        begin("glShadeModel");
        arg("mode", getShadeModel(i));
        end();
        this.mgl.glShadeModel(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glStencilFunc(int i, int i2, int i3) {
        begin("glStencilFunc");
        arg("func", i);
        arg(OapsKey.KEY_REF, i2);
        arg("mask", i3);
        end();
        this.mgl.glStencilFunc(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glStencilMask(int i) {
        begin("glStencilMask");
        arg("mask", i);
        end();
        this.mgl.glStencilMask(i);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glStencilOp(int i, int i2, int i3) {
        begin("glStencilOp");
        arg(bc.b.S, i);
        arg("zfail", i2);
        arg("zpass", i3);
        end();
        this.mgl.glStencilOp(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexCoordPointer(int i, int i2, int i3, int i4) {
        begin("glTexCoordPointer");
        arg(OapsKey.KEY_SIZE, i);
        arg("type", i2);
        arg(MediaFormat.KEY_STRIDE, i3);
        arg("offset", i4);
        end();
        this.mgl11.glTexCoordPointer(i, i2, i3, i4);
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glTexCoordPointer(int i, int i2, int i3, Buffer buffer) {
        begin("glTexCoordPointer");
        argPointer(i, i2, i3, buffer);
        end();
        this.mTexCoordPointer = new PointerInfo(i, i2, i3, buffer);
        this.mgl.glTexCoordPointer(i, i2, i3, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexEnvf(int i, int i2, float f) {
        begin("glTexEnvf");
        arg(TypedValues.AttributesType.S_TARGET, getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(i2));
        arg(RemoteMessageConst.MessageBody.PARAM, getTextureEnvParamName(f));
        end();
        this.mgl.glTexEnvf(i, i2, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexEnvfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glTexEnvfv");
        arg(TypedValues.AttributesType.S_TARGET, getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(i2));
        arg("params", getTextureEnvParamCount(i2), floatBuffer);
        end();
        this.mgl.glTexEnvfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexEnvfv(int i, int i2, float[] fArr, int i3) {
        begin("glTexEnvfv");
        arg(TypedValues.AttributesType.S_TARGET, getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(i2));
        arg("params", getTextureEnvParamCount(i2), fArr, i3);
        arg("offset", i3);
        end();
        this.mgl.glTexEnvfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexEnvi(int i, int i2, int i3) {
        begin("glTexEnvi");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg(RemoteMessageConst.MessageBody.PARAM, i3);
        end();
        this.mgl11.glTexEnvi(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexEnviv(int i, int i2, IntBuffer intBuffer) {
        begin("glTexEnviv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glTexEnviv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexEnviv(int i, int i2, int[] iArr, int i3) {
        begin("glTexEnviv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glTexEnviv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexEnvx(int i, int i2, int i3) {
        begin("glTexEnvx");
        arg(TypedValues.AttributesType.S_TARGET, getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(i2));
        arg(RemoteMessageConst.MessageBody.PARAM, i3);
        end();
        this.mgl.glTexEnvx(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexEnvxv(int i, int i2, IntBuffer intBuffer) {
        begin("glTexEnvxv");
        arg(TypedValues.AttributesType.S_TARGET, getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(i2));
        arg("params", getTextureEnvParamCount(i2), intBuffer);
        end();
        this.mgl.glTexEnvxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexEnvxv(int i, int i2, int[] iArr, int i3) {
        begin("glTexEnvxv");
        arg(TypedValues.AttributesType.S_TARGET, getTextureEnvTarget(i));
        arg("pname", getTextureEnvPName(i2));
        arg("params", getTextureEnvParamCount(i2), iArr, i3);
        arg("offset", i3);
        end();
        this.mgl.glTexEnvxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGenf(int i, int i2, float f) {
        begin("glTexGenf");
        arg("coord", i);
        arg("pname", i2);
        arg(RemoteMessageConst.MessageBody.PARAM, f);
        end();
        this.mgl11ExtensionPack.glTexGenf(i, i2, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGenfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glTexGenfv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", floatBuffer.toString());
        end();
        this.mgl11ExtensionPack.glTexGenfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGenfv(int i, int i2, float[] fArr, int i3) {
        begin("glTexGenfv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", fArr.toString());
        arg("offset", i3);
        end();
        this.mgl11ExtensionPack.glTexGenfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGeni(int i, int i2, int i3) {
        begin("glTexGeni");
        arg("coord", i);
        arg("pname", i2);
        arg(RemoteMessageConst.MessageBody.PARAM, i3);
        end();
        this.mgl11ExtensionPack.glTexGeni(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGeniv(int i, int i2, IntBuffer intBuffer) {
        begin("glTexGeniv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glTexGeniv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGeniv(int i, int i2, int[] iArr, int i3) {
        begin("glTexGeniv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11ExtensionPack.glTexGeniv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGenx(int i, int i2, int i3) {
        begin("glTexGenx");
        arg("coord", i);
        arg("pname", i2);
        arg(RemoteMessageConst.MessageBody.PARAM, i3);
        end();
        this.mgl11ExtensionPack.glTexGenx(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGenxv(int i, int i2, IntBuffer intBuffer) {
        begin("glTexGenxv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11ExtensionPack.glTexGenxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexGenxv(int i, int i2, int[] iArr, int i3) {
        begin("glTexGenxv");
        arg("coord", i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11ExtensionPack.glTexGenxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        begin("glTexImage2D");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg(BatteryManager.EXTRA_LEVEL, i2);
        arg("internalformat", i3);
        arg("width", i4);
        arg("height", i5);
        arg("border", i6);
        arg("format", i7);
        arg("type", i8);
        arg("pixels", buffer.toString());
        end();
        this.mgl.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL11ExtensionPack
    public void glTexParameterf(int i, int i2, float f) {
        begin("glTexParameterf");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg("pname", getTexturePName(i2));
        arg(RemoteMessageConst.MessageBody.PARAM, getTextureParamName(f));
        end();
        this.mgl.glTexParameterf(i, i2, f);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        begin("glTexParameterfv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", floatBuffer.toString());
        end();
        this.mgl11.glTexParameterfv(i, i2, floatBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11, javax.microedition.khronos.opengles.GL11Ext
    public void glTexParameterfv(int i, int i2, float[] fArr, int i3) {
        begin("glTexParameterfv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", fArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glTexParameterfv(i, i2, fArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexParameteri(int i, int i2, int i3) {
        begin("glTexParameterxv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg(RemoteMessageConst.MessageBody.PARAM, i3);
        end();
        this.mgl11.glTexParameteri(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        begin("glTexParameteriv");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg("pname", getTexturePName(i2));
        arg("params", 4, intBuffer);
        end();
        this.mgl11.glTexParameteriv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexParameteriv(int i, int i2, int[] iArr, int i3) {
        begin("glTexParameteriv");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg("pname", getTexturePName(i2));
        arg("params", 4, iArr, i3);
        end();
        this.mgl11.glTexParameteriv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glTexParameterx(int i, int i2, int i3) {
        begin("glTexParameterx");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg("pname", getTexturePName(i2));
        arg(RemoteMessageConst.MessageBody.PARAM, i3);
        end();
        this.mgl.glTexParameterx(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexParameterxv(int i, int i2, IntBuffer intBuffer) {
        begin("glTexParameterxv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", intBuffer.toString());
        end();
        this.mgl11.glTexParameterxv(i, i2, intBuffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glTexParameterxv(int i, int i2, int[] iArr, int i3) {
        begin("glTexParameterxv");
        arg(TypedValues.AttributesType.S_TARGET, i);
        arg("pname", i2);
        arg("params", iArr.toString());
        arg("offset", i3);
        end();
        this.mgl11.glTexParameterxv(i, i2, iArr, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        begin("glTexSubImage2D");
        arg(TypedValues.AttributesType.S_TARGET, getTextureTarget(i));
        arg(BatteryManager.EXTRA_LEVEL, i2);
        arg("xoffset", i3);
        arg("yoffset", i4);
        arg("width", i5);
        arg("height", i6);
        arg("format", i7);
        arg("type", i8);
        arg("pixels", buffer.toString());
        end();
        this.mgl.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glTranslatef(float f, float f2, float f3) {
        begin("glTranslatef");
        arg("x", f);
        arg("y", f2);
        arg(bh.aG, f3);
        end();
        this.mgl.glTranslatef(f, f2, f3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glTranslatex(int i, int i2, int i3) {
        begin("glTranslatex");
        arg("x", i);
        arg("y", i2);
        arg(bh.aG, i3);
        end();
        this.mgl.glTranslatex(i, i2, i3);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11
    public void glVertexPointer(int i, int i2, int i3, int i4) {
        begin("glVertexPointer");
        arg(OapsKey.KEY_SIZE, i);
        arg("type", i2);
        arg(MediaFormat.KEY_STRIDE, i3);
        arg("offset", i4);
        end();
        this.mgl11.glVertexPointer(i, i2, i3, i4);
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glVertexPointer(int i, int i2, int i3, Buffer buffer) {
        begin("glVertexPointer");
        argPointer(i, i2, i3, buffer);
        end();
        this.mVertexPointer = new PointerInfo(i, i2, i3, buffer);
        this.mgl.glVertexPointer(i, i2, i3, buffer);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL10
    public void glViewport(int i, int i2, int i3, int i4) {
        begin("glViewport");
        arg("x", i);
        arg("y", i2);
        arg("width", i3);
        arg("height", i4);
        end();
        this.mgl.glViewport(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glWeightPointerOES(int i, int i2, int i3, int i4) {
        begin("glWeightPointerOES");
        arg(OapsKey.KEY_SIZE, i);
        arg("type", i2);
        arg(MediaFormat.KEY_STRIDE, i3);
        arg("offset", i4);
        end();
        this.mgl11Ext.glWeightPointerOES(i, i2, i3, i4);
        checkError();
    }

    @Override // javax.microedition.khronos.opengles.GL11Ext
    public void glWeightPointerOES(int i, int i2, int i3, Buffer buffer) {
        begin("glWeightPointerOES");
        argPointer(i, i2, i3, buffer);
        end();
        this.mgl11Ext.glWeightPointerOES(i, i2, i3, buffer);
        checkError();
    }
}
