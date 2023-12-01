package com.soft.blued.ui.user.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyTipsModel.class */
public class VIPBuyTipsModel implements Serializable {
    public int open_intercept;
    public PrivilegeModel privilege;
    public long welfare_deadline;
    public String welfare_link;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyTipsModel$PrivilegeModel.class */
    public class PrivilegeModel implements Serializable {
        public List<VIPPrivilegeModel> svip;
        public List<VIPPrivilegeModel> vip;

        public PrivilegeModel() {
        }
    }
}
