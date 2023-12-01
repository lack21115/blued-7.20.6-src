package com.soft.blued.ui.user.model;

import com.blued.android.sdk.model.BluedEntity;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/ServiceMenuModel.class */
public class ServiceMenuModel extends BluedEntity {
    public List<ServiceMenuModel> levelTwo;
    public String name;
    public int show_divider;
    public int type;
    public JumpValue value;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/ServiceMenuModel$JumpValue.class */
    public class JumpValue {
        public String url;

        public JumpValue() {
        }
    }
}
