package com.sobot.chat.widget.kpswitch.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.widget.emoji.DisplayEmojiRules;
import com.sobot.chat.widget.emoji.EmojiconNew;
import com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView;
import com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonPageView;
import com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView;
import com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsIndicatorView;
import com.sobot.chat.widget.kpswitch.widget.adpater.EmoticonsAdapter;
import com.sobot.chat.widget.kpswitch.widget.adpater.PageSetAdapter;
import com.sobot.chat.widget.kpswitch.widget.data.EmoticonPageEntity;
import com.sobot.chat.widget.kpswitch.widget.data.EmoticonPageSetEntity;
import com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity;
import com.sobot.chat.widget.kpswitch.widget.interfaces.EmoticonClickListener;
import com.sobot.chat.widget.kpswitch.widget.interfaces.EmoticonDisplayListener;
import com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/ChattingPanelEmoticonView.class */
public class ChattingPanelEmoticonView extends BaseChattingPanelView implements EmoticonsFuncView.OnEmoticonsPageViewListener {
    EmoticonClickListener emoticonClickListener;
    protected EmoticonsFuncView mEmoticonsFuncView;
    protected EmoticonsIndicatorView mEmoticonsIndicatorView;
    SobotEmoticonClickListener mListener;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/ChattingPanelEmoticonView$SobotEmoticonClickListener.class */
    public interface SobotEmoticonClickListener extends BaseChattingPanelView.SobotBasePanelListener {
        void backspace();

        void inputEmoticon(EmojiconNew emojiconNew);
    }

    public ChattingPanelEmoticonView(Context context) {
        super(context);
        this.emoticonClickListener = new EmoticonClickListener() { // from class: com.sobot.chat.widget.kpswitch.view.ChattingPanelEmoticonView.3
            @Override // com.sobot.chat.widget.kpswitch.widget.interfaces.EmoticonClickListener
            public void onEmoticonClick(Object obj, boolean z) {
                if (ChattingPanelEmoticonView.this.mListener != null) {
                    if (z) {
                        ChattingPanelEmoticonView.this.mListener.backspace();
                    } else {
                        ChattingPanelEmoticonView.this.mListener.inputEmoticon((EmojiconNew) obj);
                    }
                }
            }
        };
    }

    @Override // com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView.OnEmoticonsPageViewListener
    public void emoticonSetChanged(PageSetEntity pageSetEntity) {
    }

    public EmoticonDisplayListener<Object> getEmoticonDisplayListener(final EmoticonClickListener emoticonClickListener) {
        return new EmoticonDisplayListener<Object>() { // from class: com.sobot.chat.widget.kpswitch.view.ChattingPanelEmoticonView.2
            @Override // com.sobot.chat.widget.kpswitch.widget.interfaces.EmoticonDisplayListener
            public void onBindView(int i, ViewGroup viewGroup, EmoticonsAdapter.ViewHolder viewHolder, Object obj, final boolean z) {
                final EmojiconNew emojiconNew = (EmojiconNew) obj;
                if (emojiconNew != null || z) {
                    viewHolder.ly_root.setBackgroundResource(ChattingPanelEmoticonView.this.getResDrawableId("sobot_bg_emoticon"));
                    if (z) {
                        viewHolder.iv_emoticon.setVisibility(0);
                        viewHolder.tv_emoticon.setVisibility(8);
                        viewHolder.iv_emoticon.setImageResource(ChattingPanelEmoticonView.this.getResDrawableId("sobot_emoticon_del_selector"));
                    } else {
                        viewHolder.iv_emoticon.setVisibility(8);
                        viewHolder.tv_emoticon.setVisibility(0);
                        viewHolder.tv_emoticon.setText(emojiconNew.getEmojiCode());
                    }
                    viewHolder.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.kpswitch.view.ChattingPanelEmoticonView.2.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            if (emoticonClickListener != null) {
                                emoticonClickListener.onEmoticonClick(emojiconNew, z);
                            }
                        }
                    });
                }
            }
        };
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public String getRootViewTag() {
        return "ChattingPanelEmoticonView";
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public void initData() {
        this.mEmoticonsFuncView = (EmoticonsFuncView) getRootView().findViewById(getResId("view_epv"));
        this.mEmoticonsIndicatorView = (EmoticonsIndicatorView) getRootView().findViewById(getResId("view_eiv"));
        this.mEmoticonsFuncView.setOnIndicatorListener(this);
        setAdapter();
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public View initView() {
        return View.inflate(this.context, getResLayoutId("sobot_emoticon_layout"), null);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView.OnEmoticonsPageViewListener
    public void playBy(int i, int i2, PageSetEntity pageSetEntity) {
        this.mEmoticonsIndicatorView.playBy(i, i2, pageSetEntity);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView.OnEmoticonsPageViewListener
    public void playTo(int i, PageSetEntity pageSetEntity) {
        this.mEmoticonsIndicatorView.playTo(i, pageSetEntity);
    }

    public void setAdapter() {
        PageSetAdapter pageSetAdapter = new PageSetAdapter();
        pageSetAdapter.add(new EmoticonPageSetEntity.Builder().setLine(getResInteger("sobot_emotiocon_line")).setRow(getResInteger("sobot_emotiocon_row")).setEmoticonList(DisplayEmojiRules.getListAll(this.context)).setIPageViewInstantiateItem(new PageViewInstantiateListener<EmoticonPageEntity>() { // from class: com.sobot.chat.widget.kpswitch.view.ChattingPanelEmoticonView.1
            @Override // com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener
            public View instantiateItem(ViewGroup viewGroup, int i, EmoticonPageEntity emoticonPageEntity) {
                if (emoticonPageEntity.getRootView() == null) {
                    EmoticonPageView emoticonPageView = new EmoticonPageView(viewGroup.getContext());
                    emoticonPageView.setNumColumns(emoticonPageEntity.getRow());
                    emoticonPageEntity.setRootView(emoticonPageView);
                    try {
                        EmoticonsAdapter emoticonsAdapter = new EmoticonsAdapter(viewGroup.getContext(), emoticonPageEntity, ChattingPanelEmoticonView.this.emoticonClickListener);
                        emoticonsAdapter.setItemHeightMaxRatio(1.8d);
                        emoticonsAdapter.setOnDisPlayListener(ChattingPanelEmoticonView.this.getEmoticonDisplayListener(ChattingPanelEmoticonView.this.emoticonClickListener));
                        emoticonPageView.getEmoticonsGridView().setAdapter((ListAdapter) emoticonsAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return emoticonPageEntity.getRootView();
            }
        }).setShowDelBtn(EmoticonPageEntity.DelBtnStatus.LAST).build());
        this.mEmoticonsFuncView.setAdapter(pageSetAdapter);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView
    public void setListener(BaseChattingPanelView.SobotBasePanelListener sobotBasePanelListener) {
        if (sobotBasePanelListener == null || !(sobotBasePanelListener instanceof SobotEmoticonClickListener)) {
            return;
        }
        this.mListener = (SobotEmoticonClickListener) sobotBasePanelListener;
    }
}
