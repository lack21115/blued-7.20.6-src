package com.sobot.chat.core.channel;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/Const.class */
public interface Const {
    public static final int CONNTYPE_CONNECT_SUCCESS = 2;
    public static final int CONNTYPE_IN_CONNECTION = 1;
    public static final int CONNTYPE_UNCONNECTED = 0;
    public static final String SOBOT_APPKEY = "sobot_appkey_chat";
    public static final String SOBOT_CHAT_CHECK_CONNCHANNEL = "sobot_chat_check_connchannel";
    public static final String SOBOT_CHAT_CHECK_SWITCHFLAG = "sobot_chat_check_switchflag";
    public static final String SOBOT_CHAT_CONNCHANNEL = "sobot_chat_connchannel";
    public static final String SOBOT_CHAT_DISCONNCHANNEL = "sobot_chat_disconnchannel";
    public static final String SOBOT_CHAT_USER_OUTLINE = "sobot_chat_user_outline";
    public static final String SOBOT_CHAT_WSLINK_BAK = "sobot_chat_wslink_bak";
    public static final String SOBOT_CHAT_WSLINK_DEFAULT = "sobot_chat_wslink_default";
    public static final String SOBOT_CID = "sobot_cid_chat";
    public static final String SOBOT_NOTIFICATION_FLAG = "sobot_notification_flag_chat";
    public static final String SOBOT_PUID = "sobot_puid_chat";
    public static final String SOBOT_UID = "sobot_uid_chat";
    public static final String SOBOT_USERTYPE = "sobot_usertype_chat";
    public static final String SOBOT_WAYHTTP = "sobot_wayhttp_chat";
    public static final String SOBOT_WSLINKBAK = "sobot_wslinkbak_chat";
    public static final String SOBOT_WSLINKDEFAULT = "sobot_wslinkdefault_chat";
    public static final int SOCKET_CHECK_CHANNEL = 120000;
    public static final int SOCKET_HEART_SECOND = 10000;
    public static final int SOCKET_MAX_RECONNECT_NUM = 3;
    public static final int SOCKET_READ_TIMOUT = 5000;
    public static final int SOCKET_SLEEP_SECOND = 5000;
    public static final int SOCKET_TIMOUT = 5000;
    public static final int message_type_conn_auth = 0;
    public static final int message_type_data = 3;
    public static final int message_type_heartbeat = 1;
    public static final int message_type_receipt = 2;
    public static final int user_type_customer = 2;
    public static final int user_type_normal = 0;
    public static final int version = 1;
}
