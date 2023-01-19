package ssm.test.cookmobile.view.activity

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ssm.test.cookmobile.R
import ssm.test.cookmobile.presenter.BaseUI

open class BaseActivity: AppCompatActivity(), BaseUI {

    private var mAlertDialog: AlertDialog? = null
    private var mAlertAskDialog: AlertDialog? = null

    override fun showMessageDialog(message: String) {
        runOnUiThread {

            if (mAlertDialog != null) {
                mAlertDialog?.setMessage(message)
                mAlertDialog?.show()
            } else {
                mAlertDialog = AlertDialog.Builder(this)
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("Aceptar") { dialog, _ ->
                        dialog.dismiss()
                    }.show()

                mAlertDialog?.getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(
                    resources.getColor(
                        R.color.colorPrimaryDark
                    )
                )
            }

        }
    }

    override fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun hideMessageDialog() {
        mAlertDialog?.dismiss()
        mAlertAskDialog?.dismiss()
    }
}
