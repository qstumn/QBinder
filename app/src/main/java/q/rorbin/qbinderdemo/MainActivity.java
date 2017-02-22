package q.rorbin.qbinderdemo;

import android.support.annotation.AnyRes;
import android.support.annotation.Size;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.annotation.Target;

import q.rorbin.qbinder.QBinder;
import q.rorbin.qbinder.annotation.BindView;
import q.rorbin.qbinder.annotation.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textview)
    TextView textView;

    @BindView(R.id.imageview)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QBinder.bind(this);
        textView.setText("Hello Annotation!");
        imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @OnClick({R.id.textview, R.id.imageview})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.textview:
                Toast.makeText(MainActivity.this, "Click By TextView", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageview:
                Toast.makeText(MainActivity.this, "Click By ImageView", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
