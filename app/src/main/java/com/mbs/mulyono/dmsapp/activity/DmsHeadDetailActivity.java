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
import com.mbs.mulyono.dmsapp.adapter.DmsOverviewAdapter;
import com.mbs.mulyono.dmsapp.adapter.MenuDetailAdapter;
import com.mbs.mulyono.dmsapp.base.BaseActivity;
import com.mbs.mulyono.dmsapp.base.BaseApplication;
import com.mbs.mulyono.dmsapp.model.DmsOverviewResponse;
import com.mbs.mulyono.dmsapp.model.DmsXActivityProsesOverviewItem;
import com.mbs.mulyono.dmsapp.model.DmsXActivityProsesOverviewResponse;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DmsHeadDetailActivity extends BaseActivity implements Observer {

    private BaseApplication baseApplication;

    public static String KEY_DATA = "dmsno";
    private String recievedData = null;
    private ArrayList<DmsXActivityProsesOverviewItem> listXActivityOverviewItem;

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
        getSupportActionBar().setSubtitle("Overview : Approved/Sent/Canceled");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvnotetext = (TextView)findViewById(R.id.tvnotetext);

        fabapr = (FloatingActionButton)findViewById(R.id.fabapproved);
        fabapr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog alertOverviewProses = new AlertDialog.Builder(DmsHeadDetailActivity.this).create();
                alertOverviewProses.setTitle("Prosses Approved-Sent/Cancel By Kpst");
                alertOverviewProses.setMessage("Are You sure to Prosses DMS No. " + recievedData + " ?, the contents of the note below , for reasons ! ");
                final EditText input = new EditText(DmsHeadDetailActivity.this);
                alertOverviewProses.setView(input);
                alertOverviewProses.setButton3("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        finish();
                    }
                });
                alertOverviewProses.setButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        String value = input.getText().toString();
                        tvnotetext.setText(value);
                        //if (value.toString().equals("")) {
                        //    Toast.makeText(DmsHeadDetailActivity.this, "Prosses Cancelled{Kpst) failled, please add notetext ! ", Toast.LENGTH_SHORT).show();
                        //} else {
                            cancelldmsOverview();
                            finish();
                        //} t
                    }
                });
                alertOverviewProses.setButton2("Approved(Sent)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String value = input.getText().toString();
                        tvnotetext.setText(value);
                        //if (value.toString().equals("")) {
                        //    Toast.makeText(DmsHeadDetailActivity.this, "Prosses Approved(Sent) failled, please add notetext ! ", Toast.LENGTH_SHORT).show();
                        //} else {
                            approveddmsOverview();
                            finish();
                        //}
                    }
                });
                alertOverviewProses.show();
            }
        });

        lvItem = (ListView)findViewById(R.id.lv_item_detail);
        lvItem.setAdapter(new MenuDetailAdapter(DmsHeadDetailActivity.this));
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String isuskup0 = "HeaderOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup0);
                        break;
                    case 1:
                        String isuskup1 = "CustGroupOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup1);
                        break;
                    case 2:
                        String isuskup2 = "CustChainOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup2);
                        break;
                    case 3:
                        String isuskup3 = "CustomerOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup3);
                        break;
                    case 4:
                        String isuskup4 = "ProductGroupOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup4);
                        break;
                    case 5:
                        String isuskup5 = "ProductOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup5);
                        break;
                    case 6:
                        String isuskup6 = "OrderOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup6);
                        break;
                    case 7:
                        String isuskup7 = "OrderValueOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup7);
                        break;
                    case 8:
                        String isuskup8 = "MixedBonusOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup8);
                        break;
                    case 9:
                        String isuskup9 = "MixedPersenOverview";
                        //DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup9);
                        Toast.makeText(DmsHeadDetailActivity.this, "Mixed % jarang di gunakan, under Development! ", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        String isuskup10 = "SignatureOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup10);
                        break;
                    case 11:
                        String isuskup11 = "HistoryOverview";
                        DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup11);
                        break;
                    case 12:
                        String isuskup12 = "PDFFileOverview";
                        //DmsHeadDetailContentActivity.toDmsHeadDetailContentActivity(DmsHeadDetailActivity.this,recievedData, isuskup12);
                        Toast.makeText(DmsHeadDetailActivity.this, "PDF File for Overview under Development! ", Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                        break;
                    case 14:
                        break;

                }
            }
        });

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

    // PROSSES BY KPST TASK //
    private boolean approveddmsOverview() {
        String user = appPreference.getUsername();
        String passwd = appPreference.getPassword();
        String dmsnomor = recievedData;
        String gpslocat = "-";
        String notex = tvnotetext.getText().toString();
        String action = "ApprovedByKpst";

        String selmodul = "A";
        Call<DmsXActivityProsesOverviewResponse> getDmsXAPOverview = apiClient.GetXActivityProsesOverviewContent(selmodul,user,passwd,dmsnomor,gpslocat,notex,action);
        getDmsXAPOverview.enqueue(new Callback<DmsXActivityProsesOverviewResponse>() {
            @Override
            public void onResponse(Response<DmsXActivityProsesOverviewResponse> response, Retrofit retrofit) {
                DmsXActivityProsesOverviewResponse res = response.body();
                if (res.status.equals(REQUEST_SUCCESS)) {
                    Toast.makeText(DmsHeadDetailActivity.this, "Prosses Approved.Succes.... " + res.status.toString().trim(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DmsHeadDetailActivity.this, "-o-" + res.status.toString().trim(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // other
            }
        });
        return true;
    }

    private boolean cancelldmsOverview() {
        String user = appPreference.getUsername();
        String passwd = appPreference.getPassword();
        String dmsnomor = recievedData;
        String gpslocat = "-";
        String notex = tvnotetext.getText().toString();
        String action = "CancelledByKpst";

        String selmodul = "A";
        Call<DmsXActivityProsesOverviewResponse> getDmsXAPOverview = apiClient.GetXActivityProsesOverviewContent(selmodul,user,passwd,dmsnomor,gpslocat,notex,action);
        getDmsXAPOverview.enqueue(new Callback<DmsXActivityProsesOverviewResponse>() {
            @Override
            public void onResponse(Response<DmsXActivityProsesOverviewResponse> response, Retrofit retrofit) {
                DmsXActivityProsesOverviewResponse res = response.body();
                if (res.status.equals(REQUEST_SUCCESS)) {
                    Toast.makeText(DmsHeadDetailActivity.this, "Proses Cancelled.Succes.... " + res.status.toString().trim(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DmsHeadDetailActivity.this, "Proses Cancelled.Succes.... " + res.status.toString().trim(), Toast.LENGTH_LONG).show();
                }
            }

            public void onFailure(Throwable t) {
                // other
            }
        });
        return true;
    }

}
