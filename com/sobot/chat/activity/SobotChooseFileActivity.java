package com.sobot.chat.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.format.Formatter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.adapter.SobotFilesAdapter;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.FileOpenHelper;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotChooseFileActivity.class */
public class SobotChooseFileActivity extends SobotBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int READ_REQUEST_CODE = 42;
    private SobotFilesAdapter mAdapter;
    private File mCurrentDir;
    private ListView sobot_lv_files;
    private TextView sobot_tv_send;
    private TextView sobot_tv_total;
    private File mRootDir = Environment.getExternalStorageDirectory();
    private List<File> mDatas = new ArrayList();

    private File[] getChildFiles(File file) {
        if (file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    private void goback() {
        if (this.mRootDir.equals(this.mCurrentDir)) {
            super.onBackPressed();
            finish();
            return;
        }
        File parentFile = this.mCurrentDir.getParentFile();
        this.mCurrentDir = parentFile;
        showCurrentFiles(parentFile);
    }

    private void showCurrentFiles(File file) {
        if (file.isDirectory()) {
            showData(getChildFiles(file));
        }
    }

    private void showData(File[] fileArr) {
        this.mDatas.clear();
        if (fileArr != null) {
            this.mDatas.addAll(Arrays.asList(fileArr));
        }
        Collections.sort(this.mDatas, new Comparator<File>() { // from class: com.sobot.chat.activity.SobotChooseFileActivity.1
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                if (file.isDirectory() && file2.isFile()) {
                    return -1;
                }
                if (file.isFile() && file2.isDirectory()) {
                    return 1;
                }
                return file2.getName().compareTo(file.getName());
            }
        });
        SobotFilesAdapter sobotFilesAdapter = this.mAdapter;
        if (sobotFilesAdapter != null) {
            sobotFilesAdapter.notifyDataSetChanged();
            return;
        }
        SobotFilesAdapter sobotFilesAdapter2 = new SobotFilesAdapter(this, this.mDatas);
        this.mAdapter = sobotFilesAdapter2;
        this.sobot_lv_files.setAdapter((ListAdapter) sobotFilesAdapter2);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_choose_file");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        if (checkStoragePermission() && CommonUtils.isExitsSdcard()) {
            File file = this.mRootDir;
            this.mCurrentDir = file;
            showCurrentFiles(file);
            this.sobot_lv_files.setOnItemClickListener(this);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        if (Build.VERSION.SDK_INT >= 29) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(intent, 42);
        }
        setTitle(getResString("sobot_internal_memory"));
        showLeftMenu(getResDrawableId("sobot_btn_back_selector"), "", true);
        this.sobot_lv_files = (ListView) findViewById(getResId("sobot_lv_files"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_send"));
        this.sobot_tv_send = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_button_send"));
        this.sobot_tv_total = (TextView) findViewById(getResId("sobot_tv_total"));
        this.sobot_tv_send.setOnClickListener(this);
        displayInNotch(this.sobot_lv_files);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        if (i != 42 || i2 != -1 || intent == null || (data = intent.getData()) == null) {
            finish();
            return;
        }
        Intent intent2 = new Intent();
        intent2.setData(data);
        setResult(107, intent2);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        goback();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File checkedFile;
        Tracker.onClick(view);
        if (view != this.sobot_tv_send || (checkedFile = this.mAdapter.getCheckedFile()) == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(ZhiChiConstant.SOBOT_INTENT_DATA_SELECTED_FILE, checkedFile);
        setResult(107, intent);
        finish();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String formatFileSize;
        Tracker.onItemClick(adapterView, view, i, j);
        try {
            File file = this.mDatas.get(i);
            if (file != null) {
                if (file.isDirectory()) {
                    this.mCurrentDir = file;
                    showCurrentFiles(file);
                } else if (file.length() > 52428800) {
                    ToastUtil.showToast(this, getResString("sobot_file_upload_failed"));
                } else if (FileOpenHelper.checkEndsWithInStringArray(file.getName().toLowerCase(), this, "sobot_fileEndingAll") || this.mAdapter == null) {
                } else {
                    if (this.mAdapter.isCheckedFile(file)) {
                        this.mAdapter.setCheckedFile(null);
                        formatFileSize = "0B";
                        this.sobot_tv_send.setEnabled(false);
                    } else {
                        this.mAdapter.setCheckedFile(file);
                        formatFileSize = Formatter.formatFileSize(this, file.length());
                        this.sobot_tv_send.setEnabled(true);
                    }
                    this.mAdapter.notifyDataSetChanged();
                    TextView textView = this.sobot_tv_total;
                    textView.setText(getResString("sobot_files_selected") + "：" + formatFileSize);
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void onLeftMenuClick(View view) {
        goback();
    }
}
