package com.soft.blued.ui.msg;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.photo.fragment.BizPhotoDetailFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ChatBgPicturePreFragment.class */
public class ChatBgPicturePreFragment extends BizPhotoDetailFragment implements PhotoDetailFragment.GetConfigCallback {
    public static void a(BaseFragment baseFragment, String str, int i, LoadOptions loadOptions, boolean z, int i2) {
        Bundle a2 = a(str, loadOptions, z, false);
        a2.putInt("come_code", i);
        TerminalActivity.a(a2);
        TerminalActivity.b(a2);
        TerminalActivity.a(baseFragment, ChatBgPicturePreFragment.class, a2, i2);
    }

    public View a() {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.chat_bg_pircture_pre_top_title, (ViewGroup) null);
        ((ImageView) inflate.findViewById(2131363120)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatBgPicturePreFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChatBgPicturePreFragment.this.getActivity().finish();
            }
        });
        return inflate;
    }

    public View b() {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.tab_chat_bg_picture_pre_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.chat_bg_pre_done_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatBgPicturePreFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Intent intent = new Intent();
                intent.putExtra("photo_path", ChatBgPicturePreFragment.this.g);
                ChatBgPicturePreFragment.this.getActivity().setResult(-1, intent);
                ChatBgPicturePreFragment.this.getActivity().finish();
            }
        });
        return inflate;
    }

    public ImageView.ScaleType c() {
        return ImageView.ScaleType.CENTER_CROP;
    }

    @Override // com.soft.blued.ui.photo.fragment.BizPhotoDetailFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a((PhotoDetailFragment.GetConfigCallback) this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
