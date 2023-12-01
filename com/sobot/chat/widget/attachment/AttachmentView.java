package com.sobot.chat.widget.attachment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.model.SobotFileModel;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.pictureframe.SobotBitmapUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/attachment/AttachmentView.class */
public class AttachmentView extends FrameLayout {
    private SobotFileModel fileModel;
    private String fileName;
    private String fileUrl;
    private ImageView imageView;
    private Listener listener;
    private Context mContext;
    private int position;
    private View rootView;
    private RelativeLayout sobotAttachmentRootView;
    private TextView sobotFileName;
    private TextView sobotFilePreview;
    private ImageView sobotFileTypeIcon;
    private int type;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/attachment/AttachmentView$Listener.class */
    public interface Listener {
        void downFileLister(SobotFileModel sobotFileModel, int i);

        void previewMp4(SobotFileModel sobotFileModel, int i);

        void previewPic(String str, String str2, int i);
    }

    public AttachmentView(Context context) {
        super(context);
        initView(context);
    }

    public AttachmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public AttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        this.rootView = inflate(context, ResourceUtils.getResLayoutId(context, "sobot_layout_attachment_view"), this);
        this.sobotAttachmentRootView = (RelativeLayout) findViewById(ResourceUtils.getResId(context, "sobot_attachment_root_view"));
        this.sobotFileName = (TextView) findViewById(ResourceUtils.getResId(context, "sobot_file_name"));
        this.sobotFileTypeIcon = (ImageView) findViewById(ResourceUtils.getResId(context, "sobot_file_type_icon"));
        TextView textView = (TextView) findViewById(ResourceUtils.getResId(context, "sobot_file_download"));
        this.sobotFilePreview = textView;
        textView.setText(ResourceUtils.getResString(context, "sobot_preview_see"));
        this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.attachment.AttachmentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (AttachmentView.this.listener == null) {
                    return;
                }
                if (AttachmentView.this.type == 18) {
                    AttachmentView.this.listener.previewMp4(AttachmentView.this.fileModel, AttachmentView.this.position);
                } else if (AttachmentView.this.type == 1) {
                    AttachmentView.this.listener.previewPic(AttachmentView.this.fileUrl, AttachmentView.this.fileName, AttachmentView.this.position);
                } else {
                    AttachmentView.this.listener.downFileLister(AttachmentView.this.fileModel, AttachmentView.this.position);
                }
            }
        });
        this.imageView = (ImageView) findViewById(ResourceUtils.getResId(context, "sobot_file_image_view"));
    }

    public void setFileModel(SobotFileModel sobotFileModel) {
        this.fileModel = sobotFileModel;
    }

    public void setFileName(CharSequence charSequence) {
        this.fileName = charSequence.toString();
        TextView textView = this.sobotFileName;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setFileNameColor(int i) {
        TextView textView = this.sobotFileName;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setFileTypeIcon(int i) {
        this.type = i;
        if (this.sobotFileTypeIcon == null) {
            return;
        }
        if (i == 1) {
            this.imageView.setVisibility(0);
            this.sobotAttachmentRootView.setVisibility(8);
            SobotBitmapUtil.display(this.mContext, this.fileUrl, this.imageView);
            return;
        }
        this.imageView.setVisibility(8);
        this.sobotAttachmentRootView.setVisibility(0);
        this.sobotFileTypeIcon.setImageResource(FileTypeConfig.getFileIcon(this.mContext, i));
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
