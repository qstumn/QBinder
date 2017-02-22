package q.rorbin.qbinder.binder;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import q.rorbin.qbinder.annotation.BindView;
import q.rorbin.qbinder.annotation.OnClick;
import q.rorbin.qbinder.binder.interfaces.BindableOnClickListener;


/**
 * @author chqiu
 * Email : qstumn@163.com
 * Github : https://github.com/qstumn
 */

public abstract class BinderHelper {

    protected abstract View findViewById(int resid);

    protected abstract Object getObject();

    public void bind() {
        Class<?> objClass = getObject().getClass();
        bindField(objClass);
        bindMethod(objClass);
    }

    private void bindField(Class<?> objClass) {
        Field[] fields = objClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            BindView bindView = fields[i].getAnnotation(BindView.class);
            if (bindView != null) {
                bindFieldByBindView(bindView, fields[i]);
            }
        }
    }

    private void bindFieldByBindView(BindView bindView, Field field) {
        View view = findViewById(bindView.value());
        field.setAccessible(true);
        try {
            field.set(getObject(), view);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void bindMethod(Class<?> objClass) {
        Method[] methods = objClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            OnClick onClick = methods[i].getAnnotation(OnClick.class);
            if (onClick != null) {
                bindMethodByOnClick(onClick, methods[i]);
            }
        }
    }

    private void bindMethodByOnClick(OnClick onClick, Method method) {
        int[] values = onClick.value();
        BindableOnClickListener listener = new BindableOnClickListener(method, getObject());
        for (int i = 0; i < values.length; i++) {
            View view = findViewById(values[i]);
            view.setOnClickListener(listener);
        }
    }
}
