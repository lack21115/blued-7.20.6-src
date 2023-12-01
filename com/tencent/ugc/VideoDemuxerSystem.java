package com.tencent.ugc;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/VideoDemuxerSystem.class */
public class VideoDemuxerSystem implements VideoDemuxer {
    MediaExtractorWrapper mMediaExtractorWrapper;

    @Override // com.tencent.ugc.VideoDemuxer
    public void close() {
        MediaExtractorWrapper mediaExtractorWrapper = this.mMediaExtractorWrapper;
        if (mediaExtractorWrapper != null) {
            mediaExtractorWrapper.release();
        }
        this.mMediaExtractorWrapper = null;
    }

    @Override // com.tencent.ugc.VideoDemuxer
    public EncodedVideoFrame getNextEncodeVideoFrame() {
        MediaExtractorWrapper mediaExtractorWrapper = this.mMediaExtractorWrapper;
        return mediaExtractorWrapper != null ? mediaExtractorWrapper.readVideoSampleData() : VideoDemuxer.END_OF_STREAM;
    }

    @Override // com.tencent.ugc.VideoDemuxer
    public boolean open(String str) {
        MediaExtractorWrapper mediaExtractorWrapper = new MediaExtractorWrapper();
        this.mMediaExtractorWrapper = mediaExtractorWrapper;
        return mediaExtractorWrapper.setDataSource(str);
    }

    @Override // com.tencent.ugc.VideoDemuxer
    public boolean seek(long j) {
        MediaExtractorWrapper mediaExtractorWrapper = this.mMediaExtractorWrapper;
        if (mediaExtractorWrapper != null) {
            mediaExtractorWrapper.seekVideo(j);
            return true;
        }
        return true;
    }
}
