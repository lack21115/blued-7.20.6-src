package com.tencent.thumbplayer.adapter.a.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/b.class */
public class b extends MediaPlayer {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.media.MediaPlayer
    public void finalize() {
        try {
            super.finalize();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public int getCurrentPosition() {
        try {
            return super.getCurrentPosition();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public int getDuration() {
        try {
            return super.getDuration();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public int getSelectedTrack(int i) {
        try {
            return super.getSelectedTrack(i);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        try {
            return super.getTrackInfo();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
            return new MediaPlayer.TrackInfo[0];
        }
    }

    @Override // android.media.MediaPlayer
    public int getVideoHeight() {
        try {
            return super.getVideoHeight();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public int getVideoWidth() {
        try {
            return super.getVideoWidth();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public void prepare() {
        try {
            super.prepare();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void release() {
        try {
            if ("N1W".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || "X909T".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || "X909".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || "N1T".equalsIgnoreCase(TPSystemInfo.getDeviceName())) {
                super.setOnPreparedListener(null);
                super.setOnCompletionListener(null);
                super.setOnErrorListener(null);
                super.setOnInfoListener(null);
                super.setOnBufferingUpdateListener(null);
                super.setOnSeekCompleteListener(null);
                super.setOnVideoSizeChangedListener(null);
                ((Handler) super.getClass().getDeclaredField("mA2dpHandler").get(this)).removeCallbacksAndMessages(null);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
        try {
            super.release();
        } catch (Exception e2) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
        }
    }

    @Override // android.media.MediaPlayer
    public void reset() {
        try {
            super.reset();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri) {
        try {
            super.setDataSource(context, uri);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        try {
            super.setDataSource(context, uri, map);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        try {
            super.setDataSource(fileDescriptor);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            super.setDisplay(surfaceHolder);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void setLooping(boolean z) {
        try {
            super.setLooping(z);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    public void setPlaybackParams(PlaybackParams playbackParams) {
        try {
            super.setPlaybackParams(playbackParams);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void setSurface(Surface surface) {
        try {
            super.setSurface(surface);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void setVolume(float f, float f2) {
        try {
            super.setVolume(f, f2);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void stop() {
        try {
            super.stop();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e);
        }
    }
}
