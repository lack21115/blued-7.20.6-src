package com.sobot.chat.utils;

import android.text.TextUtils;
import com.anythink.expressad.exoplayer.k.o;
import com.huawei.openalliance.ad.constant.ax;
import java.io.File;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/MediaFileUtils.class */
public class MediaFileUtils {
    public static final int FILE_TYPE_3GPP = 23;
    public static final int FILE_TYPE_3GPP2 = 24;
    public static final int FILE_TYPE_AMR = 4;
    public static final int FILE_TYPE_AWB = 5;
    public static final int FILE_TYPE_BMP = 34;
    public static final int FILE_TYPE_GIF = 32;
    public static final int FILE_TYPE_IMY = 13;
    public static final int FILE_TYPE_JPEG = 31;
    public static final int FILE_TYPE_M3U = 41;
    public static final int FILE_TYPE_M4A = 2;
    public static final int FILE_TYPE_M4V = 22;
    public static final int FILE_TYPE_MID = 11;
    public static final int FILE_TYPE_MP3 = 1;
    public static final int FILE_TYPE_MP4 = 21;
    public static final int FILE_TYPE_OGG = 7;
    public static final int FILE_TYPE_PLS = 42;
    public static final int FILE_TYPE_PNG = 33;
    public static final int FILE_TYPE_SMF = 12;
    public static final int FILE_TYPE_WAV = 3;
    public static final int FILE_TYPE_WBMP = 35;
    public static final int FILE_TYPE_WMA = 6;
    public static final int FILE_TYPE_WMV = 25;
    public static final int FILE_TYPE_WPL = 43;
    private static final int FIRST_AUDIO_FILE_TYPE = 1;
    private static final int FIRST_IMAGE_FILE_TYPE = 31;
    private static final int FIRST_MIDI_FILE_TYPE = 11;
    private static final int FIRST_PLAYLIST_FILE_TYPE = 41;
    private static final int FIRST_VIDEO_FILE_TYPE = 21;
    private static final int LAST_AUDIO_FILE_TYPE = 7;
    private static final int LAST_IMAGE_FILE_TYPE = 35;
    private static final int LAST_MIDI_FILE_TYPE = 13;
    private static final int LAST_PLAYLIST_FILE_TYPE = 43;
    private static final int LAST_VIDEO_FILE_TYPE = 25;
    public static final String UNKNOWN_STRING = "<unknown>";
    public static String sFileExtensions;
    private static HashMap<String, MediaFileType> sFileTypeMap = new HashMap<>();
    private static HashMap<String, Integer> sMimeTypeMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/MediaFileUtils$MediaFileType.class */
    public static class MediaFileType {
        int fileType;
        String mimeType;

        MediaFileType(int i, String str) {
            this.fileType = i;
            this.mimeType = str;
        }
    }

    static {
        addFileType("MP3", 1, "audio/mpeg");
        addFileType("M4A", 2, o.q);
        addFileType("WAV", 3, "audio/x-wav");
        addFileType("AMR", 4, "audio/amr");
        addFileType("AWB", 5, "audio/amr-wb");
        addFileType("WMA", 6, "audio/x-ms-wma");
        addFileType("OGG", 7, "application/ogg");
        addFileType("MID", 11, "audio/midi");
        addFileType("XMF", 11, "audio/midi");
        addFileType("RTTTL", 11, "audio/midi");
        addFileType("SMF", 12, "audio/sp-midi");
        addFileType("IMY", 13, "audio/imelody");
        addFileType("MP4", 21, "video/mp4");
        addFileType("M4V", 22, "video/mp4");
        addFileType("3GP", 23, "video/3gpp");
        addFileType("3GPP", 23, "video/3gpp");
        addFileType("3G2", 24, "video/3gpp2");
        addFileType("3GPP2", 24, "video/3gpp2");
        addFileType("WMV", 25, "video/x-ms-wmv");
        addFileType("JPG", 31, ax.V);
        addFileType("JPEG", 31, ax.V);
        addFileType("GIF", 32, ax.B);
        addFileType("PNG", 33, ax.Z);
        addFileType("BMP", 34, "image/x-ms-bmp");
        addFileType("WBMP", 35, "image/vnd.wap.wbmp");
        addFileType("M3U", 41, "audio/x-mpegurl");
        addFileType("PLS", 42, "audio/x-scpls");
        addFileType("WPL", 43, "application/vnd.ms-wpl");
        StringBuilder sb = new StringBuilder();
        for (String str : sFileTypeMap.keySet()) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(str);
        }
        sFileExtensions = sb.toString();
    }

    static void addFileType(String str, int i, String str2) {
        sFileTypeMap.put(str, new MediaFileType(i, str2));
        sMimeTypeMap.put(str2, new Integer(i));
    }

    public static MediaFileType getFileType(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return null;
        }
        return sFileTypeMap.get(str.substring(lastIndexOf + 1).toUpperCase());
    }

    public static int getFileTypeForMimeType(String str) {
        Integer num = sMimeTypeMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean isAudioFileType(int i) {
        boolean z = true;
        if (i < 1 || i > 7) {
            if (i >= 11 && i <= 13) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public static boolean isAudioFileType(String str) {
        MediaFileType fileType = getFileType(str);
        if (fileType != null) {
            return isAudioFileType(fileType.fileType);
        }
        return false;
    }

    public static boolean isImageFileType(int i) {
        return i >= 31 && i <= 35;
    }

    public static boolean isImageFileType(String str) {
        MediaFileType fileType;
        if (TextUtils.isEmpty(str) || !new File(str).exists() || (fileType = getFileType(str)) == null) {
            return false;
        }
        return isImageFileType(fileType.fileType);
    }

    public static boolean isPlayListFileType(int i) {
        return i >= 41 && i <= 43;
    }

    public static boolean isVideoFileType(int i) {
        return i >= 21 && i <= 25;
    }

    public static boolean isVideoFileType(String str) {
        MediaFileType fileType;
        if (TextUtils.isEmpty(str) || !new File(str).exists() || (fileType = getFileType(str)) == null) {
            return false;
        }
        return isVideoFileType(fileType.fileType);
    }
}
