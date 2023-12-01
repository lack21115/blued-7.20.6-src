package android.media;

import android.media.SubtitleTrack;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/media/WebVttTrack.class */
class WebVttTrack extends SubtitleTrack implements WebVttCueListener {
    private static final String TAG = "WebVttTrack";
    private Long mCurrentRunID;
    private final UnstyledTextExtractor mExtractor;
    private final WebVttParser mParser;
    private final Map<String, TextTrackRegion> mRegions;
    private final WebVttRenderingWidget mRenderingWidget;
    private final Vector<Long> mTimestamps;
    private final Tokenizer mTokenizer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebVttTrack(WebVttRenderingWidget webVttRenderingWidget, MediaFormat mediaFormat) {
        super(mediaFormat);
        this.mParser = new WebVttParser(this);
        this.mExtractor = new UnstyledTextExtractor();
        this.mTokenizer = new Tokenizer(this.mExtractor);
        this.mTimestamps = new Vector<>();
        this.mRegions = new HashMap();
        this.mRenderingWidget = webVttRenderingWidget;
    }

    @Override // android.media.SubtitleTrack
    public WebVttRenderingWidget getRenderingWidget() {
        return this.mRenderingWidget;
    }

    @Override // android.media.WebVttCueListener
    public void onCueParsed(TextTrackCue textTrackCue) {
        synchronized (this.mParser) {
            if (textTrackCue.mRegionId.length() != 0) {
                textTrackCue.mRegion = this.mRegions.get(textTrackCue.mRegionId);
            }
            if (this.DEBUG) {
                Log.v(TAG, "adding cue " + textTrackCue);
            }
            this.mTokenizer.reset();
            String[] strArr = textTrackCue.mStrings;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                this.mTokenizer.tokenize(strArr[i2]);
                i = i2 + 1;
            }
            textTrackCue.mLines = this.mExtractor.getText();
            if (this.DEBUG) {
                Log.v(TAG, textTrackCue.appendLinesToBuilder(textTrackCue.appendStringsToBuilder(new StringBuilder()).append(" simplified to: ")).toString());
            }
            TextTrackCueSpan[][] textTrackCueSpanArr = textTrackCue.mLines;
            int length2 = textTrackCueSpanArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                TextTrackCueSpan[] textTrackCueSpanArr2 = textTrackCueSpanArr[i4];
                int length3 = textTrackCueSpanArr2.length;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 < length3) {
                        TextTrackCueSpan textTrackCueSpan = textTrackCueSpanArr2[i6];
                        if (textTrackCueSpan.mTimestampMs > textTrackCue.mStartTimeMs && textTrackCueSpan.mTimestampMs < textTrackCue.mEndTimeMs && !this.mTimestamps.contains(Long.valueOf(textTrackCueSpan.mTimestampMs))) {
                            this.mTimestamps.add(Long.valueOf(textTrackCueSpan.mTimestampMs));
                        }
                        i5 = i6 + 1;
                    }
                }
                i3 = i4 + 1;
            }
            if (this.mTimestamps.size() > 0) {
                textTrackCue.mInnerTimesMs = new long[this.mTimestamps.size()];
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= this.mTimestamps.size()) {
                        break;
                    }
                    textTrackCue.mInnerTimesMs[i8] = this.mTimestamps.get(i8).longValue();
                    i7 = i8 + 1;
                }
                this.mTimestamps.clear();
            } else {
                textTrackCue.mInnerTimesMs = null;
            }
            textTrackCue.mRunID = this.mCurrentRunID.longValue();
        }
        addCue(textTrackCue);
    }

    @Override // android.media.SubtitleTrack
    public void onData(byte[] bArr, boolean z, long j) {
        try {
            String str = new String(bArr, "UTF-8");
            synchronized (this.mParser) {
                if (this.mCurrentRunID != null && j != this.mCurrentRunID.longValue()) {
                    throw new IllegalStateException("Run #" + this.mCurrentRunID + " in progress.  Cannot process run #" + j);
                }
                this.mCurrentRunID = Long.valueOf(j);
                this.mParser.parse(str);
                if (z) {
                    finishedRun(j);
                    this.mParser.eos();
                    this.mRegions.clear();
                    this.mCurrentRunID = null;
                }
            }
        } catch (UnsupportedEncodingException e) {
            Log.w(TAG, "subtitle data is not UTF-8 encoded: " + e);
        }
    }

    @Override // android.media.WebVttCueListener
    public void onRegionParsed(TextTrackRegion textTrackRegion) {
        synchronized (this.mParser) {
            this.mRegions.put(textTrackRegion.mId, textTrackRegion);
        }
    }

    @Override // android.media.SubtitleTrack
    public void updateView(Vector<SubtitleTrack.Cue> vector) {
        if (this.mVisible) {
            if (this.DEBUG && this.mTimeProvider != null) {
                try {
                    Log.d(TAG, "at " + (this.mTimeProvider.getCurrentTimeUs(false, true) / 1000) + " ms the active cues are:");
                } catch (IllegalStateException e) {
                    Log.d(TAG, "at (illegal state) the active cues are:");
                }
            }
            if (this.mRenderingWidget != null) {
                this.mRenderingWidget.setActiveCues(vector);
            }
        }
    }
}
