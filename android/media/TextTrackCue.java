package android.media;

import android.media.SubtitleTrack;
import com.igexin.push.core.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/TextTrackCue.class */
public class TextTrackCue extends SubtitleTrack.Cue {
    static final int ALIGNMENT_END = 202;
    static final int ALIGNMENT_LEFT = 203;
    static final int ALIGNMENT_MIDDLE = 200;
    static final int ALIGNMENT_RIGHT = 204;
    static final int ALIGNMENT_START = 201;
    private static final String TAG = "TTCue";
    static final int WRITING_DIRECTION_HORIZONTAL = 100;
    static final int WRITING_DIRECTION_VERTICAL_LR = 102;
    static final int WRITING_DIRECTION_VERTICAL_RL = 101;
    boolean mAutoLinePosition;
    String[] mStrings;
    String mId = "";
    boolean mPauseOnExit = false;
    int mWritingDirection = 100;
    String mRegionId = "";
    boolean mSnapToLines = true;
    Integer mLinePosition = null;
    int mTextPosition = 50;
    int mSize = 100;
    int mAlignment = 200;
    TextTrackCueSpan[][] mLines = null;
    TextTrackRegion mRegion = null;

    public StringBuilder appendLinesToBuilder(StringBuilder sb) {
        if (this.mLines == null) {
            sb.append(b.l);
            return sb;
        }
        sb.append("[");
        boolean z = true;
        TextTrackCueSpan[][] textTrackCueSpanArr = this.mLines;
        int length = textTrackCueSpanArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append("]");
                return sb;
            }
            TextTrackCueSpan[] textTrackCueSpanArr2 = textTrackCueSpanArr[i2];
            if (!z) {
                sb.append(", ");
            }
            if (textTrackCueSpanArr2 == null) {
                sb.append(b.l);
            } else {
                sb.append("\"");
                boolean z2 = true;
                long j = -1;
                int length2 = textTrackCueSpanArr2.length;
                int i3 = 0;
                while (i3 < length2) {
                    TextTrackCueSpan textTrackCueSpan = textTrackCueSpanArr2[i3];
                    if (!z2) {
                        sb.append(" ");
                    }
                    long j2 = j;
                    if (textTrackCueSpan.mTimestampMs != j) {
                        sb.append(SimpleComparison.LESS_THAN_OPERATION).append(WebVttParser.timeToString(textTrackCueSpan.mTimestampMs)).append(SimpleComparison.GREATER_THAN_OPERATION);
                        j2 = textTrackCueSpan.mTimestampMs;
                    }
                    sb.append(textTrackCueSpan.mText);
                    z2 = false;
                    i3++;
                    j = j2;
                }
                sb.append("\"");
            }
            z = false;
            i = i2 + 1;
        }
    }

    public StringBuilder appendStringsToBuilder(StringBuilder sb) {
        if (this.mStrings == null) {
            sb.append(b.l);
            return sb;
        }
        sb.append("[");
        boolean z = true;
        String[] strArr = this.mStrings;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append("]");
                return sb;
            }
            String str = strArr[i2];
            if (!z) {
                sb.append(", ");
            }
            if (str == null) {
                sb.append(b.l);
            } else {
                sb.append("\"");
                sb.append(str);
                sb.append("\"");
            }
            z = false;
            i = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof TextTrackCue)) {
            z = false;
        } else if (this == obj) {
            return true;
        } else {
            try {
                TextTrackCue textTrackCue = (TextTrackCue) obj;
                boolean z2 = this.mId.equals(textTrackCue.mId) && this.mPauseOnExit == textTrackCue.mPauseOnExit && this.mWritingDirection == textTrackCue.mWritingDirection && this.mRegionId.equals(textTrackCue.mRegionId) && this.mSnapToLines == textTrackCue.mSnapToLines && this.mAutoLinePosition == textTrackCue.mAutoLinePosition && (this.mAutoLinePosition || this.mLinePosition == textTrackCue.mLinePosition) && this.mTextPosition == textTrackCue.mTextPosition && this.mSize == textTrackCue.mSize && this.mAlignment == textTrackCue.mAlignment && this.mLines.length == textTrackCue.mLines.length;
                z = z2;
                if (z2) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        z = z2;
                        if (i2 >= this.mLines.length) {
                            break;
                        } else if (!Arrays.equals(this.mLines[i2], textTrackCue.mLines[i2])) {
                            return false;
                        } else {
                            i = i2 + 1;
                        }
                    }
                }
            } catch (IncompatibleClassChangeError e) {
                return false;
            }
        }
        return z;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // android.media.SubtitleTrack.Cue
    public void onTime(long j) {
        TextTrackCueSpan[][] textTrackCueSpanArr = this.mLines;
        int length = textTrackCueSpanArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            TextTrackCueSpan[] textTrackCueSpanArr2 = textTrackCueSpanArr[i2];
            int length2 = textTrackCueSpanArr2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length2) {
                    TextTrackCueSpan textTrackCueSpan = textTrackCueSpanArr2[i4];
                    textTrackCueSpan.mEnabled = j >= textTrackCueSpan.mTimestampMs;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WebVttParser.timeToString(this.mStartTimeMs)).append(" --> ").append(WebVttParser.timeToString(this.mEndTimeMs)).append(" {id:\"").append(this.mId).append("\", pauseOnExit:").append(this.mPauseOnExit).append(", direction:").append(this.mWritingDirection == 100 ? "horizontal" : this.mWritingDirection == 102 ? "vertical_lr" : this.mWritingDirection == 101 ? "vertical_rl" : "INVALID").append(", regionId:\"").append(this.mRegionId).append("\", snapToLines:").append(this.mSnapToLines).append(", linePosition:").append(this.mAutoLinePosition ? "auto" : this.mLinePosition).append(", textPosition:").append(this.mTextPosition).append(", size:").append(this.mSize).append(", alignment:").append(this.mAlignment == 202 ? "end" : this.mAlignment == 203 ? "left" : this.mAlignment == 200 ? "middle" : this.mAlignment == 204 ? "right" : this.mAlignment == 201 ? "start" : "INVALID").append(", text:");
        appendStringsToBuilder(sb).append("}");
        return sb.toString();
    }
}
