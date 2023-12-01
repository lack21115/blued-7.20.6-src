package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveDesireGiftNumberDialogFragment;
import com.blued.android.module.live_china.fragment.LiveDesireSelectGiftDialogFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveDesireGiftInfo;
import com.blued.android.module.live_china.model.LiveDesireLiseExtra;
import com.blued.android.module.live_china.model.LiveDesireLiseModel;
import com.blued.android.module.live_china.model.LiveDesireSelectGiftModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireAddDialogFragment.class */
public class LiveDesireAddDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f12809a;
    public Observer<Boolean> b;

    /* renamed from: c  reason: collision with root package name */
    private View f12810c;
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private View h;
    private TextView i;
    private View j;
    private EditText k;
    private SmartRefreshLayout l;
    private AddDesireCallBack m;
    private LiveDesireLiseModel n;
    private long o = 0;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireAddDialogFragment$AddDesireCallBack.class */
    public interface AddDesireCallBack {
        void addDesireSuccess(LiveDesireLiseModel liveDesireLiseModel);
    }

    public LiveDesireAddDialogFragment(Context context, AddDesireCallBack addDesireCallBack) {
        this.f12809a = context;
        this.m = addDesireCallBack;
        LiveDesireLiseModel liveDesireLiseModel = new LiveDesireLiseModel();
        this.n = liveDesireLiseModel;
        liveDesireLiseModel.gift_info = new LiveDesireGiftInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        this.n.count = i;
        this.i.setText(String.valueOf(i));
        this.i.setTextColor(this.f12809a.getResources().getColor(R.color.syc_dark_0a0a0a));
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.o = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        LiveDesireLiseModel liveDesireLiseModel = this.n;
        if (liveDesireLiseModel == null || liveDesireLiseModel.gift_info == null || this.n.gift_info.id <= 0 || this.n.count <= 0) {
            return;
        }
        String obj = this.k.getText().toString();
        if (obj.length() > 8) {
            ToastUtils.b(R.string.live_desire_exceed_the_word_limit);
            return;
        }
        this.n.return_way = obj;
        EventTrackLive.a(LiveProtos.Event.LIVE_WISH_ADD_CONFIRM_CLICK, LiveRoomManager.a().e(), String.valueOf(this.n.gift_info.id), this.n.count, this.n.return_way);
        if (!TextUtils.isEmpty(obj)) {
            LiveRoomHttpUtils.h(obj, new BluedUIHttpResponse<BluedEntity<LiveDesireLiseModel, LiveDesireLiseExtra>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveDesireAddDialogFragment.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    if (i == 422) {
                        EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_WISH_RETURN_AUDIT_FAIL, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                        LiveDesireAddDialogFragment.this.k.setText("");
                    }
                    return super.onUIFailure(i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    LiveDesireAddDialogFragment.this.d.setVisibility(8);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    LiveDesireAddDialogFragment.this.d.setVisibility(0);
                    super.onUIStart();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<LiveDesireLiseModel, LiveDesireLiseExtra> bluedEntity) {
                    EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_WISH_RETURN_AUDIT_SUCCESS, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                    LiveDesireAddDialogFragment.this.m.addDesireSuccess(LiveDesireAddDialogFragment.this.n);
                    LiveDesireAddDialogFragment.this.dismiss();
                }
            });
            return;
        }
        this.m.addDesireSuccess(this.n);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, Boolean bool) {
        view.animate().translationY(bool.booleanValue() ? 0.0f : view.getHeight()).setStartDelay(bool.booleanValue() ? 100L : 0L).setDuration(350L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveDesireSelectGiftModel liveDesireSelectGiftModel) {
        this.n.gift_info.id = liveDesireSelectGiftModel.goods_id;
        this.n.gift_info.pic = liveDesireSelectGiftModel.images_static;
        this.n.gift_info.name = liveDesireSelectGiftModel.name;
        this.n.gift_info.beans = liveDesireSelectGiftModel.beans;
        this.g.setText(liveDesireSelectGiftModel.name);
        this.g.setTextColor(this.f12809a.getResources().getColor(R.color.syc_dark_0a0a0a));
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface) {
        this.o = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        LiveDesireSelectGiftDialogFragment liveDesireSelectGiftDialogFragment = new LiveDesireSelectGiftDialogFragment(this.f12809a, this.n.gift_info.id, new LiveDesireSelectGiftDialogFragment.SelectGiftCallBack() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$fDcz4TrXlDUeCQoMVabscN1sKL8
            @Override // com.blued.android.module.live_china.fragment.LiveDesireSelectGiftDialogFragment.SelectGiftCallBack
            public final void selectGift(LiveDesireSelectGiftModel liveDesireSelectGiftModel) {
                LiveDesireAddDialogFragment.this.a(liveDesireSelectGiftModel);
            }
        });
        liveDesireSelectGiftDialogFragment.a(new DialogInterface.OnDismissListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$z1TLqA_aZtoK26_cvNDHMTeTp6Y
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                LiveDesireAddDialogFragment.this.b(dialogInterface);
            }
        });
        liveDesireSelectGiftDialogFragment.show(getFragmentManager(), "selectGiftDialog");
        this.o = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        LiveDesireGiftNumberDialogFragment liveDesireGiftNumberDialogFragment = new LiveDesireGiftNumberDialogFragment(this.f12809a, this.n.count, new LiveDesireGiftNumberDialogFragment.SelectGiftNumberCallBack() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$ZDz0RpRoVHdgNm846ALgB-6d7so
            @Override // com.blued.android.module.live_china.fragment.LiveDesireGiftNumberDialogFragment.SelectGiftNumberCallBack
            public final void selectGiftNumber(int i) {
                LiveDesireAddDialogFragment.this.a(i);
            }
        });
        liveDesireGiftNumberDialogFragment.a(new DialogInterface.OnDismissListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$MRG993CXGvXoa3xXcTaMOIwIYls
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                LiveDesireAddDialogFragment.this.a(dialogInterface);
            }
        });
        liveDesireGiftNumberDialogFragment.show(getFragmentManager(), "giftNumberDialog");
        this.o = 0L;
    }

    private void d() {
        this.f12810c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$M9aaLRdQSo2Bp2s8hHn140rJxq0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireAddDialogFragment.this.e(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$0dXiu-R_-r2yDty4-DSbj_P6rI0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireAddDialogFragment.this.d(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$L02P6-uceQ-_AtA5wNpbFDy66U4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireAddDialogFragment.this.a(view);
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$JM4AbSeGqyNUvpNrQoG75S8-BqI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireAddDialogFragment.this.b(view);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$JM4AbSeGqyNUvpNrQoG75S8-BqI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireAddDialogFragment.this.b(view);
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$_7EVP9NJWF4C3fTyk1y9IienYss
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireAddDialogFragment.this.c(view);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$_7EVP9NJWF4C3fTyk1y9IienYss
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireAddDialogFragment.this.c(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        dismiss();
    }

    private void e() {
        LiveDesireLiseModel liveDesireLiseModel = this.n;
        if (liveDesireLiseModel == null || liveDesireLiseModel.count <= 0 || this.n.gift_info == null || this.n.gift_info.id <= 0) {
            if (this.f.isClickable()) {
                this.f.setClickable(false);
                this.f.animate().alpha(0.3f).setDuration(200L);
            }
        } else if (this.f.isClickable()) {
        } else {
            this.f.setClickable(true);
            this.f.animate().alpha(1.0f).setDuration(200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        LiveEventBus.get("desire_dialog_show", Boolean.class).post(true);
        super.dismiss();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.o == 0 || System.currentTimeMillis() - this.o < 200) {
            return true;
        }
        LiveEventBus.get("desire_dialog_show", Boolean.class).post(true);
        return super.onBackPressed();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.f12809a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_desire_adddesire, (ViewGroup) null);
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, height));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = height;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        window.setGravity(80);
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final View inflate = layoutInflater.inflate(R.layout.dialog_live_desire_adddesire, viewGroup);
        this.f12810c = inflate.findViewById(R.id.rl_root);
        this.d = inflate.findViewById(R.id.loading);
        this.e = inflate.findViewById(R.id.iv_back);
        this.f = (TextView) inflate.findViewById(R.id.tv_confirm);
        this.g = (TextView) inflate.findViewById(R.id.tv_select_gift);
        this.h = inflate.findViewById(R.id.iv_select_gift);
        this.i = (TextView) inflate.findViewById(R.id.tv_gift_number);
        this.j = inflate.findViewById(R.id.iv_gift_number);
        this.l = (SmartRefreshLayout) inflate.findViewById(R.id.smart_refresh);
        this.k = (EditText) inflate.findViewById(R.id.et_repay_mode);
        d();
        this.l.c(false);
        this.l.l(false);
        this.l.f(true);
        this.l.e(true);
        this.l.g(true);
        this.b = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireAddDialogFragment$PEdy8-JSWKpkJiq1Nb5rdfLbxVQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveDesireAddDialogFragment.a(View.this, (Boolean) obj);
            }
        };
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
            this.o = System.currentTimeMillis();
            LiveEventBus.get("desire_dialog_show", Boolean.class).post(false);
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
