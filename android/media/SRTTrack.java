package android.media;

import android.media.SubtitleTrack;
import android.os.Handler;
import android.os.Parcel;
import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/media/SRTTrack.class */
class SRTTrack extends WebVttTrack {
    private static final int KEY_LOCAL_SETTING = 102;
    private static final int KEY_START_TIME = 7;
    private static final int KEY_STRUCT_TEXT = 16;
    private static final int MEDIA_TIMED_TEXT = 99;
    private static final String TAG = "SRTTrack";
    private final Handler mEventHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SRTTrack(WebVttRenderingWidget webVttRenderingWidget, MediaFormat mediaFormat) {
        super(webVttRenderingWidget, mediaFormat);
        this.mEventHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SRTTrack(Handler handler, MediaFormat mediaFormat) {
        super(null, mediaFormat);
        this.mEventHandler = handler;
    }

    private static long parseMs(String str) {
        return (60 * Long.parseLong(str.split(":")[0].trim()) * 60 * 1000) + (60 * Long.parseLong(str.split(":")[1].trim()) * 1000) + (1000 * Long.parseLong(str.split(":")[2].split(",")[0].trim())) + Long.parseLong(str.split(":")[2].split(",")[1].trim());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v16, types: [android.media.TextTrackCueSpan[], android.media.TextTrackCueSpan[][]] */
    @Override // android.media.SubtitleTrack
    public void onData(SubtitleData subtitleData) {
        try {
            TextTrackCue textTrackCue = new TextTrackCue();
            textTrackCue.mStartTimeMs = subtitleData.getStartTimeUs() / 1000;
            textTrackCue.mEndTimeMs = (subtitleData.getStartTimeUs() + subtitleData.getDurationUs()) / 1000;
            String[] split = new String(subtitleData.getData(), "UTF-8").split("\\r?\\n");
            textTrackCue.mLines = new TextTrackCueSpan[split.length];
            int length = split.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= length) {
                    addCue(textTrackCue);
                    return;
                }
                TextTrackCueSpan textTrackCueSpan = new TextTrackCueSpan(split[i], -1L);
                TextTrackCueSpan[][] textTrackCueSpanArr = textTrackCue.mLines;
                TextTrackCueSpan[] textTrackCueSpanArr2 = new TextTrackCueSpan[1];
                textTrackCueSpanArr2[0] = textTrackCueSpan;
                textTrackCueSpanArr[i3] = textTrackCueSpanArr2;
                i++;
                i2 = i3 + 1;
            }
        } catch (UnsupportedEncodingException e) {
            Log.w(TAG, "subtitle data is not UTF-8 encoded: " + e);
        }
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [android.media.TextTrackCueSpan[], android.media.TextTrackCueSpan[][]] */
    @Override // android.media.WebVttTrack, android.media.SubtitleTrack
    public void onData(byte[] bArr, boolean z, long j) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), "UTF-8"));
            while (bufferedReader.readLine() != null && (readLine = bufferedReader.readLine()) != null) {
                TextTrackCue textTrackCue = new TextTrackCue();
                String[] split = readLine.split("-->");
                textTrackCue.mStartTimeMs = parseMs(split[0]);
                textTrackCue.mEndTimeMs = parseMs(split[1]);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 == null || readLine2.trim().equals("")) {
                        break;
                    }
                    arrayList.add(readLine2);
                }
                textTrackCue.mLines = new TextTrackCueSpan[arrayList.size()];
                textTrackCue.mStrings = (String[]) arrayList.toArray(new String[0]);
                Iterator it = arrayList.iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (it.hasNext()) {
                        String str = (String) it.next();
                        TextTrackCueSpan textTrackCueSpan = new TextTrackCueSpan(str, -1L);
                        textTrackCue.mStrings[i2] = str;
                        TextTrackCueSpan[][] textTrackCueSpanArr = textTrackCue.mLines;
                        TextTrackCueSpan[] textTrackCueSpanArr2 = new TextTrackCueSpan[1];
                        textTrackCueSpanArr2[0] = textTrackCueSpan;
                        textTrackCueSpanArr[i2] = textTrackCueSpanArr2;
                        i = i2 + 1;
                    }
                }
                addCue(textTrackCue);
            }
        } catch (UnsupportedEncodingException e) {
            Log.w(TAG, "subtitle data is not UTF-8 encoded: " + e);
        } catch (IOException e2) {
            Log.e(TAG, e2.getMessage(), e2);
        }
    }

    @Override // android.media.WebVttTrack, android.media.SubtitleTrack
    public void updateView(Vector<SubtitleTrack.Cue> vector) {
        if (getRenderingWidget() != null) {
            super.updateView(vector);
        } else if (this.mEventHandler != null) {
            Iterator<SubtitleTrack.Cue> it = vector.iterator();
            while (it.hasNext()) {
                SubtitleTrack.Cue next = it.next();
                TextTrackCue textTrackCue = (TextTrackCue) next;
                Parcel obtain = Parcel.obtain();
                obtain.writeInt(102);
                obtain.writeInt(7);
                obtain.writeInt((int) next.mStartTimeMs);
                obtain.writeInt(16);
                StringBuilder sb = new StringBuilder();
                String[] strArr = textTrackCue.mStrings;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        sb.append(strArr[i2]).append('\n');
                        i = i2 + 1;
                    }
                }
                byte[] bytes = sb.toString().getBytes();
                obtain.writeInt(bytes.length);
                obtain.writeByteArray(bytes);
                this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(99, 0, 0, obtain));
            }
            vector.clear();
        }
    }
}
