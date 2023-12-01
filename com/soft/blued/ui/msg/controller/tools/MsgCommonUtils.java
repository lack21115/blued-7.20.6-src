package com.soft.blued.ui.msg.controller.tools;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.video.fragment.VideoScanFragment;
import com.blued.das.message.MessageProtos;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.ReportChatFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/MsgCommonUtils.class */
public class MsgCommonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32265a = MsgCommonUtils.class.getSimpleName();

    /* renamed from: com.soft.blued.ui.msg.controller.tools.MsgCommonUtils$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/MsgCommonUtils$2.class */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32266a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0131 -> B:131:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0135 -> B:143:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0139 -> B:139:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x013d -> B:151:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0141 -> B:147:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0145 -> B:109:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0149 -> B:105:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x014d -> B:115:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0151 -> B:111:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0155 -> B:119:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0159 -> B:117:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x015d -> B:123:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0161 -> B:121:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0165 -> B:127:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0169 -> B:125:0x00b8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x016d -> B:133:0x00c4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0171 -> B:129:0x00d0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0175 -> B:141:0x00dc). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0179 -> B:137:0x00e8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x017d -> B:149:0x00f4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0181 -> B:145:0x0100). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x0185 -> B:107:0x010c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0189 -> B:103:0x0118). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x018d -> B:113:0x0124). Please submit an issue!!! */
        static {
            int[] iArr = new int[MessageProtos.StrangerSource.values().length];
            f32266a = iArr;
            try {
                iArr[MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FRIEND_NEARBY_VISIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FRIEND_NEARBY_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FRIEND_NEARBY_NEARBY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FRIEND_NEARBY_ONLINE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FRIEND_NEARBY_NEW_FACE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FRIEND_NEARBY_PERSONAL_NEARBY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FOLLOW_ATTENTION.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FEED_FIND_PHOTO.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FEED_NEARBY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FEED_FIND_PLAZA.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FEED_PERSONAL_TOPIC.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.FEED_NOT_SUPER_EXPOSURE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.APPRECIATE_CALL_SHORT.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.APPRECIATE_CALL_TOTAL.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.APPRECIATE_CALL_COMPLEX.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.APPRECIATE_CALL_ONLINE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.APPRECIATE_NEARBY.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.APPRECIATE_FIND.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.APPRECIATE_SUPER_EXPOSURE.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.LIVE.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.MINE_FOLLOW.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.MINE_FAN.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.MAP_FIND.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f32266a[MessageProtos.StrangerSource.SHADOW_SOURCE.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x012c, code lost:
        if (r8.size() <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0155, code lost:
        if (r10.size() <= 0) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity.SecureNotify a(com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity.SecureNotify r3) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.controller.tools.MsgCommonUtils.a(com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity$SecureNotify):com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity$SecureNotify");
    }

    private static CharSequence a(CharSequence charSequence, int i, int i2) {
        return TextUtils.isEmpty(charSequence) ? charSequence : Emotion.a(charSequence, i, i2);
    }

    public static String a(Context context, long j) {
        return TimeAndDateUtils.g(j) ? TimeAndDateUtils.f(j) ? TimeAndDateUtils.f.get().format(new Date(j)) : TimeAndDateUtils.h(j) ? context.getResources().getString(R.string.biao_msg_yesterday) : TimeAndDateUtils.g.get().format(new Date(j)) : TimeAndDateUtils.f10913a.get().format(new Date(j));
    }

    public static String a(Context context, MessageProtos.StrangerSource strangerSource, String str, String str2) {
        String str3 = "";
        if (strangerSource != null) {
            EventTrackMessage.a(MessageProtos.Event.MSG_PRIVATE_STRANGER_SOURCE_PROMPT, strangerSource, str2);
            switch (AnonymousClass2.f32266a[strangerSource.ordinal()]) {
                case 2:
                    str3 = context.getResources().getString(R.string.he_noticed_your_visit);
                    break;
                case 3:
                    return context.getResources().getString(R.string.he_visited_you_several_times);
                case 4:
                    return context.getResources().getString(R.string.he_found_you_from_nearby);
                case 5:
                    return context.getResources().getString(R.string.he_found_you_from_online);
                case 6:
                    return context.getResources().getString(R.string.he_found_you_from_new_face);
                case 7:
                    return String.format(context.getResources().getString(R.string.your_tag_attracted_him), str);
                case 8:
                    return context.getResources().getString(R.string.he_noticed_your_follow);
                case 9:
                    return context.getResources().getString(R.string.he_found_you_from_your_post_on_shine_video);
                case 10:
                    return context.getResources().getString(R.string.he_found_you_from_your_post_on_buzz);
                case 11:
                    return context.getResources().getString(R.string.he_found_you_from_your_post_on_square);
                case 12:
                    return context.getResources().getString(R.string.he_found_you_from_your_post_on_topic);
                case 13:
                    return context.getResources().getString(R.string.he_found_you_from_your_post);
                case 14:
                case 15:
                case 16:
                case 17:
                    return context.getResources().getString(R.string.he_found_you_from_hello);
                case 18:
                case 19:
                case 20:
                    return context.getResources().getString(R.string.he_found_you_from_your_s_post);
                case 21:
                    return context.getResources().getString(R.string.he_watched_your_live);
                case 22:
                    return context.getResources().getString(R.string.he_is_your_fan);
                case 23:
                    return context.getResources().getString(R.string.he_found_you_among_his_fans);
                case 24:
                    return context.getResources().getString(R.string.he_map_find);
                case 25:
                    return context.getResources().getString(R.string.he_found_you_from_shadow);
                default:
                    return "";
            }
        }
        return str3;
    }

    public static String a(ChattingModel chattingModel, String str, String str2) {
        String a2 = IMV4Method.a(chattingModel.sessionType, chattingModel.sessionId, str);
        if (!TextUtils.isEmpty(a2) && AppMethods.a(str2, a2)) {
            return a2;
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0243, code lost:
        if (android.text.TextUtils.equals(r0, r0.fromId + "") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02ed, code lost:
        if (android.text.TextUtils.equals(r0, r0.fromId + "") == false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.util.List<com.blued.android.chat.model.ChattingModel> r6, com.blued.android.chat.model.ChattingModel r7) {
        /*
            Method dump skipped, instructions count: 825
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.controller.tools.MsgCommonUtils.a(java.util.List, com.blued.android.chat.model.ChattingModel):java.lang.String");
    }

    public static void a(Context context, EditText editText, int i, int i2, String str, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(str2);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayList.size()) {
                editText.setText(a((CharSequence) spannableStringBuilder, (int) editText.getTextSize(), 0));
                return;
            }
            String str3 = "@" + ((String) arrayList.get(i4)) + " ";
            if (str.contains(str3)) {
                Matcher matcher = Pattern.compile(str3).matcher(str);
                while (matcher.find()) {
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    textView.setTextSize(i);
                    textView.setTextColor(i2);
                    textView.setDrawingCacheEnabled(true);
                    textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
                    ImageSpan imageSpan = new ImageSpan(context, textView.getDrawingCache());
                    try {
                        if (a(spannableStringBuilder, matcher.start(), matcher.end())) {
                            spannableStringBuilder.setSpan(imageSpan, matcher.start(), matcher.end(), 33);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            i3 = i4 + 1;
        }
    }

    public static void a(Context context, MessageProtos.StrangerSource strangerSource, String str) {
        if (strangerSource != null) {
            int i = AnonymousClass2.f32266a[strangerSource.ordinal()];
            if (i == 25) {
                WebViewShowInfoFragment.show(context, H5Url.a(46, UserInfo.getInstance().getLoginUserInfo().uid), 0);
                return;
            }
            switch (i) {
                case 9:
                    VideoScanFragment.a(context, str);
                    return;
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                case 19:
                case 20:
                    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                    bluedIngSelfFeed.feed_id = EncryptTool.a(str);
                    bluedIngSelfFeed.is_ads = 0;
                    FeedDetailsFragment.a(context, bluedIngSelfFeed, -1, new FeedDetailParams(0));
                    return;
                case 14:
                case 15:
                case 16:
                case 17:
                    WebViewShowInfoFragment.show(context, H5Url.a(52, UserInfo.getInstance().getLoginUserInfo().uid), 0);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(Context context, String str, String str2, long j, IRequestHost iRequestHost) {
        Logger.b(f32265a, "举报消息字符串：targetID：", str2, ",contents:", str);
        ChatHttpUtils.a(context, new BluedUIHttpResponse(iRequestHost) { // from class: com.soft.blued.ui.msg.controller.tools.MsgCommonUtils.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.d((int) R.string.biao_report_ok);
            }
        }, str, null, 8, str2, "", j, 0, "", "", "", 0, iRequestHost);
    }

    public static void a(Context context, List<ChattingModel> list, ChattingModel chattingModel, String str, int i, int i2, IRequestHost iRequestHost) {
        String str2 = "";
        String a2 = chattingModel == null ? "" : i == 6 ? a(list, chattingModel) : AppInfo.f().toJson(GroupUtil.a(list, chattingModel));
        if (chattingModel != null) {
            String str3 = chattingModel.fromNickName;
            str2 = str3;
            if (!TextUtils.isEmpty(chattingModel.fromNickName)) {
                str2 = str3;
                if (chattingModel.isMatchMsg == 1) {
                    DateTodayManager.f32404a.a(MessageProtos.Event.MSG_MATCH_CHAT_PAGE_REPORT_CLICK);
                    str2 = DateTodayManager.f32404a.c(chattingModel.fromNickName);
                }
            }
        }
        ReportChatFragment.a(context, a2, str, i, str2);
        if (i == 6) {
            if (i2 == 1) {
                EventTrackMessage.a(MessageProtos.Event.PRIVATE_CHAT_REPORT_CLICK, 1, str);
                InstantLog.b("private_chat_report_click", 1);
                return;
            }
            EventTrackMessage.a(MessageProtos.Event.PRIVATE_CHAT_REPORT_CLICK, 0, str);
            InstantLog.b("private_chat_report_click", 0);
        }
    }

    private static boolean a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        int length;
        return i2 >= i && i <= (length = spannableStringBuilder.length()) && i2 <= length && i >= 0 && i2 >= 0;
    }
}
