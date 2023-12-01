package com.tencent.liteav.videobase.videobase;

import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<a, Integer> f22988a = new HashMap<a, Integer>() { // from class: com.tencent.liteav.videobase.videobase.h.1
        {
            put(a.ERR_CODE_NONE, 0);
            put(a.ERR_VIDEO_CAPTURE_EGL_CORE_CREATE_FAILED, -1301);
            put(a.ERR_VIDEO_CAPTURE_OPENGL_ERROR, -1301);
            put(a.ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE, -1301);
            put(a.ERR_VIDEO_CAPTURE_SCREEN_CAPTURE_START_FAILED, -1308);
            put(a.ERR_VIDEO_CAPTURE_SCREEN_UNSUPPORTED, -1309);
            put(a.ERR_VIDEO_CAPTURE_SCREEN_UNAUTHORIZED, -1308);
            put(a.ERR_VIDEO_ENCODE_FATALERROR, -1303);
            put(a.ERR_VIDEO_ENCODE_FAIL, -1303);
            put(a.ERR_VIDEO_NO_AVAILABLE_HEVC_DECODERS, -2304);
        }
    };
    private static final Map<c, Integer> b = new HashMap<c, Integer>() { // from class: com.tencent.liteav.videobase.videobase.h.2
        {
            put(c.WARNING_VIDEO_ENCODE_EGL_CORE_CREATE_FAILED, 1103);
            put(c.WARNING_VIDEO_ENCODE_START_FAILED_INSUFFICIENT_RESOURCE, 1103);
            put(c.WARNING_VIDEO_ENCODE_START_FAILED, 1103);
            put(c.WARNING_VIDEO_ENCODE_SWAP_BUFFER, 1103);
            put(c.WARNING_VIDEO_RENDER_EGL_CORE_CREATE_FAILED, 2110);
            put(c.WARNING_VIDEO_RENDER_EGL_CORE_DESTROY_FAILED, 2110);
            put(c.WARNING_VIDEO_RENDER_SWAP_BUFFER, 2110);
            put(c.WARNING_VIDEO_DECODE_EGL_CORE_CREATE_FAILED, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED_OUT_OF_MEMORY, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED, 2106);
            put(c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, 2101);
            put(c.WARNING_VIDEO_DECODE_ERROR_NOT_SUPPORT_PIXEL_FORMAT_TYPE, 2101);
            put(c.WARNING_VIDEO_DECODE_FATAL_ERROR, 2101);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final Map<b, Integer> f22989c = new HashMap<b, Integer>() { // from class: com.tencent.liteav.videobase.videobase.h.3
        {
            put(b.EVT_VIDEO_DECODE_HW_TO_SW_DECODE_COST_TOO_HIGH, 2108);
            put(b.EVT_VIDEO_DECODE_HW_TO_SW_REMOTE_VIDEO_ENABLE_RPS, 2108);
            put(b.EVT_VIDEO_DECODE_HW_TO_SW_MEDIACODEC_NOT_WORK, 2108);
        }
    };
    private static final Map<b, Integer> d = new HashMap<b, Integer>() { // from class: com.tencent.liteav.videobase.videobase.h.4
        {
            put(b.EVT_VIDEO_DECODE_FIRST_FRAME_DECODED, 10000);
            put(b.EVT_VIDEO_RENDER_FIRST_FRAME_ON_VIEW, 10004);
            put(b.EVT_VIDEO_RENDER_FIRST_FRAME, 10001);
            put(b.EVT_VIDEO_DECODE_TYPE_CHANGE, 10002);
            put(b.EVT_VIDEO_RENDER_RESOLUTION_CHANGE, Integer.valueOf((int) GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR));
            put(b.EVT_VIDEO_CAPTURE_FIRST_FRAME, 20000);
            put(b.EVT_VIDEO_CAPTURE_CAMERA_START_SUCCESS, Integer.valueOf((int) PushConsts.ALIAS_ERROR_FREQUENCY));
            put(b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_START_SUCCESS, Integer.valueOf((int) PushConsts.ALIAS_OPERATE_PARAM_ERROR));
            put(b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS, Integer.valueOf((int) PushConsts.ALIAS_REQUEST_FILTER));
            put(b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED, Integer.valueOf((int) PushConsts.ALIAS_OPERATE_ALIAS_FAILED));
            put(b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME, Integer.valueOf((int) PushConsts.ALIAS_CID_LOST));
            put(b.EVT_VIDEO_ENCODE_START_SUCCESS, 40001);
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/h$a.class */
    public enum a {
        ERR_CODE_NONE,
        ERR_VIDEO_CAPTURE_EGL_CORE_CREATE_FAILED,
        ERR_VIDEO_CAPTURE_OPENGL_ERROR,
        ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE,
        ERR_VIDEO_CAPTURE_SCREEN_CAPTURE_START_FAILED,
        ERR_VIDEO_CAPTURE_SCREEN_UNAUTHORIZED,
        ERR_VIDEO_CAPTURE_SCREEN_UNSUPPORTED,
        ERR_VIDEO_ENCODE_FATALERROR,
        ERR_VIDEO_ENCODE_FAIL,
        ERR_VIDEO_NO_AVAILABLE_HEVC_DECODERS
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/h$b.class */
    public enum b {
        EVT_CODE_NONE,
        EVT_VIDEO_DECODE_HW_TO_SW_DECODE_COST_TOO_HIGH,
        EVT_VIDEO_DECODE_HW_TO_SW_REMOTE_VIDEO_ENABLE_RPS,
        EVT_VIDEO_DECODE_HW_TO_SW_MEDIACODEC_NOT_WORK,
        EVT_VIDEO_DECODE_FIRST_FRAME_DECODED,
        EVT_VIDEO_RENDER_FIRST_FRAME,
        EVT_VIDEO_DECODE_TYPE_CHANGE,
        EVT_VIDEO_RENDER_RESOLUTION_CHANGE,
        EVT_VIDEO_RENDER_FIRST_FRAME_ON_VIEW,
        EVT_VIDEO_CAPTURE_FIRST_FRAME,
        EVT_VIDEO_CAPTURE_CAMERA_START_SUCCESS,
        EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_START_SUCCESS,
        EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS,
        EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED,
        EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME,
        EVT_VIDEO_ENCODE_START_SUCCESS,
        EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_SIZE_CHANGE_SUCCESS,
        EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_START_SUCCESS,
        EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_STOP_SUCCESS,
        EVT_VIDEO_PREPROCESS_FACE_RECOGNIZE_SUCESS,
        EVT_VIDEO_PREPROCESS_FACE_RECOGNIZE_FAILED,
        EVT_VIDEO_PREPROCESS_COSMETIC_FIRST_USE,
        EVT_VIDEO_ENCODE_STOP_SUCCESS,
        EVT_VIDEO_ENCODE_SW_TO_HW_CPU_USAGE,
        EVT_VIDEO_ENCODE_HW_TO_SW_MEDIACODEC_NOT_WORK,
        EVT_VIDEO_CONSUMER_RECEIVE_FIRST_FRAME,
        EVT_VIDEO_DECODE_START_DECODE_FIRST_FRAME,
        EVT_VIDEO_DECODE_START_SUCCESS,
        EVT_VIDEO_DECODE_SW_TO_HW_REMOTE_VIDEO_DISABLE_RPS
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/h$c.class */
    public enum c {
        WARNING_VIDEO_ENCODE_EGL_CORE_CREATE_FAILED,
        WARNING_VIDEO_ENCODE_START_FAILED_INSUFFICIENT_RESOURCE,
        WARNING_VIDEO_ENCODE_START_FAILED,
        WARNING_VIDEO_ENCODE_SWAP_BUFFER,
        WARNING_VIDEO_RENDER_EGL_CORE_CREATE_FAILED,
        WARNING_VIDEO_RENDER_EGL_CORE_DESTROY_FAILED,
        WARNING_VIDEO_RENDER_SWAP_BUFFER,
        WARNING_VIDEO_DECODE_EGL_CORE_CREATE_FAILED,
        WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT,
        WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE,
        WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE,
        WARNING_VIDEO_DECODE_START_FAILED_OUT_OF_MEMORY,
        WARNING_VIDEO_DECODE_START_FAILED,
        WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR,
        WARNING_VIDEO_DECODE_ERROR_NOT_SUPPORT_PIXEL_FORMAT_TYPE,
        WARNING_VIDEO_DECODE_FATAL_ERROR,
        WARNING_VIDEO_DECODE_CACHE_EXCEEDED,
        WARNING_VIDEO_DECODE_ABNORMAL,
        WARNING_VIDEO_DECODE_EGL_CORE_DESTROY_FAILED
    }

    public static int a(a aVar) {
        if (f22988a.containsKey(aVar)) {
            return f22988a.get(aVar).intValue();
        }
        return 0;
    }

    public static int a(b bVar) {
        if (f22989c.containsKey(bVar)) {
            return f22989c.get(bVar).intValue();
        }
        if (d.containsKey(bVar)) {
            return d.get(bVar).intValue();
        }
        return 0;
    }

    public static int a(c cVar) {
        if (b.containsKey(cVar)) {
            return b.get(cVar).intValue();
        }
        return 0;
    }

    public static boolean b(b bVar) {
        return f22989c.containsKey(bVar);
    }
}
