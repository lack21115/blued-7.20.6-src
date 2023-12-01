package com.blued.android.module.live_china.zegoVideoCapture;

import android.content.Context;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/VideoFilterFactory.class */
public class VideoFilterFactory extends ZegoVideoFilterFactory {
    private FilterType a;
    private ZegoVideoFilter b = null;
    private ISenseTimeProcessor c;
    private Context d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/VideoFilterFactory$FilterType.class */
    public enum FilterType {
        FilterType_SyncTexture,
        FilterType_HybridMem,
        FilterType_Mem,
        FilterType_ASYNCI420Mem,
        FilterType_SurfaceTexture
    }

    public VideoFilterFactory(FilterType filterType, ISenseTimeProcessor iSenseTimeProcessor) {
        this.a = FilterType.FilterType_SyncTexture;
        this.a = filterType;
        this.c = iSenseTimeProcessor;
    }

    public void a(Context context) {
        this.d = context;
    }

    public ZegoVideoFilter create() {
        return new VideoFilterSurfaceTexture(this.d, this.c);
    }

    public void destroy(ZegoVideoFilter zegoVideoFilter) {
        this.b = null;
    }
}
