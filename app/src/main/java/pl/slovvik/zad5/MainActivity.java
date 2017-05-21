package pl.slovvik.zad5;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static pl.slovvik.zad5.Numbers.ONE;
import static pl.slovvik.zad5.Numbers.TWO;

public class MainActivity extends AppCompatActivity {

    private TextView one;
    private TextView two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (TextView) findViewById(R.id.textOne);
        two = (TextView) findViewById(R.id.textTwo);
        registerForContextMenu(one);
        registerForContextMenu(two);
    }

    public void secondMenu(View view) {
        Intent intent = new Intent(this, SecondMenu.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_one, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        TextView one = (TextView) v;
        if (one == this.one) {
            inflater.inflate(R.menu.menu_context_atr_one, menu);
        } else {
            inflater.inflate(R.menu.menu_context_atr_two, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.textREDContextMenu:
                setRedText(ONE);
                return true;
            case R.id.textBLUEContextMenu:
                setBlueText(ONE);
                return true;
            case R.id.textGREENContextMenu:
                setGreenText(ONE);
                return true;
            case R.id.textSizeSmallContextMenu:
                setTextSmall(ONE);
                return true;
            case R.id.textSizeMediumContextMenu:
                setTextMedium(ONE);
                return true;
            case R.id.textSizeLargeContextMenu:
                setTextLarge(ONE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.textRED:
                setRedText(TWO);
                return true;
            case R.id.textBLUE:
                setBlueText(TWO);
                return true;
            case R.id.textGREEN:
                setGreenText(TWO);
                return true;
            case R.id.textSizeSmall:
                setTextSmall(TWO);
                return true;
            case R.id.textSizeMedium:
                setTextMedium(TWO);
                return true;
            case R.id.textSizeLarge:
                setTextLarge(TWO);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setTextLarge(Numbers number) {
        if (number == ONE) two.setTextSize(COMPLEX_UNIT_SP, 30);
        else {
            one.setTextSize(COMPLEX_UNIT_SP, 30);
            two.setTextSize(COMPLEX_UNIT_SP, 30);
        }

    }

    private void setTextMedium(Numbers number) {
        if (number == ONE) two.setTextSize(COMPLEX_UNIT_SP, 30);
        else {
            one.setTextSize(COMPLEX_UNIT_SP, 14);
            two.setTextSize(COMPLEX_UNIT_SP, 14);
        }
    }

    private void setTextSmall(Numbers number) {
        if (number == ONE) two.setTextSize(COMPLEX_UNIT_SP, 30);
        else {
            one.setTextSize(COMPLEX_UNIT_SP, 8);
            two.setTextSize(COMPLEX_UNIT_SP, 8);
        }
    }


    private void setRedText(Numbers number) {
        if (number == ONE) one.setTextColor(Color.RED);
        else {
            one.setTextColor(Color.RED);
            two.setTextColor(Color.RED);
        }
    }

    private void setGreenText(Numbers number) {
        if (number == ONE) one.setTextColor(Color.GREEN);
        else {
            one.setTextColor(Color.GREEN);
            two.setTextColor(Color.GREEN);
        }
    }

    private void setBlueText(Numbers number) {
        if (number == ONE) one.setTextColor(Color.BLUE);
        else {
            one.setTextColor(Color.BLUE);
            two.setTextColor(Color.BLUE);
        }
    }
}
