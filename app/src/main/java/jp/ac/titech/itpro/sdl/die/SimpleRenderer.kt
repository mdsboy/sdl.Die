package jp.ac.titech.itpro.sdl.die

import android.opengl.GLSurfaceView
import android.opengl.GLU
import android.util.Log
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class SimpleRenderer internal constructor() : GLSurfaceView.Renderer {
    private var obj: Obj? = null
    private var x = 0f
    private var y = 0f
    private var z // object position
            = 0f
    private var rx = 0f
    private var ry = 0f
    private var rz // object rotation
            = 0f

    fun setObj(obj: Obj?, x: Float, y: Float, z: Float) {
        this.obj = obj
        this.x = x
        this.y = y
        this.z = z
    }

    fun setObj(obj: Obj?) {
        setObj(obj, 0f, 0f, 0f)
    }

    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {
        Log.d(TAG, "onSurfaceCreated")
        gl.glEnable(GL10.GL_DEPTH_TEST)
        gl.glDepthFunc(GL10.GL_LEQUAL)
        gl.glEnable(GL10.GL_LIGHTING)
        gl.glEnable(GL10.GL_LIGHT0)
    }

    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
        Log.d(TAG, "onSurfaceChanged")
        gl.glViewport(0, 0, width, height)
        gl.glMatrixMode(GL10.GL_PROJECTION)
        gl.glLoadIdentity()
        GLU.gluPerspective(gl, 30f, width.toFloat() / height, 1f, 50f)
        GLU.gluLookAt(gl, 0f, 0f, 10f, 0f, 0f, 0f, 0f, 1f, 0f)
    }

    override fun onDrawFrame(gl: GL10) {
        gl.glClearColor(0.1f, 0.1f, 0.1f, 0.0f)
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)
        gl.glMatrixMode(GL10.GL_MODELVIEW)
        gl.glLoadIdentity()
        gl.glTranslatef(x, y, z)
        gl.glRotatef(rx, 1f, 0f, 0f)
        gl.glRotatef(ry, 0f, 1f, 0f)
        gl.glRotatef(rz, 0f, 0f, 1f)
        gl.glScalef(1f, 1f, 1f)
        obj!!.draw(gl)
    }

    fun rotateObjX(th: Float) {
        rx = th
    }

    fun rotateObjY(th: Float) {
        ry = th
    }

    fun rotateObjZ(th: Float) {
        rz = th
    }

    companion object {
        private val TAG = SimpleRenderer::class.java.simpleName
    }
}
