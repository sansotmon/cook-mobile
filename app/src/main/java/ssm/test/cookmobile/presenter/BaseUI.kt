package ssm.test.cookmobile.presenter

interface BaseUI {
    fun showMessageDialog(message: String)
    fun showProgressDialog(message: String)
    fun showToast(message: String)
}