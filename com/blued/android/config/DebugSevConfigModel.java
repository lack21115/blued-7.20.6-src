package com.blued.android.config;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/config/DebugSevConfigModel.class */
public class DebugSevConfigModel {
    public String android_external_sense_update_info;
    public int gray_count;
    public int use_client_img_cache;
    public int android_msg_backup = 0;
    public int android_grpc_live = 0;
    public int android_grpc_im = 0;
    public int android_font_adjust = 0;
    public int android_forbidden_splash_ad = 0;
    public int android_forbidden_banner1_ad = 0;
    public int android_forbidden_banner2_ad = 0;
    public int android_forbidden_origin_ad = 0;
    public int android_http_cache_limit = 0;
    public long refresh_limit_interval = 0;
    public int refresh_limit_count = 0;

    public boolean isOpenLocalIdentifyYellow() {
        return this.use_client_img_cache == 1;
    }

    public String toString() {
        return "DebugSevConfigModel{android_msg_backup=" + this.android_msg_backup + ", android_grpc_live=" + this.android_grpc_live + ", android_grpc_im=" + this.android_grpc_im + ", android_font_adjust=" + this.android_font_adjust + '}';
    }
}
