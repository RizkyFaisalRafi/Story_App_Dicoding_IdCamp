package com.rifara.storyappdicoding.ui.pages.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rifara.storyappdicoding.R
import com.rifara.storyappdicoding.core.helper.NavigationHelper
import com.rifara.storyappdicoding.databinding.FragmentLoginBinding
import com.rifara.storyappdicoding.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var _binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        _binding.apply {
            haveAccount.setOnClickListener{
                NavigationHelper.movePagesFragment(
                    requireParentFragment(),
                    R.id.action_registerFragment_to_loginFragment
                )
            }
        }


    }
}