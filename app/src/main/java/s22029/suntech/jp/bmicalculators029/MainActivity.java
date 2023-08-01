package s22029.suntech.jp.bmicalculators029;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalc = findViewById(R.id.btCalc);

        buttonListener listener = new buttonListener();
        btCalc.setOnClickListener(listener);
        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    private class buttonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            EditText input_wei = findViewById(R.id.etWeight);
            EditText input_hei = findViewById(R.id.etHeight);
            EditText input_age = findViewById(R.id.etAge);
            TextView output_result1 = findViewById(R.id.tvResult1);
            TextView output_result2 = findViewById(R.id.tvResult2);
            TextView output_calcResult = findViewById(R.id.tvCalcResult);
            TextView output_appWeight = findViewById(R.id.tvAppWeight);
            int id = v.getId();
            if(id == R.id.btCalc){
                int age = Integer.parseInt(input_age.getText().toString());
                if(age <= 16){
                    BMIDialogFragment dialogFragment = new BMIDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(),"BMIDialogFragment");
                }
                float weight = Float.parseFloat(input_wei.getText().toString());
                float height = Float.parseFloat(input_hei.getText().toString());
                height = height/100;
                float BMI = weight/(height*height);
                String str = String.format("%.2fkg",height*height*22);
                output_result1.setText("あなたの肥満度は");
                output_result2.setText("あなたの適正体重は");
                if(BMI < 18.5){
                    output_calcResult.setText("低体重(やせ型)");
                    output_appWeight.setText(str);
                }
                else if(BMI < 25) {
                    output_calcResult.setText("普通体重");
                    output_appWeight.setText(str);
                }
                else if(BMI < 30) {
                    output_calcResult.setText("肥満(１度)");
                    output_appWeight.setText(str);
                }
                else if(BMI < 35) {
                    output_calcResult.setText("肥満(２度)");
                    output_appWeight.setText(str);
                }
                else if(BMI < 40) {
                    output_calcResult.setText("肥満(３度)");
                    output_appWeight.setText(str);
                }
                else {
                    output_calcResult.setText("肥満(４度)");
                    output_appWeight.setText(str);
                }
            }
            if(id == R.id.btClear){
                input_hei.setText("");
                input_wei.setText("");
                input_age.setText("");
                output_result1.setText("");
                output_result2.setText("");
                output_calcResult.setText("");
                output_appWeight.setText("");
            }
        }
    }
}