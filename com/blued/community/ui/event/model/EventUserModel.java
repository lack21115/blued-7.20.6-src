package com.blued.community.ui.event.model;

import com.blued.android.module.common.login.model.UserBasicModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/model/EventUserModel.class */
public class EventUserModel extends UserBasicModel {
    private String activity_sign_content = "";
    private String activity_sign_content_occupy = "";
    private int activity_sign_id;
    private int activity_sign_status;
    private int is_activity_create_uid;
    private int is_followed;
    private int is_subscribe;
    private int join_activity_num;
    private int reg_date;
    private int registration_time;
    private int release_activity_num;

    public final String getActivity_sign_content() {
        return this.activity_sign_content;
    }

    public final String getActivity_sign_content_occupy() {
        return this.activity_sign_content_occupy;
    }

    public final int getActivity_sign_id() {
        return this.activity_sign_id;
    }

    public final int getActivity_sign_status() {
        return this.activity_sign_status;
    }

    public final int getJoin_activity_num() {
        return this.join_activity_num;
    }

    public final int getReg_date() {
        return this.reg_date;
    }

    public final int getRegistration_time() {
        return this.registration_time;
    }

    public final int getRelease_activity_num() {
        return this.release_activity_num;
    }

    public final int is_activity_create_uid() {
        return this.is_activity_create_uid;
    }

    public final int is_followed() {
        return this.is_followed;
    }

    public final int is_subscribe() {
        return this.is_subscribe;
    }

    public final void setActivity_sign_content(String str) {
        Intrinsics.e(str, "<set-?>");
        this.activity_sign_content = str;
    }

    public final void setActivity_sign_content_occupy(String str) {
        Intrinsics.e(str, "<set-?>");
        this.activity_sign_content_occupy = str;
    }

    public final void setActivity_sign_id(int i) {
        this.activity_sign_id = i;
    }

    public final void setActivity_sign_status(int i) {
        this.activity_sign_status = i;
    }

    public final void setJoin_activity_num(int i) {
        this.join_activity_num = i;
    }

    public final void setReg_date(int i) {
        this.reg_date = i;
    }

    public final void setRegistration_time(int i) {
        this.registration_time = i;
    }

    public final void setRelease_activity_num(int i) {
        this.release_activity_num = i;
    }

    public final void set_activity_create_uid(int i) {
        this.is_activity_create_uid = i;
    }

    public final void set_followed(int i) {
        this.is_followed = i;
    }

    public final void set_subscribe(int i) {
        this.is_subscribe = i;
    }
}
