package com.blued.android.module.live_china.model;

import android.util.Log;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveFunctionModel.class */
public class LiveFunctionModel implements MultiItemEntity {
    public static final int FUNCTION_ANNOUNCE = 11;
    public static final int FUNCTION_BEAUTY = 0;
    public static final int FUNCTION_CAMERA = 1;
    public static final int FUNCTION_FLASH = 3;
    public static final int FUNCTION_GESTURE = 5;
    public static final int FUNCTION_MIRROR = 2;
    public static final int FUNCTION_MUSIC = 9;
    public static final int FUNCTION_RECORD = 10;
    public static final int FUNCTION_SHOP = 7;
    public static final int FUNCTION_STICKER = 6;
    public static final int FUNCTION_TITLE = 4;
    public static final int FUNCTION_TOP_CARD = 8;
    public static final int ITEM_TYPE_NORMAL = 0;
    public static final int ITEM_TYPE_TOP_CARD = 1;
    public int count;
    public int dot;
    public int function_type;
    public int icon;
    public int item_type;
    public String name;

    public LiveFunctionModel(int i, String str, int i2) {
        Log.i("==abc", "function_type:" + i + " name:" + str);
        this.function_type = i;
        this.name = str;
        this.icon = i2;
    }

    public LiveFunctionModel(int i, String str, int i2, int i3) {
        Log.i("==abc", "function_type:" + i + " name:" + str + " dot:" + i3);
        this.function_type = i;
        this.name = str;
        this.icon = i2;
        this.dot = i3;
    }

    public LiveFunctionModel(int i, String str, int i2, int i3, int i4) {
        Log.i("==abc", "function_type:" + i + " name:" + str + " dot:" + i3 + " count:" + i4);
        this.function_type = i;
        this.name = str;
        this.icon = i2;
        this.dot = i3;
        this.count = i4;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.item_type;
    }
}
