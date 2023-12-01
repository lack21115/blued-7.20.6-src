package com.sobot.chat.widget.kpswitch.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView;
import com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView;
import com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsIndicatorView;
import com.sobot.chat.widget.kpswitch.view.plus.SobotPlusPageView;
import com.sobot.chat.widget.kpswitch.widget.adpater.PageSetAdapter;
import com.sobot.chat.widget.kpswitch.widget.adpater.PlusAdapter;
import com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity;
import com.sobot.chat.widget.kpswitch.widget.data.PlusPageEntity;
import com.sobot.chat.widget.kpswitch.widget.data.PlusPageSetEntity;
import com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener;
import com.sobot.chat.widget.kpswitch.widget.interfaces.PlusDisplayListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/ChattingPanelUploadView.class */
public class ChattingPanelUploadView extends BaseChattingPanelView implements View.OnClickListener, EmoticonsFuncView.OnEmoticonsPageViewListener {
    private static final String ACTION_CAMERA = "sobot_action_camera";
    private static final String ACTION_CHOOSE_FILE = "sobot_action_choose_file";
    private static final String ACTION_LEAVEMSG = "sobot_action_leavemsg";
    private static final String ACTION_PIC = "sobot_action_pic";
    private static final String ACTION_SATISFACTION = "sobot_action_satisfaction";
    private static final String ACTION_VIDEO = "sobot_action_video";
    private int mCurrentClientMode;
    private EmoticonsFuncView mEmoticonsFuncView;
    private EmoticonsIndicatorView mEmoticonsIndicatorView;
    private SobotPlusClickListener mListener;
    private List<SobotPlusEntity> operatorList;
    private PageSetAdapter pageSetAdapter;
    private List<SobotPlusEntity> robotList;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/ChattingPanelUploadView$SobotPlusClickListener.class */
    public interface SobotPlusClickListener extends BaseChattingPanelView.SobotBasePanelListener {
        void btnCameraPicture();

        void btnPicture();

        void btnSatisfaction();

        void btnVedio();

        void chooseFile();

        void startToPostMsgActivty(boolean z);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/ChattingPanelUploadView$SobotPlusEntity.class */
    public static class SobotPlusEntity {
        public String action;
        public int iconResId;
        public String name;

        public SobotPlusEntity(int i, String str, String str2) {
            this.iconResId = i;
            this.name = str;
            this.action = str2;
        }
    }

    public ChattingPanelUploadView(Context context) {
        super(context);
        this.robotList = new ArrayList();
        this.operatorList = new ArrayList();
        this.mCurrentClientMode = -1;
    }

    private void setAdapter(List<SobotPlusEntity> list) {
        PageSetAdapter pageSetAdapter = this.pageSetAdapter;
        if (pageSetAdapter == null) {
            this.pageSetAdapter = new PageSetAdapter();
        } else {
            pageSetAdapter.getPageSetEntityList().clear();
        }
        this.pageSetAdapter.add(new PlusPageSetEntity.Builder().setLine(getResInteger("sobot_plus_menu_line")).setRow(getResInteger("sobot_plus_menu_row")).setDataList(list).setIPageViewInstantiateItem(new PageViewInstantiateListener<PlusPageEntity>() { // from class: com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView.1
            @Override // com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener
            public View instantiateItem(ViewGroup viewGroup, int i, PlusPageEntity plusPageEntity) {
                if (plusPageEntity.getRootView() == null) {
                    SobotPlusPageView sobotPlusPageView = new SobotPlusPageView(viewGroup.getContext());
                    sobotPlusPageView.setNumColumns(plusPageEntity.getRow());
                    plusPageEntity.setRootView(sobotPlusPageView);
                    try {
                        PlusAdapter plusAdapter = new PlusAdapter(viewGroup.getContext(), plusPageEntity, ChattingPanelUploadView.this.mListener);
                        plusAdapter.setOnDisPlayListener(ChattingPanelUploadView.this.getPlusItemDisplayListener(ChattingPanelUploadView.this.mListener));
                        sobotPlusPageView.getGridView().setAdapter((ListAdapter) plusAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return plusPageEntity.getRootView();
            }
        }).build());
        this.mEmoticonsFuncView.setAdapter(this.pageSetAdapter);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView.OnEmoticonsPageViewListener
    public void emoticonSetChanged(PageSetEntity pageSetEntity) {
    }

    public PlusDisplayListener<Object> getPlusItemDisplayListener(SobotPlusClickListener sobotPlusClickListener) {
        return new PlusDisplayListener<Object>() { // from class: com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView.2
            @Override // com.sobot.chat.widget.kpswitch.widget.interfaces.PlusDisplayListener
            public void onBindView(int i, ViewGroup viewGroup, PlusAdapter.ViewHolder viewHolder, Object obj) {
                SobotPlusEntity sobotPlusEntity = (SobotPlusEntity) obj;
                if (sobotPlusEntity == null) {
                    return;
                }
                viewHolder.mMenu.setText(sobotPlusEntity.name);
                Drawable drawable = ChattingPanelUploadView.this.context.getResources().getDrawable(sobotPlusEntity.iconResId);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                viewHolder.mMenu.setCompoundDrawables(null, drawable, null, null);
                viewHolder.mMenu.setTag(sobotPlusEntity.action);
                viewHolder.rootView.setOnClickListener(ChattingPanelUploadView.this);
            }
        };
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public String getRootViewTag() {
        return "ChattingPanelUploadView";
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public void initData() {
        Information information = (Information) SharedPreferencesUtil.getObject(this.context, ZhiChiConstant.sobot_last_current_info);
        int intData = SharedPreferencesUtil.getIntData(this.context, ZhiChiConstant.sobot_msg_flag, 0);
        boolean booleanData = SharedPreferencesUtil.getBooleanData(this.context, ZhiChiConstant.sobot_leave_msg_flag, false);
        this.mEmoticonsFuncView = (EmoticonsFuncView) getRootView().findViewById(getResId("view_epv"));
        this.mEmoticonsIndicatorView = (EmoticonsIndicatorView) getRootView().findViewById(getResId("view_eiv"));
        this.mEmoticonsFuncView.setOnIndicatorListener(this);
        SobotPlusEntity sobotPlusEntity = new SobotPlusEntity(getResDrawableId("sobot_tack_picture_button_selector"), getResString("sobot_upload"), ACTION_PIC);
        SobotPlusEntity sobotPlusEntity2 = new SobotPlusEntity(getResDrawableId("sobot_tack_video_button_selector"), getResString("sobot_upload_video"), ACTION_VIDEO);
        SobotPlusEntity sobotPlusEntity3 = new SobotPlusEntity(getResDrawableId("sobot_camera_picture_button_selector"), getResString("sobot_attach_take_pic"), ACTION_CAMERA);
        SobotPlusEntity sobotPlusEntity4 = new SobotPlusEntity(getResDrawableId("sobot_choose_file_btn_selector"), getResString("sobot_choose_file"), ACTION_CHOOSE_FILE);
        SobotPlusEntity sobotPlusEntity5 = new SobotPlusEntity(getResDrawableId("sobot_leavemsg_selector"), getResString("sobot_str_bottom_message"), ACTION_LEAVEMSG);
        SobotPlusEntity sobotPlusEntity6 = new SobotPlusEntity(getResDrawableId("sobot_picture_satisfaction_selector"), getResString("sobot_str_bottom_satisfaction"), ACTION_SATISFACTION);
        this.robotList.clear();
        this.operatorList.clear();
        if (information == null) {
            if (intData == 0) {
                this.robotList.add(sobotPlusEntity5);
            }
            this.robotList.add(sobotPlusEntity6);
            this.operatorList.add(sobotPlusEntity);
            this.operatorList.add(sobotPlusEntity2);
            this.operatorList.add(sobotPlusEntity3);
            this.operatorList.add(sobotPlusEntity4);
            if (intData == 0 && !booleanData) {
                this.operatorList.add(sobotPlusEntity5);
            }
            this.operatorList.add(sobotPlusEntity6);
            return;
        }
        if (!information.isHideMenuLeave() && intData == 0) {
            this.robotList.add(sobotPlusEntity5);
        }
        if (!information.isHideMenuSatisfaction()) {
            this.robotList.add(sobotPlusEntity6);
        }
        if (!information.isHideMenuPicture()) {
            this.operatorList.add(sobotPlusEntity);
        }
        if (!information.isHideMenuVedio()) {
            this.operatorList.add(sobotPlusEntity2);
        }
        if (!information.isHideMenuCamera()) {
            this.operatorList.add(sobotPlusEntity3);
        }
        if (!information.isHideMenuFile()) {
            this.operatorList.add(sobotPlusEntity4);
        }
        if (!information.isHideMenuLeave() && !information.isHideMenuManualLeave() && intData == 0 && !booleanData) {
            this.operatorList.add(sobotPlusEntity5);
        }
        if (information.isHideMenuSatisfaction()) {
            return;
        }
        this.operatorList.add(sobotPlusEntity6);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public View initView() {
        return View.inflate(this.context, getResLayoutId("sobot_upload_layout"), null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.mListener != null) {
            String str = (String) view.findViewById(getResId("sobot_plus_menu")).getTag();
            if (ACTION_SATISFACTION.equals(str)) {
                this.mListener.btnSatisfaction();
            } else if (ACTION_LEAVEMSG.equals(str)) {
                this.mListener.startToPostMsgActivty(false);
            } else if (ACTION_PIC.equals(str)) {
                this.mListener.btnPicture();
            } else if (ACTION_VIDEO.equals(str)) {
                this.mListener.btnVedio();
            } else if (ACTION_CAMERA.equals(str)) {
                this.mListener.btnCameraPicture();
            } else if (ACTION_CHOOSE_FILE.equals(str)) {
                this.mListener.chooseFile();
            } else if (SobotUIConfig.pulsMenu.sSobotPlusMenuListener != null) {
                SobotUIConfig.pulsMenu.sSobotPlusMenuListener.onClick(view, str);
            }
        }
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public void onViewStart(Bundle bundle) {
        int i = bundle.getInt("current_client_model");
        int i2 = this.mCurrentClientMode;
        if (i2 == -1 || i2 != i) {
            ArrayList arrayList = new ArrayList();
            if (bundle.getInt("current_client_model") == 301) {
                arrayList.addAll(this.robotList);
            } else {
                arrayList.addAll(this.operatorList);
                if (SobotUIConfig.pulsMenu.operatorMenus != null) {
                    arrayList.addAll(SobotUIConfig.pulsMenu.operatorMenus);
                }
            }
            if (SobotUIConfig.pulsMenu.menus != null) {
                arrayList.addAll(SobotUIConfig.pulsMenu.menus);
            }
            setAdapter(arrayList);
        }
        this.mCurrentClientMode = i;
    }

    @Override // com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView.OnEmoticonsPageViewListener
    public void playBy(int i, int i2, PageSetEntity pageSetEntity) {
        this.mEmoticonsIndicatorView.playBy(i, i2, pageSetEntity);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView.OnEmoticonsPageViewListener
    public void playTo(int i, PageSetEntity pageSetEntity) {
        this.mEmoticonsIndicatorView.playTo(i, pageSetEntity);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public void setListener(BaseChattingPanelView.SobotBasePanelListener sobotBasePanelListener) {
        if (sobotBasePanelListener == null || !(sobotBasePanelListener instanceof SobotPlusClickListener)) {
            return;
        }
        this.mListener = (SobotPlusClickListener) sobotBasePanelListener;
    }
}
