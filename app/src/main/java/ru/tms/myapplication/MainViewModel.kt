package ru.tms.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import ru.tms.myapplication.data.IInteractor
import ru.tms.myapplication.data.Source
import ru.tms.myapplication.data.SourceResponse
import ru.tms.myapplication.data.model.StubUtil
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: IInteractor,
    stubUtil: StubUtil
) : ViewModel() {

    private val _sources = MutableLiveData<List<Source>>()
    val source: LiveData<List<Source>> get() = _sources

    init {
        loadSources()
        stubUtil.print()
    }

    private var sourcesJob: Job? = null

    fun onAttach() {
        sourcesJob = viewModelScope.launch {
            delay(7000)
            _sources.value = interactor.getSource().sources
        }
    }

    fun onDetach() {
        sourcesJob?.cancel()
    }

    private fun loadSources() {
        viewModelScope.launch {

            val sources = async {
                interactor.getSource().sources
            }

            val internalSources = async {
                interactor.getInternalSources()
            }

            val externalSources: List<Source> = sources.await()
            val internalSourcess: SourceResponse = internalSources.await()

            externalSources + internalSourcess.sources
        }
    }

    private fun cancelLoading() {
        sourcesJob?.cancel()
    }
}