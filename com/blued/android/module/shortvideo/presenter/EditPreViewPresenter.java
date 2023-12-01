package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.blued.android.core.AppMethods;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeQiniuEditVideoManager;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IBaseView;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEditor;
import com.qiniu.pili.droid.shortvideo.PLVideoEditSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import java.io.File;
import java.io.IOException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/EditPreViewPresenter.class */
public class EditPreViewPresenter extends ShortVideoBasePresent<IBaseView> {
    private static final String b = EditPreViewPresenter.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    PLVideoFilterListener f15782a = new PLVideoFilterListener() { // from class: com.blued.android.module.shortvideo.presenter.EditPreViewPresenter.2
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public int onDrawFrame(int i, int i2, int i3, long j, float[] fArr) {
            return EditPreViewPresenter.this.d.drawFrame(i, i2, i3, false);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceChanged(int i, int i2) {
            EditPreViewPresenter.this.d.adjustViewPort(i, i2);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceCreated() {
            EditPreViewPresenter.this.d.onSurfaceCreated();
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceDestroy() {
            EditPreViewPresenter.this.d.onSurfaceDestroyed();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private PLShortVideoEditor f15783c;
    private SenseTimeQiniuEditVideoManager d;
    private Bundle e;
    private EditDataModel f;

    /* renamed from: com.blued.android.module.shortvideo.presenter.EditPreViewPresenter$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/EditPreViewPresenter$1.class */
    class AnonymousClass1 implements IStvVideoFrameForTimeCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditPreViewPresenter f15784a;

        @Override // com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback
        public void a(final String str) {
            new Thread(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.EditPreViewPresenter.1.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1.this.f15784a.f.setCoverImgPath(str);
                    AnonymousClass1.this.f15784a.u();
                }
            }).start();
        }
    }

    public EditPreViewPresenter(Bundle bundle) {
        this.e = bundle;
    }

    private void a(FilterItem filterItem, int i) {
        if (filterItem != null) {
            if (filterItem.b() != null) {
                this.d.setFilterStyle(filterItem.b());
            } else {
                this.d.setFilterStyle(null);
            }
        }
    }

    private void s() {
        if (D() != null) {
            AppMethods.d(R.string.common_net_error);
        }
    }

    private void t() {
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = (SenseTimeQiniuEditVideoManager) SenseTimeFactory.createInstance(D().getContext(), 2);
        this.d = senseTimeQiniuEditVideoManager;
        senseTimeQiniuEditVideoManager.enableBeautify(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        IBaseView D = D();
        if (D != null) {
            Intent intent = new Intent();
            StvResultModel stvResultModel = new StvResultModel();
            stvResultModel.a(true);
            stvResultModel.b(this.f.getCoverImgPath());
            StvLogUtils.a(b + " coverImagePath = " + this.f.getCoverImgPath(), new Object[0]);
            stvResultModel.c(this.f.getSaveVideoPath());
            stvResultModel.a(this.f.getSaveVideoWidth());
            stvResultModel.b(this.f.getSaveVideoHeight());
            stvResultModel.a(this.f.getSaveDurationMs());
            stvResultModel.b(this.f.getVideoSize());
            stvResultModel.d(this.f.getSerializableData().getMusicId());
            stvResultModel.c(this.f.getSerializableData().getSelectFilterPosition());
            if (q() == 1 || q() == 61 || q() == 7) {
                stvResultModel.b(r());
            }
            intent.putExtra("result_model", stvResultModel);
            intent.putExtra("close_page", true);
            intent.putExtra("serializeble_data", this.f.getSerializableData());
            D.getActivity().setResult(-1, intent);
            D.getActivity().finish();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a() {
        IBaseView D = D();
        if (D != null) {
            Bundle bundle = this.e;
            Bundle bundle2 = bundle;
            if (bundle == null) {
                bundle2 = D.getArguments();
            }
            if (bundle2 == null) {
                StvLogUtils.a(b + "EditPresenter bundle == null!!!", new Object[0]);
                s();
                D.getActivity().finish();
            } else if (!STLicenseUtils.a(D().getContext())) {
                AppMethods.a((CharSequence) "请检查License授权！");
                D().getActivity().finish();
            } else {
                EditDataModel.SerializableData serializableData = (EditDataModel.SerializableData) bundle2.getSerializable("serializeble_data");
                CommonModel commonModel = (CommonModel) bundle2.getSerializable("commont_model");
                if ((serializableData == null || TextUtils.isEmpty(serializableData.getVideoPath())) && (commonModel == null || TextUtils.isEmpty(commonModel.getVideoPath()))) {
                    StvLogUtils.a(b + "EditPresenter commonModel 数据错误！！！", new Object[0]);
                    s();
                    D.getActivity().finish();
                    return;
                }
                File file = null;
                if (serializableData != null) {
                    file = new File(serializableData.getVideoPath());
                } else if (commonModel != null) {
                    file = new File(commonModel.getVideoPath());
                }
                if (file == null || !file.exists()) {
                    StvLogUtils.a(b + "EditPresenter commonModel 视频文件不存在！！！", new Object[0]);
                    s();
                    D.getActivity().finish();
                    return;
                }
                EditDataModel editDataModel = new EditDataModel();
                this.f = editDataModel;
                if (commonModel != null) {
                    editDataModel.copyModel(commonModel, serializableData);
                }
                if (serializableData != null) {
                    this.f.getSerializableData().a(serializableData);
                }
                this.f.setScreenWidth(D.getContext().getResources().getDisplayMetrics().widthPixels);
                this.f.getSerializableData().setUseData(true);
                String videoPath = this.f.getSerializableData().getVideoPath();
                StvLogUtils.a(b + "editing file: " + videoPath, new Object[0]);
                this.f.setMediaFile(videoPath);
                int videoWidth = this.f.getVideoWidth();
                int videoHeight = this.f.getVideoHeight();
                int i = D.getContext().getResources().getDisplayMetrics().widthPixels;
                int i2 = (int) (((i * 1.0f) / videoWidth) * videoHeight);
                ViewGroup.LayoutParams layoutParams = D.a().getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                D.a().setLayoutParams(layoutParams);
                PLVideoEditSetting pLVideoEditSetting = new PLVideoEditSetting();
                pLVideoEditSetting.setSourceFilepath(videoPath);
                pLVideoEditSetting.setDestFilepath(StvTools.c());
                PLShortVideoEditor pLShortVideoEditor = new PLShortVideoEditor(D.a(), pLVideoEditSetting);
                this.f15783c = pLShortVideoEditor;
                pLShortVideoEditor.setDisplayMode(PLDisplayMode.FULL);
                c(false);
                try {
                    AssetFileDescriptor openFd = D.getActivity().getAssets().openFd(EditDataModel.DEFAULT_MUTE_AUDIO_NAME);
                    if (openFd != null) {
                        this.f15783c.setAudioMixAsset(openFd);
                    }
                    a(i(), h() ? j() : 0);
                } catch (IOException e) {
                    StvLogUtils.a(b + "读取 " + EditDataModel.DEFAULT_MUTE_AUDIO_NAME + " IOException", new Object[0]);
                }
                if (this.f.getSerializableData().isHasBgMusic()) {
                    a(this.f.getSerializableData().getMusicPath());
                    this.f.getSerializableData().setMusicPath(this.f.getSerializableData().getMusicPath());
                }
                if (this.f.getSerializableData().getSelectedFilter() != null) {
                    t();
                    a(this.f.getSerializableData().getSelectedFilter(), this.f.getSerializableData().getSelectFilterPosition());
                }
                D.a(this.f.getSerializableData());
                D.a(q(), p(), k());
            }
        }
    }

    public void a(int i) {
        EditDataModel editDataModel = this.f;
        if (editDataModel != null) {
            editDataModel.getSerializableData().setShowVType(i);
        }
    }

    public void a(int i, int i2) {
        this.f.setCurrentFgVolume(i);
        this.f.setCurrentBgVolume(i2);
        PLShortVideoEditor pLShortVideoEditor = this.f15783c;
        if (pLShortVideoEditor != null) {
            pLShortVideoEditor.setAudioMixVolume(i / 100.0f, i2 / 100.0f);
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Bundle bundle) {
        if (bundle == null || this.f == null) {
            return;
        }
        CommonModel commonModel = new CommonModel();
        commonModel.copyModel(this.f.getSerializableData());
        bundle.putSerializable("commont_model", commonModel);
        if (this.f.getSerializableData() != null) {
            EditDataModel.SerializableData serializableData = new EditDataModel.SerializableData();
            serializableData.a(this.f.getSerializableData());
            bundle.putSerializable("serializeble_data", serializableData);
        }
    }

    public void a(PLVideoFilterListener pLVideoFilterListener) {
        this.f15783c.startPlayback(pLVideoFilterListener);
    }

    public void a(String str) {
        this.f.getSerializableData().setHasBgMusic(true);
        this.f.getSerializableData().setMusicPath(str);
        this.f15783c.setAudioMixFile(str);
        a(this.f.getCurrentFgVolume(), 100);
    }

    public void a(boolean z) {
        this.f15783c.setPlaybackLoop(z);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void b() {
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.d;
        if (senseTimeQiniuEditVideoManager != null) {
            senseTimeQiniuEditVideoManager.onDestroy();
        }
    }

    public void b(boolean z) {
        this.f15783c.setAudioMixLooping(z);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void c() {
        b(true);
        a(true);
        l();
        if (this.d != null) {
            a(this.f15782a);
        } else {
            a((PLVideoFilterListener) null);
        }
        a(i(), h() ? j() : 0);
    }

    public void c(boolean z) {
        this.f15783c.muteOriginAudio(z);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void d() {
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.d;
        if (senseTimeQiniuEditVideoManager != null) {
            senseTimeQiniuEditVideoManager.onStop();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void e() {
        m();
        n();
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.d;
        if (senseTimeQiniuEditVideoManager != null) {
            senseTimeQiniuEditVideoManager.onPause();
        }
        this.f.setCoverImgPath(null);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void f() {
        SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.d;
        if (senseTimeQiniuEditVideoManager != null) {
            senseTimeQiniuEditVideoManager.onStart();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public boolean g() {
        return false;
    }

    public boolean h() {
        return this.f.getSerializableData().isHasBgMusic();
    }

    public int i() {
        return this.f.getCurrentFgVolume();
    }

    public int j() {
        return this.f.getCurrentBgVolume();
    }

    public int k() {
        return this.f.getSerializableData().getCurrentPage();
    }

    public void l() {
        this.f15783c.resumePlayback();
    }

    public void m() {
        this.f15783c.pausePlayback();
    }

    public void n() {
        this.f15783c.stopPlayback();
    }

    public int o() {
        EditDataModel editDataModel = this.f;
        if (editDataModel != null) {
            return editDataModel.getSerializableData().getShowVType();
        }
        return 0;
    }

    public int p() {
        return this.f.getSerializableData().getPrePageType();
    }

    public int q() {
        return this.f.getSerializableData().getFrom();
    }

    public boolean r() {
        return this.f.isAutoDelete();
    }
}
