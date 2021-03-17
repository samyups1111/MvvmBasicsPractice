package samyups.example.mvvmbasicsprep.data


// private const. so it cannot be invoked outside this class.
class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
        private set

    companion object {
        // volatile means that rights to this property are immediately visible to other threads
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
            // left ?: right. ?: means that if the left is NOT null then it returns it, otherwise it returns right
            // "sync(this) means 2 threads cannot be executing at the same time
            instance ?: synchronized(this) {
                //again check if instance is not instantiated already. If still not, we gonna return new instance
                // instance = it means we wnat to set the instance property = database instance
                /** also expressions does some additional processing on the object it was invoked. Unlike let,
                 * it returns the original object instead of any new return data. Hence the return data has always the same type.
                 */

                instance ?: FakeDatabase().also { instance = it}
            }
    }
}