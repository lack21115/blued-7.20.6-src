package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.model.ReportJsonModel;
import com.soft.blued.ui.user.observer.ReportObserver;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportChatFragment.class */
public class ReportChatFragment extends ReportFragmentNew {

    /* renamed from: a  reason: collision with root package name */
    public String f33914a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public Context f33915c;

    public static void a(Context context, String str, String str2, int i, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_CHAT_CONTENT", str);
        bundle.putString("KEY_REPORT_TARGET_ID", str2);
        bundle.putInt("KEY_REPORT_TARGET", i);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str3);
        TransparentActivity.b(context, ReportChatFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Context context = this.f33915c;
        CommonAlertDialog.a(context, (View) null, context.getResources().getString(R.string.report_failed), str, "", new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ReportChatFragment.this.getActivity().finish();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ReportChatFragment.this.getActivity().finish();
            }
        }, true);
    }

    @Override // com.soft.blued.ui.user.fragment.ReportFragmentNew
    protected void a(String str, int i, String str2, String[] strArr) {
        if (this.e != 7) {
            if (this.e == 6) {
                if (this.b != 7) {
                    str = "";
                }
                ChatHttpUtils.a(this.f33915c, new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.2

                    /* renamed from: a  reason: collision with root package name */
                    boolean f33921a = false;
                    String b = "";

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public boolean onUIFailure(int i2, String str3, String str4) {
                        if (BluedHttpUtils.a(null, i2, str4).first.intValue() == 0) {
                            return super.onUIFailure(i2, str3, str4);
                        }
                        switch (i2) {
                            case 403001:
                                CommonAlertDialog.a(ReportChatFragment.this.f33915c, ReportChatFragment.this.f33915c.getResources().getString(R.string.submission_failed), ReportChatFragment.this.f33915c.getResources().getString(R.string.submission_failed_details), ReportChatFragment.this.f33915c.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.2.3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        Tracker.onClick(dialogInterface, i3);
                                    }
                                }, (DialogInterface.OnDismissListener) null, 1);
                                return true;
                            case 403002:
                                CommonAlertDialog.a(ReportChatFragment.this.f33915c, ReportChatFragment.this.f33915c.getResources().getString(R.string.submission_failed), str3, ReportChatFragment.this.f33915c.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.2.4
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        Tracker.onClick(dialogInterface, i3);
                                    }
                                }, (DialogInterface.OnDismissListener) null, 1);
                                return true;
                            default:
                                this.f33921a = true;
                                this.b = str3;
                                return true;
                        }
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIFinish() {
                        super.onUIFinish();
                        if (this.f33921a) {
                            ReportChatFragment.this.a(this.b);
                        }
                        DialogUtils.b(ReportChatFragment.this.h);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIUpdate(BluedEntity bluedEntity) {
                        if (ReportChatFragment.this.e != 7) {
                            AppMethods.d((int) R.string.biao_report_ok);
                            ReportChatFragment.this.getActivity().finish();
                            return;
                        }
                        if (ReportFragmentNew.d != null) {
                            ReportFragmentNew.d.clear();
                        }
                        CommonAlertDialog.a(ReportChatFragment.this.f33915c, (View) null, ReportChatFragment.this.getResources().getString(R.string.report_success_title), ReportChatFragment.this.getResources().getString(R.string.report_success_desc), ReportChatFragment.this.getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.2.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                ReportObserver.a().a(true);
                                ReportChatFragment.this.getActivity().finish();
                            }
                        }, new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.2.2
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                ReportObserver.a().a(true);
                                ReportChatFragment.this.getActivity().finish();
                            }
                        }, false);
                    }
                }, this.f33914a, strArr, this.e, this.f, "", 0L, this.b, str, "", "", 0, getFragmentActive());
                return;
            }
            return;
        }
        ReportJsonModel reportJsonModel = (ReportJsonModel) AppInfo.f().fromJson(this.f33914a, (Class<Object>) ReportJsonModel.class);
        reportJsonModel.report_type = this.b;
        reportJsonModel.reason = str;
        if (this.b == 7) {
            reportJsonModel.reason_desc = str;
        }
        reportJsonModel.check_attachments = 1;
        if (strArr != null && strArr.length > 0) {
            reportJsonModel.attachments = strArr;
        }
        MsgGroupHttpUtils.c(getFragmentActive(), AppInfo.f().toJson(reportJsonModel), new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str3, String str4) {
                if (BluedHttpUtils.a(null, i2, str4).first.intValue() == 0) {
                    return super.onUIFailure(i2, str3, str4);
                }
                switch (i2) {
                    case 403001:
                        CommonAlertDialog.a(ReportChatFragment.this.f33915c, ReportChatFragment.this.f33915c.getResources().getString(R.string.submission_failed), ReportChatFragment.this.f33915c.getResources().getString(R.string.submission_failed_details), ReportChatFragment.this.f33915c.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.1.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Tracker.onClick(dialogInterface, i3);
                            }
                        }, (DialogInterface.OnDismissListener) null, 1);
                        return true;
                    case 403002:
                        CommonAlertDialog.a(ReportChatFragment.this.f33915c, ReportChatFragment.this.f33915c.getResources().getString(R.string.submission_failed), str3, ReportChatFragment.this.f33915c.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.1.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Tracker.onClick(dialogInterface, i3);
                            }
                        }, (DialogInterface.OnDismissListener) null, 1);
                        return true;
                    default:
                        ReportChatFragment.this.a(str3);
                        return true;
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                DialogUtils.b(ReportChatFragment.this.h);
                if (z) {
                    ReportChatFragment.this.getActivity().finish();
                    AppMethods.d((int) R.string.biao_report_ok);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (ReportFragmentNew.d != null) {
                    ReportFragmentNew.d.clear();
                }
                CommonAlertDialog.a(ReportChatFragment.this.f33915c, (View) null, ReportChatFragment.this.getResources().getString(R.string.report_success_title), ReportChatFragment.this.getResources().getString(R.string.report_success_desc), ReportChatFragment.this.getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Tracker.onClick(dialogInterface, i2);
                        ReportObserver.a().a(true);
                        ReportChatFragment.this.getActivity().finish();
                    }
                }, new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.user.fragment.ReportChatFragment.1.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        ReportObserver.a().a(true);
                        ReportChatFragment.this.getActivity().finish();
                    }
                }, false);
            }
        });
    }

    @Override // com.soft.blued.ui.user.fragment.ReportFragmentNew, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 != -1 || intent == null) {
                getActivity().finish();
                return;
            }
            this.b = intent.getIntExtra("KEY_REPORT_ITEM_ID", -1);
            String stringExtra = intent.getStringExtra("KEY_REPORT_ITEM_TEXT");
            if (this.b != 7) {
                a(stringExtra, 0, "", (String[]) null);
            }
        }
    }

    @Override // com.soft.blued.ui.user.fragment.ReportFragmentNew, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33915c = getActivity();
        if (getArguments() != null) {
            this.f33914a = getArguments().getString("KEY_CHAT_CONTENT");
            this.f = getArguments().getString("KEY_REPORT_TARGET_ID");
            this.e = getArguments().getInt("KEY_REPORT_TARGET");
            this.g = getArguments().getString("KEY_REPORT_TARGET_TEXT");
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.soft.blued.ui.user.fragment.ReportFragmentNew, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
