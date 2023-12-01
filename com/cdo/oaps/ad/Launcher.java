package com.cdo.oaps.ad;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/Launcher.class */
public final class Launcher {

    /* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/Launcher$Host.class */
    public static class Host {
        public static final String GC = "gc";
        public static final String INSTANT = "instant";
        public static final String MK = "mk";
        public static final String MK_OP = "mk_op";
    }

    /* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/Launcher$Method.class */
    public static class Method {
        public static final String ADD_CALLBACK = "add";
        public static final String DELETE_CALLBACK = "delete";
        public static final String INVOKE_CALLBACK = "invoke";
    }

    /* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/Launcher$Path.class */
    public static class Path {
        public static final String ACTIVITIES = "/acts";
        public static final String ACTIVITY_CENTER = "/ac";
        public static final String APP = "/app";
        public static final String APP_MOMENT = "/appmoment";
        public static final String APP_MOMENT_APP_TODAY = "/appmoment/apptoday";
        public static final String APP_MOMENT_APP_TODAY_DETAIL = "/appmoment/apptoday/dt";
        public static final String APP_MOMENT_DETAIL = "/detail/apptoday";
        public static final String APP_MOMENT_EDUCATION = "/appmoment/edu";
        public static final String APP_MOMENT_EDUCATION_DETAIL = "/appmoment/edu/dt";
        public static final String APP_MOMENT_GAME = "/appmoment/game";
        public static final String APP_MOMENT_GAME_DETAIL = "/appmoment/game/dt";
        public static final String APP_MOMENT_MAIN = "/appmoment/main";
        public static final String APP_MOMENT_TOPIC = "/appmoment/topic";
        public static final String APP_MOMENT_TOPIC_DETAIL = "/appmoment/topic/dt";
        public static final String BEAUTY = "/beauty";
        public static final String BEAUTY_DETAIL = "/beauty/dt";
        public static final String BEAUTY_DETAIL_V2 = "/beauty/dt/v2";
        public static final String BEAUTY_V2 = "/beauty/v2";
        public static final String BOOKED = "/booked";
        public static final String BOOK_SQL = "/book/sql";
        public static final String BOOK_SQL2 = "/book/sql2";
        public static final String BOOT = "/boot";
        public static final String BOOT_GUIDE_DATA = "/bootreg/dat";
        public static final String BOOT_GUIDE_UI = "/bootreg/ui";
        public static final String CARD = "/card";
        public static final String CARD_INSTANT = "/card/instant";
        public static final String CARD_STYLE = "/cardstyle";
        public static final String CARD_STYLE_RECOMMEND = "/cardstyle/recmd";
        public static final String CATEGORY = "/cat";
        public static final String CATEGORYS = "/cats";
        public static final String CATS = "/cats";
        public static final String COIN_DETAIL = "/coin/dt";
        public static final String COIN_TICKET = "/coin/ticket";
        public static final String COIN_TICKET_PURCHASE = "/coin/ticket/pc";
        public static final String CTA_PASS = "/cta";
        public static final String DESKTOP_DOWNLOAD = "/deskdown";
        public static final String DESKTOP_MY_GAME = "/dkt/mg";
        public static final String DESKTOP_RECOMMEND = "/dkt/rec";
        public static final String DETAIL = "/dt";
        public static final String DETAIL_DIALOG = "/dtg";
        public static final String DETAIL_DOWN = "/dtd";
        @Deprecated
        public static final String DOWNLOAD = "/dl";
        public static final String DOWNLOAD_CLOUD = "/dl/cloud";
        public static final String DOWNLOAD_HISTORY = "/history";
        public static final String DOWNLOAD_REDIRECT = "/dl/rdt";
        public static final String DOWNLOAD_V2 = "/dl/v2";
        public static final String DOWNLOAD_X = "/dl/x";
        public static final String EARN_POINT = "/point";
        public static final String FEEDBACK = "/fb";
        public static final String FEEDBACK_HOME = "/fb/home";
        public static final String FORUM_BOARD = "/forum/board";
        public static final String FORUM_BOARD_DT = "/forum/board/dt";
        public static final String FORUM_COMPLEX_REPLY = "/forum/cr";
        public static final String FORUM_FANS_LIST = "/forum/fans";
        public static final String FORUM_FOLLOW_LIST = "/forum/follow";
        public static final String FORUM_POSTS_DT = "/forum/posts/dt";
        public static final String FORUM_UC = "/forum/uc";
        public static final String FULL_SCREEN_MULTITASK = "/fs/mtt";
        public static final String GAME_ACTIVE = "/active";
        public static final String GAME_ACTIVITIES = "/acts/game";
        public static final String GAME_GIFTS = "/gifts/game";
        public static final String GAME_GIFT_BAG = "/giftbag";
        public static final String GC_HOME = "/gc/home";
        public static final String GET_DESKTOP_MSG = "/dkt/get";
        public static final String GIFT = "/gift";
        public static final String GIFTS = "/gifts";
        public static final String HALL_DOWN = "/hall/d";
        public static final String HISTORY = "/history";
        public static final String HOME = "/home";
        public static final String LAUNCH_FOLD = "/launch/fd";
        public static final String MALL = "/mall";
        public static final String MANAGER_DOWNLOAD = "/md";
        public static final String MANAGER_UPGRADE = "/mu";
        public static final String MSG_MAIN = "/msg/m";
        public static final String MSG_SUBSCRIPTION = "/msg/s";
        public static final String MSG_SUBSCRIPTION_SETTING = "/msg/ss";
        public static final String MULTIPAGE = "/multipage";
        public static final String NAVIGATION = "/navi";
        public static final String NOT_REDIRECT_WEBVIEW = "/web/nr";
        public static final String OFFLINE = "/offline";
        public static final String ONLINE = "/online";
        public static final String ONLINE_SERVICE = "/online/service";
        public static final String ORDER = "/order";
        public static final String ORDER_DETAIL = "/order/dt";
        public static final String ORDER_DETAIL_AUTO_BOOK = "/order/dtb";
        public static final String ORDER_IS_BOOKDED = "/order/ib";
        public static final String POINTS = "/point";
        public static final String PREDOWN = "/predown";
        public static final String QUERY_BG_BIZ = "/query/bgbiz";
        public static final String RECOMMENDAPPS = "/recapp";
        public static final String SEARCH = "/search";
        public static final String SEARCH_DOWN = "/searchd";
        public static final String SEARCH_FOR_PICK_APP = "/search/pick";
        public static final String SNIPPET = "/snippet";
        public static final String SNIPPET_V2 = "/snippet/v2";
        public static final String SPECIAL_SINGLE = "/sps";
        public static final String STRATEGY = "/strategy";
        public static final String SUPPORT = "/support";
        public static final String TASK_ALL_GAME_PRIVILEGE = "/tasks";
        public static final String TASK_BOUNTY_LIST = "/task/bt";
        public static final String TASK_GAME_PRIVILEGE = "/task/pri";
        public static final String TASK_INSTALLED_GAME_PRIVILEGE = "/task/ipri";
        public static final String TASK_PLATFORM_LIST = "/task/pf";
        public static final String TASK_PLATFORM_PRIVILEGE_DETAIL = "/task/pfdt";
        public static final String TASK_PRIVILEGE_DETAIL = "/task/pdt";
        public static final String TOPIC = "/topic";
        public static final String TOPIC_APP_TAP = "/topic/apptag";
        public static final String VIDEO_PLAY_DETAIL = "/vpd";
        public static final String VIP = "/vip";
        public static final String VIP_WELFARE = "/vip/welfare";
        public static final String WEB = "/web";
        public static final String WELFARE = "/welfare";
        public static final String WELFARE_DETAIL = "/weldt";
    }

    /* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/Launcher$Scheme.class */
    public static class Scheme {
        public static final String OAP = "oap";
        public static final String OAPS = "oaps";
    }
}
