package com.soft.blued.ui.find.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/CheckNearbyAdModel.class */
public final class CheckNearbyAdModel {
    private List<String> images;
    private String title = "";
    private String body = "";
    private String thumb = "";
    private String author = "";
    private String ext = "";

    public final String getAuthor() {
        return this.author;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getExt() {
        return this.ext;
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final String getThumb() {
        return this.thumb;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAuthor(String str) {
        Intrinsics.e(str, "<set-?>");
        this.author = str;
    }

    public final void setBody(String str) {
        Intrinsics.e(str, "<set-?>");
        this.body = str;
    }

    public final void setExt(String str) {
        Intrinsics.e(str, "<set-?>");
        this.ext = str;
    }

    public final void setImages(List<String> list) {
        this.images = list;
    }

    public final void setThumb(String str) {
        Intrinsics.e(str, "<set-?>");
        this.thumb = str;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
