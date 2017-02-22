package q.rorbin.qbinder.binder.impl;

import android.app.Activity;
import android.view.View;

import q.rorbin.qbinder.binder.BinderHelper;

/**
 * @author chqiu
 * Email : qstumn@163.com
 * Github : https://github.com/qstumn
 */

public class ActivityBinderHelper extends BinderHelper {
    private Activity mActivity;
    private Object mObject;

    public ActivityBinderHelper(Activity activity, Object object) {
        this.mActivity = activity;
        this.mObject = object;
    }

    @Override
    protected View findViewById(int resid) {
        return mActivity.findViewById(resid);
    }

    @Override
    protected Object getObject() {
        return mObject;
    }
}
