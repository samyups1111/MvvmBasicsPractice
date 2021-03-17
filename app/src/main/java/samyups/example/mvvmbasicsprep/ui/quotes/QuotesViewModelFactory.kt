package samyups.example.mvvmbasicsprep.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import samyups.example.mvvmbasicsprep.data.QuoteRepository

class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
            return QuotesViewModel(quoteRepository) as T // suppress unchecked cast for fun create
        }
}