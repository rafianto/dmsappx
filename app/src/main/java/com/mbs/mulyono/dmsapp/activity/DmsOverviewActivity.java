package com.mbs.mulyono.dmsapp.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mbs.mulyono.dmsapp.R;
import com.mbs.mulyono.dmsapp.adapter.DmsOverviewAdapter;
import com.mbs.mulyono.dmsapp.base.BaseActivity;
import com.mbs.mulyono.dmsapp.base.BaseApplication;
import com.mbs.mulyono.dmsapp.model.DmsOverviewItem;
import com.mbs.mulyono.dmsapp.model.DmsOverviewResponse;
import com.mbs.mulyono.dmsapp.model.PrincipleItem;
import com.mbs.mulyono.dmsapp.observer.AppObserver;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DmsOverviewActivity extends BaseActivity implements Observer {
    //TextToSpeech t1;
    private BaseApplication baseApplication;

    private ListView lvDmsOverview;
    private ProgressBar pbIndicator;
    private String query;

    public static String KEY_PRINCIPAL = "principal";
    private PrincipleItem principleItem;
    private ArrayList<DmsOverviewItem> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dms_overview);

        baseApplication = (BaseApplication)getApplication();
        baseApplication.getAppObserver().addObserver(this);

        lvDmsOverview = (ListView) findViewById(R.id.lv_item);
        pbIndicator = (ProgressBar) findViewById(R.id.pb_indicator);

        principleItem = (PrincipleItem) getIntent().getSerializableExtra(DmsOverviewActivity.KEY_PRINCIPAL);

        Log.d("debug-doa : ",appPreference.getMode().toString().trim()+" id "+principleItem.priname);
        /*t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    t1.setLanguage(new Locale("id","ID"));
                }
            }
        });
        */

        handleIntent(getIntent());
        getSupportActionBar().setTitle("DMS OVERVIEW");
        getSupportActionBar().setSubtitle(principleItem.priname);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getDmsOverviewItemAsync(principleItem.princp);
    }

    // begin prosess search //
    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }
    private void handleIntent(Intent intent)  throws IllegalArgumentException {
        if (intent != null && intent.getAction() != null) {
            if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
                query = intent.getStringExtra(SearchManager.QUERY);
                new SearchData().execute();
            }
        }
    }
    // end off prosess search //
    private class SearchData extends AsyncTask<Void, Void, Void> {
        ProgressDialog mProgressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(DmsOverviewActivity.this);
            mProgressDialog.setTitle(getString(R.string.notify_searching));
            mProgressDialog.setMessage(getString(R.string.text_please_wait));
            mProgressDialog.show();
        }

        protected Void doInBackground(Void... params) {
            return null;
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            mProgressDialog.dismiss();
            getDmsOverviewItemSearchAsync(principleItem.princp,query);
        }
    }
    // End Result Search Query // ============================

    // ======================= SE ============================
    private void getDmsOverviewItemAsync(String principalId) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listItem != null) {
            listItem.clear();
        }
        String module = "B";
        String user = appPreference.getUsername();
        String passwd = appPreference.getPassword();
        //if (appPreference.getMode().toString().trim()=="Y") {
        //    t1.speak(principleItem.priname.toString().trim(), TextToSpeech.QUEUE_FLUSH, null);
        //}
        Call<DmsOverviewResponse> getDmsOverview = apiClient.GetDmsOverview(module, principalId, user, passwd);
        getDmsOverview.enqueue(new Callback<DmsOverviewResponse>() {
            @Override
            public void onResponse(Response<DmsOverviewResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                parsingDmsOverviewResponse(response);
            }
            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsOverviewItemSearchAsync(String principalId,String dmslike) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listItem != null) {
            listItem.clear();
        }
        String module = "G";
        String user = appPreference.getUsername();
        String passwd = appPreference.getPassword();
        Call<DmsOverviewResponse> getDmsOverview = apiClient.GetDmsOverviewSearch(module, principalId, dmslike, user, passwd);
        getDmsOverview.enqueue(new Callback<DmsOverviewResponse>() {
            @Override
            public void onResponse(Response<DmsOverviewResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                parsingDmsOverviewResponse(response);
            }
            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void parsingDmsOverviewResponse(Response<DmsOverviewResponse> response) {
        DmsOverviewResponse res = response.body();
        if (res.listItem.size() > 0) {
            listItem = res.listItem;
            final DmsOverviewAdapter adapter = new DmsOverviewAdapter(DmsOverviewActivity.this, listItem);
            lvDmsOverview.setAdapter(adapter);
            lvDmsOverview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                private int position;
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String dmsnox = listItem.get(position).dmsNo.toString();
                    Toast.makeText(DmsOverviewActivity.this, "Choice : "+dmsnox , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DmsOverviewActivity.this, DmsHeadDetailActivity.class);
                    intent.putExtra(DmsHeadDetailActivity.KEY_DATA,dmsnox);
                    startActivityForResult(intent, 0);
                }
            });
        } else {
            Toast.makeText(DmsOverviewActivity.this, "Data DMS not found", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    public static void toDmsOverviewActivity(Activity activity, PrincipleItem item) {
        Intent mIntent = new Intent(activity, DmsOverviewActivity.class);
        mIntent.putExtra(DmsOverviewActivity.KEY_PRINCIPAL, item);
        activity.startActivityForResult(mIntent, 0);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (data.equals(AppObserver.EVENT_PROSESS_CHANGED)){
            getDmsOverviewItemAsync(principleItem.princp);
        }
    }
}
