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
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jahanshahi.itime.R;
import com.jahanshahi.itime.dao.ItemDAO;
import com.jahanshahi.itime.dbUtil.AppDatabase;
import com.jahanshahi.itime.models.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExportToPDF extends AppCompatActivity {
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_to_pdf);
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

    private void exportToPDF() throws FileNotFoundException, DocumentException {

        AppDatabase database = Room.databaseBuilder(this,AppDatabase.class,"mydb")
                .allowMainThreadQueries()
                .build();
        ItemDAO itemDAO = database.getItemDAO();

        String filename="times.pdf";

        Document document=new Document();  // create the document
        File root = new File(Environment.getExternalStorageDirectory(), "ITime");
        if (!root.exists()) {
            root.mkdirs();   // create root directory in sdcard
        }
        File gpxfile = new File(root,filename);  // generate pdf file in that directory
        PdfWriter.getInstance(document,new FileOutputStream(gpxfile));
        document.open();  // open the directory
        Paragraph p3=new Paragraph();  // to enter value you have to create paragraph  and add value in it then paragraph is added into document
        p3.add("جدول زمان ها : ");
        p3.setAlignment(Element.ALIGN_CENTER);
        document.add(p3);
        // now for ad table in pdf use below code
        PdfPTable table = new PdfPTable(4); // Code 1
        // Code 2
        table.addCell("تاریخ");
        table.addCell("زمان شروع");
        table.addCell("زمان پایان");
        table.addCell("توضیحات");
        // now fetch data from database and display it in pdf
        for (Item item : itemDAO.getItems()){
            table.addCell(item.getDate());
            table.addCell(item.getStartTime());
            table.addCell(item.getEndTime());
            table.addCell(item.getDescription());
        }
        // add table into document
        document.add(table);
        document.addCreationDate();
        document.close();
    }
}
