package com.zego.zegoavkit2;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.zego.zegoavkit2.entities.VideoFrame;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayerCallbackBridge.class */
public final class ZegoMediaPlayerCallbackBridge {
    private static volatile HashMap<Integer, IZegoMediaPlayerWithIndexCallback> mEventWithIndexCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerVideoPlayWithIndexCallback> mVideoDataWithIndexCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerVideoPlayWithIndexCallback2> mVideoDataWithIndexCallback2Map = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerAudioPlayCallback> mAudioDataCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerMediaSideInfoCallback> mMediaSideInfoCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, ZegoMediaPlayerFileReader> mVideoMediaPlayerFileReaderMap = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerBlockDataCallback> mBlockDataCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, ByteBuffer> mVideoBuffers = new HashMap<>();

    public static void close(int i) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i));
        if (zegoMediaPlayerFileReader != null) {
            zegoMediaPlayerFileReader.close(i);
        }
    }

    public static int dequeueInputBuffer(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2 = mVideoDataWithIndexCallback2Map.get(Integer.valueOf(i3));
        if (iZegoMediaPlayerVideoPlayWithIndexCallback2 != null) {
            return iZegoMediaPlayerVideoPlayWithIndexCallback2.dequeueInputBuffer(i, i2, iArr, iArr2, i3);
        }
        return -1;
    }

    public static VideoFrame getInputBuffer(int i, int i2) {
        IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2 = mVideoDataWithIndexCallback2Map.get(Integer.valueOf(i2));
        if (iZegoMediaPlayerVideoPlayWithIndexCallback2 != null) {
            return iZegoMediaPlayerVideoPlayWithIndexCallback2.getInputBuffer(i, i2);
        }
        return null;
    }

    public static long getSize(int i) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i));
        if (zegoMediaPlayerFileReader != null) {
            return zegoMediaPlayerFileReader.getSize(i);
        }
        return 0L;
    }

    public static void onAudioBegin(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.7
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onAudioBegin(i);
                }
            }
        });
    }

    public static void onAudioDataCallback(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        IZegoMediaPlayerAudioPlayCallback iZegoMediaPlayerAudioPlayCallback = mAudioDataCallbackMap.get(Integer.valueOf(i4));
        if (iZegoMediaPlayerAudioPlayCallback != null) {
            iZegoMediaPlayerAudioPlayCallback.onPlayAudioData(byteBuffer, i, i2, i3, i4);
        }
    }

    public static void onBlockBegin(String str, int i) {
        IZegoMediaPlayerBlockDataCallback iZegoMediaPlayerBlockDataCallback = mBlockDataCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerBlockDataCallback != null) {
            iZegoMediaPlayerBlockDataCallback.OnBlockBegin(str, i);
        }
    }

    public static int onBlockData(ByteBuffer byteBuffer, int i) {
        IZegoMediaPlayerBlockDataCallback iZegoMediaPlayerBlockDataCallback = mBlockDataCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerBlockDataCallback != null) {
            return iZegoMediaPlayerBlockDataCallback.OnBlockData(byteBuffer, i);
        }
        return -1;
    }

    public static void onBufferBegin(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.9
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onBufferBegin(i);
                }
            }
        });
    }

    public static void onBufferEnd(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.10
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onBufferEnd(i);
                }
            }
        });
    }

    public static void onLoadComplete(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.11
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onLoadComplete(i);
                }
            }
        });
    }

    public static void onMediaSideInfoCallback(ByteBuffer byteBuffer, int i) {
        IZegoMediaPlayerMediaSideInfoCallback iZegoMediaPlayerMediaSideInfoCallback = mMediaSideInfoCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerMediaSideInfoCallback != null) {
            iZegoMediaPlayerMediaSideInfoCallback.onMediaSideInfo(byteBuffer, i);
        }
    }

    public static void onPlayEnd(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.8
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayEnd(i);
                }
            }
        });
    }

    public static void onPlayError(final int i, final int i2) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i2));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.5
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayError(i, i2);
                }
            }
        });
    }

    public static void onPlayPause(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.2
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayPause(i);
                }
            }
        });
    }

    public static void onPlayResume(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.4
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayResume(i);
                }
            }
        });
    }

    public static void onPlayStart(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.1
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayStart(i);
                }
            }
        });
    }

    public static void onPlayStop(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.3
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayStop(i);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (r10.capacity() < r7) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void onPlayVideoData(java.nio.ByteBuffer r6, int r7, com.zego.zegoavkit2.ZegoVideoDataFormat r8, int r9) {
        /*
            java.util.HashMap<java.lang.Integer, com.zego.zegoavkit2.IZegoMediaPlayerVideoPlayWithIndexCallback> r0 = com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.mVideoDataWithIndexCallbackMap
            r1 = r9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            com.zego.zegoavkit2.IZegoMediaPlayerVideoPlayWithIndexCallback r0 = (com.zego.zegoavkit2.IZegoMediaPlayerVideoPlayWithIndexCallback) r0
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L7a
            r0 = 0
            r10 = r0
            java.util.HashMap<java.lang.Integer, java.nio.ByteBuffer> r0 = com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.mVideoBuffers
            r1 = r9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L33
            java.util.HashMap<java.lang.Integer, java.nio.ByteBuffer> r0 = com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.mVideoBuffers
            r1 = r9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
            r10 = r0
        L33:
            r0 = r10
            if (r0 == 0) goto L45
            r0 = r10
            r11 = r0
            r0 = r10
            int r0 = r0.capacity()
            r1 = r7
            if (r0 >= r1) goto L58
        L45:
            r0 = r7
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocateDirect(r0)
            r11 = r0
            java.util.HashMap<java.lang.Integer, java.nio.ByteBuffer> r0 = com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.mVideoBuffers
            r1 = r9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r11
            java.lang.Object r0 = r0.put(r1, r2)
        L58:
            r0 = r11
            java.nio.Buffer r0 = r0.clear()
            r0 = r11
            r1 = r6
            java.nio.ByteBuffer r0 = r0.put(r1)
            r0 = r11
            java.nio.Buffer r0 = r0.flip()
            r0 = r12
            r1 = r11
            byte[] r1 = r1.array()
            r2 = r7
            r3 = r8
            r4 = r9
            r0.onPlayVideoData(r1, r2, r3, r4)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.onPlayVideoData(java.nio.ByteBuffer, int, com.zego.zegoavkit2.ZegoVideoDataFormat, int):void");
    }

    public static void onProcessInterval(long j, int i) {
        IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null || iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        iZegoMediaPlayerWithIndexCallback.onProcessInterval(j, i);
    }

    public static void onReadEOF(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.14
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onReadEOF(i);
                }
            }
        });
    }

    public static void onSeekComplete(final int i, final long j, final int i2) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i2));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.12
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onSeekComplete(i, j, i2);
                }
            }
        });
    }

    public static void onSnapshot(Bitmap bitmap, final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        }
        final Bitmap bitmap3 = bitmap2;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.13
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onSnapshot(bitmap3, i);
                }
            }
        });
    }

    public static void onVideoBegin(final int i) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.6
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onVideoBegin(i);
                }
            }
        });
    }

    public static int open(String str, int i) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i));
        if (zegoMediaPlayerFileReader != null) {
            return zegoMediaPlayerFileReader.open(str, i);
        }
        return -1;
    }

    public static void queueInputBuffer(int i, ZegoVideoDataFormat zegoVideoDataFormat, int i2) {
        IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2 = mVideoDataWithIndexCallback2Map.get(Integer.valueOf(i2));
        if (iZegoMediaPlayerVideoPlayWithIndexCallback2 != null) {
            iZegoMediaPlayerVideoPlayWithIndexCallback2.queueInputBuffer(i, zegoVideoDataFormat, i2);
        }
    }

    public static ByteBuffer read(int i, int i2) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i2));
        if (zegoMediaPlayerFileReader != null) {
            return zegoMediaPlayerFileReader.read(i, i2);
        }
        return null;
    }

    public static void removeVideoDataBuffer(int i) {
        if (mVideoBuffers.containsKey(Integer.valueOf(i))) {
            mVideoBuffers.remove(Integer.valueOf(i));
        }
    }

    public static long seek(long j, int i, int i2) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i2));
        if (zegoMediaPlayerFileReader != null) {
            return zegoMediaPlayerFileReader.seek(j, i, i2);
        }
        return -1L;
    }

    public static void setAudioDataCallback(IZegoMediaPlayerAudioPlayCallback iZegoMediaPlayerAudioPlayCallback, int i) {
        mAudioDataCallbackMap.put(Integer.valueOf(i), iZegoMediaPlayerAudioPlayCallback);
    }

    public static void setBlockDataCallback(IZegoMediaPlayerBlockDataCallback iZegoMediaPlayerBlockDataCallback, int i) {
        mBlockDataCallbackMap.put(Integer.valueOf(i), iZegoMediaPlayerBlockDataCallback);
    }

    public static void setEventWithIndexCallback(IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback, int i) {
        mEventWithIndexCallbackMap.put(Integer.valueOf(i), iZegoMediaPlayerWithIndexCallback);
    }

    public static void setMediaPlayerFileReader(ZegoMediaPlayerFileReader zegoMediaPlayerFileReader, int i) {
        mVideoMediaPlayerFileReaderMap.put(Integer.valueOf(i), zegoMediaPlayerFileReader);
    }

    public static void setMediaSideInfoCallback(IZegoMediaPlayerMediaSideInfoCallback iZegoMediaPlayerMediaSideInfoCallback, int i) {
        mMediaSideInfoCallbackMap.put(Integer.valueOf(i), iZegoMediaPlayerMediaSideInfoCallback);
    }

    public static void setVideoDataWithIndexCallback(IZegoMediaPlayerVideoPlayWithIndexCallback iZegoMediaPlayerVideoPlayWithIndexCallback, int i) {
        mVideoDataWithIndexCallbackMap.put(Integer.valueOf(i), iZegoMediaPlayerVideoPlayWithIndexCallback);
    }

    public static void setVideoDataWithIndexCallback2(IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2, int i) {
        mVideoDataWithIndexCallback2Map.put(Integer.valueOf(i), iZegoMediaPlayerVideoPlayWithIndexCallback2);
    }
}
