package com.blued.community.ui.send.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.Log;
import com.blued.android.module.media.selector.contract.IAlbumBaseCallback;
import com.blued.community.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/AlbumSelectHalfAdapter.class */
public class AlbumSelectHalfAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19887a = AlbumSelectHalfAdapter.class.getSimpleName();
    private IAlbumBaseCallback b;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/AlbumSelectHalfAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f19888a;
        public ImageView b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f19889c;
        public RelativeLayout d;
        public TextView e;

        public ViewHolder(View view) {
            super(view);
            this.f19889c = (RelativeLayout) view.findViewById(R.id.vr_select_item_v);
            this.f19888a = (ImageView) view.findViewById(R.id.vr_header_view);
            this.b = (ImageView) view.findViewById(R.id.vr_select_view);
            this.d = (RelativeLayout) view.findViewById(R.id.vr_video_type_cover_v);
            this.e = (TextView) view.findViewById(R.id.tv_video_time);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x00bb, code lost:
            if (r8.isSelected != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00d8, code lost:
            if (r8.isSelected != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00db, code lost:
            r14 = true;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(final com.blued.android.module.player.media.model.MediaInfo r8, final int r9) {
            /*
                Method dump skipped, instructions count: 337
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.send.adapter.AlbumSelectHalfAdapter.ViewHolder.a(com.blued.android.module.player.media.model.MediaInfo, int):void");
        }
    }

    public AlbumSelectHalfAdapter(IAlbumBaseCallback iAlbumBaseCallback) {
        this.b = iAlbumBaseCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.c("", "onCreateViewHolder");
        return new ViewHolder(LayoutInflater.from(this.b.getContext()).inflate(R.layout.select_file_item_v, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.a(this.b.a(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }
}
