package com.sobot.chat.api.model;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ConsultingContent.class */
public class ConsultingContent implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean isAutoSend;
    private boolean isEveryTimeAutoSend;
    private String sobotGoodsDescribe;
    private String sobotGoodsFromUrl;
    private String sobotGoodsImgUrl;
    private String sobotGoodsLable;
    private String sobotGoodsTitle;

    public ConsultingContent() {
        this.isEveryTimeAutoSend = false;
    }

    public ConsultingContent(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2) {
        this.isEveryTimeAutoSend = false;
        this.sobotGoodsTitle = str;
        this.sobotGoodsImgUrl = str2;
        this.sobotGoodsFromUrl = str3;
        this.sobotGoodsLable = str4;
        this.sobotGoodsDescribe = str5;
        this.isAutoSend = z;
        this.isEveryTimeAutoSend = z2;
    }

    public String getSobotGoodsDescribe() {
        return this.sobotGoodsDescribe;
    }

    public String getSobotGoodsFromUrl() {
        return this.sobotGoodsFromUrl;
    }

    public String getSobotGoodsImgUrl() {
        return this.sobotGoodsImgUrl;
    }

    public String getSobotGoodsLable() {
        return this.sobotGoodsLable;
    }

    public String getSobotGoodsTitle() {
        return this.sobotGoodsTitle;
    }

    public boolean isAutoSend() {
        return this.isAutoSend;
    }

    public boolean isEveryTimeAutoSend() {
        return this.isEveryTimeAutoSend;
    }

    public void setAutoSend(boolean z) {
        this.isAutoSend = z;
    }

    public void setEveryTimeAutoSend(boolean z) {
        this.isEveryTimeAutoSend = z;
    }

    public void setSobotGoodsDescribe(String str) {
        this.sobotGoodsDescribe = str;
    }

    public void setSobotGoodsFromUrl(String str) {
        this.sobotGoodsFromUrl = str;
    }

    public void setSobotGoodsImgUrl(String str) {
        this.sobotGoodsImgUrl = str;
    }

    public void setSobotGoodsLable(String str) {
        this.sobotGoodsLable = str;
    }

    public void setSobotGoodsTitle(String str) {
        this.sobotGoodsTitle = str;
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (TextUtils.isEmpty(this.sobotGoodsTitle)) {
            str = null;
        } else {
            str = "\"" + this.sobotGoodsTitle + "\"";
        }
        if (TextUtils.isEmpty(this.sobotGoodsFromUrl)) {
            str2 = null;
        } else {
            str2 = "\"" + this.sobotGoodsFromUrl + "\"";
        }
        if (TextUtils.isEmpty(this.sobotGoodsDescribe)) {
            str3 = null;
        } else {
            str3 = "\"" + this.sobotGoodsDescribe + "\"";
        }
        if (TextUtils.isEmpty(this.sobotGoodsLable)) {
            str4 = null;
        } else {
            str4 = "\"" + this.sobotGoodsLable + "\"";
        }
        if (!TextUtils.isEmpty(this.sobotGoodsImgUrl)) {
            str5 = "\"" + this.sobotGoodsImgUrl + "\"";
        }
        return "{\"title\":" + str + ",\"url\":" + str2 + ",\"description\":" + str3 + ",\"label\":" + str4 + ",\"thumbnail\":" + str5 + i.d;
    }
}
