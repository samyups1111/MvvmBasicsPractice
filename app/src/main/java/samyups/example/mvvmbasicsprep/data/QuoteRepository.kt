package samyups.example.mvvmbasicsprep.data

// we are not creating an instance of quotesDao, instead we are passing it in the constructor
// we pass a mock version of that access-object ot the repository. When we call "getquote" on that mock object,
// it'll return a fake list of quotes which are gonna be always the same for testing. This is the core idea
// of dependency injection whihc is to make things completely modular and independent of each other. Dont create
// dependency right inside the class, rather make them be passed in the constructor of the class.
class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuote() = quoteDao.getQuotes()

    companion object {
        // volatile means that rights to this property are immediately visible to other threads
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
        // left ?: right. ?: means that if the left is NOT null then it returns it, otherwise it returns right
            // "sync(this) means 2 threads cannot be executing at the same time
            instance ?: synchronized(this) {
                //again check if instance is not instantiated already. If still not, we gonna return new instance
                // instance = it means we wnat to set the instance property = database instance
                /** also expressions does some additional processing on the object it was invoked. Unlike let,
                 * it returns the original object instead of any new return data. Hence the return data has always the same type.
                 */

                instance ?: QuoteRepository(quoteDao).also { instance = it}
            }
    }
}