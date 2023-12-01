package com.soft.blued.ui.mine.model;

import com.blued.android.module.common.login.model.BluedADExtra;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageAdModel.class */
public final class MinePageAdModel extends BluedADExtra implements Serializable {
    private boolean isShow;
    private String jump_url;
    private String material;
    private PopupAd popup;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageAdModel$PopupAd.class */
    public static final class PopupAd implements Serializable {
        private int frequency_day;
        private String material = "";
        private int material_type;

        public final int getFrequency_day() {
            return this.frequency_day;
        }

        public final String getMaterial() {
            return this.material;
        }

        public final int getMaterial_type() {
            return this.material_type;
        }

        public final void setFrequency_day(int i) {
            this.frequency_day = i;
        }

        public final void setMaterial(String str) {
            Intrinsics.e(str, "<set-?>");
            this.material = str;
        }

        public final void setMaterial_type(int i) {
            this.material_type = i;
        }

        public String toString() {
            return "PopupAd(material='" + this.material + "', material_type=" + this.material_type + ", frequency_day=" + this.frequency_day + ')';
        }
    }

    public MinePageAdModel(String str) {
        Intrinsics.e(str, "jump_url");
        this.jump_url = str;
        this.material = "";
    }

    public final String getJump_url() {
        return this.jump_url;
    }

    public final String getMaterial() {
        return this.material;
    }

    public final PopupAd getPopup() {
        return this.popup;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setJump_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.jump_url = str;
    }

    public final void setMaterial(String str) {
        Intrinsics.e(str, "<set-?>");
        this.material = str;
    }

    public final void setPopup(PopupAd popupAd) {
        this.popup = popupAd;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public String toString() {
        return "MinePageAdModel(material='" + this.material + "',jump_url='" + this.jump_url + "', popup=" + this.popup + ')';
    }
}
