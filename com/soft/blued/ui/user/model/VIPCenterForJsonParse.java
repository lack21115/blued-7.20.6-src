package com.soft.blued.ui.user.model;

import com.soft.blued.ui.find.model.AdvertFloatModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse.class */
public class VIPCenterForJsonParse {
    public _banner_ad banner;
    public _banner_ad footer;
    public AdvertFloatModel market;
    public List<VIPRightOption> privilege;
    public List<NonVIPPriviledge> privilege_normal;
    public List<_upgrade> upgrade;
    public _user_info user_info;
    public UserLvlPriviledge user_lvl_privilege;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse$IS_SHOW_LVL_LIST.class */
    public interface IS_SHOW_LVL_LIST {
        public static final int HIDE = 0;
        public static final int SHOW_MY_RIGHT = 2;
        public static final int SHOW_WAITING_RIGHT = 1;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse$NonVIPPriviledge.class */
    public static class NonVIPPriviledge {
        public List<VIPRightOption> privilege_list;
        public String title;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse$UserLvlPriviledge.class */
    public static class UserLvlPriviledge {
        public int is_show_lvl_list;
        public List<_privilege_list> privilege_list;
        public String user_lvl_content;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse$_banner.class */
    public static class _banner {
        public boolean ifShowed = false;
        public String img;
        public String link;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse$_banner_ad.class */
    public class _banner_ad {
        public List<_banner> svip;
        public List<_banner> vip;

        public _banner_ad() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse$_privilege_list.class */
    public static class _privilege_list {
        public String corner;
        public String icon;
        public int privilege_type;
        public String title;
        public String unit;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse$_upgrade.class */
    public class _upgrade {
        public String description;
        public String icon;
        public int pid;
        public String tips;
        public String title;

        public _upgrade() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterForJsonParse$_user_info.class */
    public class _user_info {
        public long expire_time;
        public int expire_type;
        public int grade;
        public int is_show_expire;
        public int is_show_level;
        public int is_vip_annual;
        public long svip_endtime;
        public long vip_endtime;
        public int vip_exp_lvl;

        public _user_info() {
        }
    }
}
