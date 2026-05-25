package com.ntvdm.clockwidgets;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1.0
        Button btnClassic = (Button) findViewById(R.id.btn_classic);
        btnClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("classic");
            }
        });

        // GB
        Button btnGinger = (Button) findViewById(R.id.btn_gingerbread);
        btnGinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("gingerbread");
            }
        });

        // HC
        Button btnhc = (Button) findViewById(R.id.btn_hc);
        btnhc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("honey");
            }
        });

        // ICS
        Button btnics = (Button) findViewById(R.id.btn_ics);
        btnics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("ics");
            }
        });

        // ICS GSM Arena
        Button btnicsgsm = (Button) findViewById(R.id.btn_ics_gsm);
        btnicsgsm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("ics_gsm");
            }
        });

        // JB
        Button btnjb = (Button) findViewById(R.id.btn_jb);
        btnjb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("jb");
            }
        });

        // IRK40C my fav
        Button btnirk = (Button) findViewById(R.id.btn_irk);
        btnirk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("irk");
            }
        });

        // samsnug tw """"modern""""
        Button btnmodern = (Button) findViewById(R.id.btn_modern);
        btnmodern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("modern");
            }
        });

        // samsnug tw FUNKYY
        Button btnfunky = (Button) findViewById(R.id.btn_funky);
        btnfunky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("funky");
            }
        });

        // materiealie
        Button btnmaterial = (Button) findViewById(R.id.btn_material);
        btnmaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("material");
            }
        });

        // samsnug tw ""modern"" TWO!
        Button btngbsam = (Button) findViewById(R.id.btn_gbsam);
        btngbsam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("gbsam");
            }
        });

        // samsnug tw ""modern"" TWO!
        Button btngbsam1 = (Button) findViewById(R.id.btn_gbsam1);
        btngbsam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("gbsam1");
            }
        });

        // htc gooner i mean sooner
        Button btnsooner = (Button) findViewById(R.id.btn_sooner);
        btnsooner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTheme("sooner");
            }
        });

        // 4.2 Digital Clock
        Button btndigital = (Button) findViewById(R.id.btn_digital);
        btndigital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextClock requires API 17 (Jelly Bean 4.2)
                if (android.os.Build.VERSION.SDK_INT >= 17) {
                    applyTheme("digital");
                } else {
                    Toast.makeText(MainActivity.this, "Android 4.2+ only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 4.4 Digital Clock
        Button btndigitalkk = (Button) findViewById(R.id.btn_digitalkk);
        btndigitalkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextClock requires API 17 (Jelly Bean 4.2)
                if (android.os.Build.VERSION.SDK_INT >= 17) {
                    applyTheme("digitalkk");
                } else {
                    Toast.makeText(MainActivity.this, "Android 4.2+ only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 4.0 Digital Clock
        Button btndigitalics = (Button) findViewById(R.id.btn_digitalics);
        btndigitalics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {applyTheme("digitalics");
                Toast.makeText(MainActivity.this, "meant for the losck screen", Toast.LENGTH_SHORT).show();
                }

        });

        final ImageView mascot = (ImageView) findViewById(R.id.mascot_gjinka);
        CheckBox toggle = (CheckBox) findViewById(R.id.toggle_gjinka);

        final SharedPreferences prefs = getSharedPreferences("ClockPrefs", MODE_PRIVATE);
        boolean isVisible = prefs.getBoolean("show_mascot", true);
        toggle.setChecked(isVisible);
        mascot.setVisibility(isVisible ? View.VISIBLE : View.GONE);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                prefs.edit().putBoolean("show_mascot", isChecked).apply();

                mascot.setVisibility(isChecked ? View.VISIBLE : View.GONE);

                String status = isChecked ? "enjoy cringe" : "you killed em.";
                Toast.makeText(MainActivity.this, status, Toast.LENGTH_SHORT).show();
            }
        });

        // funny shits
        int sdk = android.os.Build.VERSION.SDK_INT;

        if (sdk >= 36) { // LATEST ASSHOLE
            mascot.setImageResource(R.drawable.gjinka_berice);

        } else if (sdk == 35) { // androd 15
            mascot.setImageResource(R.drawable.gjinka_vannela);

        } else if (sdk == 34) { // upside down WHAT
            mascot.setImageResource(R.drawable.gjinka_upsica);

        } else if (sdk == 33) { // Tirashitsu
            mascot.setImageResource(R.drawable.gjinka_tifu);

        } else if (sdk >= 31 && sdk <= 32) { // snowbro
            mascot.setImageResource(R.drawable.gjinka_snowie);

        } else if (sdk == 30) { // androd 11
            mascot.setImageResource(R.drawable.gjinka_reveca);

        } else if (sdk == 29) { // androd 10
            mascot.setImageResource(R.drawable.gjinka_quincie);

        /* } else if (sdk == 28) { // the pie woman
            mascot.setImageResource(R.drawable.gjinka_paifira); */

        } else if (sdk >= 26 && sdk <= 27) { // octopus head
            mascot.setImageResource(R.drawable.gjinka_oaklee);

        /* } else if (sdk >= 24 && sdk <= 25) { // meow meow
            mascot.setImageResource(R.drawable.gjinka_nina); */

        } else if (sdk == 23) { // fluff v6
            mascot.setImageResource(R.drawable.gjinka_marshymo);

        } else if (sdk >= 21 && sdk <= 22) { // material girl
            mascot.setImageResource(R.drawable.gjinka_lollypo);

        } else if (sdk == 19 || sdk == 20) { // kitkat
            mascot.setImageResource(R.drawable.gjinka_kathie);

        } else if (sdk >= 16 && sdk <= 18) { // jellybn
            mascot.setImageResource(R.drawable.gjinka_jellybo);

        } else if (sdk >= 14 && sdk <= 15) { // ics
            mascot.setImageResource(R.drawable.gjinka_icelyn);

        } else if (sdk >= 11 && sdk <= 13) { // bee
            mascot.setImageResource(R.drawable.gjinka_haniku);

        } else if (sdk == 10 || sdk == 9) { // assbread
            mascot.setImageResource(R.drawable.gjinka_genny);

        } else {
            // default to Apphie cuz why not
            mascot.setImageResource(R.drawable.gjinka_apphie);
        }

        // doze check for marshy+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent();
            String packageName = getPackageName();
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);

            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + packageName));
                startActivity(intent);

                Toast.makeText(this, "pleeaaseee disable battery optimizations or android will kill the clock", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void applyTheme(String themeKey) {
        SharedPreferences prefs = getSharedPreferences("ClockPrefs", Context.MODE_PRIVATE);
        prefs.edit().putString("selected_theme", themeKey).apply();

        Intent intent = new Intent(this, AnalogWidgetProvider.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

        AppWidgetManager widgetManager = AppWidgetManager.getInstance(this);
        int[] ids = widgetManager.getAppWidgetIds(new ComponentName(this, AnalogWidgetProvider.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);

        sendBroadcast(intent);

        Toast.makeText(this, "Theme used: " + themeKey, Toast.LENGTH_SHORT).show();
    }


}