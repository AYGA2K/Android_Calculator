package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private TextView textView;
  private String input = "";
  private double num1 = 0;
  private double num2 = 0;
  private String operator = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = findViewById(R.id.textView);

  }

  public void numberClick(View view) {
    Button button = (Button) view;
    input += button.getText().toString();
    System.out.println(input);
    textView.setText(input);
  }

  public void operatorClick(View view) {
    Button button = (Button) view;
    if (!input.isEmpty()) {
      num1 = Double.parseDouble(input);
      operator = button.getText().toString();
      input = "";
      textView.setText(input);
    }
  }

  public void equalClick(View view) {
    if (!input.isEmpty()) {
      num2 = Double.parseDouble(input);
      double result = 0;
      if (operator.equals("+")) {
        result = num1 + num2;
      } else if (operator.equals("-")) {
        result = num1 - num2;
      } else if (operator.equals("*")) {
        result = num1 * num2;
      } else if (operator.equals("/")) {
        result = num1 / num2;
      }

      textView.setText(String.valueOf(result));
      input = String.valueOf(result);
    }
  }

  public void clearClick(View view) {
    input = "";
    num1 = 0;
    num2 = 0;
    operator = "";
    textView.setText("");
  }
}
