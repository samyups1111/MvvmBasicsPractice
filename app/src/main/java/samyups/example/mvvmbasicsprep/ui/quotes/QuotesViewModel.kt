package samyups.example.mvvmbasicsprep.ui.quotes

import androidx.lifecycle.ViewModel
import samyups.example.mvvmbasicsprep.data.Quote
import samyups.example.mvvmbasicsprep.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuote()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}

/** we need a viewmodel factory and viewmodel provider to create the viewmodel. we don't want to create a new instance
        of viewmodel because that will erase the data (on orientation). viewmodelprovider will check if viewmodel is
 aleady present? yes? were going to pass it back to the activity so the data in the activity is reset. if not, we're
 gonna create a new instance. viewmodel provider requires a factory. */