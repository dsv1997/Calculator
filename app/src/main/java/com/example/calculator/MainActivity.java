/*
 created by Deepak singh verma
 date:19/3/2019

*/
package com.example.calculator;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     private TextView e1,e2;
    private Double result;
    private int  count=0;
    private String expression="";
    private String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.t1);
        e2=findViewById(R.id.t2);
     findViewById(R.id.num0).setOnClickListener(this);
     findViewById(R.id.num1).setOnClickListener(this);
        findViewById(R.id.num2).setOnClickListener(this);
        findViewById(R.id.num3).setOnClickListener(this);
        findViewById(R.id.num4).setOnClickListener(this);
        findViewById(R.id.num5).setOnClickListener(this);
        findViewById(R.id.num6).setOnClickListener(this);
        findViewById(R.id.num7).setOnClickListener(this);
        findViewById(R.id.num8).setOnClickListener(this);
        findViewById(R.id.num9).setOnClickListener(this);
        findViewById(R.id.dot).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);
        findViewById(R.id.multipy).setOnClickListener(this);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.del).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
          switch (v.getId()) {
              case R.id.num0:
                  e2.setText(e2.getText() + "0");
                  break;

              case R.id.num1:
                  e2.setText(e2.getText() + "1");
                  break;

              case R.id.num2:
                  e2.setText(e2.getText() + "2");
                  break;

              case R.id.num3:
                  e2.setText(e2.getText() + "3");
                  break;


              case R.id.num4:
                  e2.setText(e2.getText() + "4");
                  break;

              case R.id.num5:
                  e2.setText(e2.getText() + "5");
                  break;

              case R.id.num6:
                  e2.setText(e2.getText() + "6");
                  break;

              case R.id.num7:
                  e2.setText(e2.getText() + "7");
                  break;

              case R.id.num8:
                  e2.setText(e2.getText() + "8");
                  break;

              case R.id.num9:
                  e2.setText(e2.getText() + "9");
                  break;

              case R.id.dot:
                  if (count == 0 && e2.length() != 0) {
                      e2.setText(e2.getText() + ".");
                      count++;
                  }
                  break;

              case R.id.del:
                  e1.setText("");
                  e2.setText("");
                  count = 0;
                  expression = "";
                  break;
              case R.id.plus:
                  operationClicked("+");
                  break;

              case R.id.minus:
                  operationClicked("-");
                  break;

              case R.id.divide:
                  operationClicked("/");
                  break;

              case R.id.multipy:
                  operationClicked("*");
                  break;
              case R.id.equal:
                 if(e2.length()!=0)
                  {
                      s=e2.getText().toString();
                      expression=e1.getText().toString()+s;
                  }
                  e1.setText("");
                  if(expression.length()==0)
                      expression="0.0";
                  DoubleEvaluator evaluator = new DoubleEvaluator();
                  try
                  {
                      //evaluate the expression
                      result=evaluator.evaluate(expression);
                      //insert expression and result in sqlite database if expression is valid and not 0.0
                      e2.setText(result+"");
                  }
                  catch (Exception e)
                  {
                      e2.setText("Invalid Expression");
                      e1.setText("");
                      expression="";
                      e.printStackTrace();
                  }
                  break;
          }
    }
    private void operationClicked(String op)
    {
        if(e2.length()!=0)
        {
            String text=e2.getText().toString();
            e1.setText(e1.getText() + text+op);
            e2.setText("");
            count=0;
        }
        else
        {
            String text=e1.getText().toString();
            if(text.length()>0)
            {
                String newText=text.substring(0,text.length()-1)+op;
                e1.setText(newText);
            }
        }
    }
}
