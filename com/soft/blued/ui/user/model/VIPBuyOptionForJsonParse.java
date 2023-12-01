package com.soft.blued.ui.user.model;

import com.soft.blued.ui.pay.model.BluedCoupon;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyOptionForJsonParse.class */
public class VIPBuyOptionForJsonParse {
    public _banner banner;
    public _explain_list explain_list;
    public int has_payment_code;
    public int is_new_face;
    public int is_show_hori_items;
    public int new_member_experiment;
    public List<_rule_list> rule_list;
    public _vip_list svip_list;
    public int upgrade_button;
    public _vip_list vip_list;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyOptionForJsonParse$_banner.class */
    public class _banner {
        public List<_banner_model> svip;
        public List<_banner_model> vip;

        public _banner() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyOptionForJsonParse$_banner_model.class */
    public class _banner_model {
        public String img;
        public String link;

        public _banner_model() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyOptionForJsonParse$_explain_list.class */
    public class _explain_list {
        public String svip;
        public String vip;

        public _explain_list() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyOptionForJsonParse$_rule_list.class */
    public class _rule_list {
        public String title;
        public String url;

        public _rule_list() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyOptionForJsonParse$_vip_list.class */
    public class _vip_list {
        public BluedCoupon default_coupon;
        public List<VIPBuyOption> list;
        public List<VIPRightDescForSelling> privilege;
        public List<VIPPrivilegeModel> privilege_list;
        public int stop_time;

        public _vip_list() {
        }
    }
}
