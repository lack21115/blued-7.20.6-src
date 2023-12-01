package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback;
import com.soft.blued.ui.msg.manager.ChatBgManager;
import com.soft.blued.ui.msg.model.MsgChattingBgModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ChatBgSelectAdapter.class */
public class ChatBgSelectAdapter extends RecyclerView.Adapter {
    private static List<String> d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f18275a;
    private IChatBgSelectOptionCallback b;

    /* renamed from: c  reason: collision with root package name */
    private List<MsgChattingBgModel> f18276c;
    private LoadOptions e;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ChatBgSelectAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f18278c;
        private MsgChattingBgModel d;
        private int e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.soft.blued.ui.msg.adapter.ChatBgSelectAdapter$ViewHolder$1  reason: invalid class name */
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ChatBgSelectAdapter$ViewHolder$1.class */
        public class AnonymousClass1 extends FileHttpResponseHandler {

            /* renamed from: a  reason: collision with root package name */
            boolean f18279a = false;
            final /* synthetic */ MsgChattingBgModel b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f18280c;
            final /* synthetic */ ImageView d;

            AnonymousClass1(MsgChattingBgModel msgChattingBgModel, View view, ImageView imageView) {
                this.b = msgChattingBgModel;
                this.f18280c = view;
                this.d = imageView;
            }

            /* renamed from: a */
            public void onSuccess(File file) {
                if (ChatBgSelectAdapter.d != null) {
                    ChatBgSelectAdapter.d.remove(this.b.getUrl());
                }
            }

            /* renamed from: a */
            public void onFailure(Throwable th, int i, File file) {
                super.onFailure(th, i, file);
                this.f18279a = true;
                if (ChatBgSelectAdapter.d != null) {
                    ChatBgSelectAdapter.d.remove(this.b.getUrl());
                }
            }

            public void onCancel() {
                super.onCancel();
                this.f18279a = true;
                if (ChatBgSelectAdapter.d != null) {
                    ChatBgSelectAdapter.d.remove(this.b.getUrl());
                }
            }

            public void onFinish() {
                super.onFinish();
                if (ChatBgSelectAdapter.d != null) {
                    ChatBgSelectAdapter.d.remove(this.b.getUrl());
                }
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.adapter.ChatBgSelectAdapter.ViewHolder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass1.this.f18280c != null) {
                            AnonymousClass1.this.f18280c.setEnabled(true);
                        }
                        if (AnonymousClass1.this.d != null) {
                            ChatBgSelectAdapter.this.a(AnonymousClass1.this.d);
                            if (AnonymousClass1.this.f18279a) {
                                AnonymousClass1.this.d.setVisibility(0);
                                ViewHolder.this.f18278c.setImageResource(R.drawable.chat_bg_item_status_nodownload);
                            } else if (ViewHolder.this.a(AnonymousClass1.this.b.getUrl())) {
                                AnonymousClass1.this.d.setVisibility(8);
                                ViewHolder.this.e = 3;
                            } else {
                                AnonymousClass1.this.d.setVisibility(0);
                                ViewHolder.this.f18278c.setImageResource(R.drawable.chat_bg_item_status_nodownload);
                            }
                        }
                    }
                });
            }

            public void onStart() {
                super.onStart();
                if (ChatBgSelectAdapter.d != null) {
                    ChatBgSelectAdapter.d.add(this.b.getUrl());
                }
            }
        }

        public ViewHolder(View view) {
            super(view);
            this.b = (ImageView) view.findViewById(R.id.chat_bg_thum_img);
            this.f18278c = (ImageView) view.findViewById(R.id.chat_bg_status_img);
            view.setOnClickListener(this);
        }

        private void a(View view, ImageView imageView, MsgChattingBgModel msgChattingBgModel) {
            if (view != null) {
                view.setEnabled(false);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.chat_bg_item_status_loading);
                ChatBgSelectAdapter.this.a(imageView.getContext(), imageView);
            }
            FileDownloader.a(msgChattingBgModel.getUrl(), ChatBgManager.c(msgChattingBgModel.getUrl()), new AnonymousClass1(msgChattingBgModel, view, imageView), ChatBgSelectAdapter.this.b.a());
        }

        public void a(MsgChattingBgModel msgChattingBgModel) {
            this.d = msgChattingBgModel;
            if (msgChattingBgModel != null) {
                if (msgChattingBgModel.type == 1) {
                    ImageLoader.a(ChatBgSelectAdapter.this.f18275a, 2131101196).a(3.0f).a(this.b);
                    if (ChatBgSelectAdapter.this.b.an_()) {
                        this.f18278c.setVisibility(8);
                        return;
                    }
                    this.e = 4;
                    this.f18278c.setVisibility(0);
                    this.f18278c.setImageResource(R.drawable.msg_photo_select);
                } else if (TextUtils.isEmpty(msgChattingBgModel.getUrl())) {
                } else {
                    if (ChatBgSelectAdapter.this.e == null) {
                        ChatBgSelectAdapter.this.e = new LoadOptions();
                        ChatBgSelectAdapter.this.e.d = R.drawable.feed_photo_default;
                        ChatBgSelectAdapter.this.e.b = R.drawable.feed_photo_default;
                        ChatBgSelectAdapter.this.e.j = true;
                        ChatBgSelectAdapter.this.e.l = false;
                    }
                    ImageLoader.a(ChatBgSelectAdapter.this.f18275a, msgChattingBgModel.getPreview()).b((int) R.drawable.feed_photo_default).a(3.0f).a(this.b);
                    if (a(msgChattingBgModel.getUrl())) {
                        this.e = 3;
                        if (!ChatBgSelectAdapter.this.b.a(RecyclingUtils.Scheme.c.b(ChatBgManager.c(this.d.getUrl())))) {
                            this.f18278c.setVisibility(8);
                            return;
                        }
                        this.e = 4;
                        this.f18278c.setVisibility(0);
                        this.f18278c.setImageResource(R.drawable.msg_photo_select);
                    } else if (ChatBgSelectAdapter.d.contains(msgChattingBgModel.getUrl())) {
                        this.e = 2;
                        this.f18278c.setVisibility(0);
                        this.f18278c.setImageResource(R.drawable.chat_bg_item_status_loading);
                    } else {
                        this.e = 1;
                        this.f18278c.setVisibility(0);
                        this.f18278c.setImageResource(R.drawable.chat_bg_item_status_nodownload);
                    }
                }
            }
        }

        public boolean a(String str) {
            return new File(ChatBgManager.c(str)).exists();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            MsgChattingBgModel msgChattingBgModel = this.d;
            if (msgChattingBgModel != null) {
                if (msgChattingBgModel.type == 1) {
                    EventTrackVIP.a(VipProtos.Event.VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK);
                    this.f18278c.setImageResource(R.drawable.msg_photo_select);
                    if (ChatBgSelectAdapter.this.b != null) {
                        ChatBgSelectAdapter.this.b.b("default");
                        return;
                    }
                    return;
                }
                int i = this.e;
                if (i == 1) {
                    a(this.itemView, this.f18278c, this.d);
                } else if (i == 3) {
                    EventTrackVIP.b(VipProtos.Event.VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK, this.d.getUrl());
                    this.f18278c.setImageResource(R.drawable.msg_photo_select);
                    if (ChatBgSelectAdapter.this.b != null) {
                        ChatBgSelectAdapter.this.b.b(RecyclingUtils.Scheme.c.b(ChatBgManager.c(this.d.getUrl())));
                    }
                }
            }
        }
    }

    public ChatBgSelectAdapter(IRequestHost iRequestHost, IChatBgSelectOptionCallback iChatBgSelectOptionCallback) {
        this.b = iChatBgSelectOptionCallback;
        this.f18275a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.flash_loading_animation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view != null) {
            view.clearAnimation();
        }
    }

    public void a(List<MsgChattingBgModel> list) {
        this.f18276c = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MsgChattingBgModel> list = this.f18276c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        List<MsgChattingBgModel> list = this.f18276c;
        if (list == null || list.size() <= 0) {
            return;
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        MsgChattingBgModel msgChattingBgModel = this.f18276c.get(i);
        if (viewHolder2 == null || msgChattingBgModel == null) {
            return;
        }
        viewHolder2.a(msgChattingBgModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.b.getContext()).inflate(R.layout.view_chat_bg_list_item, (ViewGroup) null));
    }
}
