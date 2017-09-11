package kr.co.tjeit.fileanddatabase;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

public class SharedPrefActivity extends BaseActivity {

    private android.widget.CheckBox pushCheckBox;
    private android.widget.Switch autoLoginSwitch;
    String prefName = "FileAndDatabasePref";
    SharedPreferences pref = mContext.getSharedPreferences(prefName, MODE_PRIVATE);
    private android.widget.ToggleButton soundToggleBtn;
    private android.widget.EditText nameEdt;
    private android.widget.Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);


        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        pushCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                pref.edit().putBoolean("pushCheck",isChecked).apply();
            }
        });
        autoLoginSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                pref.edit().putBoolean("autoLogin",isChecked).apply();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref.edit().putString("name",nameEdt.getText().toString()).apply();
            }
        });



    }

    @Override
    public void setValues() {


        pushCheckBox.setChecked(pref.getBoolean("puschCheck",false));
        autoLoginSwitch.setChecked(pref.getBoolean("autoLogin",false));
        nameEdt.setText(pref.getString("name",""));

    }

    @Override
    public void bindViews() {
        this.autoLoginSwitch = (Switch) findViewById(R.id.autoLoginSwitch);
        this.pushCheckBox = (CheckBox) findViewById(R.id.pushCheckBox);
        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.soundToggleBtn = (ToggleButton) findViewById(R.id.soundToggleBtn);
        this.autoLoginSwitch = (Switch) findViewById(R.id.autoLoginSwitch);
        this.pushCheckBox = (CheckBox) findViewById(R.id.pushCheckBox);

    }
}
