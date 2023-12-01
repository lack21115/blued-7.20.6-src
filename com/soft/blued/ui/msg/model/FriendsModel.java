package com.soft.blued.ui.msg.model;

import com.soft.blued.ui.setting.model.BluedBlackList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/FriendsModel.class */
public class FriendsModel implements Cloneable {
    public List<BluedBlackList> data = new ArrayList();

    public Object clone() {
        try {
            return (FriendsModel) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
