package android.filterpacks.videoproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GLFrame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/videoproc/BackDropperFilter.class */
public class BackDropperFilter extends Filter {
    private static final float DEFAULT_ACCEPT_STDDEV = 0.85f;
    private static final float DEFAULT_ADAPT_RATE_BG = 0.0f;
    private static final float DEFAULT_ADAPT_RATE_FG = 0.0f;
    private static final String DEFAULT_AUTO_WB_SCALE = "0.25";
    private static final float DEFAULT_EXPOSURE_CHANGE = 1.0f;
    private static final int DEFAULT_HIER_LRG_EXPONENT = 3;
    private static final float DEFAULT_HIER_LRG_SCALE = 0.7f;
    private static final int DEFAULT_HIER_MID_EXPONENT = 2;
    private static final float DEFAULT_HIER_MID_SCALE = 0.6f;
    private static final int DEFAULT_HIER_SML_EXPONENT = 0;
    private static final float DEFAULT_HIER_SML_SCALE = 0.5f;
    private static final float DEFAULT_LEARNING_ADAPT_RATE = 0.2f;
    private static final int DEFAULT_LEARNING_DONE_THRESHOLD = 20;
    private static final int DEFAULT_LEARNING_DURATION = 40;
    private static final int DEFAULT_LEARNING_VERIFY_DURATION = 10;
    private static final float DEFAULT_MASK_BLEND_BG = 0.65f;
    private static final float DEFAULT_MASK_BLEND_FG = 0.95f;
    private static final int DEFAULT_MASK_HEIGHT_EXPONENT = 8;
    private static final float DEFAULT_MASK_VERIFY_RATE = 0.25f;
    private static final int DEFAULT_MASK_WIDTH_EXPONENT = 8;
    private static final float DEFAULT_UV_SCALE_FACTOR = 1.35f;
    private static final float DEFAULT_WHITE_BALANCE_BLUE_CHANGE = 0.0f;
    private static final float DEFAULT_WHITE_BALANCE_RED_CHANGE = 0.0f;
    private static final int DEFAULT_WHITE_BALANCE_TOGGLE = 0;
    private static final float DEFAULT_Y_SCALE_FACTOR = 0.4f;
    private static final String DISTANCE_STORAGE_SCALE = "0.6";
    private static final String MASK_SMOOTH_EXPONENT = "2.0";
    private static final String MIN_VARIANCE = "3.0";
    private static final String RGB_TO_YUV_MATRIX = "0.299, -0.168736,  0.5,      0.000, 0.587, -0.331264, -0.418688, 0.000, 0.114,  0.5,      -0.081312, 0.000, 0.000,  0.5,       0.5,      1.000 ";
    private static final String TAG = "BackDropperFilter";
    private static final String VARIANCE_STORAGE_SCALE = "5.0";
    private static final String mAutomaticWhiteBalance = "uniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform float pyramid_depth;\nuniform bool autowb_toggle;\nvarying vec2 v_texcoord;\nvoid main() {\n   vec4 mean_video = texture2D(tex_sampler_0, v_texcoord, pyramid_depth);\n   vec4 mean_bg = texture2D(tex_sampler_1, v_texcoord, pyramid_depth);\n   float green_normalizer = mean_video.g / mean_bg.g;\n   vec4 adjusted_value = vec4(mean_bg.r / mean_video.r * green_normalizer, 1., \n                         mean_bg.b / mean_video.b * green_normalizer, 1.) * auto_wb_scale; \n   gl_FragColor = autowb_toggle ? adjusted_value : vec4(auto_wb_scale);\n}\n";
    private static final String mBgDistanceShader = "uniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform sampler2D tex_sampler_2;\nuniform float subsample_level;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 fg_rgb = texture2D(tex_sampler_0, v_texcoord, subsample_level);\n  vec4 fg = coeff_yuv * vec4(fg_rgb.rgb, 1.);\n  vec4 mean = texture2D(tex_sampler_1, v_texcoord);\n  vec4 variance = inv_var_scale * texture2D(tex_sampler_2, v_texcoord);\n\n  float dist_y = gauss_dist_y(fg.r, mean.r, variance.r);\n  float dist_uv = gauss_dist_uv(fg.gb, mean.gb, variance.gb);\n  gl_FragColor = vec4(0.5*fg.rg, dist_scale*dist_y, dist_scale*dist_uv);\n}\n";
    private static final String mBgMaskShader = "uniform sampler2D tex_sampler_0;\nuniform float accept_variance;\nuniform vec2 yuv_weights;\nuniform float scale_lrg;\nuniform float scale_mid;\nuniform float scale_sml;\nuniform float exp_lrg;\nuniform float exp_mid;\nuniform float exp_sml;\nvarying vec2 v_texcoord;\nbool is_fg(vec2 dist_yc, float accept_variance) {\n  return ( dot(yuv_weights, dist_yc) >= accept_variance );\n}\nvoid main() {\n  vec4 dist_lrg_sc = texture2D(tex_sampler_0, v_texcoord, exp_lrg);\n  vec4 dist_mid_sc = texture2D(tex_sampler_0, v_texcoord, exp_mid);\n  vec4 dist_sml_sc = texture2D(tex_sampler_0, v_texcoord, exp_sml);\n  vec2 dist_lrg = inv_dist_scale * dist_lrg_sc.ba;\n  vec2 dist_mid = inv_dist_scale * dist_mid_sc.ba;\n  vec2 dist_sml = inv_dist_scale * dist_sml_sc.ba;\n  vec2 norm_dist = 0.75 * dist_sml / accept_variance;\n  bool is_fg_lrg = is_fg(dist_lrg, accept_variance * scale_lrg);\n  bool is_fg_mid = is_fg_lrg || is_fg(dist_mid, accept_variance * scale_mid);\n  float is_fg_sml =\n      float(is_fg_mid || is_fg(dist_sml, accept_variance * scale_sml));\n  float alpha = 0.5 * is_fg_sml + 0.3 * float(is_fg_mid) + 0.2 * float(is_fg_lrg);\n  gl_FragColor = vec4(alpha, norm_dist, is_fg_sml);\n}\n";
    private static final String mBgSubtractForceShader = "  vec4 ghost_rgb = (fg_adjusted * 0.7 + vec4(0.3,0.3,0.4,0.))*0.65 + \n                   0.35*bg_rgb;\n  float glow_start = 0.75 * mask_blend_bg; \n  float glow_max   = mask_blend_bg; \n  gl_FragColor = mask.a < glow_start ? bg_rgb : \n                 mask.a < glow_max ? mix(bg_rgb, vec4(0.9,0.9,1.0,1.0), \n                                     (mask.a - glow_start) / (glow_max - glow_start) ) : \n                 mask.a < mask_blend_fg ? mix(vec4(0.9,0.9,1.0,1.0), ghost_rgb, \n                                    (mask.a - glow_max) / (mask_blend_fg - glow_max) ) : \n                 ghost_rgb;\n}\n";
    private static final String mBgSubtractShader = "uniform mat3 bg_fit_transform;\nuniform float mask_blend_bg;\nuniform float mask_blend_fg;\nuniform float exposure_change;\nuniform float whitebalancered_change;\nuniform float whitebalanceblue_change;\nuniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform sampler2D tex_sampler_2;\nuniform sampler2D tex_sampler_3;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec2 bg_texcoord = (bg_fit_transform * vec3(v_texcoord, 1.)).xy;\n  vec4 bg_rgb = texture2D(tex_sampler_1, bg_texcoord);\n  vec4 wb_auto_scale = texture2D(tex_sampler_3, v_texcoord) * exposure_change / auto_wb_scale;\n  vec4 wb_manual_scale = vec4(1. + whitebalancered_change, 1., 1. + whitebalanceblue_change, 1.);\n  vec4 fg_rgb = texture2D(tex_sampler_0, v_texcoord);\n  vec4 fg_adjusted = fg_rgb * wb_manual_scale * wb_auto_scale;\n  vec4 mask = texture2D(tex_sampler_2, v_texcoord, \n                      2.0);\n  float alpha = smoothstep(mask_blend_bg, mask_blend_fg, mask.a);\n  gl_FragColor = mix(bg_rgb, fg_adjusted, alpha);\n";
    private static final String mMaskVerifyShader = "uniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform float verify_rate;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 lastmask = texture2D(tex_sampler_0, v_texcoord);\n  vec4 mask = texture2D(tex_sampler_1, v_texcoord);\n  float newmask = mix(lastmask.a, mask.a, verify_rate);\n  gl_FragColor = vec4(0., 0., 0., newmask);\n}\n";
    private static final String mUpdateBgModelMeanShader = "uniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform sampler2D tex_sampler_2;\nuniform float subsample_level;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 fg_rgb = texture2D(tex_sampler_0, v_texcoord, subsample_level);\n  vec4 fg = coeff_yuv * vec4(fg_rgb.rgb, 1.);\n  vec4 mean = texture2D(tex_sampler_1, v_texcoord);\n  vec4 mask = texture2D(tex_sampler_2, v_texcoord, \n                      2.0);\n\n  float alpha = local_adapt_rate(mask.a);\n  vec4 new_mean = mix(mean, fg, alpha);\n  gl_FragColor = new_mean;\n}\n";
    private static final String mUpdateBgModelVarianceShader = "uniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform sampler2D tex_sampler_2;\nuniform sampler2D tex_sampler_3;\nuniform float subsample_level;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 fg_rgb = texture2D(tex_sampler_0, v_texcoord, subsample_level);\n  vec4 fg = coeff_yuv * vec4(fg_rgb.rgb, 1.);\n  vec4 mean = texture2D(tex_sampler_1, v_texcoord);\n  vec4 variance = inv_var_scale * texture2D(tex_sampler_2, v_texcoord);\n  vec4 mask = texture2D(tex_sampler_3, v_texcoord, \n                      2.0);\n\n  float alpha = local_adapt_rate(mask.a);\n  vec4 cur_variance = (fg-mean)*(fg-mean);\n  vec4 new_variance = mix(variance, cur_variance, alpha);\n  new_variance = max(new_variance, vec4(min_variance));\n  gl_FragColor = var_scale * new_variance;\n}\n";
    private final int BACKGROUND_FILL_CROP;
    private final int BACKGROUND_FIT;
    private final int BACKGROUND_STRETCH;
    private ShaderProgram copyShaderProgram;
    private boolean isOpen;
    @GenerateFieldPort(hasDefault = true, name = "acceptStddev")
    private float mAcceptStddev;
    @GenerateFieldPort(hasDefault = true, name = "adaptRateBg")
    private float mAdaptRateBg;
    @GenerateFieldPort(hasDefault = true, name = "adaptRateFg")
    private float mAdaptRateFg;
    @GenerateFieldPort(hasDefault = true, name = "learningAdaptRate")
    private float mAdaptRateLearning;
    private GLFrame mAutoWB;
    @GenerateFieldPort(hasDefault = true, name = "autowbToggle")
    private int mAutoWBToggle;
    private ShaderProgram mAutomaticWhiteBalanceProgram;
    private MutableFrameFormat mAverageFormat;
    @GenerateFieldPort(hasDefault = true, name = "backgroundFitMode")
    private int mBackgroundFitMode;
    private boolean mBackgroundFitModeChanged;
    private ShaderProgram mBgDistProgram;
    private GLFrame mBgInput;
    private ShaderProgram mBgMaskProgram;
    private GLFrame[] mBgMean;
    private ShaderProgram mBgSubtractProgram;
    private ShaderProgram mBgUpdateMeanProgram;
    private ShaderProgram mBgUpdateVarianceProgram;
    private GLFrame[] mBgVariance;
    @GenerateFieldPort(hasDefault = true, name = "chromaScale")
    private float mChromaScale;
    private ShaderProgram mCopyOutProgram;
    private GLFrame mDistance;
    @GenerateFieldPort(hasDefault = true, name = "exposureChange")
    private float mExposureChange;
    private int mFrameCount;
    @GenerateFieldPort(hasDefault = true, name = "hierLrgExp")
    private int mHierarchyLrgExp;
    @GenerateFieldPort(hasDefault = true, name = "hierLrgScale")
    private float mHierarchyLrgScale;
    @GenerateFieldPort(hasDefault = true, name = "hierMidExp")
    private int mHierarchyMidExp;
    @GenerateFieldPort(hasDefault = true, name = "hierMidScale")
    private float mHierarchyMidScale;
    @GenerateFieldPort(hasDefault = true, name = "hierSmlExp")
    private int mHierarchySmlExp;
    @GenerateFieldPort(hasDefault = true, name = "hierSmlScale")
    private float mHierarchySmlScale;
    @GenerateFieldPort(hasDefault = true, name = "learningDoneListener")
    private LearningDoneListener mLearningDoneListener;
    @GenerateFieldPort(hasDefault = true, name = "learningDuration")
    private int mLearningDuration;
    @GenerateFieldPort(hasDefault = true, name = "learningVerifyDuration")
    private int mLearningVerifyDuration;
    private final boolean mLogVerbose;
    @GenerateFieldPort(hasDefault = true, name = "lumScale")
    private float mLumScale;
    private GLFrame mMask;
    private GLFrame mMaskAverage;
    @GenerateFieldPort(hasDefault = true, name = "maskBg")
    private float mMaskBg;
    @GenerateFieldPort(hasDefault = true, name = "maskFg")
    private float mMaskFg;
    private MutableFrameFormat mMaskFormat;
    @GenerateFieldPort(hasDefault = true, name = "maskHeightExp")
    private int mMaskHeightExp;
    private GLFrame[] mMaskVerify;
    private ShaderProgram mMaskVerifyProgram;
    @GenerateFieldPort(hasDefault = true, name = "maskWidthExp")
    private int mMaskWidthExp;
    private MutableFrameFormat mMemoryFormat;
    @GenerateFieldPort(hasDefault = true, name = "mirrorBg")
    private boolean mMirrorBg;
    @GenerateFieldPort(hasDefault = true, name = "orientation")
    private int mOrientation;
    private FrameFormat mOutputFormat;
    private boolean mPingPong;
    @GenerateFinalPort(hasDefault = true, name = "provideDebugOutputs")
    private boolean mProvideDebugOutputs;
    private int mPyramidDepth;
    private float mRelativeAspect;
    private boolean mStartLearning;
    private int mSubsampleLevel;
    @GenerateFieldPort(hasDefault = true, name = "useTheForce")
    private boolean mUseTheForce;
    @GenerateFieldPort(hasDefault = true, name = "maskVerifyRate")
    private float mVerifyRate;
    private GLFrame mVideoInput;
    @GenerateFieldPort(hasDefault = true, name = "whitebalanceblueChange")
    private float mWhiteBalanceBlueChange;
    @GenerateFieldPort(hasDefault = true, name = "whitebalanceredChange")
    private float mWhiteBalanceRedChange;
    private long startTime;
    private static final float[] DEFAULT_BG_FIT_TRANSFORM = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final String[] mInputNames = {"video", "background"};
    private static final String[] mOutputNames = {"video"};
    private static final String[] mDebugOutputNames = {"debug1", "debug2"};
    private static String mSharedUtilShader = "precision mediump float;\nuniform float fg_adapt_rate;\nuniform float bg_adapt_rate;\nconst mat4 coeff_yuv = mat4(0.299, -0.168736,  0.5,      0.000, 0.587, -0.331264, -0.418688, 0.000, 0.114,  0.5,      -0.081312, 0.000, 0.000,  0.5,       0.5,      1.000 );\nconst float dist_scale = 0.6;\nconst float inv_dist_scale = 1. / dist_scale;\nconst float var_scale=5.0;\nconst float inv_var_scale = 1. / var_scale;\nconst float min_variance = inv_var_scale *3.0/ 256.;\nconst float auto_wb_scale = 0.25;\n\nfloat gauss_dist_y(float y, float mean, float variance) {\n  float dist = (y - mean) * (y - mean) / variance;\n  return dist;\n}\nfloat gauss_dist_uv(vec2 uv, vec2 mean, vec2 variance) {\n  vec2 dist = (uv - mean) * (uv - mean) / variance;\n  return dist.r + dist.g;\n}\nfloat local_adapt_rate(float alpha) {\n  return mix(bg_adapt_rate, fg_adapt_rate, alpha);\n}\n\n";

    /* loaded from: source-9557208-dex2jar.jar:android/filterpacks/videoproc/BackDropperFilter$LearningDoneListener.class */
    public interface LearningDoneListener {
        void onLearningDone(BackDropperFilter backDropperFilter);
    }

    public BackDropperFilter(String str) {
        super(str);
        this.BACKGROUND_STRETCH = 0;
        this.BACKGROUND_FIT = 1;
        this.BACKGROUND_FILL_CROP = 2;
        this.mBackgroundFitMode = 2;
        this.mLearningDuration = 40;
        this.mLearningVerifyDuration = 10;
        this.mAcceptStddev = DEFAULT_ACCEPT_STDDEV;
        this.mHierarchyLrgScale = 0.7f;
        this.mHierarchyMidScale = 0.6f;
        this.mHierarchySmlScale = 0.5f;
        this.mMaskWidthExp = 8;
        this.mMaskHeightExp = 8;
        this.mHierarchyLrgExp = 3;
        this.mHierarchyMidExp = 2;
        this.mHierarchySmlExp = 0;
        this.mLumScale = 0.4f;
        this.mChromaScale = DEFAULT_UV_SCALE_FACTOR;
        this.mMaskBg = DEFAULT_MASK_BLEND_BG;
        this.mMaskFg = 0.95f;
        this.mExposureChange = 1.0f;
        this.mWhiteBalanceRedChange = 0.0f;
        this.mWhiteBalanceBlueChange = 0.0f;
        this.mAutoWBToggle = 0;
        this.mAdaptRateLearning = 0.2f;
        this.mAdaptRateBg = 0.0f;
        this.mAdaptRateFg = 0.0f;
        this.mVerifyRate = 0.25f;
        this.mLearningDoneListener = null;
        this.mUseTheForce = false;
        this.mProvideDebugOutputs = false;
        this.mMirrorBg = false;
        this.mOrientation = 0;
        this.startTime = -1L;
        this.mLogVerbose = Log.isLoggable(TAG, 2);
        String str2 = SystemProperties.get("ro.media.effect.bgdropper.adj");
        if (str2.length() > 0) {
            try {
                this.mAcceptStddev += Float.parseFloat(str2);
                if (this.mLogVerbose) {
                    Log.v(TAG, "Adjusting accept threshold by " + str2 + ", now " + this.mAcceptStddev);
                }
            } catch (NumberFormatException e) {
                Log.e(TAG, "Badly formatted property ro.media.effect.bgdropper.adj: " + str2);
            }
        }
    }

    private void allocateFrames(FrameFormat frameFormat, FilterContext filterContext) {
        if (createMemoryFormat(frameFormat)) {
            if (this.mLogVerbose) {
                Log.v(TAG, "Allocating BackDropperFilter frames");
            }
            int size = this.mMaskFormat.getSize();
            byte[] bArr = new byte[size];
            byte[] bArr2 = new byte[size];
            byte[] bArr3 = new byte[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                bArr[i2] = Byte.MIN_VALUE;
                bArr2[i2] = 10;
                bArr3[i2] = 0;
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 2) {
                    break;
                }
                this.mBgMean[i4] = (GLFrame) filterContext.getFrameManager().newFrame(this.mMaskFormat);
                this.mBgMean[i4].setData(bArr, 0, size);
                this.mBgVariance[i4] = (GLFrame) filterContext.getFrameManager().newFrame(this.mMaskFormat);
                this.mBgVariance[i4].setData(bArr2, 0, size);
                this.mMaskVerify[i4] = (GLFrame) filterContext.getFrameManager().newFrame(this.mMaskFormat);
                this.mMaskVerify[i4].setData(bArr3, 0, size);
                i3 = i4 + 1;
            }
            if (this.mLogVerbose) {
                Log.v(TAG, "Done allocating texture for Mean and Variance objects!");
            }
            this.mDistance = (GLFrame) filterContext.getFrameManager().newFrame(this.mMaskFormat);
            this.mMask = (GLFrame) filterContext.getFrameManager().newFrame(this.mMaskFormat);
            this.mAutoWB = (GLFrame) filterContext.getFrameManager().newFrame(this.mAverageFormat);
            this.mVideoInput = (GLFrame) filterContext.getFrameManager().newFrame(this.mMemoryFormat);
            this.mBgInput = (GLFrame) filterContext.getFrameManager().newFrame(this.mMemoryFormat);
            this.mMaskAverage = (GLFrame) filterContext.getFrameManager().newFrame(this.mAverageFormat);
            this.mBgDistProgram = new ShaderProgram(filterContext, mSharedUtilShader + mBgDistanceShader);
            this.mBgDistProgram.setHostValue("subsample_level", Float.valueOf(this.mSubsampleLevel));
            this.mBgMaskProgram = new ShaderProgram(filterContext, mSharedUtilShader + mBgMaskShader);
            this.mBgMaskProgram.setHostValue("accept_variance", Float.valueOf(this.mAcceptStddev * this.mAcceptStddev));
            this.mBgMaskProgram.setHostValue("yuv_weights", new float[]{this.mLumScale, this.mChromaScale});
            this.mBgMaskProgram.setHostValue("scale_lrg", Float.valueOf(this.mHierarchyLrgScale));
            this.mBgMaskProgram.setHostValue("scale_mid", Float.valueOf(this.mHierarchyMidScale));
            this.mBgMaskProgram.setHostValue("scale_sml", Float.valueOf(this.mHierarchySmlScale));
            this.mBgMaskProgram.setHostValue("exp_lrg", Float.valueOf(this.mSubsampleLevel + this.mHierarchyLrgExp));
            this.mBgMaskProgram.setHostValue("exp_mid", Float.valueOf(this.mSubsampleLevel + this.mHierarchyMidExp));
            this.mBgMaskProgram.setHostValue("exp_sml", Float.valueOf(this.mSubsampleLevel + this.mHierarchySmlExp));
            if (this.mUseTheForce) {
                this.mBgSubtractProgram = new ShaderProgram(filterContext, mSharedUtilShader + mBgSubtractShader + mBgSubtractForceShader);
            } else {
                this.mBgSubtractProgram = new ShaderProgram(filterContext, mSharedUtilShader + mBgSubtractShader + "}\n");
            }
            this.mBgSubtractProgram.setHostValue("bg_fit_transform", DEFAULT_BG_FIT_TRANSFORM);
            this.mBgSubtractProgram.setHostValue("mask_blend_bg", Float.valueOf(this.mMaskBg));
            this.mBgSubtractProgram.setHostValue("mask_blend_fg", Float.valueOf(this.mMaskFg));
            this.mBgSubtractProgram.setHostValue("exposure_change", Float.valueOf(this.mExposureChange));
            this.mBgSubtractProgram.setHostValue("whitebalanceblue_change", Float.valueOf(this.mWhiteBalanceBlueChange));
            this.mBgSubtractProgram.setHostValue("whitebalancered_change", Float.valueOf(this.mWhiteBalanceRedChange));
            this.mBgUpdateMeanProgram = new ShaderProgram(filterContext, mSharedUtilShader + mUpdateBgModelMeanShader);
            this.mBgUpdateMeanProgram.setHostValue("subsample_level", Float.valueOf(this.mSubsampleLevel));
            this.mBgUpdateVarianceProgram = new ShaderProgram(filterContext, mSharedUtilShader + mUpdateBgModelVarianceShader);
            this.mBgUpdateVarianceProgram.setHostValue("subsample_level", Float.valueOf(this.mSubsampleLevel));
            this.mCopyOutProgram = ShaderProgram.createIdentity(filterContext);
            this.mAutomaticWhiteBalanceProgram = new ShaderProgram(filterContext, mSharedUtilShader + mAutomaticWhiteBalance);
            this.mAutomaticWhiteBalanceProgram.setHostValue("pyramid_depth", Float.valueOf(this.mPyramidDepth));
            this.mAutomaticWhiteBalanceProgram.setHostValue("autowb_toggle", Integer.valueOf(this.mAutoWBToggle));
            this.mMaskVerifyProgram = new ShaderProgram(filterContext, mSharedUtilShader + mMaskVerifyShader);
            this.mMaskVerifyProgram.setHostValue("verify_rate", Float.valueOf(this.mVerifyRate));
            if (this.mLogVerbose) {
                Log.v(TAG, "Shader width set to " + this.mMemoryFormat.getWidth());
            }
            this.mRelativeAspect = 1.0f;
            this.mFrameCount = 0;
            this.mStartLearning = true;
        }
    }

    private boolean createMemoryFormat(FrameFormat frameFormat) {
        if (this.mMemoryFormat != null) {
            return false;
        }
        if (frameFormat.getWidth() == 0 || frameFormat.getHeight() == 0) {
            throw new RuntimeException("Attempting to process input frame with unknown size");
        }
        this.mMaskFormat = frameFormat.mutableCopy();
        int pow = (int) Math.pow(2.0d, this.mMaskWidthExp);
        int pow2 = (int) Math.pow(2.0d, this.mMaskHeightExp);
        this.mMaskFormat.setDimensions(pow, pow2);
        this.mPyramidDepth = Math.max(this.mMaskWidthExp, this.mMaskHeightExp);
        this.mMemoryFormat = this.mMaskFormat.mutableCopy();
        int max = Math.max(this.mMaskWidthExp, pyramidLevel(frameFormat.getWidth()));
        int max2 = Math.max(this.mMaskHeightExp, pyramidLevel(frameFormat.getHeight()));
        this.mPyramidDepth = Math.max(max, max2);
        int max3 = Math.max(pow, (int) Math.pow(2.0d, max));
        int max4 = Math.max(pow2, (int) Math.pow(2.0d, max2));
        this.mMemoryFormat.setDimensions(max3, max4);
        this.mSubsampleLevel = this.mPyramidDepth - Math.max(this.mMaskWidthExp, this.mMaskHeightExp);
        if (this.mLogVerbose) {
            Log.v(TAG, "Mask frames size " + pow + " x " + pow2);
            Log.v(TAG, "Pyramid levels " + max + " x " + max2);
            Log.v(TAG, "Memory frames size " + max3 + " x " + max4);
        }
        this.mAverageFormat = frameFormat.mutableCopy();
        this.mAverageFormat.setDimensions(1, 1);
        return true;
    }

    private int pyramidLevel(int i) {
        return ((int) Math.floor(Math.log10(i) / Math.log10(2.0d))) - 1;
    }

    private void updateBgScaling(Frame frame, Frame frame2, boolean z) {
        float width = (frame.getFormat().getWidth() / frame.getFormat().getHeight()) / (frame2.getFormat().getWidth() / frame2.getFormat().getHeight());
        if (width != this.mRelativeAspect || z) {
            this.mRelativeAspect = width;
            float f = 0.0f;
            float f2 = 1.0f;
            float f3 = 0.0f;
            float f4 = 1.0f;
            switch (this.mBackgroundFitMode) {
                case 0:
                    break;
                case 1:
                    if (this.mRelativeAspect <= 1.0f) {
                        f3 = 0.5f - (0.5f / this.mRelativeAspect);
                        f4 = 1.0f / this.mRelativeAspect;
                        f = 0.0f;
                        f2 = 1.0f;
                        break;
                    } else {
                        f = 0.5f - (0.5f * this.mRelativeAspect);
                        f2 = 1.0f * this.mRelativeAspect;
                        f3 = 0.0f;
                        f4 = 1.0f;
                        break;
                    }
                case 2:
                    if (this.mRelativeAspect <= 1.0f) {
                        f = 0.5f - (0.5f * this.mRelativeAspect);
                        f2 = this.mRelativeAspect;
                        f3 = 0.0f;
                        f4 = 1.0f;
                        break;
                    } else {
                        f3 = 0.5f - (0.5f / this.mRelativeAspect);
                        f4 = 1.0f / this.mRelativeAspect;
                        f = 0.0f;
                        f2 = 1.0f;
                        break;
                    }
                default:
                    f4 = 1.0f;
                    f3 = 0.0f;
                    f2 = 1.0f;
                    f = 0.0f;
                    break;
            }
            float f5 = f;
            float f6 = f2;
            float f7 = f3;
            float f8 = f4;
            if (this.mMirrorBg) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Mirroring the background!");
                }
                if (this.mOrientation == 0 || this.mOrientation == 180) {
                    f6 = -f2;
                    f5 = 1.0f - f;
                    f8 = f4;
                    f7 = f3;
                } else {
                    f8 = -f4;
                    f7 = 1.0f - f3;
                    f5 = f;
                    f6 = f2;
                }
            }
            if (this.mLogVerbose) {
                Log.v(TAG, "bgTransform: xMin, yMin, xWidth, yWidth : " + f5 + ", " + f7 + ", " + f6 + ", " + f8 + ", mRelAspRatio = " + this.mRelativeAspect);
            }
            this.mBgSubtractProgram.setHostValue("bg_fit_transform", new float[]{f6, 0.0f, 0.0f, 0.0f, f8, 0.0f, f5, f7, 1.0f});
        }
    }

    @Override // android.filterfw.core.Filter
    public void close(FilterContext filterContext) {
        if (this.mMemoryFormat == null) {
            return;
        }
        if (this.mLogVerbose) {
            Log.v(TAG, "Filter Closing!");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                this.mDistance.release();
                this.mMask.release();
                this.mAutoWB.release();
                this.mVideoInput.release();
                this.mBgInput.release();
                this.mMaskAverage.release();
                this.mMemoryFormat = null;
                return;
            }
            this.mBgMean[i2].release();
            this.mBgVariance[i2].release();
            this.mMaskVerify[i2].release();
            i = i2 + 1;
        }
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (str.equals("backgroundFitMode")) {
            this.mBackgroundFitModeChanged = true;
        } else if (str.equals("acceptStddev")) {
            this.mBgMaskProgram.setHostValue("accept_variance", Float.valueOf(this.mAcceptStddev * this.mAcceptStddev));
        } else if (str.equals("hierLrgScale")) {
            this.mBgMaskProgram.setHostValue("scale_lrg", Float.valueOf(this.mHierarchyLrgScale));
        } else if (str.equals("hierMidScale")) {
            this.mBgMaskProgram.setHostValue("scale_mid", Float.valueOf(this.mHierarchyMidScale));
        } else if (str.equals("hierSmlScale")) {
            this.mBgMaskProgram.setHostValue("scale_sml", Float.valueOf(this.mHierarchySmlScale));
        } else if (str.equals("hierLrgExp")) {
            this.mBgMaskProgram.setHostValue("exp_lrg", Float.valueOf(this.mSubsampleLevel + this.mHierarchyLrgExp));
        } else if (str.equals("hierMidExp")) {
            this.mBgMaskProgram.setHostValue("exp_mid", Float.valueOf(this.mSubsampleLevel + this.mHierarchyMidExp));
        } else if (str.equals("hierSmlExp")) {
            this.mBgMaskProgram.setHostValue("exp_sml", Float.valueOf(this.mSubsampleLevel + this.mHierarchySmlExp));
        } else if (str.equals("lumScale") || str.equals("chromaScale")) {
            this.mBgMaskProgram.setHostValue("yuv_weights", new float[]{this.mLumScale, this.mChromaScale});
        } else if (str.equals("maskBg")) {
            this.mBgSubtractProgram.setHostValue("mask_blend_bg", Float.valueOf(this.mMaskBg));
        } else if (str.equals("maskFg")) {
            this.mBgSubtractProgram.setHostValue("mask_blend_fg", Float.valueOf(this.mMaskFg));
        } else if (str.equals("exposureChange")) {
            this.mBgSubtractProgram.setHostValue("exposure_change", Float.valueOf(this.mExposureChange));
        } else if (str.equals("whitebalanceredChange")) {
            this.mBgSubtractProgram.setHostValue("whitebalancered_change", Float.valueOf(this.mWhiteBalanceRedChange));
        } else if (str.equals("whitebalanceblueChange")) {
            this.mBgSubtractProgram.setHostValue("whitebalanceblue_change", Float.valueOf(this.mWhiteBalanceBlueChange));
        } else if (str.equals("autowbToggle")) {
            this.mAutomaticWhiteBalanceProgram.setHostValue("autowb_toggle", Integer.valueOf(this.mAutoWBToggle));
        }
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        MutableFrameFormat mutableCopy = frameFormat.mutableCopy();
        if (!Arrays.asList(mOutputNames).contains(str)) {
            mutableCopy.setDimensions(0, 0);
        }
        return mutableCopy;
    }

    @Override // android.filterfw.core.Filter
    public void prepare(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Preparing BackDropperFilter!");
        }
        this.mBgMean = new GLFrame[2];
        this.mBgVariance = new GLFrame[2];
        this.mMaskVerify = new GLFrame[2];
        this.copyShaderProgram = ShaderProgram.createIdentity(filterContext);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("video");
        Frame pullInput2 = pullInput("background");
        allocateFrames(pullInput.getFormat(), filterContext);
        if (this.mStartLearning) {
            if (this.mLogVerbose) {
                Log.v(TAG, "Starting learning");
            }
            this.mBgUpdateMeanProgram.setHostValue("bg_adapt_rate", Float.valueOf(this.mAdaptRateLearning));
            this.mBgUpdateMeanProgram.setHostValue("fg_adapt_rate", Float.valueOf(this.mAdaptRateLearning));
            this.mBgUpdateVarianceProgram.setHostValue("bg_adapt_rate", Float.valueOf(this.mAdaptRateLearning));
            this.mBgUpdateVarianceProgram.setHostValue("fg_adapt_rate", Float.valueOf(this.mAdaptRateLearning));
            this.mFrameCount = 0;
        }
        char c2 = this.mPingPong ? (char) 0 : (char) 1;
        char c3 = this.mPingPong ? (char) 1 : (char) 0;
        this.mPingPong = !this.mPingPong;
        updateBgScaling(pullInput, pullInput2, this.mBackgroundFitModeChanged);
        this.mBackgroundFitModeChanged = false;
        this.copyShaderProgram.process(pullInput, this.mVideoInput);
        this.copyShaderProgram.process(pullInput2, this.mBgInput);
        this.mVideoInput.generateMipMap();
        this.mVideoInput.setTextureParameter(10241, 9985);
        this.mBgInput.generateMipMap();
        this.mBgInput.setTextureParameter(10241, 9985);
        if (this.mStartLearning) {
            this.copyShaderProgram.process(this.mVideoInput, this.mBgMean[c2]);
            this.mStartLearning = false;
        }
        this.mBgDistProgram.process(new Frame[]{this.mVideoInput, this.mBgMean[c2], this.mBgVariance[c2]}, this.mDistance);
        this.mDistance.generateMipMap();
        this.mDistance.setTextureParameter(10241, 9985);
        this.mBgMaskProgram.process(this.mDistance, this.mMask);
        this.mMask.generateMipMap();
        this.mMask.setTextureParameter(10241, 9985);
        this.mAutomaticWhiteBalanceProgram.process(new Frame[]{this.mVideoInput, this.mBgInput}, this.mAutoWB);
        if (this.mFrameCount <= this.mLearningDuration) {
            pushOutput("video", pullInput);
            if (this.mFrameCount == this.mLearningDuration - this.mLearningVerifyDuration) {
                this.copyShaderProgram.process(this.mMask, this.mMaskVerify[c3]);
                this.mBgUpdateMeanProgram.setHostValue("bg_adapt_rate", Float.valueOf(this.mAdaptRateBg));
                this.mBgUpdateMeanProgram.setHostValue("fg_adapt_rate", Float.valueOf(this.mAdaptRateFg));
                this.mBgUpdateVarianceProgram.setHostValue("bg_adapt_rate", Float.valueOf(this.mAdaptRateBg));
                this.mBgUpdateVarianceProgram.setHostValue("fg_adapt_rate", Float.valueOf(this.mAdaptRateFg));
            } else if (this.mFrameCount > this.mLearningDuration - this.mLearningVerifyDuration) {
                this.mMaskVerifyProgram.process(new Frame[]{this.mMaskVerify[c2], this.mMask}, this.mMaskVerify[c3]);
                this.mMaskVerify[c3].generateMipMap();
                this.mMaskVerify[c3].setTextureParameter(10241, 9985);
            }
            if (this.mFrameCount == this.mLearningDuration) {
                this.copyShaderProgram.process(this.mMaskVerify[c3], this.mMaskAverage);
                int i = this.mMaskAverage.getData().array()[3] & 255;
                if (this.mLogVerbose) {
                    Log.v(TAG, String.format("Mask_average is %d, threshold is %d", Integer.valueOf(i), 20));
                }
                if (i >= 20) {
                    this.mStartLearning = true;
                } else {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Learning done");
                    }
                    if (this.mLearningDoneListener != null) {
                        this.mLearningDoneListener.onLearningDone(this);
                    }
                }
            }
        } else {
            Frame newFrame = filterContext.getFrameManager().newFrame(pullInput.getFormat());
            this.mBgSubtractProgram.process(new Frame[]{pullInput, pullInput2, this.mMask, this.mAutoWB}, newFrame);
            pushOutput("video", newFrame);
            newFrame.release();
        }
        if (this.mFrameCount < this.mLearningDuration - this.mLearningVerifyDuration || this.mAdaptRateBg > 0.0d || this.mAdaptRateFg > 0.0d) {
            this.mBgUpdateMeanProgram.process(new Frame[]{this.mVideoInput, this.mBgMean[c2], this.mMask}, this.mBgMean[c3]);
            this.mBgMean[c3].generateMipMap();
            this.mBgMean[c3].setTextureParameter(10241, 9985);
            this.mBgUpdateVarianceProgram.process(new Frame[]{this.mVideoInput, this.mBgMean[c2], this.mBgVariance[c2], this.mMask}, this.mBgVariance[c3]);
            this.mBgVariance[c3].generateMipMap();
            this.mBgVariance[c3].setTextureParameter(10241, 9985);
        }
        if (this.mProvideDebugOutputs) {
            Frame newFrame2 = filterContext.getFrameManager().newFrame(pullInput.getFormat());
            this.mCopyOutProgram.process(pullInput, newFrame2);
            pushOutput("debug1", newFrame2);
            newFrame2.release();
            Frame newFrame3 = filterContext.getFrameManager().newFrame(this.mMemoryFormat);
            this.mCopyOutProgram.process(this.mMask, newFrame3);
            pushOutput("debug2", newFrame3);
            newFrame3.release();
        }
        this.mFrameCount++;
        if (this.mLogVerbose && this.mFrameCount % 30 == 0) {
            if (this.startTime == -1) {
                filterContext.getGLEnvironment().activate();
                GLES20.glFinish();
                this.startTime = SystemClock.elapsedRealtime();
                return;
            }
            filterContext.getGLEnvironment().activate();
            GLES20.glFinish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Log.v(TAG, "Avg. frame duration: " + String.format("%.2f", Double.valueOf((elapsedRealtime - this.startTime) / 30.0d)) + " ms. Avg. fps: " + String.format("%.2f", Double.valueOf(1000.0d / ((elapsedRealtime - this.startTime) / 30.0d))));
            this.startTime = elapsedRealtime;
        }
    }

    public void relearn() {
        synchronized (this) {
            this.mStartLearning = true;
        }
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        MutableFrameFormat create = ImageFormat.create(3, 0);
        String[] strArr = mInputNames;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            addMaskedInputPort(strArr[i2], create);
            i = i2 + 1;
        }
        String[] strArr2 = mOutputNames;
        int length2 = strArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                break;
            }
            addOutputBasedOnInput(strArr2[i4], "video");
            i3 = i4 + 1;
        }
        if (!this.mProvideDebugOutputs) {
            return;
        }
        String[] strArr3 = mDebugOutputNames;
        int length3 = strArr3.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                return;
            }
            addOutputBasedOnInput(strArr3[i6], "video");
            i5 = i6 + 1;
        }
    }
}
