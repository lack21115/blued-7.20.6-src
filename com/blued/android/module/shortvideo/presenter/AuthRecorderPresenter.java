package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IAuthRecorderView;
import com.blued.android.module.shortvideo.fragment.AuthPreviewFragment;
import com.blued.android.module.shortvideo.utils.StvCameraUtils;
import com.blued.android.module.shortvideo.utils.StvConfig;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.utils.VideoConfigData;
import com.bytedance.applog.tracker.Tracker;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEnv;
import com.qiniu.pili.droid.shortvideo.PLShortVideoRecorder;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/AuthRecorderPresenter.class */
public class AuthRecorderPresenter extends ShortVideoBasePresent<IAuthRecorderView> implements PLFocusListener, PLRecordStateListener, PLVideoSaveListener {
    private static final String a = AuthPreviewPresenter.class.getSimpleName();
    private PLShortVideoRecorder b;
    private PLRecordSetting c;
    private PLCameraSetting d;
    private Bundle e;
    private int f;

    public AuthRecorderPresenter(Bundle bundle) {
        this.e = bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        StvLogUtils.a(str);
    }

    private void m() {
        PLShortVideoRecorder pLShortVideoRecorder = new PLShortVideoRecorder();
        this.b = pLShortVideoRecorder;
        pLShortVideoRecorder.setRecordStateListener(this);
        this.b.setFocusListener(this);
        this.d = new PLCameraSetting();
        this.d.setCameraId(StvCameraUtils.a());
        this.d.setCameraPreviewSizeRatio(VideoConfigData.a());
        PLMicrophoneSetting pLMicrophoneSetting = new PLMicrophoneSetting();
        PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(D().getContext());
        pLVideoEncodeSetting.setPreferredEncodingSize(720, (int) GL10.GL_INVALID_ENUM);
        pLVideoEncodeSetting.setEncodingFps(30);
        pLVideoEncodeSetting.setEncodingBitrate(VideoConfigData.c());
        pLVideoEncodeSetting.setHWCodecEnabled(VideoConfigData.a.booleanValue());
        PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
        pLAudioEncodeSetting.setHWCodecEnabled(false);
        PLRecordSetting pLRecordSetting = new PLRecordSetting();
        this.c = pLRecordSetting;
        pLRecordSetting.setVideoCacheDir(StvConfig.b());
        this.c.setVideoFilepath(StvTools.a());
        this.c.setDisplayMode(PLDisplayMode.FULL);
        this.c.setMaxRecordDuration(5000L);
        this.b.prepare(D().a(), this.d, pLMicrophoneSetting, pLVideoEncodeSetting, pLAudioEncodeSetting, (PLFaceBeautySetting) null, this.c);
        this.b.setRecordSpeed(1.0d);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a() {
        Bundle bundle = this.e;
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = D().getArguments();
        }
        if (bundle2 != null) {
            this.f = bundle2.getInt("from", 0);
        }
        if (StvCameraUtils.b() <= 0) {
            StvLogUtils.a("不支持摄像头");
            D().c();
            return;
        }
        if (!AppInfo.m()) {
            PLShortVideoEnv.setLogLevel(7);
        }
        m();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == 0) {
            return;
        }
        activity.setResult(i, intent);
        if (i != 9) {
            activity.finish();
        } else {
            activity.finish();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Bundle bundle) {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void b() {
        StvLogUtils.a(a + "destroy()", new Object[0]);
        PLShortVideoRecorder pLShortVideoRecorder = this.b;
        if (pLShortVideoRecorder != null) {
            pLShortVideoRecorder.destroy();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void c() {
        StvLogUtils.a(a + "resume()", new Object[0]);
        this.b.resume();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void d() {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void e() {
        StvLogUtils.a(a + "pause()", new Object[0]);
        this.b.pause();
        i();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void f() {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public boolean g() {
        k();
        return false;
    }

    public boolean h() {
        boolean beginSection = this.b.beginSection();
        if (beginSection && D() != null) {
            D().e();
        }
        return beginSection;
    }

    public boolean i() {
        return this.b.deleteLastSection();
    }

    public void j() {
        this.b.concatSections(this);
    }

    public void k() {
        this.b.cancelConcat();
    }

    public void onAutoFocusStart() {
        StvLogUtils.a(a + "auto focus start", new Object[0]);
    }

    public void onAutoFocusStop() {
        StvLogUtils.a(a + "auto focus stop", new Object[0]);
    }

    public void onDurationTooShort() {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    AuthRecorderPresenter.this.i();
                    AuthRecorderPresenter.this.D().b(false);
                    StvLogUtils.a(AuthRecorderPresenter.a + " 录制视频太短！！！", new Object[0]);
                    AuthRecorderPresenter.this.a("时间过短，无法完成录制");
                }
            });
            return;
        }
        StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
    }

    public void onError(int i) {
        String str = i == 4 ? "摄像头配置错误" : i == 5 ? "麦克风配置错误" : null;
        if (!TextUtils.isEmpty(str)) {
            StvLogUtils.a(str, new Object[0]);
        }
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AuthRecorderPresenter.this.D().getContext());
                    builder.setMessage("相机没有正常启动，请重新开始");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                            AuthRecorderPresenter.this.D().a(false);
                        }
                    });
                    builder.create().show();
                }
            });
            return;
        }
        StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
    }

    public void onManualFocusCancel() {
    }

    public void onManualFocusStart(boolean z) {
    }

    public void onManualFocusStop(boolean z) {
    }

    public void onProgressUpdate(float f) {
        if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
            StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
        }
    }

    public void onReady() {
        StvLogUtils.a(a + "onReady()", new Object[0]);
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    AuthRecorderPresenter.this.D().d();
                }
            });
            return;
        }
        StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
    }

    public void onRecordCompleted() {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter.4
                @Override // java.lang.Runnable
                public void run() {
                    AuthRecorderPresenter.this.j();
                    AuthRecorderPresenter.this.D().f();
                }
            });
            return;
        }
        StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
    }

    public void onRecordStarted() {
        StvLogUtils.a(a + "record start time: " + System.currentTimeMillis(), new Object[0]);
        if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
            StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
        }
    }

    public void onRecordStopped() {
        StvLogUtils.a(a + "record stop time: " + System.currentTimeMillis(), new Object[0]);
        if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
            StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
        }
    }

    public void onSaveVideoCanceled() {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter.6
                @Override // java.lang.Runnable
                public void run() {
                    AuthRecorderPresenter.this.i();
                    AuthRecorderPresenter.this.D().b(false);
                }
            });
            return;
        }
        StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
    }

    public void onSaveVideoFailed(final int i) {
        if (D() != null && D().getActivity() != null) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter.5
                @Override // java.lang.Runnable
                public void run() {
                    AuthRecorderPresenter.this.i();
                    AuthRecorderPresenter.this.D().b(false);
                    String string = AuthRecorderPresenter.this.D().getContext().getString(R.string.stv_video_progress_error);
                    StvLogUtils.a(string + " :" + i, new Object[0]);
                    AuthRecorderPresenter.this.a(string);
                }
            });
            return;
        }
        StvLogUtils.a(a + " getView() == null", new Object[0]);
    }

    public void onSaveVideoSuccess(final String str) {
        StvLogUtils.a(a + "concat sections success filePath: " + str, new Object[0]);
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter.7
                @Override // java.lang.Runnable
                public void run() {
                    AuthRecorderPresenter.this.D().g();
                    AuthRecorderPresenter.this.D().b(false);
                    AuthRecorderPresenter.this.i();
                    AuthPreviewFragment.a(AuthRecorderPresenter.this.D().b(), str, AuthRecorderPresenter.this.f, 9);
                }
            });
            return;
        }
        StvLogUtils.a(a + " getView() == null!!!", new Object[0]);
    }

    public void onSectionDecreased(long j, long j2, int i) {
        StvLogUtils.a(a + "section decreased decDuration: " + j + " totalDuration: " + j2 + " sectionCount: " + i, new Object[0]);
    }

    public void onSectionIncreased(long j, long j2, int i) {
        StvLogUtils.a(a + "section increased incDuration: " + j + " totalDuration: " + j2 + " sectionCount: " + i, new Object[0]);
    }

    public void onSectionRecording(long j, long j2, int i) {
    }
}
