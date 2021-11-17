package com.example.kadai01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.kadai01.databinding.FragmentPasswordEditBinding
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PasswordEditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PasswordEditFragment : Fragment() {
    private var _binding: FragmentPasswordEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //realm = Realm.getDefaultInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPasswordEditBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View,savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.setFabVisible(View.INVISIBLE)
        //binding.back.setOnClickListener{saveSchedule(it)}
    }
    private fun saveSchedule(view: View) {
        /*
        realm.executeTransaction{db: Realm ->
            val maxId = db.where<Password>().max("id")
            val nextId = (maxId?.toLong() ?: 0L) + 1L
            val password = db.createObject<Password>(nextId)
        }

         */
        Snackbar.make(view,"追加しました。",Snackbar.LENGTH_SHORT).setAction("戻る")
        {findNavController().popBackStack()}.show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onDestroy(){
        super.onDestroy()
        //realm.close()
    }
}