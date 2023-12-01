package com.blued.login.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/model/LoginSplashModel.class */
public final class LoginSplashModel {
    private int duration;
    private ArrayList<String> images;
    private int is_open;
    private String video = "";

    public final int getDuration() {
        return this.duration;
    }

    public final ArrayList<String> getImages() {
        return this.images;
    }

    public final String getVideo() {
        return this.video;
    }

    public final int is_open() {
        return this.is_open;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final void setImages(ArrayList<String> arrayList) {
        this.images = arrayList;
    }

    public final void setVideo(String str) {
        Intrinsics.e(str, "<set-?>");
        this.video = str;
    }

    public final void set_open(int i) {
        this.is_open = i;
    }
}
