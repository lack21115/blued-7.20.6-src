package android.media;

import android.graphics.Canvas;
import android.media.MediaTimeProvider;
import android.os.Handler;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/media/SubtitleTrack.class */
public abstract class SubtitleTrack implements MediaTimeProvider.OnMediaTimeListener {
    private static final String TAG = "SubtitleTrack";
    private MediaFormat mFormat;
    private long mLastTimeMs;
    private long mLastUpdateTimeMs;
    private Runnable mRunnable;
    protected MediaTimeProvider mTimeProvider;
    protected boolean mVisible;
    protected final LongSparseArray<Run> mRunsByEndTime = new LongSparseArray<>();
    protected final LongSparseArray<Run> mRunsByID = new LongSparseArray<>();
    protected final Vector<Cue> mActiveCues = new Vector<>();
    public boolean DEBUG = false;
    protected Handler mHandler = new Handler();
    private long mNextScheduledTimeMs = -1;
    protected CueList mCues = new CueList();

    /* loaded from: source-9557208-dex2jar.jar:android/media/SubtitleTrack$Cue.class */
    public static class Cue {
        public long mEndTimeMs;
        public long[] mInnerTimesMs;
        public Cue mNextInRun;
        public long mRunID;
        public long mStartTimeMs;

        public void onTime(long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/SubtitleTrack$CueList.class */
    public static class CueList {
        private static final String TAG = "CueList";
        public boolean DEBUG = false;
        private SortedMap<Long, Vector<Cue>> mCues = new TreeMap();

        /* loaded from: source-9557208-dex2jar.jar:android/media/SubtitleTrack$CueList$EntryIterator.class */
        class EntryIterator implements Iterator<Pair<Long, Cue>> {
            private long mCurrentTimeMs;
            private boolean mDone;
            private Pair<Long, Cue> mLastEntry;
            private Iterator<Cue> mLastListIterator;
            private Iterator<Cue> mListIterator;
            private SortedMap<Long, Vector<Cue>> mRemainingCues;

            public EntryIterator(SortedMap<Long, Vector<Cue>> sortedMap) {
                if (CueList.this.DEBUG) {
                    Log.v(CueList.TAG, sortedMap + "");
                }
                this.mRemainingCues = sortedMap;
                this.mLastListIterator = null;
                nextKey();
            }

            private void nextKey() {
                do {
                    try {
                        if (this.mRemainingCues == null) {
                            throw new NoSuchElementException("");
                        }
                        this.mCurrentTimeMs = this.mRemainingCues.firstKey().longValue();
                        this.mListIterator = this.mRemainingCues.get(Long.valueOf(this.mCurrentTimeMs)).iterator();
                        try {
                            this.mRemainingCues = this.mRemainingCues.tailMap(Long.valueOf(this.mCurrentTimeMs + 1));
                        } catch (IllegalArgumentException e) {
                            this.mRemainingCues = null;
                        }
                        this.mDone = false;
                    } catch (NoSuchElementException e2) {
                        this.mDone = true;
                        this.mRemainingCues = null;
                        this.mListIterator = null;
                        return;
                    }
                    this.mDone = true;
                    this.mRemainingCues = null;
                    this.mListIterator = null;
                    return;
                } while (!this.mListIterator.hasNext());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.mDone;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Pair<Long, Cue> next() {
                if (this.mDone) {
                    throw new NoSuchElementException("");
                }
                this.mLastEntry = new Pair<>(Long.valueOf(this.mCurrentTimeMs), this.mListIterator.next());
                this.mLastListIterator = this.mListIterator;
                if (!this.mListIterator.hasNext()) {
                    nextKey();
                }
                return this.mLastEntry;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.mLastListIterator == null || this.mLastEntry.second.mEndTimeMs != this.mLastEntry.first.longValue()) {
                    throw new IllegalStateException("");
                }
                this.mLastListIterator.remove();
                this.mLastListIterator = null;
                if (((Vector) CueList.this.mCues.get(this.mLastEntry.first)).size() == 0) {
                    CueList.this.mCues.remove(this.mLastEntry.first);
                }
                Cue cue = this.mLastEntry.second;
                CueList.this.removeEvent(cue, cue.mStartTimeMs);
                if (cue.mInnerTimesMs == null) {
                    return;
                }
                long[] jArr = cue.mInnerTimesMs;
                int length = jArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return;
                    }
                    CueList.this.removeEvent(cue, jArr[i2]);
                    i = i2 + 1;
                }
            }
        }

        CueList() {
        }

        private boolean addEvent(Cue cue, long j) {
            Vector<Cue> vector;
            Vector<Cue> vector2 = this.mCues.get(Long.valueOf(j));
            if (vector2 == null) {
                vector = new Vector<>(2);
                this.mCues.put(Long.valueOf(j), vector);
            } else {
                vector = vector2;
                if (vector2.contains(cue)) {
                    return false;
                }
            }
            vector.add(cue);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeEvent(Cue cue, long j) {
            Vector<Cue> vector = this.mCues.get(Long.valueOf(j));
            if (vector != null) {
                vector.remove(cue);
                if (vector.size() == 0) {
                    this.mCues.remove(Long.valueOf(j));
                }
            }
        }

        public void add(Cue cue) {
            if (cue.mStartTimeMs < cue.mEndTimeMs && addEvent(cue, cue.mStartTimeMs)) {
                long j = cue.mStartTimeMs;
                if (cue.mInnerTimesMs != null) {
                    long[] jArr = cue.mInnerTimesMs;
                    int length = jArr.length;
                    int i = 0;
                    while (i < length) {
                        long j2 = jArr[i];
                        long j3 = j;
                        if (j2 > j) {
                            j3 = j;
                            if (j2 < cue.mEndTimeMs) {
                                addEvent(cue, j2);
                                j3 = j2;
                            }
                        }
                        i++;
                        j = j3;
                    }
                }
                addEvent(cue, cue.mEndTimeMs);
            }
        }

        public Iterable<Pair<Long, Cue>> entriesBetween(final long j, final long j2) {
            return new Iterable<Pair<Long, Cue>>() { // from class: android.media.SubtitleTrack.CueList.1
                @Override // java.lang.Iterable
                public Iterator<Pair<Long, Cue>> iterator() {
                    if (CueList.this.DEBUG) {
                        Log.d(CueList.TAG, "slice (" + j + ", " + j2 + "]=");
                    }
                    try {
                        return new EntryIterator(CueList.this.mCues.subMap(Long.valueOf(j + 1), Long.valueOf(j2 + 1)));
                    } catch (IllegalArgumentException e) {
                        return new EntryIterator(null);
                    }
                }
            };
        }

        public long nextTimeAfter(long j) {
            try {
                SortedMap<Long, Vector<Cue>> tailMap = this.mCues.tailMap(Long.valueOf(1 + j));
                if (tailMap != null) {
                    return tailMap.firstKey().longValue();
                }
                return -1L;
            } catch (IllegalArgumentException e) {
                return -1L;
            } catch (NoSuchElementException e2) {
                return -1L;
            }
        }

        public void remove(Cue cue) {
            removeEvent(cue, cue.mStartTimeMs);
            if (cue.mInnerTimesMs != null) {
                long[] jArr = cue.mInnerTimesMs;
                int length = jArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    removeEvent(cue, jArr[i2]);
                    i = i2 + 1;
                }
            }
            removeEvent(cue, cue.mEndTimeMs);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/SubtitleTrack$RenderingWidget.class */
    public interface RenderingWidget {

        /* loaded from: source-9557208-dex2jar.jar:android/media/SubtitleTrack$RenderingWidget$OnChangedListener.class */
        public interface OnChangedListener {
            void onChanged(RenderingWidget renderingWidget);
        }

        void draw(Canvas canvas);

        void onAttachedToWindow();

        void onDetachedFromWindow();

        void setOnChangedListener(OnChangedListener onChangedListener);

        void setSize(int i, int i2);

        void setVisible(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/SubtitleTrack$Run.class */
    public static class Run {
        static final /* synthetic */ boolean $assertionsDisabled;
        public long mEndTimeMs;
        public Cue mFirstCue;
        public Run mNextRunAtEndTimeMs;
        public Run mPrevRunAtEndTimeMs;
        public long mRunID;
        private long mStoredEndTimeMs;

        static {
            $assertionsDisabled = !SubtitleTrack.class.desiredAssertionStatus();
        }

        private Run() {
            this.mEndTimeMs = -1L;
            this.mRunID = 0L;
            this.mStoredEndTimeMs = -1L;
        }

        public void removeAtEndTimeMs() {
            Run run = this.mPrevRunAtEndTimeMs;
            if (this.mPrevRunAtEndTimeMs != null) {
                this.mPrevRunAtEndTimeMs.mNextRunAtEndTimeMs = this.mNextRunAtEndTimeMs;
                this.mPrevRunAtEndTimeMs = null;
            }
            if (this.mNextRunAtEndTimeMs != null) {
                this.mNextRunAtEndTimeMs.mPrevRunAtEndTimeMs = run;
                this.mNextRunAtEndTimeMs = null;
            }
        }

        public void storeByEndTimeMs(LongSparseArray<Run> longSparseArray) {
            int indexOfKey = longSparseArray.indexOfKey(this.mStoredEndTimeMs);
            if (indexOfKey >= 0) {
                if (this.mPrevRunAtEndTimeMs == null) {
                    if (!$assertionsDisabled && this != longSparseArray.valueAt(indexOfKey)) {
                        throw new AssertionError();
                    }
                    if (this.mNextRunAtEndTimeMs == null) {
                        longSparseArray.removeAt(indexOfKey);
                    } else {
                        longSparseArray.setValueAt(indexOfKey, this.mNextRunAtEndTimeMs);
                    }
                }
                removeAtEndTimeMs();
            }
            if (this.mEndTimeMs >= 0) {
                this.mPrevRunAtEndTimeMs = null;
                this.mNextRunAtEndTimeMs = longSparseArray.get(this.mEndTimeMs);
                if (this.mNextRunAtEndTimeMs != null) {
                    this.mNextRunAtEndTimeMs.mPrevRunAtEndTimeMs = this;
                }
                longSparseArray.put(this.mEndTimeMs, this);
                this.mStoredEndTimeMs = this.mEndTimeMs;
            }
        }
    }

    public SubtitleTrack(MediaFormat mediaFormat) {
        this.mFormat = mediaFormat;
        clearActiveCues();
        this.mLastTimeMs = -1L;
    }

    private void removeRunsByEndTimeIndex(int i) {
        Run valueAt = this.mRunsByEndTime.valueAt(i);
        while (true) {
            Run run = valueAt;
            if (run == null) {
                this.mRunsByEndTime.removeAt(i);
                return;
            }
            Cue cue = run.mFirstCue;
            while (true) {
                Cue cue2 = cue;
                if (cue2 != null) {
                    this.mCues.remove(cue2);
                    Cue cue3 = cue2.mNextInRun;
                    cue2.mNextInRun = null;
                    cue = cue3;
                }
            }
            this.mRunsByID.remove(run.mRunID);
            Run run2 = run.mNextRunAtEndTimeMs;
            run.mPrevRunAtEndTimeMs = null;
            run.mNextRunAtEndTimeMs = null;
            valueAt = run2;
        }
    }

    private void takeTime(long j) {
        synchronized (this) {
            this.mLastTimeMs = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addCue(Cue cue) {
        boolean z;
        Run run;
        synchronized (this) {
            this.mCues.add(cue);
            if (cue.mRunID != 0) {
                Run run2 = this.mRunsByID.get(cue.mRunID);
                if (run2 == null) {
                    run = new Run();
                    this.mRunsByID.put(cue.mRunID, run);
                    run.mEndTimeMs = cue.mEndTimeMs;
                } else {
                    run = run2;
                    if (run2.mEndTimeMs < cue.mEndTimeMs) {
                        run2.mEndTimeMs = cue.mEndTimeMs;
                        run = run2;
                    }
                }
                cue.mNextInRun = run.mFirstCue;
                run.mFirstCue = cue;
            }
            long j = -1;
            if (this.mTimeProvider != null) {
                try {
                    j = this.mTimeProvider.getCurrentTimeUs(false, true) / 1000;
                } catch (IllegalStateException e) {
                    j = -1;
                }
            }
            if (this.DEBUG) {
                Log.v(TAG, "mVisible=" + this.mVisible + ", " + cue.mStartTimeMs + " <= " + j + ", " + cue.mEndTimeMs + " >= " + this.mLastTimeMs);
            }
            if (!this.mVisible || cue.mStartTimeMs > j || cue.mEndTimeMs < this.mLastTimeMs) {
                if (this.mVisible && cue.mEndTimeMs >= this.mLastTimeMs && (cue.mStartTimeMs < this.mNextScheduledTimeMs || this.mNextScheduledTimeMs < 0)) {
                    scheduleTimedEvents();
                }
                z = false;
            } else {
                if (this.mRunnable != null) {
                    this.mHandler.removeCallbacks(this.mRunnable);
                }
                final long j2 = j;
                this.mRunnable = new Runnable() { // from class: android.media.SubtitleTrack.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (this) {
                            SubtitleTrack.this.mRunnable = null;
                            SubtitleTrack.this.updateActiveCues(true, j2);
                            SubtitleTrack.this.updateView(SubtitleTrack.this.mActiveCues);
                        }
                    }
                };
                if (this.mHandler.postDelayed(this.mRunnable, 10L)) {
                    z = true;
                    if (this.DEBUG) {
                        Log.v(TAG, "scheduling update");
                        z = true;
                    }
                } else {
                    z = true;
                    if (this.DEBUG) {
                        Log.w(TAG, "failed to schedule subtitle view update");
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    protected void clearActiveCues() {
        synchronized (this) {
            if (this.DEBUG) {
                Log.v(TAG, "Clearing " + this.mActiveCues.size() + " active cues");
            }
            this.mActiveCues.clear();
            this.mLastUpdateTimeMs = -1L;
        }
    }

    protected void finalize() throws Throwable {
        int size = this.mRunsByEndTime.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                super.finalize();
                return;
            } else {
                removeRunsByEndTimeIndex(i);
                size = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finishedRun(long j) {
        Run run;
        if (j == 0 || j == -1 || (run = this.mRunsByID.get(j)) == null) {
            return;
        }
        run.storeByEndTimeMs(this.mRunsByEndTime);
    }

    public final MediaFormat getFormat() {
        return this.mFormat;
    }

    public abstract RenderingWidget getRenderingWidget();

    public void hide() {
        if (this.mVisible) {
            if (this.mTimeProvider != null) {
                this.mTimeProvider.cancelNotifications(this);
            }
            RenderingWidget renderingWidget = getRenderingWidget();
            if (renderingWidget != null) {
                renderingWidget.setVisible(false);
            }
            this.mVisible = false;
        }
    }

    public boolean isTimedText() {
        return getRenderingWidget() == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onData(SubtitleData subtitleData) {
        long startTimeUs = subtitleData.getStartTimeUs() + 1;
        onData(subtitleData.getData(), true, startTimeUs);
        setRunDiscardTimeMs(startTimeUs, (subtitleData.getStartTimeUs() + subtitleData.getDurationUs()) / 1000);
    }

    public abstract void onData(byte[] bArr, boolean z, long j);

    @Override // android.media.MediaTimeProvider.OnMediaTimeListener
    public void onSeek(long j) {
        if (this.DEBUG) {
            Log.d(TAG, "onSeek " + j);
        }
        synchronized (this) {
            long j2 = j / 1000;
            updateActiveCues(true, j2);
            takeTime(j2);
        }
        updateView(this.mActiveCues);
        scheduleTimedEvents();
    }

    @Override // android.media.MediaTimeProvider.OnMediaTimeListener
    public void onStop() {
        synchronized (this) {
            if (this.DEBUG) {
                Log.d(TAG, "onStop");
            }
            clearActiveCues();
            this.mLastTimeMs = -1L;
        }
        updateView(this.mActiveCues);
        this.mNextScheduledTimeMs = -1L;
        this.mTimeProvider.notifyAt(-1L, this);
    }

    @Override // android.media.MediaTimeProvider.OnMediaTimeListener
    public void onTimedEvent(long j) {
        if (this.DEBUG) {
            Log.d(TAG, "onTimedEvent " + j);
        }
        synchronized (this) {
            long j2 = j / 1000;
            updateActiveCues(false, j2);
            takeTime(j2);
        }
        updateView(this.mActiveCues);
        scheduleTimedEvents();
    }

    protected void scheduleTimedEvents() {
        if (this.mTimeProvider != null) {
            this.mNextScheduledTimeMs = this.mCues.nextTimeAfter(this.mLastTimeMs);
            if (this.DEBUG) {
                Log.d(TAG, "sched @" + this.mNextScheduledTimeMs + " after " + this.mLastTimeMs);
            }
            this.mTimeProvider.notifyAt(this.mNextScheduledTimeMs >= 0 ? this.mNextScheduledTimeMs * 1000 : -1L, this);
        }
    }

    public void setRunDiscardTimeMs(long j, long j2) {
        Run run;
        if (j == 0 || j == -1 || (run = this.mRunsByID.get(j)) == null) {
            return;
        }
        run.mEndTimeMs = j2;
        run.storeByEndTimeMs(this.mRunsByEndTime);
    }

    public void setTimeProvider(MediaTimeProvider mediaTimeProvider) {
        synchronized (this) {
            if (this.mTimeProvider != mediaTimeProvider) {
                if (this.mTimeProvider != null) {
                    this.mTimeProvider.cancelNotifications(this);
                }
                this.mTimeProvider = mediaTimeProvider;
                if (this.mTimeProvider != null) {
                    this.mTimeProvider.scheduleUpdate(this);
                }
            }
        }
    }

    public void show() {
        if (this.mVisible) {
            return;
        }
        this.mVisible = true;
        RenderingWidget renderingWidget = getRenderingWidget();
        if (renderingWidget != null) {
            renderingWidget.setVisible(true);
        }
        if (this.mTimeProvider != null) {
            this.mTimeProvider.scheduleUpdate(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r6.mLastUpdateTimeMs > r8) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void updateActiveCues(boolean r7, long r8) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.SubtitleTrack.updateActiveCues(boolean, long):void");
    }

    public abstract void updateView(Vector<Cue> vector);
}
