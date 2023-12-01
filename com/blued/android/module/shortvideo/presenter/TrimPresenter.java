package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ITrimView;
import com.blued.android.module.shortvideo.fragment.EditFragment;
import com.blued.android.module.shortvideo.fragment.SaveVideoFragment;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.TrimDataModel;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.view.RangeSeekBar;
import com.qiniu.pili.droid.shortvideo.PLShortVideoTrimmer;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/TrimPresenter.class */
public class TrimPresenter extends ShortVideoBasePresent<ITrimView> implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15828a = TrimPresenter.class.getSimpleName();
    private VideoView b;

    /* renamed from: c  reason: collision with root package name */
    private PLShortVideoTrimmer f15829c;
    private Bundle d;
    private TrimDataModel e;
    private DeleteAutoCheckedListener f;
    private String i;
    private int j;
    private boolean k;
    private final RangeSeekBar.OnRangeSeekBarChangeListener l = new RangeSeekBar.OnRangeSeekBarChangeListener() { // from class: com.blued.android.module.shortvideo.presenter.TrimPresenter.2
        @Override // com.blued.android.module.shortvideo.view.RangeSeekBar.OnRangeSeekBarChangeListener
        public void a(RangeSeekBar rangeSeekBar, long j, long j2, int i, boolean z, RangeSeekBar.Thumb thumb) {
            long scrollMs = TrimPresenter.this.e.getScrollMs();
            long scrollMs2 = j2 + TrimPresenter.this.e.getScrollMs();
            StvLogUtils.a(TrimPresenter.f15828a + " bar.getWidth():" + rangeSeekBar.getWidth(), new Object[0]);
            TrimPresenter.this.e.setLeftProgress((double) (j + scrollMs));
            TrimPresenter.this.e.setRightProgress(scrollMs2 < TrimPresenter.this.e.getMinVideoDuration() ? TrimPresenter.this.e.getMinVideoDuration() : scrollMs2);
            ITrimView D = TrimPresenter.this.D();
            if (i == 0) {
                TrimPresenter.this.k = false;
                TrimPresenter.this.m();
            } else if (i == 1) {
                TrimPresenter.this.k = false;
                if (D != null) {
                    D.a(TrimPresenter.this.e.getRightProgress() - TrimPresenter.this.e.getLeftProgress());
                }
                TrimPresenter trimPresenter = TrimPresenter.this;
                trimPresenter.a((int) trimPresenter.e.getLeftProgress());
            } else if (i != 2) {
            } else {
                TrimPresenter.this.k = true;
                TrimPresenter.this.b((int) (thumb == RangeSeekBar.Thumb.MIN ? TrimPresenter.this.e.getLeftProgress() : TrimPresenter.this.e.getRightProgress()));
                if (D != null) {
                    D.a(TrimPresenter.this.e.getRightProgress() - TrimPresenter.this.e.getLeftProgress());
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener m = new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.shortvideo.presenter.TrimPresenter.3
        private int b = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            this.b = i;
            if (i == 0) {
                TrimPresenter.this.k = false;
                TrimPresenter.this.k();
                return;
            }
            TrimPresenter.this.k = true;
            if (TrimPresenter.this.l()) {
                TrimPresenter.this.m();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            long j;
            long j2;
            super.onScrolled(recyclerView, i, i2);
            if (this.b == 0) {
                return;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            int width = (findFirstVisibleItemPosition * findViewByPosition.getWidth()) - findViewByPosition.getLeft();
            if (TrimPresenter.this.l()) {
                TrimPresenter.this.m();
            }
            TrimPresenter.this.k = true;
            ITrimView D = TrimPresenter.this.D();
            if (D != null) {
                j = D.c();
                j2 = D.d();
            } else {
                j = 0;
                j2 = 0;
            }
            if (width == (-TrimPresenter.this.e.getMarginSize())) {
                TrimPresenter.this.e.setScrollMs(0L);
                TrimPresenter.this.e.setLeftProgress(j);
            } else {
                TrimPresenter.this.e.setScrollMs(TrimPresenter.this.e.getAveragePxMs() * width);
                TrimPresenter.this.e.setLeftProgress(j + TrimPresenter.this.e.getScrollMs());
            }
            TrimPresenter.this.e.setRightProgress(j2 + TrimPresenter.this.e.getScrollMs());
            TrimPresenter trimPresenter = TrimPresenter.this;
            trimPresenter.b((int) trimPresenter.e.getLeftProgress());
        }
    };

    public TrimPresenter(Bundle bundle, DeleteAutoCheckedListener deleteAutoCheckedListener) {
        this.d = bundle;
        this.f = deleteAutoCheckedListener;
    }

    private void b(final View view, final int i) {
        StvLogUtils.a(f15828a + " 剪切视频，视频地址: " + this.e.getVideoPath() + " 剪切范围: " + p() + " - " + q(), new Object[0]);
        this.f15829c.trim((long) p(), (long) q(), PLShortVideoTrimmer.TRIM_MODE.FAST, new PLVideoSaveListener() { // from class: com.blued.android.module.shortvideo.presenter.TrimPresenter.1
            @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
            public void onProgressUpdate(final float f) {
                if (TrimPresenter.this.D() != null && TrimPresenter.this.D().getActivity() != null && !TrimPresenter.this.D().getActivity().isFinishing()) {
                    TrimPresenter.this.D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.TrimPresenter.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            TrimPresenter.this.D().a(f);
                        }
                    });
                    return;
                }
                StvLogUtils.a(TrimPresenter.f15828a + " getView() == null!!!", new Object[0]);
            }

            @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
            public void onSaveVideoCanceled() {
                if (TrimPresenter.this.D() != null && TrimPresenter.this.D().getActivity() != null && !TrimPresenter.this.D().getActivity().isFinishing()) {
                    TrimPresenter.this.D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.TrimPresenter.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setEnabled(true);
                            TrimPresenter.this.D().c(false);
                        }
                    });
                    return;
                }
                StvLogUtils.a(TrimPresenter.f15828a + " getView() == null!!!", new Object[0]);
            }

            @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
            public void onSaveVideoFailed(int i2) {
                StvLogUtils.a(TrimPresenter.f15828a + " 视频剪切失败, error code: " + i2, new Object[0]);
                if (i2 == 16) {
                    StvLogUtils.a(TrimPresenter.f15828a + " 视频剪切，当前机型暂不支持该功能", new Object[0]);
                }
                if (TrimPresenter.this.D() != null && TrimPresenter.this.D().getActivity() != null && !TrimPresenter.this.D().getActivity().isFinishing()) {
                    TrimPresenter.this.D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.TrimPresenter.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setEnabled(true);
                            TrimPresenter.this.D().c(false);
                            StvLogUtils.a(R.string.common_net_error);
                        }
                    });
                    return;
                }
                StvLogUtils.a(TrimPresenter.f15828a + " getView() == null!!!", new Object[0]);
            }

            @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
            public void onSaveVideoSuccess(final String str) {
                if (TrimPresenter.this.D() != null && TrimPresenter.this.D().getActivity() != null && !TrimPresenter.this.D().getActivity().isFinishing()) {
                    TrimPresenter.this.D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.TrimPresenter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setEnabled(true);
                            TrimPresenter.this.D().g();
                            TrimPresenter.this.D().c(false);
                            CommonModel commonModel = new CommonModel();
                            commonModel.copyModel(TrimPresenter.this.e);
                            commonModel.setVideoPath(str);
                            if (TrimPresenter.this.e.getVideoPath().equals(str) || str.equals(TrimPresenter.this.e.getOriginalVideoPath())) {
                                commonModel.setCanDeleteVideoFile(false);
                            }
                            commonModel.setCurrentPage(3);
                            if (commonModel.getFrom() != 60) {
                                EditFragment.a(TrimPresenter.this.D().a(), commonModel, 2, TrimPresenter.this.j(), TrimPresenter.this.i, TrimPresenter.this.j, TrimPresenter.this.f);
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("commont_model", commonModel);
                            SaveVideoFragment.a(TrimPresenter.this.D().a(), bundle, commonModel.getFrom(), i);
                        }
                    });
                    return;
                }
                StvLogUtils.a(TrimPresenter.f15828a + " getView() == null!!!", new Object[0]);
            }
        });
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a() {
        boolean z;
        Bundle bundle = this.d;
        if (bundle == null) {
            bundle = D().getArguments();
            z = false;
        } else {
            z = true;
        }
        if (bundle == null) {
            StvLogUtils.a(f15828a + "TrimPresenter bundle == null!!!", new Object[0]);
            AppMethods.d(R.string.common_net_error);
            D().getActivity().finish();
        } else if (!STLicenseUtils.a(D().getContext())) {
            AppMethods.a((CharSequence) "请检查License授权！");
            D().getActivity().finish();
        } else {
            CommonModel commonModel = (CommonModel) bundle.getSerializable("commont_model");
            if (!new File(commonModel.getVideoPath()).exists()) {
                StvLogUtils.a("TrimPresenter commonModel 视频文件不存在！！！", new Object[0]);
                AppMethods.d(R.string.common_net_error);
                D().getActivity().finish();
                return;
            }
            TrimDataModel.SerializableData serializableData = (TrimDataModel.SerializableData) bundle.getSerializable("serializeble_data");
            TrimDataModel trimDataModel = new TrimDataModel();
            this.e = trimDataModel;
            trimDataModel.copyModel(commonModel, serializableData);
            this.e.setUseData(Boolean.valueOf(z));
            this.i = bundle.getString("delete_auto_checkbox_text", "");
            this.j = bundle.getInt("delete_auto_number");
            this.e.setMaxVideoDuration(900000L);
            this.b = D().b();
            int videoWidth = this.e.getVideoWidth();
            int videoHeight = this.e.getVideoHeight();
            int i = D().getContext().getResources().getDisplayMetrics().widthPixels;
            int i2 = (int) (((i * 1.0f) / videoWidth) * videoHeight);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.b.setLayoutParams(layoutParams);
            this.b.setVideoPath(this.e.getVideoPath());
            this.b.setOnPreparedListener(this);
            this.b.setOnCompletionListener(this);
            this.f15829c = new PLShortVideoTrimmer(D().getContext(), this.e.getVideoPath(), StvTools.d());
            D().a(this.e);
            D().a(this.l);
            D().a(this.m);
            StvLogUtils.a(f15828a + "video duration: " + this.e.getDurationMs(), new Object[0]);
        }
    }

    public void a(int i) {
        b(i);
        if (i == 0) {
            k();
            return;
        }
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.start();
            ITrimView D = D();
            if (D != null) {
                D.c(i);
            }
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -1) {
            boolean z = false;
            if (intent == null || intent.getBooleanExtra("close_page", false)) {
                z = true;
            }
            if (i == 2 && z) {
                Intent intent2 = intent;
                if (intent == null) {
                    intent2 = new Intent();
                }
                intent2.putExtra("close_page", true);
                activity.setResult(-1, intent2);
                activity.finish();
            }
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Bundle bundle) {
    }

    public void a(View view, int i) {
        n();
        b(view, i);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void b() {
        n();
        TrimDataModel trimDataModel = this.e;
        if (trimDataModel != null) {
            trimDataModel.clear();
        }
        PLShortVideoTrimmer pLShortVideoTrimmer = this.f15829c;
        if (pLShortVideoTrimmer != null) {
            pLShortVideoTrimmer.destroy();
        }
    }

    public void b(int i) {
        if (this.b == null) {
            return;
        }
        String str = f15828a;
        Logger.c(str, "var1" + i);
        this.b.seekTo(i);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void c() {
        a((int) o());
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void d() {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void e() {
        m();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void f() {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public boolean g() {
        return false;
    }

    public CommonModel h() {
        return this.e;
    }

    public TrimDataModel.SerializableData i() {
        return this.e.getSerializableData();
    }

    public int j() {
        return this.e.getFrom();
    }

    public void k() {
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.start();
            ITrimView D = D();
            if (D != null) {
                D.c(0);
            }
        }
    }

    public boolean l() {
        VideoView videoView = this.b;
        if (videoView == null) {
            return false;
        }
        return videoView.isPlaying();
    }

    public void m() {
        VideoView videoView = this.b;
        if (videoView == null) {
            return;
        }
        videoView.pause();
        ITrimView D = D();
        if (D != null) {
            D.e();
        }
        this.k = false;
    }

    public void n() {
        VideoView videoView = this.b;
        if (videoView == null) {
            return;
        }
        videoView.stopPlayback();
        ITrimView D = D();
        if (D != null) {
            D.e();
        }
        this.k = false;
    }

    public long o() {
        return this.e.getSelectedBeginMs();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.seekTo((int) this.e.getLeftProgress());
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo((int) this.e.getLeftProgress());
        mediaPlayer.setOnSeekCompleteListener(this);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
    }

    public double p() {
        return this.e.getLeftProgress();
    }

    public double q() {
        return this.e.getRightProgress();
    }
}
