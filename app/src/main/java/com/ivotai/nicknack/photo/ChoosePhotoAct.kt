package com.ivotai.nicknack.photo

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.ivotai.nicknack.R
import kotlinx.android.synthetic.main.act_choose_photo.*
import java.io.File


class ChoosePhotoAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_choose_photo)
        btnChoosePhoto.setOnClickListener { showChoosePhotoDialog() }
    }

    val TAKE_PHOTO = 1
    lateinit var photo:File

    private fun showChoosePhotoDialog() {
        ChoosePhotoDialog(this, R.style.Dialog).addOnClickListeners(
                View.OnClickListener {
                    photo = File(filesDir, "output_image.jpg")
//                    try {
//                        if (outputImage.exists()) {
//                            outputImage.delete()
//                        }
//                        outputImage.createNewFile()
//                    } catch (e: IOException) {
//                        e.printStackTrace()
//                    }

                     val uri =
                            if (Build.VERSION.SDK_INT >= 24) {
                        FileProvider.getUriForFile(this,
                                "com.ivotai.nicknack.fileprovider", photo)
                    }
                    else {
                        Uri.fromFile(photo)
                    }
                    // 启动相机程序
                    val intent = Intent("android.media.action.IMAGE_CAPTURE")
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
                    startActivityForResult(intent, TAKE_PHOTO)
                },
                View.OnClickListener {
                    val intent = Intent("android.intent.action.GET_CONTENT")
                    intent.type = "image/*"
                    startActivityForResult(intent, 2) // 打开相册
                }).show()
    }


    // 这个问号很关键 Intent?
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
            val bitmap = BitmapFactory.decodeFile(photo.path)
            Glide.with(this).load(bitmap).into(ivPhoto)
        }
    }


}
