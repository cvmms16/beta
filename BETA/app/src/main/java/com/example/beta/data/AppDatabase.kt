package com.example.beta.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.beta.dao.ViagemDao
import com.example.beta.model.*

@Database(
    entities = [
        Viagem::class,
        Onibus::class,
        Passageiro::class,
        Reserva::class,
        Pagamento::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun viagemDao(): ViagemDao

    companion object {

        @Volatile
        private var INSTANCIA: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return INSTANCIA ?: synchronized(this) {

                val instancia = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "beta_database"
                ).build()

                INSTANCIA = instancia

                instancia
            }
        }
    }
}