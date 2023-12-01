package com.blued.android.module.common.txcloud;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/txcloud/CredentialsInfo.class */
public final class CredentialsInfo {
    private long expired_time;
    private long start_time;
    private String tmp_secret_id = "";
    private String tmp_secret_key = "";
    private String session_token = "";
    private String bucket = "";
    private String region = "";
    private String path = "";

    public final String getBucket() {
        return this.bucket;
    }

    public final long getExpired_time() {
        return this.expired_time;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getSession_token() {
        return this.session_token;
    }

    public final long getStart_time() {
        return this.start_time;
    }

    public final String getTmp_secret_id() {
        return this.tmp_secret_id;
    }

    public final String getTmp_secret_key() {
        return this.tmp_secret_key;
    }

    public final void setBucket(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bucket = str;
    }

    public final void setExpired_time(long j) {
        this.expired_time = j;
    }

    public final void setPath(String str) {
        Intrinsics.e(str, "<set-?>");
        this.path = str;
    }

    public final void setRegion(String str) {
        Intrinsics.e(str, "<set-?>");
        this.region = str;
    }

    public final void setSession_token(String str) {
        Intrinsics.e(str, "<set-?>");
        this.session_token = str;
    }

    public final void setStart_time(long j) {
        this.start_time = j;
    }

    public final void setTmp_secret_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.tmp_secret_id = str;
    }

    public final void setTmp_secret_key(String str) {
        Intrinsics.e(str, "<set-?>");
        this.tmp_secret_key = str;
    }
}
