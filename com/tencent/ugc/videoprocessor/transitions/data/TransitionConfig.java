package com.tencent.ugc.videoprocessor.transitions.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/transitions/data/TransitionConfig.class */
public class TransitionConfig {
    private final List<TransitionBean> mTransitions = new ArrayList();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/transitions/data/TransitionConfig$TransitionBean.class */
    public static class TransitionBean {
        public int type;
        public long startTimeMs = -1;
        public long endTimeMs = -1;

        public TransitionBean(int i) {
            this.type = i;
        }
    }

    public void addTransition(TransitionBean transitionBean) {
        this.mTransitions.add(transitionBean);
    }

    public void clear() {
        this.mTransitions.clear();
    }

    public void deleteLastTransitionEffect() {
        if (this.mTransitions.size() == 0) {
            return;
        }
        List<TransitionBean> list = this.mTransitions;
        list.remove(list.size() - 1);
    }

    public List<TransitionBean> getTransitionList() {
        return this.mTransitions;
    }
}
