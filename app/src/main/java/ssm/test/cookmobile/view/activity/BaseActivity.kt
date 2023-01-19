package ssm.test.cookmobile.view.activity

import androidx.appcompat.app.AppCompatActivity
import ssm.test.cookmobile.presenter.BaseUI

open class BaseActivity: AppCompatActivity(), BaseUI{
    override fun showMessageDialog(message: String) {
        TODO("Not yet implemented")
    }

    override fun showProgressDialog(message: String) {
        TODO("Not yet implemented")
    }

    override fun showToast(message: String) {
        TODO("Not yet implemented")
    }
}