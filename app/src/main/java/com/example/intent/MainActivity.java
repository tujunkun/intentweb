package com.example.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.intentButton);
        editText=(EditText) findViewById(R.id.intentText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //对intent进行设置
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String url="https://"+editText.getText().toString();
                intent.addCategory("android.intent.category.MY_CATEGORY");
                Uri uri = Uri.parse(url);
                intent.setData(uri);
                //     intent.setClassName("com.example.shiyan4", "com.example.shiyan4.viewWebActivity");
                //    intent.putExtra("url",url);
                 //   Intent choose=Intent.createChooser(intent,"选择浏览器");
                startActivity(intent);
            }
        });
    }
}
