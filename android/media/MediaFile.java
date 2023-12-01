package android.media;

import android.content.ClipDescription;
import android.media.DecoderCapabilities;
import android.mtp.MtpConstants;
import com.anythink.expressad.exoplayer.k.o;
import com.huawei.openalliance.ad.constant.ax;
import com.tencent.cos.xml.model.tag.DomainConfiguration;
import com.tencent.mapsdk.internal.ma;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaFile.class */
public class MediaFile {
    public static final int FILE_TYPE_3GPA = 301;
    public static final int FILE_TYPE_3GPP = 23;
    public static final int FILE_TYPE_3GPP2 = 24;
    public static final int FILE_TYPE_AAC = 8;
    public static final int FILE_TYPE_AC3 = 302;
    public static final int FILE_TYPE_AMR = 4;
    public static final int FILE_TYPE_APE = 306;
    public static final int FILE_TYPE_ASF = 26;
    public static final int FILE_TYPE_AVI = 29;
    public static final int FILE_TYPE_AWB = 5;
    public static final int FILE_TYPE_BMP = 34;
    public static final int FILE_TYPE_DASH = 45;
    public static final int FILE_TYPE_DIVX = 201;
    public static final int FILE_TYPE_DTS = 300;
    public static final int FILE_TYPE_EC3 = 305;
    public static final int FILE_TYPE_FL = 51;
    public static final int FILE_TYPE_FLAC = 10;
    public static final int FILE_TYPE_FLV = 202;
    public static final int FILE_TYPE_GIF = 32;
    public static final int FILE_TYPE_HTML = 101;
    public static final int FILE_TYPE_HTTPLIVE = 44;
    public static final int FILE_TYPE_IMY = 13;
    public static final int FILE_TYPE_JPEG = 31;
    public static final int FILE_TYPE_M3U = 41;
    public static final int FILE_TYPE_M4A = 2;
    public static final int FILE_TYPE_M4V = 22;
    public static final int FILE_TYPE_MID = 11;
    public static final int FILE_TYPE_MKA = 9;
    public static final int FILE_TYPE_MKV = 27;
    public static final int FILE_TYPE_MP2PS = 200;
    public static final int FILE_TYPE_MP2TS = 28;
    public static final int FILE_TYPE_MP3 = 1;
    public static final int FILE_TYPE_MP4 = 21;
    public static final int FILE_TYPE_MS_EXCEL = 105;
    public static final int FILE_TYPE_MS_POWERPOINT = 106;
    public static final int FILE_TYPE_MS_WORD = 104;
    public static final int FILE_TYPE_OGG = 7;
    public static final int FILE_TYPE_PCM = 304;
    public static final int FILE_TYPE_PDF = 102;
    public static final int FILE_TYPE_PLS = 42;
    public static final int FILE_TYPE_PNG = 33;
    public static final int FILE_TYPE_QCP = 303;
    public static final int FILE_TYPE_SMF = 12;
    public static final int FILE_TYPE_TEXT = 100;
    public static final int FILE_TYPE_WAV = 3;
    public static final int FILE_TYPE_WBMP = 35;
    public static final int FILE_TYPE_WEBM = 30;
    public static final int FILE_TYPE_WEBP = 36;
    public static final int FILE_TYPE_WMA = 6;
    public static final int FILE_TYPE_WMV = 25;
    public static final int FILE_TYPE_WPL = 43;
    public static final int FILE_TYPE_XML = 103;
    public static final int FILE_TYPE_ZIP = 107;
    private static final int FIRST_AUDIO_FILE_TYPE = 1;
    private static final int FIRST_AUDIO_FILE_TYPE_EXT = 300;
    private static final int FIRST_DRM_FILE_TYPE = 51;
    private static final int FIRST_IMAGE_FILE_TYPE = 31;
    private static final int FIRST_MIDI_FILE_TYPE = 11;
    private static final int FIRST_PLAYLIST_FILE_TYPE = 41;
    private static final int FIRST_VIDEO_FILE_TYPE = 21;
    private static final int FIRST_VIDEO_FILE_TYPE2 = 200;
    private static final int LAST_AUDIO_FILE_TYPE = 10;
    private static final int LAST_AUDIO_FILE_TYPE_EXT = 306;
    private static final int LAST_DRM_FILE_TYPE = 51;
    private static final int LAST_IMAGE_FILE_TYPE = 36;
    private static final int LAST_MIDI_FILE_TYPE = 13;
    private static final int LAST_PLAYLIST_FILE_TYPE = 45;
    private static final int LAST_VIDEO_FILE_TYPE = 30;
    private static final int LAST_VIDEO_FILE_TYPE2 = 202;
    private static final HashMap<String, MediaFileType> sFileTypeMap = new HashMap<>();
    private static final HashMap<String, Integer> sMimeTypeMap = new HashMap<>();
    private static final HashMap<String, Integer> sFileTypeToFormatMap = new HashMap<>();
    private static final HashMap<String, Integer> sMimeTypeToFormatMap = new HashMap<>();
    private static final HashMap<Integer, String> sFormatToMimeTypeMap = new HashMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaFile$MediaFileType.class */
    public static class MediaFileType {
        public final int fileType;
        public final String mimeType;

        MediaFileType(int i, String str) {
            this.fileType = i;
            this.mimeType = str;
        }
    }

    static {
        addFileType("MP3", 1, "audio/mpeg", 12297);
        addFileType("MP3D", 1, "audio/mp3d", 12297);
        addFileType("MPGA", 1, "audio/mpeg", 12297);
        addFileType("M4A", 2, o.q, 12299);
        addFileType("M4A", 2, "audio/m4a", 12299);
        addFileType("M4A", 2, "audio/mp4a-latm", 12299);
        addFileType("WAV", 3, "audio/x-wav", 12296);
        addFileType("WAV", 3, "audio/wav", 12296);
        addFileType("AMR", 4, "audio/amr");
        addFileType("AWB", 5, "audio/amr-wb");
        if (isWMAEnabled()) {
            addFileType("WMA", 6, "audio/x-ms-wma", MtpConstants.FORMAT_WMA);
        }
        addFileType("OGG", 7, "audio/ogg", MtpConstants.FORMAT_OGG);
        addFileType("OGG", 7, "application/ogg", MtpConstants.FORMAT_OGG);
        addFileType("OGA", 7, "application/ogg", MtpConstants.FORMAT_OGG);
        addFileType("AAC", 8, "audio/aac", MtpConstants.FORMAT_AAC);
        addFileType("AAC", 8, "audio/aac-adts", MtpConstants.FORMAT_AAC);
        addFileType("MKA", 9, "audio/x-matroska");
        addFileType("3G2", 24, "audio/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("MID", 11, "audio/midi");
        addFileType("MIDI", 11, "audio/midi");
        addFileType("XMF", 11, "audio/midi");
        addFileType("RTTTL", 11, "audio/midi");
        addFileType("SMF", 12, "audio/sp-midi");
        addFileType("IMY", 13, "audio/imelody");
        addFileType("RTX", 11, "audio/midi");
        addFileType("OTA", 11, "audio/midi");
        addFileType("MXMF", 11, "audio/midi");
        addFileType("MPEG", 21, o.m, 12299);
        addFileType("MPG", 21, o.m, 12299);
        addFileType("MP4", 21, "video/mp4", 12299);
        addFileType("M4V", 22, "video/mp4", 12299);
        addFileType("3GP", 23, "video/3gpp", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3GPP", 23, "video/3gpp", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3G2", 24, "video/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3GPP2", 24, "video/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("MKV", 27, "video/x-matroska");
        addFileType("WEBM", 30, o.f);
        addFileType(ma.g, 28, "video/mp2ts");
        addFileType("AVI", 29, "video/avi");
        if (isWMVEnabled()) {
            addFileType("WMV", 25, "video/x-ms-wmv", MtpConstants.FORMAT_WMV);
            addFileType("ASF", 26, "video/x-ms-asf");
        }
        addFileType("JPG", 31, ax.V, MtpConstants.FORMAT_EXIF_JPEG);
        addFileType("JPEG", 31, ax.V, MtpConstants.FORMAT_EXIF_JPEG);
        addFileType("GIF", 32, ax.B, MtpConstants.FORMAT_GIF);
        addFileType("PNG", 33, ax.Z, MtpConstants.FORMAT_PNG);
        addFileType("BMP", 34, "image/bmp", MtpConstants.FORMAT_BMP);
        addFileType("BMP", 34, "image/x-ms-bmp", MtpConstants.FORMAT_BMP);
        addFileType("BMP", 34, "image/x-MS-bmp", MtpConstants.FORMAT_BMP);
        addFileType("WBMP", 35, "image/vnd.wap.wbmp");
        addFileType("WEBP", 36, "image/webp");
        addFileType("M3U", 41, "audio/x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST);
        addFileType("M3U", 41, "application/x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST);
        addFileType("PLS", 42, "audio/x-scpls", MtpConstants.FORMAT_PLS_PLAYLIST);
        addFileType("WPL", 43, "application/vnd.ms-wpl", MtpConstants.FORMAT_WPL_PLAYLIST);
        addFileType("M3U8", 44, "application/vnd.apple.mpegurl");
        addFileType("M3U8", 44, "audio/mpegurl");
        addFileType("M3U8", 44, "audio/x-mpegurl");
        addFileType("MPD", 45, o.S);
        addFileType("FL", 51, "application/x-android-drm-fl");
        addFileType(DomainConfiguration.REPLACE_TXT, 100, "text/plain", 12292);
        addFileType("HTM", 101, ClipDescription.MIMETYPE_TEXT_HTML, 12293);
        addFileType("HTML", 101, ClipDescription.MIMETYPE_TEXT_HTML, 12293);
        addFileType("PDF", 102, "application/pdf");
        addFileType("DOC", 104, "application/msword", MtpConstants.FORMAT_MS_WORD_DOCUMENT);
        addFileType("XLS", 105, "application/vnd.ms-excel", MtpConstants.FORMAT_MS_EXCEL_SPREADSHEET);
        addFileType("PPT", 106, "application/mspowerpoint", MtpConstants.FORMAT_MS_POWERPOINT_PRESENTATION);
        addFileType("FLAC", 10, "audio/flac", MtpConstants.FORMAT_FLAC);
        addFileType("ZIP", 107, "application/zip");
        addFileType("MPG", 200, "video/mp2p");
        addFileType("MPEG", 200, "video/mp2p");
        addFileType("DIVX", 201, "video/divx");
        addFileType("QCP", 303, MediaFormat.MIMETYPE_AUDIO_QCELP);
        addFileType("AC3", 302, "audio/ac3");
        addFileType("EC3", 305, "audio/eac3");
        addFileType("FLV", 202, "video/x-flv");
        addFileType("APE", 306, "audio/x-ape");
    }

    static void addFileType(String str, int i, String str2) {
        sFileTypeMap.put(str, new MediaFileType(i, str2));
        sMimeTypeMap.put(str2, Integer.valueOf(i));
    }

    static void addFileType(String str, int i, String str2, int i2) {
        addFileType(str, i, str2);
        sFileTypeToFormatMap.put(str, Integer.valueOf(i2));
        sMimeTypeToFormatMap.put(str2, Integer.valueOf(i2));
        sFormatToMimeTypeMap.put(Integer.valueOf(i2), str2);
    }

    public static String getFileTitle(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        String str2 = str;
        if (lastIndexOf >= 0) {
            int i = lastIndexOf + 1;
            str2 = str;
            if (i < str.length()) {
                str2 = str.substring(i);
            }
        }
        int lastIndexOf2 = str2.lastIndexOf(46);
        String str3 = str2;
        if (lastIndexOf2 > 0) {
            str3 = str2.substring(0, lastIndexOf2);
        }
        return str3;
    }

    public static MediaFileType getFileType(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        return sFileTypeMap.get(str.substring(lastIndexOf + 1).toUpperCase(Locale.ROOT));
    }

    public static int getFileTypeForMimeType(String str) {
        Integer num = sMimeTypeMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int getFormatCode(String str, String str2) {
        Integer num;
        if (str2 == null || (num = sMimeTypeToFormatMap.get(str2)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf > 0) {
                Integer num2 = sFileTypeToFormatMap.get(str.substring(lastIndexOf + 1).toUpperCase(Locale.ROOT));
                if (num2 != null) {
                    return num2.intValue();
                }
                return 12288;
            }
            return 12288;
        }
        return num.intValue();
    }

    public static String getMimeTypeForFile(String str) {
        MediaFileType fileType = getFileType(str);
        if (fileType == null) {
            return null;
        }
        return fileType.mimeType;
    }

    public static String getMimeTypeForFormatCode(int i) {
        return sFormatToMimeTypeMap.get(Integer.valueOf(i));
    }

    public static boolean isAudioFileType(int i) {
        if (i < 1 || i > 10) {
            if (i < 11 || i > 13) {
                return i >= 300 && i <= 306;
            }
            return true;
        }
        return true;
    }

    public static boolean isDrmFileType(int i) {
        return i >= 51 && i <= 51;
    }

    public static boolean isImageFileType(int i) {
        return i >= 31 && i <= 36;
    }

    public static boolean isMimeTypeMedia(String str) {
        int fileTypeForMimeType = getFileTypeForMimeType(str);
        return isAudioFileType(fileTypeForMimeType) || isVideoFileType(fileTypeForMimeType) || isImageFileType(fileTypeForMimeType) || isPlayListFileType(fileTypeForMimeType);
    }

    public static boolean isPlayListFileType(int i) {
        return i >= 41 && i <= 45;
    }

    public static boolean isVideoFileType(int i) {
        if (i < 21 || i > 30) {
            return i >= 200 && i <= 202;
        }
        return true;
    }

    private static boolean isWMAEnabled() {
        List<DecoderCapabilities.AudioDecoder> audioDecoders = DecoderCapabilities.getAudioDecoders();
        int size = audioDecoders.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (audioDecoders.get(i2) == DecoderCapabilities.AudioDecoder.AUDIO_DECODER_WMA) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean isWMVEnabled() {
        List<DecoderCapabilities.VideoDecoder> videoDecoders = DecoderCapabilities.getVideoDecoders();
        int size = videoDecoders.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (videoDecoders.get(i2) == DecoderCapabilities.VideoDecoder.VIDEO_DECODER_WMV) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
