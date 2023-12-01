package com.soft.blued.ui.user.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel.class */
public class VIPCenterNewModel implements Serializable {
    public BannerModel banner;
    public Explain explain_list;
    public int[] grade_list;
    public int has_payment_code;
    public List<List<VIPRightOption>> level_privilege;
    public List<PrivilegeModel> privilege;
    public List<RuleItem> rule_list;
    public List<OptionList> svip_list;
    public UserModel user_info;
    public List<OptionList> vip_list;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel$BannerItem.class */
    public class BannerItem {
        public boolean ifShowed = false;
        public String img;
        public String link;

        public BannerItem() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel$BannerModel.class */
    public class BannerModel {
        public List<BannerItem> svip;
        public List<BannerItem> vip;

        public BannerModel() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel$Explain.class */
    public class Explain {
        public String svip;
        public String vip;

        public Explain() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel$OptionList.class */
    public class OptionList extends VIPBuyOption {
        public OptionList() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel$PrivilegeItem.class */
    public class PrivilegeItem extends VIPRightOption {
        public PrivilegeItem() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel$PrivilegeModel.class */
    public class PrivilegeModel {
        public boolean checked;
        public List<VIPRightOption> privilege_list;
        public String title;

        public PrivilegeModel() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel$RuleItem.class */
    public class RuleItem {
        public String title;
        public String url;

        public RuleItem() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCenterNewModel$UserModel.class */
    public class UserModel {
        public int day_growth_value;
        public int exp_lvl_diff;
        public int exp_lvl_next;
        public int expire_time;
        public int expire_type;
        public int grade;
        public int is_show_expire;
        public int is_show_level;
        public int is_svip;
        public int is_vip;
        public int is_vip_annual;
        public long svip_endtime;
        public long time_now;
        public long vip_endtime;
        public long vip_exp;
        public int vip_exp_lvl;

        public UserModel() {
        }
    }
}
