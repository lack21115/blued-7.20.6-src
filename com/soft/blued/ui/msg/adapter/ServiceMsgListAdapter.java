package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.anythink.expressad.a;
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
    public static final Companion f18500a = new Companion(null);
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
        private final View f18501a;
        private final IRequestHost b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f18502c;
        private final BaseViewHolder d;
        private ImageView e;
        private TextView f;
        private ImageView g;
        private ImageView h;
        private ImageView i;
        private TextView j;
        private LinearLayout k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageAndTextViewHolder(View view, IRequestHost iRequestHost, Context context, BaseViewHolder baseViewHolder) {
            super(view);
            Intrinsics.e(view, a.B);
            Intrinsics.e(iRequestHost, "fragmentActive");
            Intrinsics.e(context, "mContext");
            Intrinsics.e(baseViewHolder, "helper");
            this.f18501a = view;
            this.b = iRequestHost;
            this.f18502c = context;
            this.d = baseViewHolder;
            View findViewById = view.findViewById(R.id.iv_avatar);
            Intrinsics.c(findViewById, "view.findViewById(R.id.iv_avatar)");
            this.e = (ImageView) findViewById;
            View findViewById2 = this.f18501a.findViewById(2131372046);
            Intrinsics.c(findViewById2, "view.findViewById(R.id.tv_name)");
            this.f = (TextView) findViewById2;
            View findViewById3 = this.f18501a.findViewById(R.id.iv_vbadge);
            Intrinsics.c(findViewById3, "view.findViewById(R.id.iv_vbadge)");
            this.g = (ImageView) findViewById3;
            View findViewById4 = this.f18501a.findViewById(R.id.iv_vip_gradle);
            Intrinsics.c(findViewById4, "view.findViewById(R.id.iv_vip_gradle)");
            this.h = (ImageView) findViewById4;
            View findViewById5 = this.f18501a.findViewById(R.id.iv_no_remind);
            Intrinsics.c(findViewById5, "view.findViewById(R.id.iv_no_remind)");
            this.i = (ImageView) findViewById5;
            View findViewById6 = this.f18501a.findViewById(R.id.tv_push_time);
            Intrinsics.c(findViewById6, "view.findViewById(R.id.tv_push_time)");
            this.j = (TextView) findViewById6;
            View findViewById7 = this.f18501a.findViewById(R.id.ll_see_details);
            Intrinsics.c(findViewById7, "view.findViewById(R.id.ll_see_details)");
            this.k = (LinearLayout) findViewById7;
        }

        private final String a(MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            if (msgExtraForTextTypeEntity == null || TextUtils.isEmpty(msgExtraForTextTypeEntity.activity_work_id)) {
                return "";
            }
            String str = msgExtraForTextTypeEntity.activity_work_id;
            Intrinsics.c(str, "extra.activity_work_id");
            return StringsKt.c(str, b.g, false, 2, (Object) null) ? msgExtraForTextTypeEntity.activity_work_id : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ImageAndTextViewHolder imageAndTextViewHolder, ServiceMsgModel serviceMsgModel, String str, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, View view) {
            Tracker.onClick(view);
            Intrinsics.e(imageAndTextViewHolder, "this$0");
            Intrinsics.e(serviceMsgModel, "$chattingModel");
            Intrinsics.e(str, "$url");
            Intrinsics.e(objectRef, "$title");
            Intrinsics.e(objectRef2, "$extra");
            imageAndTextViewHolder.a(serviceMsgModel, str, 2, (String) objectRef.a, (MsgExtraForTextTypeEntity) objectRef2.a);
        }

        private final void a(ServiceMsgModel serviceMsgModel, String str, int i, String str2, MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            MessageEventUtils.b(str);
            InstantLog.a("message_page", str);
            EventTrackMessage.a(MessageProtos.Event.MESSAGE_PAGE);
            WebViewShowInfoFragment.show(this.f18502c, str, -1);
            EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_CLICK, String.valueOf(serviceMsgModel.fromId), String.valueOf(serviceMsgModel.msgId), str, "image", i, str2);
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, str, a(msgExtraForTextTypeEntity));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ServiceMsgModel serviceMsgModel, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, ImageAndTextViewHolder imageAndTextViewHolder, Ref.ObjectRef objectRef3, LogData logData, View view) {
            Tracker.onClick(view);
            Intrinsics.e(serviceMsgModel, "$chattingModel");
            Intrinsics.e(objectRef, "$link");
            Intrinsics.e(objectRef2, "$title");
            Intrinsics.e(imageAndTextViewHolder, "this$0");
            Intrinsics.e(objectRef3, "$extra");
            Intrinsics.e(logData, "$logDataChat");
            EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_CLICK, String.valueOf(serviceMsgModel.fromId), String.valueOf(serviceMsgModel.msgId), (String) objectRef.a, "image", 1, (String) objectRef2.a);
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, (String) objectRef.a, imageAndTextViewHolder.a((MsgExtraForTextTypeEntity) objectRef3.a));
            ChatHelperV4.a().a(imageAndTextViewHolder.f18502c, serviceMsgModel.sessionId, serviceMsgModel.fromNickName, serviceMsgModel.fromAvatar, serviceMsgModel.fromVBadge, serviceMsgModel.fromVipGrade, serviceMsgModel.fromVipAnnual, serviceMsgModel.fromVipExpLvl, Intrinsics.a(serviceMsgModel.fromDistance, ""), false, 0, 0, logData, BluedPreferences.eS() && !BluedPreferences.eQ(), new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ImageAndTextViewHolder imageAndTextViewHolder, ServiceMsgModel serviceMsgModel, String str, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, View view) {
            Tracker.onClick(view);
            Intrinsics.e(imageAndTextViewHolder, "this$0");
            Intrinsics.e(serviceMsgModel, "$chattingModel");
            Intrinsics.e(str, "$url");
            Intrinsics.e(objectRef, "$title");
            Intrinsics.e(objectRef2, "$extra");
            imageAndTextViewHolder.a(serviceMsgModel, str, 3, (String) objectRef.a, (MsgExtraForTextTypeEntity) objectRef2.a);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0375 -> B:8:0x0138). Please submit an issue!!! */
        public final void a(final ServiceMsgModel serviceMsgModel) {
            String str;
            String str2;
            MsgImageAndTextModel msgImageAndTextModel;
            String str3;
            Intrinsics.e(serviceMsgModel, "chattingModel");
            TextView textView = (TextView) ViewHolder.a(this.f18501a, R.id.tv_detail);
            TextView textView2 = (TextView) ViewHolder.a(this.f18501a, R.id.tv_push_desc);
            TextView textView3 = (TextView) ViewHolder.a(this.f18501a, R.id.tv_push_title);
            ImageView imageView = (ImageView) ViewHolder.a(this.f18501a, R.id.iv_push_image);
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewHolder.a(this.f18501a, R.id.cl_msg_detail);
            LinearLayout linearLayout = (LinearLayout) ViewHolder.a(this.f18501a, R.id.ll_userinfo);
            ImageLoader.a(this.b, serviceMsgModel.fromAvatar).b(2131237310).a(15.0f).a(this.e);
            setText(2131372046, serviceMsgModel.fromNickName);
            UserInfoHelper.a(this.g, serviceMsgModel.fromVBadge, 3, 1, ContextCompat.getColor(this.f18502c, 2131101191));
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = serviceMsgModel.fromVipGrade;
            userBasicModel.is_vip_annual = serviceMsgModel.fromVipAnnual;
            userBasicModel.is_hide_vip_look = serviceMsgModel.fromHideVipLook;
            userBasicModel.vip_exp_lvl = serviceMsgModel.fromVipExpLvl;
            UserRelationshipUtils.a(this.h, userBasicModel);
            setGone(R.id.iv_no_remind, SubscribeNumberManager.f18759a.a(serviceMsgModel.sessionId));
            String str4 = "";
            if (serviceMsgModel.msgTimestamp == 0) {
                setText(R.id.tv_push_time, "");
            } else {
                setText(R.id.tv_push_time, MsgCommonUtils.a(this.f18502c, serviceMsgModel.msgTimestamp));
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                objectRef.a = AppInfo.f().fromJson(serviceMsgModel.getMsgExtra(), (Class<Object>) MsgExtraForTextTypeEntity.class);
            } catch (Exception e) {
            }
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.d = 2131101212;
            loadOptions.b = 2131101212;
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.a = "";
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.a = "";
            try {
                if (TextUtils.isEmpty(serviceMsgModel.getMsgExtra()) || (msgImageAndTextModel = (MsgImageAndTextModel) AppInfo.f().fromJson(serviceMsgModel.getMsgExtra(), (Class<Object>) MsgImageAndTextModel.class)) == null) {
                    str = "";
                    str2 = str;
                } else {
                    String str5 = msgImageAndTextModel.title;
                    Intrinsics.c(str5, "model.title");
                    objectRef2.a = str5;
                    str4 = msgImageAndTextModel.image;
                    Intrinsics.c(str4, "model.image");
                    String str6 = msgImageAndTextModel.desc;
                    Intrinsics.c(str6, "model.desc");
                    String str7 = msgImageAndTextModel.link;
                    Intrinsics.c(str7, "model.link");
                    objectRef3.a = str7;
                    if (TextUtils.isEmpty(msgImageAndTextModel.click_desc)) {
                        str = this.f18502c.getString(R.string.view_detail);
                        str3 = "mContext.getString(R.string.view_detail)";
                    } else {
                        str = msgImageAndTextModel.click_desc;
                        str3 = "model.click_desc";
                    }
                    Intrinsics.c(str, str3);
                    str2 = str6;
                }
                if (TextUtils.isEmpty((CharSequence) objectRef2.a)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText((CharSequence) objectRef2.a);
                    textView3.setVisibility(0);
                }
                ImageLoader.a(this.b, str4).b((int) R.drawable.icon_msg_image_and_text_bg).d((int) R.drawable.icon_msg_image_and_text_bg).a(imageView);
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
                if (TextUtils.isEmpty((CharSequence) objectRef3.a)) {
                    constraintLayout.setOnClickListener(null);
                } else {
                    final String str8 = (String) objectRef3.a;
                    constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$ImageAndTextViewHolder$-ehmOqVi-2bYehRIWoJJ1exwDkI
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ServiceMsgListAdapter.ImageAndTextViewHolder.a(ServiceMsgListAdapter.ImageAndTextViewHolder.this, serviceMsgModel, str8, objectRef2, objectRef, view);
                        }
                    });
                    this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$ImageAndTextViewHolder$Vw6rXyGsTlALax1oGcR5nvg8XNo
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ServiceMsgListAdapter.ImageAndTextViewHolder.b(ServiceMsgListAdapter.ImageAndTextViewHolder.this, serviceMsgModel, str8, objectRef2, objectRef, view);
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
                EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_SHOW, String.valueOf(serviceMsgModel.fromId), String.valueOf(serviceMsgModel.msgId), (String) objectRef3.a, "image", (String) objectRef2.a);
                EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_SHOW, (String) objectRef3.a, a((MsgExtraForTextTypeEntity) objectRef.a));
                Log.e("xfm", Intrinsics.a("link: ", objectRef3.a));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ServiceMsgListAdapter$TextViewHolder.class */
    public static final class TextViewHolder extends BaseViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f18503a;
        private final IRequestHost b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f18504c;
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
        public TextViewHolder(View view, IRequestHost iRequestHost, Context context, BaseViewHolder baseViewHolder) {
            super(view);
            Intrinsics.e(view, a.B);
            Intrinsics.e(iRequestHost, "fragmentActive");
            Intrinsics.e(context, "context");
            Intrinsics.e(baseViewHolder, "helper");
            this.f18503a = view;
            this.b = iRequestHost;
            this.f18504c = context;
            this.d = baseViewHolder;
            View findViewById = view.findViewById(R.id.iv_avatar);
            Intrinsics.c(findViewById, "view.findViewById(R.id.iv_avatar)");
            this.e = (ImageView) findViewById;
            View findViewById2 = this.f18503a.findViewById(2131372046);
            Intrinsics.c(findViewById2, "view.findViewById(R.id.tv_name)");
            this.f = (TextView) findViewById2;
            View findViewById3 = this.f18503a.findViewById(R.id.iv_vbadge);
            Intrinsics.c(findViewById3, "view.findViewById(R.id.iv_vbadge)");
            this.g = (ImageView) findViewById3;
            View findViewById4 = this.f18503a.findViewById(R.id.iv_vip_gradle);
            Intrinsics.c(findViewById4, "view.findViewById(R.id.iv_vip_gradle)");
            this.h = (ImageView) findViewById4;
            View findViewById5 = this.f18503a.findViewById(R.id.iv_no_remind);
            Intrinsics.c(findViewById5, "view.findViewById(R.id.iv_no_remind)");
            this.i = (ImageView) findViewById5;
            View findViewById6 = this.f18503a.findViewById(R.id.tv_push_time);
            Intrinsics.c(findViewById6, "view.findViewById(R.id.tv_push_time)");
            this.j = (TextView) findViewById6;
            View findViewById7 = this.f18503a.findViewById(R.id.tv_push_desc);
            Intrinsics.c(findViewById7, "view.findViewById(R.id.tv_push_desc)");
            this.k = (TextViewFixTouchForServiceMsg) findViewById7;
            View findViewById8 = this.f18503a.findViewById(R.id.ll_see_details);
            Intrinsics.c(findViewById8, "view.findViewById(R.id.ll_see_details)");
            this.l = (LinearLayout) findViewById8;
            View findViewById9 = this.f18503a.findViewById(R.id.ll_userinfo);
            Intrinsics.c(findViewById9, "view.findViewById(R.id.ll_userinfo)");
            this.m = (LinearLayout) findViewById9;
            View findViewById10 = this.f18503a.findViewById(R.id.cv_content);
            Intrinsics.c(findViewById10, "view.findViewById(R.id.cv_content)");
            this.n = (CardView) findViewById10;
            View findViewById11 = this.f18503a.findViewById(R.id.ll_msg_content);
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
            textViewFixTouchForServiceMsg.setMovementMethod((MovementMethod) LinkMovementClickMethod.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(TextViewHolder textViewHolder, ServiceMsgModel serviceMsgModel, Ref.ObjectRef objectRef, LogData logData, Ref.ObjectRef objectRef2, View view) {
            Tracker.onClick(view);
            Intrinsics.e(textViewHolder, "this$0");
            Intrinsics.e(serviceMsgModel, "$data");
            Intrinsics.e(objectRef, "$eventUrl");
            Intrinsics.e(logData, "$logDataChat");
            Intrinsics.e(objectRef2, "$extra");
            textViewHolder.a(serviceMsgModel, (String) objectRef.a, logData, 1, textViewHolder.k.getText().toString(), (MsgExtraForTextTypeEntity) objectRef2.a);
        }

        private final void a(ServiceMsgModel serviceMsgModel, String str, LogData logData, int i, String str2, MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_CLICK, String.valueOf(serviceMsgModel.fromId), String.valueOf(serviceMsgModel.msgId), str, "txt", i, str2);
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, str, b(msgExtraForTextTypeEntity));
            ChatHelperV4.a().a(this.f18504c, serviceMsgModel.sessionId, serviceMsgModel.fromNickName, serviceMsgModel.fromAvatar, serviceMsgModel.fromVBadge, serviceMsgModel.fromVipGrade, serviceMsgModel.fromVipAnnual, serviceMsgModel.fromVipExpLvl, Intrinsics.a(serviceMsgModel.fromDistance, ""), false, 0, 0, logData, BluedPreferences.eS() && !BluedPreferences.eQ(), new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        }

        private final String b(MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
            if (msgExtraForTextTypeEntity == null || TextUtils.isEmpty(msgExtraForTextTypeEntity.activity_work_id)) {
                return "";
            }
            String str = msgExtraForTextTypeEntity.activity_work_id;
            Intrinsics.c(str, "extra.activity_work_id");
            return StringsKt.c(str, b.g, false, 2, (Object) null) ? msgExtraForTextTypeEntity.activity_work_id : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TextViewHolder textViewHolder, ServiceMsgModel serviceMsgModel, Ref.ObjectRef objectRef, LogData logData, Ref.ObjectRef objectRef2, View view) {
            Tracker.onClick(view);
            Intrinsics.e(textViewHolder, "this$0");
            Intrinsics.e(serviceMsgModel, "$data");
            Intrinsics.e(objectRef, "$eventUrl");
            Intrinsics.e(logData, "$logDataChat");
            Intrinsics.e(objectRef2, "$extra");
            textViewHolder.a(serviceMsgModel, (String) objectRef.a, logData, 2, textViewHolder.k.getText().toString(), (MsgExtraForTextTypeEntity) objectRef2.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TextViewHolder textViewHolder, ServiceMsgModel serviceMsgModel, Ref.ObjectRef objectRef, LogData logData, Ref.ObjectRef objectRef2, View view) {
            Tracker.onClick(view);
            Intrinsics.e(textViewHolder, "this$0");
            Intrinsics.e(serviceMsgModel, "$data");
            Intrinsics.e(objectRef, "$eventUrl");
            Intrinsics.e(logData, "$logDataChat");
            Intrinsics.e(objectRef2, "$extra");
            textViewHolder.a(serviceMsgModel, (String) objectRef.a, logData, 3, textViewHolder.k.getText().toString(), (MsgExtraForTextTypeEntity) objectRef2.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(final ServiceMsgModel serviceMsgModel) {
            Spanned spanned;
            Intrinsics.e(serviceMsgModel, "data");
            ImageLoader.a(this.b, serviceMsgModel.fromAvatar).b(2131237310).a(15.0f).a(this.e);
            setText(2131372046, serviceMsgModel.fromNickName);
            UserInfoHelper.a(this.g, serviceMsgModel.fromVBadge, 3, 1, ContextCompat.getColor(this.f18504c, 2131101191));
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = serviceMsgModel.fromVipGrade;
            userBasicModel.is_vip_annual = serviceMsgModel.fromVipAnnual;
            userBasicModel.is_hide_vip_look = serviceMsgModel.fromHideVipLook;
            userBasicModel.vip_exp_lvl = serviceMsgModel.fromVipExpLvl;
            UserRelationshipUtils.a(this.h, userBasicModel);
            setGone(R.id.iv_no_remind, SubscribeNumberManager.f18759a.a(serviceMsgModel.sessionId));
            if (serviceMsgModel.msgTimestamp == 0) {
                setText(R.id.tv_push_time, "");
            } else {
                setText(R.id.tv_push_time, MsgCommonUtils.a(this.f18504c, serviceMsgModel.msgTimestamp));
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                objectRef.a = AppInfo.f().fromJson(serviceMsgModel.getMsgExtra(), (Class<Object>) MsgExtraForTextTypeEntity.class);
            } catch (Exception e) {
            }
            int a2 = IMV4Method.a(serviceMsgModel.fromId);
            MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = (MsgExtraForTextTypeEntity) objectRef.a;
            String a3 = msgExtraForTextTypeEntity == null ? null : a(msgExtraForTextTypeEntity);
            if (TextUtils.isEmpty(a3)) {
                TextViewFixTouchForServiceMsg textViewFixTouchForServiceMsg = this.k;
                String str = serviceMsgModel.msgContent;
                Intrinsics.c(str, "data.msgContent");
                a(textViewFixTouchForServiceMsg, str, a2, serviceMsgModel.fromVBadge == 3);
                spanned = null;
            } else {
                Spanned fromHtml = Html.fromHtml(a3);
                this.k.setMaxLines(2);
                this.k.setExpandText(TypefaceUtils.a(this.f18504c, a3, serviceMsgModel.fromVBadge == 3, (TypefaceUtils.ClickLinkListener) null));
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
                    Object[] objArr3 = objArr[i];
                    int i2 = i + 1;
                    Intrinsics.c(objArr3, "item");
                    int length2 = objArr3.length;
                    int i3 = 0;
                    while (true) {
                        i = i2;
                        if (i3 < length2) {
                            MyURLSpan myURLSpan = objArr3[i3];
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
            objectRef2.a = "";
            if (arrayList.size() > 0) {
                String obj = arrayList.toString();
                String substring = obj.substring(1, obj.length() - 1);
                Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                objectRef2.a = substring;
            }
            Log.e("xfm", Intrinsics.a("eventUrl: ", objectRef2.a));
            final LogData logData = new LogData();
            logData.from = "none";
            this.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$TextViewHolder$7AUiV8YEUHIiyvF132NiQIFipV4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ServiceMsgListAdapter.TextViewHolder.a(ServiceMsgListAdapter.TextViewHolder.this, serviceMsgModel, objectRef2, logData, objectRef, view);
                }
            });
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$TextViewHolder$7u6hJEL9VYCn8DO4MOkbbxb7fpo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ServiceMsgListAdapter.TextViewHolder.b(ServiceMsgListAdapter.TextViewHolder.this, serviceMsgModel, objectRef2, logData, objectRef, view);
                }
            });
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMsgListAdapter$TextViewHolder$bjzVBWovAk7YGMFPTuj7K-aayoE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ServiceMsgListAdapter.TextViewHolder.c(ServiceMsgListAdapter.TextViewHolder.this, serviceMsgModel, objectRef2, logData, objectRef, view);
                }
            });
            EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_LIST_ONE_SHOW, String.valueOf(serviceMsgModel.fromId), String.valueOf(serviceMsgModel.msgId), (String) objectRef2.a, "txt", this.k.getText().toString());
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_SHOW, (String) objectRef2.a, b((MsgExtraForTextTypeEntity) objectRef.a));
        }

        public final Context getContext() {
            return this.f18504c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceMsgListAdapter(IRequestHost iRequestHost) {
        super(null);
        Intrinsics.e(iRequestHost, "requestHost");
        this.b = iRequestHost;
        addItemType(1, R.layout.item_service_msg_text);
        addItemType(68, R.layout.item_service_msg_image_and_text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, ServiceMsgModel serviceMsgModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(serviceMsgModel, "item");
        View view = baseViewHolder.itemView;
        Intrinsics.c(view, "helper.itemView");
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType == 1) {
            IRequestHost iRequestHost = this.b;
            Context context = this.mContext;
            Intrinsics.c(context, "mContext");
            new TextViewHolder(view, iRequestHost, context, baseViewHolder).a(serviceMsgModel);
        } else if (itemViewType != 68) {
        } else {
            IRequestHost iRequestHost2 = this.b;
            Context context2 = this.mContext;
            Intrinsics.c(context2, "mContext");
            new ImageAndTextViewHolder(view, iRequestHost2, context2, baseViewHolder).a(serviceMsgModel);
        }
    }
}
