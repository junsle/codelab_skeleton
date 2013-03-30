
package org.gdg.korea.android.codelab;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import net.simonvt.menudrawer.MenuDrawer;
import org.gdg.korea.android.oscl1.R;

public class MainActivity extends SherlockFragmentActivity {
    private MenuDrawer mDrawer;
    static final String[] FRUITS = new String[]{"Apple", "Avocado", "Banana",
            "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
            "Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple"};

    private ListView mDrawerLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mDrawer = MenuDrawer.attach(this);
        mDrawer.setContentView(R.layout.activity_main);
        mDrawer.setMenuView(R.layout.drawer_listview);
        mDrawerLv = (ListView) mDrawer.findViewById(R.id.lv_drawer);
        mDrawerLv.setBackgroundColor(Color.WHITE);
        mDrawerLv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, FRUITS));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawer.toggleMenu();
        }
        return super.onOptionsItemSelected(item);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {

        getSupportMenuInflater().inflate(R.menu.main, menu);

        menu.add("search")
                .setIcon(R.drawable.ic_launcher)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        menu.add("Settings")
                .setIcon(R.drawable.ic_launcher)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);    //To change body of overridden methods use File | Settings | File Templates.
    }


}//end of class
