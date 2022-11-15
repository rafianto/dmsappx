package com.mbs.mulyono.dmsapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mbs.mulyono.dmsapp.R;
import com.mbs.mulyono.dmsapp.adapter.DmsCustomerAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsCustomerChainAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsCustomerGroupAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsDetHistoryAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsMixedBonusAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsOrderAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsOrderValueAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsOverviewAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsProductAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsProductGroupAdapter;
import com.mbs.mulyono.dmsapp.adapter.DmsSignatureAdapter;
import com.mbs.mulyono.dmsapp.base.BaseActivity;
import com.mbs.mulyono.dmsapp.base.BaseApplication;
import com.mbs.mulyono.dmsapp.model.DmsCustomerChainItem;
import com.mbs.mulyono.dmsapp.model.DmsCustomerChainResponse;
import com.mbs.mulyono.dmsapp.model.DmsCustomerGroupItem;
import com.mbs.mulyono.dmsapp.model.DmsCustomerGroupResponse;
import com.mbs.mulyono.dmsapp.model.DmsCustomerItem;
import com.mbs.mulyono.dmsapp.model.DmsCustomerResponse;
import com.mbs.mulyono.dmsapp.model.DmsDetHistoryItem;
import com.mbs.mulyono.dmsapp.model.DmsDetHistoryResponse;
import com.mbs.mulyono.dmsapp.model.DmsMixedBonusItem;
import com.mbs.mulyono.dmsapp.model.DmsMixedBonusResponse;
import com.mbs.mulyono.dmsapp.model.DmsOrderItem;
import com.mbs.mulyono.dmsapp.model.DmsOrderResponse;
import com.mbs.mulyono.dmsapp.model.DmsOrderValueItem;
import com.mbs.mulyono.dmsapp.model.DmsOrderValueResponse;
import com.mbs.mulyono.dmsapp.model.DmsOverviewItem;
import com.mbs.mulyono.dmsapp.model.DmsOverviewResponse;
import com.mbs.mulyono.dmsapp.model.DmsProductGroupItem;
import com.mbs.mulyono.dmsapp.model.DmsProductGroupResponse;
import com.mbs.mulyono.dmsapp.model.DmsProductItem;
import com.mbs.mulyono.dmsapp.model.DmsProductResponse;
import com.mbs.mulyono.dmsapp.model.DmsSignatureItem;
import com.mbs.mulyono.dmsapp.model.DmsSignatureResponse;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DmsHeadHistoryContentActivity extends BaseActivity {
    private BaseApplication baseApplication;

    private ListView lvDmsOverview;
    private ProgressBar pbIndicator;

    public static String KEY_DMSNO = "dmsno";
    public static String KEY_SCOPE = "schope";

    private String recievedData = null;
    private String recievedSkup = null;

    private ArrayList<DmsOverviewItem> listItem;
    private ArrayList<DmsCustomerItem> listCustomerItem;
    private ArrayList<DmsProductItem> listProdusctItem;
    private ArrayList<DmsOrderItem> listOrderItem;
    private ArrayList<DmsOrderValueItem> listOrderValueItem;
    private ArrayList<DmsSignatureItem> listSignatureItem;
    private ArrayList<DmsDetHistoryItem> listDetHistoryItem;
    private ArrayList<DmsCustomerGroupItem> listCustomerGrpItem;
    private ArrayList<DmsProductGroupItem> listProductGroupItem;
    private ArrayList<DmsCustomerChainItem> listCustomerChainItem;
    private ArrayList<DmsMixedBonusItem> listMixedBonusItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_dms_detail_header_item);

        lvDmsOverview = (ListView) findViewById(R.id.lv_item);
        pbIndicator = (ProgressBar) findViewById(R.id.pb_indicator);

        recievedData = getIntent().getStringExtra(KEY_DMSNO);
        recievedSkup = getIntent().getStringExtra(KEY_SCOPE);

        getSupportActionBar().setTitle("History : "+recievedSkup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle(recievedData);

        if (recievedSkup.toString().trim().equals("HeaderHistoryOverview")) {
            getDmsHistoryHeaderItemAsync(recievedData, recievedSkup);
        } else {
            if (recievedSkup.toString().trim().equals("CustomerOverview")) {
                getDmsHistoryCustomerItemAsync(recievedData, recievedSkup);
            } else {
                if (recievedSkup.toString().trim().equals("ProductOverview")) {
                    getDmsHistoryProductItemAsync(recievedData, recievedSkup);
                } else {
                    if (recievedSkup.toString().trim().equals("OrderOverview")) {
                        getDmsHistoryOrderItemAsync(recievedData, recievedSkup);
                    } else {
                        if (recievedSkup.toString().trim().equals("OrderValueOverview")) {
                            getDmsHistoryOrderValueItemAsync(recievedData, recievedSkup);
                        } else {
                            if (recievedSkup.toString().trim().equals("SignatureOverview")) {
                                getDmsHistorySignatureItemAsync(recievedData, recievedSkup);
                            } else {
                                if (recievedSkup.toString().trim().equals("HistoryOverview")) {
                                    getDmsHistoryHistoryItemAsync(recievedData, recievedSkup);
                                } else {
                                    if (recievedSkup.toString().trim().equals("CustGroupOverview")) {
                                        getDmsHistoryCustomerGrpItemAsync(recievedData, recievedSkup);
                                    } else {
                                        if (recievedSkup.toString().trim().equals("ProductGroupOverview")) {
                                            getDmsHistoryProductGrpItemAsync(recievedData, recievedSkup);
                                        } else {
                                            if (recievedSkup.toString().trim().equals("CustChainOverview")) {
                                                getDmsHistoryCustomerChainItemAsync(recievedData, recievedSkup);
                                            } else {
                                                if (recievedSkup.toString().trim().equals("MixedBonusOverview")) {
                                                    getDmsHistoryMixedBonusItemAsync(recievedData, recievedSkup);
                                                } else {
                                                    Toast.makeText(DmsHeadHistoryContentActivity.this, "meneng wae ..." + recievedData + " " + recievedSkup, Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void getDmsHistoryHeaderItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listItem != null) {
            listItem.clear();
        }
        String selmodul = "E";
        Call<DmsOverviewResponse> getDmsOverview = apiClient.GetDmsDetailContent(selmodul, dmslike, dmsisue);
        getDmsOverview.enqueue(new Callback<DmsOverviewResponse>() {
            @Override
            public void onResponse(Response<DmsOverviewResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsOverviewResponse res = response.body();
                if (res.listItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listItem = res.listItem;
                    DmsOverviewAdapter adapter = new DmsOverviewAdapter(DmsHeadHistoryContentActivity.this, listItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Haeader not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistoryCustomerGrpItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listCustomerGrpItem != null) {
            listCustomerGrpItem.clear();
        }
        String selmodul = "E";
        Call<DmsCustomerGroupResponse> getDmsCustomerGrp = apiClient.GetDmsDetailCustomerGroupContent(selmodul, dmslike, dmsisue);
        getDmsCustomerGrp.enqueue(new Callback<DmsCustomerGroupResponse>() {
            @Override
            public void onResponse(Response<DmsCustomerGroupResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsCustomerGroupResponse res = response.body();
                if (res.listCustomerGroupItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listCustomerGrpItem = res.listCustomerGroupItem;
                    DmsCustomerGroupAdapter adapter = new DmsCustomerGroupAdapter(DmsHeadHistoryContentActivity.this, listCustomerGrpItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Customer Group not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistoryCustomerChainItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listCustomerChainItem != null) {
            listCustomerChainItem.clear();
        }
        String selmodul = "E";
        Call<DmsCustomerChainResponse> getDmsCustomerChain = apiClient.GetDmsDetailCustomerChianContent(selmodul, dmslike, dmsisue);
        getDmsCustomerChain.enqueue(new Callback<DmsCustomerChainResponse>() {
            @Override
            public void onResponse(Response<DmsCustomerChainResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsCustomerChainResponse res = response.body();
                if (res.listCustomerChainItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listCustomerChainItem = res.listCustomerChainItem;
                    DmsCustomerChainAdapter adapter = new DmsCustomerChainAdapter(DmsHeadHistoryContentActivity.this, listCustomerChainItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Customer Chains not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistoryCustomerItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listCustomerItem != null) {
            listCustomerItem.clear();
        }
        String selmodul = "E";
        Call<DmsCustomerResponse> getDmsCustomer = apiClient.GetDmsDetailCustomerContent(selmodul, dmslike, dmsisue);
        getDmsCustomer.enqueue(new Callback<DmsCustomerResponse>() {
            @Override
            public void onResponse(Response<DmsCustomerResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsCustomerResponse res = response.body();
                if (res.listCustomerItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listCustomerItem = res.listCustomerItem;
                    DmsCustomerAdapter adapter = new DmsCustomerAdapter(DmsHeadHistoryContentActivity.this, listCustomerItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Customer not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistoryProductGrpItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listProductGroupItem != null) {
            listProductGroupItem.clear();
        }
        String selmodul = "E";
        Call<DmsProductGroupResponse> getDmsProductGrp = apiClient.GetDmsDetailProductGroupContent(selmodul, dmslike, dmsisue);
        getDmsProductGrp.enqueue(new Callback<DmsProductGroupResponse>() {
            @Override
            public void onResponse(Response<DmsProductGroupResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsProductGroupResponse res = response.body();
                if (res.listProductGroupItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listProductGroupItem = res.listProductGroupItem;
                    DmsProductGroupAdapter adapter = new DmsProductGroupAdapter(DmsHeadHistoryContentActivity.this, listProductGroupItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Product Group not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistoryProductItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listProdusctItem != null) {
            listProdusctItem.clear();
        }
        String selmodul = "E";
        Call<DmsProductResponse> getDmsProduct = apiClient.GetDmsDetailProductContent(selmodul, dmslike, dmsisue);
        getDmsProduct.enqueue(new Callback<DmsProductResponse>() {
            @Override
            public void onResponse(Response<DmsProductResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsProductResponse res = response.body();
                if (res.listProductItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listProdusctItem = res.listProductItem;
                    DmsProductAdapter adapter = new DmsProductAdapter(DmsHeadHistoryContentActivity.this, listProdusctItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Product not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }


    private void getDmsHistoryOrderItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listOrderItem != null) {
            listOrderItem.clear();
        }
        String selmodul = "E";
        Call<DmsOrderResponse> getDmsOrder = apiClient.GetDmsDetailOrderContent(selmodul, dmslike, dmsisue);
        getDmsOrder.enqueue(new Callback<DmsOrderResponse>() {
            @Override
            public void onResponse(Response<DmsOrderResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsOrderResponse res = response.body();
                if (res.listOrderItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listOrderItem = res.listOrderItem;
                    DmsOrderAdapter adapter = new DmsOrderAdapter(DmsHeadHistoryContentActivity.this, listOrderItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Order Type not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistoryOrderValueItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listOrderValueItem != null) {
            listOrderValueItem.clear();
        }
        String selmodul = "E";
        Call<DmsOrderValueResponse> getDmsOrderValue = apiClient.GetDmsDetailOrderValueContent(selmodul, dmslike, dmsisue);
        getDmsOrderValue.enqueue(new Callback<DmsOrderValueResponse>() {
            @Override
            public void onResponse(Response<DmsOrderValueResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsOrderValueResponse res = response.body();
                if (res.listOrderValueItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listOrderValueItem = res.listOrderValueItem;
                    DmsOrderValueAdapter adapter = new DmsOrderValueAdapter(DmsHeadHistoryContentActivity.this, listOrderValueItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Order Value not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistoryMixedBonusItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listMixedBonusItem != null) {
            listMixedBonusItem.clear();
        }
        String selmodul = "E";
        Call<DmsMixedBonusResponse> getDmsMixedBonus = apiClient.GetDmsDetailMixedBonusContent(selmodul, dmslike, dmsisue);
        getDmsMixedBonus.enqueue(new Callback<DmsMixedBonusResponse>() {
            @Override
            public void onResponse(Response<DmsMixedBonusResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsMixedBonusResponse res = response.body();
                if (res.listMixedBonusItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listMixedBonusItem = res.listMixedBonusItem;
                    DmsMixedBonusAdapter adapter = new DmsMixedBonusAdapter(DmsHeadHistoryContentActivity.this, listMixedBonusItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Mixed Bonus not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistorySignatureItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listSignatureItem != null) {
            listSignatureItem.clear();
        }
        String selmodul = "E";
        Call<DmsSignatureResponse> getDmsSignature = apiClient.GetDmsDetailSignatureContent(selmodul, dmslike, dmsisue);
        getDmsSignature.enqueue(new Callback<DmsSignatureResponse>() {
            @Override
            public void onResponse(Response<DmsSignatureResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsSignatureResponse res = response.body();
                if (res.listSignatureItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listSignatureItem = res.listSignatureItem;
                    DmsSignatureAdapter adapter = new DmsSignatureAdapter(DmsHeadHistoryContentActivity.this, listSignatureItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Signature not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void getDmsHistoryHistoryItemAsync(String dmslike, String dmsisue) {
        pbIndicator.setVisibility(View.VISIBLE);
        lvDmsOverview.setVisibility(View.GONE);
        if (listDetHistoryItem != null) {
            listDetHistoryItem.clear();
        }
        String selmodul = "E";
        Call<DmsDetHistoryResponse> getDmsDetHistory = apiClient.GetDmsDetailHistoryContent(selmodul, dmslike, dmsisue);
        getDmsDetHistory.enqueue(new Callback<DmsDetHistoryResponse>() {
            @Override
            public void onResponse(Response<DmsDetHistoryResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                lvDmsOverview.setVisibility(View.VISIBLE);
                DmsDetHistoryResponse res = response.body();
                if (res.listDetHistoryItem.size() > 0) {
                    pbIndicator.setVisibility(View.GONE);
                    lvDmsOverview.setVisibility(View.VISIBLE);
                    listDetHistoryItem = res.listDetHistoryItem;
                    DmsDetHistoryAdapter adapter = new DmsDetHistoryAdapter(DmsHeadHistoryContentActivity.this, listDetHistoryItem);
                    lvDmsOverview.setAdapter(adapter);
                } else {
                    Toast.makeText(DmsHeadHistoryContentActivity.this, "Dms Signature not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
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

    public static void toDmsHeadHistoryContentActivity(Activity activity, String item, String skup) {
        Intent mIntent = new Intent(activity, DmsHeadHistoryContentActivity.class);
        mIntent.putExtra(KEY_DMSNO, item);
        mIntent.putExtra(KEY_SCOPE, skup);
        activity.startActivityForResult(mIntent, 0);
    }

}
