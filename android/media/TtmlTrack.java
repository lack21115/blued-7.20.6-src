package android.media;

import android.media.SubtitleTrack;
import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/media/TtmlTrack.class */
class TtmlTrack extends SubtitleTrack implements TtmlNodeListener {
    private static final String TAG = "TtmlTrack";
    private Long mCurrentRunID;
    private final TtmlParser mParser;
    private String mParsingData;
    private final TtmlRenderingWidget mRenderingWidget;
    private TtmlNode mRootNode;
    private final TreeSet<Long> mTimeEvents;
    private final LinkedList<TtmlNode> mTtmlNodes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TtmlTrack(TtmlRenderingWidget ttmlRenderingWidget, MediaFormat mediaFormat) {
        super(mediaFormat);
        this.mParser = new TtmlParser(this);
        this.mTtmlNodes = new LinkedList<>();
        this.mTimeEvents = new TreeSet<>();
        this.mRenderingWidget = ttmlRenderingWidget;
        this.mParsingData = "";
    }

    private void addTimeEvents(TtmlNode ttmlNode) {
        this.mTimeEvents.add(Long.valueOf(ttmlNode.mStartTimeMs));
        this.mTimeEvents.add(Long.valueOf(ttmlNode.mEndTimeMs));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ttmlNode.mChildren.size()) {
                return;
            }
            addTimeEvents(ttmlNode.mChildren.get(i2));
            i = i2 + 1;
        }
    }

    private List<TtmlNode> getActiveNodes(long j, long j2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTtmlNodes.size()) {
                return arrayList;
            }
            TtmlNode ttmlNode = this.mTtmlNodes.get(i2);
            if (ttmlNode.isActive(j, j2)) {
                arrayList.add(ttmlNode);
            }
            i = i2 + 1;
        }
    }

    public TtmlCue getNextResult() {
        while (this.mTimeEvents.size() >= 2) {
            long longValue = this.mTimeEvents.pollFirst().longValue();
            long longValue2 = this.mTimeEvents.first().longValue();
            if (!getActiveNodes(longValue, longValue2).isEmpty()) {
                return new TtmlCue(longValue, longValue2, TtmlUtils.applySpacePolicy(TtmlUtils.extractText(this.mRootNode, longValue, longValue2), false), TtmlUtils.extractTtmlFragment(this.mRootNode, longValue, longValue2));
            }
        }
        return null;
    }

    @Override // android.media.SubtitleTrack
    public TtmlRenderingWidget getRenderingWidget() {
        return this.mRenderingWidget;
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
                this.mParsingData += str;
                if (z) {
                    try {
                        this.mParser.parse(this.mParsingData, this.mCurrentRunID.longValue());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e2) {
                        e2.printStackTrace();
                    }
                    finishedRun(j);
                    this.mParsingData = "";
                    this.mCurrentRunID = null;
                }
            }
        } catch (UnsupportedEncodingException e3) {
            Log.w(TAG, "subtitle data is not UTF-8 encoded: " + e3);
        }
    }

    @Override // android.media.TtmlNodeListener
    public void onRootNodeParsed(TtmlNode ttmlNode) {
        this.mRootNode = ttmlNode;
        while (true) {
            TtmlCue nextResult = getNextResult();
            if (nextResult == null) {
                this.mRootNode = null;
                this.mTtmlNodes.clear();
                this.mTimeEvents.clear();
                return;
            }
            addCue(nextResult);
        }
    }

    @Override // android.media.TtmlNodeListener
    public void onTtmlNodeParsed(TtmlNode ttmlNode) {
        this.mTtmlNodes.addLast(ttmlNode);
        addTimeEvents(ttmlNode);
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
            this.mRenderingWidget.setActiveCues(vector);
        }
    }
}
