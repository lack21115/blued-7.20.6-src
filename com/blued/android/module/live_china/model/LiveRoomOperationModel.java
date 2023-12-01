package com.blued.android.module.live_china.model;

import com.google.gson.JsonObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomOperationModel.class */
public final class LiveRoomOperationModel implements Serializable {
    private int countdonw_type;
    private int countdown;
    private int desc_type;
    private float dynamic_weight;
    private JsonObject extra;
    private long get_countdown_timemillis;
    private boolean is_grpc;
    private int link_type;
    private int red_point;
    private int status;
    private int tools_type;
    private boolean view_init_finish;
    private String title = "";
    private String badge_text = "";
    private String link = "";
    private String icon = "";
    private String dynamic_icon = "";
    private float weight;
    private float current_weight = this.weight;
    private String desc = "";
    private String desc_icon = "";
    private String red_point_word = "";
    private int red_point_cancel = -1;

    public final String getBadge_text() {
        return this.badge_text;
    }

    public final int getCountdonw_type() {
        return this.countdonw_type;
    }

    public final int getCountdown() {
        return this.countdown;
    }

    public final float getCurrent_weight() {
        return this.current_weight;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDesc_icon() {
        return this.desc_icon;
    }

    public final int getDesc_type() {
        return this.desc_type;
    }

    public final String getDynamic_icon() {
        return this.dynamic_icon;
    }

    public final float getDynamic_weight() {
        return this.dynamic_weight;
    }

    public final JsonObject getExtra() {
        return this.extra;
    }

    public final long getGet_countdown_timemillis() {
        return this.get_countdown_timemillis;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getLink_type() {
        return this.link_type;
    }

    public final int getRed_point() {
        return this.red_point;
    }

    public final int getRed_point_cancel() {
        return this.red_point_cancel;
    }

    public final String getRed_point_word() {
        return this.red_point_word;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTools_type() {
        return this.tools_type;
    }

    public final boolean getView_init_finish() {
        return this.view_init_finish;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final boolean is_grpc() {
        return this.is_grpc;
    }

    public final void setBadge_text(String str) {
        Intrinsics.e(str, "<set-?>");
        this.badge_text = str;
    }

    public final void setCountdonw_type(int i) {
        this.countdonw_type = i;
    }

    public final void setCountdown(int i) {
        this.countdown = i;
    }

    public final void setCurrent_weight(float f) {
        this.current_weight = f;
    }

    public final void setDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc = str;
    }

    public final void setDesc_icon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc_icon = str;
    }

    public final void setDesc_type(int i) {
        this.desc_type = i;
    }

    public final void setDynamic_icon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.dynamic_icon = str;
    }

    public final void setDynamic_weight(float f) {
        this.dynamic_weight = f;
    }

    public final void setExtra(JsonObject jsonObject) {
        this.extra = jsonObject;
    }

    public final void setGet_countdown_timemillis(long j) {
        this.get_countdown_timemillis = j;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setLink(String str) {
        Intrinsics.e(str, "<set-?>");
        this.link = str;
    }

    public final void setLink_type(int i) {
        this.link_type = i;
    }

    public final void setRed_point(int i) {
        this.red_point = i;
    }

    public final void setRed_point_cancel(int i) {
        this.red_point_cancel = i;
    }

    public final void setRed_point_word(String str) {
        Intrinsics.e(str, "<set-?>");
        this.red_point_word = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public final void setTools_type(int i) {
        this.tools_type = i;
    }

    public final void setView_init_finish(boolean z) {
        this.view_init_finish = z;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    public final void set_grpc(boolean z) {
        this.is_grpc = z;
    }
}
