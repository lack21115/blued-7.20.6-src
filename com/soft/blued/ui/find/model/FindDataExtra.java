package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/FindDataExtra.class */
public class FindDataExtra extends BluedEntityBaseExtra {
    public List<_adms> adms;
    public BluedADExtra adms_activity;
    public List<UserFindExtra> adms_operating;
    public List<_adms_user> adms_user;
    public GuideMap guide_map;
    public InsertExtra insert;
    public List<OperateUserADExtra> nearby_dating;
    public String next_min_dist;
    public String next_skip_uid;
    public String selected_refresh_hint;
    public List<OperateUserADExtra> super_call;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/FindDataExtra$GuideMap.class */
    public class GuideMap {
        public String code;
        public String image;
        public int is_open;

        public GuideMap() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/FindDataExtra$InsertExtra.class */
    public static class InsertExtra {
        public SidePrivilegeRecycling side_privilege_recycling;
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/FindDataExtra$SidePrivilegeRecycling.class */
    public static class SidePrivilegeRecycling {
        public String desc;
        public int floor;
        public String title;
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/FindDataExtra$_adms.class */
    public static class _adms {
        public List<UserFindResult> data;
        public int line;
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/FindDataExtra$_adms_user.class */
    public static class _adms_user extends UserBasicModel {
        public int layer;
    }
}
