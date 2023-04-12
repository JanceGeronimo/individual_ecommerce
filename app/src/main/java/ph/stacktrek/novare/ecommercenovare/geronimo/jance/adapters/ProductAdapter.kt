package ph.stacktrek.novare.ecommercenovare.geronimo.jance.adapters

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.databinding.ProductItemBinding
import ph.stacktrek.novare.ecommercenovare.geronimo.jance.model.Product
import java.io.ByteArrayOutputStream
import java.io.File

//onBindViewHolder
//create view holder
class ProductAdapter(private val context: Context,
                     private var productList:ArrayList<Product>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    fun deleteProduct(position:Int){
        productList.removeAt(position)

        //update the UI for the changes
        notifyItemRemoved(position)
    }

    fun addProduct(product: Product){
        productList.add(productList.size, product)
        notifyItemInserted(productList.size)
    }


    //below are fixed methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val productItemBinding = ProductItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(productItemBinding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bindItems(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    inner class ViewHolder(private val productItemBinding: ProductItemBinding):
        RecyclerView.ViewHolder(productItemBinding.root){

        fun bindItems(product: Product) {
            productItemBinding.productName.text = product.name
//            productItemBinding.viewProductButton.text = product.name

            val imagePath = product.imagePath
            println("hesrses the path ${imagePath}")
            val file = File(imagePath)
            if (file.exists()) {
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                productItemBinding.productImage.setImageBitmap(bitmap)
            } else {
                Log.e(TAG, "File not found: $imagePath")
            }

            productItemBinding.viewProductButton.setOnClickListener {
                Toast.makeText(context, "${product.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}