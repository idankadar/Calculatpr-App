package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView result;
    char ch;
    int n1=0, n2=0;
    boolean isequalwaslast = false;
    boolean isOperatorSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById(R.id.textViewresult);
        result.setText("");
    }

    public void numFunc(View view) {
        onbottonanimation(view);
        Button b = (Button)view;
        if(!isequalwaslast)
            result.append(b.getText().toString());
        else {
            result.setText(b.getText().toString());
        }
        isequalwaslast=false;

    }

    public void funequal(View view) {

        onbottonanimation(view);
        int res=0;

        //checking if the n1 is empty
        if(result.getText().toString().isEmpty())
            return;
        if(!isOperatorSet)
            return;

    n2=(Integer.parseInt(result.getText().toString())) ;
    if(ch=='+')
        res = n1+n2;
    else if(ch=='-')
        res = n1-n2;
    else if(ch=='/')
        if(n2==0) {
            result.setText("Error");
            return;
        }        else
            res = n1/n2;
    else if(ch=='X')
        res = n1*n2;


    result.setText(String.valueOf(res));
    isequalwaslast=true;
    isOperatorSet=false;

    }

    public void funcCh(View view) {
        onbottonanimation(view);
        if(result.getText().toString().isEmpty()) //checking if there
            return;
        n1 = (Integer.parseInt(result.getText().toString())) ;
        Button b = (Button)view;
        ch=b.getText().toString().charAt(0);
        result.setText("");
        isOperatorSet=true;

    }

    public void clearfun(View view) {
        onbottonanimation(view);
        n1=0;
        n2=0;
        ch='\0';
        result.setText("");
        isequalwaslast=false;
        isOperatorSet=false;
    }



    public void onbottonanimation(View view) {
        view.animate()
                .scaleX(0.9f) // מקטין את הכפתור ל-90% מהרוחב המקורי
                .scaleY(0.9f) // מקטין את הכפתור ל-90% מהגובה המקורי
                .setDuration(100) // משך האנימציה ב-milliseconds
                .withEndAction(() -> {
                    view.animate()
                            .scaleX(1f) // מחזיר לגודל המקורי
                            .scaleY(1f)
                            .setDuration(100)
                            .start();
                })
                .start();
    }

    public void minplus(View view) {
        onbottonanimation(view);
       if(result.getText().toString().isEmpty())
           return;
       int currentVal;
       currentVal=Integer.parseInt(result.getText().toString());
       currentVal=-currentVal;
       result.setText(String.valueOf(currentVal));
    }
}