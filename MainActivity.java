package com.example.calculator3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView edtext;
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    private Button clear, del, add, sub, divid, mult, point, euq, leftkuo, rightkuo, thepow, thefu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtext = (TextView) findViewById(R.id.edtext);
        edtext.setSingleLine(true);
        edtext.setHorizontallyScrolling(true);
        edtext.setInputType(InputType.TYPE_NULL);//编辑框属性

        num0 = (Button) findViewById(R.id.button_num0);
        num1 = (Button) findViewById(R.id.button_num1);
        num2 = (Button) findViewById(R.id.button_num2);
        num3 = (Button) findViewById(R.id.button_num3);
        num4 = (Button) findViewById(R.id.button_num4);
        num5 = (Button) findViewById(R.id.button_num5);
        num6 = (Button) findViewById(R.id.button_num6);
        num7 = (Button) findViewById(R.id.button_num7);
        num8 = (Button) findViewById(R.id.button_num8);
        num9 = (Button) findViewById(R.id.button_num9);
        clear = (Button) findViewById(R.id.button_clear);
        del = (Button) findViewById(R.id.button_delete);
        add = (Button) findViewById(R.id.button_add);
        sub = (Button) findViewById(R.id.button_sub);
        mult = (Button) findViewById(R.id.multi);
        divid = (Button) findViewById(R.id.button_divid);
        point = (Button) findViewById(R.id.button_point);
        euq = (Button) findViewById(R.id.button_equal);
        leftkuo = (Button) findViewById(R.id.button_leftkuo);
        rightkuo = (Button) findViewById(R.id.button_rightkuo);
        thepow = (Button) findViewById(R.id.button_pow);
        thefu = (Button) findViewById(R.id.button_thefu);


        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        clear.setOnClickListener(this);
        del.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mult.setOnClickListener(this);
        divid.setOnClickListener(this);
        point.setOnClickListener(this);
        euq.setOnClickListener(this);
        leftkuo.setOnClickListener(this);
        rightkuo.setOnClickListener(this);
        thepow.setOnClickListener(this);
        thefu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str;
        switch (v.getId()) {
            case R.id.button_num0:
                str = edtext.getText().toString();
                str += "0";
                edtext.setText(str);
                break;
            case R.id.button_num1:
                str = edtext.getText().toString();
                str += "1";
                edtext.setText(str);
                break;
            case R.id.button_num2:
                str = edtext.getText().toString();
                str += "2";
                edtext.setText(str);
                break;
            case R.id.button_num3:
                str = edtext.getText().toString();
                str += "3";
                edtext.setText(str);
                break;
            case R.id.button_num4:
                str = edtext.getText().toString();
                str += "4";
                edtext.setText(str);
                break;
            case R.id.button_num5:
                str = edtext.getText().toString();
                str += "5";
                edtext.setText(str);
                break;
            case R.id.button_num6:
                str = edtext.getText().toString();
                str += "6";
                edtext.setText(str);
                break;
            case R.id.button_num7:
                str = edtext.getText().toString();
                str += "7";
                edtext.setText(str);
                break;
            case R.id.button_num8:
                str = edtext.getText().toString();
                str += "8";
                edtext.setText(str);
                break;
            case R.id.button_num9:
                str = edtext.getText().toString();
                str += "9";
                edtext.setText(str);
                break;
            case R.id.button_add:
                str = edtext.getText().toString();
                str += "+";
                edtext.setText(str);
                break;
            case R.id.button_sub:
                str = edtext.getText().toString();
                str += "-";
                edtext.setText(str);
                break;
            case R.id.multi:
                str = edtext.getText().toString();
                str += "*";
                edtext.setText(str);
                break;
            case R.id.button_divid:
                str = edtext.getText().toString();
                str += "/";
                edtext.setText(str);
                break;
            case R.id.button_point:
                str = edtext.getText().toString();
                str += ".";
                edtext.setText(str);
                break;
            case R.id.button_leftkuo:
                str = edtext.getText().toString();
                str += "(";
                edtext.setText(str);
                break;
            case R.id.button_rightkuo:
                str = edtext.getText().toString();
                str += ")";
                edtext.setText(str);
                break;
            case R.id.button_pow:
                str = edtext.getText().toString();
                str += "^";
                edtext.setText(str);
                break;
            case R.id.button_thefu:
                str = edtext.getText().toString();
                str += "~";
                edtext.setText(str);
                break;

            case R.id.button_clear:
                edtext.setText("");
                break;
            case R.id.button_delete:
                if (edtext.length() != 0) {
                    str = edtext.getText().toString();
                    str = str.substring(0, str.length() - 1);
                    edtext.setText(str);
                    break;
                } else break;
            case R.id.button_equal:
                if (edtext.length() != 0) {
                    str = edtext.getText().toString();
                    char[] m = str.toCharArray();
                    Calculation cal = new Calculation(m);
                    cal.trans();
                    double dtemp = cal.compvalue();

                    if (cal.Isright) {
                        int itemp = (int) dtemp;
                        if (itemp != dtemp) {//结果是小数
                            str = String.valueOf(dtemp);
                            while (str.charAt(str.length() - 1) == '0')//删去小数末尾的0
                                str = str.substring(1, str.charAt(str.length() - 2));
                            edtext.setText(str);
                            break;
                        } else {//结果是整数
                            str = String.valueOf(itemp);
                            edtext.setText(str);
                            break;
                        }
                    } else {
                        Toast t = new Toast(this);
                        t.makeText(getApplicationContext(), "不合法的输入", Toast.LENGTH_SHORT).show();
                    }
                } else break;
        }
    }
}
