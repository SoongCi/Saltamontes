package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.saltamontes.clases.Operaciones



class EstadisticasActivity : AppCompatActivity() {

    var campCantProcesados: TextView?=null
    var campCantGanan: TextView?=null
    var campCantPierden: TextView?=null
    var campCantRecuperan: TextView?=null

    var lista=Operaciones.listaEstudiantes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)
        iniciarComponentes()

        var botonSalir: Button =findViewById(R.id.btn_salirEst)
        botonSalir.setOnClickListener{salir()}

    }

    private fun iniciarComponentes(){

        var cantidadTotal=lista.size
        var cantidadGanados:Int=totalGanadores()
        var cantidadPerdedores:Int=totalPerdedores()
        var cantidadRecuperacion:Int=totalRecuperacion()

        campCantProcesados=findViewById(R.id.textCantProcesados)
        campCantGanan=findViewById(R.id.textCantGanan)
        campCantPierden=findViewById(R.id.textCantPierden)
        campCantRecuperan=findViewById(R.id.textCantRecuperan)

        campCantProcesados?.text= "$cantidadTotal"
        campCantGanan?.text="$cantidadGanados"
        campCantPierden?.text="$cantidadPerdedores"
        campCantRecuperan?.text="$cantidadRecuperacion"

    }

    private fun totalRecuperacion(): Int {
        var cantidad=0
        for (est in lista){
            if (est.resultado.equals("Usted perdió el periodo pero puede recuperar")){
                cantidad=+1
            }
        }

        return cantidad
    }

    private fun totalPerdedores(): Int {
        var cantidad=0
        for (est in lista){

            if (est.resultado.equals("Usted perdió el periodo")){
                cantidad=+1
            }
        }

        return cantidad
    }

    private fun totalGanadores(): Int {
        var cantidad=0
        for (est in lista){
            if (est.resultado.equals("Usted ganó el periodo")){
                cantidad=cantidad+1
            }
        }

        return cantidad
    }


    private fun salir(){
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}