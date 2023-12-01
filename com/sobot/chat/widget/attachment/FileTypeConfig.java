package com.sobot.chat.widget.attachment;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/attachment/FileTypeConfig.class */
public class FileTypeConfig {
    public static final int MSGTYPE_FILE_DOC = 13;
    public static final int MSGTYPE_FILE_MP3 = 17;
    public static final int MSGTYPE_FILE_MP4 = 18;
    public static final int MSGTYPE_FILE_OTHER = 10;
    public static final int MSGTYPE_FILE_PDF = 16;
    public static final int MSGTYPE_FILE_PIC = 1;
    public static final int MSGTYPE_FILE_PPT = 14;
    public static final int MSGTYPE_FILE_RAR = 19;
    public static final int MSGTYPE_FILE_TXT = 20;
    public static final int MSGTYPE_FILE_XLS = 15;

    public static int getFileIcon(Context context, int i) {
        if (context == null) {
            return 0;
        }
        if (i != 10) {
            switch (i) {
                case 13:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_doc");
                case 14:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_ppt");
                case 15:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_xls");
                case 16:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_pdf");
                case 17:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_mp3");
                case 18:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_mp4");
                case 19:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_rar");
                case 20:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_txt");
                default:
                    return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_unknow");
            }
        }
        return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_unknow");
    }

    public static int getFileType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 10;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case 99640:
                if (str.equals("doc")) {
                    z = true;
                    break;
                }
                break;
            case 102340:
                if (str.equals("gif")) {
                    z = true;
                    break;
                }
                break;
            case 105441:
                if (str.equals("jpg")) {
                    z = true;
                    break;
                }
                break;
            case 108272:
                if (str.equals("mp3")) {
                    z = true;
                    break;
                }
                break;
            case 108273:
                if (str.equals("mp4")) {
                    z = true;
                    break;
                }
                break;
            case 110834:
                if (str.equals("pdf")) {
                    z = true;
                    break;
                }
                break;
            case 111145:
                if (str.equals("png")) {
                    z = true;
                    break;
                }
                break;
            case 111220:
                if (str.equals("ppt")) {
                    z = true;
                    break;
                }
                break;
            case 112675:
                if (str.equals("rar")) {
                    z = true;
                    break;
                }
                break;
            case 115312:
                if (str.equals("txt")) {
                    z = true;
                    break;
                }
                break;
            case 118783:
                if (str.equals("xls")) {
                    z = true;
                    break;
                }
                break;
            case 120609:
                if (str.equals("zip")) {
                    z = false;
                    break;
                }
                break;
            case 3088960:
                if (str.equals("docx")) {
                    z = true;
                    break;
                }
                break;
            case 3447940:
                if (str.equals("pptx")) {
                    z = true;
                    break;
                }
                break;
            case 3682393:
                if (str.equals("xlsx")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
                return 19;
            case true:
            case true:
                return 13;
            case true:
            case true:
                return 14;
            case true:
            case true:
                return 15;
            case true:
                return 16;
            case true:
                return 17;
            case true:
                return 18;
            case true:
                return 20;
            case true:
            case true:
            case true:
                return 1;
            default:
                return 10;
        }
    }
}
