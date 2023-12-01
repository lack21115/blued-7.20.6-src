package android.util;

import android.os.SystemClock;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/util/TimingLogger.class */
public class TimingLogger {
    private boolean mDisabled;
    private String mLabel;
    ArrayList<String> mSplitLabels;
    ArrayList<Long> mSplits;
    private String mTag;

    public TimingLogger(String str, String str2) {
        reset(str, str2);
    }

    public void addSplit(String str) {
        if (this.mDisabled) {
            return;
        }
        this.mSplits.add(Long.valueOf(SystemClock.elapsedRealtime()));
        this.mSplitLabels.add(str);
    }

    public void dumpToLog() {
        if (this.mDisabled) {
            return;
        }
        Log.d(this.mTag, this.mLabel + ": begin");
        long longValue = this.mSplits.get(0).longValue();
        long j = longValue;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSplits.size()) {
                Log.d(this.mTag, this.mLabel + ": end, " + (j - longValue) + " ms");
                return;
            }
            j = this.mSplits.get(i2).longValue();
            Log.d(this.mTag, this.mLabel + ":      " + (j - this.mSplits.get(i2 - 1).longValue()) + " ms, " + this.mSplitLabels.get(i2));
            i = i2 + 1;
        }
    }

    public void reset() {
        this.mDisabled = !Log.isLoggable(this.mTag, 2);
        if (this.mDisabled) {
            return;
        }
        if (this.mSplits == null) {
            this.mSplits = new ArrayList<>();
            this.mSplitLabels = new ArrayList<>();
        } else {
            this.mSplits.clear();
            this.mSplitLabels.clear();
        }
        addSplit(null);
    }

    public void reset(String str, String str2) {
        this.mTag = str;
        this.mLabel = str2;
        reset();
    }
}
