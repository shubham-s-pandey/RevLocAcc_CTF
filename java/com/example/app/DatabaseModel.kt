package com.example.app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseModel(context: Context?) : SQLiteOpenHelper(context, "ctf.db", null, 1) {
    companion object {
        const val ctf_name = "name"
        const val ctf_table = "ctftable"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val creatable = "CREATE TABLE $ctf_table ($ctf_name VARCHAR(20))"
        db.execSQL(creatable)
    }

    fun add(ctf: CtfModel): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(ctf_name, ctf.getName())
        val insert = db.insert(ctf_table, null, cv)
        return insert != -1L
    }

    fun getAllData(): Cursor {
        val db = this.writableDatabase
        return db.rawQuery("SELECT * FROM $ctf_table", null)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}
