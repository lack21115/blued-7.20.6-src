package com.soft.blued.ui.welcome;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.manager.CommunityManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.login_register.model.UpdateTerms;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/PrivacyClauseDialog.class */
public class PrivacyClauseDialog extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f20850a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f20851c;
    private TextView d;
    private TextView e;
    private TextView f;
    private UpdateTerms g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.welcome.PrivacyClauseDialog$5  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/PrivacyClauseDialog$5.class */
    public class AnonymousClass5 extends BluedUIHttpResponse<BluedEntityA<UpdateTerms>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f20856a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(IRequestHost iRequestHost, Context context) {
            super(iRequestHost);
            this.f20856a = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<UpdateTerms> bluedEntityA) {
            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                return;
            }
            UpdateTerms updateTerms = (UpdateTerms) bluedEntityA.getSingleData();
            if (!PrivacyClauseDialog.b(updateTerms)) {
                if (isActive()) {
                    PrivacyClauseDialog.b(this.f20856a);
                    return;
                }
                return;
            }
            PrivacyClauseDialog privacyClauseDialog = new PrivacyClauseDialog(this.f20856a, updateTerms);
            privacyClauseDialog.show();
            CommunityManager.a.a().f(true);
            privacyClauseDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.5.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    CommunityManager.a.a().f(false);
                    AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass5.this.isActive()) {
                                PrivacyClauseDialog.b(AnonymousClass5.this.f20856a);
                            }
                        }
                    }, 500L);
                }
            });
        }
    }

    public PrivacyClauseDialog(Context context, UpdateTerms updateTerms) {
        super(context);
        this.f20850a = context;
        this.g = updateTerms;
    }

    private void a() {
        this.b = (TextView) findViewById(2131371186);
        this.f20851c = (TextView) findViewById(R.id.tv_link1);
        this.d = (TextView) findViewById(R.id.tv_link2);
        this.e = (TextView) findViewById(R.id.tv_one);
        this.f = (TextView) findViewById(R.id.tv_two);
        UpdateTerms updateTerms = this.g;
        if (updateTerms == null) {
            return;
        }
        this.b.setText(updateTerms.description);
        if (this.g.jump_links.size() > 0) {
            this.f20851c.setVisibility(0);
            this.f20851c.setText(this.g.jump_links.get(0).text);
            this.f20851c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (PrivacyClauseDialog.this.g != null) {
                        WebViewShowInfoFragment.show(PrivacyClauseDialog.this.f20850a, PrivacyClauseDialog.this.g.jump_links.get(0).link, 0);
                    }
                }
            });
        } else {
            this.f20851c.setVisibility(8);
        }
        if (this.g.jump_links.size() > 1) {
            this.d.setVisibility(0);
            this.d.setText(this.g.jump_links.get(1).text);
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (PrivacyClauseDialog.this.g != null) {
                        WebViewShowInfoFragment.show(PrivacyClauseDialog.this.f20850a, PrivacyClauseDialog.this.g.jump_links.get(1).link, 0);
                    }
                }
            });
        } else {
            this.d.setVisibility(8);
        }
        if (this.g.button.size() > 0) {
            this.e.setVisibility(0);
            this.e.setText(this.g.button.get(0).text);
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FindHttpUtils.a(PrivacyClauseDialog.this.g.button.get(0).click_url);
                    PrivacyClauseDialog privacyClauseDialog = PrivacyClauseDialog.this;
                    privacyClauseDialog.a(privacyClauseDialog.g.button.get(0).click_type);
                }
            });
        } else {
            this.e.setVisibility(8);
        }
        if (this.g.button.size() <= 1) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        this.f.setText(this.g.button.get(1).text);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FindHttpUtils.a(PrivacyClauseDialog.this.g.button.get(1).click_url);
                PrivacyClauseDialog privacyClauseDialog = PrivacyClauseDialog.this;
                privacyClauseDialog.a(privacyClauseDialog.g.button.get(1).click_type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            dismiss();
        } else {
            UserRelationshipUtils.a("", new int[0]);
        }
    }

    public static void a(Context context, IRequestHost iRequestHost) {
        b(context, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context) {
        if (BluedPreferences.fm()) {
            CommunityManager.a.a().f(true);
            BluedAlertDialog a2 = CommonAlertDialog.a(context, context.getString(2131891631), context.getString(2131891630), context.getString(2131891629), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    BluedPreferences.fn();
                    CommunityManager.a.a().f(false);
                }
            }, (DialogInterface.OnDismissListener) null, 0);
            a2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    CommunityManager.a.a().f(false);
                }
            });
            a2.a(false);
            TextView h = a2.h();
            h.setMovementMethod(LinkMovementClickMethod.a());
            h.setText(StringUtils.a(new SpannableStringBuilder(h.getText().toString()), context.getString(R.string.hello_subscribe), new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.PrivacyClauseDialog.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(Context.this, H5Url.a(34), 0);
                }
            }));
        }
    }

    private static void b(Context context, IRequestHost iRequestHost) {
        AppHttpUtils.a(context, new AnonymousClass5(iRequestHost, context), iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(UpdateTerms updateTerms) {
        return (updateTerms == null || updateTerms.is_open != 1 || TextUtils.isEmpty(updateTerms.description) || updateTerms.jump_links == null || updateTerms.jump_links.size() <= 0 || updateTerms.button == null || updateTerms.button.size() <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_privacy_clause);
        a();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
