package ph.stacktrek.novare.ecommercenovare.geronimo.jance.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.R
import java.io.File
import java.io.FileOutputStream

//onCreate is only called once when the application is created
//onUpgrade if there are any changes in the SQL

//companion object is like global variable
class DatabaseHandler(context: Context):
    SQLiteOpenHelper(context, DATABASENAME,null, DATABASEVERSION) {

    private val mContext = context

    companion object {
        private val DATABASEVERSION = 1
        private val DATABASENAME = "ProductsDatabase"

        const val TABLE_PRODUCT = "product_table"
        const val TABLE_PRODUCT_ID = "id"
        const val TABLE_PRODUCT_NAME = "name"
        const val TABLE_PRODUCT_PRICE = "price"
        const val TABLE_PRODUCT_BRAND = "brand"
        const val TABLE_PRODUCT_MEASUREMENT = "measurement"
        const val TABLE_PRODUCT_DESCRIPTION = "description"
        const val TABLE_PRODUCT_MEASUREMENT_UNIT = "measurement_unit"
        const val TABLE_PRODUCT_QUANTITY = "quantity"
        const val TABLE_PRODUCT_IMAGE_PATH = "path"
        const val TABLE_PRODUCT_IMAGE = "image"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PRODUCTS_TABLE =
            "CREATE TABLE $TABLE_PRODUCT " +
                    "($TABLE_PRODUCT_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$TABLE_PRODUCT_NAME TEXT, " +
                    "$TABLE_PRODUCT_PRICE REAL, " +
                    "$TABLE_PRODUCT_BRAND TEXT, " +
                    "$TABLE_PRODUCT_MEASUREMENT REAL, " +
                    "$TABLE_PRODUCT_DESCRIPTION TEXT, " +
                    "$TABLE_PRODUCT_MEASUREMENT_UNIT TEXT, " +
                    "$TABLE_PRODUCT_QUANTITY REAL, " +
                    "$TABLE_PRODUCT_IMAGE BLOB, " +
                    "$TABLE_PRODUCT_IMAGE_PATH TEXT)"


        db?.execSQL(CREATE_PRODUCTS_TABLE)

        val image = BitmapFactory.decodeResource(mContext.resources, R.drawable.berserk)
        val file = File(mContext.filesDir, "berserk.png")
        val fileOutputStream = FileOutputStream(file)
        image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
        fileOutputStream.flush()
        fileOutputStream.close()

        val values = ContentValues()
        values.put(TABLE_PRODUCT_NAME, "Berserk")
        values.put(TABLE_PRODUCT_IMAGE_PATH, file.absolutePath) // add new column for file path
        val id = db?.insert(TABLE_PRODUCT, null, values)


        val image1 = BitmapFactory.decodeResource(mContext.resources, R.drawable.vagabond)
        val file1 = File(mContext.filesDir, "vagabond.png")
        val fileOutputStream1 = FileOutputStream(file1)
        image1.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream1)
        fileOutputStream1.flush()
        fileOutputStream1.close()

        val values1 = ContentValues()
        values1.put(TABLE_PRODUCT_NAME, "Vagabond")
        values1.put(TABLE_PRODUCT_IMAGE_PATH, file1.absolutePath) // add new column for file path
        val id1 = db?.insert(TABLE_PRODUCT, null, values1)

        val image2 = BitmapFactory.decodeResource(mContext.resources, R.drawable.monster)
        val file2 = File(mContext.filesDir, "monster.jpg")
        val fileOutputStream2 = FileOutputStream(file2)
        image2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2)
        fileOutputStream2.flush()
        fileOutputStream2.close()

        val values2 = ContentValues()
        values2.put(TABLE_PRODUCT_NAME, "Monster")
        values2.put(TABLE_PRODUCT_IMAGE_PATH, file2.absolutePath) // add new column for file path
        val id2 = db?.insert(TABLE_PRODUCT, null, values2)

        val image3 = BitmapFactory.decodeResource(mContext.resources, R.drawable.evangelion)
        val file3 = File(mContext.filesDir, "evangelion.jpg")
        val fileOutputStream3 = FileOutputStream(file3)
        image3.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream3)
        fileOutputStream3.flush()
        fileOutputStream3.close()

        val values3 = ContentValues()
        values3.put(TABLE_PRODUCT_NAME, "Neon Genesis Evangelion")
        values3.put(TABLE_PRODUCT_IMAGE_PATH, file3.absolutePath) // add new column for file path
        val id3 = db?.insert(TABLE_PRODUCT, null, values3)

        val image4 = BitmapFactory.decodeResource(mContext.resources, R.drawable.punpun)
        val file4 = File(mContext.filesDir, "punpun.jpg")
        val fileOutputStream4 = FileOutputStream(file4)
        image4.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream4)
        fileOutputStream4.flush()
        fileOutputStream4.close()

        val values4 = ContentValues()
        values4.put(TABLE_PRODUCT_NAME, "Oyasumi Punpun")
        values4.put(TABLE_PRODUCT_IMAGE_PATH, file4.absolutePath) // add new column for file path
        val id4 = db?.insert(TABLE_PRODUCT, null, values4)

        val image5 = BitmapFactory.decodeResource(mContext.resources, R.drawable.aot)
        val file5 = File(mContext.filesDir, "aot.jpg")
        val fileOutputStream5 = FileOutputStream(file5)
        image5.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream5)
        fileOutputStream5.flush()
        fileOutputStream5.close()

        val values5 = ContentValues()
        values5.put(TABLE_PRODUCT_NAME, "Attack on Titan")
        values5.put(TABLE_PRODUCT_IMAGE_PATH, file5.absolutePath) // add new column for file path
        val id5 = db?.insert(TABLE_PRODUCT, null, values5)

        val image6 = BitmapFactory.decodeResource(mContext.resources, R.drawable.vinland)
        val file6 = File(mContext.filesDir, "vinland.jpg")
        val fileOutputStream6 = FileOutputStream(file6)
        image6.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream6)
        fileOutputStream6.flush()
        fileOutputStream6.close()

        val values6 = ContentValues()
        values6.put(TABLE_PRODUCT_NAME, "Vinland Saga")
        values6.put(TABLE_PRODUCT_IMAGE_PATH, file6.absolutePath) // add new column for file path
        val id6 = db?.insert(TABLE_PRODUCT, null, values6)

        val image7 = BitmapFactory.decodeResource(mContext.resources, R.drawable.geass)
        val file7 = File(mContext.filesDir, "geass.jpg")
        val fileOutputStream7 = FileOutputStream(file7)
        image7.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream7)
        fileOutputStream7.flush()
        fileOutputStream7.close()

        val values7 = ContentValues()
        values7.put(TABLE_PRODUCT_NAME, "Code Geass")
        values7.put(TABLE_PRODUCT_IMAGE_PATH, file7.absolutePath) // add new column for file path
        val id7 = db?.insert(TABLE_PRODUCT, null, values7)

        val image8 = BitmapFactory.decodeResource(mContext.resources, R.drawable.deathnote)
        val file8 = File(mContext.filesDir, "deathnote.jpg")
        val fileOutputStream8 = FileOutputStream(file8)
        image8.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream8)
        fileOutputStream8.flush()
        fileOutputStream8.close()

        val values8 = ContentValues()
        values8.put(TABLE_PRODUCT_NAME, "Death Note")
        values8.put(TABLE_PRODUCT_IMAGE_PATH, file8.absolutePath) // add new column for file path
        val id8 = db?.insert(TABLE_PRODUCT, null, values8)

        val image9 = BitmapFactory.decodeResource(mContext.resources, R.drawable.steins)
        val file9 = File(mContext.filesDir, "steins.jpg")
        val fileOutputStream9 = FileOutputStream(file9)
        image9.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream9)
        fileOutputStream9.flush()
        fileOutputStream9.close()

        val values9 = ContentValues()
        values9.put(TABLE_PRODUCT_NAME, "Steins;Gate")
        values9.put(TABLE_PRODUCT_IMAGE_PATH, file9.absolutePath) // add new column for file path
        val id9 = db?.insert(TABLE_PRODUCT, null, values9)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCT")
        onCreate(db)
    }


}