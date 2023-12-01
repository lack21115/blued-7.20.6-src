package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/jni/model/ReflectColorData.class */
public class ReflectColorData {
    private long begin_time;
    private long changepoint_time;
    public ArrayList<Long> changepoint_time_list;
    private int config_begin;
    private int frame_num;
    private int height;
    private ArrayList<ColorImgData> images_data;
    private int landmark_num;
    private String log;
    private float offset_sys;
    private String reflect_video;
    public String version;
    private int width;

    public long getBegin_time() {
        return this.begin_time;
    }

    public long getChangepoint_time() {
        return this.changepoint_time;
    }

    public int getConfig_begin() {
        return this.config_begin;
    }

    public int getFrame_num() {
        return this.frame_num;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<ColorImgData> getImages_data() {
        return this.images_data;
    }

    public int getLandmark_num() {
        return this.landmark_num;
    }

    public String getLog() {
        return this.log;
    }

    public float getOffset_sys() {
        return this.offset_sys;
    }

    public String getReflect_video() {
        return this.reflect_video;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBegin_time(long j) {
        this.begin_time = j;
    }

    public void setChangepoint_time(long j) {
        this.changepoint_time = j;
    }

    public void setConfig_begin(int i) {
        this.config_begin = i;
    }

    public void setFrame_num(int i) {
        this.frame_num = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setImages_data(ArrayList<ColorImgData> arrayList) {
        this.images_data = arrayList;
    }

    public void setLandmark_num(int i) {
        this.landmark_num = i;
    }

    public void setLog(String str) {
        this.log = str;
    }

    public void setOffset_sys(float f) {
        this.offset_sys = f;
    }

    public void setReflectVideo(String str) {
        this.reflect_video = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        return "ReflectColorData{images_data=" + this.images_data + ", begin_time=" + this.begin_time + ", changepoint_time=" + this.changepoint_time + ", changepoint_time_list=" + this.changepoint_time_list + ", offset_sys=" + this.offset_sys + ", frame_num=" + this.frame_num + ", landmark_num=" + this.landmark_num + ", width=" + this.width + ", height=" + this.height + ", log='" + this.log + "', config_begin=" + this.config_begin + ", version='" + this.version + "', reflect_video='" + this.reflect_video + "'}";
    }
}
