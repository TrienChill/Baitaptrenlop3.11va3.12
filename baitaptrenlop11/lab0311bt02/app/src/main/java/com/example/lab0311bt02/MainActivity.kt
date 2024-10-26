package com.example.lab0311bt02

import android.graphics.Color
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    private lateinit var gestureDetector: GestureDetector
    private lateinit var mainLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.mainLayout)
        // Khởi tạo GestureDetector
        gestureDetector = GestureDetector(this, this)
    }

    // Xử lý các sự kiện chạm
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }

    override fun onDown(event: MotionEvent): Boolean {
        return true
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        // Đổi màu nền khi chạm
        mainLayout.setBackgroundColor(Color.BLUE)
        return true
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1 != null) {
            val diffY = e2.y - e1.y
            if (abs(diffY) > 100 && abs(velocityY) > 100) {
                if (diffY < 0) {
                    // Vuốt lên
                    mainLayout.setBackgroundColor(Color.YELLOW)
                } else {
                    // Vuốt xuống
                    mainLayout.setBackgroundColor(Color.RED)
                }
                return true
            }
        }
        return false
    }

    override fun onLongPress(event: MotionEvent) {
        // Không cần xử lý
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        // Không cần xử lý
    }

}
