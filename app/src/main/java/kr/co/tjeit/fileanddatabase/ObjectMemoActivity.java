package kr.co.tjeit.fileanddatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import kr.co.tjeit.fileanddatabase.util.ObjectManager02;

public class ObjectMemoActivity extends BaseActivity {

    private android.widget.Button loadBtn;
    private android.widget.Button saveBtn;
    private android.widget.Button deleteBtn;
    private android.widget.EditText titleEdt;
    private android.widget.EditText contentEdt;
    ObjectManager02 om2 = new ObjectManager02(mContext);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_memo);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleEdt.setText(om2.load().get("title"));
                contentEdt.setText(om2.load().get("content"));
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> saveData = new HashMap<>();
                saveData.put("title",titleEdt.getText().toString());
                saveData.put("content",contentEdt.getText().toString());
                om2.save(saveData);

                titleEdt.setText("");
                contentEdt.setText("");
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                om2.delete();
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.titleEdt = (EditText) findViewById(R.id.titleEdt);
        this.deleteBtn = (Button) findViewById(R.id.deleteBtn);
        this.saveBtn = (Button) findViewById(R.id.saveBtn);
        this.loadBtn = (Button) findViewById(R.id.loadBtn);
    }
}
