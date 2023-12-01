package android.media;

import android.content.Context;
import android.media.SubtitleController;

/* loaded from: source-9557208-dex2jar.jar:android/media/ClosedCaptionRenderer.class */
public class ClosedCaptionRenderer extends SubtitleController.Renderer {
    private final Context mContext;
    private ClosedCaptionWidget mRenderingWidget;

    public ClosedCaptionRenderer(Context context) {
        this.mContext = context;
    }

    @Override // android.media.SubtitleController.Renderer
    public SubtitleTrack createTrack(MediaFormat mediaFormat) {
        if (this.mRenderingWidget == null) {
            this.mRenderingWidget = new ClosedCaptionWidget(this.mContext);
        }
        return new ClosedCaptionTrack(this.mRenderingWidget, mediaFormat);
    }

    @Override // android.media.SubtitleController.Renderer
    public boolean supports(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey(MediaFormat.KEY_MIME)) {
            return mediaFormat.getString(MediaFormat.KEY_MIME).equals("text/cea-608");
        }
        return false;
    }
}
