package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/TextTrackCueSpan.class */
class TextTrackCueSpan {
    boolean mEnabled;
    String mText;
    long mTimestampMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextTrackCueSpan(String str, long j) {
        this.mTimestampMs = j;
        this.mText = str;
        this.mEnabled = this.mTimestampMs < 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TextTrackCueSpan) {
            TextTrackCueSpan textTrackCueSpan = (TextTrackCueSpan) obj;
            return this.mTimestampMs == textTrackCueSpan.mTimestampMs && this.mText.equals(textTrackCueSpan.mText);
        }
        return false;
    }
}
