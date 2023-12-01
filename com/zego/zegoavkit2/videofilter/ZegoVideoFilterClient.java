package com.zego.zegoavkit2.videofilter;

import android.graphics.SurfaceTexture;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videofilter/ZegoVideoFilterClient.class */
public class ZegoVideoFilterClient implements ZegoVideoFilter.Client {
    private long pthis = 0;

    private static native int dequeue_input_buffer(long j, int i, int i2, int i3);

    private static native void destroy(long j);

    private static native ByteBuffer get_input_buffer(long j, int i);

    private static native SurfaceTexture get_surface_texture(long j);

    private static native void on_process_callback(long j, int i, int i2, int i3, long j2);

    private static native void queue_input_buffer(long j, int i, int i2, int i3, int i4, long j2);

    private int setThis(long j) {
        this.pthis = j;
        return 0;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public int dequeueInputBuffer(int i, int i2, int i3) {
        return dequeue_input_buffer(this.pthis, i, i2, i3);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public void destroy() {
        destroy(this.pthis);
        this.pthis = 0L;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public ByteBuffer getInputBuffer(int i) {
        return get_input_buffer(this.pthis, i);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public SurfaceTexture getSurfaceTexture() {
        return get_surface_texture(this.pthis);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public void onProcessCallback(int i, int i2, int i3, long j) {
        on_process_callback(this.pthis, i, i2, i3, j);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public void queueInputBuffer(int i, int i2, int i3, int i4, long j) {
        queue_input_buffer(this.pthis, i, i2, i3, i4, j);
    }
}
