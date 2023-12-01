package com.soft.blued.ui.live.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.SuperToast.SuperActivityToast;
import com.blued.android.module.common.user.UserInfoHelper;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/VideoChatHintToast.class */
public class VideoChatHintToast extends SuperActivityToast {

    /* renamed from: a  reason: collision with root package name */
    private Context f17642a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private String f17643c;
    private int d;
    private String e;
    private SuperActivityToast.OnButtonClickListener f;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/VideoChatHintToast$onHintClickLisnter.class */
    public interface onHintClickLisnter {
        void a();
    }

    public VideoChatHintToast(Context context, String str, int i, String str2, SuperActivityToast.OnButtonClickListener onButtonClickListener) {
        super(context);
        this.f17642a = context;
        this.f17643c = str;
        this.d = i;
        this.e = str2;
        this.f = onButtonClickListener;
    }

    public static void a(Context context, String str, int i, String str2, final onHintClickLisnter onhintclicklisnter) {
        new VideoChatHintToast(context, str, i, str2, new SuperActivityToast.OnButtonClickListener() { // from class: com.soft.blued.ui.live.view.VideoChatHintToast.2
            public void a() {
                onHintClickLisnter.this.a();
            }
        }).b(48, 0, 0).a(5000).n();
    }

    public static void b(Context context, Bundle bundle) {
        SuperActivityToast.a(context, bundle);
    }

    public static void b(Bundle bundle) {
        SuperActivityToast.a(bundle);
    }

    public View a(Context context, LayoutInflater layoutInflater) {
        this.b = layoutInflater.inflate(R.layout.pop_video_chat_hint, (ViewGroup) ((Activity) context).findViewById(android.R.id.content), false);
        j().c = 0;
        return this.b;
    }

    public void e() {
        ((TextView) this.b.findViewById(2131371186)).setText(this.e);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(2131367715);
        ImageView imageView = (ImageView) this.b.findViewById(R.id.img_avatar);
        ImageView imageView2 = (ImageView) this.b.findViewById(R.id.img_verify);
        ImageLoader.a((IRequestHost) null, this.f17643c).b(2131237310).a(2.0f, this.f17642a.getResources().getColor(2131102478)).a(imageView);
        UserInfoHelper.a(imageView2, this.d, 3);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.view.VideoChatHintToast.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                VideoChatHintToast.this.f.a();
                VideoChatHintToast.this.o();
            }
        });
    }
}
