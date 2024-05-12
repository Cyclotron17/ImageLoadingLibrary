import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.io.InputStream
import java.lang.ref.WeakReference
import java.net.HttpURLConnection
import java.net.URL

class ImageLoader(private val imageView: WeakReference<ImageView>) :
    AsyncTask<String, Void, Bitmap?>() {

    override fun doInBackground(vararg params: String?): Bitmap? {
        val imageUrl = params[0]
        var bitmap: Bitmap? = null
        try {
            val url = URL(imageUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val inputStream: InputStream = connection.inputStream
            bitmap = BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        result?.let {
            imageView.get()?.setImageBitmap(it)
        }
    }
}
