package com.blued.android.module.yy_china.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/GiftMicModel.class */
public class GiftMicModel {
    private YYSeatMemberModel mic;
    private String num;

    public GiftMicModel(String str, YYSeatMemberModel yYSeatMemberModel) {
        this.num = str;
        this.mic = yYSeatMemberModel;
    }

    public YYSeatMemberModel getMic() {
        return this.mic;
    }

    public String getNum() {
        return this.num;
    }

    public void setMic(YYSeatMemberModel yYSeatMemberModel) {
        this.mic = yYSeatMemberModel;
    }

    public void setNum(String str) {
        this.num = str;
    }
}
