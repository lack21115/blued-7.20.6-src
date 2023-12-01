package com.soft.blued.ui.user.utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg_group.model.GroupCommandDetailResp;
import com.soft.blued.ui.msg_group.pop.PopGroupCommand;
import com.soft.blued.ui.user.fragment.CommandFragment;
import com.soft.blued.ui.user.model.WatchWordModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/CommandManager.class */
public class CommandManager {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34326a = CommandManager.class.getSimpleName();
    private static final CommandManager b = new CommandManager();

    /* renamed from: c  reason: collision with root package name */
    private int f34327c = 10;
    private int d;

    private CommandManager() {
    }

    public static CommandManager a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return str.contains("##");
    }

    public static String b(Context context) {
        Context context2 = context;
        if (context == null) {
            context2 = AppInfo.d();
        }
        ClipData primaryClip = ((ClipboardManager) context2.getSystemService(Context.CLIPBOARD_SERVICE)).getPrimaryClip();
        return (primaryClip == null || primaryClip.getItemCount() <= 0 || TextUtils.isEmpty(primaryClip.getItemAt(0).getText())) ? "" : primaryClip.getItemAt(0).getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x007e -> B:10:0x0061). Please submit an issue!!! */
    public void b(String str) {
        String str2;
        Matcher matcher = Pattern.compile("##([^##]+)##").matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
            String str3 = f34326a;
            Log.v(str3, "matcher:" + str2);
        } else {
            str2 = "";
        }
        if (!str2.contains(":G")) {
            MineHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<WatchWordModel>>(null) { // from class: com.soft.blued.ui.user.utils.CommandManager.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<WatchWordModel> bluedEntityA) {
                    if (bluedEntityA.hasData()) {
                        final WatchWordModel watchWordModel = bluedEntityA.data.get(0);
                        if (TextUtils.isEmpty(watchWordModel.image)) {
                            WebViewShowInfoFragment.show(BluedApplicationLike.getForeActivity(), watchWordModel.url, -1);
                        } else {
                            ImageFileLoader.a((IRequestHost) null).a(watchWordModel.image).a(new ImageLoadResult(null) { // from class: com.soft.blued.ui.user.utils.CommandManager.3.1
                                @Override // com.blued.android.core.image.ImageLoadResult
                                public void a() {
                                    CommandFragment.a(BluedApplicationLike.getForeActivity(), watchWordModel);
                                }
                            }).a();
                        }
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str4) {
                    return true;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                }
            }, str2);
            return;
        }
        try {
            ((ClipboardManager) AppInfo.d().getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("Label", ""));
        } catch (Exception e) {
        }
        final String str4 = str2;
        MineHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<GroupCommandDetailResp>>(null) { // from class: com.soft.blued.ui.user.utils.CommandManager.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupCommandDetailResp> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    String str5 = UserInfo.getInstance().getLoginUserInfo().uid;
                    if (str5.equals(bluedEntityA.getSingleData().getUid() + "")) {
                        return;
                    }
                    Activity foreActivity = BluedApplicationLike.getForeActivity();
                    HomeActivity homeActivity = foreActivity;
                    if (foreActivity == null) {
                        homeActivity = foreActivity;
                        if (HomeActivity.f30985c != null) {
                            homeActivity = HomeActivity.f30985c;
                        }
                    }
                    new XPopup.Builder(homeActivity).d((Boolean) true).a(PopupAnimation.ScaleAlphaFromCenter).a((BasePopupView) new PopGroupCommand(homeActivity, str4, bluedEntityA.getSingleData())).h();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str5) {
                return true;
            }
        }, str2);
    }

    static /* synthetic */ int c(CommandManager commandManager) {
        int i = commandManager.d;
        commandManager.d = i + 1;
        return i;
    }

    public void a(final Context context) {
        Log.v(f34326a, "start");
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.utils.CommandManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (BluedPreferences.cr()) {
                    if (CommandManager.this.d < CommandManager.this.f34327c) {
                        CommandManager.c(CommandManager.this);
                        String str = CommandManager.f34326a;
                        Log.v(str, "在开机动画restartCount：" + CommandManager.this.d);
                        CommandManager.this.a(context);
                        return;
                    }
                    return;
                }
                CommandManager.this.d = 0;
                String b2 = CommandManager.b(context);
                String str2 = CommandManager.f34326a;
                Log.v(str2, "getClipData:" + b2);
                if (TextUtils.isEmpty(b2) || !CommandManager.this.a(b2)) {
                    return;
                }
                CommandManager.this.b(b2);
            }
        }, 1000L);
    }
}
