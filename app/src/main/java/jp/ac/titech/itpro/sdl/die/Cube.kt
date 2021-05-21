package jp.ac.titech.itpro.sdl.die

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.opengles.GL10

class Cube internal constructor() : Obj {
    private val vbuf: FloatBuffer
    override fun draw(gl: GL10) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf)

        // left
        gl.glNormal3f(-1f, 0f, 0f)
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4)

        // right
        gl.glNormal3f(1f, 0f, 0f)
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 4, 4)

        // bottom
        gl.glNormal3f(0f, -1f, 0f)
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4)

        // top
        gl.glNormal3f(0f, 1f, 0f)
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4)

        // rear
        gl.glNormal3f(0f, 0f, -1f)
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4)

        // front
        gl.glNormal3f(0f, 0f, 1f)
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 4)
    }

    companion object {
        private val VERTICES = floatArrayOf(-1f, -1f, -1f, -1f, -1f, 1f, -1f, 1f, -1f, -1f, 1f, 1f, 1f, -1f, -1f, 1f, -1f, 1f, 1f, 1f, -1f, 1f, 1f, 1f, -1f, -1f, -1f, 1f, -1f, -1f, -1f, -1f, 1f, 1f, -1f, 1f, -1f, 1f, -1f, 1f, 1f, -1f, -1f, 1f, 1f, 1f, 1f, 1f, -1f, -1f, -1f, -1f, 1f, -1f, 1f, -1f, -1f, 1f, 1f, -1f, -1f, -1f, 1f, -1f, 1f, 1f, 1f, -1f, 1f, 1f, 1f, 1f)
    }

    init {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.size * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer()
        vbuf.put(VERTICES)
        vbuf.position(0)
    }
}
