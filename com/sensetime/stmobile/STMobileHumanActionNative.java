package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STBodyAvatar;
import com.sensetime.stmobile.model.STFaceMeshList;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STImage;
import com.sensetime.stmobile.model.STMobileFaceInfo;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileHumanActionNative.class */
public class STMobileHumanActionNative {
    public static final long ST_MOBILE_BODY_ACTION1 = 4294967296L;
    public static final long ST_MOBILE_BODY_ACTION2 = 8589934592L;
    public static final long ST_MOBILE_BODY_ACTION3 = 17179869184L;
    public static final long ST_MOBILE_BODY_ACTION4 = 34359738368L;
    public static final long ST_MOBILE_BODY_ACTION5 = 68719476736L;
    public static final long ST_MOBILE_BODY_CONTOUR = 268435456;
    public static final int ST_MOBILE_BODY_DETECT_FULL = 402653184;
    public static final long ST_MOBILE_BODY_KEYPOINTS = 134217728;
    public static final long ST_MOBILE_BODY_KEYPOINTS_3D = 562949953421312L;
    public static final long ST_MOBILE_BROW_JUMP = 32;
    public static final long ST_MOBILE_DEPTH_ESTIMATION = 2305843009213693952L;
    public static final long ST_MOBILE_DETECT_AVATAR_HELPINFO = 140737488355328L;
    public static final long ST_MOBILE_DETECT_DYNAMIC_GESTURE = 35184372088832L;
    public static final long ST_MOBILE_DETECT_EAR = 1125899906842624L;
    public static final long ST_MOBILE_DETECT_EXTRA_FACE_POINTS = 16777216;
    public static final long ST_MOBILE_DETECT_EYEBALL_CENTER = 33554432;
    public static final long ST_MOBILE_DETECT_EYEBALL_CONTOUR = 67108864;
    public static final long ST_MOBILE_DETECT_FACE_MESH = 18014398509481984L;
    public static final long ST_MOBILE_DETECT_FACE_SKIN_COLOR = 281474976710656L;
    public static final long ST_MOBILE_DETECT_FOREHEAD = 2251799813685248L;
    public static final long ST_MOBILE_DETECT_GAZE = 17592186044416L;
    public static final long ST_MOBILE_DETECT_HAIR_COLOR = 72057594037927936L;
    public static final long ST_MOBILE_DETECT_HAND_SKELETON_KEYPOINTS = 2199023255552L;
    public static final long ST_MOBILE_DETECT_HAND_SKELETON_KEYPOINTS_3D = 4398046511104L;
    public static final long ST_MOBILE_DETECT_HEAD = 144115188075855872L;
    public static final long ST_MOBILE_DETECT_HEAD_MESH = 288230376151711744L;
    public static final int ST_MOBILE_DETECT_MODE_IMAGE = 262144;
    public static final int ST_MOBILE_DETECT_MODE_VIDEO = 131072;
    public static final long ST_MOBILE_DETECT_MOUTH_PARSE = 36028797018963968L;
    public static final int ST_MOBILE_DETECT_TONGUE = 1073741824;
    public static final long ST_MOBILE_DETECT_UPBODY_AVATAR = 576460752303423488L;
    public static final int ST_MOBILE_ENABLE_AVATAR_HELPER = 536870912;
    public static final int ST_MOBILE_ENABLE_BODY_CONTOUR = 16384;
    public static final int ST_MOBILE_ENABLE_BODY_KEYPOINTS = 4096;
    public static final int ST_MOBILE_ENABLE_DYNAMIC_GESTURE = 268435456;
    public static final int ST_MOBILE_ENABLE_EYEBALL_CENTER_DETECT = 1024;
    public static final int ST_MOBILE_ENABLE_EYEBALL_CONTOUR_DETECT = 2048;
    public static final int ST_MOBILE_ENABLE_FACE_DETECT = 64;
    public static final int ST_MOBILE_ENABLE_FACE_EXTRA_DETECT = 512;
    public static final int ST_MOBILE_ENABLE_GAZE_DETECT = 134217728;
    public static final int ST_MOBILE_ENABLE_HAIR_SEGMENT = 32768;
    public static final int ST_MOBILE_ENABLE_HAND_DETECT = 128;
    public static final int ST_MOBILE_ENABLE_HAND_SKELETON_KEYPOINTS = 16777216;
    public static final int ST_MOBILE_ENABLE_HAND_SKELETON_KEYPOINTS_3D = 33554432;
    public static final long ST_MOBILE_ENABLE_HEAD_SEGMENT = 8589934592L;
    public static final long ST_MOBILE_ENABLE_MOUTH_PARSE_DETECT = 34359738368L;
    public static final int ST_MOBILE_ENABLE_MULTI_SEGMENT = 67108864;
    public static final int ST_MOBILE_ENABLE_SEGMENT_DETECT = 256;
    public static final long ST_MOBILE_ENABLE_SKIN_SEGMENT = 17179869184L;
    public static final long ST_MOBILE_EYE_BLINK = 2;
    public static final long ST_MOBILE_FACE_DETECT = 1;
    public static final int ST_MOBILE_FACE_DETECT_FULL = 255;
    public static final long ST_MOBILE_FACE_LIPS_POUTED = 128;
    public static final long ST_MOBILE_FACE_LIPS_UPWARD = 64;
    public static final long ST_MOBILE_HAND_666 = 4194304;
    public static final long ST_MOBILE_HAND_BLESS = 8388608;
    public static final long ST_MOBILE_HAND_CONGRATULATE = 131072;
    public static final long ST_MOBILE_HAND_DETECT = 256;
    public static final long ST_MOBILE_HAND_DETECT_FULL = 71468272516864L;
    public static final long ST_MOBILE_HAND_FINGER_HEART = 262144;
    public static final long ST_MOBILE_HAND_FINGER_INDEX = 1048576;
    public static final long ST_MOBILE_HAND_FIST = 2097152;
    public static final long ST_MOBILE_HAND_FOUR = 9007199254740992L;
    public static final long ST_MOBILE_HAND_GOOD = 2048;
    public static final long ST_MOBILE_HAND_HOLDUP = 32768;
    public static final long ST_MOBILE_HAND_ILOVEYOU = 1099511627776L;
    public static final long ST_MOBILE_HAND_LOVE = 16384;
    public static final long ST_MOBILE_HAND_OK = 512;
    public static final long ST_MOBILE_HAND_PALM = 4096;
    public static final long ST_MOBILE_HAND_PISTOL = 8192;
    public static final long ST_MOBILE_HAND_SCISSOR = 1024;
    public static final long ST_MOBILE_HAND_THREE = 4503599627370496L;
    public static final long ST_MOBILE_HEAD_PITCH = 16;
    public static final long ST_MOBILE_HEAD_YAW = 8;
    public static final long ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_DETECT = 101177407;
    public static final int ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_IMAGE = 328128;
    public static final int ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_VIDEO = 131568;
    public static final int ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_VIDEO_SINGLE_THREAD = 197104;
    public static final long ST_MOBILE_MOUTH_AH = 4;
    public static final long ST_MOBILE_SEG_BACKGROUND = 65536;
    public static final long ST_MOBILE_SEG_FACE_OCCLUSION = 17179869184L;
    public static final long ST_MOBILE_SEG_HAIR = 536870912;
    public static final long ST_MOBILE_SEG_HEAD = 4294967296L;
    public static final long ST_MOBILE_SEG_MULTI = 8796093022208L;
    public static final long ST_MOBILE_SEG_SKIN = 8589934592L;
    public static final long ST_MOBILE_SEG_SKY = 1152921504606846976L;
    private static final String TAG = STMobileHumanActionNative.class.getSimpleName();
    private long nativeHumanActionHandle;
    private long nativeHumanActionResultPtr;
    private long nativeHumanActionResultPtrCopy;

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileHumanActionNative$STMobileExpression.class */
    public enum STMobileExpression {
        ST_MOBILE_EXPRESSION_EYE_BLINK(1),
        ST_MOBILE_EXPRESSION_MOUTH_AH(2),
        ST_MOBILE_EXPRESSION_HEAD_YAW(3),
        ST_MOBILE_EXPRESSION_HEAD_PITCH(4),
        ST_MOBILE_EXPRESSION_BROW_JUMP(5),
        ST_MOBILE_EXPRESSION_HAND_OK(9),
        ST_MOBILE_EXPRESSION_HAND_SCISSOR(10),
        ST_MOBILE_EXPRESSION_HAND_GOOD(11),
        ST_MOBILE_EXPRESSION_HAND_PALM(12),
        ST_MOBILE_EXPRESSION_HAND_PISTOL(13),
        ST_MOBILE_EXPRESSION_HAND_LOVE(14),
        ST_MOBILE_EXPRESSION_HAND_HOLDUP(15),
        ST_MOBILE_EXPRESSION_HAND_CONGRATULATE(17),
        ST_MOBILE_EXPRESSION_HAND_FINGER_HEART(18),
        ST_MOBILE_EXPRESSION_HAND_FINGER_INDEX(20),
        ST_MOBILE_EXPRESSION_HEAD_NORMAL(65),
        ST_MOBILE_EXPRESSION_SIDE_FACE_LEFT(66),
        ST_MOBILE_EXPRESSION_SIDE_FACE_RIGHT(67),
        ST_MOBILE_EXPRESSION_TILTED_FACE_LEFT(68),
        ST_MOBILE_EXPRESSION_TILTED_FACE_RIGHT(69),
        ST_MOBILE_EXPRESSION_HEAD_RISE(70),
        ST_MOBILE_EXPRESSION_HEAD_LOWER(71),
        ST_MOBILE_EXPRESSION_TWO_EYE_CLOSE(85),
        ST_MOBILE_EXPRESSION_TWO_EYE_OPEN(86),
        ST_MOBILE_EXPRESSION_LEFTEYE_OPEN_RIGHTEYE_CLOSE(87),
        ST_MOBILE_EXPRESSION_LEFTEYE_CLOSE_RIGHTEYE_OPEN(88),
        ST_MOBILE_EXPRESSION_MOUTH_OPEN(105),
        ST_MOBILE_EXPRESSION_MOUTH_CLOSE(106),
        ST_MOBILE_EXPRESSION_FACE_LIPS_UPWARD(107),
        ST_MOBILE_EXPRESSION_FACE_LIPS_POUTED(108),
        ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_LEFT(109),
        ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_RIGHT(110),
        ST_MOBILE_EXPRESSION_COUNT(128),
        ST_MOBILE_EXPRESSION_FACE_ALL(257),
        ST_MOBILE_EXPRESSION_HAND_ALL(258);
        
        private final int expressionCode;

        STMobileExpression(int i) {
            this.expressionCode = i;
        }

        public int getExpressionCode() {
            return this.expressionCode;
        }
    }

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public static native boolean[] getExpression(STHumanAction sTHumanAction, int i, boolean z);

    public static native void setExpressionThreshold(int i, float f);

    public native int addSubModel(String str);

    public native int addSubModelFromAssetFile(String str, AssetManager assetManager);

    public native STBodyAvatar[] calcUpbodyAvatarQuaternion(STHumanAction sTHumanAction, int i, int i2, int i3);

    public native int createInstance(String str, int i);

    public native int createInstanceFromAssetFile(String str, int i, AssetManager assetManager);

    public native int createInstanceFromBuffer(byte[] bArr, int i, int i2);

    public native int createInstanceWithSubModels(String[] strArr, int i, int i2);

    public native void destroyInstance();

    public native float getFaceActionThreshold(long j);

    public native float getFaceDistance(STMobileFaceInfo sTMobileFaceInfo, int i, int i2, int i3, float f);

    public native STFaceMeshList getFaceMeshList();

    public native int[] getFaceMeshList2();

    public native float[] getFaceMeshNormal(int i);

    public native float[] getFaceMeshPoint(int i);

    public native float[] getFaceMeshTexcoords(int i);

    public native int[] getFaceOccluderList2();

    public native int getFaceShape(STMobileFaceInfo sTMobileFaceInfo, int[] iArr);

    public native STImage getFigureMattingForeground(long j);

    public native int[] getHeadMeshList2();

    public native float[] getHeadMeshNormal(int i);

    public native float[] getHeadMeshPoint(int i);

    public native float[] getHeadMeshTexcoords(int i);

    public native int[] getHeadOccluderList2();

    public native STHumanAction getNativeHumanAction();

    public long getNativeHumanActionPtrCopy() {
        return this.nativeHumanActionResultPtrCopy;
    }

    public long getNativeHumanActionResultPtr() {
        return this.nativeHumanActionResultPtr;
    }

    public native STHumanAction humanActionDetect(byte[] bArr, int i, long j, int i2, int i3, int i4);

    public native int loadStandardMeshObj(String str, int i);

    public native int loadStandardMeshObjFromAssetFile(String str, int i, AssetManager assetManager);

    public native int nativeHumanActionDetectPtr(byte[] bArr, int i, long j, int i2, int i3, int i4);

    public native void nativeHumanActionMirrorPtr(int i);

    public native void nativeHumanActionPtrCopy();

    public native void nativeHumanActionResizePtr(float f);

    public native void nativeHumanActionRotatePtr(int i, int i2, int i3, boolean z);

    public native int removeSubModelByConfig(int i);

    public native int reset();

    public native STImage retrieveHumanEdge(STImage sTImage, int i, boolean z);

    public native int setFaceActionThreshold(long j, float f);

    public native int setParam(int i, float f);
}
