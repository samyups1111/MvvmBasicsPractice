package samyups.example.mvvmbasicsprep.utilities

import samyups.example.mvvmbasicsprep.data.FakeDatabase
import samyups.example.mvvmbasicsprep.data.QuoteRepository
import samyups.example.mvvmbasicsprep.ui.quotes.QuotesViewModelFactory


// All the dependencies are created here
object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}