package q.rorbin.qbinder.binder.impl;

import android.view.View;

import q.rorbin.qbinder.binder.BinderHelper;

/**
 * @author chqiu
 * Email : qstumn@163.com
 * Github : https://github.com/qstumn
 */

public class ViewBinderHelper extends BinderHelper {
    private View mView;
    private Object mObject;

    public ViewBinderHelper(View view, Object object) {
        this.mView = view;
        this.mObject = object;
    }

    @Override
    protected View findViewById(int resid) {
        return mView.findViewById(resid);
    }

    @Override
    protected Object getObject() {
        return mObject;
    }
}
