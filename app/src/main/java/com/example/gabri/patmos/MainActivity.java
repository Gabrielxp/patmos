package com.example.gabri.patmos;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity implements
		TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

	private TabHost mTabHost;
	private ViewPager mViewPager;
	private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, TabInfo>();
	private PagerAdapter mPagerAdapter;

	// Informa��o da Tab
	private class TabInfo {
		private String tag;
		private Class<?> clss;
		private Bundle args;
		private Fragment fragment;

		TabInfo(String tag, Class<?> clazz, Bundle args) {
			this.tag = tag;
			this.clss = clazz;
			this.args = args;
		}
	}

	// Um simples factory que retorna View para o TabHost
	class TabFactory implements TabContentFactory {

		private final Context mContext;

		public TabFactory(Context context) {
			mContext = context;
		}

		public View createTabContent(String tag) {
			View v = new View(mContext);
			v.setMinimumWidth(0);
			v.setMinimumHeight(0);
			return v;
		}

	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Infla o layout
		setContentView(R.layout.activity_main);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("Patmos Web Rádio");
		// Inicializa o TabHost
		this.initialiseTabHost(savedInstanceState);
		if (savedInstanceState != null) {
			// Define a Tab de acordo com o estado salvo
			mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}
		// Inicializa o ViewPager
		this.intialiseViewPager();

		SharedPreferences sharedPreferences = getSharedPreferences("IS_LOGADO", Context.MODE_PRIVATE);

		Toast.makeText(this, sharedPreferences.getString("email", ""), Toast.LENGTH_SHORT).show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Infla o menu com os botões da action bar
		getMenuInflater().inflate(R.menu.menu_main, menu);

		// Sair
		MenuItem item = menu.findItem(R.id.action_sair);

		item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem menuItem) {

				SharedPreferences.Editor editor;
				SharedPreferences sharedPreferences;

				sharedPreferences = getSharedPreferences("IS_LOGADO", Context.MODE_PRIVATE);

				editor = sharedPreferences.edit();

				editor.putString("email", "");

				editor.apply();

				finish();

				return false;
			}
		});


		return true;
	}

	protected void onSaveInstanceState(Bundle outState) {
		// salva a Tab selecionada
		outState.putString("tab", mTabHost.getCurrentTabTag());
		super.onSaveInstanceState(outState);
	}

	private void intialiseViewPager() {

		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, Principal_Fragment.class.getName()));
		fragments.add(Fragment.instantiate(this, Programacao_Fragment.class.getName()));


		this.mPagerAdapter = new ViewPagerAdapter(
				super.getSupportFragmentManager(), fragments);
		this.mViewPager = (ViewPager) super.findViewById(R.id.viewpager);
		this.mViewPager.setAdapter(this.mPagerAdapter);
		this.mViewPager.setOnPageChangeListener(this);
	}

	private void initialiseTabHost(Bundle args) {
		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
		TabInfo tabInfo = null;
		MainActivity.AddTab(this, this.mTabHost,
				this.mTabHost.newTabSpec("Principal").setIndicator("Principal"),
				(tabInfo = new TabInfo("Principal", Principal_Fragment.class, args)));
		this.mapTabInfo.put(tabInfo.tag, tabInfo);

		MainActivity.AddTab(this, this.mTabHost,
				this.mTabHost.newTabSpec("Programação").setIndicator("Programação"),
				(tabInfo = new TabInfo("Programação", Programacao_Fragment.class, args)));
		this.mapTabInfo.put(tabInfo.tag, tabInfo);

	}

	private static void AddTab(MainActivity activity, TabHost tabHost,
                               TabHost.TabSpec tabSpec, TabInfo tabInfo) {
		// Attach uma Tab view factory para o spec
		tabSpec.setContent(activity.new TabFactory(activity));
		tabHost.addTab(tabSpec);
	}

	public void onTabChanged(String tag) {
		// Avisa para o mViewPager qual a Tab que est� ativa
		int pos = this.mTabHost.getCurrentTab();
		this.mViewPager.setCurrentItem(pos);
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int position) {
		this.mTabHost.setCurrentTab(position);
		Toast.makeText(this,"Teste", Toast.LENGTH_LONG);
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

}
