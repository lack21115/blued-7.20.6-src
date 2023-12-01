package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveBunchLightModel.class */
public final class LiveBunchLightModel implements Serializable {
    private long end_time;
    private int frequency;
    private ArrayList<String> image;
    private int lantern_id;
    private int play_times;
    private long start_time;
    private ArrayList<Long> taskList;
    private int task_id;

    public final long getEnd_time() {
        return this.end_time;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final ArrayList<String> getImage() {
        return this.image;
    }

    public final int getLantern_id() {
        return this.lantern_id;
    }

    public final int getPlay_times() {
        return this.play_times;
    }

    public final long getStart_time() {
        return this.start_time;
    }

    public final ArrayList<Long> getTaskList() {
        return this.taskList;
    }

    public final int getTask_id() {
        return this.task_id;
    }

    public final void setEnd_time(long j) {
        this.end_time = j;
    }

    public final void setFrequency(int i) {
        this.frequency = i;
    }

    public final void setImage(ArrayList<String> arrayList) {
        this.image = arrayList;
    }

    public final void setLantern_id(int i) {
        this.lantern_id = i;
    }

    public final void setPlay_times(int i) {
        this.play_times = i;
    }

    public final void setStart_time(long j) {
        this.start_time = j;
    }

    public final void setTaskList(ArrayList<Long> arrayList) {
        this.taskList = arrayList;
    }

    public final void setTask_id(int i) {
        this.task_id = i;
    }
}
