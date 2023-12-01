package com.tencent.liteav.videobase.utils;

import android.graphics.Bitmap;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/l.class */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f22973a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22974c;
    private final TakeSnapshotListener d;

    private l(ByteBuffer byteBuffer, int i, int i2, TakeSnapshotListener takeSnapshotListener) {
        this.f22973a = byteBuffer;
        this.b = i;
        this.f22974c = i2;
        this.d = takeSnapshotListener;
    }

    public static Runnable a(ByteBuffer byteBuffer, int i, int i2, TakeSnapshotListener takeSnapshotListener) {
        return new l(byteBuffer, i, i2, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteBuffer byteBuffer = this.f22973a;
        int i = this.b;
        int i2 = this.f22974c;
        TakeSnapshotListener takeSnapshotListener = this.d;
        byteBuffer.position(0);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        takeSnapshotListener.onComplete(createBitmap);
    }
}
