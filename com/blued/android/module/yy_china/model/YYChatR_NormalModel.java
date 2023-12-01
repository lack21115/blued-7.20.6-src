package com.blued.android.module.yy_china.model;

import android.content.Context;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.yy_china.R;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYChatR_NormalModel.class */
public class YYChatR_NormalModel {
    public ChatAnchorLevelModel chat_anchor_level;
    public int in_pk;
    public boolean isUpload;
    public int is_hot;
    public String label_link;
    public ArrayList<String> other_user_avatar;
    public String room_id;
    public String room_member_count;
    public String room_name;
    public String room_type_id;
    public String room_type_name;
    public String the_same_city;
    public String uid;
    public String user_avatar;
    public String user_name;

    public ShapeModel getRoomTag(Context context, int i) {
        int i2 = i % 4;
        ShapeModel shapeModel = new ShapeModel();
        if (BluedSkinUtils.c()) {
            shapeModel.t = 536928427;
            shapeModel.v = 540574717;
        } else {
            shapeModel.t = -2147426133;
            shapeModel.v = -2143779843;
        }
        shapeModel.H = context.getResources().getDimension(R.dimen.dp_12);
        shapeModel.C = 315;
        shapeModel.q = 0.0f;
        if (i2 == 1) {
            shapeModel.t = -2130848029;
            shapeModel.v = -2135570438;
            return shapeModel;
        } else if (i2 == 2) {
            shapeModel.t = -2139824904;
            shapeModel.v = -2130786877;
            return shapeModel;
        } else {
            if (i2 == 3) {
                shapeModel.t = -2130719509;
                shapeModel.v = -2130714185;
            }
            return shapeModel;
        }
    }

    public ShapeModel getRoomTagBack(Context context, int i) {
        int i2 = i % 6;
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.t = -2139824904;
        shapeModel.v = -2130786877;
        shapeModel.H = context.getResources().getDimension(R.dimen.dp_12);
        shapeModel.C = 315;
        if (i2 == 1) {
            shapeModel.t = -2136803603;
            shapeModel.v = -2133161742;
        } else if (i2 == 2) {
            shapeModel.t = -2134442052;
            shapeModel.v = -2130727235;
        } else if (i2 == 3) {
            shapeModel.t = -2130719509;
            shapeModel.v = -2130714185;
        } else if (i2 == 4) {
            shapeModel.t = -2130848029;
            shapeModel.v = -2135570438;
        }
        if (i2 == 5) {
            shapeModel.t = -2130914091;
            shapeModel.v = -2138200880;
        }
        return shapeModel;
    }
}
