package com.meizu.cloud.pushsdk.notification.model.styleenum;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/notification/model/styleenum/BaseStyleModel.class */
public enum BaseStyleModel {
    FLYME(0),
    PURE_PICTURE(1),
    ANDROID(2);
    
    private final int code;

    BaseStyleModel(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
