package com.sobot.chat.camera;

import android.content.Context;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.camera.StProgressViewUpdateHelper;
import com.sobot.chat.camera.listener.StVideoListener;
import com.sobot.chat.camera.util.AudioUtil;
import com.sobot.chat.camera.util.ScreenUtils;
import com.sobot.chat.camera.util.StCmeraLog;
import com.sobot.chat.utils.ResourceUtils;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/StVideoView.class */
public class StVideoView extends FrameLayout implements MediaPlayer.OnCompletionListener, SurfaceHolder.Callback, View.OnClickListener, StProgressViewUpdateHelper.Callback {
    private ImageButton ib_playBtn;
    private int layout_width;
    private ImageView mBack;
    private String mFirstFrameUrl;
    private MediaPlayer mMediaPlayer;
    private StProgressViewUpdateHelper mUpdateHelper;
    private StVideoListener mVideoListener;
    private String mVideoUrl;
    private VideoView mVideoView;
    private StPlayPauseDrawable playPauseDrawable;
    private TextView st_currentTime;
    private LinearLayout st_progress_container;
    private SeekBar st_seekbar;
    private TextView st_totalTime;

    public StVideoView(Context context) {
        this(context, null);
    }

    public StVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVideoUrl = "";
        initAttrs();
        initData();
        initView();
    }

    private void initAttrs() {
    }

    private void initData() {
        this.layout_width = ScreenUtils.getScreenWidth(getContext());
    }

    private void initView() {
        setWillNotDraw(false);
        View inflate = LayoutInflater.from(getContext()).inflate(ResourceUtils.getIdByName(getContext(), "layout", "sobot_video_view"), this);
        this.mVideoView = (VideoView) inflate.findViewById(ResourceUtils.getResId(getContext(), "video_preview"));
        this.mBack = (ImageView) inflate.findViewById(ResourceUtils.getResId(getContext(), "iv_back"));
        this.ib_playBtn = (ImageButton) inflate.findViewById(ResourceUtils.getResId(getContext(), "ib_playBtn"));
        this.st_currentTime = (TextView) inflate.findViewById(ResourceUtils.getResId(getContext(), "st_currentTime"));
        this.st_totalTime = (TextView) inflate.findViewById(ResourceUtils.getResId(getContext(), "st_totalTime"));
        this.st_seekbar = (SeekBar) inflate.findViewById(ResourceUtils.getResId(getContext(), "st_seekbar"));
        this.st_progress_container = (LinearLayout) inflate.findViewById(ResourceUtils.getResId(getContext(), "st_progress_container"));
        StPlayPauseDrawable stPlayPauseDrawable = new StPlayPauseDrawable(getContext());
        this.playPauseDrawable = stPlayPauseDrawable;
        this.ib_playBtn.setImageDrawable(stPlayPauseDrawable);
        this.ib_playBtn.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        this.mVideoView.getHolder().addCallback(this);
        setOnClickListener(this);
        this.mBack.setOnClickListener(this);
        this.ib_playBtn.setOnClickListener(this);
    }

    private void postError() {
        StVideoListener stVideoListener = this.mVideoListener;
        if (stVideoListener != null) {
            stVideoListener.onError();
        }
    }

    private void postStart() {
        StVideoListener stVideoListener = this.mVideoListener;
        if (stVideoListener != null) {
            stVideoListener.onStart();
        }
    }

    private void releaseUpdateHelper() {
        stopUpdateHelper();
        this.mUpdateHelper = null;
    }

    private void startUpdateHelper() {
        if (this.mUpdateHelper == null) {
            this.mUpdateHelper = new StProgressViewUpdateHelper(this.mMediaPlayer, getContext(), this);
        }
        this.mUpdateHelper.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            postStart();
            startUpdateHelper();
        }
    }

    private void stopUpdateHelper() {
        StProgressViewUpdateHelper stProgressViewUpdateHelper = this.mUpdateHelper;
        if (stProgressViewUpdateHelper != null) {
            stProgressViewUpdateHelper.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoViewSize(float f, float f2) {
        if (f > f2) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ((f2 / f) * getWidth()));
            layoutParams.gravity = 17;
            this.mVideoView.setLayoutParams(layoutParams);
        }
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StVideoListener stVideoListener;
        Tracker.onClick(view);
        if (view == this) {
            StCmeraLog.i("dd");
            if (this.mBack.getVisibility() == 8) {
                this.mBack.setVisibility(0);
                this.st_progress_container.setVisibility(0);
            } else {
                this.mBack.setVisibility(8);
                this.st_progress_container.setVisibility(8);
            }
        }
        if (this.mBack == view && (stVideoListener = this.mVideoListener) != null) {
            stVideoListener.onCancel();
        }
        if (this.ib_playBtn == view) {
            switchVideoPlay(!isPlaying());
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.playPauseDrawable.setPlay(true);
        StVideoListener stVideoListener = this.mVideoListener;
        if (stVideoListener != null) {
            stVideoListener.onEnd();
        }
        this.st_seekbar.setProgress(0);
    }

    public void onPause() {
        stopUpdateHelper();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void onResume() {
        startVideo();
    }

    @Override // com.sobot.chat.camera.StProgressViewUpdateHelper.Callback
    public void onUpdateProgressViews(int i, int i2) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.st_seekbar.setMax(i2);
        this.st_seekbar.setProgress(i);
        this.st_totalTime.setText(AudioUtil.getReadableDurationString(i2));
        this.st_currentTime.setText(AudioUtil.getReadableDurationString(i));
    }

    public void playVideo() {
        if (TextUtils.isEmpty(this.mVideoUrl)) {
            postError();
            return;
        }
        File file = new File(this.mVideoUrl);
        if (!file.exists() || !file.isFile()) {
            postError();
            return;
        }
        try {
            Surface surface = this.mVideoView.getHolder().getSurface();
            StCmeraLog.i("surface.isValid():" + surface.isValid());
            if (surface.isValid()) {
                if (this.mMediaPlayer == null) {
                    this.mMediaPlayer = new MediaPlayer();
                } else {
                    this.mMediaPlayer.reset();
                }
                this.mMediaPlayer.setDataSource(this.mVideoUrl);
                this.mMediaPlayer.setSurface(surface);
                if (Build.VERSION.SDK_INT >= 16) {
                    this.mMediaPlayer.setVideoScalingMode(1);
                }
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.sobot.chat.camera.StVideoView.1
                    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                        StVideoView stVideoView = StVideoView.this;
                        stVideoView.updateVideoViewSize(stVideoView.mMediaPlayer.getVideoWidth(), StVideoView.this.mMediaPlayer.getVideoHeight());
                    }
                });
                this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.sobot.chat.camera.StVideoView.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        StVideoView.this.startVideo();
                    }
                });
                this.mMediaPlayer.setLooping(false);
                this.mMediaPlayer.prepareAsync();
                this.mMediaPlayer.setOnCompletionListener(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            postError();
        }
    }

    public void releaseMediaPlayer() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        releaseUpdateHelper();
    }

    public void setVideoLisenter(StVideoListener stVideoListener) {
        this.mVideoListener = stVideoListener;
    }

    public void setVideoPath(String str) {
        this.mVideoUrl = str;
    }

    public void stopVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.stop();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        StCmeraLog.i("JCameraView SurfaceCreated");
        playVideo();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        StCmeraLog.i("JCameraView SurfaceDestroyed");
        releaseMediaPlayer();
    }

    public void switchVideoPlay(boolean z) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (z) {
                startVideo();
            } else {
                if (mediaPlayer.isPlaying()) {
                    this.mMediaPlayer.pause();
                }
                stopUpdateHelper();
            }
            if (isPlaying()) {
                this.playPauseDrawable.setPause(true);
            } else {
                this.playPauseDrawable.setPlay(true);
            }
        }
    }
}
