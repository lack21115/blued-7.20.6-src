package com.blued.android.module.live_china.model;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomOperationDataModel.class */
public final class LiveRoomOperationDataModel {
    private ArrayList<LiveRoomOperationModel> left;
    private ArrayList<LiveRoomOperationModel> right;

    public final ArrayList<LiveRoomOperationModel> getLeft() {
        return this.left;
    }

    public final ArrayList<LiveRoomOperationModel> getRight() {
        return this.right;
    }

    public final void setLeft(ArrayList<LiveRoomOperationModel> arrayList) {
        this.left = arrayList;
    }

    public final void setRight(ArrayList<LiveRoomOperationModel> arrayList) {
        this.right = arrayList;
    }
}
