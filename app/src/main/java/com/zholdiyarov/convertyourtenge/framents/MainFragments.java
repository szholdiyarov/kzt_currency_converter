package com.zholdiyarov.convertyourtenge.framents;

/**
 * Created by szholdiyarov on 4/21/15.
 */

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.zholdiyarov.convertyourtenge.MainActivity;
import com.zholdiyarov.convertyourtenge.R;
import com.zholdiyarov.convertyourtenge.helpers.CustomListAdapter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainFragments extends Fragment {
    private ListView list;
    public static String[] resArr;

    public static String getElem(int pos) {
        return resArr[pos];
    }

    private static String[] itemName = {
            "Доллары США",
            "Евро",
            "Рубль",
            "Английский фунт",
            "Китайская иена",

            "Дирхам ОАЭ",
            "Кыргызский сом",
            "Узбекский сум",
            "Украинская гривна",
            "Австралийский доллар"
    };

    public static String[] getItemName() {
        return itemName;
    }
    private static String[] mStrings = {
            "http://zholdiyarov.zz.mu/img/usa.gif",
            "http://zholdiyarov.zz.mu/img/eu.png",
            "http://zholdiyarov.zz.mu/img/ru.gif",
            "http://zholdiyarov.zz.mu/img/gb.gif",
            "http://zholdiyarov.zz.mu/img/china.gif",

            "http://zholdiyarov.zz.mu/img/oae.gif",
            "http://zholdiyarov.zz.mu/img/kirgizia.gif",
            "http://zholdiyarov.zz.mu/img/uzb.gif",
            "http://zholdiyarov.zz.mu/img/ukr.gif",
            "http://zholdiyarov.zz.mu/img/avstr.gif"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyAsyncTask asyncTask = new MyAsyncTask();

        View android = inflater.inflate(R.layout.fragment_main, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            asyncTask.execute();
        }
        return android;
    }

    private class MyAsyncTask extends AsyncTask<String, Void, Void> {
        private HttpClient client;
        private HttpGet request;
        private String url;
        private StringBuffer result;
        private String line;
        private String[] tokens;

        public String[] getResArr() {
            return resArr;
        }

        @Override
        protected Void doInBackground(String... params) {

            final String USER_AGENT = "Mozilla/5.0";
            Log.i("M", "++++++++++");

            try {

                url = "http://www.freecurrencyconverterapi.com/api/v3/convert?q=USD_KZT,EUR_KZT,RUB_KZT,GBP_KZT,CNY_KZT,AED_KZT,KGS_KZT,UZS_KZT,UAH_KZT,AUD_KZT&compact=ultra";
                resArr = new String[10];
                client = new DefaultHttpClient();
                request = new HttpGet(url);

                // add request header
                request.addHeader("User-Agent", USER_AGENT);

                HttpResponse response = client.execute(request);
                Log.i("Main Activity", "Sending 'GET' request to URL : " + url);
                Log.i("Main Activity", "Response Code : "
                        + response.getStatusLine().getStatusCode());


                BufferedReader rd = new BufferedReader(new InputStreamReader(response
                        .getEntity().getContent()));

                result = new StringBuffer();
                line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                Log.i("Main Activity", "Sending 'GET' request to URL : " + url);
                Log.i("Main Activity", "Result:" + result.toString());
                String delims = "[:,}]";
                tokens = result.toString().split(delims);
                for (int i = 0; i < tokens.length; i++) {
                    Log.i("Main Activity", "i:" + i + " " + tokens[i]);
                }
                resArr[0] = tokens[1];
                resArr[1] = tokens[3];
                resArr[2] = tokens[5];
                resArr[3] = tokens[7];
                resArr[4] = tokens[9];
                resArr[5] = tokens[11];
                resArr[6] = tokens[13];
                resArr[7] = tokens[15];
                resArr[8] = tokens[17];
                resArr[9] = tokens[19];
            } catch (
                    Exception e
                    )

            {
                Log.i("Main Activity", " Exception e = " + e.toString());
            }
            return null;
        }
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(
                    getActivity());
            progressDialog.setMessage("Downloading...");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Void v) {
            CustomListAdapter adapter = new CustomListAdapter(getActivity(), itemName, mStrings, resArr);
            list = (ListView) getView().findViewById(R.id.list);
            list.setAdapter(adapter);
            progressDialog.cancel();
        }
    }
}

