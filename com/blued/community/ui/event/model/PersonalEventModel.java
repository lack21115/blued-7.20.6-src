package com.blued.community.ui.event.model;

import com.blued.android.module.common.login.model.UserBasicModel;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/model/PersonalEventModel.class */
public class PersonalEventModel extends UserBasicModel {
    public List<EventDetailsModel> activity;
    public String recommend_text;

    public PersonalEventModel(UserBasicModel userBasicModel) {
        this.uid = userBasicModel.uid;
        this.name = userBasicModel.name;
        this.distance = userBasicModel.distance;
        this.age = userBasicModel.age;
        this.height = userBasicModel.height;
        this.weight = userBasicModel.weight;
        this.note = userBasicModel.note;
        this.avatar = userBasicModel.avatar;
    }
}
