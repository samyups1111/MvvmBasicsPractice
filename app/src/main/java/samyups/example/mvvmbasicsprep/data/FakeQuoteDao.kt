package samyups.example.mvvmbasicsprep.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {

    // The actual data
    private val quoteList = mutableListOf<Quote>()
    // a visual copy of the data ( to be seen in the UI)
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        // We are going to set the value of our quotes live data
        // this is so we can immediately connect the now-empty quotes list to the mutable live data that can be observed
        // from our classes.
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    // we don't want to be able to change the value of the live data outside of this DAO. Just observe
    fun getQuotes() = quotes as LiveData<List<Quote>>
}

/** Use LiveData when you don't want to modify it because the methods like setValue() & postValue() are not public .
 * Live data takes care itself by calling them internally. Where as in MutableLiveData setValue() postValue() are
 * exposed ie public. You can change set values by calling these methods.
 */
