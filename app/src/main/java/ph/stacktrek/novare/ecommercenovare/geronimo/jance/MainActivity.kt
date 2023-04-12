package ph.stacktrek.novare.ecommercenovare.geronimo.jance

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.adapters.ProductAdapter
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.adapters.SwipeCallback
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.dao.ProductDAO
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.dao.ProductDAOSQLLiteImplementation
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.dao.ProductDAOStubImplementation
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.databinding.ActivityMainBinding
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.databinding.DialogueAddProductBinding
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.model.Product
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.model.User
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.utility.PreferenceUtility
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    //create variable of product adapter
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productDAO: ProductDAO

    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        Log.d("MAIN ACTIVITY","USERNAME BUNDLE: ${bundle!!.getString("bundle_username")}")

        val extra = intent.getStringExtra("username")
        Log.d("MAIN ACTIVITY","USERNAME EXTRA : $extra")

        //day 2

        loadProducts()

        binding.fabAddProductButton.setOnClickListener {
            showAddProductDialogue().show()
        }
    }

    //displaying products
    fun loadProducts(){
//        productDAO = ProductDAOStubImplementation()
        productDAO = ProductDAOSQLLiteImplementation(applicationContext)
        productAdapter = ProductAdapter(applicationContext, productDAO.getProducts())

        with(binding.productsList){
            layoutManager=LinearLayoutManager(applicationContext,
                LinearLayoutManager.VERTICAL, false)
//                left to right, top to bottom layout. the 2 is the span size
//                layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = productAdapter
        }

        //using "with", this is not needed anymore
//            binding.productsList.layoutManager
//            binding.productsList.layout()

        var swipeCallback = SwipeCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        swipeCallback.productAdapter = productAdapter
        itemTouchHelper = ItemTouchHelper(swipeCallback).apply {
            attachToRecyclerView(binding.productsList)
        }
    }

    fun showAddProductDialogue(): Dialog {
        return this.let {
            val builder = AlertDialog.Builder(it)
            val dialogueAddProductBinding: DialogueAddProductBinding =
                DialogueAddProductBinding.inflate(it.layoutInflater)

            with(builder) {
                setPositiveButton("ADD", DialogInterface.OnClickListener { dialog, id ->

                    val product = Product("")
                    product.name = dialogueAddProductBinding.productName.text.toString()


//                    val productDAO = ProductDAOStubImplementation()
                    val productDAO = ProductDAOSQLLiteImplementation(applicationContext)
                    productDAO.addProduct(product)
                    productAdapter.addProduct(product)
                })
                setNegativeButton("CANCEL",DialogInterface.OnClickListener { dialog, id ->

                })
                setView(dialogueAddProductBinding.root)
                create()
            }
        }
    }
    //dialogue is a pop up
    //"it" refers to the dialog itself

    //onBackPress, save first for the Shared Preferences
    override fun onBackPressed() {
        super.onBackPressed()
        val goToMain = Intent(applicationContext,
            LoginActivity::class.java)
        startActivity(goToMain)
        finish()
    }
}