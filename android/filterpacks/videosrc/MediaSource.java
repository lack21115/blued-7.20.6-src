package android.filterpacks.videosrc;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.GLFrame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/videosrc/MediaSource.class */
public class MediaSource extends Filter {
    private static final int NEWFRAME_TIMEOUT = 100;
    private static final int NEWFRAME_TIMEOUT_REPEAT = 10;
    private static final int PREP_TIMEOUT = 100;
    private static final int PREP_TIMEOUT_REPEAT = 100;
    private static final String TAG = "MediaSource";
    private boolean mCompleted;
    @GenerateFieldPort(hasDefault = true, name = "context")
    private Context mContext;
    private ShaderProgram mFrameExtractor;
    private final String mFrameShader;
    private boolean mGotSize;
    private int mHeight;
    private final boolean mLogVerbose;
    @GenerateFieldPort(hasDefault = true, name = "loop")
    private boolean mLooping;
    private GLFrame mMediaFrame;
    private MediaPlayer mMediaPlayer;
    private boolean mNewFrameAvailable;
    @GenerateFieldPort(hasDefault = true, name = "orientation")
    private int mOrientation;
    private boolean mOrientationUpdated;
    private MutableFrameFormat mOutputFormat;
    private boolean mPaused;
    private boolean mPlaying;
    private boolean mPrepared;
    @GenerateFieldPort(hasDefault = true, name = "sourceIsUrl")
    private boolean mSelectedIsUrl;
    @GenerateFieldPort(hasDefault = true, name = "sourceAsset")
    private AssetFileDescriptor mSourceAsset;
    @GenerateFieldPort(hasDefault = true, name = "sourceUrl")
    private String mSourceUrl;
    private SurfaceTexture mSurfaceTexture;
    @GenerateFieldPort(hasDefault = true, name = "volume")
    private float mVolume;
    @GenerateFinalPort(hasDefault = true, name = "waitForNewFrame")
    private boolean mWaitForNewFrame;
    private int mWidth;
    private MediaPlayer.OnCompletionListener onCompletionListener;
    private SurfaceTexture.OnFrameAvailableListener onMediaFrameAvailableListener;
    private MediaPlayer.OnPreparedListener onPreparedListener;
    private MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
    private static final float[] mSourceCoords_0 = {1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] mSourceCoords_270 = {0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] mSourceCoords_180 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static final float[] mSourceCoords_90 = {1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    public MediaSource(String str) {
        super(str);
        this.mSourceUrl = "";
        this.mSourceAsset = null;
        this.mContext = null;
        this.mSelectedIsUrl = false;
        this.mWaitForNewFrame = true;
        this.mLooping = true;
        this.mVolume = 0.0f;
        this.mOrientation = 0;
        this.mFrameShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES tex_sampler_0;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_FragColor = texture2D(tex_sampler_0, v_texcoord);\n}\n";
        this.onVideoSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: android.filterpacks.videosrc.MediaSource.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                if (MediaSource.this.mLogVerbose) {
                    Log.v(MediaSource.TAG, "MediaPlayer sent dimensions: " + i + " x " + i2);
                }
                if (!MediaSource.this.mGotSize) {
                    if (MediaSource.this.mOrientation == 0 || MediaSource.this.mOrientation == 180) {
                        MediaSource.this.mOutputFormat.setDimensions(i, i2);
                    } else {
                        MediaSource.this.mOutputFormat.setDimensions(i2, i);
                    }
                    MediaSource.this.mWidth = i;
                    MediaSource.this.mHeight = i2;
                } else if (MediaSource.this.mOutputFormat.getWidth() != i || MediaSource.this.mOutputFormat.getHeight() != i2) {
                    Log.e(MediaSource.TAG, "Multiple video size change events received!");
                }
                synchronized (MediaSource.this) {
                    MediaSource.this.mGotSize = true;
                    MediaSource.this.notify();
                }
            }
        };
        this.onPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: android.filterpacks.videosrc.MediaSource.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (MediaSource.this.mLogVerbose) {
                    Log.v(MediaSource.TAG, "MediaPlayer is prepared");
                }
                synchronized (MediaSource.this) {
                    MediaSource.this.mPrepared = true;
                    MediaSource.this.notify();
                }
            }
        };
        this.onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: android.filterpacks.videosrc.MediaSource.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (MediaSource.this.mLogVerbose) {
                    Log.v(MediaSource.TAG, "MediaPlayer has completed playback");
                }
                synchronized (MediaSource.this) {
                    MediaSource.this.mCompleted = true;
                }
            }
        };
        this.onMediaFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: android.filterpacks.videosrc.MediaSource.4
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (MediaSource.this.mLogVerbose) {
                    Log.v(MediaSource.TAG, "New frame from media player");
                }
                synchronized (MediaSource.this) {
                    if (MediaSource.this.mLogVerbose) {
                        Log.v(MediaSource.TAG, "New frame: notify");
                    }
                    MediaSource.this.mNewFrameAvailable = true;
                    MediaSource.this.notify();
                    if (MediaSource.this.mLogVerbose) {
                        Log.v(MediaSource.TAG, "New frame: notify done");
                    }
                }
            }
        };
        this.mNewFrameAvailable = false;
        this.mLogVerbose = Log.isLoggable(TAG, 2);
    }

    private void createFormats() {
        this.mOutputFormat = ImageFormat.create(3, 3);
    }

    private boolean setupMediaPlayer(boolean z) {
        synchronized (this) {
            this.mPrepared = false;
            this.mGotSize = false;
            this.mPlaying = false;
            this.mPaused = false;
            this.mCompleted = false;
            this.mNewFrameAvailable = false;
            if (this.mLogVerbose) {
                Log.v(TAG, "Setting up playback.");
            }
            if (this.mMediaPlayer != null) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Resetting existing MediaPlayer.");
                }
                this.mMediaPlayer.reset();
            } else {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Creating new MediaPlayer.");
                }
                this.mMediaPlayer = new MediaPlayer();
            }
            if (this.mMediaPlayer == null) {
                throw new RuntimeException("Unable to create a MediaPlayer!");
            }
            try {
                if (z) {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Setting MediaPlayer source to URI " + this.mSourceUrl);
                    }
                    if (this.mContext == null) {
                        this.mMediaPlayer.setDataSource(this.mSourceUrl);
                    } else {
                        this.mMediaPlayer.setDataSource(this.mContext, Uri.parse(this.mSourceUrl.toString()));
                    }
                } else {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Setting MediaPlayer source to asset " + this.mSourceAsset);
                    }
                    this.mMediaPlayer.setDataSource(this.mSourceAsset.getFileDescriptor(), this.mSourceAsset.getStartOffset(), this.mSourceAsset.getLength());
                }
                this.mMediaPlayer.setLooping(this.mLooping);
                this.mMediaPlayer.setVolume(this.mVolume, this.mVolume);
                Surface surface = new Surface(this.mSurfaceTexture);
                this.mMediaPlayer.setSurface(surface);
                surface.release();
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.onVideoSizeChangedListener);
                this.mMediaPlayer.setOnPreparedListener(this.onPreparedListener);
                this.mMediaPlayer.setOnCompletionListener(this.onCompletionListener);
                this.mSurfaceTexture.setOnFrameAvailableListener(this.onMediaFrameAvailableListener);
                if (this.mLogVerbose) {
                    Log.v(TAG, "Preparing MediaPlayer.");
                }
                this.mMediaPlayer.prepareAsync();
            } catch (IOException e) {
                this.mMediaPlayer.release();
                this.mMediaPlayer = null;
                if (z) {
                    throw new RuntimeException(String.format("Unable to set MediaPlayer to URL %s!", this.mSourceUrl), e);
                }
                throw new RuntimeException(String.format("Unable to set MediaPlayer to asset %s!", this.mSourceAsset), e);
            } catch (IllegalArgumentException e2) {
                this.mMediaPlayer.release();
                this.mMediaPlayer = null;
                if (z) {
                    throw new RuntimeException(String.format("Unable to set MediaPlayer to URL %s!", this.mSourceUrl), e2);
                }
                throw new RuntimeException(String.format("Unable to set MediaPlayer to asset %s!", this.mSourceAsset), e2);
            }
        }
        return true;
    }

    @Override // android.filterfw.core.Filter
    public void close(FilterContext filterContext) {
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.stop();
        }
        this.mPrepared = false;
        this.mGotSize = false;
        this.mPlaying = false;
        this.mPaused = false;
        this.mCompleted = false;
        this.mNewFrameAvailable = false;
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
        this.mSurfaceTexture.release();
        this.mSurfaceTexture = null;
        if (this.mLogVerbose) {
            Log.v(TAG, "MediaSource closed");
        }
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Parameter update");
        }
        if (str.equals("sourceUrl")) {
            if (isOpen()) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Opening new source URL");
                }
                if (this.mSelectedIsUrl) {
                    setupMediaPlayer(this.mSelectedIsUrl);
                }
            }
        } else if (str.equals("sourceAsset")) {
            if (isOpen()) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Opening new source FD");
                }
                if (this.mSelectedIsUrl) {
                    return;
                }
                setupMediaPlayer(this.mSelectedIsUrl);
            }
        } else if (str.equals("loop")) {
            if (isOpen()) {
                this.mMediaPlayer.setLooping(this.mLooping);
            }
        } else if (str.equals("sourceIsUrl")) {
            if (isOpen()) {
                if (this.mSelectedIsUrl) {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Opening new source URL");
                    }
                } else if (this.mLogVerbose) {
                    Log.v(TAG, "Opening new source Asset");
                }
                setupMediaPlayer(this.mSelectedIsUrl);
            }
        } else if (str.equals("volume")) {
            if (isOpen()) {
                this.mMediaPlayer.setVolume(this.mVolume, this.mVolume);
            }
        } else if (str.equals("orientation") && this.mGotSize) {
            if (this.mOrientation == 0 || this.mOrientation == 180) {
                this.mOutputFormat.setDimensions(this.mWidth, this.mHeight);
            } else {
                this.mOutputFormat.setDimensions(this.mHeight, this.mWidth);
            }
            this.mOrientationUpdated = true;
        }
    }

    @Override // android.filterfw.core.Filter
    public void open(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Opening MediaSource");
            if (this.mSelectedIsUrl) {
                Log.v(TAG, "Current URL is " + this.mSourceUrl);
            } else {
                Log.v(TAG, "Current source is Asset!");
            }
        }
        this.mMediaFrame = (GLFrame) filterContext.getFrameManager().newBoundFrame(this.mOutputFormat, 104, 0L);
        this.mSurfaceTexture = new SurfaceTexture(this.mMediaFrame.getTextureId());
        if (!setupMediaPlayer(this.mSelectedIsUrl)) {
            throw new RuntimeException("Error setting up MediaPlayer!");
        }
    }

    public void pauseVideo(boolean z) {
        synchronized (this) {
            if (isOpen()) {
                if (z && !this.mPaused) {
                    this.mMediaPlayer.pause();
                } else if (!z && this.mPaused) {
                    this.mMediaPlayer.start();
                }
            }
            this.mPaused = z;
        }
    }

    @Override // android.filterfw.core.Filter
    protected void prepare(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Preparing MediaSource");
        }
        this.mFrameExtractor = new ShaderProgram(filterContext, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES tex_sampler_0;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_FragColor = texture2D(tex_sampler_0, v_texcoord);\n}\n");
        this.mFrameExtractor.setSourceRect(0.0f, 1.0f, 1.0f, -1.0f);
        createFormats();
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        int i;
        if (this.mLogVerbose) {
            Log.v(TAG, "Processing new frame");
        }
        if (this.mMediaPlayer == null) {
            throw new NullPointerException("Unexpected null media player!");
        }
        if (this.mCompleted) {
            closeOutputPort("video");
            return;
        }
        if (!this.mPlaying) {
            int i2 = 0;
            if (this.mLogVerbose) {
                Log.v(TAG, "Waiting for preparation to complete");
                i2 = 0;
            }
            do {
                if (this.mGotSize && this.mPrepared) {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Starting playback");
                    }
                    this.mMediaPlayer.start();
                } else {
                    try {
                        wait(100L);
                    } catch (InterruptedException e) {
                    }
                    if (this.mCompleted) {
                        closeOutputPort("video");
                        return;
                    } else {
                        i = i2 + 1;
                        i2 = i;
                    }
                }
            } while (i != 100);
            this.mMediaPlayer.release();
            throw new RuntimeException("MediaPlayer timed out while preparing!");
        }
        if (!this.mPaused || !this.mPlaying) {
            if (this.mWaitForNewFrame) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Waiting for new frame");
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (this.mNewFrameAvailable) {
                        this.mNewFrameAvailable = false;
                        if (this.mLogVerbose) {
                            Log.v(TAG, "Got new frame");
                        }
                    } else if (i4 == 10) {
                        if (!this.mCompleted) {
                            throw new RuntimeException("Timeout waiting for new frame!");
                        }
                        closeOutputPort("video");
                        return;
                    } else {
                        try {
                            wait(100L);
                        } catch (InterruptedException e2) {
                            if (this.mLogVerbose) {
                                Log.v(TAG, "interrupted");
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            this.mSurfaceTexture.updateTexImage();
            this.mOrientationUpdated = true;
        }
        if (this.mOrientationUpdated) {
            float[] fArr = new float[16];
            this.mSurfaceTexture.getTransformMatrix(fArr);
            float[] fArr2 = new float[16];
            switch (this.mOrientation) {
                case 90:
                    Matrix.multiplyMM(fArr2, 0, fArr, 0, mSourceCoords_90, 0);
                    break;
                case 180:
                    Matrix.multiplyMM(fArr2, 0, fArr, 0, mSourceCoords_180, 0);
                    break;
                case 270:
                    Matrix.multiplyMM(fArr2, 0, fArr, 0, mSourceCoords_270, 0);
                    break;
                default:
                    Matrix.multiplyMM(fArr2, 0, fArr, 0, mSourceCoords_0, 0);
                    break;
            }
            if (this.mLogVerbose) {
                Log.v(TAG, "OrientationHint = " + this.mOrientation);
                Log.v(TAG, String.format("SetSourceRegion: %.2f, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f", Float.valueOf(fArr2[4]), Float.valueOf(fArr2[5]), Float.valueOf(fArr2[0]), Float.valueOf(fArr2[1]), Float.valueOf(fArr2[12]), Float.valueOf(fArr2[13]), Float.valueOf(fArr2[8]), Float.valueOf(fArr2[9])));
            }
            this.mFrameExtractor.setSourceRegion(fArr2[4], fArr2[5], fArr2[0], fArr2[1], fArr2[12], fArr2[13], fArr2[8], fArr2[9]);
            this.mOrientationUpdated = false;
        }
        Frame newFrame = filterContext.getFrameManager().newFrame(this.mOutputFormat);
        this.mFrameExtractor.process(this.mMediaFrame, newFrame);
        long timestamp = this.mSurfaceTexture.getTimestamp();
        if (this.mLogVerbose) {
            Log.v(TAG, "Timestamp: " + (timestamp / 1.0E9d) + " s");
        }
        newFrame.setTimestamp(timestamp);
        pushOutput("video", newFrame);
        newFrame.release();
        this.mPlaying = true;
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addOutputPort("video", ImageFormat.create(3, 3));
    }

    @Override // android.filterfw.core.Filter
    public void tearDown(FilterContext filterContext) {
        if (this.mMediaFrame != null) {
            this.mMediaFrame.release();
        }
    }
}
