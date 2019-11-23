package com.example.projetofinal


import android.app.*
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.projetofinal.db.Produto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // INICIO NOTIFICAÇÃO
    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.example.vicky.notificationexample"
    private val description = "Test Notification"

    @RequiresApi(Build.VERSION_CODES.O)
    //INICION NOTIFICAÇÃO

    lateinit var produto: Produto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        //      NOTIFICAÇÃO
//        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        //      NOTIFICAÇÃO

//        btnSave.setOnClickListener{
//
//            val intent = Intent(this, LauncherActivity::class.java)
//            val pendingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                notificationChannel = NotificationChannel (channelId,description,IMPORTANCE_HIGH)
//                notificationChannel.enableLights(true)
//                notificationChannel.lightColor = Color.GREEN
//                notificationChannel.enableVibration(false)
//                notificationManager.createNotificationChannel(notificationChannel)
//// CONTEUDO DA NOTIFICAÇÃO
//                builder = Notification.Builder(this,channelId)
//                    .setContentTitle("Cadastro realizado")
//                    .setContentText("Confira as informações no campo abaixo!")
//                    .setSmallIcon (R.drawable.ic_success)
//                    .setLargeIcon(BitmapFactory.decodeResource (this.resources, R.drawable.ic_success))
//                    .setContentIntent(pendingIntent)
//            }else{
//                builder = Notification.Builder(this)
//                    .setContentTitle("CodeAndroid")
//                    .setContentText("Test Notification")
//                    .setSmallIcon (R.mipmap.ic_launcher_round)
//                    .setLargeIcon(BitmapFactory.decodeResource (this.resources, R.drawable.ic_success))
//                    .setContentIntent(pendingIntent)
//            }
//// FIM CONTEUDO DA NOTIFICAÇÃO
//            notificationManager.notify(1234,builder.build())
//// FIM NOTIFICAÇÃO
//        }
    }

    fun save(view: View){


        if(edtNome.text.isNullOrEmpty())
            Toast.makeText(
                this,
                "preencha o campo nome",
                Toast.LENGTH_LONG
            ).show()
        else{
            produto = Produto()
            popObj()
            notification()

            var intent = Intent()
            intent.putExtra(EXTRA_REPLY, produto)

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }

    private fun notification(){

//              NOTIFICAÇÃO
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //      NOTIFICAÇÃO

        btnSave.setOnClickListener{

            val intent = Intent(this, LauncherActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel (channelId,description,IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)
// CONTEUDO DA NOTIFICAÇÃO
                builder = Notification.Builder(this,channelId)
                    .setContentTitle("Cadastro realizado")
                    .setContentText("Confira as informações no campo abaixo!")
                    .setSmallIcon (R.drawable.ic_success)
                    .setLargeIcon(BitmapFactory.decodeResource (this.resources, R.drawable.ic_success))
                    .setContentIntent(pendingIntent)
            }else{
                builder = Notification.Builder(this)
                    .setContentTitle("CodeAndroid")
                    .setContentText("Test Notification")
                    .setSmallIcon (R.mipmap.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource (this.resources, R.drawable.ic_success))
                    .setContentIntent(pendingIntent)
            }
// FIM CONTEUDO DA NOTIFICAÇÃO
            notificationManager.notify(1234,builder.build())
// FIM NOTIFICAÇÃO
        }

    }


    private fun popObj(){
        produto.nome = edtNome.text.toString()
       produto.marca = edtMarca.text.toString()
       produto.modelo = edtModelo.text.toString()
        produto.preco = edtPreco.text.toString()
        produto.status = edtStatus.text.toString()
    }
    companion object {
        const val EXTRA_REPLY = "com.example.projetofinal.REPLY"
    }
}