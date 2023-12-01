package com.soft.blued.ui.msg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.find.manager.FlashZegoApiManager;
import com.soft.blued.ui.msg.model.ChannelModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/DialogSkipFragment.class */
public class DialogSkipFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ChannelModel f18018a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f18019c;
    private CustomDialog d;
    private boolean e = false;
    private int f = 0;

    public static void a(Context context, int i) {
        synchronized (DialogSkipFragment.class) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("flag", i);
                TransparentActivity.a(bundle);
                TransparentActivity.b(context, DialogSkipFragment.class, bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, ChannelModel channelModel) {
        synchronized (DialogSkipFragment.class) {
            try {
                if (LiveFloatManager.a().H()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("flag", 0);
                    bundle.putSerializable("CHANNEL", channelModel);
                    TransparentActivity.b(context, DialogSkipFragment.class, bundle);
                } else if (FlashZegoApiManager.a().e()) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("flag", 3);
                    bundle2.putSerializable("CHANNEL", channelModel);
                    TransparentActivity.b(context, DialogSkipFragment.class, bundle2);
                } else if (ShortVideoProxy.e().a()) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("flag", 5);
                    bundle3.putSerializable("CHANNEL", channelModel);
                    TransparentActivity.b(context, DialogSkipFragment.class, bundle3);
                } else if (AudioChannelManager.j().n()) {
                    AppMethods.a(context.getResources().getText(R.string.yy_in_use));
                } else {
                    ChannelFragment.a(AppInfo.d(), channelModel);
                }
            } finally {
            }
        }
    }

    public void a() {
        CustomDialog customDialog = this.d;
        if (customDialog != null && customDialog.isShowing()) {
            this.d.dismiss();
        }
        getActivity().finish();
    }

    public void b() {
        CustomDialog customDialog = this.d;
        if (customDialog == null || !customDialog.isShowing()) {
            this.f18019c.postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.DialogSkipFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    View inflate = LayoutInflater.from(DialogSkipFragment.this.b).inflate(2131560351, (ViewGroup) null);
                    inflate.findViewById(2131372754).setVisibility(8);
                    TextView textView = (TextView) inflate.findViewById(2131371051);
                    textView.setText(DialogSkipFragment.this.getString(2131886718));
                    textView.setOnClickListener(DialogSkipFragment.this);
                    TextView textView2 = (TextView) inflate.findViewById(2131372161);
                    textView2.setText(2131886739);
                    textView2.setOnClickListener(DialogSkipFragment.this);
                    View findViewById = inflate.findViewById(2131371289);
                    TextView textView3 = (TextView) inflate.findViewById(2131371259);
                    if (DialogSkipFragment.this.f == 0) {
                        if (DialogSkipFragment.this.f18018a.callType == 0 || DialogSkipFragment.this.f18018a.callType == 1) {
                            DialogSkipFragment.this.e = true;
                            textView3.setText(DialogSkipFragment.this.getString(R.string.channel_start_on_live_tip));
                            textView2.setText(DialogSkipFragment.this.getString(R.string.live_window_indicate_know));
                            findViewById.setVisibility(8);
                            textView.setVisibility(8);
                        } else {
                            DialogSkipFragment.this.e = false;
                            textView3.setText(DialogSkipFragment.this.getString(R.string.channel_close_live_tip));
                        }
                    } else if (DialogSkipFragment.this.f == 1) {
                        textView3.setText(DialogSkipFragment.this.getString(R.string.channel_start_on_live_lrs_tip));
                        textView2.setText(DialogSkipFragment.this.getString(R.string.live_window_indicate_know));
                        findViewById.setVisibility(8);
                        textView.setVisibility(8);
                    } else if (DialogSkipFragment.this.f == 2) {
                        textView3.setText(DialogSkipFragment.this.getString(R.string.channel_start_on_live_flash_tip));
                        textView2.setText(DialogSkipFragment.this.getString(R.string.live_window_indicate_know));
                        findViewById.setVisibility(8);
                        textView.setVisibility(8);
                    } else if (DialogSkipFragment.this.f == 3) {
                        textView3.setText(DialogSkipFragment.this.getString(R.string.flash_close_tip));
                    } else if (DialogSkipFragment.this.f == 4) {
                        textView3.setText(DialogSkipFragment.this.getString(R.string.channel_start_on_live_shine_video_tip));
                        textView2.setText(DialogSkipFragment.this.getString(R.string.live_window_indicate_know));
                        findViewById.setVisibility(8);
                        textView.setVisibility(8);
                    } else if (DialogSkipFragment.this.f == 5) {
                        textView3.setText(DialogSkipFragment.this.getString(R.string.channel_close_sharing_video_tip));
                    }
                    DialogSkipFragment.this.d = new CustomDialog(DialogSkipFragment.this.b, 2131952378);
                    DialogSkipFragment.this.d.a(inflate, new CustomDialog.OnBackCallBack() { // from class: com.soft.blued.ui.msg.DialogSkipFragment.1.1
                        public void a() {
                            DialogSkipFragment.this.getActivity().finish();
                        }
                    });
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131371051) {
            a();
        } else if (id != 2131372161) {
        } else {
            int i = this.f;
            if (i == 0) {
                if (!this.e) {
                    ChannelFragment.a(AppInfo.d(), this.f18018a);
                }
            } else if (i == 3) {
                if (FlashZegoApiManager.a().e()) {
                    FlashZegoApiManager.a().a(this.f18018a);
                }
            } else if (i == 5) {
                ShortVideoProxy.e().c();
                ChannelFragment.a(AppInfo.d(), this.f18018a);
            }
            a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        Bundle arguments = getArguments();
        int i2 = arguments.getInt("flag", 0);
        this.f = i2;
        if (i2 == 0 || i2 == 3 || i2 == 5) {
            this.f18018a = (ChannelModel) arguments.getSerializable("CHANNEL");
        }
        if (this.f18018a == null && ((i = this.f) == 0 || i == 3 || i == 5)) {
            getActivity().finish();
        }
        this.b = getActivity();
        View view = this.f18019c;
        if (view == null) {
            this.f18019c = layoutInflater.inflate(R.layout.channel_dialog_layout, viewGroup, false);
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f18019c.getParent()).removeView(this.f18019c);
        }
        return this.f18019c;
    }
}
