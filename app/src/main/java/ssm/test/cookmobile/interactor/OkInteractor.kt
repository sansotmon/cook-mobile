package ssm.test.cookmobile.interactor

import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import ssm.test.cookmobile.model.Recipe
import java.io.IOException

object OkInteractor {

    private var client = OkHttpClient()
    private var request: Request? = null
    private var url: HttpUrl? = null
    private const val BASE_URL = "http://demo4279338.mockable.io/recipes"

    private fun requestHttp(res: (String?) -> Unit, err: (String?) -> Unit) {
        request?.let { httpRequest ->
            client.newCall(httpRequest).enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) = res(response.body?.string())

                override fun onFailure(call: Call, e: IOException) {
                    err(e.localizedMessage)
                }
            })
        }
    }

    fun getRecipes(res: (String?) -> Unit, err: (String?) -> Unit) {

        url = BASE_URL.toHttpUrlOrNull()?.newBuilder()?.build()

        url?.let { httpUrl ->
            request = Request.Builder()
                .url(httpUrl)
                .build()
        }

        requestHttp(res, err)
    }


}