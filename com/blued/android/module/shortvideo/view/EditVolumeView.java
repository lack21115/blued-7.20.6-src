package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPresenter;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/EditVolumeView.class */
public class EditVolumeView extends EditBottomBaseView implements SeekBar.OnSeekBarChangeListener, EventObserver {
    private View d;
    private SeekBar e;
    private SeekBar f;
    private EditPresenter g;

    public EditVolumeView(Context context) {
        super(context);
    }

    public EditVolumeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditVolumeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.edit_adjust_audio_mix_v, (ViewGroup) null);
        this.d = inflate;
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.stv_adjust_fg_volume);
        this.e = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        SeekBar seekBar2 = (SeekBar) this.d.findViewById(R.id.stv_adjust_bg_volume);
        this.f = seekBar2;
        seekBar2.setOnSeekBarChangeListener(this);
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        if (value == EventType.VALUE.CONFIG_VOLUME) {
            c();
        }
    }

    public void a(EditPresenter editPresenter) {
        this.g = editPresenter;
        this.e.setMax(100);
        this.f.setMax(100);
        this.f.setEnabled(false);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void b() {
        StvViewUtils.a(this.f15888c, 30, 46, 30, 60);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void c() {
        super.c();
        EditPresenter editPresenter = this.g;
        if (editPresenter == null) {
            return;
        }
        editPresenter.h(4);
        if (this.g.t() < 60) {
            StatisticsProxy.a().a("sv_page", (Object) "volumn");
        }
        this.e.setProgress(this.g.k());
        if (this.g.i() || !this.g.j()) {
            this.f.setEnabled(false);
            return;
        }
        this.f.setEnabled(true);
        this.f.setProgress(this.g.l());
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void e() {
        ObserverMgr.a().a(EventType.VALUE.SAVE_VOLUME);
        d();
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void f() {
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected boolean g() {
        return true;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected View getContentV() {
        return this.d;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected int getTitleId() {
        return R.string.stv_adjust_volume_title;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void h() {
        ObserverMgr.a().a(this);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void i() {
    }

    public void j() {
        ObserverMgr.a().b(this);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void k() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int i2;
        EditPresenter editPresenter = this.g;
        if (editPresenter == null) {
            return;
        }
        if (seekBar == this.e) {
            i2 = editPresenter.l();
        } else {
            i2 = i;
            i = editPresenter.k();
        }
        if (!this.g.j()) {
            i2 = 0;
        }
        this.g.a(i, i2);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Tracker.onStopTrackingTouch(seekBar);
    }
}
