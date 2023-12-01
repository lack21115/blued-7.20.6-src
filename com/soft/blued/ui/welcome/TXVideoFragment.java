package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.common.utils.DialogUtils;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import com.soft.blued.R;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/TXVideoFragment.class */
public class TXVideoFragment extends BaseADVideoFragment implements RewardVideoADListener {
    public Context g;
    public View h;
    private RewardVideoAD i;
    private boolean j;

    private void l() {
        this.i = k();
        this.j = false;
        h();
        this.i.loadAD();
    }

    protected RewardVideoAD k() {
        return new RewardVideoAD(this.g, this.b.third_id, this, false);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        Log.i("drb", "onADClick");
        d();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        Log.i("drb", "onADClose");
        b();
        e();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        Log.i("drb", "onADExpose");
        c();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
        DialogUtils.b(this.f20822a);
        i();
        if (this.i.getRewardAdType() == 0) {
            Log.d("drb", "eCPMLevel = " + this.i.getECPMLevel() + ", ECPM: " + this.i.getECPM() + " ,video duration = " + this.i.getVideoDuration());
        } else if (this.i.getRewardAdType() == 1) {
            Log.d("drb", "eCPMLevel = " + this.i.getECPMLevel() + ", ECPM: " + this.i.getECPM());
        }
        this.i.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.soft.blued.ui.welcome.TXVideoFragment.1
            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            }
        });
        this.j = true;
        this.i.showAD(getActivity());
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
        Log.i("drb", "onADShow");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_ad_video, viewGroup, false);
            l();
            DialogUtils.a(this.f20822a);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        String format = String.format(Locale.getDefault(), "onError, error code: %d, error msg: %s", Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        Log.i("drb", "onError, adError=" + format);
        g();
        b();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        Log.i("drb", "onReward " + map.get("transId"));
        a();
        f();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        Log.i("drb", "onVideoCached");
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        Log.i("drb", "onVideoComplete");
    }
}
