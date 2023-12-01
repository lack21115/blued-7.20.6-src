package com.blued.android.module.yy_china.presenter;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.amap.api.fence.GeoFence;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYSeatCPAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYMarriageDialog;
import com.blued.android.module.yy_china.fragment.YYTakeOffMaskDialog;
import com.blued.android.module.yy_china.listener.IPopShowAndDismissListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BlindMatchUserModel;
import com.blued.android.module.yy_china.model.BlindMatchUserPairModel;
import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.VeiledRoomInfoMode;
import com.blued.android.module.yy_china.model.YYCPStepModel;
import com.blued.android.module.yy_china.model.YYMsgBlindPublishExtra;
import com.blued.android.module.yy_china.model.YYMsgBlindResultExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYCPGuideView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYCPPresenter.class */
public class YYCPPresenter extends AbstractBasePresenter {
    private PopupWindow c;
    private Handler d;
    private List<BlindMatchUserPairModel> e;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYCPPresenter$AnimHandler.class */
    class AnimHandler extends Handler {
        private AnimHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 10) {
                if (YYCPPresenter.this.c != null) {
                    YYCPPresenter.this.c.dismiss();
                    YYCPPresenter.this.c = null;
                    YYCPPresenter.this.k();
                }
            } else if (i != 11 || YYCPPresenter.this.e == null || YYCPPresenter.this.e.isEmpty()) {
            } else {
                YYCPPresenter yYCPPresenter = YYCPPresenter.this;
                yYCPPresenter.a(4, (BlindMatchUserPairModel) yYCPPresenter.e.remove(0));
            }
        }
    }

    public YYCPPresenter(BaseYYStudioFragment baseYYStudioFragment) {
        super(baseYYStudioFragment);
        this.d = new AnimHandler();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        View h;
        if (i < 1 || i > 3 || (h = h()) == null) {
            return;
        }
        TextView textView = (TextView) h.findViewById(R.id.cp_step_name);
        TextView textView2 = (TextView) h.findViewById(R.id.cp_step_content);
        textView.setText(c(i));
        textView2.setText(d(i));
        a(h, (SVGAImageView) h.findViewById(R.id.cp_step_icon_svga), null, null, null, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, BlindMatchUserPairModel blindMatchUserPairModel) {
        View i2;
        if (i != 4 || blindMatchUserPairModel.source == null || blindMatchUserPairModel.target == null || (i2 = i()) == null) {
            return;
        }
        ImageView imageView = (ImageView) i2.findViewById(R.id.iv_cp_heart);
        ImageView imageView2 = (ImageView) i2.findViewById(R.id.iv_source);
        ImageView imageView3 = (ImageView) i2.findViewById(R.id.iv_target);
        SVGAImageView sVGAImageView = (SVGAImageView) i2.findViewById(R.id.cp_step_icon_svga);
        ImageLoader.a(this.a.getFragmentActive(), blindMatchUserPairModel.source.avatar).b(R.drawable.user_bg_round).a(imageView2);
        ImageLoader.a(this.a.getFragmentActive(), blindMatchUserPairModel.target.avatar).b(R.drawable.user_bg_round).a(imageView3);
        a(i2, sVGAImageView, imageView, imageView2, imageView3, i);
    }

    private void a(final View view, final SVGAImageView sVGAImageView, final ImageView imageView, final View view2, final View view3, final int i) {
        long j;
        PopupWindow popupWindow = this.c;
        if (popupWindow == null || !popupWindow.isShowing()) {
            j = 0;
        } else {
            this.c.dismiss();
            this.c = null;
            k();
            j = 300;
        }
        this.a.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.8
            @Override // java.lang.Runnable
            public void run() {
                if (YYCPPresenter.this.a == null) {
                    return;
                }
                YYCPPresenter.this.a.y();
                YYCPPresenter yYCPPresenter = YYCPPresenter.this;
                yYCPPresenter.c = new PopupwindowFactory.Builder(yYCPPresenter.a.getContext()).a(view).a(17).c(-2).b(-2).d(R.color.syc_66000000).e(R.style.yy_pop_scale_anim).a(false).a(new IPopShowAndDismissListener() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.8.1
                    @Override // com.blued.android.module.yy_china.listener.IPopShowAndDismissListener
                    public void a() {
                        if (YYCPPresenter.this.d != null) {
                            YYCPPresenter.this.d.sendEmptyMessageDelayed(10, YYCPPresenter.this.g(i));
                        }
                        if (sVGAImageView != null) {
                            YYCPPresenter.this.a(sVGAImageView, YYCPPresenter.this.f(i));
                        }
                        if (imageView != null) {
                            ImageLoader.c(YYCPPresenter.this.a.getFragmentActive(), "cp_show_heart.png").e(i).a().a(imageView);
                        }
                        if (view2 == null || view3 == null) {
                            return;
                        }
                        view2.setVisibility(0);
                        view2.startAnimation(AnimationUtils.loadAnimation(YYCPPresenter.this.a.getContext(), R.anim.yy_cp_match_left));
                        view3.setVisibility(0);
                        view3.startAnimation(AnimationUtils.loadAnimation(YYCPPresenter.this.a.getContext(), R.anim.yy_cp_match_right));
                    }

                    @Override // com.blued.android.module.yy_china.listener.IPopShowAndDismissListener
                    public void b() {
                        YYCPPresenter.this.k();
                        if (i == 2 && YYRoomInfoManager.e().c(YYRoomInfoManager.e().k()) && !YYRoomInfoManager.e().y()) {
                            YYCPPresenter.this.f();
                        }
                        if (YYCPPresenter.this.d == null || YYCPPresenter.this.e == null || YYCPPresenter.this.e.isEmpty()) {
                            return;
                        }
                        YYCPPresenter.this.a(4, (BlindMatchUserPairModel) YYCPPresenter.this.e.remove(0));
                    }
                }).h();
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SVGAImageView sVGAImageView, String str) {
        sVGAImageView.setVisibility(0);
        sVGAImageView.setLoops(1);
        new SVGAParser(this.a.getContext()).a(str, new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.9
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                sVGAImageView.setImageDrawable(new SVGADrawable(sVGAVideoEntity, new SVGADynamicEntity()));
                sVGAImageView.a();
                sVGAImageView.setCallback(new SVGACallback() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.9.1
                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onFinished() {
                        sVGAImageView.b();
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onPause() {
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onRepeat() {
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onStep(int i, double d) {
                    }
                });
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        a(LayoutInflater.from(this.a.getContext()).inflate(R.layout.dialog_cp_nothing_anim, (ViewGroup) null), null, null, null, null, i);
    }

    private String c(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : e(R.string.yy_blind_step_result) : e(R.string.yy_blind_step_publish) : e(R.string.yy_blind_step_heart) : e(R.string.yy_blind_step_introduction);
    }

    private String d(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "" : e(R.string.yy_blind_start_publish) : e(R.string.yy_blind_start_heart) : e(R.string.yy_blind_start_introduction);
    }

    private String e(int i) {
        return this.a.getContext().getResources().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "cp_show_match.svga" : "cp_show_like.svga" : "cp_select_like.svga" : "cp_show_myself.svga";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.a == null || this.a.E == null || !(this.a.E instanceof YYSeatCPAdapter)) {
            return;
        }
        ((YYSeatCPAdapter) this.a.E).a("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return 3000L;
        }
        return i != 4 ? 0L : 4000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.a == null) {
            return;
        }
        this.a.a(new YYCPGuideView(this.a.getContext()), -2);
    }

    private View h() {
        return LayoutInflater.from(this.a.getContext()).inflate(R.layout.dialog_cp_step_anim, (ViewGroup) null);
    }

    private View i() {
        return LayoutInflater.from(this.a.getContext()).inflate(R.layout.dialog_cp_last_step_anim, (ViewGroup) null);
    }

    private void j() {
        YYRoomHttpUtils.n(new BluedUIHttpResponse<BluedEntityA<VeiledRoomInfoMode>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VeiledRoomInfoMode> bluedEntityA) {
                VeiledRoomInfoMode singleData;
                if (!bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null || YYRoomInfoManager.e().b() == null) {
                    return;
                }
                YYRoomInfoManager.e().b().mMaskedVeiledRoominfo = singleData;
            }
        }, this.a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(LifecycleOwner lifecycleOwner) {
        LiveEventBus.get("show_blind_guide", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.1
            /* renamed from: a */
            public void onChanged(String str) {
                YYCPPresenter.this.g();
            }
        });
        LiveEventBus.get("update_cp_step", YYCPStepModel.class).observe(lifecycleOwner, new Observer<YYCPStepModel>() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.2
            /* renamed from: a */
            public void onChanged(YYCPStepModel yYCPStepModel) {
                if (yYCPStepModel == null || YYCPPresenter.this.a == null) {
                    return;
                }
                YYCPPresenter.this.a.E.a(yYCPStepModel.present_step, yYCPStepModel.next_step, true);
                if (yYCPStepModel.present_step == 0) {
                    YYCPPresenter.this.a.E.c();
                }
                if (yYCPStepModel.resend) {
                    return;
                }
                YYCPPresenter.this.a(yYCPStepModel.present_step);
            }
        });
        LiveEventBus.get("show_blind_publish", YYMsgBlindPublishExtra.class).observe(lifecycleOwner, new Observer<YYMsgBlindPublishExtra>() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.3
            /* renamed from: a */
            public void onChanged(YYMsgBlindPublishExtra yYMsgBlindPublishExtra) {
                if (yYMsgBlindPublishExtra == null || YYCPPresenter.this.a == null) {
                    return;
                }
                YYCPPresenter.this.a.E.a(yYMsgBlindPublishExtra.present_step, yYMsgBlindPublishExtra.next_step, true);
                YYCPPresenter.this.a.E.a((List<BlindPublishModel>) null);
                if (yYMsgBlindPublishExtra.resend) {
                    return;
                }
                YYCPPresenter.this.a(yYMsgBlindPublishExtra.present_step);
            }
        });
        LiveEventBus.get("show_blind_result", YYMsgBlindResultExtra.class).observe(lifecycleOwner, new Observer<YYMsgBlindResultExtra>() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.4
            /* renamed from: a */
            public void onChanged(YYMsgBlindResultExtra yYMsgBlindResultExtra) {
                if (yYMsgBlindResultExtra == null || YYCPPresenter.this.a == null) {
                    return;
                }
                YYCPPresenter.this.e = yYMsgBlindResultExtra.match_users;
                YYCPPresenter.this.a.E.a(yYMsgBlindResultExtra.present_step, yYMsgBlindResultExtra.next_step, true);
                if (yYMsgBlindResultExtra.seats != null && !yYMsgBlindResultExtra.seats.isEmpty()) {
                    YYCPPresenter.this.a.E.a((List<BlindPublishModel>) null);
                }
                YYCPPresenter.this.a.E.c();
                if (!yYMsgBlindResultExtra.resend) {
                    if (YYCPPresenter.this.e == null || YYCPPresenter.this.e.isEmpty()) {
                        YYCPPresenter.this.b(yYMsgBlindResultExtra.present_step);
                    } else if (YYRoomInfoManager.e().b() != null) {
                        String str = YYRoomInfoManager.e().b().chat_type;
                        boolean z = true;
                        int hashCode = str.hashCode();
                        if (hashCode != 56) {
                            if (hashCode == 1568 && str.equals("11")) {
                                z = true;
                            }
                        } else if (str.equals("8")) {
                            z = false;
                        }
                        if (!z || z) {
                            new YYMarriageDialog(YYCPPresenter.this.a, (ArrayList) YYCPPresenter.this.e).show(YYCPPresenter.this.a.getParentFragmentManager(), "show_marriage_dialog");
                        }
                    }
                }
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    ArrayList arrayList = new ArrayList();
                    HashMap hashMap = new HashMap();
                    for (BlindMatchUserPairModel blindMatchUserPairModel : YYCPPresenter.this.e) {
                        hashMap.clear();
                        MsgPackHelper.putMapValue(hashMap, "target", blindMatchUserPairModel.source.uid);
                        MsgPackHelper.putMapValue(hashMap, "match", blindMatchUserPairModel.target.uid);
                        arrayList.add(hashMap);
                    }
                    String json = AppInfo.f().toJson(arrayList);
                    LogUtils.d(GeoFence.BUNDLE_KEY_FENCESTATUS, "match json: " + json);
                    EventTrackYY.l(ChatRoomProtos.Event.CHAT_ROOM_CP_MATCH_SUCCEED, b.room_id, b.uid, json);
                }
            }
        });
        LiveEventBus.get("show_blind_heart", BlindMatchUserModel.class).observe(lifecycleOwner, new Observer<BlindMatchUserModel>() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.5
            /* renamed from: a */
            public void onChanged(BlindMatchUserModel blindMatchUserModel) {
                if (blindMatchUserModel == null || YYCPPresenter.this.a == null) {
                    return;
                }
                YYCPPresenter.this.a.E.a((List<BlindPublishModel>) null);
            }
        });
        LiveEventBus.get("to_take_off_mask", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.6
            /* renamed from: a */
            public void onChanged(String str) {
                new YYTakeOffMaskDialog().show(YYCPPresenter.this.a.getParentFragmentManager(), "take_off_mask_dialog");
            }
        });
        LiveEventBus.get("delay_take_off_mask", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYCPPresenter.7
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYCPPresenter.this.a.E instanceof YYSeatCPAdapter) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        ((YYSeatCPAdapter) YYCPPresenter.this.a.E).a(jSONObject.getString("target_id"), jSONObject.getLong("countdown"));
                    } catch (JSONException e) {
                        LogUtils.d("YYCPPresenter", "json 解析失败");
                    }
                }
            }
        });
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void e() {
        super.e();
        List<BlindMatchUserPairModel> list = this.e;
        if (list != null) {
            list.clear();
        }
        PopupWindow popupWindow = this.c;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.c = null;
        }
        k();
        this.d = null;
    }
}
