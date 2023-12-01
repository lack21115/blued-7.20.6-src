package com.blued.android.module.shortvideo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.model.VideoFrameInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/VideoCoverAdapter.class */
public class VideoCoverAdapter extends RecyclerView.Adapter {
    private List<VideoFrameInfo> a = new ArrayList();
    private LayoutInflater b;
    private LoadOptions c;
    private int d;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/VideoCoverAdapter$EditViewHolder.class */
    final class EditViewHolder extends RecyclerView.ViewHolder {
        public ImageView a;

        EditViewHolder(View view) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(R.id.id_image);
            this.a = imageView;
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).width = VideoCoverAdapter.this.d;
        }
    }

    public VideoCoverAdapter(Context context, int i) {
        this.b = LayoutInflater.from(context);
        this.d = i;
        LoadOptions loadOptions = new LoadOptions();
        this.c = loadOptions;
        loadOptions.l = false;
        this.c.a(i, DensityUtils.a(context, 54.0f));
    }

    public void a(VideoFrameInfo videoFrameInfo) {
        this.a.add(videoFrameInfo);
        notifyItemInserted(this.a.size());
    }

    public int getItemCount() {
        return this.a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        VideoFrameInfo videoFrameInfo;
        if (this.a.size() <= i || (videoFrameInfo = this.a.get(i)) == null) {
            return;
        }
        ImageLoader.d(null, videoFrameInfo.path).a(((EditViewHolder) viewHolder).a);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new EditViewHolder(this.b.inflate(R.layout.stv_trim_video_item, viewGroup, false));
    }
}
