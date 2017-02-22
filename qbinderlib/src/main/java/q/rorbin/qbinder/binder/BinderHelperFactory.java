package q.rorbin.qbinder.binder;

import android.app.Activity;
import android.view.View;

import q.rorbin.qbinder.binder.impl.ActivityBinderHelper;
import q.rorbin.qbinder.binder.impl.DefaultBinderHelper;
import q.rorbin.qbinder.binder.impl.ViewBinderHelper;

/**
 * @author chqiu
 * Email : qstumn@163.com
 * Github : https://github.com/qstumn
 */

public class BinderHelperFactory {

    public static BinderHelper createBinderHelper(Object view, Object object) {
        if (view instanceof Activity) {
            return new ActivityBinderHelper((Activity) view, object);
        } else if (view instanceof View) {
            return new ViewBinderHelper(((View) view), object);
        }
        return new DefaultBinderHelper();
    }
}
