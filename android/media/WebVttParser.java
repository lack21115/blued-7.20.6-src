package android.media;

import android.provider.BrowserContract;
import android.util.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/WebVttParser.class */
public class WebVttParser {
    private static final String TAG = "WebVttParser";
    private TextTrackCue mCue;
    private WebVttCueListener mListener;
    private final Phase mSkipRest = new Phase() { // from class: android.media.WebVttParser.1
        @Override // android.media.WebVttParser.Phase
        public void parse(String str) {
        }
    };
    private final Phase mParseStart = new Phase() { // from class: android.media.WebVttParser.2
        @Override // android.media.WebVttParser.Phase
        public void parse(String str) {
            String str2 = str;
            if (str.startsWith(AsyncHttpResponseHandler.UTF8_BOM)) {
                str2 = str.substring(1);
            }
            if (str2.equals("WEBVTT") || str2.startsWith("WEBVTT ") || str2.startsWith("WEBVTT\t")) {
                WebVttParser.this.mPhase = WebVttParser.this.mParseHeader;
                return;
            }
            WebVttParser.this.log_warning("Not a WEBVTT header", str2);
            WebVttParser.this.mPhase = WebVttParser.this.mSkipRest;
        }
    };
    private final Phase mParseHeader = new Phase() { // from class: android.media.WebVttParser.3
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !WebVttParser.class.desiredAssertionStatus();
        }

        @Override // android.media.WebVttParser.Phase
        public void parse(String str) {
            if (str.length() == 0) {
                WebVttParser.this.mPhase = WebVttParser.this.mParseCueId;
            } else if (str.contains("-->")) {
                WebVttParser.this.mPhase = WebVttParser.this.mParseCueTime;
                WebVttParser.this.mPhase.parse(str);
            } else {
                int indexOf = str.indexOf(58);
                if (indexOf <= 0 || indexOf >= str.length() - 1) {
                    WebVttParser.this.log_warning("meta data header has invalid format", str);
                }
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring.equals("Region")) {
                    WebVttParser.this.mListener.onRegionParsed(parseRegion(substring2));
                }
            }
        }

        TextTrackRegion parseRegion(String str) {
            TextTrackRegion textTrackRegion = new TextTrackRegion();
            String[] split = str.split(" +");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return textTrackRegion;
                }
                String str2 = split[i2];
                int indexOf = str2.indexOf(61);
                if (indexOf > 0 && indexOf != str2.length() - 1) {
                    String substring = str2.substring(0, indexOf);
                    String substring2 = str2.substring(indexOf + 1);
                    if (substring.equals("id")) {
                        textTrackRegion.mId = substring2;
                    } else if (substring.equals("width")) {
                        try {
                            textTrackRegion.mWidth = WebVttParser.parseFloatPercentage(substring2);
                        } catch (NumberFormatException e) {
                            WebVttParser.this.log_warning("region setting", substring, "has invalid value", e.getMessage(), substring2);
                        }
                    } else if (substring.equals("lines")) {
                        if (substring2.matches(".*[^0-9].*")) {
                            WebVttParser.this.log_warning("lines", substring, "contains an invalid character", substring2);
                        } else {
                            try {
                                textTrackRegion.mLines = Integer.parseInt(substring2);
                                if (!$assertionsDisabled && textTrackRegion.mLines < 0) {
                                    throw new AssertionError();
                                    break;
                                }
                            } catch (NumberFormatException e2) {
                                WebVttParser.this.log_warning("region setting", substring, "is not numeric", substring2);
                            }
                        }
                    } else if (substring.equals("regionanchor") || substring.equals("viewportanchor")) {
                        int indexOf2 = substring2.indexOf(",");
                        if (indexOf2 < 0) {
                            WebVttParser.this.log_warning("region setting", substring, "contains no comma", substring2);
                        } else {
                            String substring3 = substring2.substring(0, indexOf2);
                            String substring4 = substring2.substring(indexOf2 + 1);
                            try {
                                float parseFloatPercentage = WebVttParser.parseFloatPercentage(substring3);
                                try {
                                    float parseFloatPercentage2 = WebVttParser.parseFloatPercentage(substring4);
                                    if (substring.charAt(0) == 'r') {
                                        textTrackRegion.mAnchorPointX = parseFloatPercentage;
                                        textTrackRegion.mAnchorPointY = parseFloatPercentage2;
                                    } else {
                                        textTrackRegion.mViewportAnchorPointX = parseFloatPercentage;
                                        textTrackRegion.mViewportAnchorPointY = parseFloatPercentage2;
                                    }
                                } catch (NumberFormatException e3) {
                                    WebVttParser.this.log_warning("region setting", substring, "has invalid y component", e3.getMessage(), substring4);
                                }
                            } catch (NumberFormatException e4) {
                                WebVttParser.this.log_warning("region setting", substring, "has invalid x component", e4.getMessage(), substring3);
                            }
                        }
                    } else if (substring.equals("scroll")) {
                        if (substring2.equals("up")) {
                            textTrackRegion.mScrollValue = 301;
                        } else {
                            WebVttParser.this.log_warning("region setting", substring, "has invalid value", substring2);
                        }
                    }
                }
                i = i2 + 1;
            }
        }
    };
    private final Phase mParseCueId = new Phase() { // from class: android.media.WebVttParser.4
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !WebVttParser.class.desiredAssertionStatus();
        }

        @Override // android.media.WebVttParser.Phase
        public void parse(String str) {
            if (str.length() == 0) {
                return;
            }
            if (!$assertionsDisabled && WebVttParser.this.mCue != null) {
                throw new AssertionError();
            }
            if (str.equals("NOTE") || str.startsWith("NOTE ")) {
                WebVttParser.this.mPhase = WebVttParser.this.mParseCueText;
            }
            WebVttParser.this.mCue = new TextTrackCue();
            WebVttParser.this.mCueTexts.clear();
            WebVttParser.this.mPhase = WebVttParser.this.mParseCueTime;
            if (str.contains("-->")) {
                WebVttParser.this.mPhase.parse(str);
            } else {
                WebVttParser.this.mCue.mId = str;
            }
        }
    };
    private final Phase mParseCueTime = new Phase() { // from class: android.media.WebVttParser.5
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !WebVttParser.class.desiredAssertionStatus();
        }

        @Override // android.media.WebVttParser.Phase
        public void parse(String str) {
            int indexOf = str.indexOf("-->");
            if (indexOf < 0) {
                WebVttParser.this.mCue = null;
                WebVttParser.this.mPhase = WebVttParser.this.mParseCueId;
                return;
            }
            String trim = str.substring(0, indexOf).trim();
            String replaceFirst = str.substring(indexOf + 3).replaceFirst("^\\s+", "").replaceFirst("\\s+", " ");
            int indexOf2 = replaceFirst.indexOf(32);
            String substring = indexOf2 > 0 ? replaceFirst.substring(0, indexOf2) : replaceFirst;
            String substring2 = indexOf2 > 0 ? replaceFirst.substring(indexOf2 + 1) : "";
            WebVttParser.this.mCue.mStartTimeMs = WebVttParser.parseTimestampMs(trim);
            WebVttParser.this.mCue.mEndTimeMs = WebVttParser.parseTimestampMs(substring);
            String[] split = substring2.split(" +");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    if (WebVttParser.this.mCue.mLinePosition != null || WebVttParser.this.mCue.mSize != 100 || WebVttParser.this.mCue.mWritingDirection != 100) {
                        WebVttParser.this.mCue.mRegionId = "";
                    }
                    WebVttParser.this.mPhase = WebVttParser.this.mParseCueText;
                    return;
                }
                String str2 = split[i2];
                int indexOf3 = str2.indexOf(58);
                if (indexOf3 > 0 && indexOf3 != str2.length() - 1) {
                    String substring3 = str2.substring(0, indexOf3);
                    String substring4 = str2.substring(indexOf3 + 1);
                    if (substring3.equals(TtmlUtils.TAG_REGION)) {
                        WebVttParser.this.mCue.mRegionId = substring4;
                    } else if (substring3.equals("vertical")) {
                        if (substring4.equals("rl")) {
                            WebVttParser.this.mCue.mWritingDirection = 101;
                        } else if (substring4.equals("lr")) {
                            WebVttParser.this.mCue.mWritingDirection = 102;
                        } else {
                            WebVttParser.this.log_warning("cue setting", substring3, "has invalid value", substring4);
                        }
                    } else if (substring3.equals("line")) {
                        try {
                            if (!$assertionsDisabled && substring4.indexOf(32) >= 0) {
                                throw new AssertionError();
                                break;
                            } else if (substring4.endsWith("%")) {
                                WebVttParser.this.mCue.mSnapToLines = false;
                                WebVttParser.this.mCue.mLinePosition = Integer.valueOf(WebVttParser.parseIntPercentage(substring4));
                            } else if (substring4.matches(".*[^0-9].*")) {
                                WebVttParser.this.log_warning("cue setting", substring3, "contains an invalid character", substring4);
                            } else {
                                WebVttParser.this.mCue.mSnapToLines = true;
                                WebVttParser.this.mCue.mLinePosition = Integer.valueOf(Integer.parseInt(substring4));
                            }
                        } catch (NumberFormatException e) {
                            WebVttParser.this.log_warning("cue setting", substring3, "is not numeric or percentage", substring4);
                        }
                    } else if (substring3.equals(BrowserContract.Bookmarks.POSITION)) {
                        try {
                            WebVttParser.this.mCue.mTextPosition = WebVttParser.parseIntPercentage(substring4);
                        } catch (NumberFormatException e2) {
                            WebVttParser.this.log_warning("cue setting", substring3, "is not numeric or percentage", substring4);
                        }
                    } else if (substring3.equals("size")) {
                        try {
                            WebVttParser.this.mCue.mSize = WebVttParser.parseIntPercentage(substring4);
                        } catch (NumberFormatException e3) {
                            WebVttParser.this.log_warning("cue setting", substring3, "is not numeric or percentage", substring4);
                        }
                    } else if (substring3.equals("align")) {
                        if (substring4.equals("start")) {
                            WebVttParser.this.mCue.mAlignment = 201;
                        } else if (substring4.equals("middle")) {
                            WebVttParser.this.mCue.mAlignment = 200;
                        } else if (substring4.equals("end")) {
                            WebVttParser.this.mCue.mAlignment = 202;
                        } else if (substring4.equals("left")) {
                            WebVttParser.this.mCue.mAlignment = 203;
                        } else if (substring4.equals("right")) {
                            WebVttParser.this.mCue.mAlignment = 204;
                        } else {
                            WebVttParser.this.log_warning("cue setting", substring3, "has invalid value", substring4);
                        }
                    }
                }
                i = i2 + 1;
            }
        }
    };
    private final Phase mParseCueText = new Phase() { // from class: android.media.WebVttParser.6
        @Override // android.media.WebVttParser.Phase
        public void parse(String str) {
            if (str.length() == 0) {
                WebVttParser.this.yieldCue();
                WebVttParser.this.mPhase = WebVttParser.this.mParseCueId;
            } else if (WebVttParser.this.mCue != null) {
                WebVttParser.this.mCueTexts.add(str);
            }
        }
    };
    private Phase mPhase = this.mParseStart;
    private String mBuffer = "";
    private Vector<String> mCueTexts = new Vector<>();

    /* loaded from: source-9557208-dex2jar.jar:android/media/WebVttParser$Phase.class */
    interface Phase {
        void parse(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebVttParser(WebVttCueListener webVttCueListener) {
        this.mListener = webVttCueListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log_warning(String str, String str2) {
        Log.w(getClass().getName(), str + " ('" + str2 + "')");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log_warning(String str, String str2, String str3, String str4) {
        Log.w(getClass().getName(), str + " '" + str2 + "' " + str3 + " ('" + str4 + "')");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log_warning(String str, String str2, String str3, String str4, String str5) {
        Log.w(getClass().getName(), str + " '" + str2 + "' " + str3 + " ('" + str5 + "' " + str4 + ")");
    }

    public static float parseFloatPercentage(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            String substring = str.substring(0, str.length() - 1);
            if (substring.matches(".*[^0-9.].*")) {
                throw new NumberFormatException("contains an invalid character");
            }
            try {
                float parseFloat = Float.parseFloat(substring);
                if (parseFloat < 0.0f || parseFloat > 100.0f) {
                    throw new NumberFormatException("is out of range");
                }
                return parseFloat;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("is not a number");
            }
        }
        throw new NumberFormatException("does not end in %");
    }

    public static int parseIntPercentage(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            String substring = str.substring(0, str.length() - 1);
            if (substring.matches(".*[^0-9].*")) {
                throw new NumberFormatException("contains an invalid character");
            }
            try {
                int parseInt = Integer.parseInt(substring);
                if (parseInt < 0 || parseInt > 100) {
                    throw new NumberFormatException("is out of range");
                }
                return parseInt;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("is not a number");
            }
        }
        throw new NumberFormatException("does not end in %");
    }

    public static long parseTimestampMs(String str) throws NumberFormatException {
        if (!str.matches("(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}")) {
            throw new NumberFormatException("has invalid format");
        }
        String[] split = str.split("\\.", 2);
        long j = 0;
        String[] split2 = split[0].split(":");
        int length = split2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (1000 * j) + Long.parseLong(split[1]);
            }
            j = (60 * j) + Long.parseLong(split2[i2]);
            i = i2 + 1;
        }
    }

    public static String timeToString(long j) {
        return String.format("%d:%02d:%02d.%03d", Long.valueOf(j / 3600000), Long.valueOf((j / 60000) % 60), Long.valueOf((j / 1000) % 60), Long.valueOf(j % 1000));
    }

    public void eos() {
        if (this.mBuffer.endsWith("\r")) {
            this.mBuffer = this.mBuffer.substring(0, this.mBuffer.length() - 1);
        }
        this.mPhase.parse(this.mBuffer);
        this.mBuffer = "";
        yieldCue();
        this.mPhase = this.mParseStart;
    }

    public void parse(String str) {
        boolean z = false;
        this.mBuffer = (this.mBuffer + str.replace("��", "�")).replace(IOUtils.LINE_SEPARATOR_WINDOWS, "\n");
        if (this.mBuffer.endsWith("\r")) {
            z = true;
            this.mBuffer = this.mBuffer.substring(0, this.mBuffer.length() - 1);
        }
        String[] split = this.mBuffer.split("[\r\n]");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length - 1) {
                break;
            }
            this.mPhase.parse(split[i2]);
            i = i2 + 1;
        }
        this.mBuffer = split[split.length - 1];
        if (z) {
            this.mBuffer += "\r";
        }
    }

    public void yieldCue() {
        if (this.mCue != null && this.mCueTexts.size() > 0) {
            this.mCue.mStrings = new String[this.mCueTexts.size()];
            this.mCueTexts.toArray(this.mCue.mStrings);
            this.mCueTexts.clear();
            this.mListener.onCueParsed(this.mCue);
        }
        this.mCue = null;
    }
}
