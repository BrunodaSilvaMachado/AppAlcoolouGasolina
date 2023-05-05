package com.cursoandroid.appalcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cursoandroid.appalcoolougasolina.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(calculaPreco)

    }

    private val calculaPreco: View.OnClickListener = View.OnClickListener {
        val precoAcool = binding.etPrecoAlcool.text?.toString()
        val precoGasolina = binding.etPrecoGasolina.text?.toString()

        if (validarCampos(precoAcool, precoGasolina)){
            calcularMelhorPreco(precoAcool, precoGasolina)
        }else{
            binding.tvResultado.text="Preencha os preços primeiro!"
        }
    }

    private fun validarCampos(precoAlcool: String?, precoGasolina: String?): Boolean{
        return if (precoAlcool == null || precoAlcool == "") false else !(precoGasolina == null || precoGasolina == "")
    }

    private fun calcularMelhorPreco(pAlcool: String?, pGasolina: String?) {
        val vAlcool = pAlcool?.toDouble()
        val vGasolina = pGasolina?.toDouble()
        val resultPresco = vAlcool?.div(vGasolina!!)
        if (resultPresco != null) {
            binding.tvResultado.text = if (resultPresco >= 0.7) "Melhor utilizar Gasolina!" else "Melhor utiizar Alcool!"
        }
    }
}