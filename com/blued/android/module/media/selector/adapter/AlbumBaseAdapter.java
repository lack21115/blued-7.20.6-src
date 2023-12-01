package com.blued.android.module.media.selector.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.Log;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.contract.IAlbumBaseCallback;
import com.blued.android.module.player.media.model.MediaInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/adapter/AlbumBaseAdapter.class */
public class AlbumBaseAdapter extends RecyclerView.Adapter {
    private static final String a = AlbumBaseAdapter.class.getSimpleName();
    private IAlbumBaseCallback b;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/adapter/AlbumBaseAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView a;
        public ImageView b;
        public RelativeLayout c;
        public RelativeLayout d;
        public TextView e;

        public ViewHolder(View view) {
            super(view);
            this.c = (RelativeLayout) view.findViewById(R.id.vr_select_item_v);
            this.a = (ImageView) view.findViewById(R.id.vr_header_view);
            this.b = (ImageView) view.findViewById(R.id.vr_select_view);
            this.d = (RelativeLayout) view.findViewById(R.id.vr_video_type_cover_v);
            this.e = (TextView) view.findViewById(R.id.tv_video_time);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x00b6, code lost:
            if (r8.isSelected != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00d0, code lost:
            if (r8.isSelected != false) goto L14;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(final com.blued.android.module.player.media.model.MediaInfo r8, final int r9) {
            /*
                Method dump skipped, instructions count: 282
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.media.selector.adapter.AlbumBaseAdapter.ViewHolder.a(com.blued.android.module.player.media.model.MediaInfo, int):void");
        }
    }

    public AlbumBaseAdapter(IAlbumBaseCallback iAlbumBaseCallback) {
        this.b = iAlbumBaseCallback;
    }

    public int getItemCount() {
        return this.b.a();
    }

    public long getItemId(int i) {
        return i;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MediaInfo a2 = this.b.a(i);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (viewHolder2 != null) {
            viewHolder2.a(a2, i);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.c("", "onCreateViewHolder");
        return new ViewHolder(LayoutInflater.from(this.b.getContext()).inflate(R.layout.select_file_item_v, (ViewGroup) null));
    }
}
