package android.filterpacks.videosink;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.GLEnvironment;
import android.filterfw.core.GLFrame;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.filterfw.geometry.Point;
import android.filterfw.geometry.Quad;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/videosink/MediaEncoderFilter.class */
public class MediaEncoderFilter extends Filter {
    private static final int NO_AUDIO_SOURCE = -1;
    private static final String TAG = "MediaEncoderFilter";
    @GenerateFieldPort(hasDefault = true, name = "audioSource")
    private int mAudioSource;
    private boolean mCaptureTimeLapse;
    @GenerateFieldPort(hasDefault = true, name = "errorListener")
    private MediaRecorder.OnErrorListener mErrorListener;
    @GenerateFieldPort(hasDefault = true, name = "outputFileDescriptor")
    private FileDescriptor mFd;
    @GenerateFieldPort(hasDefault = true, name = "framerate")
    private int mFps;
    @GenerateFieldPort(hasDefault = true, name = "height")
    private int mHeight;
    @GenerateFieldPort(hasDefault = true, name = "infoListener")
    private MediaRecorder.OnInfoListener mInfoListener;
    private long mLastTimeLapseFrameRealTimestampNs;
    private boolean mLogVerbose;
    @GenerateFieldPort(hasDefault = true, name = "maxDurationMs")
    private int mMaxDurationMs;
    @GenerateFieldPort(hasDefault = true, name = "maxFileSize")
    private long mMaxFileSize;
    private MediaRecorder mMediaRecorder;
    private int mNumFramesEncoded;
    @GenerateFieldPort(hasDefault = true, name = "orientationHint")
    private int mOrientationHint;
    @GenerateFieldPort(hasDefault = true, name = "outputFile")
    private String mOutputFile;
    @GenerateFieldPort(hasDefault = true, name = "outputFormat")
    private int mOutputFormat;
    @GenerateFieldPort(hasDefault = true, name = "recordingProfile")
    private CamcorderProfile mProfile;
    private ShaderProgram mProgram;
    @GenerateFieldPort(hasDefault = true, name = "recording")
    private boolean mRecording;
    private boolean mRecordingActive;
    @GenerateFieldPort(hasDefault = true, name = "recordingDoneListener")
    private OnRecordingDoneListener mRecordingDoneListener;
    private GLFrame mScreen;
    @GenerateFieldPort(hasDefault = true, name = "inputRegion")
    private Quad mSourceRegion;
    private int mSurfaceId;
    @GenerateFieldPort(hasDefault = true, name = "timelapseRecordingIntervalUs")
    private long mTimeBetweenTimeLapseFrameCaptureUs;
    private long mTimestampNs;
    @GenerateFieldPort(hasDefault = true, name = "videoEncoder")
    private int mVideoEncoder;
    @GenerateFieldPort(hasDefault = true, name = "width")
    private int mWidth;

    /* loaded from: source-9557208-dex2jar.jar:android/filterpacks/videosink/MediaEncoderFilter$OnRecordingDoneListener.class */
    public interface OnRecordingDoneListener {
        void onRecordingDone();
    }

    public MediaEncoderFilter(String str) {
        super(str);
        this.mRecording = true;
        this.mOutputFile = new String("/sdcard/MediaEncoderOut.mp4");
        this.mFd = null;
        this.mAudioSource = -1;
        this.mInfoListener = null;
        this.mErrorListener = null;
        this.mRecordingDoneListener = null;
        this.mOrientationHint = 0;
        this.mProfile = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mFps = 30;
        this.mOutputFormat = 2;
        this.mVideoEncoder = 2;
        this.mMaxFileSize = 0L;
        this.mMaxDurationMs = 0;
        this.mTimeBetweenTimeLapseFrameCaptureUs = 0L;
        this.mRecordingActive = false;
        this.mTimestampNs = 0L;
        this.mLastTimeLapseFrameRealTimestampNs = 0L;
        this.mNumFramesEncoded = 0;
        this.mCaptureTimeLapse = false;
        this.mSourceRegion = new Quad(new Point(0.0f, 0.0f), new Point(1.0f, 0.0f), new Point(0.0f, 1.0f), new Point(1.0f, 1.0f));
        this.mLogVerbose = Log.isLoggable(TAG, 2);
    }

    private void startRecording(FilterContext filterContext) {
        int i;
        int i2;
        if (this.mLogVerbose) {
            Log.v(TAG, "Starting recording");
        }
        MutableFrameFormat mutableFrameFormat = new MutableFrameFormat(2, 3);
        mutableFrameFormat.setBytesPerSample(4);
        boolean z = this.mWidth > 0 && this.mHeight > 0;
        if (this.mProfile == null || z) {
            i = this.mWidth;
            i2 = this.mHeight;
        } else {
            i = this.mProfile.videoFrameWidth;
            i2 = this.mProfile.videoFrameHeight;
        }
        mutableFrameFormat.setDimensions(i, i2);
        this.mScreen = (GLFrame) filterContext.getFrameManager().newBoundFrame(mutableFrameFormat, 101, 0L);
        this.mMediaRecorder = new MediaRecorder();
        updateMediaRecorderParams();
        try {
            this.mMediaRecorder.prepare();
            this.mMediaRecorder.start();
            if (this.mLogVerbose) {
                Log.v(TAG, "Open: registering surface from Mediarecorder");
            }
            this.mSurfaceId = filterContext.getGLEnvironment().registerSurfaceFromMediaRecorder(this.mMediaRecorder);
            this.mNumFramesEncoded = 0;
            this.mRecordingActive = true;
        } catch (IOException e) {
            throw new RuntimeException("IOException inMediaRecorder.prepare()!", e);
        } catch (IllegalStateException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException("Unknown Exception inMediaRecorder.prepare()!", e3);
        }
    }

    private void stopRecording(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Stopping recording");
        }
        this.mRecordingActive = false;
        this.mNumFramesEncoded = 0;
        GLEnvironment gLEnvironment = filterContext.getGLEnvironment();
        if (this.mLogVerbose) {
            Log.v(TAG, String.format("Unregistering surface %d", Integer.valueOf(this.mSurfaceId)));
        }
        gLEnvironment.unregisterSurfaceId(this.mSurfaceId);
        try {
            this.mMediaRecorder.stop();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
            this.mScreen.release();
            this.mScreen = null;
            if (this.mRecordingDoneListener != null) {
                this.mRecordingDoneListener.onRecordingDone();
            }
        } catch (RuntimeException e) {
            throw new MediaRecorderStopException("MediaRecorder.stop() failed!", e);
        }
    }

    private void updateMediaRecorderParams() {
        this.mCaptureTimeLapse = this.mTimeBetweenTimeLapseFrameCaptureUs > 0;
        this.mMediaRecorder.setVideoSource(2);
        if (!this.mCaptureTimeLapse && this.mAudioSource != -1) {
            this.mMediaRecorder.setAudioSource(this.mAudioSource);
        }
        if (this.mProfile != null) {
            this.mMediaRecorder.setProfile(this.mProfile);
            this.mFps = this.mProfile.videoFrameRate;
            if (this.mWidth > 0 && this.mHeight > 0) {
                this.mMediaRecorder.setVideoSize(this.mWidth, this.mHeight);
            }
        } else {
            this.mMediaRecorder.setOutputFormat(this.mOutputFormat);
            this.mMediaRecorder.setVideoEncoder(this.mVideoEncoder);
            this.mMediaRecorder.setVideoSize(this.mWidth, this.mHeight);
            this.mMediaRecorder.setVideoFrameRate(this.mFps);
        }
        this.mMediaRecorder.setOrientationHint(this.mOrientationHint);
        this.mMediaRecorder.setOnInfoListener(this.mInfoListener);
        this.mMediaRecorder.setOnErrorListener(this.mErrorListener);
        if (this.mFd != null) {
            this.mMediaRecorder.setOutputFile(this.mFd);
        } else {
            this.mMediaRecorder.setOutputFile(this.mOutputFile);
        }
        try {
            this.mMediaRecorder.setMaxFileSize(this.mMaxFileSize);
        } catch (Exception e) {
            Log.w(TAG, "Setting maxFileSize on MediaRecorder unsuccessful! " + e.getMessage());
        }
        this.mMediaRecorder.setMaxDuration(this.mMaxDurationMs);
    }

    private void updateSourceRegion() {
        Quad quad = new Quad();
        quad.p0 = this.mSourceRegion.p2;
        quad.p1 = this.mSourceRegion.p3;
        quad.p2 = this.mSourceRegion.p0;
        quad.p3 = this.mSourceRegion.p1;
        this.mProgram.setSourceRegion(quad);
    }

    @Override // android.filterfw.core.Filter
    public void close(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Closing");
        }
        if (this.mRecordingActive) {
            stopRecording(filterContext);
        }
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Port " + str + " has been updated");
        }
        if (str.equals("recording")) {
            return;
        }
        if (str.equals("inputRegion")) {
            if (isOpen()) {
                updateSourceRegion();
            }
        } else if (isOpen() && this.mRecordingActive) {
            throw new RuntimeException("Cannot change recording parameters when the filter is recording!");
        }
    }

    @Override // android.filterfw.core.Filter
    public void open(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Opening");
        }
        updateSourceRegion();
        if (this.mRecording) {
            startRecording(filterContext);
        }
    }

    @Override // android.filterfw.core.Filter
    public void prepare(FilterContext filterContext) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Preparing");
        }
        this.mProgram = ShaderProgram.createIdentity(filterContext);
        this.mRecordingActive = false;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        GLEnvironment gLEnvironment = filterContext.getGLEnvironment();
        Frame pullInput = pullInput("videoframe");
        if (!this.mRecordingActive && this.mRecording) {
            startRecording(filterContext);
        }
        if (this.mRecordingActive && !this.mRecording) {
            stopRecording(filterContext);
        }
        if (this.mRecordingActive) {
            if (!this.mCaptureTimeLapse) {
                this.mTimestampNs = pullInput.getTimestamp();
            } else if (skipFrameAndModifyTimestamp(pullInput.getTimestamp())) {
                return;
            }
            gLEnvironment.activateSurfaceWithId(this.mSurfaceId);
            this.mProgram.process(pullInput, this.mScreen);
            gLEnvironment.setSurfaceTimestamp(this.mTimestampNs);
            gLEnvironment.swapBuffers();
            this.mNumFramesEncoded++;
        }
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("videoframe", ImageFormat.create(3, 3));
    }

    public boolean skipFrameAndModifyTimestamp(long j) {
        if (this.mNumFramesEncoded == 0) {
            this.mLastTimeLapseFrameRealTimestampNs = j;
            this.mTimestampNs = j;
            if (this.mLogVerbose) {
                Log.v(TAG, "timelapse: FIRST frame, last real t= " + this.mLastTimeLapseFrameRealTimestampNs + ", setting t = " + this.mTimestampNs);
                return false;
            }
            return false;
        } else if (this.mNumFramesEncoded >= 2 && j < this.mLastTimeLapseFrameRealTimestampNs + (1000 * this.mTimeBetweenTimeLapseFrameCaptureUs)) {
            if (this.mLogVerbose) {
                Log.v(TAG, "timelapse: skipping intermediate frame");
                return true;
            }
            return true;
        } else {
            if (this.mLogVerbose) {
                Log.v(TAG, "timelapse: encoding frame, Timestamp t = " + j + ", last real t= " + this.mLastTimeLapseFrameRealTimestampNs + ", interval = " + this.mTimeBetweenTimeLapseFrameCaptureUs);
            }
            this.mLastTimeLapseFrameRealTimestampNs = j;
            this.mTimestampNs += 1000000000 / this.mFps;
            if (this.mLogVerbose) {
                Log.v(TAG, "timelapse: encoding frame, setting t = " + this.mTimestampNs + ", delta t = " + (1000000000 / this.mFps) + ", fps = " + this.mFps);
                return false;
            }
            return false;
        }
    }

    @Override // android.filterfw.core.Filter
    public void tearDown(FilterContext filterContext) {
        if (this.mMediaRecorder != null) {
            this.mMediaRecorder.release();
        }
        if (this.mScreen != null) {
            this.mScreen.release();
        }
    }
}
