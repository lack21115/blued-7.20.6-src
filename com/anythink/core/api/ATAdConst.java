package com.anythink.core.api;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst.class */
public class ATAdConst {
    public static final int AD_CHOICES_PLACEMENT_BOTTOM_LEFT = 3;
    public static final int AD_CHOICES_PLACEMENT_BOTTOM_RIGHT = 2;
    public static final int AD_CHOICES_PLACEMENT_INVISIBLE = 4;
    public static final int AD_CHOICES_PLACEMENT_TOP_LEFT = 0;
    public static final int AD_CHOICES_PLACEMENT_TOP_RIGHT = 1;
    public static final String AD_SUPPORT_TYPE_ARRAY = "[1]";
    public static final int ORIENTATION_HORIZONTAL = 2;
    public static final int ORIENTATION_VERTICAL = 1;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$ATDevFrameworkType.class */
    public static class ATDevFrameworkType {
        public static final String ADOBIE_AIR = "7";
        public static final String COCOS_2DX = "3";
        public static final String COCOS_CREATOR = "4";
        public static final String FLUTTER = "6";
        public static final String NATIVE = "1";
        public static final String REACT_NATIVE = "5";
        public static final String UNITY = "2";
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$ATMixedFormatAdType.class */
    public static class ATMixedFormatAdType {
        public static final int BANNER = 2;
        public static final int DEFAULT = -1;
        public static final int INTERSTITIAL = 3;
        public static final int NATIVE = 0;
        public static final int REWARDED_VIDEO = 1;
        public static final int SPLASH = 4;
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$BIDDING_TYPE.class */
    public class BIDDING_TYPE {
        public static final String BIDDING_LOSS_WITH_BIDDING_TIMEOUT = "2";
        public static final String BIDDING_LOSS_WITH_EXPIRE = "5";
        public static final String BIDDING_LOSS_WITH_EXPIRE_SIGMOB = "2002";
        public static final String BIDDING_LOSS_WITH_LOW_PRICE_IN_HB = "102";
        public static final String BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL = "103";

        public BIDDING_TYPE() {
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$CURRENCY.class */
    public enum CURRENCY {
        RMB,
        RMB_CENT,
        USD
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$DISMISS_TYPE.class */
    public static class DISMISS_TYPE {
        public static final int CLICKAD = 4;
        public static final int NORMAL = 1;
        public static final int SHOWFAILED = 99;
        public static final int SKIP = 2;
        public static final int TIMEOVER = 3;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$KEY.class */
    public static class KEY {
        public static final String AD_CHOICES_PLACEMENT = "ad_choices_placement";
        public static final String AD_CLICK_CONFIRM_STATUS = "ad_click_confirm_status";
        public static final String AD_HEIGHT = "key_height";
        public static final String AD_IS_SUPPORT_DEEP_LINK = "ad_is_support_deep_link";
        public static final String AD_ORIENTATION = "ad_orientation";
        public static final String AD_SOUND = "ad_sound";
        public static final String AD_WIDTH = "key_width";
        public static final String APP_LOGO_ID = "app_logo_id";
        public static final String APP_NAME = "app_name";
        public static final String CP_LOAD_MODE = "cp_pre_md";
        public static final String CP_PLACEMENT_ID = "cp_placement_id";
        public static final String REWARD_AMOUNT = "reward_amount";
        public static final String REWARD_NAME = "reward_name";
        public static final String START_APP_PRIMARY_IMAGE_SIZE = "start_app_primary_image_size";
        public static final String START_APP_SECONDARY_IMAGE_SIZE = "start_app_secondary_image_size";
        public static final String USER_CUSTOM_DATA = "user_custom_data";
        public static final String USER_ID = "user_id";
        public static final String WECHAT_APPID = "wechat_app_id";
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$NETWORK_CUSTOM_KEY.class */
    public static class NETWORK_CUSTOM_KEY {
        public static final String CREATIVE_ID = "creative_id";
        public static final String DSP_ID = "dsp_id";
        public static final String IS_DEEPLINK_OFFER = "is_deeplink";
        public static final String NETWORK_BIDDING_TYPE = "bidding_type";
        public static final String NETWORK_ECPM = "network_ecpm";
        public static final String NETWORK_ID = "network_id";
        public static final String NETWORK_NAME = "network_name";
        public static final String NETWORK_REQUEST_ID = "request_id";
        public static final String NETWORK_UNIT_ID = "network_unit_id";
        public static final String OFFER_ID = "offer_id";
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$NETWORK_REQUEST_PARAMS_KEY.class */
    public static class NETWORK_REQUEST_PARAMS_KEY {
        public static final String ACCOUNT_ID = "account_id";
        public static final String ADP_ACCEPT_TYPE = "adp_accept_type";
        public static final String AD_HEIGHT = "ad_height";
        public static final String AD_SOURCE_ID = "ad_source_id";
        public static final String AD_WIDTH = "ad_width";
        public static final String APP_ID = "app_id";
        public static final String APP_KEY = "app_key";
        public static final String BANNER_SIZE = "size";
        public static final String BIDDING_FLOOR = "bidfloor";
        public static final String BID_FLOOR = "bid_floor";
        public static final String BID_REQUEST_INFO = "bid_info";
        public static final String BID_TOKEN = "bid_token";
        public static final String BUYERUID = "buyeruid";
        public static final String CUSTOM_INHOUSE_BID_RESULT = "custom_inhouse_bid_result";
        public static final String DIRECTLY_AD_SOURCEIDS = "unit_ids";
        public static final String DIRECTLY_DA_CREATIVE_CLICK = "c_cl";
        public static final String DIRECTLY_DA_CREATIVE_IMPRESSION = "c_im";
        public static final String DIRECTLY_DA_OFFER_CLICK = "o_cl";
        public static final String DIRECTLY_DA_OFFER_IMPRESSION = "o_im";
        public static final String EXCLUDE_OFFER = "ecpoffer";
        public static final String FORMAT = "ad_format";
        public static final String GET_OFFER = "get_offer";
        public static final String INSTANCE_ID = "instance_id";
        public static final String NETWORK_SDK_VERSION = "display_manager_ver";
        public static final String NW_FIRM_ID = "nw_firm_id";
        public static final String SDK_INFO = "sdk_info";
        public static final String SUPPORT_TEMPLATE_VERSION = "tpl_ver";
        public static final String UNIT_ID = "unit_id";
        public static final String UNIT_TYPE = "unit_type";
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$PRIVACY.class */
    public class PRIVACY {
        public static final int PERSIONALIZED_ALLOW_STATUS = 1;
        public static final int PERSIONALIZED_LIMIT_STATUS = 2;

        public PRIVACY() {
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$REWARD_EXTRA_REPLACE_HODLER_KEY.class */
    public static class REWARD_EXTRA_REPLACE_HODLER_KEY {
        public static final String NETWORK_PLACEMENT_ID_HOLDER_NAME = "{network_placement_id}";
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdConst$START_APP_IMAGE_SIZE.class */
    public static class START_APP_IMAGE_SIZE {
        public static final int SIZE_100x100 = 1;
        public static final int SIZE_1200x628 = 4;
        public static final int SIZE_150x150 = 2;
        public static final int SIZE_340x340 = 3;
        public static final int SIZE_72x72 = 0;
    }
}
