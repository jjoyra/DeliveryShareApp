package com.cookandroid.dsa_start

//import androidx.lifecycle.LiveData
//import androidx.room.*

class defAddressDB {

}
//
//@Entity
//data class AddressTable(
//    @PrimaryKey val code : Long,
//    val name1 : String,
//    val name2 : String,
//    val name3 : String,
//    val name4 : String
//)
//
//@Dao
//interface AddressInterface {
//    @Query("SELECT* FROM AddressTable")
//    suspend fun getAll(): List<AddressTable>
//
//    @Insert
//    suspend fun insert(addressTable : AddressTable)
//
//    @Query("DELETE FROM AddressTable")
//    suspend fun deleteAll()
//
//    @Query("SELECT * FROM AddressTable WHERE name2 LIKE :searchQuery")
//    fun searchDatabase(searchQuery: String) : LiveData<List<AddressTable>>
//}
//
//@Database(entities = [AddressTable::class],version = 1)
//abstract class AppDatabase: RoomDatabase() {
//    abstract fun addressInterface() : AddressInterface
//
//}