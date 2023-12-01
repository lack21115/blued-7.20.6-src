package com.zego.zegoavkit2.videofilter;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videofilter/ZegoDefaultVideoFilterFactory.class */
public class ZegoDefaultVideoFilterFactory extends ZegoVideoFilterFactory {
    public static final ZegoDefaultVideoFilterFactory sFactory = new ZegoDefaultVideoFilterFactory();
    private ZegoVideoFilter mVideoFilter;

    private ZegoDefaultVideoFilterFactory() {
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory
    protected ZegoVideoFilter create() {
        return this.mVideoFilter;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory
    protected void destroy(ZegoVideoFilter zegoVideoFilter) {
        if (zegoVideoFilter == null || !zegoVideoFilter.equals(this.mVideoFilter)) {
            return;
        }
        this.mVideoFilter = null;
    }

    public ZegoVideoFilter getZegoVideoFilter() {
        return this.mVideoFilter;
    }

    public void setZegoVideoFilter(ZegoVideoFilter zegoVideoFilter) {
        this.mVideoFilter = zegoVideoFilter;
    }
}
