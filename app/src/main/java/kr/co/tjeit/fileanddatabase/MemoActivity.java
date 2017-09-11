package kr.co.tjeit.fileanddatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import kr.co.tjeit.fileanddatabase.util.ObjectFileManager;

// 파일 저장 / 불러오기 / 삭제 기능 구현
// TextManager 클래스 활용

public class MemoActivity extends BaseActivity {

//    TextManager mTextManager = new TextManager(mContext);

    ObjectFileManager ofm = new ObjectFileManager(mContext);

    private android.widget.Button loadBtn;
    private android.widget.Button saveBtn;
    private android.widget.Button deleteBtn;
    private android.widget.EditText contentEdt;
    private EditText titleEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);


        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mTextManager.save(contentEdt.getText().toString());
                HashMap<String,String> memoData = new HashMap<String, String>();
                memoData.put("title",titleEdt.getText().toString());
                memoData.put("content",contentEdt.getText().toString());

                ofm.save(memoData);

                titleEdt.setText("");
                contentEdt.setText("");
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                contentEdt.setText(mTextManager.load());

                HashMap<String, String> loadMemoData = ofm.load();

                titleEdt.setText(loadMemoData.get("title"));
                contentEdt.setText(loadMemoData.get("content"));

            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mTextManager.delete();
                ofm.delete();
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
