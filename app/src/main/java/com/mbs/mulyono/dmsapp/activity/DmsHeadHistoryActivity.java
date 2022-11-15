package com.mbs.mulyono.dmsapp.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mbs.mulyono.dmsapp.R;
import com.mbs.mulyono.dmsapp.adapter.MenuDetailAdapter;
import com.mbs.mulyono.dmsapp.base.BaseActivity;
import com.mbs.mulyono.dmsapp.base.BaseApplication;
import com.mbs.mulyono.dmsapp.model.DmsClActivityProsesOverviewResponse;
import com.mbs.mulyono.dmsapp.model.DmsXActivityProsesOverviewResponse;

import java.util.Observable;
import java.util.Observer;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DmsHeadHistoryActivity extends BaseActivity implements Observer {

    private BaseApplication baseApplication;

    public static String KEY_DATA = "dmsno";
    private String recievedData = null;

    private ListView lvItem;
    private FloatingActionButton fabapr;

    TextView tvnotetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_dms_head_detail);

        baseApplication = (BaseApplication)getApplication();
        baseApplication.getAppObserver().addObserver(this);

        recievedData = getIntent().getStringExtra(KEY_DATA);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setTitle(recievedData);
        getSupportActionBar().setSubtitle("History : Data Search ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvnotetext = (TextView)findViewById(R.id.tvnotetext);

        fabapr = (FloatingActionButton)findViewById(R.id.fabapproved);
        fabapr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(DmsHeadHistoryActivity.this, " History Only Overview ! ", Toast.LENGTH_LONG).show();
                AlertDialog alertOverviewProses = new AlertDialog.Builder(DmsHeadHistoryActivity.this).create();
                alertOverviewProses.setTitle("Prosses Closed DMS History/Back");
                alertOverviewProses.setMessage("Are You sure to Closed DMS No. " + recievedData + " ?, the contents of the note below , for reasons ! ");
                final EditText input = new EditText(DmsHeadHistoryActivity.this);
                alertOverviewProses.setView(input);
                alertOverviewProses.setButton2("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        String value = input.getText().toString();
                        tvnotetext.setText(value);
                        finish();
                    }
                });
                alertOverviewProses.setButton("Closed(Princ)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        String value = input.getText().toString();
                        tvnotetext.setText(value);
                        if (value.toString().equals("")) {
                            Toast.makeText(DmsHeadHistoryActivity.this, "Prosses Closed failled, please add notetext! ", Toast.LENGTH_SHORT).show();
                        } else {
                            ClosedDmsHistory();
                            Toast.makeText(DmsHeadHistoryActivity.this, "Prosses Closed Done! ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
                alertOverviewProses.show();
            }
        });

        //done
        lvItem = (ListView)findViewById(R.id.lv_item_detail);
        lvItem.setAdapter(new MenuDetailAdapter(DmsHeadHistoryActivity.this));
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String isuskup0 = "HeaderHistoryOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup0);
                        break;
                    case 1:
                        String isuskup1 = "CustGroupOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup1);
                        break;
                    case 2:
                        String isuskup2 = "CustChainOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup2);
                        break;
                    case 3:
                        String isuskup3 = "CustomerOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup3);
                        break;
                    case 4:
                        String isuskup4 = "ProductGroupOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup4);
                        break;
                    case 5:
                        String isuskup5 = "ProductOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup5);
                        break;
                    case 6:
                        String isuskup6 = "OrderOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup6);
                        break;
                    case 7:
                        String isuskup7 = "OrderValueOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup7);
                        break;
                    case 8:
                        String isuskup8 = "MixedBonusOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup8);
                        break;
                    case 9:
                        String isuskup9 = "MIxedPersenOverview";
                        //DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup9);
                        Toast.makeText(DmsHeadHistoryActivity.this, "Mixed % jarang di gunakan, under Development! ", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        String isuskup10 = "SignatureOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup10);
                        break;
                    case 11:
                        String isuskup11 = "HistoryOverview";
                        DmsHeadHistoryContentActivity.toDmsHeadHistoryContentActivity(DmsHeadHistoryActivity.this, recievedData, isuskup11);
                        break;
                    case 12:
                        //String isuskup12 = "PDFFilePrincipal";
                        //DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup11);
                        Toast.makeText(DmsHeadHistoryActivity.this, "PDF File for History under Development! ", Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                        break;
                }
            }
        });

    }

    // private bolean closed History DMS //
    private boolean ClosedDmsHistory() {
        String user = appPreference.getUsername();
        String passwd = appPreference.getPassword();
        String dmsnomor = recievedData;
        String gpslocat = "-";
        String notex = tvnotetext.getText().toString();
        String action = "ClossedByPrincipal";

        String selmodul = "B";
        Call<DmsClActivityProsesOverviewResponse> getDmsClAPOverview = apiClient.GetClActivityProsesOverviewContent(selmodul,user,passwd,dmsnomor,gpslocat,notex,action);
        getDmsClAPOverview.enqueue(new Callback<DmsClActivityProsesOverviewResponse>() {
            @Override
            public void onResponse(Response<DmsClActivityProsesOverviewResponse> response, Retrofit retrofit) {
                DmsClActivityProsesOverviewResponse res = response.body();
                if (res.status.equals(REQUEST_SUCCESS)) {
                    Toast.makeText(DmsHeadHistoryActivity.this, "Prosses Clossed.Succes.... " + res.status.toString().trim(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DmsHeadHistoryActivity.this, "-o-" + res.status.toString().trim(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // other
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void update(Observable observable, Object data) {
        baseApplication.getAppObserver().notifyProsessChanged();
    }

    @Override
    protected void onDestroy() {
        baseApplication.getAppObserver().deleteObserver(this);
        super.onDestroy();
    }

}
