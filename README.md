# QBinder
简单的注解绑定View和onClick事件，代替findViewById和setOnClickListener，个人Annotation学习产物

```goovy
compile 'q.rorbin:qbinder:1.0.0'
```

```java
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
```

#### 更新计划
使用注解处理器代替反射优化性能，编写对应的AS插件
