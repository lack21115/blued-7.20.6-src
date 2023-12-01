package com.sobot.chat.camera;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.push.config.c;
import com.sobot.chat.camera.CameraInterface;
import com.sobot.chat.camera.listener.StCameraListener;
import com.sobot.chat.camera.listener.StCaptureListener;
import com.sobot.chat.camera.listener.StClickListener;
import com.sobot.chat.camera.listener.StErrorListener;
import com.sobot.chat.camera.listener.StTypeListener;
import com.sobot.chat.camera.state.CameraMachine;
import com.sobot.chat.camera.util.FileUtil;
import com.sobot.chat.camera.util.ScreenUtils;
import com.sobot.chat.camera.util.StCmeraLog;
import com.sobot.chat.camera.view.StICameraView;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/StCameraView.class */
public class StCameraView extends FrameLayout implements SurfaceHolder.Callback, CameraInterface.CameraOpenOverCallback, StICameraView {
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    public static final int MEDIA_QUALITY_DESPAIR = 200000;
    public static final int MEDIA_QUALITY_FUNNY = 400000;
    public static final int MEDIA_QUALITY_HIGH = 2000000;
    public static final int MEDIA_QUALITY_LOW = 1200000;
    public static final int MEDIA_QUALITY_MIDDLE = 1600000;
    public static final int MEDIA_QUALITY_POOR = 800000;
    public static final int MEDIA_QUALITY_SORRY = 80000;
    public static final int TYPE_DEFAULT = 4;
    private static final int TYPE_FLASH_AUTO = 33;
    private static final int TYPE_FLASH_OFF = 35;
    private static final int TYPE_FLASH_ON = 34;
    public static final int TYPE_PICTURE = 1;
    public static final int TYPE_SHORT = 3;
    public static final int TYPE_VIDEO = 2;
    private Bitmap captureBitmap;
    private int duration;
    private StErrorListener errorLisenter;
    private Bitmap firstFrame;
    private boolean firstTouch;
    private float firstTouchLength;
    private int iconLeft;
    private int iconMargin;
    private int iconRight;
    private int iconSize;
    private int iconSrc;
    private StCameraListener jCameraLisenter;
    private int layout_width;
    private StClickListener leftClickListener;
    private CaptureLayout mCaptureLayout;
    private StFoucsView mFoucsView;
    private MediaPlayer mMediaPlayer;
    private ImageView mPhoto;
    private ImageView mSwitchCamera;
    private VideoView mVideoView;
    private CameraMachine machine;
    private StClickListener rightClickListener;
    private float screenProp;
    private int type_flash;
    private String videoUrl;
    private int zoomGradient;

    public StCameraView(Context context) {
        this(context, null);
    }

    public StCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type_flash = 35;
        this.screenProp = 0.0f;
        this.iconSize = 0;
        this.iconMargin = 0;
        this.iconSrc = 0;
        this.iconLeft = 0;
        this.iconRight = 0;
        this.duration = 0;
        this.zoomGradient = 0;
        this.firstTouch = true;
        this.firstTouchLength = 0.0f;
        initAttrs();
        initData();
        initView();
    }

    private void initAttrs() {
        this.iconSize = (int) TypedValue.applyDimension(2, 30.0f, getResources().getDisplayMetrics());
        this.iconMargin = (int) TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics());
        this.iconSrc = ResourceUtils.getDrawableId(getContext(), "sobot_ic_camera");
        this.iconLeft = ResourceUtils.getDrawableId(getContext(), "sobot_ic_back");
        this.iconRight = 0;
        this.duration = 15000;
    }

    private void initData() {
        int screenWidth = ScreenUtils.getScreenWidth(getContext());
        this.layout_width = screenWidth;
        this.zoomGradient = (int) (screenWidth / 16.0f);
        StCmeraLog.i("zoom = " + this.zoomGradient);
        this.machine = new CameraMachine(getContext(), this, this);
        CameraInterface.getInstance().setContext(getContext());
    }

    private void initView() {
        setWillNotDraw(false);
        View inflate = LayoutInflater.from(getContext()).inflate(ResourceUtils.getResLayoutId(getContext(), "sobot_camera_view"), this);
        this.mVideoView = (VideoView) inflate.findViewById(ResourceUtils.getResId(getContext(), "video_preview"));
        this.mPhoto = (ImageView) inflate.findViewById(ResourceUtils.getResId(getContext(), "image_photo"));
        ImageView imageView = (ImageView) inflate.findViewById(ResourceUtils.getResId(getContext(), "image_switch"));
        this.mSwitchCamera = imageView;
        imageView.setImageResource(this.iconSrc);
        CaptureLayout captureLayout = (CaptureLayout) inflate.findViewById(ResourceUtils.getResId(getContext(), "capture_layout"));
        this.mCaptureLayout = captureLayout;
        captureLayout.setDuration(this.duration);
        this.mCaptureLayout.setIconSrc(this.iconLeft, this.iconRight);
        this.mFoucsView = (StFoucsView) inflate.findViewById(ResourceUtils.getResId(getContext(), "fouce_view"));
        this.mVideoView.getHolder().addCallback(this);
        this.mSwitchCamera.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.camera.StCameraView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                StCameraView.this.machine.swtich(StCameraView.this.mVideoView.getHolder(), StCameraView.this.screenProp);
            }
        });
        this.mCaptureLayout.setCaptureLisenter(new StCaptureListener() { // from class: com.sobot.chat.camera.StCameraView.2
            @Override // com.sobot.chat.camera.listener.StCaptureListener
            public void recordEnd(long j) {
                StCameraView.this.machine.stopRecord(false, j);
            }

            @Override // com.sobot.chat.camera.listener.StCaptureListener
            public void recordError() {
                if (StCameraView.this.errorLisenter != null) {
                    StCameraView.this.errorLisenter.AudioPermissionError();
                }
            }

            @Override // com.sobot.chat.camera.listener.StCaptureListener
            public void recordShort(final long j) {
                StCameraView.this.mCaptureLayout.setTextWithAnimation(ResourceUtils.getResString(StCameraView.this.getContext(), "sobot_voice_time_short"));
                StCameraView.this.mSwitchCamera.setVisibility(0);
                StCameraView.this.postDelayed(new Runnable() { // from class: com.sobot.chat.camera.StCameraView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StCameraView.this.machine.stopRecord(true, j);
                    }
                }, c.j - j);
            }

            @Override // com.sobot.chat.camera.listener.StCaptureListener
            public void recordStart() {
                StCameraView.this.mSwitchCamera.setVisibility(4);
                StCameraView.this.machine.record(StCameraView.this.mVideoView.getHolder().getSurface(), StCameraView.this.screenProp);
            }

            @Override // com.sobot.chat.camera.listener.StCaptureListener
            public void recordZoom(float f) {
                StCmeraLog.i("recordZoom");
                StCameraView.this.machine.zoom(f, 144);
            }

            @Override // com.sobot.chat.camera.listener.StCaptureListener
            public void takePictures() {
                StCameraView.this.mSwitchCamera.setVisibility(4);
                StCameraView.this.machine.capture();
            }
        });
        this.mCaptureLayout.setTypeLisenter(new StTypeListener() { // from class: com.sobot.chat.camera.StCameraView.3
            @Override // com.sobot.chat.camera.listener.StTypeListener
            public void cancel() {
                StCameraView.this.recycleBitmap();
                StCameraView.this.machine.cancle(StCameraView.this.mVideoView.getHolder(), StCameraView.this.screenProp);
            }

            @Override // com.sobot.chat.camera.listener.StTypeListener
            public void confirm() {
                StCameraView.this.machine.confirm();
            }
        });
        this.mCaptureLayout.setLeftClickListener(new StClickListener() { // from class: com.sobot.chat.camera.StCameraView.4
            @Override // com.sobot.chat.camera.listener.StClickListener
            public void onClick() {
                if (StCameraView.this.leftClickListener != null) {
                    StCameraView.this.leftClickListener.onClick();
                }
            }
        });
        this.mCaptureLayout.setRightClickListener(new StClickListener() { // from class: com.sobot.chat.camera.StCameraView.5
            @Override // com.sobot.chat.camera.listener.StClickListener
            public void onClick() {
                if (StCameraView.this.rightClickListener != null) {
                    StCameraView.this.rightClickListener.onClick();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleBitmap() {
        Bitmap bitmap = this.captureBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.captureBitmap.recycle();
            this.captureBitmap = null;
        }
        Bitmap bitmap2 = this.firstFrame;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.firstFrame.recycle();
        this.firstFrame = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocusViewWidthAnimation(float f, float f2) {
        this.machine.foucs(f, f2, new CameraInterface.FocusCallback() { // from class: com.sobot.chat.camera.StCameraView.7
            @Override // com.sobot.chat.camera.CameraInterface.FocusCallback
            public void focusSuccess() {
                StCameraView.this.mFoucsView.setVisibility(4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoViewSize(float f, float f2) {
        if (f > f2) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ((f2 / f) * getWidth()));
            layoutParams.gravity = 17;
            this.mVideoView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.sobot.chat.camera.CameraInterface.CameraOpenOverCallback
    public void cameraHasOpened() {
        CameraInterface.getInstance().doStartPreview(this.mVideoView.getHolder(), this.screenProp);
    }

    @Override // com.sobot.chat.camera.view.StICameraView
    public void confirmState(int i) {
        if (i == 1) {
            this.mPhoto.setVisibility(4);
            StCameraListener stCameraListener = this.jCameraLisenter;
            if (stCameraListener != null) {
                stCameraListener.captureSuccess(this.captureBitmap);
            }
        } else if (i == 2) {
            stopVideo();
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.machine.start(this.mVideoView.getHolder(), this.screenProp);
            StCameraListener stCameraListener2 = this.jCameraLisenter;
            if (stCameraListener2 != null) {
                stCameraListener2.recordSuccess(this.videoUrl, this.firstFrame);
            }
        }
        this.mCaptureLayout.resetCaptureLayout();
    }

    @Override // com.sobot.chat.camera.view.StICameraView
    public boolean handlerFoucs(float f, float f2) {
        StFoucsView stFoucsView;
        StFoucsView stFoucsView2;
        if (f2 > this.mCaptureLayout.getTop()) {
            return false;
        }
        this.mFoucsView.setVisibility(0);
        float f3 = f;
        if (f < this.mFoucsView.getWidth() / 2) {
            f3 = this.mFoucsView.getWidth() / 2;
        }
        float f4 = f3;
        if (f3 > this.layout_width - (this.mFoucsView.getWidth() / 2)) {
            f4 = this.layout_width - (this.mFoucsView.getWidth() / 2);
        }
        float f5 = f2;
        if (f2 < this.mFoucsView.getWidth() / 2) {
            f5 = this.mFoucsView.getWidth() / 2;
        }
        float f6 = f5;
        if (f5 > this.mCaptureLayout.getTop() - (this.mFoucsView.getWidth() / 2)) {
            f6 = this.mCaptureLayout.getTop() - (this.mFoucsView.getWidth() / 2);
        }
        this.mFoucsView.setX(f4 - (stFoucsView.getWidth() / 2));
        this.mFoucsView.setY(f6 - (stFoucsView2.getHeight() / 2));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mFoucsView, "scaleX", 1.0f, 0.6f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFoucsView, "scaleY", 1.0f, 0.6f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mFoucsView, "alpha", 1.0f, 0.4f, 1.0f, 0.4f, 1.0f, 0.4f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3);
        animatorSet.setDuration(400L);
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        recycleBitmap();
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float measuredWidth = this.mVideoView.getMeasuredWidth();
        float measuredHeight = this.mVideoView.getMeasuredHeight();
        if (this.screenProp == 0.0f) {
            this.screenProp = measuredHeight / measuredWidth;
        }
    }

    public void onPause() {
        StCmeraLog.i("JCameraView onPause");
        stopVideo();
        resetState(1);
        CameraInterface.getInstance().stopRecord(true, null);
        CameraInterface.getInstance().isPreview(false);
        CameraInterface.getInstance().unregisterSensorManager(getContext());
    }

    public void onResume() {
        StCmeraLog.i("JCameraView onResume");
        resetState(4);
        CameraInterface.getInstance().registerSensorManager(getContext());
        CameraInterface.getInstance().setSwitchView(this.mSwitchCamera);
        this.machine.start(this.mVideoView.getHolder(), this.screenProp);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getPointerCount() == 1) {
                setFocusViewWidthAnimation(motionEvent.getX(), motionEvent.getY());
            }
            if (motionEvent.getPointerCount() == 2) {
                Log.i("CJT", "ACTION_DOWN = 2");
                return true;
            }
            return true;
        } else if (action == 1) {
            this.firstTouch = true;
            return true;
        } else if (action != 2) {
            return true;
        } else {
            if (motionEvent.getPointerCount() == 1) {
                this.firstTouch = true;
            }
            if (motionEvent.getPointerCount() == 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                float sqrt = (float) Math.sqrt(Math.pow(x - motionEvent.getX(1), 2.0d) + Math.pow(y - motionEvent.getY(1), 2.0d));
                if (this.firstTouch) {
                    this.firstTouchLength = sqrt;
                    this.firstTouch = false;
                }
                float f = this.firstTouchLength;
                if (((int) (sqrt - f)) / this.zoomGradient != 0) {
                    this.firstTouch = true;
                    this.machine.zoom(sqrt - f, 145);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    @Override // com.sobot.chat.camera.view.StICameraView
    public void playVideo(Bitmap bitmap, String str) {
        this.videoUrl = str;
        this.firstFrame = bitmap;
        try {
            Surface surface = this.mVideoView.getHolder().getSurface();
            StCmeraLog.i("surface.isValid():" + surface.isValid());
            if (surface.isValid()) {
                if (this.mMediaPlayer == null) {
                    this.mMediaPlayer = new MediaPlayer();
                } else {
                    this.mMediaPlayer.reset();
                }
                this.mMediaPlayer.setDataSource(str);
                this.mMediaPlayer.setSurface(surface);
                if (Build.VERSION.SDK_INT >= 16) {
                    this.mMediaPlayer.setVideoScalingMode(1);
                }
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.sobot.chat.camera.StCameraView.8
                    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                        StCameraView stCameraView = StCameraView.this;
                        stCameraView.updateVideoViewSize(stCameraView.mMediaPlayer.getVideoWidth(), StCameraView.this.mMediaPlayer.getVideoHeight());
                    }
                });
                this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.sobot.chat.camera.StCameraView.9
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        StCameraView.this.mMediaPlayer.start();
                    }
                });
                this.mMediaPlayer.setLooping(true);
                this.mMediaPlayer.prepareAsync();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sobot.chat.camera.view.StICameraView
    public void resetState(int i) {
        if (i == 1) {
            this.mPhoto.setVisibility(4);
        } else if (i == 2) {
            stopVideo();
            FileUtil.deleteFile(this.videoUrl);
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.machine.start(this.mVideoView.getHolder(), this.screenProp);
        } else if (i == 4) {
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        this.mSwitchCamera.setVisibility(0);
        this.mCaptureLayout.resetCaptureLayout();
    }

    public void setErrorLisenter(StErrorListener stErrorListener) {
        this.errorLisenter = stErrorListener;
        CameraInterface.getInstance().setErrorLinsenter(stErrorListener);
    }

    public void setFeatures(int i) {
        this.mCaptureLayout.setButtonFeatures(i);
    }

    public void setJCameraLisenter(StCameraListener stCameraListener) {
        this.jCameraLisenter = stCameraListener;
    }

    public void setLeftClickListener(StClickListener stClickListener) {
        this.leftClickListener = stClickListener;
    }

    public void setMediaQuality(int i) {
        CameraInterface.getInstance().setMediaQuality(i);
    }

    public void setRightClickListener(StClickListener stClickListener) {
        this.rightClickListener = stClickListener;
    }

    public void setSaveVideoPath(String str) {
        CameraInterface.getInstance().setSaveVideoPath(str);
    }

    @Override // com.sobot.chat.camera.view.StICameraView
    public void setTip(String str) {
        this.mCaptureLayout.setTip(str);
    }

    @Override // com.sobot.chat.camera.view.StICameraView
    public void showPicture(Bitmap bitmap, boolean z) {
        if (z) {
            this.mPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            this.mPhoto.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.captureBitmap = bitmap;
        this.mPhoto.setImageBitmap(bitmap);
        this.mPhoto.setVisibility(0);
        this.mCaptureLayout.startAlphaAnimation();
        this.mCaptureLayout.startTypeBtnAnimator();
    }

    @Override // com.sobot.chat.camera.view.StICameraView
    public void startPreviewCallback() {
        StCmeraLog.i("startPreviewCallback");
        handlerFoucs(this.mFoucsView.getWidth() / 2, this.mFoucsView.getHeight() / 2);
    }

    @Override // com.sobot.chat.camera.view.StICameraView
    public void stopVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        StCmeraLog.i("JCameraView SurfaceCreated");
        new Thread() { // from class: com.sobot.chat.camera.StCameraView.6
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                CameraInterface.getInstance().doOpenCamera(StCameraView.this);
                StCameraView.this.postDelayed(new Runnable() { // from class: com.sobot.chat.camera.StCameraView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StCameraView.this.setFocusViewWidthAnimation(StCameraView.this.getWidth() / 2, StCameraView.this.getHeight() / 2);
                    }
                }, 1000L);
            }
        }.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        StCmeraLog.i("JCameraView SurfaceDestroyed");
        CameraInterface.getInstance().doDestroyCamera();
    }
}
