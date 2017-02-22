package q.rorbin.qbinder;

import android.app.Activity;
import android.view.View;

import q.rorbin.qbinder.binder.BinderHelperFactory;

/**
 * @author chqiu
 * Email : qstumn@163.com
 * Github : https://github.com/qstumn
 */

public class QBinder {

    /**
     * 绑定Activity
     * @param activity
     */
    public static void bind(Activity activity) {
        BinderHelperFactory.createBinderHelper(activity, activity).bind();
    }

    /**
     * 绑定自定义View
     * @param view
     */
    public static void bind(View view) {
        BinderHelperFactory.createBinderHelper(view, view).bind();
    }

    /**
     * 绑定任意对象
     * @param view
     * @param object
     */
    public static void bind(View view, Object object) {
        BinderHelperFactory.createBinderHelper(view, object).bind();
    }

}
