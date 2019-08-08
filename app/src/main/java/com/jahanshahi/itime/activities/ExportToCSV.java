package com.jahanshahi.itime.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.jahanshahi.itime.R;
import com.jahanshahi.itime.csvUtil.CSVWriter;
import com.jahanshahi.itime.dao.ItemDAO;
import com.jahanshahi.itime.dbUtil.AppDatabase;
import com.jahanshahi.itime.models.Item;

import java.io.File;
import java.io.FileWriter;

public class ExportToCSV extends AppCompatActivity {
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_to_csv);
    }

    private boolean isStoragePermissionGranted(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]
                        { Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_REQUEST_CODE);
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Thanks!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    private void exportDB() {
        File exportDir = new File(Environment.getExternalStorageDirectory(), "ITime");
        if (!exportDir.exists())
        {
            exportDir.mkdirs();
        }

        File file = new File(exportDir, "times.csv");
        try
        {
            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
            AppDatabase database = Room.databaseBuilder(this,AppDatabase.class,"mydb")
                    .allowMainThreadQueries()
                    .build();
            ItemDAO itemDAO = database.getItemDAO();
            csvWrite.writeNext(new String[]{"تاریخ","زمان شروع","زمان پایان","توضیحات"});
            for (Item item : itemDAO.getItems()){
                //Which column you want to exprort
                String[] arrStr = {item.getDate(), item.getStartTime(), item.getEndTime(), item.getDescription()};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
        }
        catch(Exception sqlEx)
        {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }
    }

}
