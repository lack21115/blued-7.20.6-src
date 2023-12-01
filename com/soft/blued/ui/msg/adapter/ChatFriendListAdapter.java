package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.view.BluedMarqueeTextView;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.contract.IMsgView;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.GroupStatusManager;
import com.soft.blued.ui.msg.manager.MessageChatMethod;
import com.soft.blued.ui.msg.manager.OnlineStatusManager;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.ChatOnlineStatusModel;
import com.soft.blued.ui.msg.model.GroupStatusInfo;
import com.soft.blued.ui.msg.model.MsgChattingImageModel;
import com.soft.blued.ui.msg.model.MsgChattingVideoModel;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.msg.presenter.MsgPresenter;
import com.soft.blued.ui.msg.util.ChatUtils;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ChatFriendListAdapter.class */
public class ChatFriendListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public MsgPresenter f31972a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private IMsgView f31973c;
    private Emotion d;
    private List<ViewHolder> e = new ArrayList();
    private boolean f = false;
    private List<SessionModel> g = new ArrayList();
    private IRequestHost h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ChatFriendListAdapter$ViewHolder.class */
    public class ViewHolder {
        ImageView[] A;
        BluedMarqueeTextView B;
        ImageView C;
        LinearLayout D;
        ImageView E;
        TextView F;

        /* renamed from: a  reason: collision with root package name */
        View f31974a;
        TextView b;

        /* renamed from: c  reason: collision with root package name */
        View f31975c;
        QBadgeContainer d;
        TextView e;
        ImageView f;
        TextView g;
        ImageView h;
        ImageView i;
        ImageView j;
        ImageView k;
        View l;
        TextView m;
        TextView n;
        ImageView o;
        ImageView p;
        ShapeFrameLayout q;
        TextView r;
        View s;
        ImageView t;
        TextView u;
        ShapeTextView v;
        ShapeTextView w;
        ShapeTextView x;
        LinearLayout y;
        LinearLayout z;

        private ViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ChatFriendListAdapter$ViewType.class */
    interface ViewType {
    }

    public ChatFriendListAdapter(IRequestHost iRequestHost, IMsgView iMsgView) {
        this.f31973c = iMsgView;
        this.h = iRequestHost;
        this.b = LayoutInflater.from(iMsgView.getContext());
        this.d = new Emotion(this.f31973c.getContext());
    }

    public static String a(View view, SessionModel sessionModel) {
        if (sessionModel.vBadge == 3) {
            return "";
        }
        String str = "";
        if (sessionModel.sessionType == 2) {
            str = "";
            if (IMV4Method.a(sessionModel.lastMsgFromId) == 1) {
                if (DistanceUtils.c(sessionModel.lastMsgFromDistance) && view != null) {
                    view.setVisibility(0);
                    return "";
                }
                String a2 = DistanceUtils.a(sessionModel.lastMsgFromDistance, BlueAppLocal.c(), false);
                String str2 = "";
                if (!StringUtils.d(a2)) {
                    str2 = "[" + a2 + "] ";
                }
                str = str2;
                if (view != null) {
                    view.setVisibility(8);
                    str = str2;
                }
            }
        }
        return str;
    }

    private static String a(SessionModel sessionModel, Context context) {
        MsgExtraGift msgExtraGift;
        try {
            if (TextUtils.isEmpty(sessionModel.lastMsgExtra) || (msgExtraGift = (MsgExtraGift) AppInfo.f().fromJson(sessionModel.lastMsgExtra, (Class<Object>) MsgExtraGift.class)) == null) {
                return "";
            }
            return UserPagerGiftManager.a(sessionModel.lastMsgFromId != Long.valueOf(UserInfo.getInstance().getLoginUserInfo().uid).longValue(), msgExtraGift, context, sessionModel.lastMsgFromNickname);
        } catch (Throwable th) {
            return "";
        }
    }

    public static void a(Context context, View view, TextView textView, SessionModel sessionModel, String str) {
        boolean z;
        if (view != null) {
            view.setVisibility(8);
        }
        textView.setVisibility(0);
        String str2 = sessionModel.lastDraft;
        if (!TextUtils.isEmpty(str2)) {
            String string = context.getResources().getString(R.string.msg_draft);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(2131101201)), 0, string.length(), 33);
            textView.setText(StringUtils.a(spannableStringBuilder, (int) textView.getTextSize(), 0));
        } else if (MsgType.getClassify(sessionModel.lastMsgType) == 1 || sessionModel.lastMsgType == 8) {
            if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                textView.setText("");
            } else {
                textView.setText(sessionModel.lastMsgContent);
            }
        } else if (MsgType.getGroupOperationNotifyType(sessionModel.lastMsgType) == 2) {
            if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                textView.setText("");
            } else {
                textView.setText(sessionModel.lastMsgContent);
            }
        } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 5) {
            if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                textView.setText("");
            } else if (TextUtils.isEmpty(sessionModel.lastMsgFromNickname)) {
                textView.setText(sessionModel.lastMsgContent);
            } else {
                textView.setText(sessionModel.lastMsgFromNickname + ": " + sessionModel.lastMsgContent);
            }
        } else if (sessionModel.sessionType == 6668) {
            if (sessionModel.sessionId != 1 && sessionModel.sessionId != 2) {
                if (sessionModel.sessionId == 3) {
                    textView.setVisibility(8);
                    textView.setText("");
                } else if (sessionModel.sessionId == 4) {
                    textView.setText(sessionModel.lastMsgContent);
                }
            } else if (sessionModel.lastMsgFromId == 0) {
                textView.setText(sessionModel.lastMsgContent);
            } else {
                textView.setText(sessionModel.lastMsgFromNickname + ": " + sessionModel.lastMsgContent);
            }
        } else {
            short s = sessionModel.lastMsgType;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3) {
                        textView.setText(a(view, sessionModel) + str + context.getResources().getString(R.string.biao_v4_msg_audio));
                        if (IMV4Method.a(sessionModel.lastMsgFromId) != 1 || sessionModel.lastMsgStateCode == 5) {
                            return;
                        }
                        textView.setTextColor(context.getResources().getColor(2131101201));
                        return;
                    } else if (s == 4) {
                        textView.setText(a(view, sessionModel) + str + context.getResources().getString(R.string.biao_v4_msg_location));
                        return;
                    } else {
                        if (s != 5) {
                            if (s != 6) {
                                if (s == 9 || s == 10) {
                                    textView.setText(a(view, sessionModel) + str + sessionModel.lastMsgContent);
                                    return;
                                } else if (s == 52) {
                                    a(context, sessionModel, textView, view);
                                    return;
                                } else if (s == 53) {
                                    b(context, sessionModel, textView, view);
                                    return;
                                } else if (s == 73) {
                                    textView.setText(a(view, sessionModel) + ((Object) context.getResources().getText(R.string.msg_like_see_private_photo)));
                                    return;
                                } else if (s == 74) {
                                    textView.setText(a(view, sessionModel) + ((Object) context.getResources().getText(R.string.msg_unlock_private_photo)));
                                    return;
                                } else if (s == 98) {
                                    textView.setText("[" + ((Object) context.getResources().getText(R.string.msg_vip_pay)) + "]");
                                    textView.setTextColor(context.getResources().getColor(2131101203));
                                    return;
                                } else if (s == 99) {
                                    textView.setText("[" + ((Object) context.getResources().getText(R.string.msg_vip_present)) + "]");
                                    textView.setTextColor(context.getResources().getColor(2131101203));
                                    return;
                                } else if (s != 250) {
                                    if (s != 251) {
                                        if (s == 256) {
                                            if (TextUtils.isEmpty(sessionModel.lastMsgContent) || TextUtils.isEmpty(sessionModel.lastMsgFromNickname)) {
                                                return;
                                            }
                                            String str3 = sessionModel.lastMsgContent;
                                            String str4 = str3;
                                            if (sessionModel.lastMsgContent.startsWith(sessionModel.lastMsgFromNickname)) {
                                                str4 = str3;
                                                if (sessionModel.lastMsgContent.length() > sessionModel.lastMsgFromNickname.length() + 1) {
                                                    str4 = sessionModel.lastMsgContent.substring(sessionModel.lastMsgFromNickname.length() + 1);
                                                }
                                            }
                                            textView.setText(ChatUtils.a(a(sessionModel), str4));
                                            return;
                                        }
                                        if (s != 257) {
                                            switch (s) {
                                                case 6:
                                                    break;
                                                case 32:
                                                    textView.setText(a(view, sessionModel) + str + sessionModel.lastMsgContent);
                                                    return;
                                                case 55:
                                                    if (!TextUtils.isEmpty(UserInfo.getInstance().getLoginUserInfo().getUid())) {
                                                        long j = -1;
                                                        try {
                                                            j = Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue();
                                                        } catch (Exception e) {
                                                        }
                                                        if (sessionModel.lastMsgFromId == j) {
                                                            z = true;
                                                            MessageChatMethod.a(z, sessionModel.sessionType, sessionModel.sessionId, sessionModel.lastMsgStateCode, textView, sessionModel.lastMsgFromNickname);
                                                            return;
                                                        }
                                                    }
                                                    z = false;
                                                    MessageChatMethod.a(z, sessionModel.sessionType, sessionModel.sessionId, sessionModel.lastMsgStateCode, textView, sessionModel.lastMsgFromNickname);
                                                    return;
                                                case 68:
                                                    if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                                                        textView.setText("");
                                                        return;
                                                    }
                                                    textView.setText(StringUtils.a(a(view, sessionModel) + sessionModel.lastMsgContent, false, true, true, ""));
                                                    return;
                                                case 164:
                                                    textView.setText(a(view, sessionModel) + a(sessionModel, context));
                                                    return;
                                                case 169:
                                                    textView.setText(Html.fromHtml(sessionModel.lastMsgContent));
                                                    return;
                                                case 205:
                                                    String string2 = context.getString(R.string.biao_v4_msg_hell_emotion);
                                                    String str5 = string2;
                                                    try {
                                                        if (!TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                                                            str5 = a(view, sessionModel) + "[" + sessionModel.lastMsgContent.split("@")[1] + "]";
                                                        }
                                                    } catch (Throwable th) {
                                                        str5 = string2;
                                                    }
                                                    textView.setText(str5);
                                                    return;
                                                case 210:
                                                case 216:
                                                case 281:
                                                case 282:
                                                case 290:
                                                    break;
                                                case 220:
                                                    textView.setText(sessionModel.lastMsgFromNickname + context.getString(R.string.group_announcement_updated) + " " + context.getString(R.string.group_announcement));
                                                    return;
                                                case 267:
                                                    if (!UserInfo.getInstance().getLoginUserInfo().uid.equals(sessionModel.lastMsgFromId + "")) {
                                                        textView.setText(context.getString(R.string.msg_super_call_tips));
                                                        return;
                                                    } else if (TextUtils.isEmpty(sessionModel.lastMsgContent) || TextUtils.isEmpty(sessionModel.lastMsgFromNickname)) {
                                                        return;
                                                    } else {
                                                        String str6 = sessionModel.lastMsgContent;
                                                        String str7 = str6;
                                                        if (sessionModel.lastMsgContent.startsWith(sessionModel.lastMsgFromNickname)) {
                                                            str7 = str6;
                                                            if (sessionModel.lastMsgContent.length() > sessionModel.lastMsgFromNickname.length() + 1) {
                                                                str7 = sessionModel.lastMsgContent.substring(sessionModel.lastMsgFromNickname.length() + 1);
                                                            }
                                                        }
                                                        textView.setText(ChatUtils.a(a(sessionModel), str7));
                                                        return;
                                                    }
                                                case 271:
                                                    textView.setText(Html.fromHtml(context.getString(R.string.msg_special_care_post_feed_tips)));
                                                    return;
                                                case 279:
                                                    textView.setText("");
                                                    return;
                                                case 283:
                                                    if (a(sessionModel)) {
                                                        textView.setText(context.getResources().getString(R.string.date_today_text_wait_like));
                                                        return;
                                                    } else {
                                                        textView.setText(context.getResources().getString(R.string.date_today_text_like_you));
                                                        return;
                                                    }
                                                case 288:
                                                    textView.setText(context.getResources().getString(R.string.date_today_text_both_like));
                                                    return;
                                                default:
                                                    switch (s) {
                                                        case 24:
                                                            break;
                                                        case 25:
                                                            break;
                                                        case 26:
                                                            if (sessionModel.lastMsgFromId == Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue()) {
                                                                textView.setText(a(view, sessionModel) + ((Object) context.getResources().getText(R.string.biao_msg_screenshot_me)));
                                                                return;
                                                            }
                                                            textView.setText(a(view, sessionModel) + ((Object) context.getResources().getText(R.string.biao_msg_screenshot_other)));
                                                            return;
                                                        default:
                                                            switch (s) {
                                                                case 87:
                                                                case 88:
                                                                case 89:
                                                                case 90:
                                                                    break;
                                                                default:
                                                                    switch (s) {
                                                                        case 240:
                                                                            textView.setText("[" + context.getString(R.string.group_event_evaluation) + "]");
                                                                            return;
                                                                        case 241:
                                                                            textView.setText("[匿名动态]");
                                                                            return;
                                                                        case 242:
                                                                            break;
                                                                        case 243:
                                                                            if (TextUtils.equals("" + sessionModel.lastMsgFromId, UserInfo.getInstance().getLoginUserInfo().uid)) {
                                                                                textView.setText(context.getString(R.string.msg_poke_him));
                                                                                return;
                                                                            } else {
                                                                                textView.setText(context.getString(R.string.msg_poke_you));
                                                                                return;
                                                                            }
                                                                        case 244:
                                                                            textView.setText(a(view, sessionModel) + str + sessionModel.lastMsgContent);
                                                                            return;
                                                                        default:
                                                                            if (sessionModel.lastMsgId == 0) {
                                                                                textView.setText("");
                                                                                return;
                                                                            } else if (sessionModel.lastMsgFromApp != 2) {
                                                                                textView.setText(context.getResources().getString(R.string.biao_v4_msgtype_no));
                                                                                return;
                                                                            } else {
                                                                                textView.setText(context.getResources().getString(R.string.msg_from_international));
                                                                                return;
                                                                            }
                                                                    }
                                                            }
                                                            String str8 = "";
                                                            if (!TextUtils.isEmpty(sessionModel.lastMsgExtra)) {
                                                                ShareToMsgEntity shareToMsgEntity = (ShareToMsgEntity) AppInfo.f().fromJson(sessionModel.lastMsgExtra, (Class<Object>) ShareToMsgEntity.class);
                                                                str8 = "";
                                                                if (shareToMsgEntity != null) {
                                                                    str8 = "";
                                                                    if (shareToMsgEntity.share_from == 13) {
                                                                        str8 = "：" + shareToMsgEntity.name;
                                                                    }
                                                                }
                                                            }
                                                            textView.setText(a(view, sessionModel) + str + sessionModel.lastMsgContent + str8);
                                                            return;
                                                    }
                                            }
                                        }
                                        textView.setText(sessionModel.lastMsgContent);
                                        return;
                                    }
                                }
                            }
                            textView.setText(a(view, sessionModel) + str + context.getResources().getString(R.string.biao_v4_msg_emotion));
                            return;
                        }
                        textView.setText(a(view, sessionModel) + str + context.getResources().getString(R.string.biao_v4_msg_sight));
                        return;
                    }
                }
                textView.setText(a(view, sessionModel) + str + context.getResources().getString(R.string.biao_v4_msg_img));
                return;
            }
            if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                textView.setText("");
                return;
            }
            textView.setText(StringUtils.a(StringUtils.a(a(view, sessionModel) + str + sessionModel.lastMsgContent, false, true, true, ""), (int) textView.getTextSize()));
        }
    }

    private static void a(Context context, SessionModel sessionModel, TextView textView, View view) {
        String str;
        ImageSpan imageSpan;
        SpannableString spannableString;
        VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel) AppInfo.f().fromJson(sessionModel.lastMsgContent, (Class<Object>) VideoChatMsgContentModel.class);
        if (videoChatMsgContentModel != null) {
            if (videoChatMsgContentModel.room_type == 2) {
                String string = context.getResources().getString(R.string.msg_list_invitation_video_chat);
                Drawable drawable = context.getResources().getDrawable(R.drawable.icon_msg_list_video_chat);
                drawable.setBounds(0, DensityUtils.a(context, 3.0f), DensityUtils.a(context, 17.0f), DensityUtils.a(context, 17.0f));
                str = string;
                imageSpan = new ImageSpan(drawable, 1);
            } else if (videoChatMsgContentModel.room_type == 1) {
                String string2 = context.getResources().getString(R.string.msg_list_invitation_audio_chat);
                Drawable drawable2 = context.getResources().getDrawable(R.drawable.icon_msg_list_audio_chat);
                drawable2.setBounds(0, DensityUtils.a(context, 3.0f), DensityUtils.a(context, 17.0f), DensityUtils.a(context, 17.0f));
                str = string2;
                imageSpan = new ImageSpan(drawable2, 1);
            } else {
                str = "";
                imageSpan = null;
            }
            new SpannableString(str).setSpan(imageSpan, 2, 3, 17);
            textView.setText(a(view, sessionModel) + ((Object) spannableString));
            textView.setTextColor(Color.parseColor("#9CD225"));
        }
    }

    private void a(SessionModel sessionModel, SessionSettingModel sessionSettingModel, TextView textView) {
        String str = sessionModel.nickName != null ? new String(sessionModel.nickName) : "";
        String sessinoNote = sessionSettingModel != null ? sessionSettingModel.getSessinoNote() : "";
        if (!TextUtils.isEmpty(sessinoNote)) {
            textView.setText(sessinoNote);
        } else if (TextUtils.isEmpty(str)) {
            textView.setText(EncryptTool.b(sessionModel.sessionId + ""));
        } else {
            String str2 = str;
            if (sessionModel.sessionId < 0) {
                str2 = DateTodayManager.f32404a.c(str);
            }
            textView.setText(str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0062, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00eb, code lost:
        if (a(r8, r11) == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.blued.android.chat.model.SessionModel r7, com.blued.android.module.common.db.model.SessionSettingModel r8, com.soft.blued.ui.msg.adapter.ChatFriendListAdapter.ViewHolder r9) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.ChatFriendListAdapter.a(com.blued.android.chat.model.SessionModel, com.blued.android.module.common.db.model.SessionSettingModel, com.soft.blued.ui.msg.adapter.ChatFriendListAdapter$ViewHolder):void");
    }

    private void a(SessionModel sessionModel, ViewHolder viewHolder) {
        if (viewHolder.i == null || viewHolder.j == null) {
            return;
        }
        final long j = sessionModel.sessionId;
        viewHolder.j.setVisibility(8);
        viewHolder.i.setVisibility(8);
        final ChatOnlineStatusModel a2 = OnlineStatusManager.f32435a.a(Long.valueOf(j));
        OnlineStatusManager.f32435a.a(sessionModel, a2);
        if (a2 != null) {
            int social_status = a2.getSocial_status();
            boolean z = true;
            if (social_status == 1) {
                viewHolder.i.setVisibility(0);
                if (BluedPreferences.cK()) {
                    viewHolder.i.setImageResource(2131233954);
                } else {
                    viewHolder.i.setImageResource(2131233953);
                }
            } else if (social_status == 2 || social_status == 3) {
                viewHolder.j.setVisibility(0);
                if (a2.getSocial_status() != 3) {
                    z = false;
                }
                ImageLoader.c(this.h, z ? "anim_chat_list.png" : "anim_live_list.png").e((int) j).g(-1).a(viewHolder.j);
                viewHolder.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ChatFriendListAdapter$e0siIaE6g8n0TzSDBbFEUJ_tK0E
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChatFriendListAdapter.this.a(a2, j, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ChatOnlineStatusModel chatOnlineStatusModel, long j, View view) {
        String str;
        Tracker.onClick(view);
        MessageProtos.Event event = MessageProtos.Event.MSG_USER_AVATAR_CLICK;
        String a2 = OnlineStatusManager.f32435a.a(Integer.valueOf(chatOnlineStatusModel.getSocial_status()));
        String str2 = "";
        if (j == 0) {
            str = "";
        } else {
            str = "" + j;
        }
        if (chatOnlineStatusModel.getSource_id() != 0) {
            str2 = "" + chatOnlineStatusModel.getSource_id();
        }
        EventTrackMessage.d(event, a2, str, str2);
        WebViewShowInfoFragment.show(this.f31973c.getContext(), chatOnlineStatusModel.getJump_url());
    }

    private static boolean a(SessionModel sessionModel) {
        String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
        if (TextUtils.isEmpty(uid)) {
            return false;
        }
        long j = -1;
        try {
            j = Long.parseLong(uid);
        } catch (Exception e) {
        }
        return sessionModel.lastMsgFromId == j;
    }

    private static void b(Context context, SessionModel sessionModel, TextView textView, View view) {
        try {
            VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel) AppInfo.f().fromJson(sessionModel.lastMsgContent, (Class<Object>) VideoChatMsgContentModel.class);
            String str = "";
            if (videoChatMsgContentModel != null) {
                if (videoChatMsgContentModel.room_type == 2) {
                    str = context.getResources().getString(R.string.channel_video);
                } else if (videoChatMsgContentModel.room_type == 1) {
                    str = context.getResources().getString(R.string.channel_voice);
                }
                textView.setText(a(view, sessionModel) + "[" + str + "]");
            }
        } catch (Exception e) {
        }
    }

    private void b(SessionModel sessionModel, ViewHolder viewHolder) {
        if (sessionModel.sessionType != 3) {
            viewHolder.D.setVisibility(8);
            return;
        }
        GroupStatusInfo a2 = GroupStatusManager.f32419a.a(Long.valueOf(sessionModel.sessionId));
        if (a2 == null || a2.getOnline() <= 0) {
            if (a2 == null) {
                this.f31972a.d(true);
            }
            viewHolder.D.setVisibility(8);
            return;
        }
        Log.a("lyl", "group_online_num = " + a2.getOnline());
        viewHolder.D.setVisibility(0);
        TextView textView = viewHolder.F;
        textView.setText(a2.getOnline() + this.f31973c.getContext().getResources().getString(R.string.group_online_number) + " | ");
    }

    private boolean b(SessionModel sessionModel) {
        if (sessionModel.lastMsgType == 24) {
            try {
                return ((MsgChattingImageModel) AppInfo.f().fromJson(sessionModel.lastMsgExtra, (Class<Object>) MsgChattingImageModel.class)).illegal;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else if (sessionModel.lastMsgType == 25) {
            try {
                return ((MsgChattingVideoModel) AppInfo.f().fromJson(sessionModel.lastMsgExtra, (Class<Object>) MsgChattingVideoModel.class)).illegal;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public void a() {
        synchronized (this) {
            for (ViewHolder viewHolder : this.e) {
                if (!TextUtils.isEmpty(viewHolder.d.getBadgeText()) && viewHolder.f31974a.getParent() != null) {
                    viewHolder.d.b(true);
                }
            }
        }
    }

    public void a(List<SessionModel> list, boolean z) {
        this.g = list;
        this.f = z;
    }

    public boolean a(SessionSettingModel sessionSettingModel) {
        return sessionSettingModel != null && sessionSettingModel.getSessionType() == 2 && TextUtils.equals(sessionSettingModel.getSessionCommonStatus(), "1");
    }

    public boolean a(SessionSettingModel sessionSettingModel, boolean z) {
        if (sessionSettingModel != null) {
            if (sessionSettingModel.getSessionType() == 2 && sessionSettingModel.getRemindAudio() == 1) {
                return true;
            }
            return sessionSettingModel.getSessionType() == 3 && GroupUtil.a(sessionSettingModel.getRemindAudio());
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i;
        List<SessionModel> list = this.g;
        if (list != null) {
            int size = list.size();
            i = size;
            if (this.f) {
                i = size;
                if (size > 0) {
                    return size + 1;
                }
            }
        } else {
            i = 0;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<SessionModel> list = this.g;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0379, code lost:
        if (a(r0, r0.atMessageId == r0.lastMsgId) == false) goto L181;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03ee  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            Method dump skipped, instructions count: 3151
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.ChatFriendListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
