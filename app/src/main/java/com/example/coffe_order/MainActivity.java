package com.example.coffe_order;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quant = 0;
    String massage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void quantity(View view){
        int sum = 0;
        TextView quantityTextView = (TextView) findViewById(R.id.sum);
        if (onCheck(quantityTextView) && onCheckchocolate(quantityTextView)) sum = (quant * 5) + (quant * 2) + quant;
        if (onCheck(quantityTextView) && !onCheckchocolate(quantityTextView)) sum = (quant * 5) + quant;
        if (onCheckchocolate(quantityTextView) && !onCheck(quantityTextView)) sum = (quant * 5) + (quant * 2);
        if (!onCheck(quantityTextView) && !onCheckchocolate(quantityTextView)) sum = quant * 5;
        summa(sum);
            }

    public void minus(View view){
        if(quant==1) {
            display(1);
            Toast.makeText(this,"Нельзя заказать меньше 1 чашки", Toast.LENGTH_SHORT).show();
        }
        else {
            quant--;
            display(quant);
        }
    }
    public void plus(View view){
        if(quant ==10 ){
            display(10);
            Toast.makeText(this,"Нельзя заказать больше 10 чашек", Toast.LENGTH_SHORT).show();
        }
        else {
            quant++;
            display(quant);
        }
    }
    public boolean onCheck(View view){
        CheckBox checkBox = findViewById(R.id.notify_me_checkbox);
        boolean isCheckBox = checkBox.isChecked();
        return isCheckBox;
    }
    public boolean onCheckchocolate(View view){
        CheckBox checkBox = findViewById(R.id.chocolate);
        boolean isCheckBox = checkBox.isChecked();
        return isCheckBox;
    }
    public String name(View view){
        EditText nameEditText = findViewById(R.id.album_description_view);
        String result = ""+ nameEditText.getText();
        return result;
    }

    @SuppressLint("SetTextI18n")
    public void summa(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.sum);
        if (onCheck(quantityTextView) || onCheckchocolate(quantityTextView)){
            quantityTextView.setText(getString(R.string.Dear) + " " + name(quantityTextView) + "\n" + getString(R.string.thx) + "\n" + getString(R.string.topping1) + "\n" + getString(R.string.cost) + number);
        massage = getString(R.string.Dear) + " " + name(quantityTextView) + "\n" + getString(R.string.thx) + "\n" + getString(R.string.topping1) + "\n" + getString(R.string.cost) + number;}
        if (onCheck(quantityTextView) && onCheckchocolate(quantityTextView)){
            quantityTextView.setText(getString(R.string.Dear) + " " + name(quantityTextView) + "\n" + getString(R.string.thx) + "\n" + getString(R.string.topping2) + "\n" + getString(R.string.cost) + number);
        massage = getString(R.string.Dear) + " " + name(quantityTextView) + "\n" + getString(R.string.thx) + "\n" + getString(R.string.topping2) + "\n" + getString(R.string.cost) + number;}
        if (!onCheck(quantityTextView) && !onCheckchocolate(quantityTextView)){
            quantityTextView.setText(getString(R.string.Dear) + " " + name(quantityTextView) + "\n" + getString(R.string.thx) + "\n" + getString(R.string.dontTakeTopping) + "\n" + getString(R.string.cost) + number);
        massage = getString(R.string.Dear) + " " + name(quantityTextView) + "\n" + getString(R.string.thx) + "\n" + getString(R.string.dontTakeTopping) + "\n" + getString(R.string.cost) + number;}
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "denisxomaxd@mail.ru"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "кофе 1");
        intent.putExtra(Intent.EXTRA_TEXT, massage);
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }
}
