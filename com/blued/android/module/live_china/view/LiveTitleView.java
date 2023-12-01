package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRoomTitleModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveTitleView.class */
public class LiveTitleView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f14935a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f14936c;
    private View d;
    private View e;
    private EditText f;
    private TextView g;
    private RecordingOnliveFragment h;
    private View i;
    private boolean j;
    private TextWatcher k;

    public LiveTitleView(Context context) {
        this(context, null);
    }

    public LiveTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new TextWatcher() { // from class: com.blued.android.module.live_china.view.LiveTitleView.4
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f14941c;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i2;
                this.b = LiveTitleView.this.f.getSelectionStart();
                this.f14941c = LiveTitleView.this.f.getSelectionEnd();
                LiveTitleView.this.f.removeTextChangedListener(LiveTitleView.this.k);
                String trim = LiveTitleView.this.f.getText().toString().trim();
                if (editable.length() > 0) {
                    LiveTitleView.this.i.setVisibility(0);
                } else {
                    LiveTitleView.this.i.setVisibility(8);
                }
                int i3 = 20;
                int i4 = 0;
                while (i4 < trim.length()) {
                    char charAt = trim.charAt(i4);
                    if (charAt < ' ' || charAt > 'z') {
                        i2 = i3;
                        if (i3 > 10) {
                            i2 = i3 - 1;
                        }
                    } else {
                        i2 = i3;
                    }
                    i4++;
                    i3 = i2;
                }
                Logger.a("drb", "mTextMaxLength - ", Integer.valueOf(i3));
                while (editable.length() > i3) {
                    editable.delete(this.b - 1, this.f14941c);
                    this.b--;
                    this.f14941c--;
                }
                LiveTitleView.this.f.setSelection(this.b);
                LiveTitleView.this.f.addTextChangedListener(LiveTitleView.this.k);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        this.b = context;
    }

    public void a() {
        d();
    }

    public void a(int i) {
        if (i == -3) {
            this.j = true;
        } else if (i != -2) {
        } else {
            this.j = false;
        }
    }

    public void a(String str) {
        this.f.setText(str);
    }

    public void a(boolean z, RecordingOnliveFragment recordingOnliveFragment) {
        this.h = recordingOnliveFragment;
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f14936c = from;
        View inflate = from.inflate(z ? R.layout.live_title_view_land : R.layout.live_title_view, this);
        this.d = inflate.findViewById(R.id.ll_content);
        this.e = inflate.findViewById(R.id.live_title_layer);
        this.f14935a = inflate.findViewById(R.id.ll_loading);
        this.f = (EditText) inflate.findViewById(R.id.live_title_edit);
        this.g = (TextView) inflate.findViewById(R.id.live_title_save);
        this.i = inflate.findViewById(R.id.live_title_edit_del);
        this.f.addTextChangedListener(this.k);
        this.e.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    public boolean b() {
        return getVisibility() == 0;
    }

    public void c() {
        setVisibility(0);
        this.d.setVisibility(0);
        this.d.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveTitleView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void d() {
        if (this.d.getVisibility() == 8) {
            return;
        }
        this.d.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveTitleView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveTitleView.this.setVisibility(8);
                if (LiveTitleView.this.j) {
                    KeyboardUtils.a(LiveTitleView.this.h.getActivity());
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void e() {
        if (this.f.getText().length() == 0) {
            return;
        }
        LiveRoomHttpUtils.n(new BluedUIHttpResponse<BluedEntity<LiveRoomTitleModel, LiveRoomTitleModel>>(this.h.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveTitleView.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveTitleView.this.f14935a.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveTitleView.this.f14935a.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRoomTitleModel, LiveRoomTitleModel> bluedEntity) {
                LiveRoomTitleModel liveRoomTitleModel = bluedEntity.extra;
                if (liveRoomTitleModel == null || TextUtils.isEmpty(liveRoomTitleModel.title)) {
                    return;
                }
                LiveTitleView.this.f.setText(liveRoomTitleModel.title);
                LiveTitleView.this.d();
                AppMethods.d(R.string.live_title_save_success);
            }
        }, this.f.getText().toString());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_title_layer) {
            d();
        } else if (view.getId() == R.id.live_title_edit_del) {
            this.f.setText("");
        } else if (view.getId() == R.id.live_title_save) {
            EventTrackLive.a(LiveProtos.Event.LIVE_SETTING_TITLE_SAVE_BTN_CLICK);
            e();
            KeyboardUtils.b(getContext(), this.f);
        }
    }
}
