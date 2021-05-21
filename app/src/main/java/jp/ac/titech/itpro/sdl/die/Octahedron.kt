package jp.ac.titech.itpro.sdl.die

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.opengles.GL10

class Octahedron internal constructor() : Obj {
    private val vbuf: FloatBuffer
    override fun draw(gl: GL10) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf)

        // bottom
        //gl.glNormal3f(0f, -1f, 0f)
        //gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4)

        // left
        gl.glNormal3f(-1f, 1f, 0f)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 4, 3)

        // right
        gl.glNormal3f(1f, 1f, 0f)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 7, 3)

        // back
        gl.glNormal3f(0f, 1f, -1f)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 10, 3)

        // front
        gl.glNormal3f(0f, 1f, 1f)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 13, 3)

        //

        // left
        gl.glNormal3f(-1f, -1f, 0f)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 16, 3)

        // right
        gl.glNormal3f(1f, -1f, 0f)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 19, 3)

        // back
        gl.glNormal3f(0f, -1f, -1f)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 22, 3)

        // front
        gl.glNormal3f(0f, -1f, 1f)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 25, 3)
    }

    companion object {
        private val VERTICES = floatArrayOf(
                -1f, 0f, -1f,
                1f, 0f, -1f,
                -1f, 0f, 1f,
                1f, 0f, 1f,

                //

                -1f, 0f, -1f,
                0f, 1f, 0f,
                -1f, 0f, 1f,

                1f, 0f, -1f,
                0f, 1f, 0f,
                1f, 0f, 1f,

                -1f, 0f, -1f,
                0f, 1f, 0f,
                1f, 0f, -1f,

                -1f, 0f, 1f,
                0f, 1f, 0f,
                1f, 0f, 1f,

                //

                -1f, 0f, -1f,
                0f, -1f, 0f,
                -1f, 0f, 1f,

                1f, 0f, -1f,
                0f, -1f, 0f,
                1f, 0f, 1f,

                -1f, 0f, -1f,
                0f, -1f, 0f,
                1f, 0f, -1f,

                -1f, 0f, 1f,
                0f, -1f, 0f,
                1f, 0f, 1f
        )
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
