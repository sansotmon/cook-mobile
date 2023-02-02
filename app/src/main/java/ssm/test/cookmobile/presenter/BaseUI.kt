package ssm.test.cookmobile.presenter

interface BaseUI {
    fun showMessageDialog(message: String)
    fun showToast(message: String)
    fun hideMessageDialog()
    fun showProgressDialog(resourceMessage: Int)
    fun showProgressDialog(message: String)
    fun hideProgressDialog()
}