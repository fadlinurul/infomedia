package id.co.infomedia.infomediaanalytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.co.infomedia.analytics.CustomOnClickListener;
import id.co.infomedia.analytics.DeviceInformation;

public class MainActivity extends AppCompatActivity {

    protected Button button;
    protected TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        setEvent();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
    }
    private void setEvent(){
        button.setOnClickListener(new CustomOnClickListener(MainActivity.this, button, new CustomOnClickListener.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(DeviceInformation.getInfosAboutDevice(MainActivity.this));
            }
        }));
    }
}
