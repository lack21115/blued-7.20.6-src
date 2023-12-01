package com.sobot.chat.widget.attachment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sobot.chat.api.model.SobotFileModel;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.widget.attachment.AttachmentView;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/attachment/FileAttachmentAdapter.class */
public class FileAttachmentAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<SobotFileModel> arrayList;
    private AttachmentView.Listener clickListener;
    private Context context;
    private int fileColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/attachment/FileAttachmentAdapter$ViewHolder.class */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private AttachmentView attachmentView;

        public ViewHolder(View view) {
            super(view);
            this.attachmentView = (AttachmentView) view;
        }
    }

    public FileAttachmentAdapter(Context context, ArrayList<SobotFileModel> arrayList, int i, AttachmentView.Listener listener) {
        this.context = context;
        this.arrayList = arrayList;
        this.fileColor = i;
        this.clickListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<SobotFileModel> arrayList = this.arrayList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        SobotFileModel sobotFileModel = this.arrayList.get(i);
        viewHolder.attachmentView.setFileName(sobotFileModel.getFileName());
        LogUtils.e(i + "\t" + sobotFileModel.getFileType() + "\t" + sobotFileModel.getFileUrl());
        viewHolder.attachmentView.setFileUrl(sobotFileModel.getFileUrl());
        viewHolder.attachmentView.setFileTypeIcon(FileTypeConfig.getFileType(sobotFileModel.getFileType()));
        viewHolder.attachmentView.setFileNameColor(this.fileColor);
        viewHolder.attachmentView.setPosition(i);
        viewHolder.attachmentView.setListener(this.clickListener);
        viewHolder.attachmentView.setFileModel(sobotFileModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AttachmentView attachmentView = new AttachmentView(this.context);
        attachmentView.setLayoutParams(new FrameLayout.LayoutParams((ScreenUtils.getScreenWH(this.context)[0] - ScreenUtils.dip2px(this.context, 60.0f)) / 3, ScreenUtils.dip2px(this.context, 85.0f)));
        return new ViewHolder(attachmentView);
    }
}
