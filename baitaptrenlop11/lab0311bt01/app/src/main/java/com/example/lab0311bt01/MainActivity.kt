package com.example.lab0311bt01

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo GestureDetector
        gestureDetector = GestureDetector(this, this)
    }

    // Handle touch events
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }

    // Implement GestureDetector methods
    override fun onDown(event: MotionEvent): Boolean {
        return true
    }

    override fun onFling(
        p0: MotionEvent?,
        e1: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Toast.makeText(this, "Swipe detected!", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        Toast.makeText(this, "Long press detected!", Toast.LENGTH_SHORT).show()
    }

    override fun onScroll(
        p0: MotionEvent?,
        e1: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        // Không cần xử lý tại đây
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        Toast.makeText(this, "Tap detected!", Toast.LENGTH_SHORT).show()
        return true
    }
}
