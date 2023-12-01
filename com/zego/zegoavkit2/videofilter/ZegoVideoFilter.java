package com.zego.zegoavkit2.videofilter;

import android.graphics.SurfaceTexture;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videofilter/ZegoVideoFilter.class */
public abstract class ZegoVideoFilter {
    public static final int BUFFER_TYPE_ASYNC_I420_MEM = 64;
    public static final int BUFFER_TYPE_ASYNC_PIXEL_BUFFER = 2;
    public static final int BUFFER_TYPE_HYBRID_MEM_GL_TEXTURE_2D = 16;
    public static final int BUFFER_TYPE_MEM = 1;
    public static final int BUFFER_TYPE_SURFACE_TEXTURE = 8;
    public static final int BUFFER_TYPE_SYNC_GL_TEXTURE_2D = 32;
    public static final int BUFFER_TYPE_SYNC_PIXEL_BUFFER = 4;
    public static final int BUFFER_TYPE_UNKNOWN = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videofilter/ZegoVideoFilter$Client.class */
    public interface Client {
        int dequeueInputBuffer(int i, int i2, int i3);

        void destroy();

        ByteBuffer getInputBuffer(int i);

        SurfaceTexture getSurfaceTexture();

        void onProcessCallback(int i, int i2, int i3, long j);

        void queueInputBuffer(int i, int i2, int i3, int i4, long j);
    }

    protected abstract void allocateAndStart(Client client);

    protected abstract int dequeueInputBuffer(int i, int i2, int i3);

    protected abstract ByteBuffer getInputBuffer(int i);

    protected abstract SurfaceTexture getSurfaceTexture();

    protected abstract void onProcessCallback(int i, int i2, int i3, long j);

    protected abstract void queueInputBuffer(int i, int i2, int i3, int i4, long j);

    protected abstract void stopAndDeAllocate();

    protected abstract int supportBufferType();
}
