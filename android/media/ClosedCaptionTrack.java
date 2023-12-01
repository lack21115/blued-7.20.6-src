package android.media;

import android.media.SubtitleTrack;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/media/ClosedCaptionTrack.class */
class ClosedCaptionTrack extends SubtitleTrack {
    private final CCParser mCCParser;
    private final ClosedCaptionWidget mRenderingWidget;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClosedCaptionTrack(ClosedCaptionWidget closedCaptionWidget, MediaFormat mediaFormat) {
        super(mediaFormat);
        this.mRenderingWidget = closedCaptionWidget;
        this.mCCParser = new CCParser(closedCaptionWidget);
    }

    @Override // android.media.SubtitleTrack
    public SubtitleTrack.RenderingWidget getRenderingWidget() {
        return this.mRenderingWidget;
    }

    @Override // android.media.SubtitleTrack
    public void onData(byte[] bArr, boolean z, long j) {
        this.mCCParser.parse(bArr);
    }

    @Override // android.media.SubtitleTrack
    public void updateView(Vector<SubtitleTrack.Cue> vector) {
    }
}
