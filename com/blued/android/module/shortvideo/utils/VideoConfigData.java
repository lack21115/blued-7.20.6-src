package com.blued.android.module.shortvideo.utils;

import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.sobot.chat.camera.StCameraView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/VideoConfigData.class */
public class VideoConfigData {

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f15874a = false;
    public static final PLCameraSetting.CAMERA_PREVIEW_SIZE_RATIO[] b = {PLCameraSetting.CAMERA_PREVIEW_SIZE_RATIO.RATIO_4_3, PLCameraSetting.CAMERA_PREVIEW_SIZE_RATIO.RATIO_16_9};

    /* renamed from: c  reason: collision with root package name */
    public static final PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL[] f15875c = {PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_240P, PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_360P, PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_480P, PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_720P, PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_960P, PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_1080P, PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_1200P};
    public static final PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL[] d = {PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_240P_1, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_240P_2, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_352P_1, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_352P_2, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_360P_1, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_360P_2, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_360P_3, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_480P_1, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_480P_2, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_480P_3, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_544P_1, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_544P_2, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_720P_1, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_720P_2, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_720P_3, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_1088P_1, PLVideoEncodeSetting.VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_1088P_2};
    public static final int[] e = {500000, StCameraView.MEDIA_QUALITY_POOR, 1000000, StCameraView.MEDIA_QUALITY_LOW, StCameraView.MEDIA_QUALITY_MIDDLE, 2000000, 2800000, 3000000, 4000000, 8000000};
    public static final double[] f = {0.25d, 0.5d, 1.0d, 2.0d, 4.0d};

    public static PLCameraSetting.CAMERA_PREVIEW_SIZE_RATIO a() {
        return b[1];
    }

    public static PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL b() {
        return f15875c[3];
    }

    public static int c() {
        return e[6];
    }
}
