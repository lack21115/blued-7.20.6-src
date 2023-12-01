package com.soft.blued.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityStack;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.login.activity.PhoneOrEmailLoginActivity;
import com.blued.login.face.AVConfig;
import com.blued.login.face.AVConfigExtra;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.LoginV1ForThreeActivity;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.setting.activity.SwitchAccountActivity;
import com.soft.blued.utils.third.YouMengUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/UserRelationshipUtils.class */
public class UserRelationshipUtils {
    private static final String m = UserRelationshipUtils.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static ArrayMap<String, String> f21107a = new ArrayMap<>();
    public static ArrayMap<String, String> b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayMap<String, String> f21108c = new ArrayMap<>();
    public static ArrayMap<String, String> d = new ArrayMap<>();
    public static ArrayMap<String, String> e = new ArrayMap<>();
    public static ArrayMap<String, String> f = new ArrayMap<>();
    public static ArrayMap<String, String> g = new ArrayMap<>();
    public static ArrayMap<String, String> h = new ArrayMap<>();
    public static ArrayMap<String, String> i = new ArrayMap<>();
    public static ArrayMap<String, String> j = new ArrayMap<>();
    public static ArrayMap<String, String> k = new ArrayMap<>();
    public static int[] l = {4, 5, 6, 7};

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/UserRelationshipUtils$IAddOrRemoveAttentionDone.class */
    public interface IAddOrRemoveAttentionDone {
        void a();

        void a(String str);

        void b();

        void b(String str);

        void c();
    }

    public static int a(int i2, int i3, int i4, int i5) {
        if (i2 == 1) {
            return 1;
        }
        int i6 = (i3 != 0 || i4 == 1) ? 0 : i4 == 0 ? 2 : 4;
        if (i5 == 0) {
            i6 = 3;
        }
        return i6;
    }

    public static int a(String str) {
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.race_array_key_more);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= stringArray.length) {
                return -1;
            }
            if (str.equals(stringArray[i3])) {
                return i3 - 1;
            }
            i2 = i3 + 1;
        }
    }

    public static String a(Short sh, long j2) {
        int parseInt = Integer.parseInt(String.valueOf(j2));
        return sh.shortValue() == 2 ? "MN" : sh.shortValue() == 3 ? "PN" : parseInt != 1 ? parseInt != 3 ? parseInt != 5 ? "PN" : "FN" : "TN" : "AN";
    }

    public static void a() {
        Iterator it = ActivityStack.a().b().iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (activity.getClass() != LoginV1ForThreeActivity.class && activity.getClass() != SignInActivity.class && activity.getClass() != PhoneOrEmailLoginActivity.class && activity.getClass() != SwitchAccountActivity.class && !activity.getClass().getSimpleName().equals("OneLoginActivity") && !a(activity)) {
                String str = m;
                Logger.c(str, "切换账号-移除： " + activity.getClass().getSimpleName());
                activity.finish();
            }
        }
    }

    public static void a(Context context, TextView textView, UserBasicModel userBasicModel) {
        UserInfoHelper.a(context, textView, userBasicModel, -1);
    }

    public static void a(Context context, UserBasicModel userBasicModel, long j2, String str) {
        a(context, userBasicModel, j2, str, (List<BluedLiveListData>) null);
    }

    public static void a(Context context, UserBasicModel userBasicModel, long j2, String str, String str2, String str3, int i2, List<UserFindResult> list) {
        LiveRoomData liveRoomData = new LiveRoomData(j2, 0, str, userBasicModel.uid, userBasicModel.name, userBasicModel.avatar, userBasicModel.vbadge);
        liveRoomData.liveFrom = str2;
        liveRoomData.recommendType = str3;
        liveRoomData.livePosition = i2;
        List<LiveRoomData> a2 = LiveRoomInfoChannel.a((List<BluedLiveListData>) null, str);
        ArrayList arrayList = a2;
        if (a2 == null) {
            arrayList = new ArrayList();
        }
        if (list != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    break;
                }
                UserFindResult userFindResult = list.get(i4);
                if (userFindResult.live_info != null) {
                    arrayList.add(new LiveRoomData(userFindResult.live_info.lid, 0, str, userFindResult.uid, userFindResult.name, userFindResult.avatar, userFindResult.vbadge));
                }
                i3 = i4 + 1;
            }
        }
        arrayList.add(liveRoomData);
        arrayList.addAll(LiveRoomManager.a().a(str));
        LiveRoomInfoChannel.a(context, liveRoomData, 0, arrayList);
    }

    public static void a(Context context, UserBasicModel userBasicModel, long j2, String str, List<BluedLiveListData> list) {
        LiveRoomInfoChannel.a(context, new LiveRoomData(j2, 0, str, userBasicModel.uid, userBasicModel.name, userBasicModel.avatar, userBasicModel.vbadge), -1, LiveRoomInfoChannel.a(list, str));
    }

    public static void a(Context context, IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, IRequestHost iRequestHost) {
        UserHttpUtils.a(context, iAddOrRemoveAttentionDone, str, "", iRequestHost);
    }

    public static void a(final Context context, final IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, final String str, String str2, String str3, final IRequestHost iRequestHost, boolean z) {
        if (!"3".equals(str2) && !"1".equals(str2)) {
            UserHttpUtils.b(context, iAddOrRemoveAttentionDone, str, str3, iRequestHost);
        } else if (z) {
            CommonAlertDialog.a(context, context.getResources().getString(R.string.common_string_notice), context.getResources().getString(2131886888), context.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.utils.UserRelationshipUtils.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                    UserRelationshipUtils.a(Context.this, iAddOrRemoveAttentionDone, str, iRequestHost);
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            UserHttpUtils.a(context, iAddOrRemoveAttentionDone, str, str3, iRequestHost);
        }
    }

    public static void a(Context context, final String str) {
        final Dialog a2 = DialogUtils.a(context);
        LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedEntityBaseExtra>>() { // from class: com.soft.blued.utils.UserRelationshipUtils.6

            /* renamed from: c  reason: collision with root package name */
            private boolean f21117c = false;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedEntityBaseExtra> bluedEntityA) {
            }

            public boolean onUIFailure(int i2, String str2) {
                if (i2 == 4036501) {
                    this.f21117c = true;
                    return true;
                }
                return true;
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(Dialog.this);
                if (this.f21117c) {
                    UserRelationshipUtils.a(str, new int[0]);
                }
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(Dialog.this);
            }
        });
    }

    public static void a(Context context, String str, TextView textView, ImageView imageView, boolean z) {
        if (StringUtils.d(str)) {
            return;
        }
        if (textView != null) {
            if (z) {
                textView.setTextColor(context.getResources().getColor(BluedSkinUtils.c() ? 2131102260 : 2131102262));
            }
            if ("0".equals(str)) {
                textView.setText(2131886495);
                if (z) {
                    textView.setTextColor(context.getResources().getColor(2131101766));
                }
            } else if ("1".equals(str)) {
                textView.setText(2131888173);
            } else if ("2".equals(str)) {
                textView.setText(2131886577);
            } else if ("3".equals(str)) {
                textView.setText(2131888166);
            } else {
                textView.setText(2131886495);
            }
        }
        if (imageView != null) {
            if ("0".equals(str)) {
                imageView.setImageResource(2131233955);
            } else if ("1".equals(str)) {
                imageView.setImageResource(2131233962);
            } else if ("2".equals(str)) {
                imageView.setImageResource(2131233955);
            } else if ("3".equals(str)) {
                imageView.setImageResource(2131233981);
            } else {
                imageView.setImageResource(2131233955);
            }
        }
    }

    public static void a(Context context, String str, String str2, TextView textView) {
        if (textView == null) {
            return;
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else if (!str.toLowerCase().contains(str3.toLowerCase())) {
            textView.setText(str);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            String lowerCase = str.toLowerCase();
            String lowerCase2 = str3.toLowerCase();
            int length = lowerCase2.length();
            int indexOf = lowerCase.indexOf(lowerCase2);
            if (indexOf >= 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, 2131101766)), indexOf, length + indexOf, 33);
            }
            textView.setText(spannableStringBuilder);
        }
    }

    public static void a(ImageView imageView, UserBasicModel userBasicModel) {
        UserInfoHelper.a(imageView, userBasicModel);
    }

    public static void a(ImageView imageView, MineEntryInfo.VipInfo vipInfo) {
        if (vipInfo != null) {
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.expire_type = vipInfo.expire_type;
            userBasicModel.vip_grade = vipInfo.vip_grade;
            userBasicModel.is_vip_annual = vipInfo.is_vip_annual;
            userBasicModel.vip_exp_lvl = vipInfo.vip_exp_lvl;
            a(imageView, userBasicModel);
        }
    }

    public static void a(final Runnable runnable, final String str) {
        if (!UserInfo.getInstance().isLogin()) {
            runnable.run();
            return;
        }
        PushManager.a().f();
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<AppConfigModel>>() { // from class: com.soft.blued.utils.UserRelationshipUtils.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AppConfigModel> bluedEntityA) {
                if (runnable != null) {
                    UserRelationshipUtils.a(str, new int[0]);
                    runnable.run();
                }
            }

            public void onFailure(Throwable th) {
                super.onFailure(th);
            }

            public void onFailure(Throwable th, int i2, String str2) {
                super.onFailure(th, i2, str2);
            }
        }, (IRequestHost) null, 1);
    }

    public static void a(String str, TextView textView, ImageView imageView) {
        if (StringUtils.d(str) || textView == null || imageView == null) {
            return;
        }
        if ("0".equals(str)) {
            textView.setText(2131886495);
            imageView.setImageResource(R.drawable.card_attention);
        } else if ("1".equals(str)) {
            textView.setText(2131888173);
            imageView.setImageResource(R.drawable.card_attentioned_write);
        } else if ("2".equals(str)) {
            textView.setText(2131886577);
            imageView.setImageResource(R.drawable.card_attentioned_write);
        } else if ("3".equals(str)) {
            textView.setText(2131888166);
            imageView.setImageResource(R.drawable.icon_usercard_each);
        }
    }

    public static void a(final String str, final int... iArr) {
        if (UserInfo.getInstance().isLogin()) {
            YouMengUtils.b();
            Runnable runnable = new Runnable() { // from class: com.soft.blued.utils.UserRelationshipUtils.1
                /* JADX WARN: Code restructure failed: missing block: B:21:0x00de, code lost:
                    if (r4.equals("bind_Acc") != false) goto L14;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 425
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.utils.UserRelationshipUtils.AnonymousClass1.run():void");
                }
            };
            if (AppMethods.b()) {
                runnable.run();
            } else {
                AppInfo.n().post(runnable);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
        if (r0.a(com.blued.login.fragment.LoginMainFragment.class) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.app.Activity r3) {
        /*
            r0 = r3
            boolean r0 = r0 instanceof com.blued.android.core.ui.TerminalActivity
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L2a
            r0 = r3
            com.blued.android.core.ui.TerminalActivity r0 = (com.blued.android.core.ui.TerminalActivity) r0
            r3 = r0
            r0 = r3
            java.lang.Class<com.soft.blued.ui.login_register.View.OneLoginFragmentNew> r1 = com.soft.blued.ui.login_register.View.OneLoginFragmentNew.class
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto L28
            r0 = r5
            r4 = r0
            r0 = r3
            java.lang.Class<com.blued.login.fragment.LoginMainFragment> r1 = com.blued.login.fragment.LoginMainFragment.class
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L2a
        L28:
            r0 = 1
            r4 = r0
        L2a:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.utils.UserRelationshipUtils.a(android.app.Activity):boolean");
    }

    public static int b(Context context, String str) {
        int i2;
        String[] stringArray = context.getResources().getStringArray(R.array.relation_status_array);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i2 = 0;
            if (i4 >= stringArray.length) {
                break;
            } else if (stringArray[i4].equals(str)) {
                i2 = i4;
                break;
            } else {
                i3 = i4 + 1;
            }
        }
        return i2 + 1;
    }

    public static int b(String str) {
        int i2 = 0;
        if (!StringUtils.d(str)) {
            if (str.contains("'") && str.contains("\"")) {
                return (int) Math.round((StringUtils.a(str.split("'")[0], 0.0d) + (StringUtils.a(str.split("'")[1].replace("\"", ""), 0.0d) / 12.0d)) * 30.48d);
            }
            i2 = StringUtils.a(str, 0);
        }
        return i2;
    }

    public static void b() {
        if (UserInfo.getInstance().isLogin()) {
            int loginType = UserInfo.getInstance().getLoginType();
            if (loginType == 0 || loginType == 1) {
                i();
            } else if (loginType != 2) {
            } else {
                j();
            }
        }
    }

    public static void b(Context context, UserBasicModel userBasicModel, long j2, String str, String str2, String str3, int i2, List<UserFindResult> list) {
        boolean z;
        LiveRoomData liveRoomData = new LiveRoomData(j2, 0, str, userBasicModel.uid, userBasicModel.name, userBasicModel.avatar, userBasicModel.vbadge);
        liveRoomData.liveFrom = str2;
        liveRoomData.recommendType = str3;
        liveRoomData.livePosition = i2;
        List<LiveRoomData> a2 = LiveRoomInfoChannel.a((List<BluedLiveListData>) null, str);
        ArrayList arrayList = a2;
        if (a2 == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(liveRoomData);
        if (list != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    break;
                }
                UserFindResult userFindResult = list.get(i4);
                if (userFindResult.live_info != null && userFindResult.live_info.lid != j2) {
                    LiveRoomData liveRoomData2 = new LiveRoomData(userFindResult.live_info.lid, 0, str, userFindResult.uid, userFindResult.name, userFindResult.avatar, userFindResult.vbadge);
                    liveRoomData.liveFrom = str2;
                    liveRoomData.recommendType = str3;
                    liveRoomData.livePosition = userFindResult.userPositionReal + 1;
                    arrayList.add(liveRoomData2);
                }
                i3 = i4 + 1;
            }
        }
        for (LiveRoomData liveRoomData3 : LiveRoomManager.a().a(str)) {
            Iterator<LiveRoomData> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().lid == liveRoomData3.lid) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                arrayList.add(liveRoomData3);
            }
        }
        LiveRoomInfoChannel.a(context, liveRoomData, 0, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Runnable runnable, int i2) {
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<AppConfigModel>>() { // from class: com.soft.blued.utils.UserRelationshipUtils.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AppConfigModel> bluedEntityA) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }

            public void onFailure(Throwable th) {
            }
        }, (IRequestHost) null, i2);
    }

    public static int c(String str) {
        if (StringUtils.d(str)) {
            return 0;
        }
        String str2 = str;
        if (str.contains("lbs")) {
            str2 = str.replace("lbs", "");
        }
        return (int) Math.round(StringUtils.a(str2, 0.0d) / 2.2d);
    }

    public static ArrayMap<String, String> c() {
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.bloodtype_key);
        String[] stringArray2 = AppInfo.d().getResources().getStringArray(R.array.bloodtype);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= stringArray.length) {
                return e;
            }
            e.put(stringArray[i3], stringArray2[i3]);
            i2 = i3 + 1;
        }
    }

    public static ArrayMap<String, String> d() {
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.bloodtype);
        String[] stringArray2 = AppInfo.d().getResources().getStringArray(R.array.bloodtype_key);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= stringArray.length) {
                return f;
            }
            f.put(stringArray[i3], stringArray2[i3]);
            i2 = i3 + 1;
        }
    }

    public static ArrayMap<String, String> e() {
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.detection_result_key);
        String[] stringArray2 = AppInfo.d().getResources().getStringArray(R.array.detection_result);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= stringArray.length) {
                return i;
            }
            i.put(stringArray[i3], stringArray2[i3]);
            i2 = i3 + 1;
        }
    }

    public static ArrayMap<String, String> f() {
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.detection_prep_key);
        String[] stringArray2 = AppInfo.d().getResources().getStringArray(R.array.detection_prep);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= stringArray.length) {
                return j;
            }
            j.put(stringArray[i3], stringArray2[i3]);
            i2 = i3 + 1;
        }
    }

    public static ArrayMap<String, String> g() {
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.register_time_key);
        String[] stringArray2 = AppInfo.d().getResources().getStringArray(R.array.register_time);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= stringArray.length) {
                return k;
            }
            k.put(stringArray[i3], stringArray2[i3]);
            i2 = i3 + 1;
        }
    }

    private static void i() {
        final String userName = UserInfo.getInstance().getUserName();
        final int loginType = UserInfo.getInstance().getLoginType();
        String str = loginType == 0 ? "email" : loginType == 1 ? "mobile" : null;
        Logger.b(m, "==底层=自主登录==for===", str);
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>() { // from class: com.soft.blued.utils.UserRelationshipUtils.4

            /* renamed from: a  reason: collision with root package name */
            String f21113a = "";

            public void onFailure(Throwable th, int i2, String str2) {
                super.onFailure(th, i2, str2);
                try {
                    if (StringUtils.d(str2)) {
                        return;
                    }
                    Logger.b(UserRelationshipUtils.m, "===error", "responseCode:", Integer.valueOf(i2), ",responseJson:", str2);
                    if (i2 != 403) {
                        if (i2 != 500) {
                            BluedHttpUtils.b(th, i2, str2);
                            return;
                        }
                        return;
                    }
                    Pair a2 = BluedHttpUtils.a(th, i2, str2);
                    switch (((Integer) a2.first).intValue()) {
                        case 403600:
                        case 403800:
                        case 403801:
                            UserRelationshipUtils.a(AppInfo.d().getResources().getString(R.string.account_abnormal) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + a2.first, new int[0]);
                            return;
                        case 4036501:
                            UserRelationshipUtils.a(AppInfo.d().getResources().getString(R.string.e4036501), new int[0]);
                            return;
                        default:
                            return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    return;
                }
                if (bluedEntity.extra != null) {
                    AVConfig.a().a(((AVConfigExtra) bluedEntity.extra).f6932a, AVConfig.a().f6930a);
                }
                PushManager.a().d();
                int i2 = loginType;
                int i3 = (i2 != 0 && i2 == 1) ? 1 : 0;
                try {
                    String a2 = AesCrypto2.a(((BluedLoginResult) bluedEntity.data.get(0)).getEncrypted());
                    Logger.b(UserRelationshipUtils.m, "解密：deData===", a2);
                    BluedLoginResult bluedLoginResult = (BluedLoginResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedLoginResult.class);
                    CrashReport.setUserId(bluedLoginResult.uid);
                    YouMengUtils.a(bluedLoginResult.uid);
                    String str2 = UserRelationshipUtils.m;
                    Logger.c(str2, "relation_mobile" + bluedLoginResult.getVerified_bindings().relation_mobile);
                    UserInfo.getInstance().saveUserInfo(userName, i3, this.f21113a, bluedLoginResult, new String[0]);
                    String str3 = UserRelationshipUtils.m;
                    Logger.c(str3, "IM=token==UserRenew=" + bluedLoginResult.getAccess_token());
                    LoginRegisterTools.a();
                } catch (Exception e2) {
                }
            }

            public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str2) {
                this.f21113a = str2;
                return super.parseData(str2);
            }
        }, str, LoginRegisterTools.f(UserInfo.getInstance().getAccessToken()), UserInfo.getInstance().getLoginUserInfo().uid);
    }

    private static void j() {
        final String userName = UserInfo.getInstance().getUserName();
        if (StringUtils.d(userName)) {
            return;
        }
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>() { // from class: com.soft.blued.utils.UserRelationshipUtils.5

            /* renamed from: a  reason: collision with root package name */
            String f21115a = "";

            public void onFailure(Throwable th, int i2, String str) {
                super.onFailure(th, i2, str);
                try {
                    if (StringUtils.d(str)) {
                        return;
                    }
                    Logger.b(UserRelationshipUtils.m, "===error", "responseCode:", Integer.valueOf(i2), ",responseJson:", str);
                    if (i2 != 403) {
                        if (i2 != 500) {
                            BluedHttpUtils.b(th, i2, str);
                            return;
                        }
                        return;
                    }
                    Pair a2 = BluedHttpUtils.a(th, i2, str);
                    switch (((Integer) a2.first).intValue()) {
                        case 403600:
                        case 403800:
                        case 403801:
                        case 4036303:
                            UserRelationshipUtils.a(AppInfo.d().getResources().getString(R.string.account_abnormal) + "-Error code: " + a2.first, new int[0]);
                            return;
                        case 4036301:
                        case 4036302:
                            UserRelationshipUtils.a(AppInfo.d().getResources().getString(R.string.account_abnormal) + " -Error code: " + a2.first, new int[0]);
                            return;
                        case 4036501:
                            UserRelationshipUtils.a(AppInfo.d().getResources().getString(R.string.e4036501), new int[0]);
                            return;
                        default:
                            return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    return;
                }
                if (bluedEntity.extra != null) {
                    AVConfig.a().a(((AVConfigExtra) bluedEntity.extra).f6932a, false);
                }
                try {
                    BluedLoginResult bluedLoginResult = (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(((BluedLoginResult) bluedEntity.data.get(0)).getEncrypted()), (Class<Object>) BluedLoginResult.class);
                    CrashReport.setUserId(bluedLoginResult.uid);
                    YouMengUtils.a(bluedLoginResult.uid);
                    String str = UserRelationshipUtils.m;
                    Logger.c(str, "relation_mobile" + bluedLoginResult.getVerified_bindings().relation_mobile);
                    UserInfo.getInstance().saveUserInfo(userName, 2, this.f21115a, bluedLoginResult, new String[0]);
                } catch (Exception e2) {
                }
            }

            public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str) {
                this.f21115a = str;
                return super.parseData(str);
            }
        }, "weixin", LoginRegisterTools.f(UserInfo.getInstance().getAccessToken()), UserInfo.getInstance().getLoginUserInfo().uid);
    }
}
