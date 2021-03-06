package com.example.finaliproject.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String age, String present, byte[] image, String sex,
                           String village, int studentCode){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO STUDENT VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, age);
        statement.bindString(3, present);
        statement.bindBlob(4, image);
        statement.bindString(5, sex);
        statement.bindString(6, village);
        statement.bindDouble(7, (double) studentCode);

        statement.executeInsert();
    }

    public void updateData(String name, String age, String present, byte[] image, String sex,
                           String village, int studentCode, int id ) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE STUDENT SET name = ?, age = ?, present = ?, image = ?, sex = ?," +
                " village = ?, studentCode = ? WHERE id = ? ";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, age);
        statement.bindString(3, present);
        statement.bindBlob(4, image);
        statement.bindString(5, sex);
        statement.bindString(6, village);
        statement.bindDouble(7, (double) studentCode);
        statement.bindDouble(8, (double)id);



        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM STUDENT WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

