package com.test.eltivo.testndk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num: Int = 10
    private var sex: String = "female"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accessPublicMethod()
        // Example of a call to a native method
        sample_text.text = stringFromJNI() + ", Num = " + addNum(3, 7) + "\n" +
                "now sex = " + getSex() + "\n" + "nu = " + test(1)

    }

    fun test(nu: Int): Int {
        var nu: Int = 3
        if(nu > 0) {
            var nu: Int = 2
        }
        return nu
    }

    fun setSex(sex: String) {
        this.sex = sex
    }

    fun getSex(): String {
        return sex
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun addNum(a: Int, b: Int): Int
    external fun accessPublicMethod()

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
