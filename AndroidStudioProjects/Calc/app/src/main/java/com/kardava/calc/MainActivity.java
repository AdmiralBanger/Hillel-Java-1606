package com.kardava.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
	{
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void doCalc(View view)
    {
        EditText aNum = (EditText) findViewById(R.id.aField);
        EditText opNum = (EditText) findViewById(R.id.opField);
        EditText bNum = (EditText) findViewById(R.id.bField);
        EditText out = (EditText) findViewById(R.id.output);

        int a = Integer.parseInt(aNum.getText().toString());
        char op = opNum.getText().toString().charAt(0);
        int b = Integer.parseInt(bNum.getText().toString());

        out.setText(Integer.toString(calculate(a, b, op)));
    }

    private int calculate(int a, int b, char op)
    {
        int res = 0;
		
        switch (op)
        {
            case '+': res = a + b; break;
            case '-': res = a - b; break;
            case '*': res = a * b; break;
            case '/': res = a / b; break;
        }

        return res;
    }
}
