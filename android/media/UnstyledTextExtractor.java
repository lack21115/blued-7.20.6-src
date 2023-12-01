package android.media;

import android.media.Tokenizer;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/media/UnstyledTextExtractor.class */
class UnstyledTextExtractor implements Tokenizer.OnTokenListener {
    long mLastTimestamp;
    StringBuilder mLine = new StringBuilder();
    Vector<TextTrackCueSpan[]> mLines = new Vector<>();
    Vector<TextTrackCueSpan> mCurrentLine = new Vector<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnstyledTextExtractor() {
        init();
    }

    private void init() {
        this.mLine.delete(0, this.mLine.length());
        this.mLines.clear();
        this.mCurrentLine.clear();
        this.mLastTimestamp = -1L;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [android.media.TextTrackCueSpan[], android.media.TextTrackCueSpan[][], java.lang.Object[]] */
    public TextTrackCueSpan[][] getText() {
        if (this.mLine.length() > 0 || this.mCurrentLine.size() > 0) {
            onLineEnd();
        }
        ?? r0 = new TextTrackCueSpan[this.mLines.size()];
        this.mLines.toArray(r0);
        init();
        return r0;
    }

    @Override // android.media.Tokenizer.OnTokenListener
    public void onData(String str) {
        this.mLine.append(str);
    }

    @Override // android.media.Tokenizer.OnTokenListener
    public void onEnd(String str) {
    }

    @Override // android.media.Tokenizer.OnTokenListener
    public void onLineEnd() {
        if (this.mLine.length() > 0) {
            this.mCurrentLine.add(new TextTrackCueSpan(this.mLine.toString(), this.mLastTimestamp));
            this.mLine.delete(0, this.mLine.length());
        }
        TextTrackCueSpan[] textTrackCueSpanArr = new TextTrackCueSpan[this.mCurrentLine.size()];
        this.mCurrentLine.toArray(textTrackCueSpanArr);
        this.mCurrentLine.clear();
        this.mLines.add(textTrackCueSpanArr);
    }

    @Override // android.media.Tokenizer.OnTokenListener
    public void onStart(String str, String[] strArr, String str2) {
    }

    @Override // android.media.Tokenizer.OnTokenListener
    public void onTimeStamp(long j) {
        if (this.mLine.length() > 0 && j != this.mLastTimestamp) {
            this.mCurrentLine.add(new TextTrackCueSpan(this.mLine.toString(), this.mLastTimestamp));
            this.mLine.delete(0, this.mLine.length());
        }
        this.mLastTimestamp = j;
    }
}
