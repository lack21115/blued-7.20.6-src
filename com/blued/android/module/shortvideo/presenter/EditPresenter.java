package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppMethods;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.base.shortvideo.MusicListProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.base.user.UserProxy;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeQiniuEditVideoManager;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IEditView;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.model.FilterConfigModel;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.model.VideoFrameModel;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvMediaUtils;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.utils.VideoConfigData;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEditor;
import com.qiniu.pili.droid.shortvideo.PLVideoEditSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.File;
import java.io.IOException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/EditPresenter.class */
public class EditPresenter extends ShortVideoBasePresent<IEditView> implements EventObserver, PLVideoSaveListener {
    private static final String f = EditPresenter.class.getSimpleName();
    private PLShortVideoEditor i;
    private SenseTimeQiniuEditVideoManager j;
    private SenseTimeQiniuEditVideoManager k;
    private GestureDetector l;
    private Bundle m;
    private EditDataModel n;

    /* renamed from: a  reason: collision with root package name */
    public int f15787a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f15788c = 0;
    private GestureDetector.OnGestureListener o = new GestureDetector.OnGestureListener() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.7
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            float x = motionEvent.getX() - motionEvent2.getX();
            float y = motionEvent.getY() - motionEvent2.getY();
            int i = 0;
            if (y > 0.0f && y > 80.0f && Math.abs(f3) > Math.abs(f2)) {
                StvLogUtils.a(EditPresenter.f + " 向上滑...", new Object[0]);
                if (EditPresenter.this.n.getSerializableData().getPrePageType() == 3) {
                    int selectFilterPosition = EditPresenter.this.n.getSerializableData().getSelectFilterPosition() + 1;
                    if (selectFilterPosition < EditPresenter.this.n.getSerializableData().getFilters().size()) {
                        i = selectFilterPosition;
                    }
                    FilterItem filterItem = EditPresenter.this.n.getSerializableData().getFilters().get(i);
                    if (EditPresenter.this.n.getSerializableData().getFrom() < 60) {
                        StatisticsProxy.a().a("sv_filter_click", i);
                    }
                    EditPresenter.this.a(filterItem, i);
                    EditPresenter.this.b(filterItem, i);
                    ObserverMgr.a().a(EventType.VALUE.UPDATE_FILTER);
                    return true;
                }
            }
            if (y < 0.0f && Math.abs(y) > 80.0f && Math.abs(f3) > Math.abs(f2)) {
                StvLogUtils.a(EditPresenter.f + " 向下滑...", new Object[0]);
                if (EditPresenter.this.n.getSerializableData().getPrePageType() == 3) {
                    int selectFilterPosition2 = EditPresenter.this.n.getSerializableData().getSelectFilterPosition() - 1;
                    int i2 = selectFilterPosition2;
                    if (selectFilterPosition2 < 0) {
                        i2 = EditPresenter.this.n.getSerializableData().getFilters().size() - 1;
                    }
                    FilterItem filterItem2 = EditPresenter.this.n.getSerializableData().getFilters().get(i2);
                    if (EditPresenter.this.n.getSerializableData().getFrom() < 60) {
                        StatisticsProxy.a().a("sv_filter_click", i2);
                    }
                    EditPresenter.this.a(filterItem2, i2);
                    EditPresenter.this.b(filterItem2, i2);
                    ObserverMgr.a().a(EventType.VALUE.UPDATE_FILTER);
                    return true;
                }
            }
            if (x > 0.0f && x > 80.0f && Math.abs(f2) > Math.abs(f3)) {
                StvLogUtils.a(EditPresenter.f + " 向左滑...", new Object[0]);
                return true;
            } else if (x >= 0.0f || Math.abs(x) <= 80.0f || Math.abs(f2) <= Math.abs(f3)) {
                return false;
            } else {
                StvLogUtils.a(EditPresenter.f + " 向右滑...", new Object[0]);
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IEditView D = EditPresenter.this.D();
            if (D != null) {
                int showVType = EditPresenter.this.n.getSerializableData().getShowVType();
                if (showVType == 2) {
                    D.c();
                    return false;
                } else if (showVType == 3) {
                    D.e();
                    return false;
                } else if (showVType != 4) {
                    return false;
                } else {
                    D.d();
                    return false;
                }
            }
            return false;
        }
    };
    PLVideoFilterListener d = new PLVideoFilterListener() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.8
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public int onDrawFrame(int i, int i2, int i3, long j, float[] fArr) {
            return EditPresenter.this.k.drawFrame(i, i2, i3, false);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceChanged(int i, int i2) {
            EditPresenter.this.k.adjustViewPort(i, i2);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceCreated() {
            EditPresenter.this.k.onSurfaceCreated();
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceDestroy() {
            EditPresenter.this.k.onSurfaceDestroyed();
        }
    };
    PLVideoFilterListener e = new PLVideoFilterListener() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.9
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public int onDrawFrame(int i, int i2, int i3, long j, float[] fArr) {
            return EditPresenter.this.j.drawFrame(i, i2, i3, false);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceChanged(int i, int i2) {
            EditPresenter.this.j.adjustViewPort(i, i2);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceCreated() {
            EditPresenter.this.j.onSurfaceCreated();
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceDestroy() {
            EditPresenter.this.j.onSurfaceDestroyed();
        }
    };

    /* renamed from: com.blued.android.module.shortvideo.presenter.EditPresenter$10  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/EditPresenter$10.class */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15790a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            f15790a = iArr;
            try {
                iArr[EventType.VALUE.CONFIG_MUSIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15790a[EventType.VALUE.UPDATE_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15790a[EventType.VALUE.EDIT_FINISH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15790a[EventType.VALUE.CONFIG_COVER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15790a[EventType.VALUE.HIDE_COVER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public EditPresenter(Bundle bundle) {
        this.m = bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (D() != null) {
            AppMethods.d(R.string.common_net_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        IEditView D = D();
        if (D != null) {
            Intent intent = new Intent();
            StvResultModel stvResultModel = new StvResultModel();
            stvResultModel.a(true);
            stvResultModel.b(this.n.getCoverImgPath());
            StvLogUtils.a(f + " coverImagePath = " + this.n.getCoverImgPath(), new Object[0]);
            stvResultModel.c(this.n.getSaveVideoPath());
            stvResultModel.a(this.n.getSaveVideoWidth());
            stvResultModel.b(this.n.getSaveVideoHeight());
            stvResultModel.a(this.n.getSaveDurationMs());
            stvResultModel.b(this.n.getVideoSize());
            stvResultModel.d(this.n.getSerializableData().getMusicId());
            stvResultModel.c(this.n.getSerializableData().getSelectFilterPosition());
            if (t() == 1 || t() == 61 || t() == 7) {
                stvResultModel.b(u());
            }
            intent.putExtra("result_model", stvResultModel);
            intent.putExtra("close_page", true);
            intent.putExtra("serializeble_data", this.n.getSerializableData());
            D.getActivity().setResult(-1, intent);
            D.getActivity().finish();
        }
    }

    private void G() {
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = (SenseTimeQiniuEditVideoManager) SenseTimeFactory.createInstance(D().getContext(), 2);
        this.j = senseTimeQiniuEditVideoManager;
        senseTimeQiniuEditVideoManager.enableBeautify(false);
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager2 = (SenseTimeQiniuEditVideoManager) SenseTimeFactory.createInstance(D().getContext(), 2);
        this.k = senseTimeQiniuEditVideoManager2;
        senseTimeQiniuEditVideoManager2.enableBeautify(false);
    }

    private void H() {
        ObserverMgr.a().a(this);
    }

    private void I() {
        ObserverMgr.a().b(this);
    }

    private void a(long j) {
        this.n.setCurrentCoverTime(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FilterItem filterItem, int i) {
        if (filterItem != null) {
            if (filterItem.b() != null) {
                this.j.setFilterStyle(filterItem.b());
                this.k.setFilterStyle(filterItem.b());
                return;
            }
            this.j.setFilterStyle(null);
            this.k.setFilterStyle(null);
        }
    }

    private void b(final String str) {
        IEditView D = D();
        if (D == null || D.getActivity() == null) {
            return;
        }
        final String videoPath = this.n.getSerializableData().getVideoPath();
        final String needDeleteVideoPath = this.n.getNeedDeleteVideoPath();
        final boolean isCanDeleteVideoFile = this.n.getSerializableData().isCanDeleteVideoFile();
        StvThreadPoolHelper.a().a((Runnable) new StvThreadPoolHelper.StvThread(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                if (isCanDeleteVideoFile && !TextUtils.isEmpty(videoPath) && !videoPath.equals(EditPresenter.this.n.getSerializableData().getOriginalVideoPath()) && !videoPath.equals(str)) {
                    File file = new File(videoPath);
                    if (file.exists()) {
                        Log.d("StvMediaUtils", "5 delete file videoPath" + videoPath);
                        file.delete();
                    }
                }
                if (TextUtils.isEmpty(needDeleteVideoPath) || needDeleteVideoPath.equals(EditPresenter.this.n.getSerializableData().getOriginalVideoPath()) || videoPath.equals(str)) {
                    return;
                }
                File file2 = new File(needDeleteVideoPath);
                if (file2.exists()) {
                    Log.d("StvMediaUtils", "6 delete file videoPath" + videoPath);
                    file2.delete();
                }
            }
        }));
        if (this.n.getSerializableData().isAddAblum()) {
            StvMediaUtils.a(D.getContext(), str);
        }
        this.n.setSaveVideoPath(str);
        this.n.getSerializableData().setMusicPath(this.n.getSerializableData().getMusicPath());
        VideoFrameModel.getInstance().saveVideoFrameByTime(this.n.getSaveVideoPath(), this.n.getCurrentCoverTime(), new IStvVideoFrameForTimeCallback() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.6
            @Override // com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback
            public void a(final String str2) {
                IEditView D2 = EditPresenter.this.D();
                if (D2 != null && D2.getActivity() != null && !D2.getActivity().isFinishing()) {
                    D2.a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IEditView D3 = EditPresenter.this.D();
                            if (D3 != null) {
                                D3.c(false);
                                EditPresenter.this.n.setCoverImgPath(str2);
                                EditPresenter.this.F();
                            }
                        }
                    });
                    return;
                }
                StvLogUtils.a(EditPresenter.f + " getView() == null!!!", new Object[0]);
            }
        });
    }

    public long A() {
        return this.n.getDurationMs();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a() {
        boolean z;
        File file;
        IEditView D = D();
        if (D != null) {
            Bundle bundle = this.m;
            if (bundle == null) {
                bundle = D.getArguments();
                z = false;
            } else {
                z = true;
            }
            if (bundle == null) {
                StvLogUtils.a(f + "EditPresenter bundle == null!!!", new Object[0]);
                C();
                D.getActivity().finish();
            } else if (!STLicenseUtils.a(D().getContext())) {
                AppMethods.a((CharSequence) "请检查License授权！");
                D().getActivity().finish();
            } else {
                this.f15787a = bundle.getInt("from");
                this.b = bundle.getString("delete_auto_checkbox_text");
                this.f15788c = bundle.getInt("delete_auto_number");
                CommonModel commonModel = (CommonModel) bundle.getSerializable("commont_model");
                EditDataModel.SerializableData serializableData = (EditDataModel.SerializableData) bundle.getSerializable("serializeble_data");
                if (commonModel == null && serializableData == null) {
                    StvLogUtils.a(f + "EditPresenter commonModel 数据错误！！！", new Object[0]);
                    C();
                    D.getActivity().finish();
                    return;
                }
                if (commonModel == null || TextUtils.isEmpty(commonModel.getVideoPath())) {
                    file = null;
                    if (serializableData != null) {
                        file = null;
                        if (!TextUtils.isEmpty(serializableData.getVideoPath())) {
                            file = new File(serializableData.getVideoPath());
                        }
                    }
                } else {
                    file = new File(commonModel.getVideoPath());
                }
                if (file == null || !file.exists()) {
                    C();
                    D.getActivity().finish();
                    return;
                }
                EditDataModel editDataModel = new EditDataModel();
                this.n = editDataModel;
                editDataModel.copyModel(commonModel, serializableData);
                this.n.setScreenWidth(D.getContext().getResources().getDisplayMetrics().widthPixels);
                this.n.getSerializableData().setUseData(Boolean.valueOf(z));
                this.n.getSerializableData().setFilters(new FilterConfigModel().getFilters());
                String a2 = UserProxy.b().a();
                if (!TextUtils.isEmpty(a2) && (a2.equals(String.valueOf(2)) || a2.equals(String.valueOf(3)))) {
                    this.n.getSerializableData().setPrivilegeUser(true);
                }
                String videoPath = this.n.getSerializableData().getVideoPath();
                StvLogUtils.a(f + "editing file: " + videoPath, new Object[0]);
                int videoWidth = this.n.getVideoWidth();
                int videoHeight = this.n.getVideoHeight();
                int i = D.getContext().getResources().getDisplayMetrics().widthPixels;
                int i2 = (int) (((((float) i) * 1.0f) / ((float) videoWidth)) * ((float) videoHeight));
                ViewGroup.LayoutParams layoutParams = D.a().getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                D.a().setLayoutParams(layoutParams);
                PLVideoEditSetting pLVideoEditSetting = new PLVideoEditSetting();
                pLVideoEditSetting.setSourceFilepath(videoPath);
                pLVideoEditSetting.setDestFilepath(StvTools.c());
                PLShortVideoEditor pLShortVideoEditor = new PLShortVideoEditor(D.a(), pLVideoEditSetting);
                this.i = pLShortVideoEditor;
                pLShortVideoEditor.setDisplayMode(PLDisplayMode.FULL);
                if (s() == 3 && this.n.isTranscode()) {
                    EditDataModel editDataModel2 = this.n;
                    editDataModel2.calculateEncodingSize(editDataModel2.getVideoBitrate(), this.n.getVideoWidth(), this.n.getVideoHeight());
                    PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(D.getContext());
                    pLVideoEncodeSetting.setEncodingBitrate(this.n.getEncodingVideoBitrate());
                    pLVideoEncodeSetting.setEncodingBitrateMode(PLVideoEncodeSetting.BitrateMode.QUALITY_PRIORITY);
                    pLVideoEncodeSetting.setEncodingFps(30);
                    pLVideoEncodeSetting.setPreferredEncodingSize(this.n.getEncodingW(), this.n.getEncodingH());
                    pLVideoEncodeSetting.setHWCodecEnabled(VideoConfigData.f15874a.booleanValue());
                    this.i.setVideoEncodeSetting(pLVideoEncodeSetting);
                }
                this.i.setVideoSaveListener(this);
                c(false);
                try {
                    AssetFileDescriptor openFd = D.getActivity().getAssets().openFd(EditDataModel.DEFAULT_MUTE_AUDIO_NAME);
                    if (openFd != null) {
                        this.i.setAudioMixAsset(openFd);
                    }
                    a(k(), j() ? l() : 0);
                } catch (IOException e) {
                    StvLogUtils.a(f + "读取 " + EditDataModel.DEFAULT_MUTE_AUDIO_NAME + " IOException", new Object[0]);
                }
                G();
                this.l = new GestureDetector(D.getContext(), this.o);
                D.a().setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        EditPresenter.this.l.onTouchEvent(motionEvent);
                        return true;
                    }
                });
                if (z) {
                    if (s() == 3) {
                        a(this.n.getSerializableData().getMusicPath());
                        b(this.n.getSerializableData().getSelectedFilter(), this.n.getSerializableData().getSelectFilterPosition());
                    } else if (!i()) {
                        a(this.n.getSerializableData().getMusicPath());
                    }
                }
                EditDataModel editDataModel3 = this.n;
                editDataModel3.setSaveVideoPath(editDataModel3.getSerializableData().getVideoPath());
                D.a(this.n.getSerializableData());
                D.a(t(), s(), n());
            }
        }
    }

    public void a(int i) {
        this.i.seekTo(i);
        if (this.n.getSerializableData().getShowVType() == 3) {
            this.i.resumePlayback();
            this.i.pausePlayback();
        }
    }

    public void a(int i, int i2) {
        this.n.setCurrentFgVolume(i);
        this.n.setCurrentBgVolume(i2);
        PLShortVideoEditor pLShortVideoEditor = this.i;
        if (pLShortVideoEditor != null) {
            pLShortVideoEditor.setAudioMixVolume(i / 100.0f, i2 / 100.0f);
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 3) {
            String stringExtra = intent.getStringExtra("music_file_path");
            StvLogUtils.a(f + "Select file: " + stringExtra, new Object[0]);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            a(stringExtra);
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Bundle bundle) {
        if (bundle == null || this.n == null) {
            return;
        }
        CommonModel commonModel = new CommonModel();
        commonModel.copyModel(this.n.getSerializableData());
        bundle.putSerializable("commont_model", commonModel);
        if (this.n.getSerializableData() != null) {
            EditDataModel.SerializableData serializableData = new EditDataModel.SerializableData();
            serializableData.a(this.n.getSerializableData());
            bundle.putSerializable("serializeble_data", serializableData);
        }
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        int i = AnonymousClass10.f15790a[value.ordinal()];
        if (i == 1) {
            m();
        } else if (i == 2) {
            b(this.n.getSerializableData().getSelectedFilter(), this.n.getSerializableData().getSelectFilterPosition());
        } else if (i != 3) {
            if (i == 4) {
                a((int) this.n.getCurrentCoverTime());
                p();
            } else if (i != 5) {
            } else {
                o();
            }
        } else if (t() == 2) {
            F();
        } else if (t() == 4 || t() == 0 || t() == 1 || t() == 7 || t() == 61 || t() == 60) {
            h();
        } else {
            b(this.d);
        }
    }

    public void a(FilterItem filterItem, int i) {
        this.n.getSerializableData().setSelectedFilter(filterItem);
        this.n.getSerializableData().setSelectFilterPosition(i);
    }

    public void a(PLVideoFilterListener pLVideoFilterListener) {
        this.i.startPlayback(pLVideoFilterListener);
    }

    public void a(String str) {
        this.n.getSerializableData().setHasBgMusic(true);
        this.n.getSerializableData().setMusicPath(str);
        this.i.setAudioMixFile(str);
        a(this.n.getCurrentFgVolume(), 100);
    }

    public void a(boolean z) {
        this.i.setPlaybackLoop(z);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void b() {
        I();
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.j;
        if (senseTimeQiniuEditVideoManager != null) {
            senseTimeQiniuEditVideoManager.onDestroy();
        }
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager2 = this.k;
        if (senseTimeQiniuEditVideoManager2 != null) {
            senseTimeQiniuEditVideoManager2.onDestroy();
        }
    }

    public void b(int i) {
        EditDataModel editDataModel = this.n;
        if (editDataModel != null) {
            editDataModel.getSerializableData().setShowVType(i);
        }
    }

    public void b(PLVideoFilterListener pLVideoFilterListener) {
        p();
        q();
        this.i.save(pLVideoFilterListener);
    }

    public void b(boolean z) {
        this.i.setAudioMixLooping(z);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void c() {
        H();
        b(true);
        a(true);
        if (this.n.getSerializableData().getShowVType() != 3) {
            o();
            a(this.e);
        }
        a(k(), j() ? l() : 0);
    }

    public void c(int i) {
        int x = i - x();
        int i2 = x;
        if (x < 0) {
            i2 = 0;
        }
        int i3 = i2;
        if (i2 > w()) {
            i3 = w();
        }
        a(Math.round(((i3 * 1.0f) / w()) * ((float) A())));
    }

    public void c(boolean z) {
        this.i.muteOriginAudio(z);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void d() {
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.j;
        if (senseTimeQiniuEditVideoManager != null) {
            senseTimeQiniuEditVideoManager.onStop();
        }
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager2 = this.k;
        if (senseTimeQiniuEditVideoManager2 != null) {
            senseTimeQiniuEditVideoManager2.onStop();
        }
    }

    public void d(int i) {
        this.n.setCoverVLenght(i);
    }

    public void d(boolean z) {
        this.n.setAutoDelete(z);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void e() {
        p();
        q();
        I();
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.j;
        if (senseTimeQiniuEditVideoManager != null) {
            senseTimeQiniuEditVideoManager.onPause();
        }
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager2 = this.k;
        if (senseTimeQiniuEditVideoManager2 != null) {
            senseTimeQiniuEditVideoManager2.onPause();
        }
        this.n.setCoverImgPath(null);
    }

    public void e(int i) {
        this.n.setCoverStartPositon(i);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void f() {
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.j;
        if (senseTimeQiniuEditVideoManager != null) {
            senseTimeQiniuEditVideoManager.onStart();
        }
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager2 = this.k;
        if (senseTimeQiniuEditVideoManager2 != null) {
            senseTimeQiniuEditVideoManager2.onStart();
        }
    }

    public void f(int i) {
        this.n.setCoverEndPosition(i);
    }

    public void g(int i) {
        this.n.setCoverCurrentLeftPosition(i);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public boolean g() {
        return false;
    }

    public void h() {
        StvThreadPoolHelper.a().a((Runnable) new StvThreadPoolHelper.StvThread(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                VideoFrameModel.getInstance().saveVideoFrameByTime(EditPresenter.this.n.getSerializableData().getVideoPath(), EditPresenter.this.n.getCurrentCoverTime(), new IStvVideoFrameForTimeCallback() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.4.1
                    @Override // com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback
                    public void a(String str) {
                        EditPresenter.this.n.setCoverImgPath(str);
                        EditPresenter.this.F();
                    }
                });
            }
        }));
    }

    public void h(int i) {
        this.n.getSerializableData().setShowVType(i);
    }

    public boolean i() {
        return this.n.getSerializableData().isAddMusic();
    }

    public boolean j() {
        return this.n.getSerializableData().isHasBgMusic();
    }

    public int k() {
        return this.n.getCurrentFgVolume();
    }

    public int l() {
        return this.n.getCurrentBgVolume();
    }

    public void m() {
        IEditView D = D();
        if (D != null) {
            D.g();
            if (this.n.getSerializableData().getPrePageType() == 3) {
                MusicListProxy.a().a(D.b(), 3);
            } else {
                MusicListProxy.a().b(D.b(), 3);
            }
        }
    }

    public int n() {
        return this.n.getSerializableData().getCurrentPage();
    }

    public void o() {
        this.i.resumePlayback();
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
    public void onProgressUpdate(float f2) {
        IEditView D = D();
        if (D != null && D.b() != null && D.b().isAdded()) {
            D.a((f2 / 2.0f) + 0.5f);
            return;
        }
        StvLogUtils.a(f + " getView() == null!!!", new Object[0]);
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
    public void onSaveVideoCanceled() {
        StvLogUtils.a(f + " 转码取消", new Object[0]);
        IEditView D = D();
        if (D != null && D.getActivity() != null && !D.getActivity().isFinishing()) {
            D.a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    IEditView D2 = EditPresenter.this.D();
                    if (D2 != null) {
                        D2.c(false);
                        EditPresenter.this.C();
                    }
                }
            });
            return;
        }
        StvLogUtils.a(f + " getView() == null!!!", new Object[0]);
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
    public void onSaveVideoFailed(final int i) {
        StvLogUtils.a(f + " 转码失败 errorCode:" + i, new Object[0]);
        IEditView D = D();
        if (D != null && D.getActivity() != null && !D.getActivity().isFinishing()) {
            D.a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.EditPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    IEditView D2 = EditPresenter.this.D();
                    if (D2 != null) {
                        D2.c(false);
                    }
                    EditPresenter.this.C();
                    int i2 = i;
                    if (i2 == 13) {
                        StvLogUtils.a(EditPresenter.f + "该文件没有视频信息！", new Object[0]);
                    } else if (i2 == 14) {
                        StvLogUtils.a(EditPresenter.f + "源文件路径和目标路径不能相同！", new Object[0]);
                    } else if (i2 != 16) {
                    } else {
                        StvLogUtils.a(EditPresenter.f + "当前机型暂不支持该功能", new Object[0]);
                    }
                }
            });
            return;
        }
        StvLogUtils.a(f + " getView() == null!!!", new Object[0]);
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
    public void onSaveVideoSuccess(String str) {
        StvLogUtils.a(f + " 转码成功 succes | path:" + str, new Object[0]);
        IEditView D = D();
        if (D == null || D.getActivity() == null || D.getActivity().isFinishing()) {
            StvLogUtils.a(f + " getView() == null!!!", new Object[0]);
            return;
        }
        if (this.n.getSerializableData().getVideoPath().equals(str) || str.equals(this.n.getSerializableData().getOriginalVideoPath())) {
            this.n.getSerializableData().setCanDeleteVideoFile(false);
        } else {
            this.n.getSerializableData().setCanDeleteVideoFile(true);
        }
        b(str);
    }

    public void p() {
        this.i.pausePlayback();
    }

    public void q() {
        this.i.stopPlayback();
    }

    public int r() {
        EditDataModel editDataModel = this.n;
        if (editDataModel != null) {
            return editDataModel.getSerializableData().getShowVType();
        }
        return 0;
    }

    public int s() {
        return this.n.getSerializableData().getPrePageType();
    }

    public int t() {
        return this.n.getSerializableData().getFrom();
    }

    public boolean u() {
        return this.n.isAutoDelete();
    }

    public long v() {
        return this.n.getCurrentCoverTime();
    }

    public int w() {
        return this.n.getCoverVLenght();
    }

    public int x() {
        return this.n.getCoverStartPositon();
    }

    public int y() {
        return this.n.getCoverCurrentLeftPosition();
    }

    public String z() {
        return this.n.getSerializableData().getVideoPath();
    }
}
