package com.sobot.chat;

import com.sobot.chat.listener.SobotPlusMenuListener;
import com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/SobotUIConfig.class */
public class SobotUIConfig {
    public static final int DEFAULT = -1;
    public static int sobot_apicloud_titleBgColor = -1;
    public static int sobot_chat_bottom_bgColor = -1;
    public static int sobot_chat_file_bgColor = -1;
    public static int sobot_chat_left_bgColor = -1;
    public static int sobot_chat_left_link_textColor = -1;
    public static int sobot_chat_left_textColor = -1;
    public static int sobot_chat_right_bgColor = -1;
    public static int sobot_chat_right_link_textColor = -1;
    public static int sobot_chat_right_textColor = -1;
    public static boolean sobot_head_title_is_bold = true;
    public static int sobot_moreBtnImgId = -1;
    public static int sobot_serviceImgId = -1;
    public static int sobot_statusbar_BgColor = -1;
    public static int sobot_titleBgColor = -1;
    public static int sobot_titleTextColor = -1;
    public static boolean sobot_title_right_menu1_display = true;
    public static int sobot_title_right_menu2_bg = -1;
    public static String sobot_title_right_menu2_call_num = "";
    public static boolean sobot_title_right_menu2_display = false;
    public static int sobot_title_right_menu3_bg = -1;
    public static String sobot_title_right_menu3_call_num = "";
    public static boolean sobot_title_right_menu3_display = false;
    public static boolean sobot_webview_title_display = true;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/SobotUIConfig$pulsMenu.class */
    public static final class pulsMenu {
        public static List<ChattingPanelUploadView.SobotPlusEntity> menus;
        public static List<ChattingPanelUploadView.SobotPlusEntity> operatorMenus;
        public static SobotPlusMenuListener sSobotPlusMenuListener;
    }
}
