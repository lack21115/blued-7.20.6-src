package android.media;

import android.content.Context;
import android.media.SubtitleController;
import android.os.Handler;

/* loaded from: source-9557208-dex2jar.jar:android/media/SRTRenderer.class */
public class SRTRenderer extends SubtitleController.Renderer {
    private final Context mContext;
    private final Handler mEventHandler;
    private final boolean mRender;
    private WebVttRenderingWidget mRenderingWidget;

    public SRTRenderer(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SRTRenderer(Context context, Handler handler) {
        this.mContext = context;
        this.mRender = handler == null;
        this.mEventHandler = handler;
    }

    @Override // android.media.SubtitleController.Renderer
    public SubtitleTrack createTrack(MediaFormat mediaFormat) {
        if (this.mRender && this.mRenderingWidget == null) {
            this.mRenderingWidget = new WebVttRenderingWidget(this.mContext);
        }
        return this.mRender ? new SRTTrack(this.mRenderingWidget, mediaFormat) : new SRTTrack(this.mEventHandler, mediaFormat);
    }

    @Override // android.media.SubtitleController.Renderer
    public boolean supports(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey(MediaFormat.KEY_MIME) && mediaFormat.getString(MediaFormat.KEY_MIME).equals("application/x-subrip")) {
            return this.mRender == (mediaFormat.getInteger(MediaFormat.KEY_IS_TIMED_TEXT, 0) == 0);
        }
        return false;
    }
}
