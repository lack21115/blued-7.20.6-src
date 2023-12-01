package com.blued.android.module.live_china.zegoVideoCapture;

import android.content.Context;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/VideoFilterFactory.class */
public class VideoFilterFactory extends ZegoVideoFilterFactory {

    /* renamed from: a  reason: collision with root package name */
    private FilterType f15486a;
    private ZegoVideoFilter b = null;

    /* renamed from: c  reason: collision with root package name */
    private ISenseTimeProcessor f15487c;
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
        this.f15486a = FilterType.FilterType_SyncTexture;
        this.f15486a = filterType;
        this.f15487c = iSenseTimeProcessor;
    }

    public void a(Context context) {
        this.d = context;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory
    public ZegoVideoFilter create() {
        return new VideoFilterSurfaceTexture(this.d, this.f15487c);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory
    public void destroy(ZegoVideoFilter zegoVideoFilter) {
        this.b = null;
    }
}
