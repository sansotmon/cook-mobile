package ssm.test.cookmobile.presenter

import android.content.Context
import ssm.test.cookmobile.interactor.OkInteractor

open class BasePresenter(context: Context) {

    protected val okInteractor = OkInteractor
}