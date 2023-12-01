package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.TXVideoInfoReader;
import com.tencent.ugc.common.MediaExtractorBuilder;
import com.tencent.ugc.common.MediaRetrieverBuilder;
import com.tencent.ugc.retriver.FFmpegMediaRetriever;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoInfoReader.class */
public class TXVideoInfoReader {
    private static final int RETRY_MAX_COUNT = 3;
    private static TXVideoInfoReader sInstance;
    private Context mContext;
    private int mCount;
    private a mGenerateImageThread;
    private volatile WeakReference<OnSampleProgrocess> mListener;
    private final String TAG = "TXVideoInfoReader";
    private final AtomicInteger mRetryTimes = new AtomicInteger(0);
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoInfoReader$OnSampleProgrocess.class */
    public interface OnSampleProgrocess {
        void sampleProcess(int i, Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoInfoReader$a.class */
    public final class a extends Thread {
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private volatile Bitmap f40199c;
        private final int d;

        public a(String str) {
            this.d = TXVideoInfoReader.this.mListener.hashCode();
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(a aVar, String str) {
            TXVideoInfoReader tXVideoInfoReader = TXVideoInfoReader.this;
            tXVideoInfoReader.getSampleImages(tXVideoInfoReader.mCount, str, (OnSampleProgrocess) TXVideoInfoReader.this.mListener.get());
            TXVideoInfoReader.this.mRetryTimes.getAndIncrement();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            final OnSampleProgrocess onSampleProgrocess;
            MediaMetadataRetriever build = new MediaRetrieverBuilder().setPath(this.b).build();
            long videoDurationMs = new FFmpegMediaRetriever().getVideoDurationMs() * 1000;
            long j = videoDurationMs / TXVideoInfoReader.this.mCount;
            LiteavLog.i("TXVideoInfoReader", "run duration = " + videoDurationMs + " count = " + TXVideoInfoReader.this.mCount);
            int i = 0;
            while (true) {
                final int i2 = i;
                if (i2 >= TXVideoInfoReader.this.mCount || Thread.currentThread().isInterrupted()) {
                    break;
                }
                long j2 = i2 * j;
                long j3 = j2;
                if (j2 > videoDurationMs) {
                    j3 = videoDurationMs;
                }
                Bitmap frameAtTime = build.getFrameAtTime(j3);
                Bitmap bitmap = frameAtTime;
                if (frameAtTime == null) {
                    LiteavLog.w("TXVideoInfoReader", "getSampleImages failed!");
                    if (i2 == 0) {
                        final String str = this.b;
                        if (TXVideoInfoReader.this.mRetryTimes.get() < 3) {
                            LiteavLog.i("TXVideoInfoReader", "retry to get sample images");
                            TXVideoInfoReader.this.mMainHandler.post(new Runnable(this, str) { // from class: com.tencent.ugc.bq

                                /* renamed from: a  reason: collision with root package name */
                                private final TXVideoInfoReader.a f40269a;
                                private final String b;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.f40269a = this;
                                    this.b = str;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    TXVideoInfoReader.a.a(this.f40269a, this.b);
                                }
                            });
                        }
                    } else {
                        bitmap = null;
                        if (this.f40199c != null) {
                            bitmap = null;
                            if (!this.f40199c.isRecycled()) {
                                LiteavLog.i("TXVideoInfoReader", "copy last image");
                                bitmap = this.f40199c.copy(this.f40199c.getConfig(), true);
                            }
                        }
                    }
                }
                this.f40199c = bitmap;
                TXVideoInfoReader.this.mRetryTimes.set(0);
                if (TXVideoInfoReader.this.mListener != null && TXVideoInfoReader.this.mCount > 0 && TXVideoInfoReader.this.mListener.hashCode() == this.d && (onSampleProgrocess = (OnSampleProgrocess) TXVideoInfoReader.this.mListener.get()) != null) {
                    final Bitmap bitmap2 = bitmap;
                    TXVideoInfoReader.this.mMainHandler.post(new Runnable(onSampleProgrocess, i2, bitmap2) { // from class: com.tencent.ugc.bp

                        /* renamed from: a  reason: collision with root package name */
                        private final TXVideoInfoReader.OnSampleProgrocess f40267a;
                        private final int b;

                        /* renamed from: c  reason: collision with root package name */
                        private final Bitmap f40268c;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f40267a = onSampleProgrocess;
                            this.b = i2;
                            this.f40268c = bitmap2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f40267a.sampleProcess(this.b, this.f40268c);
                        }
                    });
                }
                i = i2 + 1;
            }
            this.f40199c = null;
            build.release();
        }
    }

    private TXVideoInfoReader() {
    }

    private TXVideoInfoReader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void cancelThread() {
        a aVar = this.mGenerateImageThread;
        if (aVar == null || !aVar.isAlive() || this.mGenerateImageThread.isInterrupted()) {
            return;
        }
        LiteavLog.i("TXVideoInfoReader", "cancelThread: thread cancel");
        this.mGenerateImageThread.interrupt();
        this.mGenerateImageThread = null;
    }

    private long getContentUrlFileSize(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Uri parse = Uri.parse(str);
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        try {
            if (this.mContext == null) {
                com.tencent.liteav.base.util.g.a((Closeable) null);
                com.tencent.liteav.base.util.g.a((Closeable) null);
                return 0L;
            }
            ParcelFileDescriptor openFileDescriptor = this.mContext.getContentResolver().openFileDescriptor(parse, "r");
            try {
                fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    long available = fileInputStream2.available();
                    com.tencent.liteav.base.util.g.a(openFileDescriptor);
                    com.tencent.liteav.base.util.g.a(fileInputStream2);
                    return available;
                } catch (Exception e) {
                    parcelFileDescriptor2 = openFileDescriptor;
                    try {
                        LiteavLog.e("TXVideoInfoReader", "getVideoFileInfo  not found , uri = ".concat(String.valueOf(parse)));
                        com.tencent.liteav.base.util.g.a(parcelFileDescriptor2);
                        com.tencent.liteav.base.util.g.a(fileInputStream2);
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        parcelFileDescriptor = parcelFileDescriptor2;
                        com.tencent.liteav.base.util.g.a(parcelFileDescriptor);
                        com.tencent.liteav.base.util.g.a(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    parcelFileDescriptor = openFileDescriptor;
                    th = th;
                    com.tencent.liteav.base.util.g.a(parcelFileDescriptor);
                    com.tencent.liteav.base.util.g.a(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (Exception e3) {
            fileInputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    @Deprecated
    public static TXVideoInfoReader getInstance() {
        if (sInstance == null) {
            sInstance = new TXVideoInfoReader();
        }
        return sInstance;
    }

    public static TXVideoInfoReader getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TXVideoInfoReader(context);
        }
        return sInstance;
    }

    public void cancel() {
        LiteavLog.i("TXVideoInfoReader", com.anythink.expressad.d.a.b.dO);
        cancelThread();
        this.mMainHandler.removeCallbacksAndMessages(null);
        if (this.mListener != null) {
            this.mListener.clear();
            this.mListener = null;
        }
    }

    public Bitmap getSampleImage(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.w("TXVideoInfoReader", "videoPath is null");
            return null;
        } else if (!new File(str).exists()) {
            LiteavLog.w("TXVideoInfoReader", "videoPath is not exist");
            return null;
        } else {
            FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever();
            fFmpegMediaRetriever.setDataSource(str);
            long videoDurationMs = fFmpegMediaRetriever.getVideoDurationMs() * 1000;
            long j2 = j * 1000;
            long j3 = j2;
            if (j2 > videoDurationMs) {
                j3 = videoDurationMs;
            }
            if (videoDurationMs <= 0) {
                LiteavLog.w("TXVideoInfoReader", "video duration is 0");
                return null;
            }
            Bitmap frameAtTime = new MediaRetrieverBuilder().setPath(str).build().getFrameAtTime(j3);
            if (frameAtTime == null) {
                LiteavLog.e("TXVideoInfoReader", "getSampleImages failed!");
                return frameAtTime;
            }
            LiteavLog.i("TXVideoInfoReader", "getSampleImages bmp= " + frameAtTime + ",time= " + j3 + ",duration= " + videoDurationMs);
            return frameAtTime;
        }
    }

    public void getSampleImages(int i, String str, OnSampleProgrocess onSampleProgrocess) {
        this.mCount = i;
        this.mListener = new WeakReference<>(onSampleProgrocess);
        if (TextUtils.isEmpty(str)) {
            LiteavLog.w("TXVideoInfoReader", "getSampleImages: videoPath is empty.");
        } else if (!com.tencent.liteav.base.util.g.a(str)) {
            LiteavLog.w("TXVideoInfoReader", "getSampleImages: file is not exist.");
        } else {
            cancelThread();
            a aVar = new a(str);
            this.mGenerateImageThread = aVar;
            aVar.start();
            LiteavLog.i("TXVideoInfoReader", "getSampleImages: thread start");
        }
    }

    public TXVideoEditConstants.TXVideoInfo getVideoFileInfo(String str) {
        LiteavLog.i("TXVideoInfoReader", "videoSource:".concat(String.valueOf(str)));
        if (LiteavSystemInfo.getSystemOSVersionInt() < 18) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e("TXVideoInfoReader", "videoSource is empty!!");
            return null;
        }
        if (!MediaExtractorBuilder.isContentUri(str)) {
            File file = new File(str);
            if (!file.exists() || !file.canRead()) {
                LiteavLog.e("TXVideoInfoReader", "getVideoFileInfo  file exist = " + file.exists() + " can read = " + file.canRead());
                return null;
            }
        }
        TXVideoEditConstants.TXVideoInfo tXVideoInfo = new TXVideoEditConstants.TXVideoInfo();
        FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever();
        fFmpegMediaRetriever.setDataSource(str);
        tXVideoInfo.duration = fFmpegMediaRetriever.getVideoDurationMs();
        LiteavLog.i("TXVideoInfoReader", "getVideoFileInfo: duration = " + tXVideoInfo.duration);
        tXVideoInfo.coverImage = new MediaRetrieverBuilder().setPath(str).build().getFrameAtTime();
        tXVideoInfo.fps = fFmpegMediaRetriever.getFPS();
        tXVideoInfo.bitrate = (int) (fFmpegMediaRetriever.getVideoBitrate() / 1024);
        tXVideoInfo.audioSampleRate = fFmpegMediaRetriever.getSampleRate();
        int rotation = fFmpegMediaRetriever.getRotation();
        LiteavLog.i("TXVideoInfoReader", "rotation: ".concat(String.valueOf(rotation)));
        if (rotation == 90 || rotation == 270) {
            tXVideoInfo.width = fFmpegMediaRetriever.getVideoHeight();
            tXVideoInfo.height = fFmpegMediaRetriever.getVideoWidth();
        } else {
            tXVideoInfo.width = fFmpegMediaRetriever.getVideoWidth();
            tXVideoInfo.height = fFmpegMediaRetriever.getVideoHeight();
        }
        if (MediaExtractorBuilder.isContentUri(str)) {
            tXVideoInfo.fileSize = getContentUrlFileSize(str);
            return tXVideoInfo;
        }
        tXVideoInfo.fileSize = new File(str).length();
        return tXVideoInfo;
    }
}
