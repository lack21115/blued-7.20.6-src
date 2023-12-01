package android.media;

import android.content.Context;
import android.media.SubtitleController;

/* loaded from: source-9557208-dex2jar.jar:android/media/TtmlRenderer.class */
public class TtmlRenderer extends SubtitleController.Renderer {
    private static final String MEDIA_MIMETYPE_TEXT_TTML = "application/ttml+xml";
    private final Context mContext;
    private TtmlRenderingWidget mRenderingWidget;

    public TtmlRenderer(Context context) {
        this.mContext = context;
    }

    @Override // android.media.SubtitleController.Renderer
    public SubtitleTrack createTrack(MediaFormat mediaFormat) {
        if (this.mRenderingWidget == null) {
            this.mRenderingWidget = new TtmlRenderingWidget(this.mContext);
        }
        return new TtmlTrack(this.mRenderingWidget, mediaFormat);
    }

    @Override // android.media.SubtitleController.Renderer
    public boolean supports(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey(MediaFormat.KEY_MIME)) {
            return mediaFormat.getString(MediaFormat.KEY_MIME).equals("application/ttml+xml");
        }
        return false;
    }
}
