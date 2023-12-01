package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.base.album.AlbumProxy;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.base.http.FeedStateObserverProxy;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.base.shortvideo.MusicListProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.base.user.UserProxy;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeQiniuShortVideoManager;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IShineView;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameCallback;
import com.blued.android.module.shortvideo.fragment.EditFragment;
import com.blued.android.module.shortvideo.fragment.PhotoPreviewFragment;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.manager.StvFragmentManager;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.model.FilterConfigModel;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.model.ShineDataModel;
import com.blued.android.module.shortvideo.model.VideoFrameModel;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.utils.SenseConfigData;
import com.blued.android.module.shortvideo.utils.StvCameraUtils;
import com.blued.android.module.shortvideo.utils.StvConfig;
import com.blued.android.module.shortvideo.utils.StvGuideUtils;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.utils.VideoConfigData;
import com.blued.android.module.shortvideo.view.SectionProgressBar;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraPreviewListener;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLCaptureFrameListener;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEnv;
import com.qiniu.pili.droid.shortvideo.PLShortVideoRecorder;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.File;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/ShinePresenter.class */
public class ShinePresenter extends ShortVideoBasePresent<IShineView> implements FeedStateObserverProxy.IFeedStateListener, EventObserver, PLFocusListener, PLRecordStateListener, PLVideoSaveListener {
    private static final String i = ShinePresenter.class.getSimpleName();
    public String a;
    public int b;
    PLMicrophoneSetting c;
    PLVideoEncodeSetting d;
    PLAudioEncodeSetting e;
    PLFaceBeautySetting f;
    private Bundle j;
    private PLShortVideoRecorder k;
    private GestureDetector l;
    private PLRecordSetting m;
    private PLCameraSetting n;
    private String o;
    private int p;
    private int q;
    private DeleteAutoCheckedListener s;
    private SenseTimeQiniuShortVideoManager t;
    private ShineDataModel u;
    private boolean r = false;
    private GestureDetector.OnGestureListener v = new GestureDetector.OnGestureListener() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.16
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            ShinePresenter.this.a(motionEvent);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (ShinePresenter.this.u.isRecording()) {
                return true;
            }
            float x = motionEvent.getX() - motionEvent2.getX();
            float y = motionEvent.getY() - motionEvent2.getY();
            int i2 = 0;
            if (y > 0.0f && y > 80.0f && Math.abs(f2) > Math.abs(f)) {
                StvLogUtils.a(ShinePresenter.i + " 向上滑...", new Object[0]);
                int size = ShinePresenter.this.u.getFilters().size();
                if (size <= 0) {
                    StvLogUtils.a(ShinePresenter.i + " 没有滤镜数据...", new Object[0]);
                    return true;
                }
                int selectFilterPosition = ShinePresenter.this.u.getSelectFilterPosition() + 1;
                if (selectFilterPosition < size) {
                    i2 = selectFilterPosition;
                }
                FilterItem filterItem = ShinePresenter.this.u.getFilters().get(i2);
                if (filterItem != null) {
                    if (ShinePresenter.this.u.getFrom() < 60) {
                        StatisticsProxy.a().a("sv_filter_click", i2);
                    }
                    ShinePresenter.this.a(filterItem, i2);
                    ObserverMgr.a().a(EventType.VALUE.UPDATE_FILTER);
                    return true;
                }
                return true;
            } else if (y < 0.0f && Math.abs(y) > 80.0f && Math.abs(f2) > Math.abs(f)) {
                StvLogUtils.a(ShinePresenter.i + " 向下滑...", new Object[0]);
                if (ShinePresenter.this.u.getFilters().size() <= 0) {
                    StvLogUtils.a(ShinePresenter.i + " 没有滤镜数据...", new Object[0]);
                    return true;
                }
                int selectFilterPosition2 = ShinePresenter.this.u.getSelectFilterPosition() - 1;
                int i3 = selectFilterPosition2;
                if (selectFilterPosition2 < 0) {
                    i3 = ShinePresenter.this.u.getFilters().size() - 1;
                }
                FilterItem filterItem2 = ShinePresenter.this.u.getFilters().get(i3);
                if (filterItem2 != null) {
                    if (ShinePresenter.this.u.getFrom() < 60) {
                        StatisticsProxy.a().a("sv_filter_click", i3);
                    }
                    ShinePresenter.this.a(filterItem2, i3);
                    ObserverMgr.a().a(EventType.VALUE.UPDATE_FILTER);
                    return true;
                }
                return true;
            } else if (x > 0.0f && x > 80.0f && Math.abs(f) > Math.abs(f2)) {
                StvLogUtils.a(ShinePresenter.i + " 向左滑...", new Object[0]);
                if (ShinePresenter.this.u.getFrom() != 0 || ShinePresenter.this.r) {
                    return true;
                }
                ShinePresenter.this.i();
                return true;
            } else if (x >= 0.0f || Math.abs(x) <= 80.0f || Math.abs(f) <= Math.abs(f2)) {
                return false;
            } else {
                StvLogUtils.a(ShinePresenter.i + " 向右滑...", new Object[0]);
                if (ShinePresenter.this.u.getFrom() == 0 && ShinePresenter.this.r) {
                    ShinePresenter.this.h();
                    return true;
                }
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (ShinePresenter.this.u.getShowVType() == 2) {
                ShinePresenter.this.D().c();
                return false;
            }
            ShinePresenter.this.p = ((int) motionEvent.getX()) - (ShinePresenter.this.D().f().getWidth() / 2);
            ShinePresenter.this.q = ((int) motionEvent.getY()) - (ShinePresenter.this.D().f().getHeight() / 2);
            ShinePresenter.this.k.manualFocus(ShinePresenter.this.D().f().getWidth(), ShinePresenter.this.D().f().getHeight(), (int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
    };

    /* renamed from: com.blued.android.module.shortvideo.presenter.ShinePresenter$19  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/ShinePresenter$19.class */
    static /* synthetic */ class AnonymousClass19 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:61:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:55:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0085 -> B:51:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0089 -> B:45:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008d -> B:59:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0091 -> B:53:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0095 -> B:49:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0099 -> B:43:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009d -> B:57:0x0070). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            a = iArr;
            try {
                iArr[EventType.VALUE.CONFIG_MUSIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[EventType.VALUE.CONFIG_BEAUTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[EventType.VALUE.CONFIG_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[EventType.VALUE.UPDATE_FILTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[EventType.VALUE.SAVE_FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[EventType.VALUE.CAPTURE_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[EventType.VALUE.SHINE_RECORD.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[EventType.VALUE.SHINE_ENDRECORD.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[EventType.VALUE.SHINE_SPEED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[EventType.VALUE.DELECT_LAST_SECOTION.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.shortvideo.presenter.ShinePresenter$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/ShinePresenter$2.class */
    public class AnonymousClass2 implements PLCaptureFrameListener {
        AnonymousClass2() {
        }

        public void onFrameCaptured(PLVideoFrame pLVideoFrame) {
            IShineView D = ShinePresenter.this.D();
            if (D == null || D.getActivity() == null || D.getActivity().isFinishing()) {
                StvLogUtils.a(ShinePresenter.i + " getView() == null!!!", new Object[0]);
            } else if (pLVideoFrame == null) {
                D.b(false);
                StvLogUtils.b(ShinePresenter.i, "capture frame failed");
            } else {
                if (AppInfo.m()) {
                    String str = ShinePresenter.i;
                    StvLogUtils.c(str, "captured frame width: " + pLVideoFrame.getWidth() + " height: " + pLVideoFrame.getHeight() + " timestamp: " + pLVideoFrame.getTimestampMs());
                }
                VideoFrameModel.getInstance().saveVideoFrameToPicture(pLVideoFrame, new IStvVideoFrameCallback() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.2.1
                    @Override // com.blued.android.module.shortvideo.contract.IStvVideoFrameCallback
                    public void a(Object obj, PLVideoFrame pLVideoFrame2, Bitmap bitmap, final String str2) {
                        final IShineView D2 = ShinePresenter.this.D();
                        if (D2 != null && D2.getActivity() != null && !D2.getActivity().isFinishing()) {
                            D2.a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ShinePresenter.this.u.setFramePath(str2);
                                    D2.b(false);
                                    ShinePresenter.this.l();
                                }
                            });
                            return;
                        }
                        StvLogUtils.a(ShinePresenter.i + " getView() == null!!!", new Object[0]);
                    }
                });
            }
        }
    }

    public ShinePresenter(Bundle bundle, DeleteAutoCheckedListener deleteAutoCheckedListener) {
        this.j = bundle;
        if (deleteAutoCheckedListener != null) {
            this.s = deleteAutoCheckedListener;
        }
    }

    private void F() {
        IShineView D = D();
        if (D != null) {
            Intent intent = new Intent();
            StvResultModel stvResultModel = new StvResultModel();
            stvResultModel.a(false);
            stvResultModel.a(this.u.getFramePath());
            StvLogUtils.a(i + " picturePath = " + this.u.getFramePath(), new Object[0]);
            intent.putExtra("result_model", stvResultModel);
            intent.putExtra("close_page", true);
            D.getActivity().setResult(-1, intent);
            D.getActivity().finish();
        }
    }

    private void G() {
        D().g();
        MusicListProxy.a().b(D().b(), 3);
    }

    private void H() {
        ObserverMgr.a().a(this);
    }

    private void I() {
        ObserverMgr.a().b(this);
    }

    private void J() {
        boolean z = !this.u.isOpenBeauty();
        this.u.setOpenBeauty(z);
        this.t.enableBeautify(z);
    }

    private void K() {
        SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.t;
        if (senseTimeQiniuShortVideoManager != null) {
            senseTimeQiniuShortVideoManager.onResume();
            this.t.enableBeautify(this.u.isOpenBeauty());
            if (this.u.getSelectedFilter() != null) {
                b(this.u.getSelectedFilter(), this.u.getSelectFilterPosition());
            }
        }
    }

    private void L() {
        SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = (SenseTimeQiniuShortVideoManager) SenseTimeFactory.createInstance(D().getContext(), 1);
        this.t = senseTimeQiniuShortVideoManager;
        senseTimeQiniuShortVideoManager.enableBeautify(false);
        SenseConfigData.a(this.t);
        this.k.setCameraPreviewListener(new PLCameraPreviewListener() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.17
            public boolean onPreviewFrame(byte[] bArr, int i2, int i3, int i4, int i5, long j) {
                if (ShinePresenter.this.t != null) {
                    ShinePresenter.this.t.handlePreviewFrame(bArr, i2, i3, i4);
                    return true;
                }
                return true;
            }
        });
        this.k.setVideoFilterListener(new PLVideoFilterListener() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.18
            public int onDrawFrame(int i2, int i3, int i4, long j, float[] fArr) {
                return ShinePresenter.this.t.drawFrame(i2, i3, i4, false);
            }

            public void onSurfaceChanged(int i2, int i3) {
                ShinePresenter.this.t.adjustViewPort(i2, i3);
            }

            public void onSurfaceCreated() {
                ShinePresenter.this.t.onSurfaceCreated();
            }

            public void onSurfaceDestroy() {
                ShinePresenter.this.t.onSurfaceDestroyed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Rect indexRect = this.t.getIndexRect();
        if (motionEvent.getPointerCount() == 1 && action == 0) {
            if (((int) motionEvent.getX()) >= indexRect.left && ((int) motionEvent.getX()) <= indexRect.right && ((int) motionEvent.getY()) >= indexRect.top && ((int) motionEvent.getY()) <= indexRect.bottom) {
                this.t.setIndexRect(((int) motionEvent.getX()) - (indexRect.width() / 2), ((int) motionEvent.getY()) - (indexRect.width() / 2), true);
            }
            this.t.changeCustomEvent();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        StvLogUtils.a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        StvLogUtils.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        D().g();
        D().b(false);
        ObserverMgr.a().a(EventType.VALUE.CONCAT_SECTION_FINISH);
        CommonModel commonModel = new CommonModel();
        commonModel.copyModel(this.u);
        commonModel.setVideoPath(str);
        commonModel.setAddAblum(true);
        commonModel.setCurrentPage(1);
        EditFragment.a(D().b(), commonModel, 2, o(), this.a, this.b, this.s);
    }

    public boolean A() {
        return this.u.isConcatSections();
    }

    public boolean B() {
        return this.k.isFlashSupport();
    }

    @Override // com.blued.android.module.base.http.FeedStateObserverProxy.IFeedStateListener
    public void Y_() {
        StvFragmentManager.a().b();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a() {
        boolean z;
        Bundle bundle = this.j;
        if (bundle == null) {
            bundle = D().getArguments();
            z = false;
        } else {
            z = true;
        }
        if (bundle == null) {
            StvLogUtils.a(i + " bundle == null!!!", new Object[0]);
            b(R.string.common_net_error);
            D().getActivity().finish();
        } else if (!STLicenseUtils.a(D().getContext())) {
            AppMethods.a((CharSequence) "请检查License授权！");
            D().getActivity().finish();
        } else {
            CommonModel commonModel = (CommonModel) bundle.getSerializable("commont_model");
            if (commonModel == null) {
                StvLogUtils.a(i + " commonModel 数据错误！！！", new Object[0]);
                b(R.string.common_net_error);
                D().getActivity().finish();
                return;
            }
            ShineDataModel.SerializableData serializableData = (ShineDataModel.SerializableData) bundle.getSerializable("serializeble_data");
            ShineDataModel shineDataModel = new ShineDataModel();
            this.u = shineDataModel;
            shineDataModel.copyModel(commonModel, serializableData);
            this.a = bundle.getString("delete_auto_checkbox_text");
            this.b = bundle.getInt("delete_auto_number");
            if (o() == 3 || o() == 0) {
                this.r = true;
                this.u.setCurrentPage(5);
            }
            this.u.setFilters(new FilterConfigModel().getFilters());
            this.u.setUseData(Boolean.valueOf(z));
            if (!z) {
                this.u.setOpenBeauty(true);
            }
            String a = UserProxy.b().a();
            if (!TextUtils.isEmpty(a) && (a.equals(String.valueOf(2)) || a.equals(String.valueOf(3)))) {
                this.u.setPrivilegeUser(true);
            }
            if (this.u.isPrivilegeUser()) {
                this.u.setMaxVideoDuration(300000L);
            } else {
                this.u.setMaxVideoDuration(60000L);
            }
            D().a(this.u);
            D().a(o(), m(), n());
            if (this.u.getFrom() == 0 && StvGuideUtils.a()) {
                D().X_();
                StvGuideUtils.b();
            }
            if (!AppInfo.m()) {
                PLShortVideoEnv.setLogLevel(7);
            }
            PLShortVideoRecorder pLShortVideoRecorder = new PLShortVideoRecorder();
            this.k = pLShortVideoRecorder;
            pLShortVideoRecorder.setRecordStateListener(this);
            this.k.setFocusListener(this);
            this.n = new PLCameraSetting();
            PLCameraSetting.CAMERA_FACING_ID a2 = StvCameraUtils.a();
            if (z) {
                a2 = StvCameraUtils.a(this.u.getCurrentCameraId());
            }
            this.n.setCameraId(a2);
            this.n.setCameraPreviewSizeRatio(VideoConfigData.a());
            this.n.setCameraPreviewSizeLevel(VideoConfigData.b());
            this.c = new PLMicrophoneSetting();
            PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(D().getContext());
            this.d = pLVideoEncodeSetting;
            pLVideoEncodeSetting.setPreferredEncodingSize(720, (int) GL10.GL_INVALID_ENUM);
            this.d.setEncodingBitrate(VideoConfigData.c());
            this.d.setEncodingFps(30);
            this.d.setHWCodecEnabled(VideoConfigData.a.booleanValue());
            this.d.setProfileMode(PLVideoEncodeSetting.ProfileMode.HIGH);
            PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
            this.e = pLAudioEncodeSetting;
            pLAudioEncodeSetting.setHWCodecEnabled(false);
            PLRecordSetting pLRecordSetting = new PLRecordSetting();
            this.m = pLRecordSetting;
            pLRecordSetting.setVideoCacheDir(StvConfig.a());
            this.m.setVideoFilepath(StvTools.b());
            this.m.setDisplayMode(PLDisplayMode.FULL);
            this.u.setMaxRecordDuration(15000L);
            this.m.setMaxRecordDuration((long) (this.u.getRecordSpeed() * 15000.0d));
            D().e().setFirstPointPre(this.u.getMinRecordDurationPre());
            D().e().a((Context) D().getActivity(), this.m.getMaxRecordDuration());
            this.k.prepare(D().a(), this.n, this.c, this.d, this.e, this.f, this.m);
            this.k.setRecordSpeed(this.u.getRecordSpeed());
            L();
            this.l = new GestureDetector(D().getContext(), this.v);
            D().a().setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ShinePresenter.this.l.onTouchEvent(motionEvent);
                    return true;
                }
            });
            if (!StringUtils.b(this.u.getMusicPath())) {
                a(this.u.getMusicPath());
            }
            FeedStateObserverProxy.a().a(this);
            StvLogUtils.a(i + "ShinePresenter initV()", new Object[0]);
            if (60 > this.u.getFrom()) {
                StatisticsProxy.a().a("sv_page", (Object) "shoot");
            }
        }
    }

    public void a(double d) {
        this.u.setRecordSpeed(d);
    }

    public void a(int i2) {
        this.u.setShowVType(i2);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Activity activity, int i2, int i3, Intent intent) {
        if (activity != null) {
            if (i3 != -1) {
                if (i2 == 4 && intent != null && intent.getBooleanExtra("close_page", false)) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("music_file_path");
                        StvLogUtils.a(i + "Select file: " + stringExtra, new Object[0]);
                        if (TextUtils.isEmpty(stringExtra)) {
                            return;
                        }
                        a(stringExtra);
                        return;
                    }
                    return;
                } else if (i2 != 4) {
                    if (i2 != 7) {
                        return;
                    }
                    F();
                    return;
                }
            }
            if (intent == null || !intent.getBooleanExtra("close_page", false)) {
                return;
            }
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Bundle bundle) {
        if (bundle != null) {
            CommonModel commonModel = new CommonModel();
            if (this.u != null) {
                commonModel.copyModel(commonModel);
                bundle.putSerializable("commont_model", commonModel);
                if (this.u.getSerializableData() != null) {
                    ShineDataModel.SerializableData serializableData = new ShineDataModel.SerializableData();
                    serializableData.a(this.u.getSerializableData());
                    bundle.putSerializable("serializeble_data", serializableData);
                }
            }
        }
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        switch (AnonymousClass19.a[value.ordinal()]) {
            case 1:
                G();
                return;
            case 2:
                J();
                return;
            case 3:
            default:
                return;
            case 4:
                b(this.u.getSelectedFilter(), this.u.getSelectFilterPosition());
                return;
            case 5:
                this.u.setShowVType(0);
                return;
            case 6:
                k();
                return;
            case 7:
                if (this.u.isRecordCompleted()) {
                    ObserverMgr.a().a(value, false);
                    this.u.setRecording(false);
                    c(this.u.getVideoPath());
                    return;
                }
                boolean p = p();
                this.u.setRecording(p);
                ObserverMgr.a().a(value, p);
                return;
            case 8:
                boolean q = q();
                this.u.setRecording(!q);
                ObserverMgr.a().a(value, q);
                return;
            case 9:
                double recordSpeed = this.u.getRecordSpeed();
                this.m.setMaxRecordDuration((long) (this.u.getMaxRecordDuration() * recordSpeed));
                this.k.setRecordSpeed(recordSpeed);
                D().e().a((Context) D().getActivity(), this.m.getMaxRecordDuration());
                return;
            case 10:
                boolean s = s();
                if (!s) {
                    StvLogUtils.a("回删视频段失败", new Object[0]);
                    b(R.string.common_net_error);
                }
                ObserverMgr.a().a(value, s);
                return;
        }
    }

    public void a(FilterItem filterItem, int i2) {
        this.u.setSelectedFilter(filterItem);
        this.u.setSelectFilterPosition(i2);
    }

    public void a(String str) {
        this.u.setHasBgMusic(true);
        this.u.setMusicPath(str);
        this.k.setMusicFile(str);
    }

    public boolean a(boolean z) {
        return this.k.setFlashEnabled(z);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void b() {
        StvLogUtils.a(i + "destroy()", new Object[0]);
        FeedStateObserverProxy.a().b(this);
        I();
        PLShortVideoRecorder pLShortVideoRecorder = this.k;
        if (pLShortVideoRecorder != null) {
            pLShortVideoRecorder.destroy();
        }
        SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.t;
        if (senseTimeQiniuShortVideoManager != null) {
            senseTimeQiniuShortVideoManager.onDestroy();
        }
        ShineDataModel shineDataModel = this.u;
        if (shineDataModel != null) {
            shineDataModel.clear();
        }
    }

    public void b(FilterItem filterItem, int i2) {
        if (filterItem != null) {
            if (filterItem.b() != null) {
                this.t.setFilterStyle(filterItem.b());
            } else {
                this.t.setFilterStyle(null);
            }
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void c() {
        StvLogUtils.a(i + "resume()", new Object[0]);
        H();
        this.k.resume();
        K();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void d() {
        SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.t;
        if (senseTimeQiniuShortVideoManager != null) {
            senseTimeQiniuShortVideoManager.onStop();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void e() {
        StvLogUtils.a(i + "pause()", new Object[0]);
        this.k.pause();
        SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.t;
        if (senseTimeQiniuShortVideoManager != null) {
            senseTimeQiniuShortVideoManager.onPause();
        }
        I();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void f() {
        SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.t;
        if (senseTimeQiniuShortVideoManager != null) {
            senseTimeQiniuShortVideoManager.onStart();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public boolean g() {
        ShineDataModel shineDataModel;
        if (D() == null || (shineDataModel = this.u) == null) {
            return false;
        }
        int showVType = shineDataModel.getShowVType();
        if (showVType == 2) {
            D().c();
            this.u.setShowVType(0);
            return true;
        } else if (showVType != 5) {
            if (D().e().i()) {
                D().h_(0);
                return true;
            }
            u();
            D().getActivity().finish();
            return false;
        } else {
            return true;
        }
    }

    public void h() {
        this.u.setCurrentPage(1);
        this.r = false;
        IShineView D = D();
        if (D != null && D.getActivity() != null && !D.getActivity().isFinishing()) {
            D.a(o(), m(), n());
            return;
        }
        StvLogUtils.a(i + " getView() == null!!!", new Object[0]);
    }

    public void i() {
        this.u.setCurrentPage(5);
        this.r = true;
        IShineView D = D();
        if (D != null && D.getActivity() != null && !D.getActivity().isFinishing()) {
            D.a(o(), m(), n());
            return;
        }
        StvLogUtils.a(i + " getView() == null!!!", new Object[0]);
    }

    public void j() {
        if (m() == 2) {
            D().getActivity().finish();
        } else {
            AlbumProxy.a().a(D().b(), this.u.getFrom(), 1, 4);
        }
    }

    public void k() {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().b(true);
            this.k.captureFrame(new AnonymousClass2());
            return;
        }
        StvLogUtils.a(i + " getView() == null!!!", new Object[0]);
    }

    public void l() {
        IShineView D = D();
        if (D != null && D.getActivity() != null && !D.getActivity().isFinishing()) {
            PhotoPreviewFragment.a(D.b(), this.u.getFramePath(), 7);
            return;
        }
        StvLogUtils.d(i + " getView() == null!!!", new Object[0]);
    }

    public int m() {
        return this.u.getPrePageType();
    }

    public int n() {
        return this.u.getCurrentPage();
    }

    public int o() {
        return this.u.getFrom();
    }

    public void onAutoFocusStart() {
        StvLogUtils.a(i + "auto focus start", new Object[0]);
    }

    public void onAutoFocusStop() {
        StvLogUtils.a(i + "auto focus stop", new Object[0]);
    }

    public void onDurationTooShort() {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.5
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.b(R.string.stv_upload_video_time_too_short);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null!!!", new Object[0]);
    }

    public void onError(int i2) {
        if (i2 == 4) {
            this.o = "摄像头配置错误";
        } else if (i2 == 5) {
            this.o = "麦克风配置错误";
        }
        if (!TextUtils.isEmpty(this.o)) {
            StvLogUtils.a(this.o, new Object[0]);
        }
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.4
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.b(R.string.common_net_error);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null!!!", new Object[0]);
    }

    public void onManualFocusCancel() {
        StvLogUtils.a(i + "manual focus canceled", new Object[0]);
        D().f().d();
    }

    public void onManualFocusStart(boolean z) {
        if (!z) {
            D().f().d();
            StvLogUtils.a(i + "manual focus not supported", new Object[0]);
            return;
        }
        StvLogUtils.a(i + "manual focus begin success", new Object[0]);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) D().f().getLayoutParams();
        layoutParams.leftMargin = this.p;
        layoutParams.topMargin = this.q;
        D().f().setLayoutParams(layoutParams);
        D().f().a();
    }

    public void onManualFocusStop(boolean z) {
        StvLogUtils.a(i + "manual focus end result: " + z, new Object[0]);
        if (z) {
            D().f().b();
        } else {
            D().f().c();
        }
    }

    public void onProgressUpdate(final float f) {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.11
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.D().a(f);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onReady() {
        StvLogUtils.a(i + "onReady()", new Object[0]);
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.D().d();
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null!!!", new Object[0]);
    }

    public void onRecordCompleted() {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            this.k.concatSections(this);
            this.u.setRecordCompleted(true);
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.10
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.D().b(false);
                    ShinePresenter.this.D().c(true);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onRecordStarted() {
        StvLogUtils.a(i + "record start time: " + System.currentTimeMillis(), new Object[0]);
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.6
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.D().e().setCurrentState(SectionProgressBar.State.START);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onRecordStopped() {
        StvLogUtils.a(i + "record stop time: " + System.currentTimeMillis(), new Object[0]);
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.7
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.D().e().setCurrentState(SectionProgressBar.State.PAUSE);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onSaveVideoCanceled() {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.13
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.D().c(false);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onSaveVideoFailed(final int i2) {
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.12
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.D().c(false);
                    String string = ShinePresenter.this.D().getContext().getString(R.string.stv_video_progress_error);
                    StvLogUtils.a(string + " :" + i2, new Object[0]);
                    ShinePresenter.this.b(string);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onSaveVideoSuccess(final String str) {
        StvLogUtils.a(i + "concat sections success filePath: " + str, new Object[0]);
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.14
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.D().c(false);
                    ShinePresenter.this.u.setVideoPath(str);
                    ShinePresenter.this.c(str);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onSectionDecreased(long j, final long j2, final int i2) {
        StvLogUtils.a(i + "section decreased decDuration: " + j + " totalDuration: " + j2 + " sectionCount: " + i2, new Object[0]);
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.9
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.u.onSectionCountChanged(j2, i2);
                    if (j2 <= 0) {
                        ShinePresenter.this.u.setMusicPath(null);
                        ShinePresenter.this.m.setVideoFilepath(StvTools.b());
                    }
                    ShinePresenter.this.D().a(i2, j2, false);
                    ShinePresenter.this.D().e().g();
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onSectionIncreased(long j, final long j2, final int i2) {
        StvLogUtils.a(i + "section increased incDuration: " + j + " totalDuration: " + j2 + " sectionCount: " + i2, new Object[0]);
        if (D() != null && D().getActivity() != null && !D().getActivity().isFinishing()) {
            D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.8
                @Override // java.lang.Runnable
                public void run() {
                    ShinePresenter.this.u.onSectionCountChanged(j2, i2);
                    ShinePresenter.this.D().a(i2, j2, true);
                    ShinePresenter.this.D().e().a(j2);
                }
            });
            return;
        }
        StvLogUtils.a(i + " getView() == null", new Object[0]);
    }

    public void onSectionRecording(long j, long j2, int i2) {
        StvLogUtils.a(i + "section recording sectionDurationMs: " + j + " videoDurationMs: " + j2 + " sectionCount: " + i2, new Object[0]);
    }

    public boolean p() {
        boolean beginSection = this.k.beginSection();
        this.u.setBeginSection(beginSection);
        if (beginSection) {
            ShineDataModel shineDataModel = this.u;
            shineDataModel.setMusicPath(shineDataModel.getMusicPath());
        }
        return beginSection;
    }

    public boolean q() {
        boolean endSection = this.k.endSection();
        if (endSection) {
            this.u.setBeginSection(false);
        }
        return endSection;
    }

    public boolean r() {
        boolean deleteAllSections = this.k.deleteAllSections();
        if (deleteAllSections) {
            this.u.setRecordCompleted(false);
            this.u.onSectionCountChanged(0L, 0);
            this.u.setMusicPath(null);
            this.m.setVideoFilepath(StvTools.b());
            D().e().h();
            D().a(0, 0L, false);
        }
        return deleteAllSections;
    }

    public boolean s() {
        boolean deleteLastSection = this.k.deleteLastSection();
        if (deleteLastSection) {
            this.u.setRecordCompleted(false);
        }
        return deleteLastSection;
    }

    public void t() {
        this.k.concatSections(this);
    }

    public void u() {
        this.k.cancelConcat();
    }

    public void v() {
        final String videoPath = this.u.getVideoPath();
        StvThreadPoolHelper.a().a((Runnable) new StvThreadPoolHelper.StvThread(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.ShinePresenter.15
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(videoPath)) {
                    return;
                }
                File file = new File(videoPath);
                if (file.exists()) {
                    file.delete();
                }
            }
        }));
    }

    public void w() {
        this.k.switchCamera();
        SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.t;
        if (senseTimeQiniuShortVideoManager != null) {
            senseTimeQiniuShortVideoManager.switchCamera();
        }
        this.u.setCurrentCameraId(StvCameraUtils.a(this.n.getCameraId()));
    }

    public long x() {
        return this.u.getMinRecordDuration();
    }

    public double y() {
        return this.u.getRecordSpeed();
    }

    public boolean z() {
        return this.u.isRecordSection();
    }
}
