package com.rifara.storyappdicoding.ui.pages.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rifara.storyappdicoding.R
import com.rifara.storyappdicoding.core.helper.NavigationHelper
import com.rifara.storyappdicoding.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.onBackPressedDispatcher?.addCallback(this, // lifecycle Owner
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Back is pressed... Finishing the activity
                    activity?.finish()
                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setMyButtonEnable()

        // Email
        _binding.customEditTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        // Pass
        _binding.customEditTextPass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        _binding.customButtonLogin.setOnClickListener {
            Toast.makeText(
                activity,
                _binding.customEditTextEmail.text,
                Toast.LENGTH_SHORT
            ).show()

            Toast.makeText(
                activity,
                _binding.customEditTextPass.text,
                Toast.LENGTH_SHORT
            ).show()
        }
        playAnimation()

        _binding.apply {
            createAccount.setOnClickListener{
                NavigationHelper.movePagesFragment(
                    requireParentFragment(),
                    R.id.action_loginFragment_to_registerFragment
                )
            }
        }
    }

    private fun setMyButtonEnable() {
        val result = _binding.customEditTextEmail.text
        val result2 = _binding.customEditTextPass.text

        _binding.customButtonLogin.isEnabled = (result != null && result.toString().isNotEmpty()) && (result2 != null && result2.toString().isNotEmpty())

    }

    private fun playAnimation(){

        // Title
        val titleLogin = ObjectAnimator.ofFloat(_binding.tvLogin, View.ALPHA, 1f).setDuration(500)
        val imglogo = ObjectAnimator.ofFloat(_binding.ivLogo, View.ALPHA, 1f).setDuration(500)

        // Email
        val textEmail = ObjectAnimator.ofFloat(_binding.tvEmail, View.ALPHA, 1f).setDuration(500)
        val inputEmail = ObjectAnimator.ofFloat(_binding.emailTextField, View.ALPHA, 1f).setDuration(500)
//
//        // Password
        val textPassword = ObjectAnimator.ofFloat(_binding.tvPassword, View.ALPHA, 1f).setDuration(500)
        val inputPassword = ObjectAnimator.ofFloat(_binding.passTextField, View.ALPHA, 1f).setDuration(500)
//
//        // Button
        val btnLogin = ObjectAnimator.ofFloat(_binding.customButtonLogin, View.ALPHA, 1f).setDuration(500)
        val createAccount = ObjectAnimator.ofFloat(_binding.createAccount, View.ALPHA, 1f).setDuration(500)
//
        val setEmail = AnimatorSet().apply {
            playTogether(textEmail, inputEmail)
        }
//
        val setPassword = AnimatorSet().apply {
            playTogether(textPassword, inputPassword)
        }
//
        AnimatorSet().apply {
            playSequentially(
                imglogo,
                titleLogin,
                setEmail,
                setPassword,
                btnLogin,
                createAccount

            )
            start()
        }
    }



}