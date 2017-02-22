package q.rorbin.qbinder.binder.interfaces;

import android.view.View;

import java.lang.reflect.Method;

import q.rorbin.qbinder.binder.exception.BinderException;


/**
 * @author chqiu
 * Email : qstumn@163.com
 * Github : https://github.com/qstumn
 */

public class BindableOnClickListener implements View.OnClickListener {
    private Method method;
    private Object object;

    public BindableOnClickListener(Method method, Object object) {
        this.method = method;
        this.object = object;
    }

    @Override
    public void onClick(View v) {
        method.setAccessible(true);
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes != null && parameterTypes.length == 1 && parameterTypes[0] == View.class) {
            invoke(v);
        } else if (parameterTypes == null || parameterTypes.length == 0) {
            invoke(null);
        } else {
            throw new BinderException(method.getDeclaringClass().getName() + "." + method.getName() +
                    " may have up to 1 parameters or parameter may not be android.view.View");
        }
    }

    private void invoke(View v) {
        try {
            if (v != null) {
                method.invoke(object, v);
            } else {
                method.invoke(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
