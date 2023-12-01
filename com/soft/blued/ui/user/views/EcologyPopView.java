package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.EcoVoteJsonParse;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/EcologyPopView.class */
public class EcologyPopView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f34366a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f34367c;
    private LinearLayout d;
    private ShapeTextView e;
    private LinearLayout f;
    private ShapeTextView g;
    private ShapeTextView h;
    private ShapeTextView i;
    private String j;
    private String k;
    private IRequestHost l;
    private View.OnClickListener m;
    private View n;

    public EcologyPopView(Context context) {
        super(context);
        a(context);
    }

    public EcologyPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public EcologyPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a() {
        this.n = findViewById(2131368824);
        this.f34367c = (ImageView) findViewById(2131364488);
        this.d = (LinearLayout) findViewById(R.id.ll_result_option);
        this.e = (ShapeTextView) findViewById(R.id.tv_back);
        this.f = (LinearLayout) findViewById(R.id.ll_quest_option);
        this.g = (ShapeTextView) findViewById(R.id.tv_is_trash);
        this.h = (ShapeTextView) findViewById(R.id.tv_no_trash);
        this.i = (ShapeTextView) findViewById(R.id.tv_no_idea);
        a(this.g, 2131102360);
        a(this.h, 2131102360);
        a(this.i, 2131102360);
        b(this.g, 2131102254);
        b(this.h, 2131102254);
        b(this.i, 2131102254);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        setVisibility(8);
    }

    private void a(ShapeTextView shapeTextView, int i) {
        ShapeHelper.b(shapeTextView, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    private void b(ShapeTextView shapeTextView, int i) {
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        a(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        Tracker.onClick(view);
        a(1);
    }

    public void a(int i) {
        if (i == 0) {
            EventTrackPersonalProfile.a(this.j, PersonalProfileProtos.VoteOption.UNCERTAIN);
        } else if (i == 1) {
            EventTrackPersonalProfile.a(this.j, PersonalProfileProtos.VoteOption.IS_JUNK);
        } else if (i == 2) {
            EventTrackPersonalProfile.a(this.j, PersonalProfileProtos.VoteOption.NOT_JUNK);
        }
        UserHttpUtils.a(this.j, i, new BluedUIHttpResponse<BluedEntityA<EcoVoteJsonParse>>(this.l) { // from class: com.soft.blued.ui.user.views.EcologyPopView.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EcoVoteJsonParse> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                EcoVoteJsonParse ecoVoteJsonParse = bluedEntityA.data.get(0);
                if (ecoVoteJsonParse == null || StringUtils.d(ecoVoteJsonParse.next_uid) || "0".equals(ecoVoteJsonParse.next_uid)) {
                    EcologyPopView.this.f.setVisibility(8);
                    EcologyPopView.this.d.setVisibility(0);
                    return;
                }
                EcologyPopView.this.k = ecoVoteJsonParse.next_uid;
                if (EcologyPopView.this.m != null) {
                    EcologyPopView.this.m.onClick(EcologyPopView.this);
                }
                UserInfoFragmentNew.a(EcologyPopView.this.f34366a, EcologyPopView.this.k);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                EcologyPopView.this.n.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                EcologyPopView.this.n.setVisibility(0);
            }
        }, this.l);
    }

    public void a(Context context) {
        this.f34366a = context;
        this.b = LayoutInflater.from(context).inflate(R.layout.view_ecology_pop, this);
        a();
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.views.-$$Lambda$EcologyPopView$ofBMmRhjY0qX8yGo544fnXbnVF8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EcologyPopView.this.e(view);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.views.-$$Lambda$EcologyPopView$UUsk60dI5tAdiPJNO4ZwcEzBs0U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EcologyPopView.this.d(view);
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.views.-$$Lambda$EcologyPopView$E_FS1E0uFBtIp2mlndfEPiQHoM4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EcologyPopView.this.c(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.views.-$$Lambda$EcologyPopView$6E7ss3Uv4l2vaGqT11rOtnIRsCA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EcologyPopView.this.b(view);
            }
        });
        this.f34367c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.views.-$$Lambda$EcologyPopView$gzClnMZrzXwxO7HdGnyFIGHFoaE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EcologyPopView.this.a(view);
            }
        });
        getConfig();
    }

    public void a(String str, IRequestHost iRequestHost, View.OnClickListener onClickListener) {
        this.j = str;
        this.l = iRequestHost;
        this.m = onClickListener;
        setVisibility(0);
        this.f.setVisibility(0);
        this.d.setVisibility(8);
        this.f34367c.setVisibility(8);
    }

    public void getConfig() {
        UserHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<EcoVoteJsonParse>>(this.l) { // from class: com.soft.blued.ui.user.views.EcologyPopView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EcoVoteJsonParse> bluedEntityA) {
                EcoVoteJsonParse ecoVoteJsonParse;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (ecoVoteJsonParse = bluedEntityA.data.get(0)) == null) {
                    return;
                }
                EcologyPopView.this.e.setText(ecoVoteJsonParse.voted_button1);
                EcologyPopView.this.g.setText(ecoVoteJsonParse.vote_option1);
                EcologyPopView.this.h.setText(ecoVoteJsonParse.vote_option2);
                EcologyPopView.this.i.setText(ecoVoteJsonParse.vote_option3);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                EcologyPopView.this.n.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                EcologyPopView.this.n.setVisibility(0);
            }
        }, this.l);
    }
}
