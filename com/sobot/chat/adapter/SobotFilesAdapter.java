package com.sobot.chat.adapter;

import android.content.Context;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.utils.DateUtil;
import com.sobot.chat.utils.ResourceUtils;
import java.io.File;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotFilesAdapter.class */
public class SobotFilesAdapter extends SobotBaseAdapter<File> {
    public static final int MSG_TYPE_DIR = 1;
    public static final int MSG_TYPE_FILE = 0;
    private static final String[] layoutRes = {"sobot_choose_file_item", "sobot_choose_dir_item"};
    private File mCheckedFile;
    private Context mContext;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotFilesAdapter$BaseViewHolder.class */
    static abstract class BaseViewHolder {
        Context mContext;

        BaseViewHolder(Context context, View view) {
            this.mContext = context;
        }

        abstract void bindData(File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotFilesAdapter$DirViewHolder.class */
    public static class DirViewHolder extends BaseViewHolder {
        private TextView sobot_tv_name;

        DirViewHolder(Context context, View view) {
            super(context, view);
            this.sobot_tv_name = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_name"));
        }

        @Override // com.sobot.chat.adapter.SobotFilesAdapter.BaseViewHolder
        void bindData(File file) {
            this.sobot_tv_name.setText(file.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotFilesAdapter$FileViewHolder.class */
    public class FileViewHolder extends BaseViewHolder {
        private TextView sobot_tv_descripe;
        private TextView sobot_tv_name;
        private TextView sobot_tv_radioBtn;

        FileViewHolder(Context context, View view) {
            super(context, view);
            this.sobot_tv_descripe = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_descripe"));
            this.sobot_tv_name = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_name"));
            this.sobot_tv_radioBtn = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_radioBtn"));
        }

        @Override // com.sobot.chat.adapter.SobotFilesAdapter.BaseViewHolder
        void bindData(File file) {
            this.sobot_tv_radioBtn.setSelected(SobotFilesAdapter.this.mCheckedFile != null && SobotFilesAdapter.this.mCheckedFile.equals(file));
            this.sobot_tv_descripe.setText(DateUtil.toDate(file.lastModified(), DateUtil.DATE_FORMAT) + "  " + Formatter.formatFileSize(this.mContext, file.length()));
            this.sobot_tv_name.setText(file.getName());
        }
    }

    public SobotFilesAdapter(Context context, List list) {
        super(context, list);
        this.mContext = context;
    }

    private View initView(View view, int i, int i2, File file) {
        View view2 = view;
        if (view == null) {
            view2 = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", layoutRes[i]), (ViewGroup) null);
            view2.setTag(i != 0 ? i != 1 ? new FileViewHolder(this.context, view2) : new DirViewHolder(this.context, view2) : new FileViewHolder(this.context, view2));
        }
        return view2;
    }

    public File getCheckedFile() {
        return this.mCheckedFile;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        File file = (File) this.list.get(i);
        View view2 = view;
        if (file != null) {
            view2 = initView(view, getItemViewType(i), i, file);
            ((BaseViewHolder) view2.getTag()).bindData(file);
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        String[] strArr = layoutRes;
        return strArr.length > 0 ? strArr.length : super.getViewTypeCount();
    }

    public boolean isCheckedFile(File file) {
        File file2 = this.mCheckedFile;
        return file2 != null && file2.equals(file);
    }

    public void setCheckedFile(File file) {
        this.mCheckedFile = file;
    }
}
