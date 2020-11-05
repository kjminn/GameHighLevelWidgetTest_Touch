package kr.ac.ssu.gamehighlevelwidgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabActivity1 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        TabHost host = getTabHost();

        TabHost.TabSpec tabDog = host.newTabSpec("DOG").setIndicator("강아지");
        tabDog.setContent(R.id.linear_dog);
        host.addTab(tabDog);

        TabHost.TabSpec tabCat = host.newTabSpec("CAT").setIndicator("고양이");
        tabCat.setContent(R.id.linear_cat);
        host.addTab(tabCat);

        TabHost.TabSpec tabAng = host.newTabSpec("ANG").setIndicator("앵무새");
        tabAng.setContent(R.id.linear_ang);
        host.addTab(tabAng);
        host.setCurrentTab(0);

    }
}