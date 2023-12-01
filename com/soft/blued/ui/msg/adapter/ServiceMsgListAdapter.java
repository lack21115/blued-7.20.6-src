package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sobot.chat.widget.rich.MyURLSpan;
import com.soft.blued.R;
import com.soft.blued.customview.TextViewFixTouchForServiceMsg;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.adapter.ServiceMsgListAdapter;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.msg.model.MsgImageAndTextModel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.ServiceMsgModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ServiceMsgListAdapter.class */
public final class ServiceMsgListAdapter extends BaseMultiItemQuickAdapter<ServiceMsgModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f32190a = new Companion(null);
    private final IRequestHost b;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ServiceMsgListAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ServiceMsgListAdapter$ImageAndTextViewHolder.class */
    public static final class ImageAndTextViewHolder extends BaseViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f32191a;
        private final IRequestHost b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f32192c;
        private final BaseViewHolder d;
        private ImageView e;
        private TextView f;
        private ImageView g;
        private ImageView h;
        private ImageView i;
        private TextView j;
        private LinearLayout k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageAndTextViewHolder(View view, IRequestHost fragmentActive, Context mContext, BaseViewHolder helper) {
            super(view);
            Intrinsics.e(view, "view");
            Intrinsics.e(fragmentActive, "fragmentActive");
            Intrinsics.e(mContext, "mContext");
            Intrinsics.e(helper, "helper");
            this.f32191a = view;
            this.b = fragmentActive;
            this.f32192c = mContext;
            this.d = helper;
            View findViewById = view.findViewById(2131365082);
            Intrinsics.c(findViewById, "view.findViewById(R.id.iv_avatar)");
            this.e = (ImageView) findViewById;
            View findViewById2 = this.f32191a.findViewById(2131372046);
            Intrinsics.c(findViewById2, "view.findViewById(R.id.tv_name)");
            this.f = (TextView) findViewById2;
            View findViewById3 = this.f32191a.findViewById(R.id.iv_vbadge);
            Intrinsics.c(findViewById3, "view.findViewById(R.id.iv_vbadge)");
            this.g = (ImageView) findViewById3;
            View findViewById4 = this.f32191a.findViewById(R.id.iv_vip_gradle);
            Intrinsics.c(findViewById4, "view.findViewById(R.id.iv_vip_gradle)");
            this.h = (ImageView) findViewById4;
            View findViewById5 = this.f32191a.findViewById(R.id.iv_no_remind);
            Intrinsics.c(findViewById5, "view.findViewById(R.id.iv_no_remind)");
            this.i = (ImageView) findViewById5;
            View findViewById6 = this.f32191a.findViewById(R.id.tv_push_time);
            Intrinsics.c(findViewById6, "view.findViewById(R.id.tv_push_time)");
            this.j = (TextView) findViewById6;
            View findViewById7 = this.f32191a.findViewById(R.id.ll_see_details);
            Intrinsics.c(findViewById7, "view.findViewById(R.id.ll_see_details)");
            this.k = (LinearLayout) findViewById7;
        }

        private final String a(MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            if (msgExtraForTextTypeEntity == null || TextUtils.isEmpty(msgExtraForTextTypeEntity.activity_work_id)) {
                return "";
            }
            String str = msgExtraForTextTypeEntity.activity_work_id;
            Intrinsics.c(str, "extra.activity_work_id");
            return StringsKt.c((CharSequence) str, (CharSequence) b.g, false, 2, (Object) null) ? msgExtraForTextTypeEntity.activity_work_id : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ImageAndTextViewHolder this$0, ServiceMsgModel chattingModel, String url, Ref.ObjectRef title, Ref.ObjectRef extra, View view) {
            Tracker.onClick(view);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(chattingModel, "$chattingModel");
            Intrinsics.e(url, "$url");
            Intrinsics.e(title, "$title");
            Intrinsics.e(extra, "$extra");
            this$0.a(chattingModel, url, 2, (String) title.f42545a, (MsgExtraForTextTypeEntity) extra.f42545a);
        }

        private final void a(ServiceMsgModel serviceMsgModel, String str, int i, String str2, MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            MessageEventUtils.b(str);
            InstantLog.a("message_page", str);
            EventTrackMessage.a(MessageProtos.Event.MESSAGE_PAGE);
            WebViewShowInfoFragment.show(this.f32192c, str, -1);
            EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_CLICK, String.valueOf(serviceMsgModel.fromId), String.valueOf(serviceMsgModel.msgId), str, "image", i, str2);
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, str, a(msgExtraForTextTypeEntity));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ServiceMsgModel chattingModel, Ref.ObjectRef link, Ref.ObjectRef title, ImageAndTextViewHolder this$0, Ref.ObjectRef extra, LogData logDataChat, View view) {
            Tracker.onClick(view);
            Intrinsics.e(chattingModel, "$chattingModel");
            Intrinsics.e(link, "$link");
            Intrinsics.e(title, "$title");
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(extra, "$extra");
            Intrinsics.e(logDataChat, "$logDataChat");
            EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_CLICK, String.valueOf(chattingModel.fromId), String.valueOf(chattingModel.msgId), (String) link.f42545a, "image", 1, (String) title.f42545a);
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, (String) link.f42545a, this$0.a((MsgExtraForTextTypeEntity) extra.f42545a));
            ChatHelperV4.a().a(this$0.f32192c, chattingModel.sessionId, chattingModel.fromNickName, chattingModel.fromAvatar, chattingModel.fromVBadge, chattingModel.fromVipGrade, chattingModel.fromVipAnnual, chattingModel.fromVipExpLvl, Intrinsics.a(chattingModel.fromDistance, (Object) ""), false, 0, 0, logDataChat, BluedPreferences.eS() && !BluedPreferences.eQ(), new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ImageAndTextViewHolder this$0, ServiceMsgModel chattingModel, String url, Ref.ObjectRef title, Ref.ObjectRef extra, View view) {
            Tracker.onClick(view);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(chattingModel, "$chattingModel");
            Intrinsics.e(url, "$url");
            Intrinsics.e(title, "$title");
            Intrinsics.e(extra, "$extra");
            this$0.a(chattingModel, url, 3, (String) title.f42545a, (MsgExtraForTextTypeEntity) extra.f42545a);
        }

        /* JADX WARN: Type inference failed for: r0v112, types: [T, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v122, types: [T, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v79, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0375 -> B:8:0x0138). Please submit an issue!!! */
        public final void a(final ServiceMsgModel chattingModel) {
            String str;
            String str2;
            MsgImageAndTextModel msgImageAndTextModel;
            String str3;
            Intrinsics.e(chattingModel, "chattingModel");
            TextView textView = (TextView) ViewHolder.a(this.f32191a, R.id.tv_detail);
            TextView textView2 = (TextView) ViewHolder.a(this.f32191a, R.id.tv_push_desc);
            TextView textView3 = (TextView) ViewHolder.a(this.f32191a, R.id.tv_push_title);
            ImageView imageView = (ImageView) ViewHolder.a(this.f32191a, R.id.iv_push_image);
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewHolder.a(this.f32191a, R.id.cl_msg_detail);
            LinearLayout linearLayout = (LinearLayout) ViewHolder.a(this.f32191a, 2131368333);
            ImageLoader.a(this.b, chattingModel.fromAvatar).b(2131237310).a(15.0f).a(this.e);
            setText(2131372046, chattingModel.fromNickName);
            UserInfoHelper.a(this.g, chattingModel.fromVBadge, 3, 1, ContextCompat.getColor(this.f32192c, 2131101191));
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = chattingModel.fromVipGrade;
            userBasicModel.is_vip_annual = chattingModel.fromVipAnnual;
            userBasicModel.is_hide_vip_look = chattingModel.fromHideVipLook;
            userBasicModel.vip_exp_lvl = chattingModel.fromVipExpLvl;
            UserRelationshipUtils.a(this.h, userBasicModel);
            setGone(R.id.iv_no_remind, SubscribeNumberManager.f32449a.a(chattingModel.sessionId));
            String str4 = "";
            if (chattingModel.msgTimestamp == 0) {
                setText(R.id.tv_push_time, "");
            } else {
                setText(R.id.tv_push_time, MsgCommonUtils.a(this.f32192c, chattingModel.msgTimestamp));
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                objectRef.f42545a = AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<??>) MsgExtraForTextTypeEntity.class);
            } catch (Exception e) {
            }
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.d = 2131101212;
            loadOptions.b = 2131101212;
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.f42545a = "";
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.f42545a = "";
            try {
                if (TextUtils.isEmpty(chattingModel.getMsgExtra()) || (msgImageAndTextModel = (MsgImageAndTextModel) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgImageAndTextModel.class)) == null) {
                    str = "";
                    str2 = str;
                } else {
                    ?? r0 = msgImageAndTextModel.title;
                    Intrinsics.c(r0, "model.title");
                    objectRef2.f42545a = r0;
                    str4 = msgImageAndTextModel.image;
                    Intrinsics.c(str4, "model.image");
                    String str5 = msgImageAndTextModel.desc;
                    Intrinsics.c(str5, "model.desc");
                    ?? r02 = msgImageAndTextModel.link;
                    Intrinsics.c(r02, "model.link");
                    objectRef3.f42545a = r02;
                    if (TextUtils.isEmpty(msgImageAndTextModel.click_desc)) {
                        str = this.f32192c.getString(2131892577);
                        str3 = "mContext.getString(R.string.view_detail)";
                    } else {
                        str = msgImageAndTextModel.click_desc;
                        str3 = "model.click_desc";
                    }
                    Intrinsics.c(str, str3);
                    str2 = str5;
                }
                if (TextUtils.isEmpty((CharSequence) objectRef2.f42545a)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText((CharSequence) objectRef2.f42545a);
                    textView3.setVisibility(0);
                }
                ImageLoader.a(this.b, str4).b(R.drawable.icon_msg_image_and_text_bg).d(R.drawable.icon_msg_image_and_text_bg).a(imageView);
                if (TextUtils.isEmpty(str2)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str2);
                    textView2.setVisibility(0);
                }
                if (TextUtils.isEmpty(str)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str);
                    textView.setVisibility(0);
                }
                if (TextUtils.isEmpty((CharSequence) objectRef3.f42545a)) {
                    constraintLayout.setOnClickListener(null);
                } else {
                    final String str6 = (String) objectRef3.f42545a;
                    constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$ImageAndTextViewHolder$-ehmOqVi-2bYehRIWoJJ1exwDkI
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ServiceMsgListAdapter.ImageAndTextViewHolder.a(ServiceMsgListAdapter.ImageAndTextViewHolder.this, chattingModel, str6, objectRef2, objectRef, view);
                        }
                    });
                    this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$ImageAndTextViewHolder$Vw6rXyGsTlALax1oGcR5nvg8XNo
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ServiceMsgListAdapter.ImageAndTextViewHolder.b(ServiceMsgListAdapter.ImageAndTextViewHolder.this, chattingModel, str6, objectRef2, objectRef, view);
                        }
                    });
                }
                final LogData logData = new LogData();
                logData.from = "none";
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$ImageAndTextViewHolder$0Ov9ELGpySSDaxTJt5hApinD-xI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ServiceMsgListAdapter.ImageAndTextViewHolder.a(ServiceMsgModel.this, objectRef3, objectRef2, this, objectRef, logData, view);
                    }
                });
                EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_SHOW, String.valueOf(chattingModel.fromId), String.valueOf(chattingModel.msgId), (String) objectRef3.f42545a, "image", (String) objectRef2.f42545a);
                EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_SHOW, (String) objectRef3.f42545a, a((MsgExtraForTextTypeEntity) objectRef.f42545a));
                Log.e("xfm", Intrinsics.a("link: ", (Object) objectRef3.f42545a));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ServiceMsgListAdapter$TextViewHolder.class */
    public static final class TextViewHolder extends BaseViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f32193a;
        private final IRequestHost b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f32194c;
        private final BaseViewHolder d;
        private ImageView e;
        private TextView f;
        private ImageView g;
        private ImageView h;
        private ImageView i;
        private TextView j;
        private TextViewFixTouchForServiceMsg k;
        private LinearLayout l;
        private LinearLayout m;
        private CardView n;
        private LinearLayout o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextViewHolder(View view, IRequestHost fragmentActive, Context context, BaseViewHolder helper) {
            super(view);
            Intrinsics.e(view, "view");
            Intrinsics.e(fragmentActive, "fragmentActive");
            Intrinsics.e(context, "context");
            Intrinsics.e(helper, "helper");
            this.f32193a = view;
            this.b = fragmentActive;
            this.f32194c = context;
            this.d = helper;
            View findViewById = view.findViewById(2131365082);
            Intrinsics.c(findViewById, "view.findViewById(R.id.iv_avatar)");
            this.e = (ImageView) findViewById;
            View findViewById2 = this.f32193a.findViewById(2131372046);
            Intrinsics.c(findViewById2, "view.findViewById(R.id.tv_name)");
            this.f = (TextView) findViewById2;
            View findViewById3 = this.f32193a.findViewById(R.id.iv_vbadge);
            Intrinsics.c(findViewById3, "view.findViewById(R.id.iv_vbadge)");
            this.g = (ImageView) findViewById3;
            View findViewById4 = this.f32193a.findViewById(R.id.iv_vip_gradle);
            Intrinsics.c(findViewById4, "view.findViewById(R.id.iv_vip_gradle)");
            this.h = (ImageView) findViewById4;
            View findViewById5 = this.f32193a.findViewById(R.id.iv_no_remind);
            Intrinsics.c(findViewById5, "view.findViewById(R.id.iv_no_remind)");
            this.i = (ImageView) findViewById5;
            View findViewById6 = this.f32193a.findViewById(R.id.tv_push_time);
            Intrinsics.c(findViewById6, "view.findViewById(R.id.tv_push_time)");
            this.j = (TextView) findViewById6;
            View findViewById7 = this.f32193a.findViewById(R.id.tv_push_desc);
            Intrinsics.c(findViewById7, "view.findViewById(R.id.tv_push_desc)");
            this.k = (TextViewFixTouchForServiceMsg) findViewById7;
            View findViewById8 = this.f32193a.findViewById(R.id.ll_see_details);
            Intrinsics.c(findViewById8, "view.findViewById(R.id.ll_see_details)");
            this.l = (LinearLayout) findViewById8;
            View findViewById9 = this.f32193a.findViewById(2131368333);
            Intrinsics.c(findViewById9, "view.findViewById(R.id.ll_userinfo)");
            this.m = (LinearLayout) findViewById9;
            View findViewById10 = this.f32193a.findViewById(2131363153);
            Intrinsics.c(findViewById10, "view.findViewById(R.id.cv_content)");
            this.n = (CardView) findViewById10;
            View findViewById11 = this.f32193a.findViewById(R.id.ll_msg_content);
            Intrinsics.c(findViewById11, "view.findViewById(R.id.ll_msg_content)");
            this.o = (LinearLayout) findViewById11;
        }

        private final String a(MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            if (msgExtraForTextTypeEntity == null || msgExtraForTextTypeEntity.htmlContent == null) {
                return "";
            }
            String str = msgExtraForTextTypeEntity.htmlContent;
            Intrinsics.c(str, "extra.htmlContent");
            return str;
        }

        private final void a(TextViewFixTouchForServiceMsg textViewFixTouchForServiceMsg, String str, int i, boolean z) {
            CharSequence a2 = StringUtils.a((CharSequence) str, true, z);
            textViewFixTouchForServiceMsg.setMaxLines(2);
            textViewFixTouchForServiceMsg.setExpandText(a2);
            textViewFixTouchForServiceMsg.setMovementMethod(LinkMovementClickMethod.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(TextViewHolder this$0, ServiceMsgModel data, Ref.ObjectRef eventUrl, LogData logDataChat, Ref.ObjectRef extra, View view) {
            Tracker.onClick(view);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(data, "$data");
            Intrinsics.e(eventUrl, "$eventUrl");
            Intrinsics.e(logDataChat, "$logDataChat");
            Intrinsics.e(extra, "$extra");
            this$0.a(data, (String) eventUrl.f42545a, logDataChat, 1, this$0.k.getText().toString(), (MsgExtraForTextTypeEntity) extra.f42545a);
        }

        private final void a(ServiceMsgModel serviceMsgModel, String str, LogData logData, int i, String str2, MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_CLICK, String.valueOf(serviceMsgModel.fromId), String.valueOf(serviceMsgModel.msgId), str, "txt", i, str2);
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, str, b(msgExtraForTextTypeEntity));
            ChatHelperV4.a().a(this.f32194c, serviceMsgModel.sessionId, serviceMsgModel.fromNickName, serviceMsgModel.fromAvatar, serviceMsgModel.fromVBadge, serviceMsgModel.fromVipGrade, serviceMsgModel.fromVipAnnual, serviceMsgModel.fromVipExpLvl, Intrinsics.a(serviceMsgModel.fromDistance, (Object) ""), false, 0, 0, logData, BluedPreferences.eS() && !BluedPreferences.eQ(), new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        }

        private final String b(MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            if (msgExtraForTextTypeEntity == null || TextUtils.isEmpty(msgExtraForTextTypeEntity.activity_work_id)) {
                return "";
            }
            String str = msgExtraForTextTypeEntity.activity_work_id;
            Intrinsics.c(str, "extra.activity_work_id");
            return StringsKt.c((CharSequence) str, (CharSequence) b.g, false, 2, (Object) null) ? msgExtraForTextTypeEntity.activity_work_id : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TextViewHolder this$0, ServiceMsgModel data, Ref.ObjectRef eventUrl, LogData logDataChat, Ref.ObjectRef extra, View view) {
            Tracker.onClick(view);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(data, "$data");
            Intrinsics.e(eventUrl, "$eventUrl");
            Intrinsics.e(logDataChat, "$logDataChat");
            Intrinsics.e(extra, "$extra");
            this$0.a(data, (String) eventUrl.f42545a, logDataChat, 2, this$0.k.getText().toString(), (MsgExtraForTextTypeEntity) extra.f42545a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TextViewHolder this$0, ServiceMsgModel data, Ref.ObjectRef eventUrl, LogData logDataChat, Ref.ObjectRef extra, View view) {
            Tracker.onClick(view);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(data, "$data");
            Intrinsics.e(eventUrl, "$eventUrl");
            Intrinsics.e(logDataChat, "$logDataChat");
            Intrinsics.e(extra, "$extra");
            this$0.a(data, (String) eventUrl.f42545a, logDataChat, 3, this$0.k.getText().toString(), (MsgExtraForTextTypeEntity) extra.f42545a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v85, types: [T, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v66, types: [T, java.lang.Object] */
        public final void a(final ServiceMsgModel data) {
            Spanned spanned;
            Intrinsics.e(data, "data");
            ImageLoader.a(this.b, data.fromAvatar).b(2131237310).a(15.0f).a(this.e);
            setText(2131372046, data.fromNickName);
            UserInfoHelper.a(this.g, data.fromVBadge, 3, 1, ContextCompat.getColor(this.f32194c, 2131101191));
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = data.fromVipGrade;
            userBasicModel.is_vip_annual = data.fromVipAnnual;
            userBasicModel.is_hide_vip_look = data.fromHideVipLook;
            userBasicModel.vip_exp_lvl = data.fromVipExpLvl;
            UserRelationshipUtils.a(this.h, userBasicModel);
            setGone(R.id.iv_no_remind, SubscribeNumberManager.f32449a.a(data.sessionId));
            if (data.msgTimestamp == 0) {
                setText(R.id.tv_push_time, "");
            } else {
                setText(R.id.tv_push_time, MsgCommonUtils.a(this.f32194c, data.msgTimestamp));
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                objectRef.f42545a = AppInfo.f().fromJson(data.getMsgExtra(), (Class<??>) MsgExtraForTextTypeEntity.class);
            } catch (Exception e) {
            }
            int a2 = IMV4Method.a(data.fromId);
            MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = (MsgExtraForTextTypeEntity) objectRef.f42545a;
            String a3 = msgExtraForTextTypeEntity == null ? null : a(msgExtraForTextTypeEntity);
            if (TextUtils.isEmpty(a3)) {
                TextViewFixTouchForServiceMsg textViewFixTouchForServiceMsg = this.k;
                String str = data.msgContent;
                Intrinsics.c(str, "data.msgContent");
                a(textViewFixTouchForServiceMsg, str, a2, data.fromVBadge == 3);
                spanned = null;
            } else {
                Spanned fromHtml = Html.fromHtml(a3);
                this.k.setMaxLines(2);
                this.k.setExpandText(TypefaceUtils.a(this.f32194c, a3, data.fromVBadge == 3, (TypefaceUtils.ClickLinkListener) null));
                spanned = fromHtml;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (spanned != null) {
                spannableStringBuilder = (SpannableStringBuilder) spanned;
            }
            Object[] objArr = {(URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class)};
            ArrayList arrayList = new ArrayList();
            Object[] objArr2 = objArr;
            if (!(objArr2.length == 0)) {
                int length = objArr2.length;
                int i = 0;
                while (i < length) {
                    Object[] item = objArr[i];
                    int i2 = i + 1;
                    Intrinsics.c(item, "item");
                    int length2 = item.length;
                    int i3 = 0;
                    while (true) {
                        i = i2;
                        if (i3 < length2) {
                            MyURLSpan myURLSpan = item[i3];
                            i3++;
                            if (myURLSpan == 0) {
                                throw new NullPointerException("null cannot be cast to non-null type android.text.style.URLSpan");
                            }
                            String url = myURLSpan.getURL();
                            Intrinsics.c(url, "span.url");
                            arrayList.add(url);
                        }
                    }
                }
            }
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.f42545a = "";
            if (arrayList.size() > 0) {
                String obj = arrayList.toString();
                ?? substring = obj.substring(1, obj.length() - 1);
                Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                objectRef2.f42545a = substring;
            }
            Log.e("xfm", Intrinsics.a("eventUrl: ", (Object) objectRef2.f42545a));
            final LogData logData = new LogData();
            logData.from = "none";
            this.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$TextViewHolder$7AUiV8YEUHIiyvF132NiQIFipV4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ServiceMsgListAdapter.TextViewHolder.a(ServiceMsgListAdapter.TextViewHolder.this, data, objectRef2, logData, objectRef, view);
                }
            });
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$TextViewHolder$7u6hJEL9VYCn8DO4MOkbbxb7fpo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ServiceMsgListAdapter.TextViewHolder.b(ServiceMsgListAdapter.TextViewHolder.this, data, objectRef2, logData, objectRef, view);
                }
            });
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$TextViewHolder$bjzVBWovAk7YGMFPTuj7K-aayoE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ServiceMsgListAdapter.TextViewHolder.c(ServiceMsgListAdapter.TextViewHolder.this, data, objectRef2, logData, objectRef, view);
                }
            });
            EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_SHOW, String.valueOf(data.fromId), String.valueOf(data.msgId), (String) objectRef2.f42545a, "txt", this.k.getText().toString());
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_SHOW, (String) objectRef2.f42545a, b((MsgExtraForTextTypeEntity) objectRef.f42545a));
        }

        public final Context getContext() {
            return this.f32194c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceMsgListAdapter(IRequestHost requestHost) {
        super(null);
        Intrinsics.e(requestHost, "requestHost");
        this.b = requestHost;
        addItemType(1, R.layout.item_service_msg_text);
        addItemType(68, R.layout.item_service_msg_image_and_text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, ServiceMsgModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        View view = helper.itemView;
        Intrinsics.c(view, "helper.itemView");
        int itemViewType = helper.getItemViewType();
        if (itemViewType == 1) {
            IRequestHost iRequestHost = this.b;
            Context mContext = this.mContext;
            Intrinsics.c(mContext, "mContext");
            new TextViewHolder(view, iRequestHost, mContext, helper).a(item);
        } else if (itemViewType != 68) {
        } else {
            IRequestHost iRequestHost2 = this.b;
            Context mContext2 = this.mContext;
            Intrinsics.c(mContext2, "mContext");
            new ImageAndTextViewHolder(view, iRequestHost2, mContext2, helper).a(item);
        }
    }
}
