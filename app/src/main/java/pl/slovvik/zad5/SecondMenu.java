package pl.slovvik.zad5;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class SecondMenu extends AppCompatActivity {

    private TextView one;
    private TextView two;
    private TextView three;
    private ActionMode actionMode;

    boolean[] checkable = {false, false, false};
    private ActionMode.Callback mActionModeCallback  = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            menu.add(Menu.NONE, 1, 1, "One");
            menu.add(Menu.NONE, 2, 2, "Two");
            menu.add(Menu.NONE, 3, 3, "Three");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case 1:
                    three.setText("One");
                    mode.finish();
                    return true;
                case 2:
                    three.setText("Two");
                    mode.finish();
                    return true;
                case 3:
                    three.setText("Three");
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_menu);


        one = (TextView) findViewById(R.id.oneSecond);
        two = (TextView) findViewById(R.id.twoSecond);
        three = (TextView) findViewById(R.id.threeSecond);

        registerForContextMenu(one);

        three.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                if (actionMode != null) return false;
                actionMode = startActionMode(mActionModeCallback);
                v.setSelected(true);
                return true;
            }


        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        TextView one = (TextView) v;
        if (one == this.one) {
            menu.setHeaderTitle("Options");
            menu.setHeaderIcon(R.drawable.red);
            menu.add(1, 1, 1, "Background RED").setCheckable(true).setChecked(checkable[0]);
            menu.add(1, 2, 2, "Text color BLUE").setCheckable(true).setChecked(checkable[1]);
            menu.add(1, 3, 3, "Letter spacing 0.50").setCheckable(true).setChecked(checkable[2]);
//            menu.setGroupCheckable(1, true, false);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                one.setBackgroundColor(Color.RED);
                checkable[0] = true;
                item.setChecked(checkable[0]);
                return true;
            case 2:
                one.setTextColor(Color.BLUE);
                checkable[1] = true;
                item.setChecked(checkable[1]);
                return true;
            case 3:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    one.setLetterSpacing((float) 0.5);
                }
                checkable[2] = true;
                item.setChecked(checkable[2]);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, 1, "Background RED");
        menu.add(Menu.NONE, 2, 2, "Background BLUE");
        menu.add(Menu.NONE, 3, 3, "Background GREEN");
        SubMenu subMenu = menu.addSubMenu("Different options");
        subMenu.add(Menu.NONE, 4, 4, "Letter spacing 0.25").setIcon(R.drawable.red);
        subMenu.add(Menu.NONE, 5, 5, "Letter spacing 0.50").setIcon(R.drawable.green);
        subMenu.add(Menu.NONE, 6, 6, "Letter spacing 0.75").setIcon(R.drawable.blue);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                one.setBackgroundColor(Color.RED);
                two.setBackgroundColor(Color.RED);
                return true;
            case 2:
                one.setBackgroundColor(Color.BLUE);
                two.setBackgroundColor(Color.BLUE);
                return true;
            case 3:
                one.setBackgroundColor(Color.GREEN);
                two.setBackgroundColor(Color.GREEN);
                return true;
            case 4:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    one.setLetterSpacing((float) 0.25);
                    two.setLetterSpacing((float) 0.25);
                }
                return true;
            case 5:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    one.setLetterSpacing((float) 0.5);
                    two.setLetterSpacing((float) 0.5);
                }
                return true;
            case 6:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    one.setLetterSpacing((float) 0.75);
                    two.setLetterSpacing((float) 0.75);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
