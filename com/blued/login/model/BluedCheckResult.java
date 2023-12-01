package com.blued.login.model;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.gson.annotations.SerializedName;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/model/BluedCheckResult.class */
public class BluedCheckResult {
    private String captcha;
    @SerializedName(BridgeUtil.UNDERLINE_STR)
    private String encrypted;
    public int health_test_info_show;
    private int is_sm_captcha;
    private String login_email;
    private String login_mobile;
    private String mobile;
    private String msg;
    private String name;
    private String relation_mobile;
    private String ret;
    private String safe_email;
    private String third_access_token;
    private String third_user_id;
    private String token;
    private String uid;

    public String getCaptcha() {
        return this.captcha;
    }

    public String getEncrypted() {
        return this.encrypted;
    }

    public int getIs_sm_captcha() {
        return this.is_sm_captcha;
    }

    public String getLogin_email() {
        return this.login_email;
    }

    public String getLogin_mobile() {
        return this.login_mobile;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getName() {
        return this.name;
    }

    public String getRelation_mobile() {
        return this.relation_mobile;
    }

    public String getRet() {
        return this.ret;
    }

    public String getSafe_email() {
        return this.safe_email;
    }

    public String getThirdToken() {
        return this.third_access_token;
    }

    public String getThirdUid() {
        return this.third_user_id;
    }

    public String getToken() {
        return this.token;
    }

    public String getUid() {
        return this.uid;
    }

    public void setCaptcha(String str) {
        this.captcha = str;
    }

    public void setEncrypted(String str) {
        this.encrypted = str;
    }

    public void setIs_sm_captcha(int i) {
        this.is_sm_captcha = i;
    }

    public void setLogin_email(String str) {
        this.login_email = str;
    }

    public void setLogin_mobile(String str) {
        this.login_mobile = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRelation_mobile(String str) {
        this.relation_mobile = str;
    }

    public void setRet(String str) {
        this.ret = str;
    }

    public void setSafe_email(String str) {
        this.safe_email = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
