package com.example.areas2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    double area =0;
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inflat
        Toast.makeText(getBaseContext(),"on create",Toast.LENGTH_LONG).show();
        Spinner sp_shapes = findViewById(R.id.areas_sp_shape);
        EditText et_rectangle_width =findViewById(R.id.areas_et_width_rec);
        EditText et_rectangle_height =findViewById(R.id.areas_et_height_rec);
        EditText et_circle_radius =findViewById(R.id.areas_et_radius);
        EditText et_triangle_width =findViewById(R.id.areas_et_width_tri);
        EditText et_triangle_height =findViewById(R.id.areas_et_height_tri);
        tv_result =findViewById(R.id.areas_tv_result);
        Button btn_calculate = findViewById(R.id.areas_bu_calculate);
        //circle = pi*r*r
        //rectangle = w*h
        // triangle = (b*h)/2;
        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        et_triangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        break;
                    case 1:
                        et_rectangle_height.setVisibility(View.VISIBLE);
                        et_rectangle_width.setVisibility(View.VISIBLE);
                        et_triangle_height.setVisibility(View.GONE);
                        et_triangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        break;
                    case 2:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        et_triangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.VISIBLE);
                        et_triangle_width.setVisibility(View.VISIBLE);
                        et_circle_radius.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int index =sp_shapes.getSelectedItemPosition();
               //لمااضغط ع الور اعرف العنصر اللي تم اختيااره

               switch (index)
               {
                   case 1 :
                       //rectangle
                       String h = et_rectangle_height.getText().toString();
                       String w =et_rectangle_width.getText().toString();
                       double rect_height =Double.parseDouble(h);
                       double rect_width =Double.parseDouble(w);
                       area =rect_height*rect_width;
                       break;
                   case 2:
                       //circle
                       String r = et_circle_radius.getText().toString();
                       double radius = Double.parseDouble(r);
                       area = 3.14 *radius *radius ;
                       break;
                   case 3:
                       String x = et_triangle_height.getText().toString();
                       String y = et_triangle_width.getText().toString();
                       double base_tri = Double.parseDouble(y);
                       double height_tri =Double.parseDouble(x);
                       area =(base_tri*height_tri)/2;
                       break;
               }
               // الداله بتاعت الست دي بتاخد نص مش بتاخد ارقام ف هنعمل زي معملنا فوق
               tv_result.setText(area+"");
            }
        });
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(),"on start",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getBaseContext(),"on resume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(),"on pause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getBaseContext(),"on stop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getBaseContext(),"on restart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(),"on destroy",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // قولنا دي بتتنفذ بعد ال pause
       // outState.putString("result",area+"");
        // لو جيت قلبت مرتين هيديلي القيمه بصفر لان هو اصلا بصفر و انا مغيرتش فيه
        // لتفادي الحوار انا هقوله يحفظلي اللي موجود ف قلب التكست فيو نفسه
        //كانت ال area لوكال و حولناها جلوبال
        outState.putString("result",tv_result.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // دي بتتنفذ بعدال on start
        String s = savedInstanceState.getString("result");
        tv_result.setText(s);
    }*/
}