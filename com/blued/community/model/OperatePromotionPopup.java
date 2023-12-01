package com.blued.community.model;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/OperatePromotionPopup.class */
public final class OperatePromotionPopup {
    private int frequency_count;
    private int frequency_type;
    private int material_type;
    private String material = "";
    private String extra_bubble_text = "";
    private String sourcePage = "";

    public final String getExtra_bubble_text() {
        return this.extra_bubble_text;
    }

    public final int getFrequency_count() {
        return this.frequency_count;
    }

    public final int getFrequency_type() {
        return this.frequency_type;
    }

    public final String getMaterial() {
        return this.material;
    }

    public final int getMaterial_type() {
        return this.material_type;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.material);
    }

    public final void setExtra_bubble_text(String str) {
        Intrinsics.e(str, "<set-?>");
        this.extra_bubble_text = str;
    }

    public final void setFrequency_count(int i) {
        this.frequency_count = i;
    }

    public final void setFrequency_type(int i) {
        this.frequency_type = i;
    }

    public final void setMaterial(String str) {
        Intrinsics.e(str, "<set-?>");
        this.material = str;
    }

    public final void setMaterial_type(int i) {
        this.material_type = i;
    }

    public final void setSourcePage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.sourcePage = str;
    }
}
