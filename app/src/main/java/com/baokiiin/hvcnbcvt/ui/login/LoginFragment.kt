package com.baokiiin.hvcnbcvt.ui.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.baokiiin.hvcnbcvt.R
import com.baokiiin.hvcnbcvt.databinding.FragmentLoginBinding
import com.baokiiin.hvcnbcvt.ui.student.home.HomeFragment
import com.baokiiin.hvcnbcvt.utils.BaseFragment
import com.baokiiin.hvcnbcvt.utils.Utils
import com.baokiiin.hvcnbcvt.utils.Utils.gotoFragment
import com.royrodriguez.transitionbutton.TransitionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_login
    }


    //-------------------------------- Variable ----------------------------------------
    val viewModel by viewModels<LoginViewModel>()


    //-------------------------------- createView ----------------------------------------
    override fun onCreateViews() {
        setup()
        clickView()
    }

    //-------------------------------- Func ----------------------------------------
    private fun setup() {
        baseBinding.apply {
            viewmodel = viewModel
        }

        viewModel.user.observe(viewLifecycleOwner, {
            it?.let {
                if (it.message == null) {
                    baseBinding.btnLogin.stopAnimation(
                        TransitionButton.StopAnimationStyle.EXPAND
                    ) {

                        gotoFragment(requireActivity(), HomeFragment(),false)
                        // admin
//                        when(it.data?.get(0)?.role) {
//                            "admin" -> {
//                                val fragment = HomeAdminFragment()
//                                fragment.arguments =
//                                    Bundle().apply { putString(TOKEN, it.data[0].token) }
//                                gotoFragment(requireActivity(), fragment,false)
//                            }
//                            else -> {
//                                val fragment = HomeUserFragment()
//                                fragment.arguments =
//                                    Bundle().apply {
//                                        putString(TOKEN, it.data?.get(0)?.token)
//                                        putSerializable(USER, it.data?.get(0))}
//                                gotoFragment(requireActivity(), fragment,false)
//                            }
//                        }
                    }
                } else {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    baseBinding.btnLogin.stopAnimation(
                        TransitionButton.StopAnimationStyle.SHAKE,
                        null
                    )
                }
            }
        })

    }

    private fun clickView() {
        baseBinding.btnLogin.apply {
            setOnClickListener {
                if (checkValidate()) {
                    startAnimation()
                    viewModel.login()
                }
            }
        }
    }

    private fun checkValidate(): Boolean {
        clearError()
        val checkEmail = Utils.checkNull(baseBinding.edtEmail)
        val checkPassword = Utils.checkNull(baseBinding.edtPassword)
        return checkEmail && checkPassword
    }

    private fun clearError() {
        baseBinding.apply {
            edtEmail.error = null
            edtPassword.error = null
        }
    }


}