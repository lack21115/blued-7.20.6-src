package com.blued.android.module.live_china.model;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomFunctionModel.class */
public final class LiveRoomFunctionModel {
    private ArrayList<LiveRoomFunctionItemModel> data;
    private String title;

    public final ArrayList<LiveRoomFunctionItemModel> getData() {
        return this.data;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setData(ArrayList<LiveRoomFunctionItemModel> arrayList) {
        this.data = arrayList;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
