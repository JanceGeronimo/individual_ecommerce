package ph.stacktrek.novare.ecommercenovare.geronimo.jance.model

import android.icu.util.MeasureUnit
import android.location.GnssMeasurement
import java.math.BigDecimal
import java.sql.Blob

class Product(var name: String) {
    lateinit var id: String
    lateinit var price: BigDecimal
    lateinit var brand: String
    lateinit var measurement: String
    lateinit var description : String
    var measurementUnit: MeasurementUnit = MeasurementUnit.NOT_SET
    var quantity: Int = 0
    var imagePath: String = ""
}

enum class MeasurementUnit{
    KILOGRAMS,
    GRAMS,
    METER,
    TONS,
    NOT_SET
}