import android.content.Context
import java.io.File
import java.io.FileOutputStream

class DatabaseHelper(context: Context) {

    companion object {
        private const val ASSET_FILE_NAME = "sensitive.db"
        private const val DATABASE_NAME = "sensitive.db"
    }

    init {
        val dbFile = context.getDatabasePath(DATABASE_NAME)

        if (!dbFile.exists()) {
            copyDatabaseFile(dbFile.absolutePath, context)
        }
    }

    private fun copyDatabaseFile(destinationPath: String, context: Context) {
        val buffer = ByteArray(1024)
        val assetsDB = context.assets.open(ASSET_FILE_NAME)
        val output = FileOutputStream(destinationPath)

        while (true) {
            val length = assetsDB.read(buffer)
            if (length <= 0)
                break
            output.write(buffer, 0, length)
        }

        output.flush()
        output.close()
        assetsDB.close()
    }
}
